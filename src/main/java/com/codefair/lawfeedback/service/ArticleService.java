package com.codefair.lawfeedback.service;

import com.codefair.lawfeedback.controller.article.ArticleListItemTO;
import com.codefair.lawfeedback.controller.article.ArticleViewTO;
import com.codefair.lawfeedback.controller.article.RelatedJobTO;
import com.codefair.lawfeedback.controller.article.WriteArticleTO;
import com.codefair.lawfeedback.domain.Article;
import com.codefair.lawfeedback.domain.RelatedJob;
import com.codefair.lawfeedback.repository.ArticleRepository;
import com.codefair.lawfeedback.repository.RelatedJobRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService {

    private static final Logger logger = LoggerFactory.getLogger("ArticleService");
    private final ArticleRepository articleRepository;
    private final RelatedJobRepository relatedJobRepository;

    public List<ArticleListItemTO> getArticleList() {
        return articleRepository.findAllByOrderByIdDesc()
                .stream().map(ArticleListItemTO::new).collect(Collectors.toList());
    }

    @Transactional
    public void writeArticle(WriteArticleTO writeArticleTO) {
        Article article = Article.builder()
                .userId(writeArticleTO.getUserId())
                .title(writeArticleTO.getTitle())
                .content(writeArticleTO.getContent()).build();
        article = articleRepository.save(article);
        LoggerFactory.getLogger("ArticleService").info("" + article.getId());

        for (Long jobId : writeArticleTO.getJobIdList()) {
            RelatedJob relatedJob = new RelatedJob(jobId, article.getId());
            relatedJobRepository.save(relatedJob);
        }
    }

    @Transactional
    public ArticleViewTO getArticleWithAllInfo(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        List<RelatedJob> relatedJobList = relatedJobRepository.getAllByArticleId(articleId);

        List<RelatedJobTO> relatedJobTOList = relatedJobList.stream().map(relatedJob -> new RelatedJobTO(relatedJob, relatedJob.getJob().getName())).collect(Collectors.toList());

        return new ArticleViewTO(article, relatedJobTOList);
    }
}

package com.codefair.lawfeedback.service;

import com.codefair.lawfeedback.controller.article.ArticleListItemTO;
import com.codefair.lawfeedback.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService {

    private static final Logger logger = LoggerFactory.getLogger("ArticleService");
    private final ArticleRepository articleRepository;

    public List<ArticleListItemTO> getArticleList() {
        return articleRepository.findAllByOrderByIdDesc()
                .stream().map(ArticleListItemTO::new).collect(Collectors.toList());
    }
}

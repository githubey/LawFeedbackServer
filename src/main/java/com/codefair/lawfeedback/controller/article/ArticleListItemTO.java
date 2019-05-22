package com.codefair.lawfeedback.controller.article;

import com.codefair.lawfeedback.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class ArticleListItemTO {

    private Long id;
    private Long userId;
    private String title;
    private String summary;
    private Set<Long> jobIdSet;

    public ArticleListItemTO(Article article) {
        id = article.getId();
        userId = article.getUserId();
        title = article.getTitle();
        summary = article.getContent();
        if (summary != null && summary.length() > 600) {
            summary = summary.substring(0, 600) + "...";
        }
        jobIdSet = article.getRelatedJobList().stream().map(relatedJob -> relatedJob.getJobId()).collect(Collectors.toSet());
    }
}

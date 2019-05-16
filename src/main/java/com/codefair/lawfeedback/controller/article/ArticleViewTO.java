package com.codefair.lawfeedback.controller.article;

import com.codefair.lawfeedback.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ArticleViewTO {

    private Long id;
    private Long user_id;
    private String title;
    private String content;
    private Integer good_ex;
    private Integer bad_ex;
    private List<RelatedJobTO> relatedJobTOList;

    public ArticleViewTO(Article article, List<RelatedJobTO> relatedJobTOList) {
        this.id = article.getId();
        this.user_id = article.getUserId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.good_ex = article.getGoodEx();
        this.bad_ex = article.getBadEx();
        this.relatedJobTOList = relatedJobTOList;
    }
}

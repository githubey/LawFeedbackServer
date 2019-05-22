package com.codefair.lawfeedback.controller.article;

import com.codefair.lawfeedback.domain.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReplyListItemTO {

    private Long id;
    private Long articleId;
    private Long userId;
    private String content;
    private Integer good;
    private Integer bad;
    private String jobName;

    public ReplyListItemTO(Reply reply, String jobName) {
        this.id = reply.getId();
        this.articleId = reply.getArticleId();
        this.userId = reply.getUserId();
        this.content = reply.getReplyContent();
        this.good = reply.getGood();
        this.bad = reply.getBad();
        this.jobName = jobName;
    }
}

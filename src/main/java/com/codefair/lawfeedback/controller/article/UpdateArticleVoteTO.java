package com.codefair.lawfeedback.controller.article;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateArticleVoteTO {

    private Long jobId;
    private Integer good;
    private Integer bad;
}

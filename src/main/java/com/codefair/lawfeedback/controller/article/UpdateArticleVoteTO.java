package com.codefair.lawfeedback.controller.article;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateArticleVoteTO {

    private Long jobId;
    private Long good;
    private Long bad;
}

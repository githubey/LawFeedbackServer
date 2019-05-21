package com.codefair.lawfeedback.controller.reply;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WriteReplyTO {

    private Long articleId;
    private Long userId;
    private String replyContent;
}

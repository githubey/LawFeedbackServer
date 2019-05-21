package com.codefair.lawfeedback.controller.article;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WriteReplyTO {

    private Long userId;
    private String replyContent;
}

package com.codefair.lawfeedback.controller.article;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class WriteArticleTO {

    private Long userId;
    private String title;
    private String content;
    private List<Long> jobIdList;
}

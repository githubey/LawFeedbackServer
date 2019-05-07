package com.codefair.lawfeedback.controller.article;

import com.codefair.lawfeedback.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleListItemTO> getArticleList() {
        return articleService.getArticleList();
    }
}

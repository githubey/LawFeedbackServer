package com.codefair.lawfeedback.controller.article;

import com.codefair.lawfeedback.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String writeArticle(@RequestBody WriteArticleTO writeArticleTO) {
        articleService.writeArticle(writeArticleTO);
        return "{}";
    }

    @GetMapping(value = "/{id}")
    public ArticleViewTO getArticleWithAllInfo(@PathVariable String id) {
        return null;
    }
}

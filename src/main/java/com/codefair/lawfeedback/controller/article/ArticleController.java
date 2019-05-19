package com.codefair.lawfeedback.controller.article;

import com.codefair.lawfeedback.service.ArticleService;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
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
    public ArticleViewTO getArticleWithAllInfo(@PathVariable Long id) {
        return articleService.getArticleWithAllInfo(id);
    }

    @PutMapping(value = "/{id}")
    public ArticleViewTO updateArticleWithVote(@PathVariable Long id, @RequestBody UpdateArticleVoteTO updateArticleVoteTO) {
        LoggerFactory.getLogger("ArticleController").info(id + " " + updateArticleVoteTO.getJobId() + " " + updateArticleVoteTO.getGood());
        return new ArticleViewTO();
    }
}

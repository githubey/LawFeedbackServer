package com.codefair.lawfeedback.controller.article;

import com.codefair.lawfeedback.service.ArticleService;
import com.codefair.lawfeedback.service.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final ReplyService replyService;


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
        return articleService.updateArticleWithVote(id, updateArticleVoteTO);
    }

    @PostMapping(value = "/{id}/comments")
    private String writeReply(@PathVariable Long id, @RequestBody WriteReplyTO writeReplyTO) {
        replyService.writeReply(id, writeReplyTO);
        return "{}";
    }

    @GetMapping(value = "/{id}/comments")
    public List<ReplyListItemTO> getReplyList(@PathVariable Long id, @RequestParam Boolean isRelatedView) {
        return replyService.getReplyList(id, isRelatedView);
    }
}

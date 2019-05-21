package com.codefair.lawfeedback.controller.reply;

import com.codefair.lawfeedback.service.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/comments")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    private String writeReply(@RequestBody WriteReplyTO writeReplyTO) {
        replyService.writeReply(writeReplyTO);
        return "{}";
    }
}

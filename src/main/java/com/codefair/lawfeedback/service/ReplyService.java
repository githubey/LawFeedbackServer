package com.codefair.lawfeedback.service;

import com.codefair.lawfeedback.controller.reply.WriteReplyTO;
import com.codefair.lawfeedback.domain.Reply;
import com.codefair.lawfeedback.repository.ReplyRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReplyService {

    private static final Logger logger = LoggerFactory.getLogger("ReplyService");
    private final ReplyRepository replyRepository;

    public void writeReply(WriteReplyTO writeReplyTO) {
        Reply reply = Reply.builder()
                .articleId(writeReplyTO.getArticleId())
                .userId(writeReplyTO.getUserId())
                .replyContent(writeReplyTO.getReplyContent()).build();
        replyRepository.save(reply);
    }
}

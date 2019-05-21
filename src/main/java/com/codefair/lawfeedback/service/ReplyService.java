package com.codefair.lawfeedback.service;

import com.codefair.lawfeedback.controller.article.ReplyListItemTO;
import com.codefair.lawfeedback.controller.article.WriteReplyTO;
import com.codefair.lawfeedback.domain.Reply;
import com.codefair.lawfeedback.repository.ReplyRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ReplyService {

    private static final Logger logger = LoggerFactory.getLogger("ReplyService");
    private final ReplyRepository replyRepository;

    public void writeReply(Long articleId, WriteReplyTO writeReplyTO) {
        Reply reply = Reply.builder()
                .articleId(articleId)
                .userId(writeReplyTO.getUserId())
                .replyContent(writeReplyTO.getReplyContent()).build();
        replyRepository.save(reply);
    }

    public List<ReplyListItemTO> getReplyList(Long articleId, Boolean isRelatedView) {
        logger.info("getReplyList");
        List<Reply> replyList = replyRepository.findAllByArticleIdOrderByIdDesc(articleId);
        Stream<Reply> replyStream;
        if (isRelatedView) {
            replyStream = replyList.stream()
                    .filter(reply -> reply.getArticle().getRelatedJobList().stream()
                            .map(relatedJob -> relatedJob.getJobId()).collect(Collectors.toSet())
                            .contains(reply.getUser().getJobId()));
        } else {
            replyStream = replyList.stream()
                    .filter(reply -> !reply.getArticle().getRelatedJobList().stream()
                            .map(relatedJob -> relatedJob.getJobId()).collect(Collectors.toSet())
                            .contains(reply.getUser().getJobId()));

        }
        return replyStream
                .map(reply -> new ReplyListItemTO(reply, reply.getUser().getJob().getName()))
                .collect(Collectors.toList());
    }
}

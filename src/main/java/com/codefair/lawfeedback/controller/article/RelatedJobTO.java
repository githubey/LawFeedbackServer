package com.codefair.lawfeedback.controller.article;

import com.codefair.lawfeedback.domain.RelatedJob;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RelatedJobTO {

    private Long id;
    private Long jobId;
    private String jobName;
    private Long articleId;
    private Integer good;
    private Integer bad;

    public RelatedJobTO(RelatedJob relatedJob, String jobName) {
        this.id = relatedJob.getId();
        this.jobId = relatedJob.getJobId();
        this.jobName = jobName;
        this.articleId = relatedJob.getArticleId();
        this.good = relatedJob.getGood();
        this.bad = relatedJob.getBad();
    }
}

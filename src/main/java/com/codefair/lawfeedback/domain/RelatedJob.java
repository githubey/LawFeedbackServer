package com.codefair.lawfeedback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class RelatedJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_id", columnDefinition = "bigint", nullable = false)
    private Long jobId;

    @Column(name = "article_id", columnDefinition = "bigint", nullable = false)
    private Long articleId;

    @Column(columnDefinition = "int default 0", nullable = false, insertable = false)
    private Integer good;

    @Column(columnDefinition = "int default 0", nullable = false, insertable = false)
    private Integer bad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "job_id", updatable = false, insertable = false)
    private Job job;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "article_id", updatable = false, insertable = false)
    private Article article;

    public RelatedJob(Long jobId, Long articleId) {
        this.jobId = jobId;
        this.articleId = articleId;
    }
}

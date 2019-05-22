package com.codefair.lawfeedback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", columnDefinition = "bigint", nullable = false)
    private Long userId;

    @Column(name = "article_id", columnDefinition = "bigint", nullable = false)
    private Long articleId;

    @Column(columnDefinition = "text")
    private String replyContent;

    @Column(columnDefinition = "int default 0", nullable = false, insertable = false)
    private Integer good;

    @Column(columnDefinition = "int default 0", nullable = false, insertable = false)
    private Integer bad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "article_id", updatable = false, insertable = false)
    private Article article;

    @Builder
    public Reply(Long userId, Long articleId, String replyContent, Integer good, Integer bad) {
        this.userId = userId;
        this.articleId = articleId;
        this.replyContent = replyContent;
        this.good = good;
        this.bad = bad;
    }
}

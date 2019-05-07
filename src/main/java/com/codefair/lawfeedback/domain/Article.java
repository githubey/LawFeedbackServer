package com.codefair.lawfeedback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id", columnDefinition = "bigint", nullable = false)
    private Long userId;

    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @Column(columnDefinition = "int default 0", nullable = false, insertable = false)
    private Integer goodEx = 0;

    @Column(columnDefinition = "int default 0", nullable = false, insertable = false)
    private Integer badEx;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @Builder
    public Article(Long id, Long userId, String title, String content, Integer goodEx, Integer badEx) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.goodEx = goodEx;
        this.badEx = badEx;
    }
}

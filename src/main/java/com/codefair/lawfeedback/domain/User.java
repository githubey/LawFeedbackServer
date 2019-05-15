package com.codefair.lawfeedback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, columnDefinition = "varchar(50)", nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(20)")
    private String name;

    @Column(columnDefinition = "varchar(50)")
    private String nickname;

    @Column(name = "job_id", columnDefinition = "bigint", nullable = false)
    private Long jobId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "job_id", updatable = false, insertable = false)
    private Job job;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Article> articleList = new ArrayList<>();

    @Builder
    public User(Long id, String email, String password, String name, String nickname, Long jobId, Job job) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.jobId = jobId;
        this.job = job;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

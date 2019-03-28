package com.codefair.lawfeedback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "job")
    private List<User> userList = new ArrayList<>();

}

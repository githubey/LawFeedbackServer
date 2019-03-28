package com.codefair.lawfeedback.controller.job;

import com.codefair.lawfeedback.domain.Job;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class JobTO {

    private Long id;
    private String name;

    public JobTO(Job job) {
        id = job.getId();
        name = job.getName();
    }
}
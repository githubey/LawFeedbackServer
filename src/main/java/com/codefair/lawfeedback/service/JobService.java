package com.codefair.lawfeedback.service;

import com.codefair.lawfeedback.controller.job.JobTO;
import com.codefair.lawfeedback.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public List<JobTO> getJobList() {
        return jobRepository
                .findJobsByNameIsNotNull()
                .stream().map(JobTO::new).collect(toList());
    }
}
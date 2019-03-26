package com.codefair.lawfeedback.controller.job;

import com.codefair.lawfeedback.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/jobs")
public class JobController {

    private final JobService jobService;

    @GetMapping
    public List<JobTO> getJobList() {
        return jobService.getJobList();
    }
}
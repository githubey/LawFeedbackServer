package com.codefair.lawfeedback.repository;

import com.codefair.lawfeedback.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findJobsByNameIsNotNull();
}


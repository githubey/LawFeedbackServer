package com.codefair.lawfeedback.repository;

import com.codefair.lawfeedback.domain.RelatedJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelatedJobRepository extends JpaRepository<RelatedJob, Long> {

    List<RelatedJob> getAllByArticleId(Long articleId);
}

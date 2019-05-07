package com.codefair.lawfeedback.repository;

import com.codefair.lawfeedback.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

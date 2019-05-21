package com.codefair.lawfeedback.repository;

import com.codefair.lawfeedback.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}

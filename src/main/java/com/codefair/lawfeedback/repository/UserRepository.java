package com.codefair.lawfeedback.repository;

import com.codefair.lawfeedback.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}


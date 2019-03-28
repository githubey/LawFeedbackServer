package com.codefair.lawfeedback.service;

import com.codefair.lawfeedback.controller.login.LoginTO;
import com.codefair.lawfeedback.domain.User;
import com.codefair.lawfeedback.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long login(LoginTO loginTO) {
        Long userId = 0L;
        User user = userRepository.findByEmail(loginTO.getEmail());
        if (user != null && bCryptPasswordEncoder.matches(loginTO.getPassword(), user.getPassword())) {
            userId = user.getId();
            LoggerFactory.getLogger("local").info("####LoginService(login) : Success " + userId);
        }
        return userId;
    }
}

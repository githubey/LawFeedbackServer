package com.codefair.lawfeedback.service;

import com.codefair.lawfeedback.controller.user.UserLawMakerTO;
import com.codefair.lawfeedback.controller.user.UserNormalTO;
import com.codefair.lawfeedback.domain.User;
import com.codefair.lawfeedback.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger("local");
    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void createLawMakerUser(UserLawMakerTO userLawMakerTO) {
        logger.info("####UserService : createLawMakerUser");
        User user = userLawMakerTO.toEntity();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void createNormalUser(UserNormalTO userNormalTO) {
        logger.info("####UserService : createNormalUser");
        User user = userNormalTO.toEntity();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}

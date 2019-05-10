package com.codefair.lawfeedback.service;

import com.codefair.lawfeedback.controller.login.LoginResponseTO;
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

    public LoginResponseTO login(LoginTO loginTO) {
        LoginResponseTO loginResponseTO;
        User user = userRepository.findByEmail(loginTO.getEmail());
        if (user != null && bCryptPasswordEncoder.matches(loginTO.getPassword(), user.getPassword())) {
            loginResponseTO = new LoginResponseTO(user.getId(), user.getName(), "Success");
            LoggerFactory.getLogger("local").info("####LoginService(login) : Success " + user.getId());
        } else {
            loginResponseTO = new LoginResponseTO(0L, "", "Authentification Error");
            LoggerFactory.getLogger("local").info("####LoginService(login) : Fail ");
        }
        return loginResponseTO;
    }
}

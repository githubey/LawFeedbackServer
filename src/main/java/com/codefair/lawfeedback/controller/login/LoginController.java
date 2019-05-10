package com.codefair.lawfeedback.controller.login;

import com.codefair.lawfeedback.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponseTO> login(@RequestBody LoginTO loginTO) {
        LoginResponseTO loginResponseTO = loginService.login(loginTO);
        if (loginResponseTO.getName() == null) {
            loginResponseTO.setName("");
        }
        ResponseEntity<LoginResponseTO> responseEntity;
        if (loginResponseTO.getUserId() != 0L) {
            responseEntity = new ResponseEntity<>(loginResponseTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(loginResponseTO, HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }
}
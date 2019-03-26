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
        Long userId = loginService.login(loginTO);
        ResponseEntity<LoginResponseTO> responseEntity;
        if (userId != 0L) {
            responseEntity = new ResponseEntity<>(new LoginResponseTO(userId, "Success"), HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(new LoginResponseTO(userId, "Authentification Error"), HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }
}
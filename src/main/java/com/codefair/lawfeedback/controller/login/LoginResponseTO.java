package com.codefair.lawfeedback.controller.login;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginResponseTO {

    private Long userId;
    private String message;

    public LoginResponseTO(Long userId, String message) {
        this.userId = userId;
        this.message = message;
    }
}
package com.codefair.lawfeedback.controller.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginResponseTO {

    private Long userId;
    private String name;
    private String message;

    public LoginResponseTO(Long userId, String name, String message) {
        this.userId = userId;
        this.name = name;
        this.message = message;
    }
}
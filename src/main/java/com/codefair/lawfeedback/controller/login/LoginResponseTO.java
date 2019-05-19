package com.codefair.lawfeedback.controller.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginResponseTO {

    private Long userId;
    private Long jobId;
    private String name;
    private String message;

    public LoginResponseTO(Long userId, Long jobId, String name, String message) {
        this.userId = userId;
        this.jobId = jobId;
        this.name = name;
        this.message = message;
    }
}
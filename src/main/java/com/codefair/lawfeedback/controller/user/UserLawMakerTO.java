package com.codefair.lawfeedback.controller.user;

import com.codefair.lawfeedback.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserLawMakerTO {

    private String email;
    private String password;
    private String name;
    private Long jobId;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .jobId(jobId)
                .build();
    }
}

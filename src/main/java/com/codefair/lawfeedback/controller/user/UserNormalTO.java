package com.codefair.lawfeedback.controller.user;

import com.codefair.lawfeedback.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserNormalTO {

    private String email;
    private String password;
    private String nickname;
    private Long jobId;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .jobId(jobId)
                .build();
    }
}

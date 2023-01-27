package com.HDH.kiosk.dto.admin;

import com.HDH.kiosk.domain.User;
import lombok.Data;

@Data
public class LoginReqDto {
    private String username;
    private String password;

    public User toUserEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}

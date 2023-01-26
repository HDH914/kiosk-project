package com.HDH.kiosk.dto.admin;

import com.HDH.kiosk.domain.User;
import lombok.Data;

@Data
public class LoginReqDto {
    private String adminId;
    private String password;

    public User toUserEntity(){
        return User.builder()
                .admin_id(adminId)
                .password(password)
                .build();
    }
}

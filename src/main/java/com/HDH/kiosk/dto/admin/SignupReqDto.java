package com.HDH.kiosk.dto.admin;

import com.HDH.kiosk.domain.User;
import lombok.Data;

@Data
public class SignupReqDto {
    private String adminId;
    private String password;
    private String storeNumber;

    public User toUserEntity() {
        return User.builder()
                .admin_id(adminId)
                .password(password)
                .store_number(storeNumber)
                .build();
    }
}

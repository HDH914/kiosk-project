package com.HDH.kiosk.dto.admin;

import com.HDH.kiosk.domain.User2;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

@Data
public class SignupReqDto {

    private String adminId;
    private String password;
    private int storeNumber;

    public User2 toUserEntity() {
        return User2.builder()
                .admin_id(adminId)
                .password(password)
                .store_number(storeNumber)
                .build();
    }
}

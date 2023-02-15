package com.HDH.kiosk.dto.admin;

import com.HDH.kiosk.domain.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class SignupReqDto {
    @NotBlank(message = "아이디를 입력해주세요.")
    private String username;
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]{8,16}$",
            message = "숫자, 영문, 특수기호를 하나 이상 포함하여 8자 이상 16자 이하로 작성해야합니다.")
    private String password;
    @NotBlank(message = "사업장 번호를 입력해주세요.")
    private String storeNumber;

    //    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]{8,16}$",
//            message = "숫자, 영문, 특수기호를 하나 이상 포함하여 8자 이상 16자 이하로 작성해야합니다.")

    public User toUserEntity() {
        return User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .store_number(storeNumber)
                .build();
    }
}

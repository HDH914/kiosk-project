package com.HDH.kiosk.service.admin;

import com.HDH.kiosk.dto.admin.SignupReqDto;

public interface AdminService {
    // 회원 가입
    public void signup(SignupReqDto signupReqDto) throws Exception;
}

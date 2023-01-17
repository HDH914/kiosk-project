package com.HDH.kiosk.service.admin;

import com.HDH.kiosk.dto.admin.SignupReqDto;
import com.HDH.kiosk.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    // 회원가입
    @Override
    public boolean signup(SignupReqDto signupReqDto) throws Exception {
        return adminRepository.save(signupReqDto.toUserEntity()) != 0;
    }


}

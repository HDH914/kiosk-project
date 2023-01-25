package com.HDH.kiosk.service.admin;

import com.HDH.kiosk.dto.admin.SignupReqDto;
import com.HDH.kiosk.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    // 회원가입
    @Override
    public void signup(SignupReqDto signupReqDto) throws Exception {
        adminRepository.save(signupReqDto.toUserEntity());
    }
}

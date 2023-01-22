package com.HDH.kiosk.service.admin;

import com.HDH.kiosk.dto.admin.SignupReqDto;
import com.HDH.kiosk.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    // 회원가입
    @Override
    public boolean signup(SignupReqDto signupReqDto) throws Exception {
        adminRepository.save(signupReqDto.toUserEntity());
        log.info("관리자 ID: " + signupReqDto.getAdminId());
        log.info("관리자 Password: " + signupReqDto.getPassword());
        log.info("관리자 StoreNum: " + signupReqDto.getStoreNumber());
        return true;
    }




//    @Override
//    public boolean testAjax(TestDto testDto) throws Exception {
//        return adminRepository.testAjax(testDto.testAjax()) != 0;
//    }


}

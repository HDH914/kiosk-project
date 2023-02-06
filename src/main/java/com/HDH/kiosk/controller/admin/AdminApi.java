package com.HDH.kiosk.controller.admin;

import com.HDH.kiosk.dto.CMRespDto;
import com.HDH.kiosk.dto.admin.LoginReqDto;
import com.HDH.kiosk.dto.admin.SignupReqDto;
import com.HDH.kiosk.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class AdminApi {
    private final AdminService adminService;

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupReqDto signupReqDto) throws Exception {
        adminService.signup(signupReqDto);
        return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 완료", signupReqDto));
    }


    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(LoginReqDto loginReqDto){
        return ResponseEntity.ok().body(new CMRespDto<>(1, "로그인 완료", true));
    }
    }



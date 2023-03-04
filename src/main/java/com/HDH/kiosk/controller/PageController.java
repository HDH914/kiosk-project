package com.HDH.kiosk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PageController {

    /////////////////////////////////////  화면  //////////////////////////////////////////////
    // 대기 화면
    @GetMapping({"/", "/index"})
    public String idleScreen(){
        return "main/idleScreen";
    }

    // 메인 화면
    @GetMapping("/main")
    public String main(){
        return "main/main";
        }

    /////////////////////////////////////  계정  //////////////////////////////////////////////

    //로그인 페이지
    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String signup(){
        return "admin/signup";
    }



    /////////////////////////////////////  관리자  //////////////////////////////////////////////
    // 관리자 페이지
    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }
    





    /////////////////////////////////////

    // 메뉴 추가 페이지
    @GetMapping("/admin/menuDetail")
    public String menu(){
        return "menu/menuDetail";
    }

    // 메뉴 수정 페이지
    @GetMapping("/admin/modification/{id}")
    public String modificationMen(@PathVariable int id){
        return "menu/modification";
    }


    ///////////////////////////////////////////////////////////////////////////
    // 결제 페이지
    @GetMapping("/payment/option")
    public String payment(){
        return "payment/paymentOption";
    }

}

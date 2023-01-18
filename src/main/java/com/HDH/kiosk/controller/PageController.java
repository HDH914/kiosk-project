package com.HDH.kiosk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PageController {

    /////////////////////////////////////  화면  //////////////////////////////////////////////
    // 대기 화면
    @GetMapping({"/", "/index"})
    public String idleScreen(){
        return "idleScreen";
    }

    // 메인 화면
    @GetMapping("/main")
    public String main(){
        return "main";
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
    @GetMapping("/admin/menu")
    public String menu(){
        return "admin/menu";
    }




    /////////////////////////////////////
    @GetMapping("/testajax")
    public String testajax(){
        return "/ajaxTest";
    }







}

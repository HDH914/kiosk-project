package com.HDH.kiosk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PageController {

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
}

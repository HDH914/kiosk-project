package com.HDH.kiosk.handler;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage;

        if(exception.getClass() == UsernameNotFoundException.class ) {
            errorMessage = "계정이 존재하지 않습니다.";
            //response.sendRedirect("/account/login");  //메소드를 실행하면, HTTP 응답 헤더에 어떤 페이지로 이동하라는 값을 추가한다.
        } else if(exception.getClass() == BadCredentialsException.class){
            errorMessage = "아이디 또는 비밀번호가 일치하지 않습니다.";
        }else if(exception.getClass() == AccountExpiredException.class){
            errorMessage = "계정이 만료되었습니다.";
        }else if(exception.getClass() == DisabledException.class){
            errorMessage = "계정이 비활성화 되었습니다.";
        }else if(exception.getClass() == LockedException.class){
            errorMessage = "계정이 잠금되었습니다..";
        }else{
            errorMessage ="알 수 없는 오류로 로그인 요청을 처리할 수 없습니다. 관리자에게 문의하세요.";
        }
        errorMessage = URLEncoder.encode(errorMessage, "UTF-8");
        setDefaultFailureUrl("/login?error=true&exception="+errorMessage);
        super.onAuthenticationFailure(request, response, exception);
    }
}

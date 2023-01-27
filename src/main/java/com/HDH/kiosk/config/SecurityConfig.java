package com.HDH.kiosk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity    //기존의 WebSecurityConfigurerAdapter 클래스를 해당 SecurityConfig로 대체하겠다.
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Spring Security에 정의되어 있는 Interface로 이 핸들러를 구현해주고 SecurityConfig에서 설정을 해주면 자동으로 핸들러로 등록이 된다.
//    private final AuthenticationFailureHandler authenticationFailureHandler;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }  // 비밀번호 암호화

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        // AuthenticationManager: 그냥 username, password가 아닌 토큰을 받아서 객체를 만듦.
        return super.authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests()

                // 접근 권한 관련
                .antMatchers("/**")//지정한 주소를 가지고 권한을 줄건지 정함.
                .permitAll()


                // 로그인 관련
                .and()
                .formLogin()
                .loginPage("/login")                 // GET 요청
//                .usernameParameter()         필드명을 변경하는것.
                .loginProcessingUrl("/admin/login")        // 로그인 로직(PrincipalDetailsService) POST 요청
                .successForwardUrl("/admin")    // 로그인 성공시 url
                .failureForwardUrl("/login")
//                .failureHandler(new AuthFailureHandler())   //실패핸들러

                // 로그아웃 관련
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)  // 인증정보를 지우고 세션을 무효화


//                // 세션 관련
                .and()
                .sessionManagement()
                .maximumSessions(-1)  //세션 최대 허용수. -1은 무제한
                .maxSessionsPreventsLogin(true);  // true: 중복로그인 막음. false: 이전 로그인의 세션을 해제
    }

}


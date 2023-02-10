package com.HDH.kiosk.service.auth;

import com.HDH.kiosk.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
@Getter
public class PrincipalDetails implements UserDetails {

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(()->user.getUsername());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {  // 계정 만료 여부(사용 기간 만료)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {   // 계정 자김 여부(관리자가 강제로 잠금)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {  // 비밀번호 만료 여부(몇회 이상 틀렸을 때)
        return true;
    }

    @Override
    public boolean isEnabled() {    // 계정 활성화 여부(휴면 계정)
        return true;
    }
}

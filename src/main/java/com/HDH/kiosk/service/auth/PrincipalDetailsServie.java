package com.HDH.kiosk.service.auth;

import com.HDH.kiosk.domain.User;
import com.HDH.kiosk.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsServie implements UserDetailsService {
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = adminRepository.findUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("존재하지 않는 아이디 입니다.");  // 유저네임이 없을때
        }

        return new PrincipalDetails(user);
    }
}

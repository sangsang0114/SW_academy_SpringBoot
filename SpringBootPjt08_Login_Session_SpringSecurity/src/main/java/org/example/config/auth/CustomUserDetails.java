package org.example.config.auth;

import lombok.AllArgsConstructor;
import org.example.domain.Mem;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private Mem mem;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add((GrantedAuthority) () -> mem.getRole().name());
        return collect;
    }

    @Override
    public String getPassword() {
        return mem.getMem_pw();
    }

    @Override
    public String getUsername() {
        return mem.getMem_id();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 사이트 내에서 1년동안 로그인을 안하면 휴면계정을 전화할 수 있다.
        // loginDate를 기록해두었다가 1년 동안 로그인을 안하면 이 값을 false로 return 하면 된다.
        return true;
    }
}

/*
위에서 시큐리티가 로그인 진행을 완료하면 시큐리티 session을 만들어서 ContextHolder에 저장합니다.
session은 타입이 정해져 있는데, Authentication 타입 객체여야 합니다.
그리고 Authentication 안에는 User 정보가 있고 이 또한 UserDetails 타입 객체여야합니다.
 */
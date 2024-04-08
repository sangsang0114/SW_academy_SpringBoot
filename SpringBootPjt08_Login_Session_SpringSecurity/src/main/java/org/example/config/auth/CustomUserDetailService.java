package org.example.config.auth;

import org.example.domain.Mem;
import org.example.mapper.MemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    MemMapper memMapper;

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {

        Mem mem = memMapper.findById(userID);
        System.out.println(mem.toString());

        if (mem == null) {
            return null;
        } else {
            return User.builder().username(mem.getMem_id()).password(mem.getMem_pw()).roles(mem.getRole().name()).build();
        }
    }
}

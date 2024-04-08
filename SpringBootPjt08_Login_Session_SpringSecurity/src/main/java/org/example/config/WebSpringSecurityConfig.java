package org.example.config;

import lombok.RequiredArgsConstructor;
import org.example.config.auth.CustomUserDetailService;
import org.example.domain.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class WebSpringSecurityConfig {
    private final CustomUserDetailService customUserDetailService;

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeRequestes) -> authorizeRequestes
                        .requestMatchers("/", "/login/**").permitAll()  //permitAll() 설정한 요청은 로그인 없이 접근이 가능
                        .requestMatchers("/test").hasRole(Role.USER.name())  // USER 권한이 있으면 접근가능
                        .requestMatchers("/test2").hasRole(Role.ADMIN.name()) // ADMIN 권한이 있으면 접근가능
                        .anyRequest().authenticated()) // 그외 페이지는 로그인만 하면 접근가능
                .formLogin((formLogin) -> formLogin
//                        .loginPage("/login/login")   //custom login html 를 사용할 때
                        .usernameParameter("mem_id")
                        .passwordParameter("mem_pw")
                        .loginProcessingUrl("/auth/login") // POST /auth/login 는 로그인 요청 url
                        .defaultSuccessUrl("/user", true)) // 로그인 성공 시 /user로 포워드.
                .logout((logoutConfig) ->
                        logoutConfig.logoutSuccessUrl("/")
                )
                .userDetailsService(customUserDetailService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    // 패스워드 암호화
}
package com.agencyplatform.springboot.config.auth;

import com.agencyplatform.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // h2-console 화면을 사용하기 위해 해당 옵션들을 disable 설정
                .csrf().disable().headers().frameOptions().disable()
                .and()
                // URL별 권한관리 시작점
                .authorizeRequests()
                // 지정된 URL에 대해 permitAll 옵션 적용
                .antMatchers("/","/hello","/register", "/css/**", "/img/**",
                        "/js/**","/scss/**","/vendor/**","/h2-console/**").permitAll()
                // POST 메소드 이면서 /api/v1/** 수조를 가진 API는 USER  권한을 가진 사람만 가능
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                // 나머지 URL 권한설정
                .anyRequest().authenticated()
                .and()
                // 로그아웃 성공시 지정된 URL로 이동
                .logout().logoutSuccessUrl("/")
                .and()
                // oauth2Login 시작점
                .oauth2Login()
                    // oauth2 로그인 성공 후 사용자 정보를 가져올 때 설정 담당
                    .userInfoEndpoint()
                    // oauth2 로그인 성공 시 후속 조치를 진행항 UserService 구현체 등록
                    .userService(customOAuth2UserService);

    }
}

package com.withplant.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity // 스프링 시큐리티 사용을 위한 선언
@RequiredArgsConstructor
public class SecutiryConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin(); //x-frame-options 동일 출처일경우만

        http.authorizeRequests()
                .mvcMatchers("/", "/login", "/sign-up","/h2-console/*", "/h2-console").permitAll() // 전체 접근 허용
                .anyRequest().authenticated();

        http.formLogin() // 커스텀한 로그인페이지 URL. 설정하지 않으면 시큐리티기본 로그인페이지가 보임
                .loginPage("/index").loginProcessingUrl("/login").permitAll(); // GET, POST 모두 동일한 경로를 사용

        http.logout().logoutSuccessUrl("/");
       // http.csrf().disable(); //CSRF Token 비활성화

    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/assets/**", "/images/**", "/node_modules/**");
    }
}

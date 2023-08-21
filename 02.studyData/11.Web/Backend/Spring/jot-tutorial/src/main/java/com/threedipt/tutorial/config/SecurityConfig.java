package com.threedipt.tutorial.config;

import com.threedipt.tutorial.jwt.JwtAccessDeniedHandler;
import com.threedipt.tutorial.jwt.JwtAuthenticationEntryPoint;
import com.threedipt.tutorial.jwt.JwtSecurityConfig;
import com.threedipt.tutorial.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // @PreAuthorize 어노테이션을 메소드단위로 추가하기 위해서 사용
public class SecurityConfig {
    @Autowired
    private  TokenProvider tokenProvider;
    @Autowired
    private  JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private  JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .apply(new JwtSecurityConfig(tokenProvider))
                .and()
                .authorizeHttpRequests().requestMatchers(
                        new AntPathRequestMatcher("/**")).permitAll()
                .and()
                .csrf().ignoringRequestMatchers(
                        new AntPathRequestMatcher("/h2-console/**"))
                // 화면 깨짐 문제 해결 로직
                .and()
                .headers()
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        // 헤더값 변경ß
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
        ;
        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .antMatchers(
                        "h2-console/**"
                        ,"/favicon.ico");
    }
}

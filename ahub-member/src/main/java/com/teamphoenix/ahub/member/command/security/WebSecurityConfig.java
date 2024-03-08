package com.teamphoenix.ahub.member.command.security;

import com.teamphoenix.ahub.member.command.service.MemberService;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    MemberService memberService;
    Environment environment;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurityConfig(MemberService memberService,
                             Environment environment,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberService = memberService;
        this.environment = environment;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /* Authorization(인가)용 메소드 */
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{

        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(memberService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        /* 크로스 사이트 요청 위조 방지 */
        http.csrf((csrf) -> csrf.disable());

        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(new AntPathRequestMatcher("/member/**")).permitAll()
        )
                .authenticationManager(authenticationManager);

        http.addFilter(getAuthenticcationFilter(authenticationManager));

        return http.build();
    }

    private Filter getAuthenticcationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager, memberService, environment);
    }
}

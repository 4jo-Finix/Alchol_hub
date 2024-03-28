package com.teamphoenix.ahub.member.command.security;

import com.teamphoenix.ahub.member.command.service.MemberService;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final MemberService memberService;
    private final Environment environment;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private JwtUtil jwtUtil;

    @Autowired
    public WebSecurityConfig(MemberService memberService,
                             Environment environment,
                             BCryptPasswordEncoder bCryptPasswordEncoder,
                             JwtUtil jwtUtil) {
        this.memberService = memberService;
        this.environment = environment;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(memberService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.csrf((csrf) -> csrf.disable());

        http.authorizeHttpRequests((auth) -> auth
                        .requestMatchers(new AntPathRequestMatcher("/member/**")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/member/findAllMembers/**")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/member/findByMemberCode/**")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/member/findByMemberId/**")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/member/findMyprofile/**")).hasRole("STANDARD")
                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilter(getAuthenticationFilter(authenticationManager));
        http.addFilterBefore(new JwtFilter(memberService, jwtUtil), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    private AuthenticationFilter getAuthenticationFilter(AuthenticationManager authenticationManager) {

        return new AuthenticationFilter(authenticationManager, memberService, environment);
    }

}

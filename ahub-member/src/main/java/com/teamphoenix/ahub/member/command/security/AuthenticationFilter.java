package com.teamphoenix.ahub.member.command.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamphoenix.ahub.member.command.vo.RequestLogin;
import com.teamphoenix.ahub.member.query.service.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

/* 로그인을 위한 필터 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private MemberService memberService;
    private Environment environment;

    public AuthenticationFilter(AuthenticationManager authenticationManager,
                                MemberService memberService,
                                Environment environment) {
        super(authenticationManager);
        this.memberService = memberService;
        this.environment = environment;
    }

    /* 로그인 시도 시 동작하는 기능 */

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            RequestLogin requestLogin =
                    new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestLogin.getMemberId(), requestLogin.getMemberPwd(), new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* 로그인 성공 시 JWT 토큰 생성하는 기능 */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("authResult = " + authResult);
    }
}

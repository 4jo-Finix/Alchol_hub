package com.teamphoenix.ahub.member.command.security;

import com.teamphoenix.ahub.member.command.service.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
/* 요청을 보낸 회원이 헤더에 토큰을 가지고 있는 경우 동작하는 필터(= 로그인 된 회원) */
public class JwtFilter extends OncePerRequestFilter {
    private final MemberService memberService;
    private final JwtUtil jwtUtil;

    public JwtFilter(MemberService memberService, JwtUtil jwtUtil) {
        this.memberService = memberService;
        this.jwtUtil = jwtUtil;
    }

    /* UserNamePasswordAuthentication보다 먼저 동작하는 필터를 생성 */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            String token = authorizationHeader.substring(7);
            System.out.println("token: " + token);
            if (jwtUtil.validateToken(token)) {
                Authentication authentication = jwtUtil.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}

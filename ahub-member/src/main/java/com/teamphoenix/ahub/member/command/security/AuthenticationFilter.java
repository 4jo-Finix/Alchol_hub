package com.teamphoenix.ahub.member.command.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamphoenix.ahub.member.command.dto.MemberDTO;
import com.teamphoenix.ahub.member.command.service.MemberService;
import com.teamphoenix.ahub.member.command.vo.RequestLogin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final MemberService memberService;
    private final Environment environment;

    public AuthenticationFilter(AuthenticationManager authenticationManager, MemberService memberService, Environment environment) {
        super(authenticationManager);
        this.memberService = memberService;
        this.environment = environment;
    }

    // 인증을 시도할 때 동작하는 메소드 : POST 요청으로 /login 들어오기 때문에 로그인 정보가 request body에 담겨온다.
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            RequestLogin requestLogin =
                    new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);

            // 사용자가 전달한 id / pwd 를 사용해 authentication 토큰을 만듬
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestLogin.getMemberId(), requestLogin.getMemberPwd(), new ArrayList<>())
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        /* 성공해서 관리하고 있는 정보 (authResult)를 사용해 토큰을 만든다. */
        String userName = ((User)authResult.getPrincipal()).getUsername(); //로그인한 userid 가 나온다.

        MemberDTO userDetails = memberService.getUserDetailsByUserId(userName);

        /* 회원 권한을 담을 List 생성 */
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_STANDARD");
        roles.add("ROLE_BUSINESS");

        Claims claims = Jwts.claims().setSubject(userDetails.getMemberId());
        claims.put("auth", roles);

        MemberDTO memberDTO = memberService.searchMember(authResult.getName());
        /* 토큰 생성 */
        String token = Jwts.builder().setClaims(claims)
                .setSubject(authResult.getName())
                .setAudience(String.valueOf(memberDTO.getMemberCode()))
                .claim("memberId", memberDTO.getMemberId())
                                    .setExpiration(new Date(System.currentTimeMillis() +
                                            Long.parseLong(environment.getProperty("token.expiration_time"))))
                                            .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret"))
                                                    .compact();
        response.addHeader("token", token);
        response.addHeader("memberId", userDetails.getMemberId());
    }
}

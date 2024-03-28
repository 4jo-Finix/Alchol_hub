package com.teamphoenix.ahub.member.command.security;

import com.teamphoenix.ahub.member.command.service.MemberService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Component
/* 사용자가 가져온 토큰을 분해 */
public class JwtUtil {

    private final Key key;
    private final long accessTokenExpTime;
    private final MemberService memberService;

    public JwtUtil(
            @Value("${token.secret}") String secretKey,
            @Value("${token.expiration_time}") long accessTokenExpTime,
            MemberService memberService) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.accessTokenExpTime = accessTokenExpTime;
        this.memberService = memberService;
    }

    /* AccessToken에서 (userDetails와 user권한이 담긴)인증 객체(Authentiacaion) 추출 */
    public Authentication getAuthentication(String token) {
        /* token에 담긴 memberId와 일치하는 회원의 username을 DB에서 가져와 userDetails 객체에 저장 */
        UserDetails userDetails = memberService.loadUserByUsername(this.getMemberId(token));

        /* 토큰에서 Claims 추출하여 claims 객체에 저장 */
        Claims claims = parseClaims(token);
        System.out.println("AcessToken에 담긴 Claims 확인: " + claims);

        if (claims.get("auth") == null){
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        /* 클레임에서 권한 정보 가져오기 */
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("auth").toString()
                                .replace("[", "").replace("]", "").split(", "))
                                .map(role -> new SimpleGrantedAuthority(role))
                                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    /* 구문 분석이 완료된 토큰에서 MemberId 추출하는 메소드 */
    private String getMemberId(String token) {
        return parseClaims(token).getSubject();
    }

    /* 토큰에서 Claims 추출하는 메소드 */
    /* Claim이란?
    * JWT 토큰의 payload 부분에는 토큰에 담을 정보가 들어있고, 이 정보 하나하나를 클레임이라고 한다. */
    public Claims parseClaims(String token) {
        try {
            /* 사용자가 전달한 token의 claims를 분석하는 코드.
            * key 값을 통해 구문을 분석하고, 구문 분석된 Jws<Claims> 객체를 반환함
            */
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
            /* 만료된 토큰이 들어온 경우, 만료된 토큰의 claims을 반환하여 예외 처리 */
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    /* 토큰 유효성 검증 */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token {}", e);
        } catch (ExpiredJwtException e) {
            log.info("expired JWT Toekn {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token {}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims strig si empty {}", e);
        }

        return false;
    }
}

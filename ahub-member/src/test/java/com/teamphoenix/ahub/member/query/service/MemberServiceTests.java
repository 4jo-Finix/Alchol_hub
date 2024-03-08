package com.teamphoenix.ahub.member.query.service;

import com.teamphoenix.ahub.member.query.dto.MemberDTO;
import com.teamphoenix.ahub.member.query.service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;


@SpringBootTest
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    static Stream<Arguments> getMemberCode() {
        return Stream.of(Arguments.of("2"),
                Arguments.of("3")
        );
    }

    static Stream<Arguments> getMemberId() {
        return Stream.of(Arguments.of("user01"),
                Arguments.of("user02")
        );
    }

    static Stream<Arguments> getMemberInfo() {
        return Stream.of(Arguments.of(new MemberDTO(1, "admin", "관리자", "admin01", "user01@gmail.com", "서울시 동작구", "010-1111-1111", 0)),
                Arguments.of(new MemberDTO(2, "user01", "손세림", "pass01", "user02@gmail.com", "서울시 구로구", "010-2222-2222", 0)),
                Arguments.of(new MemberDTO(3, "user02", "송동준", "pass02", "user03@gmail.com", "서울시 광진구", "010-3333-3333", 0))
        );
    }

    static Stream<Arguments> getCurrentMemberId() {
        return Stream.of(Arguments.of("user01"),
                Arguments.of("user02")
        );
    }
    static Stream<Arguments> getMemberLoginInfo() {
        return Stream.of(Arguments.of(new MemberDTO("user01", "pass01")),
                Arguments.of(new MemberDTO("user02", "pass02"))
        );
    }

    @DisplayName("T1 - 전체 회원 조회")
    @ParameterizedTest
    @MethodSource("getMemberInfo")
    void testSelectAllMembers() {
        Assertions.assertDoesNotThrow(
                () -> memberService.selectAllMembers()
        );
    }

    @DisplayName("T2 - 회원 코드로 조회")
    @ParameterizedTest
    @MethodSource("getMemberCode")
    void testSelectByMemberCode(String inputMemberCode){
        Assertions.assertDoesNotThrow(
                () -> memberService.selectByMemberCode(inputMemberCode)
        );
    }

    @DisplayName("T3- 회원 아이디로 조회")
    @ParameterizedTest
    @MethodSource("getMemberId")
    void testSelectByMemberId(String memberId){
        Assertions.assertDoesNotThrow(
                () -> memberService.selectByMemberId(memberId)
        );
    }

    @DisplayName("T4 - 회원 프로필 조회")
    @ParameterizedTest
    @MethodSource("getCurrentMemberId")
    void testSelectMyprofile(String currentMemberId){
        Assertions.assertDoesNotThrow(
                () -> memberService.selectMyprofile(currentMemberId)
        );
    }

    @DisplayName("회원 로그인")
    @ParameterizedTest
    @MethodSource("getMemberLoginInfo")
    void testMemberLogin(MemberDTO memberLoginInfo) {
        Assertions.assertDoesNotThrow(
                () -> memberService.memberLogin(memberLoginInfo)
        );
    }
}
package com.teamphoenix.ahub.member.command.service;

import com.teamphoenix.ahub.member.command.dto.MemberDTO;
import com.teamphoenix.ahub.member.command.service.MemberServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
public class MemberServiceTests {

    @Autowired
    private MemberServiceImpl memberService;

    static Stream<Arguments> getMemberDTO() {
        return Stream.of(
                Arguments.of(new MemberDTO("test01", "tpass01", "테스트1", "test1@gmail.com", "서울시 동작구", "010-1111-4444", LocalDateTime.now(), 2)),
                Arguments.of(new MemberDTO("test02", "tpass02", "테스트2", "test2@gmail.com", "서울시 동작구", "010-2222-4444", LocalDateTime.now(), 2)),
                Arguments.of(new MemberDTO("test03", "tpass03", "테스트3", "test3@gmail.com", "서울시 동작구", "010-3333-4444", LocalDateTime.now(), 2))
        );
    }

    static Stream<Arguments> getMemberId() {
        return Stream.of(
                Arguments.of("user01"),
                Arguments.of("user02"),
                Arguments.of("user03")

        );
    }

    static Stream<Arguments> getModifyValue() {
        return Stream.of(
                Arguments.of("user01", new MemberDTO("test01", "tpass01", "테스트1", "test1@gmail.com", "서울시 구로구", "010-1111-1234")),
                Arguments.of("user02", new MemberDTO("test02", "tpass02", "테스트2", "test2@gmail.com", "서울시 구로구", "010-1111-1234")),
                Arguments.of("user03", new MemberDTO("test03", "tpass03", "테스트3", "test3@gmail.com", "서울시 구로구", "010-1111-1234"))
        );
    }

    @DisplayName("T1 - 회원 가입 테스트")
    @ParameterizedTest
    @MethodSource("getMemberDTO")
    @Transactional
    void registMemberTests(MemberDTO newMemberInfo) {
        Assertions.assertDoesNotThrow(
                () -> memberService.registMember(newMemberInfo)
        );
    }

    @DisplayName("T2-1 회원 코드 요청 테스트")
    @ParameterizedTest
    @MethodSource("getMemberId")
    @Transactional
    void getMemberCodeTest(String memberId) {
        Assertions.assertDoesNotThrow(
                () -> memberService.getMemberCode(memberId)
        );
    }

    @DisplayName("T2-2 - 회원 정보 수정 테스트")
    @ParameterizedTest
    @MethodSource("getModifyValue")
    @Transactional
    void modifyMemberTests(String memberId, MemberDTO modifyMember) {
        Assertions.assertDoesNotThrow(
                () -> memberService.modifyMember(memberId, modifyMember)
        );
    }

    @DisplayName("T3 - 회원 정보 삭제 테스트")
    @ParameterizedTest
    @MethodSource("getMemberId")
    @Transactional
    void removeMemberTest(String memberId) {
        Assertions.assertDoesNotThrow(
                () -> memberService.removeMember(memberId)
        );
    }

}

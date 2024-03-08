package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;


@SpringBootTest
class FairServiceImplTest {

    @Autowired
    private FairServiceImpl fairServiceImpl;

    static Stream<Arguments> getFairDTO() {

        return Stream.of(
                Arguments.of(new FairDTO("위스키 페어 게시물 등록2", "위스키 페어 게시물을 등록합니다.", LocalDateTime.now(), 1, 1)),
                Arguments.of(new FairDTO("맥주 페어 게시물 등록3", "맥주 페어 게시물을 등록합니다.", LocalDateTime.now(), 1, 1)),
                Arguments.of(new FairDTO("와인 페어 게시물 등록4", "와인 페어 게시물을 등록합니다.", LocalDateTime.now(), 1, 1))
        );
    }

    static Stream<Arguments> getModifyInfo() {

        return Stream.of(
                Arguments.of(8, new FairDTO(8,"위스키 페어 게시물 등록2", "위스키 페어 게시물을 등록합니다.", LocalDateTime.now(), 1, 1))
        );
    }

    @DisplayName("T1 - 페어 정보 게시글 등록")
    @ParameterizedTest
    @MethodSource("getFairDTO")
    @Transactional
    void registFairPostTest(FairDTO fairInfo) {

        Assertions.assertDoesNotThrow(
                () -> fairServiceImpl.registFairPost(fairInfo)
        );
    }

    @DisplayName("T2 - 페어 정보 게시글 수정")
    @ParameterizedTest
    @MethodSource("getModifyInfo")
    @Transactional
    void modifyFairPostTest(int postNum, FairDTO modifyInfo) {

        Assertions.assertDoesNotThrow(
                () -> fairServiceImpl.modifyFairPost(postNum, modifyInfo)
        );
    }

    @DisplayName("T3 - 페어 정보 게시글 삭제")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9})
    @Transactional
    void deleteFairPostTest(int postNum) {
        Assertions.assertDoesNotThrow(
                () -> fairServiceImpl.removeFairPost(postNum)
        );

    }
}
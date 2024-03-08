package com.teamphoenix.ahub.news.command.service;

import com.teamphoenix.ahub.news.command.dto.NewsDTO;
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
class NewsServicelmplTest {

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    static Stream<Arguments> getNewsDTO() {

        return Stream.of(
                Arguments.of(new NewsDTO("뉴스 게시물 등록2", "뉴스 1 게시물을 등록합니다.", LocalDateTime.now(), 1, 1)),
                Arguments.of(new NewsDTO("뉴스 게시물 등록3", "뉴스 2 게시물을 등록합니다.", LocalDateTime.now(), 1, 1)),
                Arguments.of(new NewsDTO("뉴스 게시물 등록4", "뉴스 3 게시물을 등록합니다.", LocalDateTime.now(), 1, 1))
        );
    }

    static Stream<Arguments> getModifyInfo() {

        return Stream.of(
                Arguments.of(8, new NewsDTO(8," 뉴스 게시물 등록2", "뉴스 게시물을 등록합니다.", LocalDateTime.now(), 1, 1))
        );
    }

    @DisplayName("T1 - 페어 정보 게시글 등록")
    @ParameterizedTest
    @MethodSource("getNewsDTO")
    @Transactional
    void registNewsPostTest(NewsDTO newsInfo) {

        Assertions.assertDoesNotThrow(
                () -> newsServiceImpl.registNewsPost(newsInfo)
        );
    }

    @DisplayName("T2 - 페어 정보 게시글 수정")
    @ParameterizedTest
    @MethodSource("getModifyInfo")
    @Transactional
    void modifyPostTest(int postNum, NewsDTO modifyInfo) {

        Assertions.assertDoesNotThrow(
                () -> newsServiceImpl.modifyNewsPost(postNum, modifyInfo)
        );
    }

    @DisplayName("T3 - 페어 정보 게시글 삭제")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9})
    @Transactional
    void deleteNewsPostTest(int postNum) {
        Assertions.assertDoesNotThrow(
                () -> newsServiceImpl.removeNewsPost(postNum)
        );

    }
}

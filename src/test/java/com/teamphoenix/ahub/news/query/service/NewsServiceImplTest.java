package com.teamphoenix.ahub.news.query.service;

import com.teamphoenix.ahub.news.query.dto.NewsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class NewsServiceImplTest {

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    static Stream<Arguments> getSearchInfo() {

        return Stream.of(
                Arguments.of(new NewsDTO(null, null)),
                Arguments.of(new NewsDTO("2", null)),
                Arguments.of(new NewsDTO(null, "와인")),
                Arguments.of(new NewsDTO("2", "와인"))
        );
    }

    @DisplayName("T1-게시글 선택 시 게시글 번호로 내용 불러오기 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5})
    void findFairPost(int postNum) {
        Assertions.assertDoesNotThrow(
                () -> newsServiceImpl.getNewsPost(postNum)
        );
    }

    @DisplayName("T2-검색창에서 카테고리 조건에 맞는 게시글 검색 후 리스트 반환 테스트")
    @ParameterizedTest
    @MethodSource("getSearchInfo")
    void selectPostByConditionTest(NewsDTO newsDTO) {
        Assertions.assertDoesNotThrow(
                () -> newsServiceImpl.findPostsByCondition(newsDTO)
        );
    }


}
package com.teamphoenix.ahub.post.command;

import com.teamphoenix.ahub.post.command.dto.PostCategoryDTO;
import com.teamphoenix.ahub.post.command.dto.PostDTO;
import com.teamphoenix.ahub.post.command.service.PostServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private PostServiceImpl postServiceImpl;

    static Stream<Arguments> getPostDTO() {

        PostCategoryDTO ck = new PostCategoryDTO(1,"이름");
        List<PostCategoryDTO> pkl = new ArrayList<>();

        return Stream.of(
                Arguments.of(new PostDTO(1, "Post1", "This is Post1 contents.", "2024-01-10 17:07:28", 1, 1, 0, 0, 2, "2024-01-11 10:18:29", pkl))
        );
    }

    static Stream<Arguments> getModifyInfo() {

        PostCategoryDTO ck = new PostCategoryDTO(1,"이름");
        List<PostCategoryDTO> pkl = new ArrayList<>();

        return Stream.of(
                Arguments.of(1, (new PostDTO(1, "Post1", "This is Post1 contents.", "2024-01-10 17:07:28", 1, 1, 0, 0, 2, "2024-01-11 10:18:29", pkl)))
        );
    }

    @DisplayName("1. 게시글 등록")
    @ParameterizedTest
    @MethodSource("getPostDTO")
    @Transactional
    void registPostTest(PostDTO postInfo) {

        Assertions.assertDoesNotThrow(
                () -> postServiceImpl.createPost(postInfo)
        );
    }

    @DisplayName("2. 게시글 수정")
    @ParameterizedTest
    @MethodSource("getModifyInfo")
    @Transactional
    void modifyPostTest(int postNum, PostDTO modifyInfo) {

        Assertions.assertDoesNotThrow(
                () -> postServiceImpl.modifyPost(modifyInfo, postNum)
        );
    }

    @DisplayName("3. 게시글 삭제")
    @ParameterizedTest
    @ValueSource(ints = {1})
    @Transactional
    void deleteFairPostTest(int postNum) {
        Assertions.assertDoesNotThrow(
                () -> postServiceImpl.removePost(postNum)
        );

    }
}

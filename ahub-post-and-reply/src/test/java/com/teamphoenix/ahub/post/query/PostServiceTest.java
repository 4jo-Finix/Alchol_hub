//package com.teamphoenix.ahub.post.query;
//
//import com.teamphoenix.ahub.post.query.dto.PostDTO;
//import com.teamphoenix.ahub.post.query.service.PostService;
//import com.teamphoenix.ahub.post.query.service.PostServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.stream.Stream;
//
//@SpringBootTest
//class PostServiceTest {
//
//    @Autowired
//    private PostService postService;
//
//    @Autowired
//    private PostServiceImpl postServiceImpl;
//
//    static Stream<Arguments> getMemberCode() {
//        return Stream.of(
//                Arguments.of("3")
//        );
//    }
//
//    static Stream<Arguments> getLikeId() {
//        return Stream.of(
//                Arguments.of("2")
//        );
//    }
//
//    static Stream<Arguments> getDayLikePost() {
//        return Stream.of(
//                Arguments.of("2024-03-08")
//        );
//    }
//
//    static Stream<Arguments> getMonthLikePost() {
//        return Stream.of(
//                Arguments.of("2024-03")
//        );
//    }
//
//    static Stream<Arguments> getSearchInfo() {
//
//        return Stream.of(
//                Arguments.of(new PostDTO(null, null)),
//                Arguments.of(new PostDTO("2024", null)),
//                Arguments.of(new PostDTO(null,"맥주")),
//                Arguments.of(new PostDTO("맥주", "맥주"))
//        );
//    }
//
////    @DisplayName("회원 코드로 게시글 조회")
////    @ParameterizedTest
////    @MethodSource("getMemberCode")
////    void testSelectByMemberCode(String inputMemberCode){
////        Assertions.assertDoesNotThrow(
////                () -> postService.selectPostsByMemberCode(inputMemberCode)
////        );
////    }
//
//    @DisplayName("회원 코드로 좋아요한 게시글 조회")
//    @ParameterizedTest
//    @MethodSource("getLikeId")
//    void testSelectByLikeId(String inputLikeId){
//        Assertions.assertDoesNotThrow(
//                () -> postService.selectPostsByLikeId(inputLikeId)
//        );
//    }
//
//    @DisplayName("오늘자 인기게시글 조회(좋아요 5개 이상)")
//    @ParameterizedTest
//    @MethodSource("getDayLikePost")
//    void testSelectDayLikePost(String inputPostDate){
//        Assertions.assertDoesNotThrow(
//                () -> postService.selectDayLikePost(inputPostDate)
//        );
//    }
//
//    @DisplayName("이달의 인기게시글 조회(좋아요 10개 이상)")
//    @ParameterizedTest
//    @MethodSource("getMonthLikePost")
//    void testSelectMonthLikePost(String inputPostDate){
//        Assertions.assertDoesNotThrow(
//                () -> postService.selectDayLikePost(inputPostDate)
//        );
//    }
//
//
//    @DisplayName("T1-게시글 선택 시 게시글 번호로 내용 불러오기 테스트")
//    @ParameterizedTest
//    @ValueSource(ints = {1, 3, 8})
//    void findPostTest(int postId) {
//        Assertions.assertDoesNotThrow(
//                () -> postServiceImpl.getPost(postId)
//        );
//    }
//
//    @DisplayName("T2-검색창에서 카테고리 조건에 맞는 게시글 검색 후 리스트 반환 테스트")
//    @ParameterizedTest
//    @MethodSource("getSearchInfo")
//    void selectPostByConditionTest(PostDTO getInfo) {
//        Assertions.assertDoesNotThrow(
//                () -> postServiceImpl.findPostsByCondition(getInfo)
//        );
//    }
//
//}

package com.teamphoenix.ahub.postreply.query.controller;

import com.teamphoenix.ahub.postreply.query.dto.LikePostAndPostDTO;
import com.teamphoenix.ahub.postreply.query.dto.PostDTO;
import com.teamphoenix.ahub.postreply.query.service.PostService;
import com.teamphoenix.ahub.postreply.query.vo.ResponseFindPost;
import com.teamphoenix.ahub.postreply.query.vo.ResponseList;
import com.teamphoenix.ahub.postreply.query.vo.ResponseSearchList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@RestController(value = "queryPostController")
@RequestMapping("/posts")
@Slf4j
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/findPostsByMemberCode")
    public List<PostDTO> findPostsByMemberCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 코드 입력하여 게시글 조회: ");
        String inputMemberCode = sc.nextLine();

        return postService.selectPostsByMemberCode(inputMemberCode);
    }

    @GetMapping("/findPostsByLikeId")
    public List<LikePostAndPostDTO> findPostsByLikeId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 코드 입력하여 좋아요한 게시글 조회: ");
        String inputLikeId = sc.nextLine();

        return postService.selectPostsByLikeId(inputLikeId);
    }

    @GetMapping("/findDayLikePost")
    public List<PostDTO> findDayLikePost() {
        LocalDate localDate1 = LocalDate.now();
        String dateFormat1 = localDate1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return postService.selectDayLikePost(dateFormat1);
    }

    @GetMapping("/findMonthLikePost")
    public List<PostDTO> findMonthLikePost() {
        LocalDate localDate2 = LocalDate.now();
        String dateFormat2 = localDate2.format(DateTimeFormatter.ofPattern("yyyy-MM"));

        return postService.selectMonthLikePost(dateFormat2);
    }

    /* 게시글을 클릭하면 내용을 호출하는 핸들러 메소드 */
    @GetMapping("/{postId}")
    public ResponseEntity<ResponseFindPost> findPost(@PathVariable(value = "postId") int postId) {

        PostDTO postDTO = postService.getPost(postId);

        ResponseFindPost result = new ResponseFindPost();
        result.setCode("200, OK");
        result.setMessage("Success to Read [" + postId + "] post.");
        result.setUrl("http://localhost:8000/board/posts/lists");
        result.setResult(postDTO);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    /* 게시글 전체 리스트&검색어를 파라미터로 던질 시 해당 검색어에 해당하는 리스트를 반환하는 핸들러 메소드 */
    @GetMapping("/lists")
    public ResponseEntity<ResponseSearchList> findPostsByCondition(
            @RequestParam(value = "st", required = false) String title,
            @RequestParam(value = "sc", required = false) String content){

        PostDTO searchInfo = new PostDTO(title, content);
        List<PostDTO> resultList = postService.findPostsByCondition(searchInfo);
        List<ResponseList> responseLists = doDTOToList(resultList);



        ResponseSearchList result = new ResponseSearchList();
        result.setCode("200, OK");
        result.setMessage("Success to Read list.");
        result.setUrl("http://localhost:8000/board/fairs/{postId}");
        result.setResult(responseLists);

        return ResponseEntity
                .ok()
                .body(result);
    }

    private List<ResponseList> doDTOToList(List<PostDTO> postList) {
        List<ResponseList> responseLists = new ArrayList<>();
        for (PostDTO postDTO : postList) {
            ResponseList responseList = new ResponseList();
            responseList.setPostId(postDTO.getPostId());
            responseList.setPostTitle(postDTO.getPostTitle());
            responseList.setPostDate(postDTO.getPostDate());

            responseLists.add(responseList);
        }

        return responseLists;
    }


}

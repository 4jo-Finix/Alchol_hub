package com.teamphoenix.ahub.post.command.controller;

import com.teamphoenix.ahub.post.command.dto.PostDTO;
import com.teamphoenix.ahub.post.command.service.PostService;
import com.teamphoenix.ahub.post.command.vo.RequestRegist;
import com.teamphoenix.ahub.post.command.vo.ResponseRegist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController(value = "postCommandController")
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final ModelMapper modelMapper;

    @Autowired
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseRegist> addNewPost(@RequestBody RequestRegist postInfo) {

        PostDTO newPost = modelMapper.map(postInfo, PostDTO.class);
//        newPost.setPostDate(LocalDateTime.now());
//        newPost.setPostModifyDate(LocalDateTime.now());

        LocalDate localDate = LocalDate.now();
        String dateFormat = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        newPost.setPostDate(dateFormat);
        newPost.setPostModifyDate(dateFormat);
        newPost.setCategoryId(1);
        newPost.setLikeAmount(0);
        newPost.setUseAcceptance(1);
        newPost.setReportedAcceptance(0);
        newPost.setMemberCode(1);

        postService.createPost(newPost);

        ResponseRegist responseRegist = new ResponseRegist();
        responseRegist.setMessage("Success to add new post.");
        responseRegist.setResult(newPost);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(responseRegist);
    }


    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<ResponseRegist> removePost(@PathVariable int postId) {
        postService.removePost(postId);

        ResponseRegist responseRegist = new ResponseRegist();
        responseRegist.setMessage("Success to delete this post.");

        return ResponseEntity
                .status(HttpStatus.OK).body(responseRegist);
    }

    @PutMapping("/modify/{postId}")
    public ResponseEntity<PostDTO> modifyPost(@RequestBody PostDTO modifyInfo, @PathVariable int postId){

        PostDTO postDTO = postService.modifyPost(modifyInfo, postId);

        return ResponseEntity
                .status(HttpStatus.OK).body(postDTO);
    }

}

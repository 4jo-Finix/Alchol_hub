package com.teamphoenix.ahub.postreply.command.controller;

import com.teamphoenix.ahub.postreply.command.dto.PostDTO;
import com.teamphoenix.ahub.postreply.command.service.PostService;
import com.teamphoenix.ahub.postreply.command.vo.RequestRegist;
import com.teamphoenix.ahub.postreply.command.vo.ResponseRegist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
        newPost.setPostDate(LocalDateTime.now());
        newPost.setPostModifyDate(LocalDateTime.now());
        newPost.setUseAcceptance(1);
        newPost.setMemberCode(1);

        postService.createPost(newPost);

        ResponseRegist responseRegist = new ResponseRegist();
        responseRegist.setMessage("Success to add new post.");
        responseRegist.setResult(newPost);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(responseRegist);
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<ResponseRegist> removePost(@PathVariable("postId") int postId) {
        postService.removePost(postId);

        ResponseRegist responseRegist = new ResponseRegist();
        responseRegist.setMessage("Success to delete this post.");

        return ResponseEntity
                .status(HttpStatus.OK).body(responseRegist);
    }

}

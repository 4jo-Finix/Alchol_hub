package com.teamphoenix.ahub.postreply.command.service;

import com.teamphoenix.ahub.postreply.command.aggregate.Post;
import com.teamphoenix.ahub.postreply.command.dto.PostDTO;
import com.teamphoenix.ahub.postreply.command.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value = "CommandPostService")
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public PostDTO createPost(PostDTO newPost) {
        Post post = modelMapper.map(newPost, Post.class);

        postRepository.save(post);
        return newPost;
    }

    @Transactional
    public void removePost(int postId) {
        postRepository.deleteById(postId);
    }
}



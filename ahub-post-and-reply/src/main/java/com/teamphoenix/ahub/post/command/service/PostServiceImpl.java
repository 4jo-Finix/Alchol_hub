package com.teamphoenix.ahub.post.command.service;

import com.teamphoenix.ahub.post.command.aggregate.Post;
import com.teamphoenix.ahub.post.command.dto.PostDTO;
import com.teamphoenix.ahub.post.command.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    public void createPost(PostDTO newPost) {
        Post post = modelMapper.map(newPost, Post.class);

        postRepository.save(post);
    }

    @Transactional
    public void removePost(int postId) {
        postRepository.deleteById(postId);
    }

    @Transactional
    public PostDTO modifyPost(PostDTO modifyInfo, int postId) {
        Post foundPost = postRepository.findById(postId).orElseThrow(IllegalAccessError::new);

        LocalDate localDate = LocalDate.now();
        String dateFormat = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if(modifyInfo.getPostContent() == null) {
            foundPost.setPostTitle(modifyInfo.getPostTitle());
            foundPost.setPostModifyDate(dateFormat);
        } else if(modifyInfo.getPostTitle() == null) {
            foundPost.setPostContent(modifyInfo.getPostContent());
            foundPost.setPostModifyDate(dateFormat);
        } else {
            foundPost.setPostTitle(modifyInfo.getPostTitle());
            foundPost.setPostContent(modifyInfo.getPostContent());
            foundPost.setPostModifyDate(dateFormat);
        }

        foundPost = postRepository.findById(postId).orElseThrow(IllegalAccessError::new);

        return modelMapper.map(foundPost, PostDTO.class);
    }
}



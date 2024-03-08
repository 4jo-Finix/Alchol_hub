package com.teamphoenix.ahub.post.command.service;

import com.teamphoenix.ahub.post.command.dto.PostDTO;

public interface PostService {

    void createPost(PostDTO newPost);

    void removePost(int postId);

    PostDTO modifyPost(PostDTO modifyInfo, int postId);
}

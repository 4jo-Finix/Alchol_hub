package com.teamphoenix.ahub.post.query.service;

import com.teamphoenix.ahub.post.query.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO getPost(int postId);

    List<PostDTO> findPostsByCondition(PostDTO searchInfo);
}

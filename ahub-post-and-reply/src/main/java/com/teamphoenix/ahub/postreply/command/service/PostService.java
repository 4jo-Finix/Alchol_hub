package com.teamphoenix.ahub.postreply.command.service;

import com.teamphoenix.ahub.postreply.command.dto.PostDTO;

public interface PostService {

    PostDTO createPost(PostDTO newPost);

    void removePost(int postId);


}

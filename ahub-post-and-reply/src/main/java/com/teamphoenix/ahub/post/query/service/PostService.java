package com.teamphoenix.ahub.post.query.service;

import com.teamphoenix.ahub.post.query.dto.LikePostAndPostDTO;
import com.teamphoenix.ahub.post.query.dto.PostDTO;

import java.util.List;

public interface PostService {

    public List<PostDTO> selectPostsByMemberCode(int memberCode);

    public List<LikePostAndPostDTO> selectPostsByLikeId(int memberCode);

    public List<PostDTO> selectDayLikePost(String inputPostDate);

    public List<PostDTO> selectMonthLikePost(String inputPostDate);

    PostDTO getPost(int postId);

    List<PostDTO> findPostsByCondition(PostDTO searchInfo);


}

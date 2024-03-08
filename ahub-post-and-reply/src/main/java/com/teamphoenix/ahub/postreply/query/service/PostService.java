package com.teamphoenix.ahub.postreply.query.service;

import com.teamphoenix.ahub.postreply.query.dto.LikePostAndPostDTO;
import com.teamphoenix.ahub.postreply.query.dto.PostDTO;
import com.teamphoenix.ahub.postreply.query.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PostService {

    public List<PostDTO> selectPostsByMemberCode(String inputMemberCode);

    public List<LikePostAndPostDTO> selectPostsByLikeId(String inputLikeId);

    public List<PostDTO> selectDayLikePost(String inputPostDate);

    public List<PostDTO> selectMonthLikePost(String inputPostDate);

    PostDTO getPost(int postId);

    List<PostDTO> findPostsByCondition(PostDTO searchInfo);


}

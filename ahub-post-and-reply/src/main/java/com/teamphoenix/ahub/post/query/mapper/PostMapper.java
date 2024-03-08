package com.teamphoenix.ahub.post.query.mapper;

import com.teamphoenix.ahub.post.query.dto.LikePostAndPostDTO;
import com.teamphoenix.ahub.post.query.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostMapper {

    List<PostDTO> selectPostsByMemberCode(int memberCode);

    List<LikePostAndPostDTO> selectPostsByLikeId(int memberCode);

    List<PostDTO> selectDayLikePost(Map<String, String> map1);

    List<PostDTO> selectMonthLikePost(Map<String, String> map2);

    PostDTO getPost(int postNum);

    List<PostDTO> selectPostsByCondition(PostDTO searchInfo) ;

//    List<postDTO> selectAllPosts();
}

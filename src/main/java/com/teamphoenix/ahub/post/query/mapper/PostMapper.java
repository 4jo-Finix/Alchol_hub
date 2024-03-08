package com.teamphoenix.ahub.post.query.mapper;

import com.teamphoenix.ahub.post.query.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    PostDTO getPost(int postNum);

    List<PostDTO> selectPostsByCondition(PostDTO searchInfo) ;

//    List<postDTO> selectAllPosts();
}
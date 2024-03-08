package com.teamphoenix.ahub.fair.query.repository;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FairMapper {

    FairDTO getFairPost(int postNum);

    List<FairDTO> selectPostsByCondition(FairDTO searchInfo) ;

//    List<FairDTO> selectAllPosts();
}
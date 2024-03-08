package com.teamphoenix.ahub.news.query.repository;

import com.teamphoenix.ahub.news.query.dto.NewsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsDTO getNewsPost(int postNum);

    List<NewsDTO> selectPostsByCondition(NewsDTO searchInfo);
}
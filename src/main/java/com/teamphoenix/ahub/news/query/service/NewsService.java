package com.teamphoenix.ahub.news.query.service;

import com.teamphoenix.ahub.news.query.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    NewsDTO getNewsPost(int postId);

    List<NewsDTO> findPostsByCondition(NewsDTO searchInfo);
}

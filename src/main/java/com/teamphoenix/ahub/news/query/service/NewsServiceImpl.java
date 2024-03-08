package com.teamphoenix.ahub.news.query.service;

import com.teamphoenix.ahub.news.query.dto.NewsDTO;
import com.teamphoenix.ahub.news.query.repository.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsMapper newsMapper;

    @Autowired
    public NewsServiceImpl(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    public NewsDTO getNewsPost(int newsId) {

        return newsMapper.getNewsPost(newsId);
    }


    public List<NewsDTO> findPostsByCondition(NewsDTO searchInfo) {

        return newsMapper.selectPostsByCondition(searchInfo);
    }
}
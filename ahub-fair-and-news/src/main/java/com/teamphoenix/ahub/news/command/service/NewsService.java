package com.teamphoenix.ahub.news.command.service;

import com.teamphoenix.ahub.news.command.dto.NewsDTO;

public interface NewsService {
    void removeNewsPost(int postNum);

    void modifyNewsPost(int postNum, NewsDTO modifyInfo);

    NewsDTO registNewsPost(NewsDTO newNewsPost);
}

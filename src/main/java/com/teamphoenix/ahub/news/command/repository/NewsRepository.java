package com.teamphoenix.ahub.news.command.repository;

import com.teamphoenix.ahub.news.command.aggregate.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NewsRepository extends JpaRepository<News, Integer> {

    @Query("SELECT f FROM News f WHERE f.newsTitle = :title")
    News findByNewsTitle(@Param("title") String title);
}

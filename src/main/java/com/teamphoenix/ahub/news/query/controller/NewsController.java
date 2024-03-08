package com.teamphoenix.ahub.news.query.controller;

import com.teamphoenix.ahub.news.query.dto.NewsDTO;
import com.teamphoenix.ahub.news.query.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "queryNewsController")
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<NewsDTO> findNewsPost(@PathVariable(value = "postId") int postId) {

        return ResponseEntity.ok()
                .body(newsService.getNewsPost(postId));
    }

    @GetMapping("/lists")
    public ResponseEntity<List<NewsDTO>> findPostsByCondition(
            @RequestParam(value = "st", required = false) String title,
            @RequestParam(value = "sc", required = false) String content
    ) {

        NewsDTO searchInfo = new NewsDTO(title, content);
        List<NewsDTO> resultList = newsService.findPostsByCondition(searchInfo);

        return ResponseEntity
                .ok()
                .body(resultList);
    }


}
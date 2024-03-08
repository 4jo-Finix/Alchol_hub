package com.teamphoenix.ahub.news.command.controller;

import com.teamphoenix.ahub.news.command.dto.NewsDTO;
import com.teamphoenix.ahub.news.command.service.NewsService;
import com.teamphoenix.ahub.news.command.vo.RequestRegist;
import com.teamphoenix.ahub.news.command.vo.ResponseStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController(value = "newsCommandController")
@RequestMapping("/board")
public class NewsController {

    private final NewsService newsService;
    private final ModelMapper modelMapper;

    @Autowired
    public NewsController(NewsService newsService, ModelMapper modelMapper) {
        this.newsService = newsService;
        this.modelMapper = modelMapper;
    }

    /* 새 게시글 등록 핸들러 메소드 */
    @PostMapping("/new")
    public ResponseEntity<ResponseStatus> addNewPost(@RequestBody RequestRegist postInfo) {

        System.out.println("postInfo = " + postInfo);
        NewsDTO newNewsPost = modelMapper.map(postInfo, NewsDTO.class);

//        System.out.println("newNewsPost = " + newNewsPost);

        newNewsPost.setNewsWritedate(LocalDateTime.now());
        newNewsPost.setUseAcceptance(1);
        newNewsPost.setMemberCode(1);

        NewsDTO result = newsService.registNewsPost(newNewsPost);

        ResponseStatus respMessage = new ResponseStatus();
        respMessage.setCode("201, CREATED");
        respMessage.setMessage("Success to add new post.");
        respMessage.setUrl("http://localhost:8000/board/news/lists");
        respMessage.setResult(result);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(respMessage);
    }

    /* 기존 게시글 수정 핸들러 메소드 */
    @PutMapping("/{postNum}")
    public ResponseEntity<ResponseStatus> modifyNewsPost(
            @PathVariable(value = "postNum") int postNum,
            @RequestBody NewsDTO modifyInfo) {

        modifyInfo.setNewsWritedate(LocalDateTime.now());

        newsService.modifyNewsPost(postNum, modifyInfo);

        ResponseStatus respMessage = new ResponseStatus();
        respMessage.setCode("200, OK");
        respMessage.setMessage("Success to update [ " + postNum + " ] news post.");
        respMessage.setUrl("http://localhost:8000/board/news/lists");
        respMessage.setResult(modifyInfo);

        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);

    }


    /* 게시글 삭제 */
    @DeleteMapping("/{postNum}")
    public ResponseEntity<ResponseStatus> removeNewsPost(@PathVariable("postNum") int postNum) {

        newsService.removeNewsPost(postNum);

        ResponseStatus respMessage = new ResponseStatus();
        respMessage.setCode("200, OK");
        respMessage.setMessage("Success to delete [ " + postNum + " ] news post.");
        respMessage.setUrl("http://localhost:8000/board/news/lists");

        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);
    }
}

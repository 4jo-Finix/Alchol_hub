package com.teamphoenix.ahub.reply.query.controller;


import com.teamphoenix.ahub.reply.query.dto.ReplyDTO;
import com.teamphoenix.ahub.reply.query.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "replyQueryController")
@RequestMapping("/reply")
@Slf4j
public class ReplyController {

    ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping("/member/{memberId}")
    public List<ReplyDTO> selectReplyByWriter(@PathVariable int memberId) {
        return replyService.selectReplyByWriter(memberId);
    }

    @GetMapping("/board/replies/{boardId}")
    public List<ReplyDTO> selectAllReplyInBoard(@PathVariable int boardId) {
        return replyService.selectAllReplyInBoard(boardId);
    }

    @GetMapping("/board/search/{inputValue}")
    public List<ReplyDTO> selectReplyBySearch(@PathVariable String inputValue) {
        return replyService.selectReplyBySearch(inputValue);
    }



}

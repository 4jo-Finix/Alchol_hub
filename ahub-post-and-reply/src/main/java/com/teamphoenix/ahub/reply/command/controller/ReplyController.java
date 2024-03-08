package com.teamphoenix.ahub.reply.command.controller;

import com.teamphoenix.ahub.reply.command.dto.ReplyDTO;
import com.teamphoenix.ahub.reply.command.service.ReplyServiceImpl;
import com.teamphoenix.ahub.reply.command.vo.ReplyWithMemberNameVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "replyCommandController")
@RequestMapping("/reply")
@Slf4j
public class ReplyController {

    private final ReplyServiceImpl replyService;

    @Autowired
    public ReplyController(ReplyServiceImpl replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/regist")
    public ResponseEntity<List<ReplyDTO>> registReply(@RequestBody ReplyDTO registInfo) {

        List<ReplyDTO> replies = replyService.registReply(registInfo);

        return ResponseEntity.status(HttpStatus.OK).body(replies);
    }

    @PutMapping("/modify/{replyId}")
    public ResponseEntity<ReplyDTO> modifyReply(@RequestBody ReplyDTO modifyInfo, @PathVariable int replyId) {

        ReplyDTO reply = replyService.modifyReply(modifyInfo, replyId);

        return ResponseEntity.status(HttpStatus.OK).body(reply);
    }

    @DeleteMapping("/delete/{replyId}")
    public ResponseEntity<List<ReplyDTO>> deleteReply(@PathVariable int replyId){

        List<ReplyDTO> replies = replyService.deleteReply(replyId);

        return ResponseEntity.status(HttpStatus.OK).body(replies);
    }

    @GetMapping("/member/test/{memberId}")
    public ResponseEntity<?> getReplyWithMemberName(@PathVariable("memberId") int memberId) {
        ReplyWithMemberNameVo replyWithMemberNameVo = replyService.getReplyWithMemberNameById(memberId);


        return ResponseEntity.status(HttpStatus.OK).body(replyWithMemberNameVo);
    }
}

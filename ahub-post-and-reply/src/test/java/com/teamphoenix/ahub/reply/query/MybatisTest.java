package com.teamphoenix.ahub.reply.query;

import com.teamphoenix.ahub.reply.query.controller.ReplyController;
import com.teamphoenix.ahub.reply.query.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MybatisTest {

    private final ReplyController replyController;

    @Autowired
    public MybatisTest(ReplyController replyController) {
        this.replyController = replyController;
    }

    @Test
    public void 회원_별_댓글_조회_테스트() {
        int memberId = 2;
        List<ReplyDTO> replies = replyController.selectReplyByWriter(memberId);

        assertTrue(!replies.isEmpty());
    }

    @Test
    public void 게시판_별_댓글_조회_테스트() {
        int boardId = 2;
        List<ReplyDTO> replies = replyController.selectAllReplyInBoard(boardId);

        assertTrue(!replies.isEmpty());
    }

    @Test
    public void 댓글_검색기능_테스트() {
        String inputValue = "test";
        List<ReplyDTO> replies = replyController.selectReplyBySearch(inputValue);

        assertTrue(!replies.isEmpty());
    }
}

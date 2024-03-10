package com.teamphoenix.ahub.reply.command;

import com.teamphoenix.ahub.reply.command.controller.ReplyController;
import com.teamphoenix.ahub.reply.command.dto.ReplyDTO;
import com.teamphoenix.ahub.reply.command.entity.Reply;
import com.teamphoenix.ahub.reply.command.repository.ReplyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JpaTest {

    private final ReplyRepository replyRepository;

    private final ModelMapper mapper;

    @Autowired
    public JpaTest(ReplyRepository replyRepository, ModelMapper mapper) {
        this.replyRepository = replyRepository;
        this.mapper = mapper;
    }

    @Test
    @Transactional
    public void 댓글_등록_테스트() {
        ReplyDTO registInfo = new ReplyDTO();

        LocalDate localDate = LocalDate.now();
        String dateFormat = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        List<Reply> beforeReplies = replyRepository.findAll();
        int firstReply = beforeReplies.get(beforeReplies.size()-1).getReplyId();

        registInfo.setPostId(2);
        registInfo.setReplyContent("test코드로 댓글추가 test하기~");
        registInfo.setReplyDate(dateFormat);
        registInfo.setReportAcceptance(0);
        registInfo.setUseAcceptance(1);
        registInfo.setMemberCode(2);
        replyRepository.save(mapper.map(registInfo, Reply.class));


        List<Reply> afterReplies = replyRepository.findAll();

        int foundReply = afterReplies.get(afterReplies.size()-1).getReplyId();
        assertEquals(firstReply+1,foundReply);
    }

    @Test
    @Transactional
    public void 댓글_수정_테스트() {
        int replyId = 2;
        Reply foundReply = replyRepository.findById(replyId).orElseThrow(IllegalAccessError::new);

        ReplyDTO registInfo = new ReplyDTO();
        registInfo.setReplyContent("test코드로 댓글 수정 test하기~");

        foundReply.setReplyContent(registInfo.getReplyContent());

        Reply afterReplies = replyRepository.findById(replyId).orElseThrow(IllegalAccessError::new);
        assertEquals(afterReplies.getReplyContent(),registInfo.getReplyContent());
    }

    @Test
    @Transactional
    public void 댓글_삭제_테스트() {
        int replyId = 27;
        Reply foundReply = replyRepository.findById(replyId).orElseThrow(IllegalAccessError::new);

        replyRepository.deleteById(replyId);

        assertTrue(replyRepository.findById(replyId).isEmpty());
    }

}

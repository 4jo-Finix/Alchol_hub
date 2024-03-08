package com.teamphoenix.ahub.reply.query.service;

import com.teamphoenix.ahub.reply.query.dto.ReplyDTO;
import com.teamphoenix.ahub.reply.query.entity.Reply;
import com.teamphoenix.ahub.reply.query.repository.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "QueryReplyService")
@Slf4j
public class ReplyServiceImpl implements ReplyService{

    private ReplyMapper replyMapper;
    private ModelMapper mapper;

    @Autowired
    public ReplyServiceImpl(ReplyMapper replyMapper, ModelMapper mapper) {
        this.replyMapper = replyMapper;
        this.mapper = mapper;
    }


    @Override
    public List<ReplyDTO> selectAllReplyInBoard(int postId) {
        List<Reply> replies = replyMapper.selectAllReplyInBoard(postId);
        replies.forEach(System.out::println);

        return replies.stream().map(reply -> mapper.map(reply, ReplyDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReplyDTO> selectReplyBySearch(String searchingValue) {
        List<Reply> replies = replyMapper.selectReplyBySearch(searchingValue);
        replies.forEach(System.out::println);

        return replies.stream().map(reply -> mapper.map(reply, ReplyDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReplyDTO> selectReplyByWriter(int memberId) {
        List<Reply> replies = replyMapper.selectReplyByWriter(memberId);
        replies.forEach(System.out::println);

        return replies.stream().map(reply -> mapper.map(reply, ReplyDTO.class)).collect(Collectors.toList());
    }
}

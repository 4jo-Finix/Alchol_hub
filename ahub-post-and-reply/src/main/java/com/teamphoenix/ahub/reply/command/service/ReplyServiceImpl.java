package com.teamphoenix.ahub.reply.command.service;

import com.teamphoenix.ahub.reply.command.client.ReplyServiceClient;
import com.teamphoenix.ahub.reply.command.dto.ReplyDTO;
import com.teamphoenix.ahub.reply.command.entity.Reply;
import com.teamphoenix.ahub.reply.command.repository.ReplyRepository;
import com.teamphoenix.ahub.reply.command.vo.MemberResponse;
import com.teamphoenix.ahub.reply.command.vo.ReplyWithMemberNameVo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "CommandReplyService")
@Slf4j
public class ReplyServiceImpl implements ReplyService{

    private final ModelMapper mapper;
    private final ReplyRepository replyRespository;
    private ReplyServiceClient replyServiceClient;

    @Autowired
    public ReplyServiceImpl(ModelMapper mapper, ReplyRepository replyRespository, ReplyServiceClient replyServiceClient) {
        this.mapper = mapper;
        this.replyRespository = replyRespository;
        this.replyServiceClient = replyServiceClient;
    }

    @Transactional
    @Override
    public List<ReplyDTO> registReply(ReplyDTO newReply) {
        LocalDate localDate = LocalDate.now();
        String dateFormat = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        newReply.setReplyDate(dateFormat);
        replyRespository.save(mapper.map(newReply, Reply.class));
        List<Reply> replies = replyRespository.findAll(Sort.by("replyId").descending());

        return replies.stream().map(reply -> mapper.map(reply, ReplyDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ReplyDTO modifyReply(ReplyDTO modifyInfo, int replyId) {
        Reply foundReply = replyRespository.findById(replyId).orElseThrow(IllegalAccessError::new);
        foundReply.setReplyContent(modifyInfo.getReplyContent());
        foundReply = replyRespository.findById(replyId).orElseThrow(IllegalAccessError::new);

        return mapper.map(foundReply, ReplyDTO.class);
    }

    @Transactional
    @Override
    public List<ReplyDTO> deleteReply(int replyId) {
       replyRespository.deleteById(replyId);

        List<Reply> replies = replyRespository.findAll(Sort.by("replyId").descending());

        return replies.stream().map(reply -> mapper.map(reply, ReplyDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ReplyWithMemberNameVo getReplyWithMemberNameById(int memberId) {
        MemberResponse memberName = replyServiceClient.getMemberName(memberId);
        System.out.println(memberName);

        Optional<Reply> reply = replyRespository.findById(memberId);
        System.out.println(reply);
        ReplyWithMemberNameVo replyWithMemberNameVo = mapper.map(reply, ReplyWithMemberNameVo.class);

        replyWithMemberNameVo.setMemberName(memberName.getMemberName());

        return replyWithMemberNameVo;
    }
}

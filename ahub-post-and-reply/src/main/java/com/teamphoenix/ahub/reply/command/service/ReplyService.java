package com.teamphoenix.ahub.reply.command.service;



import com.teamphoenix.ahub.reply.command.dto.ReplyDTO;
import com.teamphoenix.ahub.reply.command.vo.ReplyWithMemberNameVo;

import java.util.List;

public interface ReplyService {

    List<ReplyDTO> deleteReply(int replyId);
    ReplyDTO modifyReply(ReplyDTO modifyInfo, int replyId);
    List<ReplyDTO> registReply(ReplyDTO newReply);

    ReplyWithMemberNameVo getReplyWithMemberNameById(int memberId);
}

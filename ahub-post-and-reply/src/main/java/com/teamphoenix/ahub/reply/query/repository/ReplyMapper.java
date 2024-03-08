package com.teamphoenix.ahub.reply.query.repository;


import com.teamphoenix.ahub.reply.query.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<Reply> selectAllReply();

    List<Reply> selectAllReplyInBoard(int postId);

    List<Reply> selectReplyBySearch(String searchingValue);

    List<Reply> selectReplyByWriter(int memberId);
}

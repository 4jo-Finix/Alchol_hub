package com.teamphoenix.ahub.reply.query.dto;

import lombok.Data;

@Data
public class ReplyDTO {

    private int replyId;
    private int postId;
    private String replyContent;
    private String replyDate;
    private int reportAcceptance;
    private int useAcceptance;
    private int memberCode;
}

package com.teamphoenix.ahub.reply.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="reply")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reply {

    @Id
    @Column(name="reply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyId;

    @Column(name="post_id")
    private int postId;

    @Column(name="reply_content")
    private String replyContent;

    @Column(name="reply_date")
    private String replyDate;

    @Column(name="report_acceptance")
    private int reportAcceptance;

    @Column(name="use_acceptance")
    private int useAcceptance;

    @Column(name="member_code")
    private int memberCode;

}

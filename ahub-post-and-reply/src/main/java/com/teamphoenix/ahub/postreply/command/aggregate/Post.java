package com.teamphoenix.ahub.postreply.command.aggregate;//package com.teampheonix.postreply.command.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Post {

    @Id
    @Column(name="post_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int postId;

    @Column(name="post_title")
    private String postTitle;

    @Column(name="post_content")
    private String postContent;

    @Column(name="post_date")
    private LocalDateTime postDate;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="use_acceptance")
    private int useAcceptance;

    @Column(name="like_amount")
    private int likeAmount;

    @Column(name="reported_acceptance")
    private int reportedAcceptance;

    @Column(name="member_code")
    private int memberCode;

    @Column(name="post_modify_date")
    private LocalDateTime postModifyDate;


}

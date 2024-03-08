package com.teamphoenix.ahub.post.command.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {

    private int postId;
    private String postTitle;
    private String postContent;
    private String postDate;
    private int categoryId;
    private int useAcceptance;
    private int likeAmount;
    private int reportedAcceptance;
    private int memberCode;
    private String postModifyDate;
    private List<PostCategoryDTO> postCategories;

}


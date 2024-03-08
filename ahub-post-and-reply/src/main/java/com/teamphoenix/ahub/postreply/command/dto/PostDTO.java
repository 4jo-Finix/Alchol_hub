package com.teamphoenix.ahub.postreply.command.dto;

import java.time.LocalDateTime;
import java.util.Date;
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
    private LocalDateTime postDate;
    private int categoryId;
    private int useAcceptance;
    private int likeAmount;
    private int reportedAcceptance;
    private int memberCode;
    private LocalDateTime postModifyDate;
    private List<PostCategoryDTO> postCategories;

}


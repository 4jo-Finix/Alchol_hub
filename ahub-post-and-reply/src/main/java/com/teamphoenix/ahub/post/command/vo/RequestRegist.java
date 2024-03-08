package com.teamphoenix.ahub.post.command.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestRegist {
    private String postTitle;
    private String postContent;
    private int categoryId;
    private int postId;

}

package com.teamphoenix.ahub.postreply.command.vo;

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

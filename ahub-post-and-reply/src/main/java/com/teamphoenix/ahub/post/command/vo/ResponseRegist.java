package com.teamphoenix.ahub.post.command.vo;

import com.teamphoenix.ahub.post.command.dto.PostDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseRegist {
    private String message;
    private PostDTO result;
}

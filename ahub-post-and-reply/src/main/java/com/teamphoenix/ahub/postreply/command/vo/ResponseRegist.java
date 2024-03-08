package com.teamphoenix.ahub.postreply.command.vo;

import com.teamphoenix.ahub.postreply.command.dto.PostDTO;
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

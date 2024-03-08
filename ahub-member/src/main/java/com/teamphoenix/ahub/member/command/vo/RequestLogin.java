package com.teamphoenix.ahub.member.command.vo;

import lombok.Data;

@Data
public class RequestLogin {
    private String memberId;
    private String memberPwd;
}

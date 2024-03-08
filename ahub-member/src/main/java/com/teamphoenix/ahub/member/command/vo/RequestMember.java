package com.teamphoenix.ahub.member.command.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestMember {

        private String memberId;
        private String memberPwd;
        private String memberName;
        private String memberEmail;
        private String memberAddr;
        private String memberPhone;
}

package com.teamphoenix.ahub.member.query.vo;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MyProfileResponseMember {
    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberAddr;
    private String memberPhone;
    private LocalDateTime restrictStartDate;
}


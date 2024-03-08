package com.teamphoenix.ahub.member.query.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {
    private int memberCode;
    private String memberId;
    private String memberName;
    private String memberPwd;
    private String memberEmail;
    private String memberAddr;
    private String memberPhone;
    private int blacklistStatus;

    private LocalDateTime restrictStartDate;
    private LocalDateTime restrictEndDate;
    private int loginFailCount;
    private int accessAcceptancce;
    private int withdrawalAcceptance;
    private int memberCategoryId;
    /* 설명. 전체 회원 조회용(관리자) */
    public MemberDTO(int memberCode, String memberId, String memberName, String memberPwd, String memberEmail, String memberAddr, String memberPhone, int blacklistStatus) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPwd = memberPwd;
        this.memberEmail = memberEmail;
        this.memberAddr = memberAddr;
        this.memberPhone = memberPhone;
        this.blacklistStatus = blacklistStatus;
    }

    /* 설명. 회원 프로필 조회용 */
    public MemberDTO(String memberId, String memberName, String memberPwd, String memberEmail, String memberAddr, String memberPhone, LocalDateTime restrictStartDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPwd = memberPwd;
        this.memberEmail = memberEmail;
        this.memberAddr = memberAddr;
        this.memberPhone = memberPhone;
        this.restrictStartDate = restrictStartDate;
    }

    public MemberDTO(String memberId) {
        this.memberId = memberId;
    }

    /* 설명. 회원 로그인 조회용 */
    public MemberDTO(String memberId, String memberPwd) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
    }
}
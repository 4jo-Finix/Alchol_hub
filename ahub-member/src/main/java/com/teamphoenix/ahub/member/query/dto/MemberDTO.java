package com.teamphoenix.ahub.member.query.dto;

import jakarta.persistence.Column;
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
    private String blacklistStatus;
    private LocalDateTime restrictStartDate;
    private LocalDateTime restrictEndDate;
    private int loginFailCount;
    private String accessAcceptance;
    private String withdrawalAcceptance;
    private int memberCategoryId;
    private String memberIntroduction;
    private String memberSnsId;
    private String snsProvider;

    /* 설명. 전체 회원 조회용(관리자) */
    public MemberDTO(int memberCode, String memberId, String memberName, String memberPwd, String memberEmail, String memberAddr, String memberPhone, String blacklistStatus, int memberCategoryId) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPwd = memberPwd;
        this.memberEmail = memberEmail;
        this.memberAddr = memberAddr;
        this.memberPhone = memberPhone;
        this.blacklistStatus = blacklistStatus;
        this.memberCategoryId = memberCategoryId;
    }

    /* 설명. 회원 프로필 조회용 */
    public MemberDTO(String memberId, String memberName, String memberEmail, String memberAddr, String memberPhone) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberAddr = memberAddr;
        this.memberPhone = memberPhone;
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
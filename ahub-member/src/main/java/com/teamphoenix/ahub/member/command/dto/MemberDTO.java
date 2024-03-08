package com.teamphoenix.ahub.member.command.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {
    private int memberCode;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String memberEmail;
    private String memberAddr;
    private String memberPhone;
    private LocalDateTime restrictStartDate;
    private int memberCategoryId;

    /* T1 - 회원 가입 테스트 용 생성자 */
    public MemberDTO(String memberId, String memberPwd, String memberName, String memberEmail, String memberAddr, String memberPhone, LocalDateTime restrictStartDate, int memberCategoryId) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberAddr = memberAddr;
        this.memberPhone = memberPhone;
        this.restrictStartDate = restrictStartDate;
        this.memberCategoryId = memberCategoryId;
    }

    /* T2 - 회원 정보 수정 테스트용 생성자 */

    public MemberDTO(String memberId, String memberPwd, String memberName, String memberEmail, String memberAddr, String memberPhone) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberAddr = memberAddr;
        this.memberPhone = memberPhone;
    }
}


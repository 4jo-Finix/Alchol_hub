package com.teamphoenix.ahub.member.command.aggregate;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_code")
    private int memberCode;
    @Column(name = "member_id")
    private String memberId;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_pwd")
    private String memberPwd;
    @Column(name = "member_email")
    private String memberEmail;
    @Column(name = "member_addr")
    private String memberAddr;
    @Column(name = "member_phone")
    private String memberPhone;
    @Column(name = "blacklist_status")
    private int blacklistStatus;
    @Column(name = "restrict_start_date")
    private LocalDateTime restrictStartDate;
    @Column(name = "restrict_end_date")
    private LocalDateTime restrictEndDate;
    @Column(name = "login_fail_count")
    private int loginFailCount;
    @Column(name = "access_acceptance")
    private int accessAcceptance;
    @Column(name = "withdrawal_acceptance")
    private int withdrawalAcceptance;
    @Column(name = "member_category_id")
    private int memberCategoryId;

}

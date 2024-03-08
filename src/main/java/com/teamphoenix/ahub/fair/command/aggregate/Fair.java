package com.teamphoenix.ahub.fair.command.aggregate;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "fair")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Fair {

    @Id
    @Column(name = "fair_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fairId;

    @Column(name = "fair_title")
    private String fairTitle;

    @Column(name = "fair_content")
    private String fairContent;

    @Column(name = "fair_writedate", columnDefinition = "default NOW()")
    @Temporal(TemporalType.TIMESTAMP)
    private java.time.LocalDateTime fairWritedate;

    @Column(name = "use_acceptance")
    private int useAcceptance;

    @Column(name = "member_code", columnDefinition = "default 1")
    private int memberCode;


    /* Fair 게시글 등록용 생성자 */

    public Fair(String fairTitle, String fairContent, LocalDateTime fairWritedate, int useAcceptance, int memberCode) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
    }

    /* 게시글 수정을 위한 setter ( title, content, writedate만 ) */
    public void setFairTitle(String fairTitle) {
        this.fairTitle = fairTitle;
    }

    public void setFairContent(String fairContent) {
        this.fairContent = fairContent;
    }

    public void setFairWritedate(LocalDateTime fairWritedate) {
        this.fairWritedate = fairWritedate;
    }
}

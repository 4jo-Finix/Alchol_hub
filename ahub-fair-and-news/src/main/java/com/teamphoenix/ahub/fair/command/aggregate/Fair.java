package com.teamphoenix.ahub.fair.command.aggregate;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
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

    @Column(name = "fair_writedate")
    @Temporal(TemporalType.TIMESTAMP)
    private java.time.LocalDateTime fairWritedate;

    @Column(name = "use_acceptance")
    private int useAcceptance;

    @Column(name = "fair_tag1")
    private String fairTag1;

    @Column(name = "fair_tag2")
    private String fairTag2;

    @Column(name = "fair_tag3")
    private String fairTag3;

    @Column(name = "fair_startdate")
    private LocalDate fairStartdate;

    @Column(name = "fair_enddate")
    private LocalDate fairEnddate;

    @Column(name = "fair_location")
    private String fairLocation;

    @Column(name = "fair_area")
    private String fairArea;

    @Column(name = "member_code")
    private int memberCode;


    /* Fair 게시글 등록용 생성자 */

    public Fair(String fairTitle, String fairContent, LocalDateTime fairWritedate,
                int useAcceptance, String fairTag1, String fairTag2, String fairTag3,
                LocalDate fairStartdate, LocalDate fairEnddate, String fairLocation,
                String fairArea, int memberCode) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.fairTag1 = fairTag1;
        this.fairTag2 = fairTag2;
        this.fairTag3 = fairTag3;
        this.fairStartdate = fairStartdate;
        this.fairEnddate = fairEnddate;
        this.fairLocation = fairLocation;
        this.fairArea = fairArea;
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

    public void setFairTag1(String fairTag1) {
        this.fairTag1 = fairTag1;
    }

    public void setFairTag2(String fairTag2) {
        this.fairTag2 = fairTag2;
    }

    public void setFairTag3(String fairTag3) {
        this.fairTag3 = fairTag3;
    }

    public void setFairStartdate(LocalDate fairStartdate) {
        this.fairStartdate = fairStartdate;
    }

    public void setFairEnddate(LocalDate fairEnddate) {
        this.fairEnddate = fairEnddate;
    }

    public void setFairLocation(String fairLocation) {
        this.fairLocation = fairLocation;
    }

    public void setFairArea(String fairArea) {
        this.fairArea = fairArea;
    }
}



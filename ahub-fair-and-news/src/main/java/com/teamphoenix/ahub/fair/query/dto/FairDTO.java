package com.teamphoenix.ahub.fair.query.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FairDTO {

    private int fairId;
    private String fairTitle;
    private String fairContent;
    private LocalDateTime fairWritedate;
    private int useAcceptance;
    private int memberCode;  // fk로 불러온 회원 코드와 매치
    private String writerId;
    private String fairTag1;
    private String fairTag2;
    private String fairTag3;
    private LocalDate fairStartdate;
    private LocalDate fairEnddate;
    private String fairLocation;
    private String fairArea;

    public FairDTO() {
    }

    public FairDTO(String fairTitle, String fairContent, String writerId) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.writerId = writerId;
    }

    public FairDTO(int fairId, String fairTitle, String fairContent,
                   LocalDateTime fairWritedate, int useAcceptance, int memberCode) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
    }

    public FairDTO(int fairId, String fairTitle, String fairContent,
                   LocalDateTime fairWritedate, int useAcceptance, int memberCode, String writerId) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
        this.writerId = writerId;
    }



    public int getFairId() {
        return fairId;
    }

    public void setFairId(int fairId) {
        this.fairId = fairId;
    }

    public String getFairTitle() {
        return fairTitle;
    }

    public void setFairTitle(String fairTitle) {
        this.fairTitle = fairTitle;
    }

    public String getFairContent() {
        return fairContent;
    }

    public void setFairContent(String fairContent) {
        this.fairContent = fairContent;
    }

    public LocalDateTime getFairWritedate() {
        return fairWritedate;
    }

    public void setFairWritedate(LocalDateTime fairWritedate) {
        this.fairWritedate = fairWritedate;
    }

    public int getUseAcceptance() {
        return useAcceptance;
    }

    public void setUseAcceptance(int useAcceptance) {
        this.useAcceptance = useAcceptance;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getFairTag1() {
        return fairTag1;
    }

    public void setFairTag1(String fairTag1) {
        this.fairTag1 = fairTag1;
    }

    public String getFairTag2() {
        return fairTag2;
    }

    public void setFairTag2(String fairTag2) {
        this.fairTag2 = fairTag2;
    }

    public String getFairTag3() {
        return fairTag3;
    }

    public void setFairTag3(String fairTag3) {
        this.fairTag3 = fairTag3;
    }

    public LocalDate getFairStartdate() {
        return fairStartdate;
    }

    public void setFairStartdate(LocalDate fairStartdate) {
        this.fairStartdate = fairStartdate;
    }

    public LocalDate getFairEnddate() {
        return fairEnddate;
    }

    public void setFairEnddate(LocalDate fairEnddate) {
        this.fairEnddate = fairEnddate;
    }

    public String getFairLocation() {
        return fairLocation;
    }

    public void setFairLocation(String fairLocation) {
        this.fairLocation = fairLocation;
    }

    public String getFairArea() {
        return fairArea;
    }

    public void setFairArea(String fairArea) {
        this.fairArea = fairArea;
    }

    @Override
    public String toString() {
        return "FairDTO{" +
                "fairId=" + fairId +
                ", fairTitle='" + fairTitle + '\'' +
                ", fairContent='" + fairContent + '\'' +
                ", fairWritedate=" + fairWritedate +
                ", useAcceptance=" + useAcceptance +
                ", memberCode=" + memberCode +
                ", writerId='" + writerId + '\'' +
                ", fairTag1='" + fairTag1 + '\'' +
                ", fairTag2='" + fairTag2 + '\'' +
                ", fairTag3='" + fairTag3 + '\'' +
                ", fairStartdate=" + fairStartdate +
                ", fairEnddate=" + fairEnddate +
                ", fairLocation='" + fairLocation + '\'' +
                ", fairArea='" + fairArea + '\'' +
                '}';
    }
}
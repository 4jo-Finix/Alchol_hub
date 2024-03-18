package com.teamphoenix.ahub.fair.command.vo;

import java.time.LocalDate;

public class RequestModify {
    private String fairTitle;
    private String fairContent;
    private String fairLocation;
    private String fairArea;
    private LocalDate fairStartdate;
    private LocalDate fairEnddate;
    private String fairTag1;
    private String fairTag2;
    private String fairTag3;

    public RequestModify() {
    }

    public RequestModify(String fairTitle, String fairContent, String fairLocation,
                         String fairArea, LocalDate fairStartdate, LocalDate fairEnddate,
                         String fairTag1, String fairTag2, String fairTag3) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairLocation = fairLocation;
        this.fairArea = fairArea;
        this.fairStartdate = fairStartdate;
        this.fairEnddate = fairEnddate;
        this.fairTag1 = fairTag1;
        this.fairTag2 = fairTag2;
        this.fairTag3 = fairTag3;
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

    public LocalDate getFairStartdate() {
        return fairStartdate;
    }

    public void setFairStartdate(LocalDate fairStarddate) {
        this.fairStartdate = fairStarddate;
    }

    public LocalDate getFairEnddate() {
        return fairEnddate;
    }

    public void setFairEnddate(LocalDate fairEnddate) {
        this.fairEnddate = fairEnddate;
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

    @Override
    public String toString() {
        return "RequestModify{" +
                "fairTitle='" + fairTitle + '\'' +
                ", fairContent='" + fairContent + '\'' +
                ", fairLocation='" + fairLocation + '\'' +
                ", fairArea='" + fairArea + '\'' +
                ", fairStartdate=" + fairStartdate +
                ", fairEnddate=" + fairEnddate +
                ", fairTag1='" + fairTag1 + '\'' +
                ", fairTag2='" + fairTag2 + '\'' +
                ", fairTag3='" + fairTag3 + '\'' +
                '}';
    }
}

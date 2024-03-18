package com.teamphoenix.ahub.fair.command.vo;

import java.time.LocalDate;
import java.util.List;

/* 게시글 작성시 화면으로부터 전달 받을 데이터들을 받는 클래스 */
public class RequestRegist {

    private String fairTitle;
    private String fairContent;
    private String fairStartdate;
    private String fairEnddate;
    private String fairTag1;
    private String fairTag2;
    private String fairTag3;
    private String fairLocation;
    private String fairArea;

    public RequestRegist() {
    }

    public RequestRegist(String fairTitle, String fairContent, String fairStartdate, String fairEnddate,
                         String fairTag1, String fairTag2, String fairTag3, String fairLocation, String fairArea) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairStartdate = fairStartdate;
        this.fairEnddate = fairEnddate;
        this.fairTag1 = fairTag1;
        this.fairTag2 = fairTag2;
        this.fairTag3 = fairTag3;
        this.fairLocation = fairLocation;
        this.fairArea = fairArea;
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

    public String getFairStartdate() {
        return fairStartdate;
    }

    public void setFairStartdate(String fairStartDate) {
        this.fairStartdate = fairStartDate;
    }

    public String getFairEnddate() {
        return fairEnddate;
    }

    public void setFairEnddate(String fairEndDate) {
        this.fairEnddate = fairEndDate;
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
        return "RequestRegist{" +
                "fairTitle='" + fairTitle + '\'' +
                ", fairContent='" + fairContent + '\'' +
                ", fairStartDate=" + fairStartdate +
                ", fairEndDate=" + fairEnddate +
                ", fairTag1='" + fairTag1 + '\'' +
                ", fairTag2='" + fairTag2 + '\'' +
                ", fairTag3='" + fairTag3 + '\'' +
                ", fairLocation='" + fairLocation + '\'' +
                ", fairArea='" + fairArea + '\'' +
                '}';
    }
}

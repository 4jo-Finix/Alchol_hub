package com.teamphoenix.ahub.fair.command.vo;

import java.time.LocalDate;
import java.util.List;

//ResponseStatus로 화면에 반환할 값들을 모아둔 VO클래스
public class ResponsePost {

    private String fairTitle;
    private String fairContent;
    private String fairWriteDate;
    private String fairTag1;
    private String fairTag2;
    private String fairTag3;
    private LocalDate fairStartdate;
    private LocalDate faireEnddate;
    private String fairLocation;
    private String fairWriterId;
    private String thumPictureUrl;
    private List<String> contentPictures;

    public ResponsePost() {
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

    public String getFairWriteDate() {
        return fairWriteDate;
    }

    public void setFairWriteDate(String fairWriteDate) {
        this.fairWriteDate = fairWriteDate;
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

    public LocalDate getFaireEnddate() {
        return faireEnddate;
    }

    public void setFaireEnddate(LocalDate faireEnddate) {
        this.faireEnddate = faireEnddate;
    }

    public String getFairLocation() {
        return fairLocation;
    }

    public void setFairLocation(String fairLocation) {
        this.fairLocation = fairLocation;
    }

    public String getFairWriterId() {
        return fairWriterId;
    }

    public void setFairWriterId(String fairWriterId) {
        this.fairWriterId = fairWriterId;
    }

    public String getThumPictureUrl() {
        return thumPictureUrl;
    }

    public void setThumPictureUrl(String thumPictureUrl) {
        this.thumPictureUrl = thumPictureUrl;
    }

    public List<String> getContentPictures() {
        return contentPictures;
    }

    public void setContentPictures(List<String> contentPictures) {
        this.contentPictures = contentPictures;
    }

    public ResponsePost(String fairTitle, String fairContent, String fairWriteDate,
                        String fairTag1, String fairTag2, String fairTag3, LocalDate fairStartdate,
                        LocalDate faireEnddate, String fairLocation, String fairWriterId,
                        String thumPictureUrl, List<String> contentPictures) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWriteDate = fairWriteDate;
        this.fairTag1 = fairTag1;
        this.fairTag2 = fairTag2;
        this.fairTag3 = fairTag3;
        this.fairStartdate = fairStartdate;
        this.faireEnddate = faireEnddate;
        this.fairLocation = fairLocation;
        this.fairWriterId = fairWriterId;
        this.thumPictureUrl = thumPictureUrl;
        this.contentPictures = contentPictures;
    }
}

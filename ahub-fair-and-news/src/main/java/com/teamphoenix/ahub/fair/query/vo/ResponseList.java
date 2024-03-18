package com.teamphoenix.ahub.fair.query.vo;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseList {

    private int fairId;
    private String fairTitle;
    private String fairContent;
    private String fairStartdate;
    private String fairEnddate;
    private String fairLocation;
    private String fairTag1;
    private String fairTag2;
    private String fairTag3;
    private String writerId;
    private String fairWritedate;
    private String thumImage;
    private List<String> contentImages;

    public ResponseList() {
    }

    public ResponseList(int fairId, String fairTitle, String fairConent,
                        String fairStartdate, String fairEnddate, String fairLocation, String fairTag1,
                        String fairTag2, String fairTag3, String writerId, String fairWritedate) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairConent;
        this.fairStartdate = fairStartdate;
        this.fairEnddate = fairEnddate;
        this.fairLocation = fairLocation;
        this.fairTag1 = fairTag1;
        this.fairTag2 = fairTag2;
        this.fairTag3 = fairTag3;
        this.writerId = writerId;
        this.fairWritedate = fairWritedate;
    }

    public ResponseList(int fairId, String fairTitle, String fairContent, String fairStartdate,
                        String fairEnddate, String fairLocation, String fairTag1, String fairTag2, String fairTag3,
                        String writerId, String fairWritedate, String thumImage, List<String> contentImages) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairStartdate = fairStartdate;
        this.fairEnddate = fairEnddate;
        this.fairLocation = fairLocation;
        this.fairTag1 = fairTag1;
        this.fairTag2 = fairTag2;
        this.fairTag3 = fairTag3;
        this.writerId = writerId;
        this.fairWritedate = fairWritedate;
        this.thumImage = thumImage;
        this.contentImages = contentImages;
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

    public void setFairContent(String fairConent) {
        this.fairContent = fairConent;
    }

    public String getFairStartdate() {
        return fairStartdate;
    }

    public void setFairStartdate(String fairStartdate) {
        this.fairStartdate = fairStartdate;
    }

    public String getFairEnddate() {
        return fairEnddate;
    }

    public void setFairEnddate(String fairEnddate) {
        this.fairEnddate = fairEnddate;
    }

    public String getFairLocation() {
        return fairLocation;
    }

    public void setFairLocation(String fairLocation) {
        this.fairLocation = fairLocation;
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

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getFairWritedate() {
        return fairWritedate;
    }

    public void setFairWritedate(String fairWritedate) {
        this.fairWritedate = fairWritedate;
    }

    public int getFairId() {
        return fairId;
    }

    public void setFairId(int fairId) {
        this.fairId = fairId;
    }

    public String getThumImage() {
        return thumImage;
    }

    public void setThumImage(String thumImage) {
        this.thumImage = thumImage;
    }

    public List<String> getContentImages() {
        return contentImages;
    }

    public void setContentImages(List<String> contentImages) {
        this.contentImages = contentImages;
    }

    @Override
    public String toString() {
        return "ResponseList{" +
                "fairId=" + fairId +
                ", fairTitle='" + fairTitle + '\'' +
                ", fairContent='" + fairContent + '\'' +
                ", fairStartdate='" + fairStartdate + '\'' +
                ", fairEnddate='" + fairEnddate + '\'' +
                ", fairLocation='" + fairLocation + '\'' +
                ", fairTag1='" + fairTag1 + '\'' +
                ", fairTag2='" + fairTag2 + '\'' +
                ", fairTag3='" + fairTag3 + '\'' +
                ", writerId='" + writerId + '\'' +
                ", fairWritedate='" + fairWritedate + '\'' +
                ", thumImage='" + thumImage + '\'' +
                ", contentImages=" + contentImages +
                '}';
    }
}

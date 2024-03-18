package com.teamphoenix.ahub.fair.command.dto;

import com.teamphoenix.ahub.fair.command.vo.ResponseMember;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class FairDTO {

    private int fairId;
    private String fairTitle;
    private String fairContent;
    private java.time.LocalDateTime fairWritedate;
    private int useAcceptance;
    private int memberCode;
    private LocalDate fairStartdate;
    private LocalDate fairEnddate;
    private String fairTag1;
    private String fairTag2;
    private String fairTag3;
    private String fairLocation;
    private String fairArea;
    private MultipartFile thumImage;
    private List<MultipartFile> contentImages;
    private ResponseMember writerInfo;

    public FairDTO() {
    }

    public FairDTO(String fairTitle, String fairContent, LocalDateTime fairWritedate, int useAcceptance, int memberCode) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
    }

    public FairDTO(int fairId, String fairTitle, String fairContent, LocalDateTime fairWritedate, int useAcceptance, int memberCode) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
    }

    public FairDTO(int fairId, String fairTitle, String fairContent, LocalDateTime fairWritedate, int useAcceptance, int memberCode, ResponseMember writerInfo) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
        this.writerInfo = writerInfo;
    }

    public FairDTO(int fairId, String fairTitle, String fairContent, LocalDateTime fairWritedate,
                   LocalDate fairStartdate, LocalDate fairEnddate, String fairTag1, String fairTag2,
                   String fairTag3, String fairLocation, int memberCode) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.fairStartdate = fairStartdate;
        this.fairEnddate = fairEnddate;
        this.fairTag1 = fairTag1;
        this.fairTag2 = fairTag2;
        this.fairTag3 = fairTag3;
        this.fairLocation = fairLocation;
        this.memberCode = memberCode;
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

    public ResponseMember getWriterInfo() {
        return writerInfo;
    }

    public void setWriterInfo(ResponseMember writerInfo) {
        this.writerInfo = writerInfo;
    }

    public LocalDate getFairStartdate() {
        return fairStartdate;
    }

    public void setFairStartdate(LocalDate fairStartDate) {
        this.fairStartdate = fairStartDate;
    }

    public LocalDate getFairEnddate() {
        return fairEnddate;
    }

    public void setFairEnddate(LocalDate fairEndDate) {
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

    public MultipartFile getThumImage() {
        return thumImage;
    }

    public void setThumImage(MultipartFile thumImage) {
        this.thumImage = thumImage;
    }

    public List<MultipartFile> getContentImages() {
        return contentImages;
    }

    public void setContentImages(List<MultipartFile> contentImages) {
        this.contentImages = contentImages;
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
                ", fairStartDate=" + fairStartdate +
                ", fairEndDate=" + fairEnddate +
                ", fairTag1='" + fairTag1 + '\'' +
                ", fairTag2='" + fairTag2 + '\'' +
                ", fairTag3='" + fairTag3 + '\'' +
                ", fairLocation='" + fairLocation + '\'' +
                ", fairArea='" + fairArea + '\'' +
                ", writerInfo=" + writerInfo +
                '}';
    }
}

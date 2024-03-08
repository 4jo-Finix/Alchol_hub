package com.teamphoenix.ahub.post.query.dto;

import java.time.LocalDateTime;

public class PostDTO {

    private int useAcceptance;
    private int likeAmount;
    private int reportedAcceptance;
    private int memberCode;
    private String postModifyDate;
    private int postId;
    private String postTitle;
    private String postContent;
    private String postDate;
    private int categoryId;

    public PostDTO() {
    }

    public PostDTO(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public PostDTO(int postId, String postTitle, String postContent, String postDate, int categoryId, int memberCode) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postDate = postDate;
        this.categoryId =  categoryId;
        this.memberCode = memberCode;
    }

    public PostDTO(int useAcceptance, int likeAmount, int reportedAcceptance, int memberCode, String postModifyDate, int postId, String postTitle, String postContent, String postDate, int categoryId) {
        this.useAcceptance = useAcceptance;
        this.likeAmount = likeAmount;
        this.reportedAcceptance = reportedAcceptance;
        this.memberCode = memberCode;
        this.postModifyDate = postModifyDate;
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postDate = postDate;
        this.categoryId = categoryId;
    }

    public int getUseAcceptance() {
        return useAcceptance;
    }

    public void setUseAcceptance(int useAcceptance) {
        this.useAcceptance = useAcceptance;
    }

    public int getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount) {
        this.likeAmount = likeAmount;
    }

    public int getReportedAcceptance() {
        return reportedAcceptance;
    }

    public void setReportedAcceptance(int reportedAcceptance) {
        this.reportedAcceptance = reportedAcceptance;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getPostModifyDate() {
        return postModifyDate;
    }

    public void setPostModifyDate(String postModifyDate) {
        this.postModifyDate = postModifyDate;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "useAcceptance=" + useAcceptance +
                ", likeAmount=" + likeAmount +
                ", reportedAcceptance=" + reportedAcceptance +
                ", memberCode=" + memberCode +
                ", postModifyDate=" + postModifyDate +
                ", postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postDate=" + postDate +
                ", categoryId=" + categoryId +
                '}';
    }
}
package com.teamphoenix.ahub.post.query.dto;

import java.time.LocalDateTime;

public class PostDTO {

    private int postId;
    private String postTitle;
    private String postContent;
    private LocalDateTime postDate;
    private int categoryId;
    private int memberCode;  // fk로 불러온 회원 코드와 매치

    public PostDTO() {
    }

    /* 테스트 케이스(T2) 작성을 위한 DTO 생성자 추가 */
    public PostDTO(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
    }
    public PostDTO(int postId, String postTitle, String postContent, LocalDateTime postDate, int categoryId, int memberCode) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postDate = postDate;
        this.categoryId =  categoryId;
        this.memberCode = memberCode;
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

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId =categoryId;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postDate=" + postDate +
                ", memberCode=" + memberCode +
                ", categoryId=" + categoryId +
                '}';
    }
}




package com.teamphoenix.ahub.post.query.vo;

import java.time.LocalDateTime;

public class ResponseList {

    private int postId;
    private String postTitle;
    private LocalDateTime postDate;

    public ResponseList() {
    }

    public ResponseList(int postId, String postTitle, LocalDateTime postDate) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postDate = postDate;
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

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }
}


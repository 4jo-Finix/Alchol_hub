package com.teamphoenix.ahub.post.query.vo;

public class RequestRegist {
    private String postTitle;
    private String postContent;

    public RequestRegist() {
    }

    public RequestRegist(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
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


    @Override
    public String toString() {
        return "RegistPostInfo{" +
                "postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                '}';
    }
}


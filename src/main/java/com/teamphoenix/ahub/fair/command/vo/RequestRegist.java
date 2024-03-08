package com.teamphoenix.ahub.fair.command.vo;

public class RequestRegist {

    private String fairTitle;
    private String fairContent;

    public RequestRegist() {
    }

    public RequestRegist(String fairTitle, String fairContent) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
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


    @Override
    public String toString() {
        return "RegistFairInfo{" +
                "fairTitle='" + fairTitle + '\'' +
                ", fairContent='" + fairContent + '\'' +
                '}';
    }
}

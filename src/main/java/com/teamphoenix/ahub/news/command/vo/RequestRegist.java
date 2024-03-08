package com.teamphoenix.ahub.news.command.vo;

public class RequestRegist {

    private String newsTitle;
    private String newsContent;

    public RequestRegist() {
    }

    public RequestRegist(String newsTitle, String newsContent) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }


    @Override
    public String toString() {
        return "RegistNewsInfo{" +
                "newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}';
    }
}

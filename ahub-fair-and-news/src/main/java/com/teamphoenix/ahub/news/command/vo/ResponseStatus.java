package com.teamphoenix.ahub.news.command.vo;

import com.teamphoenix.ahub.news.command.dto.NewsDTO;

public class ResponseStatus {

    private String code;
    private String message;
    private String url;
    private NewsDTO result;

    public ResponseStatus() {}

    public ResponseStatus(String code, String message, String url, NewsDTO result) {
        this.code = code;
        this.message = message;
        this.url = url;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NewsDTO getResult() {
        return result;
    }

    public void setResult(NewsDTO result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseStatus{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", result=" + result +
                '}';
    }
}

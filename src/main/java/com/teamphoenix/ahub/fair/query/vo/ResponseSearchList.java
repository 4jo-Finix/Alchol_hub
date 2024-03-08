package com.teamphoenix.ahub.fair.query.vo;

import java.util.List;

public class ResponseSearchList {

    private String code;
    private String message;
    private String url;
    private List<ResponseList> result;

    public ResponseSearchList() {}

    public ResponseSearchList(String code, String message, String url, List<ResponseList> result) {
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

    public List<ResponseList> getResult() {
        return result;
    }

    public void setResult(List<ResponseList> result) {
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

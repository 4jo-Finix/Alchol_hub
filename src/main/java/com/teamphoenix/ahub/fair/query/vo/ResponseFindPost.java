package com.teamphoenix.ahub.fair.query.vo;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;

import java.util.List;

public class ResponseFindPost {

    private String code;
    private String message;
    private String url;
    private FairDTO result;

    public ResponseFindPost() {
    }

    public ResponseFindPost(String code, String message, String url, FairDTO result) {
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

    public FairDTO getResult() {
        return result;
    }

    public void setResult(FairDTO result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseFindPost{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", result=" + result +
                '}';
    }
}

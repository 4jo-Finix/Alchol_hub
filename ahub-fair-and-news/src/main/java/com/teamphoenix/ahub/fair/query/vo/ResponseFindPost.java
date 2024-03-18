package com.teamphoenix.ahub.fair.query.vo;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;

public class ResponseFindPost {

    private String code;
    private String message;
    private String url;
    private ResponseList result;
    private String writerId;

    public ResponseFindPost() {
    }

    public ResponseFindPost(String code, String message, String url, ResponseList result) {
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

    public ResponseList getResult() {
        return result;
    }

    public void setResult(ResponseList result) {
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

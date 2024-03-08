package com.teamphoenix.ahub.fair.command.vo;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;

public class ResponseStatus {

    private String code;
    private String message;
    private String url;
    private FairDTO result;

    public ResponseStatus() {}

    public ResponseStatus(String code, String message, String url, FairDTO result) {
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
        return "ResponseStatus{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", result=" + result +
                '}';
    }
}

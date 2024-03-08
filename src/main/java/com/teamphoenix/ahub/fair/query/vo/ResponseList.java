package com.teamphoenix.ahub.fair.query.vo;

import java.time.LocalDateTime;

public class ResponseList {

    private int fairId;
    private String fairTitle;
    private java.time.LocalDateTime fairWritedate;

    public ResponseList() {
    }

    public ResponseList(int fairId, String fairTitle, LocalDateTime fairWritedate) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairWritedate = fairWritedate;
    }

    public int getFairId() {
        return fairId;
    }

    public void setFairId(int fairId) {
        this.fairId = fairId;
    }

    public String getFairTitle() {
        return fairTitle;
    }

    public void setFairTitle(String fairTitle) {
        this.fairTitle = fairTitle;
    }

    public LocalDateTime getFairWritedate() {
        return fairWritedate;
    }

    public void setFairWritedate(LocalDateTime fairWritedate) {
        this.fairWritedate = fairWritedate;
    }
}

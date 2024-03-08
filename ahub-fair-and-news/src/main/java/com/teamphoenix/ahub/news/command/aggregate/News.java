package com.teamphoenix.ahub.news.command.aggregate;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class News {

    @Id
    @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsId;

    @Column(name = "news_title")
    private String newsTitle;

    @Column(name = "news_content")
    private String newsContent;

    @Column(name = "news_writedate", columnDefinition = "default NOW()")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime newsWritedate;

    @Column(name = "use_acceptance")
    private int useAcceptance;

    @Column(name = "member_code", columnDefinition = "default 1")
    private int memberCode;


    /* News 게시글 등록용 생성자 */

    public News(String newsTitle, String newsContent, LocalDateTime newsWritedate, int useAcceptance, int memberCode) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsWritedate = newsWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
    }

    /* 게시글 수정을 위한 setter ( title, content, writedate만 ) */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public void setNewsWritedate(LocalDateTime newsWritedate) {
        this.newsWritedate = newsWritedate;
    }

    public void setUseAcceptance(int useAcceptance) {
        this.useAcceptance = useAcceptance;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsWritedate=" + newsWritedate +
                ", useAcceptance=" + useAcceptance +
                ", memberCode=" + memberCode +
                '}';
    }
}

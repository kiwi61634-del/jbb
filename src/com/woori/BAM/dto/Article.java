package com.woori.BAM.dto;

public class Article {
    private int id;
    private String title;
    private String body;
    private String regDate;
    private int click;

    public Article(int lastArticleID, String title, String body, String regDate, int click) {  //생성자를 통해서 초기화 작업
        this.id = lastArticleID;
        this.title = title;
        this.body = body;
        this.regDate = regDate;
        this.click = click;
    }

    public void increaseViewCnt() {
        this.click++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }
}

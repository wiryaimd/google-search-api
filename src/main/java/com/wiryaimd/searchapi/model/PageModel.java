package com.wiryaimd.searchapi.model;

public class PageModel {

    private String title;
    private String url;
    private String paragraph;

    public PageModel() {
    }

    public PageModel(String title, String url, String paragraph) {
        this.title = title;
        this.url = url;
        this.paragraph = paragraph;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getParagraph() {
        return paragraph;
    }
}

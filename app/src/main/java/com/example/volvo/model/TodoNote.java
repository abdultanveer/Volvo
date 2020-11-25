package com.example.volvo.model;

public class TodoNote {
    String title;
    String subTitle;

    public TodoNote(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return
                 title + '\n' +
                 subTitle;
    }
}

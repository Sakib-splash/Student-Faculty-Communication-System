package com.example.login.ui.notice;

public class NoticeData {
    String title, image, date, time, key, courseName;  // Added courseName field

    public NoticeData() {
    }

    public NoticeData(String title, String image, String date, String time, String key, String courseName) {
        this.title = title;
        this.image = image;
        this.date = date;
        this.time = time;
        this.key = key;
        this.courseName = courseName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

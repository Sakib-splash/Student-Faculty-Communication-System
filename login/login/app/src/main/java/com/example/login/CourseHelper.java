package com.example.login;

public class CourseHelper {

    String Course_name, for_batch, Course_code;

    public CourseHelper(String course_name, String for_batch, String course_code) {
        Course_name = course_name;
        this.for_batch = for_batch;
        Course_code = course_code;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    public String getFor_batch() {
        return for_batch;
    }

    public void setFor_batch(String for_batch) {
        this.for_batch = for_batch;
    }

    public String getCourse_code() {
        return Course_code;
    }

    public void setCourse_code(String course_code) {
        Course_code = course_code;
    }
}

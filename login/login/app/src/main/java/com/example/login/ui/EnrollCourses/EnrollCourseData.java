package com.example.login.ui.EnrollCourses;

public class EnrollCourseData {

    private String course_name, for_batch, course_code;

    public EnrollCourseData() {
    }

    public EnrollCourseData(String course_name, String for_batch, String course_code) {
        this.course_name = course_name;
        this.for_batch = for_batch;
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getFor_batch() {
        return for_batch;
    }

    public void setFor_batch(String for_batch) {
        this.for_batch = for_batch;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }
}

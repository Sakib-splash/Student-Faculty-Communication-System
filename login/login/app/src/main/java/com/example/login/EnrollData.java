package com.example.login;

public class EnrollData {
    private String StudentEmail,StudentId,uid;
    private boolean enrolled=false;

    public EnrollData() {
    }

    public EnrollData(String StudentEmail, String StudentId, String uid,boolean enrolled) {
        this.StudentEmail = StudentEmail;
        this.StudentId = StudentId;
        this.uid = uid;
        this.enrolled=enrolled;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public String getStudentId() {
        return StudentId;
    }

    public String getUid() {
        return uid;
    }

    public void setStudentEmail(String StudentEmail) {
        this.StudentEmail = StudentEmail;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }
}

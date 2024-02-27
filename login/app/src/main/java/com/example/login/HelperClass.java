package com.example.login;

public class HelperClass {
    String name, email, username, password, userid,StudentEmail,StudentId,uid;

    public String getName() {
        return name;
    }

    public HelperClass(String userid) {
        this.userid = userid;
    }

    public HelperClass(String StudentEmail,String StudentId,String uid){
        this.StudentEmail=StudentEmail;
        this.StudentId=StudentId;
        this.uid=uid;

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStudentId() {
        return StudentId;
    }

    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HelperClass(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public HelperClass() {
    }
}

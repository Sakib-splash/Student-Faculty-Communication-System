package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.login.faculty.UpdateFaculty;
import com.example.login.notice.DeleteNoticeActivity;
import com.example.login.notice.UploadNotice;

public class home_page extends AppCompatActivity {

    CardView create_course,my_courses,deleteNotice;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        deleteNotice = findViewById(R.id.deleteNotice);
        create_course = findViewById(R.id.create_course);
        my_courses = findViewById(R.id.my_courses);





        deleteNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, DeleteNoticeActivity.class);
                startActivity(intent);
            }
        });

        create_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, Create_Course.class);
                startActivity(intent);
            }
        });

        my_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, FacultyCourses.class);
                startActivity(intent);
            }
        });



    }
}
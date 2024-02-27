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

public class UploadOnCourse extends AppCompatActivity {
    CardView uploadNotice,addGalleryImage,addEbook, deleteNotice,enroll_requests;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_on_course);

        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);

        deleteNotice = findViewById(R.id.deleteNotice);

        enroll_requests=findViewById(R.id.enroll_requests);


        uploadNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentCourseName = getIntent().getStringExtra("courseName");
                Intent intent = new Intent(UploadOnCourse.this, UploadNotice.class);
                intent.putExtra("courseName", currentCourseName); // Pass the course name to the next activity
                startActivity(intent);
            }
        });

        addGalleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentCourseName = getIntent().getStringExtra("courseName");
                Intent intent = new Intent(UploadOnCourse.this,UploadImage.class);
                intent.putExtra("courseName", currentCourseName); // Pass the course name to the next activity
                startActivity(intent);
            }
        });
        addEbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentCourseName = getIntent().getStringExtra("courseName");
                Intent intent = new Intent(UploadOnCourse.this,UploadPdfActivity.class);
                intent.putExtra("courseName", currentCourseName); // Pass the course name to the next activity
                startActivity(intent);
            }
        });
//        faculty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(home_page.this, UpdateFaculty.class);
//                startActivity(intent);
//            }
//        });
        deleteNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentCourseName = getIntent().getStringExtra("courseName");
                Intent intent = new Intent(UploadOnCourse.this, DeleteNoticeActivity.class);
                intent.putExtra("courseName", currentCourseName); // Pass the course name to the next activity
                startActivity(intent);
            }
        });

        enroll_requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming you have a variable currentCourseName that holds the clicked course name
                String currentCourseName = getIntent().getStringExtra("courseName");

                // Display the current course name in a Toast message
                Toast.makeText(UploadOnCourse.this, "Selected course: " + currentCourseName, Toast.LENGTH_SHORT).show();

                // Create an Intent to start the EnrollRequest activity
                Intent intent = new Intent(UploadOnCourse.this, EnrollRequest.class);
                intent.putExtra("courseName", currentCourseName); // Pass the course name to the next activity
                startActivity(intent);
            }
        });


    }
}

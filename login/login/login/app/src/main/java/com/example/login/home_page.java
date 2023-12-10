package com.example.login;

import static com.example.login.R.id.addNotice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class home_page extends AppCompatActivity {

    CardView uploadNotice,addGalleryImage,addEbook,faculty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        uploadNotice = findViewById(addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);

        uploadNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this,UploadNotice.class);
                startActivity(intent);
            }
        });

        addGalleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this,UploadImage.class);
                startActivity(intent);
            }
        });
        addEbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this,UploadPdfActivity.class);
                startActivity(intent);
            }
        });
//        faculty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(home_page.this, UpdateFaculty.class);
//                startActivity(intent);
//            }
//        });
    }
}
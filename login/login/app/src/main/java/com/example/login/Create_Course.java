package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_Course extends AppCompatActivity {

    EditText Course_name, Course_batch, Course_code;
    Button createButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_course);

        Course_name=findViewById(R.id.course_name);
        Course_batch=findViewById(R.id.course_batch);
        Course_code=findViewById(R.id.course_code);
        createButton = findViewById(R.id.create_button);

        firebaseAuth = FirebaseAuth.getInstance();
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Classes");

                String course_name = Course_name.getText().toString();
                String for_batch = Course_batch.getText().toString();
                String course_code = Course_code.getText().toString();


                //this section usedfor finding the login user

                String userId = firebaseAuth.getCurrentUser().getUid();

                CourseData courseHelper = new CourseData(course_name, for_batch, course_code,userId);
                reference.child(course_name).setValue(courseHelper);

                Toast.makeText(Create_Course.this, "Course Create Successfully!", Toast.LENGTH_SHORT).show();



            }
        });
    }
    }
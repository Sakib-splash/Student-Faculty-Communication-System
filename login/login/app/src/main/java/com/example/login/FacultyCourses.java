package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FacultyCourses extends AppCompatActivity {

    RecyclerView courses;
    CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_courses);

        courses = findViewById(R.id.courses);
        courses.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<CourseData> options =
                new FirebaseRecyclerOptions.Builder<CourseData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Classes"), CourseData.class)
                        .build();

        adapter = new CourseAdapter(options);
        courses.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
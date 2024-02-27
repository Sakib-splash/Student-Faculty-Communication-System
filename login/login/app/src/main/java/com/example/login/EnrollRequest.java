package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

public class EnrollRequest extends AppCompatActivity {

    RecyclerView requesters;
    EnrollAdapter adapter;
    FirebaseAuth firebaseAuth;
    DataSnapshot dataSnapshot;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_request);

        // Retrieve coursename from the intent
        String currentCourseName = getIntent().getStringExtra("courseName");

        // Use the currentCourseName as needed in your activity

        // Declare the RecyclerView
        requesters = findViewById(R.id.requesters);
        requesters.setLayoutManager(new LinearLayoutManager(this));

        Log.d("getting req", "onCreate: ");

        // Query to fetch data from "Enrollment" child with the specified coursename
        Query query = FirebaseDatabase.getInstance().getReference()
                .child("Enrollment").child(currentCourseName)
                .orderByChild("enrolled")  // Use "courseName" instead of "Course Name"
                .equalTo(false);

        Log.d("got reqs", "onCreate: "+ query.toString());



        FirebaseRecyclerOptions<EnrollData> options =
                new FirebaseRecyclerOptions.Builder<EnrollData>()
                        .setQuery(query, EnrollData.class)
                        .build();

        List<EnrollData> data = options.getSnapshots();
        Log.d("data", "onCreate: "+ data.size());
        for(int i=0; i<data.size(); i++){
            Log.d("data", "onCreate: "+ data.get(i).getStudentEmail());
        };

        adapter = new EnrollAdapter(EnrollRequest.this,options, currentCourseName );
        requesters.setAdapter(adapter);
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

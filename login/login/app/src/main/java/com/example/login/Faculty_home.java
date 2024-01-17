package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.login.CourseAdapter;
import com.example.login.CourseData;
import com.example.login.Faculty_home;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Faculty_home extends AppCompatActivity {

    private RecyclerView courses;
    private LinearLayout coursesNoData;
    private List<CourseData> list1;
    private CourseAdapter adapter;
    private DatabaseReference reference, dbRef;

    @SuppressLint("MissingInflatedId")

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // View view = inflater.inflate(R.layout.fragment_notice, container, false);

        //setContentView(R.layout.view);

        courses = findViewById(R.id.courses);

        coursesNoData = findViewById(R.id.coursesNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("Classes");


        courses();

    }

    private void courses() {
        dbRef = reference.child("root1");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    coursesNoData.setVisibility(View.VISIBLE);
                    courses.setVisibility(View.GONE);
                }else {
                    coursesNoData.setVisibility(View.GONE);
                    courses.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CourseData data = snapshot.getValue(CourseData.class);
                        list1.add(data);
                    }
                    courses.setHasFixedSize(true);
                    courses.setLayoutManager(new LinearLayoutManager(Faculty_home.this));
                    //adapter = new CourseAdapter(list1, Faculty_home.this);
                    courses.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Faculty_home.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
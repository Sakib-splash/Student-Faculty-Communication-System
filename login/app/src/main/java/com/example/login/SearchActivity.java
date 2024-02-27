package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SearchActivity extends AppCompatActivity {

    private EditText courseCodeEditText;
    private Button searchButton;
    private RecyclerView searchResultRecyclerView;
    private ProgressBar progressBar;

    private DatabaseReference classesReference;
    private FirebaseRecyclerOptions<CourseData> options;
    private SearchResultAdapter searchResultAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        courseCodeEditText = findViewById(R.id.courseCodeEditText);
        searchButton = findViewById(R.id.searchButton);
        searchResultRecyclerView = findViewById(R.id.searchResultRecyclerView);
        progressBar = findViewById(R.id.progressBar);

        classesReference = FirebaseDatabase.getInstance().getReference().child("Classes");

        // Configure the search query and options
        Query query = classesReference.orderByChild("course_code");
        options = new FirebaseRecyclerOptions.Builder<CourseData>()
                .setQuery(query, CourseData.class)
                .build();

        // Initialize the adapter
        searchResultAdapter = new SearchResultAdapter(options);

        // Set the adapter to the RecyclerView
        searchResultRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchResultRecyclerView.setAdapter(searchResultAdapter);

        // Set a click listener for the search button
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });

        // Set an item click listener for the adapter
        searchResultAdapter.setOnItemClickListener(new SearchResultAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CourseData item) {
                navigateToRequestPermission(item);
            }
        });
    }

//    private void performSearch() {
//        String searchCode = courseCodeEditText.getText().toString().trim();
//
//        Log.d("CodeCollect", "performSearch: "+searchCode);
//        if (!TextUtils.isEmpty(searchCode)) {
//            // Modify the query based on your search logic
//            Query searchQuery = classesReference.orderByChild("course_code").equalTo(searchCode);
//            options = new FirebaseRecyclerOptions.Builder<CourseData>()
//                    .setQuery(searchQuery, CourseData.class)
//                    .build();
//
//            searchResultAdapter.updateOptions(options);
//        }
//    }

    private void performSearch() {
        String courseCode = courseCodeEditText.getText().toString().trim();
        if (!TextUtils.isEmpty(courseCode)) {
            // Modify the query based on your search logic
            Query searchQuery = classesReference.orderByChild("course_code").equalTo(courseCode);
            FirebaseRecyclerOptions<CourseData> updatedOptions = new FirebaseRecyclerOptions.Builder<CourseData>()
                    .setQuery(searchQuery, CourseData.class)
                    .build();

            searchResultAdapter.updateOptions(updatedOptions);
            searchResultAdapter.notifyDataSetChanged(); // Notify the adapter of the change
        }
    }


    private void navigateToRequestPermission(CourseData selectedCourse) {
        Intent intent = new Intent(this, RequestPermission.class);
        intent.putExtra("courseName", selectedCourse.getCourse_name());
        intent.putExtra("courseCode", selectedCourse.getCourse_code());
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        searchResultAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        searchResultAdapter.stopListening();
    }
}
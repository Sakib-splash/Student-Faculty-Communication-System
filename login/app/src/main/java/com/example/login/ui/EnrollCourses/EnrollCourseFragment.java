package com.example.login.ui.EnrollCourses;







        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;

        import com.example.login.R;
        import com.firebase.ui.database.FirebaseRecyclerOptions;
        import com.google.firebase.database.FirebaseDatabase;


public class EnrollCourseFragment extends AppCompatActivity {

    RecyclerView courses;
    EnrollCourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_courses);

        courses = findViewById(R.id.courses);
        courses.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<EnrollCourseData> options =
                new FirebaseRecyclerOptions.Builder<EnrollCourseData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Classes"), EnrollCourseData.class)
                        .build();

        adapter = new EnrollCourseAdapter(options);
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
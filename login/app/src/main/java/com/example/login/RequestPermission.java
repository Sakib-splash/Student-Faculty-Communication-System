package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;





public class RequestPermission extends AppCompatActivity {

    EditText studentEmail, studentId;
    String courseName;

    Button submitButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_permission);

        studentEmail = findViewById(R.id.studet_id);
        studentId = findViewById(R.id.student_email);

        submitButton = findViewById(R.id.submit_button);
        courseName = getIntent().getStringExtra("courseName");

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Enrollment");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String StudentEmail = studentEmail.getText().toString().trim();
                String StudentId = studentId.getText().toString().trim();


                enroll(StudentEmail, StudentId);
            }
        });


    }

    private void enroll(String studentEmail, String studentId) {
        String uid = firebaseAuth.getCurrentUser().getUid();
        EnrollData enrollData = new EnrollData(studentEmail, studentId, uid, false );

        // Assuming courseName is not null (make sure to handle this case)
        String courseName = getIntent().getStringExtra("courseName");

        // Reference to the "Classes" node under the specific course name
        DatabaseReference courseReference = databaseReference.child(courseName);

        // Push a new unique key for each enrollment
        String enrollmentKey = courseReference.push().getKey();

        // Write the data to the specific course node under "Classes"
        courseReference.child(uid).setValue(enrollData)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RequestPermission.this, "Enrollment successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RequestPermission.this, UserActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RequestPermission.this, "Enrollment failed. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }




}
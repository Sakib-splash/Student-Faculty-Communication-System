


        package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class SignupFacultyActivity extends AppCompatActivity {

    EditText signupName, signupEmail, signupUsername, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_faculty);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Faculty");

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                database = FirebaseDatabase.getInstance();
//                reference = database.getReference("users");

                String name = signupName.getText().toString().trim();
                String email = signupEmail.getText().toString().trim();
                String username = signupUsername.getText().toString().trim();
                String password = signupPassword.getText().toString().trim();

                register(name, email, username, password);
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupFacultyActivity.this, LoginActivityFaculty.class);
                startActivity(intent);
            }
        });
    }

    private void register(String name, String email, String username, String password) {

//        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
//                    startActivity(intent);
//
//                    databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
//
//                    String userId = firebaseAuth.getCurrentUser().getUid();
//                    HelperClass helperClass = new HelperClass(name, email, username,password);
//
//                    databaseReference.child(userId).setValue(helperClass);
//                }
//            }
//        });

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(SignupFacultyActivity.this, LoginActivityFaculty.class);
                    startActivity(intent);

//                    databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

                    String userId = firebaseAuth.getCurrentUser().getUid();
                    HelperClass helperClass = new HelperClass(name, email, username,password);

                    databaseReference.child(userId).setValue(helperClass);
                }
            }
        });

    }
}
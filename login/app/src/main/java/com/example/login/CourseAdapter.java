package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;


    public class CourseAdapter extends FirebaseRecyclerAdapter<CourseData,CourseAdapter.myViewHolder> {

    public CourseAdapter(@NonNull FirebaseRecyclerOptions<CourseData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull CourseData model) {
 holder.course_name.setText(model.getCourse_name());
 holder.for_batch.setText(model.getFor_batch());
 holder.course_code.setText(model.getCourse_code());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item,parent,false);
        return new myViewHolder(view);
    }



        public class myViewHolder extends RecyclerView.ViewHolder {
            TextView course_name, for_batch, course_code;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);
                course_name = itemView.findViewById(R.id.course_name);
                for_batch = itemView.findViewById(R.id.for_batch);
                course_code = itemView.findViewById(R.id.course_code);

                // Add OnClickListener to the itemView (assuming your card has an id like course_card)
                itemView.findViewById(R.id.course_card).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle the click event, determine the user type, and navigate accordingly

                        // Get the clicked item's data
                        CourseData clickedCourse = getItem(getAdapterPosition());

                        // Get the current user's ID (assuming it's stored in FirebaseAuth)
                        String currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

                        // Check if the current user ID is in "USERS"
                        DatabaseReference usersReference = FirebaseDatabase.getInstance().getReference("USERS");
                        usersReference.child(currentUserId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DataSnapshot userSnapshot = task.getResult();
                                    if (userSnapshot.exists()) {
                                        // Current user ID is in "USERS"
                                        navigateToRequestPermission(clickedCourse);
                                    } else {
                                        // Current user ID is not in "USERS", navigate to UpdateClass
                                        navigateToUpdateClass(clickedCourse);
                                    }
                                } else {
                                    // Handle errors
                                    Toast.makeText(itemView.getContext(), "Error checking user type", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }

            private void navigateToRequestPermission(CourseData clickedCourse) {
                String courseName = clickedCourse.getCourse_name();
                Toast.makeText(itemView.getContext(), "Clicked on course: " + courseName, Toast.LENGTH_SHORT).show();
                String currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

                // Check if the currentUserId exists in "Classes" node for the given course
                DatabaseReference classesRef = FirebaseDatabase.getInstance().getReference("Classes")
                        .child(courseName)
                        .child(currentUserId);

                classesRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            // currentUserId exists in "Classes" node for the given course
                            startAnotherClassActivity(courseName);
                        } else {
                            // currentUserId doesn't exist, start RequestPermission activity
                            startRequestPermissionActivity(courseName);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle the error if needed
                        Toast.makeText(itemView.getContext(), "Error checking currentUserId in Classes node", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void startAnotherClassActivity(String courseName) {
                // Start your AnotherClass activity with course name
                Context context = itemView.getContext();
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("courseName", courseName);
                context.startActivity(intent);
            }

            private void startRequestPermissionActivity(String courseName) {
                // Start RequestPermission activity with course name
                Context context = itemView.getContext();
                Intent intent = new Intent(context, RequestPermission.class);
                intent.putExtra("courseName", courseName);
                context.startActivity(intent);
            }

            private void navigateToUpdateClass(CourseData clickedCourse) {
                String courseName = clickedCourse.getCourse_name();
                Toast.makeText(itemView.getContext(), "Clicked on course: " + courseName, Toast.LENGTH_SHORT).show();

                // Start RequestPermission activity with course name
                Context context = itemView.getContext();
                Intent intent = new Intent(context, UploadOnCourse.class);
                intent.putExtra("courseName", courseName);
                context.startActivity(intent);
            }
        }


    }
package com.example.login;

import android.content.Context;
import android.util.Log;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Assuming your layout resource file is named enroll_item.xml
public class EnrollAdapter extends FirebaseRecyclerAdapter<EnrollData, EnrollAdapter.myViewHolder> {

    private String courseName;
    Context c;

    public EnrollAdapter(Context c,@NonNull FirebaseRecyclerOptions<EnrollData> options, String courseName) {

        super(options);
        Log.d("adapter", "EnrollAdapter: "+ options.toString());
        this.courseName = courseName;
        this.c = c;

    }


    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull EnrollData model) {

        Log.d("EnrollAdapter", "StudentEmail: " + model.getStudentEmail());
        Log.d("EnrollAdapter", "StudentId: " + model.getStudentId());

        holder.StudentEmail.setText(model.getStudentEmail());
        holder.StudentId.setText(model.getStudentId());

        holder.enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference enrollmentRef = FirebaseDatabase.getInstance().getReference("Enrollment")
                        .child(courseName)
                        .child(model.getUid());

                // Update 'enrolled' to true
                enrollmentRef.child("enrolled").setValue(true);

                // Retrieve the uid
                String uid = model.getUid();

                DatabaseReference classesRef = FirebaseDatabase.getInstance().getReference("Classes")
                        .child(courseName);

//                Map<String, Object> studentMap = new HashMap<String, Object>();
//                studentMap.put("uid", uid);
//                studentMap.put("enrolled", true);

                classesRef.child(uid).setValue(uid);

                Toast.makeText(c, "Request Approved.", Toast.LENGTH_SHORT).show();
                c.startActivity(new Intent(c, UploadOnCourse.class));
            }
        });
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Replace R.layout.approval with the actual layout resource file for your RecyclerView item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.approval, parent, false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView StudentEmail, StudentId;
        View enroll;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            StudentEmail = itemView.findViewById(R.id.StudentEmail);
            StudentId = itemView.findViewById(R.id.StudentId);
            enroll = itemView.findViewById(R.id.approve);
        }
    }


}




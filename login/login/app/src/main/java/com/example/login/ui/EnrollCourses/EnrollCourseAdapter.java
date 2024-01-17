package com.example.login.ui.EnrollCourses;





        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.login.R;
        import com.firebase.ui.database.FirebaseRecyclerAdapter;
        import com.firebase.ui.database.FirebaseRecyclerOptions;
        import com.squareup.picasso.Picasso;

        import java.util.List;


public class EnrollCourseAdapter extends FirebaseRecyclerAdapter<EnrollCourseData,EnrollCourseAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EnrollCourseAdapter(@NonNull FirebaseRecyclerOptions<EnrollCourseData> options) {
        super(options);
    }


    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull EnrollCourseData model) {
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

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView course_name, for_batch, course_code;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            course_name = itemView.findViewById(R.id.course_name);
            for_batch = itemView.findViewById(R.id.for_batch);
            course_code = itemView.findViewById(R.id.course_code);
        }
    }
}
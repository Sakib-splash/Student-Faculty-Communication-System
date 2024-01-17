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
import com.squareup.picasso.Picasso;

import java.util.List;

//public class CourseAdapter extends RecyclerView.Adapter<com.example.login.CourseAdapter.CourseViewAdapter> {
//
//    private List<CourseData> list;
//    private Context context;
//
//
//    public CourseAdapter(List<CourseData> list, Context context) {
//        this.list = list;
//        this.context = context;
//
//    }
//
//    @NonNull
//    @Override
//    public CourseViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        boolean attachToRoot;
//        View view = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
//
//        return new CourseViewAdapter(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CourseViewAdapter holder, int position) {
//
//        CourseData item = list.get(position);
//        holder.course_name.setText(item.getCourse_name());
//        holder.for_batch.setText(item.getFor_batch());
//        holder.course_code.setText(item.getCourse_code());
//
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class CourseViewAdapter extends RecyclerView.ViewHolder {
//
//        private TextView course_name, for_batch, course_code;
//
//
//        public CourseViewAdapter(@NonNull View itemView) {
//            super(itemView);
//            course_name = itemView.findViewById(R.id.course_name);
//            for_batch = itemView.findViewById(R.id.for_batch);
//            course_code = itemView.findViewById(R.id.course_code);
//
//
//        }
//    }
//}
    public class CourseAdapter extends FirebaseRecyclerAdapter<CourseData,CourseAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
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

    public class myViewHolder extends RecyclerView.ViewHolder{
            TextView course_name, for_batch, course_code;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);
                course_name = itemView.findViewById(R.id.course_name);
                for_batch = itemView.findViewById(R.id.for_batch);
                course_code = itemView.findViewById(R.id.course_code);
            }
        }
}
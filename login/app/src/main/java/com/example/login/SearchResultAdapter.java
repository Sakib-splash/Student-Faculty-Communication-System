package com.example.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class SearchResultAdapter extends FirebaseRecyclerAdapter<CourseData, SearchResultAdapter.SearchResultViewHolder> {

    private OnItemClickListener onItemClickListener;

    public SearchResultAdapter(@NonNull FirebaseRecyclerOptions<CourseData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull SearchResultViewHolder holder, int position, @NonNull CourseData model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public SearchResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        return new SearchResultViewHolder(view);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(CourseData item);
    }

    public class SearchResultViewHolder extends RecyclerView.ViewHolder {

        private TextView courseNameTextView;
        private TextView forBatchTextView;
        private TextView courseCodeTextView;


        public SearchResultViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.course_name);
            forBatchTextView = itemView.findViewById(R.id.for_batch);
            courseCodeTextView = itemView.findViewById(R.id.course_code);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                        onItemClickListener.onItemClick(getItem(position));
                    }
                }
            });
        }

        public void bind(CourseData model) {
            courseNameTextView.setText(model.getCourse_name());
            forBatchTextView.setText(model.getFor_batch());
            courseCodeTextView.setText(model.getCourse_code());


        }
    }
}
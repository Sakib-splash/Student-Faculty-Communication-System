package com.example.login.ui.notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.notice.NoticeData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class notice_Adapter extends RecyclerView.Adapter<notice_Adapter.NoticeViewAdepter> {

    private Context context;
    private ArrayList<NoticeData> list;

    public notice_Adapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdepter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_one, parent, false);
        return new NoticeViewAdepter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdepter holder, int position) {
        final NoticeData currentItem = list.get(position);

        holder.deleteNoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());

        try {
            if (currentItem.getImage() != null)
                Picasso.get().load(currentItem.getImage()).into(holder.deleteNoticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdepter extends RecyclerView.ViewHolder {


        private TextView deleteNoticeTitle, date, time;
        private ImageView deleteNoticeImage;

        public NoticeViewAdepter(@NonNull View itemView) {
            super(itemView);

            deleteNoticeTitle = itemView.findViewById(R.id.deleteNoticeTitle);
            deleteNoticeImage = itemView.findViewById(R.id.deleteNoticeImage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }

}

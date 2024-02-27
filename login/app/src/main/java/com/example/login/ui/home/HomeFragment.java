package com.example.login.ui.home;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.login.R;


public class HomeFragment extends Fragment {


    private ImageView map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openMap();

            }
        });

        return view;
    }

    private void openMap() {
       Uri uri = Uri.parse("geo:0, 0?q=Jagannath University Dhaka");
       Intent intent = new Intent(Intent.ACTION_VIEW, uri);
       intent.setPackage("com.google.android.apps.maps");
       startActivity(intent);
   }
}
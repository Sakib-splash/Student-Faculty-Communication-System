package com.example.login.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.login.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_comp, "CSE", "it is very important subject"));
        list.add(new BranchModel(R.drawable.ic_mech, "Mechanical Production", "it is very important subject"));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.university_image);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/my-university-app-bfea3.appspot.com/o/jnu%20photos%2Fjnu1.jpg?alt=media&token=acdbfc26-ef55-44dd-95d1-807dd6a86623")
                .into(imageView);


        return view;
    }
}
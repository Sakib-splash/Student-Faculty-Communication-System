package com.example.login.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.faculty.AddTeacher;
import com.example.login.faculty.UpdateFaculty;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FcultyFragment extends Fragment {

    private RecyclerView cseDepartment, mathDepartment, englishDepartment, physicsDepartment, microbiologyDepartment, banglaDepartment, psychologyDepartment, chemistryDepartment, botanyDepartment, zoologyDepartment, financeDepartment, accountingDepartment, bbaDepartment, lawDepartment, historyDepartment, socialworkDepartment, ierDepartment;
    private LinearLayout cseNoData, mathNoData, englishNoData, physicsNoData, microbiologyNoData, banglaNoData, psychologyNoData, chemistryNoData, botanyNoData, zoologyNoData, financeNoData, accountingNoData, bbaNoData, lawNoData, historyNoData, socialworkNoData, ierNoData;
    private List<TeacherData> list1, list2,list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;

    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fculty, container, false);

        cseDepartment = view.findViewById(R.id.cseDepartment);
        mathDepartment = view.findViewById(R.id.mathDepartment);
        englishDepartment = view.findViewById(R.id.englishDepartment);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);
        microbiologyDepartment = view.findViewById(R.id.microbiologyDepartment);
        banglaDepartment = view.findViewById(R.id.banglaDepartment);
        psychologyDepartment = view.findViewById(R.id.psychologyDepartment);
        chemistryDepartment = view.findViewById(R.id.chemistryDepartment);
        botanyDepartment = view.findViewById(R.id.botanyDepartment);
        zoologyDepartment = view.findViewById(R.id.zoologyDepartment);
        financeDepartment = view.findViewById(R.id.financeDepartment);
        accountingDepartment = view.findViewById(R.id.accountingDepartment);
        bbaDepartment = view.findViewById(R.id.bbaDepartment);
        lawDepartment = view.findViewById(R.id.lawDepartment);
        historyDepartment = view.findViewById(R.id.historyDepartment);
        socialworkDepartment = view.findViewById(R.id.socialworkDepartment);
        ierDepartment = view.findViewById(R.id.ierDepartment);

        cseNoData = view.findViewById(R.id.cseNoData);
        mathNoData = view.findViewById(R.id.mathNoData);
        englishNoData = view.findViewById(R.id.englishNoData);
        physicsNoData = view.findViewById(R.id.physicsNoData);
        microbiologyNoData = view.findViewById(R.id.microbiologyNoData);
        psychologyNoData = view.findViewById(R.id.psychologyNoData);
        banglaNoData = view.findViewById(R.id.banglaNoData);
        chemistryNoData = view.findViewById(R.id.chemistryNoData);
        botanyNoData = view.findViewById(R.id.botanyNoData);
        zoologyNoData = view.findViewById(R.id.zoologyNoData);
        financeNoData = view.findViewById(R.id.financeNoData);
        accountingNoData = view.findViewById(R.id.accountingNoData);
        lawNoData = view.findViewById(R.id.lawNoData);
        historyNoData = view.findViewById(R.id.historyNoData);
        socialworkNoData = view.findViewById(R.id.socialworkNoData);
        ierNoData = view.findViewById(R.id.ierNoData);
        bbaNoData = view.findViewById(R.id.bbaNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        cseDepartment();
        mathDepartment();
        englishDepartment();
        physicsDepartment();
        microbiologyDepartment();
        banglaDepartment();
        psychologyDepartment();
        chemistryDepartment();
        botanyDepartment();
        zoologyDepartment();
        financeDepartment();
        accountingDepartment();
        bbaDepartment();
        lawDepartment();
        historyDepartment();
        socialworkDepartment();
        ierDepartment();

        return view;
    }
    private void cseDepartment() {
        dbRef = reference.child("CSE");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    cseNoData.setVisibility(View.VISIBLE);
                    cseDepartment.setVisibility(View.GONE);
                }else {
                    cseNoData.setVisibility(View.GONE);
                    cseDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list1.add(data);
                    }
                    cseDepartment.setHasFixedSize(true);
                    cseDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list1, getContext(), "CSE");
                    cseDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void mathDepartment() {
        dbRef = reference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mathNoData.setVisibility(View.VISIBLE);
                    mathDepartment.setVisibility(View.GONE);
                }else {
                    mathNoData.setVisibility(View.GONE);
                    mathDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list2.add(data);
                    }
                    mathDepartment.setHasFixedSize(true);
                    mathDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list2, getContext(), "Mathematics");
                    mathDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void englishDepartment() {
        dbRef = reference.child("English");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    englishNoData.setVisibility(View.VISIBLE);
                    englishDepartment.setVisibility(View.GONE);
                }else {
                    englishNoData.setVisibility(View.GONE);
                    englishDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list3.add(data);
                    }
                    englishDepartment.setHasFixedSize(true);
                    englishDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list3, getContext(), "English");
                    englishDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void physicsDepartment() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                }else {
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list4.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list4, getContext(), "Physics");
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void microbiologyDepartment() {
        dbRef = reference.child("Microbiology");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    microbiologyNoData.setVisibility(View.VISIBLE);
                    microbiologyDepartment.setVisibility(View.GONE);
                }else {
                    microbiologyNoData.setVisibility(View.GONE);
                    microbiologyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list5.add(data);
                    }
                    microbiologyDepartment.setHasFixedSize(true);
                    microbiologyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list5, getContext(), "Microbiology");
                    microbiologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void banglaDepartment() {
        dbRef = reference.child("Bangla");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    banglaNoData.setVisibility(View.VISIBLE);
                    banglaDepartment.setVisibility(View.GONE);
                }else {
                    banglaNoData.setVisibility(View.GONE);
                    banglaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list6.add(data);
                    }
                    banglaDepartment.setHasFixedSize(true);
                    banglaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list6, getContext(), "Bangla");
                    banglaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void psychologyDepartment() {
        dbRef = reference.child("Psychology");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    psychologyNoData.setVisibility(View.VISIBLE);
                    psychologyDepartment.setVisibility(View.GONE);
                }else {
                    psychologyNoData.setVisibility(View.GONE);
                    psychologyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list7.add(data);
                    }
                    psychologyDepartment.setHasFixedSize(true);
                    psychologyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list7, getContext(), "Psychology");
                    psychologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void chemistryDepartment() {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);
                }else {
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list8.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list8, getContext(), "Chemistry");
                    chemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void botanyDepartment() {
        dbRef = reference.child("Botany");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    botanyNoData.setVisibility(View.VISIBLE);
                    botanyDepartment.setVisibility(View.GONE);
                }else {
                    botanyNoData.setVisibility(View.GONE);
                    botanyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list9.add(data);
                    }
                    botanyDepartment.setHasFixedSize(true);
                    botanyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list9, getContext(), "Botany");
                    botanyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void zoologyDepartment() {
        dbRef = reference.child("Zoology");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    zoologyNoData.setVisibility(View.VISIBLE);
                    zoologyDepartment.setVisibility(View.GONE);
                }else {
                    zoologyNoData.setVisibility(View.GONE);
                    zoologyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list10.add(data);
                    }
                    zoologyDepartment.setHasFixedSize(true);
                    zoologyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list10, getContext(), "Zoology");
                    zoologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void financeDepartment() {
        dbRef = reference.child("Finance");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    financeNoData.setVisibility(View.VISIBLE);
                    financeDepartment.setVisibility(View.GONE);
                }else {
                    financeNoData.setVisibility(View.GONE);
                    financeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list11.add(data);
                    }
                    financeDepartment.setHasFixedSize(true);
                    financeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list11, getContext(), "Finance");
                    financeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void accountingDepartment() {
        dbRef = reference.child("Accounting");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    accountingNoData.setVisibility(View.VISIBLE);
                    accountingDepartment.setVisibility(View.GONE);
                }else {
                    accountingNoData.setVisibility(View.GONE);
                    accountingDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list12.add(data);
                    }
                    accountingDepartment.setHasFixedSize(true);
                    accountingDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list12, getContext(), "Accounting");
                    accountingDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bbaDepartment() {
        dbRef = reference.child("BBA");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bbaNoData.setVisibility(View.VISIBLE);
                    bbaDepartment.setVisibility(View.GONE);
                }else {
                    bbaNoData.setVisibility(View.GONE);
                    bbaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list13.add(data);
                    }
                    bbaDepartment.setHasFixedSize(true);
                    bbaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list13, getContext(), "BBA");
                    bbaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void lawDepartment() {
        dbRef = reference.child("Law");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    lawNoData.setVisibility(View.VISIBLE);
                    lawDepartment.setVisibility(View.GONE);
                }else {
                    lawNoData.setVisibility(View.GONE);
                    lawDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list14.add(data);
                    }
                    lawDepartment.setHasFixedSize(true);
                    lawDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list14, getContext(), "Law");
                    lawDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void historyDepartment() {
        dbRef = reference.child("History");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    historyNoData.setVisibility(View.VISIBLE);
                    historyDepartment.setVisibility(View.GONE);
                }else {
                    historyNoData.setVisibility(View.GONE);
                    historyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list15.add(data);
                    }
                    historyDepartment.setHasFixedSize(true);
                    historyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list15, getContext(), "History");
                    historyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void socialworkDepartment() {
        dbRef = reference.child("Social Work");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    socialworkNoData.setVisibility(View.VISIBLE);
                    socialworkDepartment.setVisibility(View.GONE);
                }else {
                    socialworkNoData.setVisibility(View.GONE);
                    socialworkDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list16.add(data);
                    }
                    socialworkDepartment.setHasFixedSize(true);
                    socialworkDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list16, getContext(), "Social Work");
                    socialworkDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ierDepartment() {
        dbRef = reference.child("IER");
        dbRef.addValueEventListener(new ValueEventListener() {
            private Throwable databaseError;
            //private File dataSnapshot;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    ierNoData.setVisibility(View.VISIBLE);
                    ierDepartment.setVisibility(View.GONE);
                }else {
                    ierNoData.setVisibility(View.GONE);
                    ierDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        com.example.login.ui.faculty.TeacherData data = snapshot.getValue(com.example.login.ui.faculty.TeacherData.class);
                        list17.add(data);
                    }
                    ierDepartment.setHasFixedSize(true);
                    ierDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.example.login.ui.faculty.TeacherAdapter(list17, getContext(), "IER");
                    ierDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
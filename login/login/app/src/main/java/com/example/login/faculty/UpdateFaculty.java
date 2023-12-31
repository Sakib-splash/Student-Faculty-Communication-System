package com.example.login.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.login.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;

    private RecyclerView cseDepartment, mathDepartment, englishDepartment, physicsDepartment, microbiologyDepartment, banglaDepartment, psychologyDepartment, chemistryDepartment, botanyDepartment, zoologyDepartment, financeDepartment, accountingDepartment, bbaDepartment, lawDepartment, historyDepartment, socialworkDepartment, ierDepartment;
    private LinearLayout cseNoData, mathNoData, englishNoData, physicsNoData, microbiologyNoData, banglaNoData, psychologyNoData, chemistryNoData, botanyNoData, zoologyNoData, financeNoData, accountingNoData, bbaNoData, lawNoData, historyNoData, socialworkNoData, ierNoData;
    private List<TeacherData> list1, list2,list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;

    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        cseDepartment = findViewById(R.id.cseDepartment);
        mathDepartment = findViewById(R.id.mathDepartment);
        englishDepartment = findViewById(R.id.englishDepartment);
        physicsDepartment = findViewById(R.id.physicsDepartment);
        microbiologyDepartment = findViewById(R.id.microbiologyDepartment);
        banglaDepartment = findViewById(R.id.banglaDepartment);
        psychologyDepartment = findViewById(R.id.psychologyDepartment);
        chemistryDepartment = findViewById(R.id.chemistryDepartment);
        botanyDepartment = findViewById(R.id.botanyDepartment);
        zoologyDepartment = findViewById(R.id.zoologyDepartment);
        financeDepartment = findViewById(R.id.financeDepartment);
        accountingDepartment = findViewById(R.id.accountingDepartment);
        bbaDepartment = findViewById(R.id.bbaDepartment);
        lawDepartment = findViewById(R.id.lawDepartment);
        historyDepartment = findViewById(R.id.historyDepartment);
        socialworkDepartment = findViewById(R.id.socialworkDepartment);
        ierDepartment = findViewById(R.id.ierDepartment);

        cseNoData = findViewById(R.id.cseNoData);
        mathNoData = findViewById(R.id.mathNoData);
        englishNoData = findViewById(R.id.englishNoData);
        physicsNoData = findViewById(R.id.physicsNoData);
        microbiologyNoData = findViewById(R.id.microbiologyNoData);
        psychologyNoData = findViewById(R.id.psychologyNoData);
        banglaNoData = findViewById(R.id.banglaNoData);
        chemistryNoData = findViewById(R.id.chemistryNoData);
        botanyNoData = findViewById(R.id.botanyNoData);
        zoologyNoData = findViewById(R.id.zoologyNoData);
        financeNoData = findViewById(R.id.financeNoData);
        accountingNoData = findViewById(R.id.accountingNoData);
        lawNoData = findViewById(R.id.lawNoData);
        historyNoData = findViewById(R.id.historyNoData);
        socialworkNoData = findViewById(R.id.socialworkNoData);
        ierNoData = findViewById(R.id.ierNoData);
        bbaNoData = findViewById(R.id.bbaNoData);

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

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this, AddTeacher.class));
            }
        });
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    cseDepartment.setHasFixedSize(true);
                    cseDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this, "CSE");
                    cseDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mathDepartment.setHasFixedSize(true);
                    mathDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this, "Mathematics");
                    mathDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    englishDepartment.setHasFixedSize(true);
                    englishDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this, "English");
                    englishDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this, "Physics");
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    microbiologyDepartment.setHasFixedSize(true);
                    microbiologyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5, UpdateFaculty.this, "Microbiology");
                    microbiologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    banglaDepartment.setHasFixedSize(true);
                    banglaDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list6, UpdateFaculty.this, "Bangla");
                    banglaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    psychologyDepartment.setHasFixedSize(true);
                    psychologyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list7, UpdateFaculty.this, "Psychology");
                    psychologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list8, UpdateFaculty.this, "Chemistry");
                    chemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list9.add(data);
                    }
                    botanyDepartment.setHasFixedSize(true);
                    botanyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list9, UpdateFaculty.this, "Botany");
                    botanyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list10.add(data);
                    }
                    zoologyDepartment.setHasFixedSize(true);
                    zoologyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list10, UpdateFaculty.this, "Zoology");
                    zoologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list11.add(data);
                    }
                    financeDepartment.setHasFixedSize(true);
                    financeDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list11, UpdateFaculty.this, "Finance");
                    financeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list12.add(data);
                    }
                    accountingDepartment.setHasFixedSize(true);
                    accountingDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list12, UpdateFaculty.this, "Accounting");
                    accountingDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list13.add(data);
                    }
                    bbaDepartment.setHasFixedSize(true);
                    bbaDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list13, UpdateFaculty.this, "BBA");
                    bbaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list14.add(data);
                    }
                    lawDepartment.setHasFixedSize(true);
                    lawDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list14, UpdateFaculty.this, "Law");
                    lawDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list15.add(data);
                    }
                    historyDepartment.setHasFixedSize(true);
                    historyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list15, UpdateFaculty.this, "History");
                    historyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list16.add(data);
                    }
                    socialworkDepartment.setHasFixedSize(true);
                    socialworkDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list16, UpdateFaculty.this, "Social Work");
                    socialworkDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list17.add(data);
                    }
                    ierDepartment.setHasFixedSize(true);
                    ierDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list17, UpdateFaculty.this, "IER");
                    ierDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
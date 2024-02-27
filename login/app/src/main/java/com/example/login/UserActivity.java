package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle tooggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        tooggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(tooggle);
//
        tooggle.syncState();
//
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//
     navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }






    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(tooggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();
        if (itemId == R.id.navigation_developer) {
            Intent intent = new Intent(UserActivity.this, Welcome.class);
            startActivity(intent);
            Toast.makeText(this, "Log out Sucessfull", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.navigation_video) {
            Intent intent = new Intent(UserActivity.this, EnrollCourse.class);
            startActivity(intent);
            Toast.makeText(this, "Courses Open", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.navigation_rate) {
            Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.navigation_ebook) {
            Intent intent = new Intent(UserActivity.this, SearchActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Searching Courses", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.navigation_theme) {
            Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.navigation_website) {
            Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.navigation_share) {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
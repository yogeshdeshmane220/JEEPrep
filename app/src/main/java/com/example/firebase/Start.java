package com.example.firebase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import com.google.firebase.auth.FirebaseAuth;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class Start extends AppCompatActivity {
    RelativeLayout c1, c2, c3, c4;
    FirebaseAuth firebaseauth;
    TextView logout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        firebaseauth = FirebaseAuth.getInstance();
        getSupportActionBar().hide();

        c1 = findViewById(R.id.physics);
        c2 = findViewById(R.id.chemistry);
        c3 = findViewById(R.id.maths);
        c4 = findViewById(R.id.lastyear);
        logout = findViewById(R.id.logout);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, Physicis.class);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, chemsitry.class);
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, mathematics.class);
                startActivity(intent);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ilast = new Intent(Start.this,StartQuize.class);
                startActivity(ilast);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              logout();
              logout.setVisibility(View.GONE);
            }
        });
    }

    private void logout() {
        SharedPreferences preferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(Start.this, login.class);
        startActivity(intent);
        finish();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_chemistry:
                startActivity(new Intent(Start.this, chemsitry.class));
                return true;
            case R.id.menu_maths:
                startActivity(new Intent(Start.this, mathematics.class));
                return true;
            case R.id.menu_physics:
                startActivity(new Intent(Start.this, Physicis.class));
                return true;
            case R.id.menu_logout:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
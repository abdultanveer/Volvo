package com.example.volvo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent startingIntent = getIntent();
        Bundle bundle = startingIntent.getExtras();
        String name = bundle.getString("mykey");

        TextView homeTextView = findViewById(R.id.textViewHome);
        homeTextView.setText(name);
    }
}
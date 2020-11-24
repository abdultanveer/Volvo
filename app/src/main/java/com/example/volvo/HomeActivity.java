package com.example.volvo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        TextView homeTextView = findViewById(R.id.textViewHome);

        Intent startingIntent = getIntent();
        Bundle bundle = startingIntent.getExtras();
        String name = bundle.getString("mykey");

        homeTextView.setText(name);
    }

    public void clickListener(View view) {
        //close the homeactivity
        Intent mIntent = new Intent();
        mIntent.putExtra("btdevices",4);
        setResult(RESULT_OK,mIntent);
        finish();
    }
}
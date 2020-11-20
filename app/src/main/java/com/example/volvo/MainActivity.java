package com.example.volvo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandler(View view) {

        switch (view.getId()){
            case R.id.buttonLogin:
               // Toast.makeText(this, "android @ volvo", Toast.LENGTH_SHORT).show();
                Intent hIntent = new Intent(MainActivity.this,HomeActivity.class);
                hIntent.putExtra("mykey","abdul ansari");
                startActivity(hIntent);
                break;
            case R.id.buttonCancel:
                Intent dIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"));
                startActivity(dIntent);
                break;
        }

    }
}
package com.example.volvo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout inflater
    }

    public void clickHandler(View view) {

        switch (view.getId()){
            case R.id.buttonLogin:
               // Toast.makeText(this, "android @ volvo", Toast.LENGTH_SHORT).show();
                Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);//explicit intent
                hIntent.putExtra("mykey","abdul ansari");
                //startActivity(hIntent);
                startActivityForResult(hIntent,1234);
                break;
            case R.id.buttonCancel:
               // Intent driveIntent =  new Intent("com.google.android.apps.docs.DRIVE_OPEN");
                Intent dIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"));//implicit intent
                startActivity(dIntent);
                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView mainTextView = findViewById(R.id.textViewmain);
        int result = data.getExtras().getInt("btdevices");
        mainTextView.setText("no of bt devices discovered ="+result);
    }
}
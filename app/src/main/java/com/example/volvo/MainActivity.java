package com.example.volvo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout inflater
        Log.i(TAG,"oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG,"onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onpause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onresume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onstop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"ondestroy");

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
package com.example.volvo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName() ;
    EditText nameEditText;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout inflater
        Log.i(TAG,"oncreate");
        nameEditText = findViewById(R.id.editTextName);
        spinner = findViewById(R.id.spinner);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG,"onStart");
        nameEditText.setOnFocusChangeListener(this);
        spinner.setOnItemSelectedListener(this);

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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("key","abdul");
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

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(!hasFocus){
          String name =  nameEditText.getText().toString();
          if(!name.contains("volvo")){
              Toast.makeText(this, "name doens't exist", Toast.LENGTH_LONG).show();
          }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
package com.example.volvo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.volvo.data.FeedReaderContract.FeedEntry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.volvo.data.Dao;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName() ;
    public static final String FILE_NAME = "volvoprefs";
    public static final int MODE = MODE_PRIVATE;
    EditText nameEditText,pwdEditText;
    Spinner spinner;
    TextView mainTextView;
    Dao dbAcessObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout inflater
        Log.i(TAG,"oncreate");
        nameEditText = findViewById(R.id.editTextName);
        pwdEditText = findViewById(R.id.editTextPassword);
        spinner = findViewById(R.id.spinner);
        mainTextView = findViewById(R.id.textViewmain);

        dbAcessObj = new Dao(this);
        dbAcessObj.openDb();
        ListView dbListView = findViewById(R.id.listviewdb);

        Cursor dataCursor = dbAcessObj.readRow();

        CursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,//row layout
                dataCursor, //data
                new String[]{FeedEntry.COLUMN_NAME_TITLE,FeedEntry.COLUMN_NAME_SUBTITLE},//col names in table
               new int[]{android.R.id.text1, android.R.id.text2},
               1); //textviews of each row

        dbListView.setAdapter(adapter);

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
        saveData();

    }

    private void saveData() {
        //create a file volvoprefs
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE);
        //open the file in edit mode
        SharedPreferences.Editor editor = preferences.edit();
        //get data from 2 edittexts
        String name = nameEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();
        //write to file
        editor.putString("nm",name);
        editor.putString("pw",pwd);
        //save the file
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onresume");
        restoreData();

    }
    private void restoreData(){
        //open the file
        SharedPreferences preferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        //read from the file
        String name = preferences.getString("nm","");
        String pwd = preferences.getString("pw","");
        //write data into edittexts
        nameEditText.setText(name);
        pwdEditText.setText(pwd);

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
       /* String directorypath = null;
        String filename = null;
        File myFile = new File(directorypath, filename);*/
    }

    public void clickHandler(View view) {

        switch (view.getId()){
            case R.id.buttonLogin:
               // Toast.makeText(this, "android @ volvo", Toast.LENGTH_SHORT).show();
               /* Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);//explicit intent
                hIntent.putExtra("mykey","abdul ansari");
                //startActivity(hIntent);
                startActivityForResult(hIntent,1234);*/
              String name =  nameEditText.getText().toString();
              String pwd = pwdEditText.getText().toString();
              //put data in db
                dbAcessObj.createRow(name,pwd);
              //mainTextView.setText(name);
                break;
            case R.id.buttonCancel:
               // Intent driveIntent =  new Intent("com.google.android.apps.docs.DRIVE_OPEN");
                /*Intent dIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"));//implicit intent
                startActivity(dIntent);*/

                //get data from db and put it in textview
                Cursor cursor = dbAcessObj.readRow();
                cursor.moveToLast();
                int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE);
                int subtitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);
                String data = cursor.getString(titleIndex)+"\n"+cursor.getString(subtitleIndex);
                mainTextView.setText(data);
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
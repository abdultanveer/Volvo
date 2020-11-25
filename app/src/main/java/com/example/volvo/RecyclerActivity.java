package com.example.volvo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecyclerActivity extends AppCompatActivity {

    String[] languages = new String[]{"hindi","kannada","english"}; //plug
    ListView langsListView; //socket
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        langsListView = findViewById(R.id.languagesListview);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, // layout of each row in the listview
                languages);
        langsListView.setAdapter(adapter);
    }
}
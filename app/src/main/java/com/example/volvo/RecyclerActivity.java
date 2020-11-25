package com.example.volvo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RecyclerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] languages = new String[]{"hindi","kannada","english"}; //plug
    ListView langsListView; //socket
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        langsListView = findViewById(R.id.languagesListview);

        langsListView.setOnItemClickListener(this);

        adapter = new ArrayAdapter<>(this,
                R.layout.list_row,
                R.id.textViewrow,//new int[]{R.id.text1,R.id.text2}
                //android.R.layout.simple_list_item_1, // layout of each row in the listview
                languages);
        langsListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String item = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();

    }
}
package com.example.volvo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.volvo.adapters.MyAdapter;
import com.example.volvo.model.TodoNote;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] languages = new String[]{"hindi","kannada","english"}; //plug
    RecyclerView langsListView; //socket--- holder design pattern is optional
    MyAdapter adapter;
    ArrayList<TodoNote> todoNoteArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        createData();

        langsListView = findViewById(R.id.languagesListview);
        adapter = new MyAdapter(this,todoNoteArrayList);

        //langsListView.setOnItemClickListener(this);

        /*adapter = new ArrayAdapter<>(this,
                R.layout.list_row,
                R.id.textViewrow,//new int[]{R.id.text1,R.id.text2}
                //android.R.layout.simple_list_item_1, // layout of each row in the listview
                languages);*/
        langsListView.setLayoutManager(new LinearLayoutManager(this)); //layout manager helps arrange the planks vertically/horizontally/grid/staggered grid

        langsListView.setAdapter(adapter);
    }

    private void createData() {
        todoNoteArrayList = new ArrayList<>();
        todoNoteArrayList.add(new TodoNote("title","subtitle"));
        todoNoteArrayList.add(new TodoNote("title","subtitle"));
        todoNoteArrayList.add(new TodoNote("title","subtitle"));
        todoNoteArrayList.add(new TodoNote("title","subtitle"));
        todoNoteArrayList.add(new TodoNote("title","subtitle"));
        todoNoteArrayList.add(new TodoNote("title","subtitle"));

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String item = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();

    }
}
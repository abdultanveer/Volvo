package com.example.volvo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
        Button coButton = findViewById(R.id.contextbuttto);

        registerForContextMenu(coButton);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater(); //inflater will inflate the recycler_menu.xml
        menuInflater.inflate(R.menu.recycler_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
             case R.id.first:
                 Toast.makeText(this, "first selected", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.second:
                 Toast.makeText(this, "second selected", Toast.LENGTH_SHORT).show();

                 break;
         }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.recycler_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         super.onContextItemSelected(item);
        Toast.makeText(this, "context item selected", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
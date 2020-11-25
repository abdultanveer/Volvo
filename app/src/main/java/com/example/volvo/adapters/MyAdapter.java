package com.example.volvo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.volvo.R;
import com.example.volvo.model.TodoNote;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.WordViewHolder> {
    ArrayList<TodoNote> todoNotes;
    //Context mContext;
    LayoutInflater miLayoutInflater;

    public MyAdapter(Context context, ArrayList<TodoNote> todoNoteArrayList) {
        todoNotes = todoNoteArrayList;
        //mContext = context;
        miLayoutInflater = LayoutInflater.from(context);
    }



    /**
     * onCreateViewHolder -- punith
     * to buy new row planks as and when required
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mitemView = miLayoutInflater.inflate(R.layout.list_row,parent,false);
        return new WordViewHolder(mitemView);
    }

    /**
     * onBindViewHolder -- rachita -- handwriting
     * to write data into the row planks
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.WordViewHolder holder, int position) {
        holder.titleTextView.setText(todoNotes.get(position).getTitle());
        holder.subtitleTextView.setText(todoNotes.get(position).getSubTitle());

        //todoNotes.get(position).toString());
    }

    /**
     * getItemCount --- sunil
     * keep the count in the dataset/db and inform punith
     * @return
     */
    @Override
    public int getItemCount() {
        return todoNotes.size();
    }

    /**
     * This is like a box holding the stocked row planks
     */
    public class WordViewHolder  extends  RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView subtitleTextView;

        public WordViewHolder(@NonNull View itemView) { //the mitemview you return from oncreateviewholder
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewtitle);
            subtitleTextView = itemView.findViewById(R.id.textviewsubtitle);

        }
    }
}

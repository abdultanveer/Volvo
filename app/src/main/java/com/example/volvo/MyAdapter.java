package com.example.volvo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.WordViewHolder> {
    String[] langs;
    //Context mContext;
    LayoutInflater miLayoutInflater;

    public MyAdapter(Context context, String[] languages) {
        langs = languages;
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
        holder.rowTextView.setText(langs[position]);
    }

    /**
     * getItemCount --- sunil
     * keep the count in the dataset/db and inform punith
     * @return
     */
    @Override
    public int getItemCount() {
        return langs.length;
    }

    /**
     * This is like a box holding the stocked row planks
     */
    public class WordViewHolder  extends  RecyclerView.ViewHolder{
        TextView rowTextView;

        public WordViewHolder(@NonNull View itemView) { //the mitemview you return from oncreateviewholder
            super(itemView);
            rowTextView = itemView.findViewById(R.id.textViewrow);
        }
    }
}

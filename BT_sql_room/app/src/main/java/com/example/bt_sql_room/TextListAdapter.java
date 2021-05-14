package com.example.bt_sql_room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TextListAdapter extends RecyclerView.Adapter<TextViewHodel> {
    private ArrayList<Text> texts;
    private LayoutInflater inflater;
    private Context context;

    public TextListAdapter(ArrayList<Text> texts, Context context) {
        this.texts = texts;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TextViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_itemtext,parent,false);
        return new TextViewHodel(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHodel holder, int position) {
        Text text = texts.get(position);
        holder.txtText.setText(text.getId() + "." + text.getName());
        holder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }
}

class TextViewHodel extends RecyclerView.ViewHolder{
    public final TextView txtText;
    public final ImageButton imgUpdate;
    public final ImageButton imgDelete;
    final TextListAdapter adapter;

    public TextViewHodel(@NonNull View itemView, TextListAdapter adapter) {
        super(itemView);
        this.txtText = itemView.findViewById(R.id.txtTextEdit);
        this.imgUpdate = itemView.findViewById(R.id.imgUpdate);
        this.imgDelete = itemView.findViewById(R.id.imgDelete);
        this.adapter = adapter;
    }
}
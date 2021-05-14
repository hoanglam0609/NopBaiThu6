package com.example.bt_sql_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextListAdapter textListAdapter;
    private Button btnSave;
    private Button btnCancel;
    private EditText txtTextEdit;
    private ArrayList<Text> texts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-text").allowMainThreadQueries().build();

        texts = new ArrayList<>();
        Text text1 = new Text("Long An");
        Text text2 = new Text("Trà Vinh");
        Text text3 = new Text("Vĩnh Long");
        Text text4 = new Text("Bạc Liêu");
        Text text5 = new Text("Đồng Tháp");
        Text text6 = new Text("Tây Ninh");
        Text text7 = new Text("Bình Thuận");
//
        TextDao textDao = db.textDao();
        textDao.insertAll(text1);
        textDao.insertAll(text2);
        textDao.insertAll(text3);
        textDao.insertAll(text4);
        textDao.insertAll(text5);
        textDao.insertAll(text6);
        textDao.insertAll(text7);
        List<Text> list = textDao.getAll();
        texts.addAll(list);


        recyclerView = findViewById(R.id.recycleviewtext);

        textListAdapter = new TextListAdapter(texts, this);

        recyclerView.setAdapter(textListAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        txtTextEdit = findViewById(R.id.txtTextEdit);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = String.valueOf(txtTextEdit.getText());

                Text text = new Text(t);

                textDao.insertAll(text);

                ArrayList<Text> list = new ArrayList<>();
                list.addAll(textDao.getAll());
                textListAdapter = new TextListAdapter(list, v.getContext());
                recyclerView.setAdapter(textListAdapter);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
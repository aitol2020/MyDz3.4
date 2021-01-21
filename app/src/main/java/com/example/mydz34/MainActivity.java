package com.example.mydz34;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MainAdapter adapter;
    private List<TytleModel> list;
    Button button;
    EditText editText;
    EditText editTextop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();

    }

    private void setUp() {
        editText = findViewById(R.id.edittext1);
        editTextop = findViewById(R.id.edittext2);
        recyclerView = findViewById(R.id.recycler);
        button = findViewById(R.id.btnAdd);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new MainAdapter((ArrayList<TytleModel>) list, this);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText.getText().toString();
                String des = editTextop.getText().toString();
                TytleModel model = new TytleModel();
                model.setTytle(title);
                model.setDes(des);
                model.setDate(new Date(System.currentTimeMillis()));
                Log.d("date",String.valueOf(System.currentTimeMillis()));
                adapter.addText(model);
                list.add(model);
            }
        });

    }

}
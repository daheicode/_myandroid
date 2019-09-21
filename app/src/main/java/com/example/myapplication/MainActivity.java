package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private Test02Adapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("");
        }

        TestAdapter adapter = new TestAdapter(this, R.layout.item, datas);
        adapter.setOnAddListener(new TestAdapter.OnAddListener() {
            @Override
            public void addListener(RecyclerView recyclerView, ArrayList<String> datas) {
                datas.add("");
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });
        recycler.setAdapter(adapter);
    }

    public void test(RecyclerView recyclerView, ArrayList<String> datas) {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter1 = new Test02Adapter(MainActivity.this, R.layout.item02, datas);
        recyclerView.setAdapter(adapter1);

    }
}

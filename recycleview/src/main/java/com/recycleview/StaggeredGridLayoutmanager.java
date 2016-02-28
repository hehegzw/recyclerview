package com.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridLayoutmanager extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> words;
    private WordAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_layoutmanager);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        initData();
        adapter = new WordAdapter(this,words);
        recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        words = new ArrayList<>();
        for(int i=0;i<100;i++){
            words.add(i+"");
        }
    }
}

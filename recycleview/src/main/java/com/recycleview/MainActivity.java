package com.recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnRecyclerViewListener {
    private RecyclerView recyclerView;
    private List<Person> persons;
    private PersonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        initData();
        adapter = new PersonAdapter(persons);
        adapter.setOnRecyclerViewListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayout.HORIZONTAL));
        initButton();
    }

    private void initButton() {
        Button add = (Button) findViewById(R.id.add_item);
        Button delete = (Button) findViewById(R.id.delete_item);
        Button image = (Button) findViewById(R.id.image);
        Button gridl = (Button) findViewById(R.id.gridl);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person("add",100);
                adapter.notifyItemInserted(3);
                persons.add(3,p);
                adapter.notifyItemRangeChanged(3,adapter.getItemCount());
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyItemInserted(3);
                persons.remove(3);
                adapter.notifyItemRangeChanged(3,adapter.getItemCount());
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
                finish();
            }
        });
        gridl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StaggeredGridLayoutmanager.class));
                finish();
            }
        });
    }

    private void initData() {
        persons = new ArrayList<>();
        for(int i=0;i<20;i++){
            persons.add(new Person("hehe"+i,i+10));
        }
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"点击"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(int position) {
        Toast.makeText(this,"长安"+position,Toast.LENGTH_SHORT).show();
        return false;
    }
}

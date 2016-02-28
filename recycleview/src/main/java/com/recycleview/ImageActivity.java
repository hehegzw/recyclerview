package com.recycleview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity implements ImageAdapter.OnclickListener {
    private RecyclerView recyclerView;
    private ImageView bigimage;
    private List<Image> images;
    private ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        initData();
        adapter = new ImageAdapter(this,images);
        adapter.setOnclickListener(this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
        bigimage = (ImageView) findViewById(R.id.bigimage);
    }

    private void initData() {
        images = new ArrayList<>();
        images.add(new Image(R.drawable.a,"hehe1"));
        images.add(new Image(R.drawable.b,"hehe2"));
        images.add(new Image(R.drawable.c,"hehe3"));
        images.add(new Image(R.drawable.d,"hehe4"));
        images.add(new Image(R.drawable.e,"hehe5"));
        images.add(new Image(R.drawable.f,"hehe6"));
        images.add(new Image(R.drawable.a,"hehe1"));
        images.add(new Image(R.drawable.b,"hehe2"));
        images.add(new Image(R.drawable.c,"hehe3"));
        images.add(new Image(R.drawable.d,"hehe4"));
        images.add(new Image(R.drawable.e,"hehe5"));
        images.add(new Image(R.drawable.f,"hehe6"));
        images.add(new Image(R.drawable.a,"hehe1"));
        images.add(new Image(R.drawable.b,"hehe2"));
        images.add(new Image(R.drawable.c,"hehe3"));
        images.add(new Image(R.drawable.d,"hehe4"));
        images.add(new Image(R.drawable.e,"hehe5"));
        images.add(new Image(R.drawable.f,"hehe6"));
        images.add(new Image(R.drawable.a,"hehe1"));
        images.add(new Image(R.drawable.b,"hehe2"));
        images.add(new Image(R.drawable.c,"hehe3"));
        images.add(new Image(R.drawable.d,"hehe4"));
        images.add(new Image(R.drawable.e,"hehe5"));
        images.add(new Image(R.drawable.f,"hehe6"));
    }

    @Override
    public void click(int position) {
        Log.d("ImageActivity","is"+position);
        bigimage.setImageResource(images.get(position).imageId);
    }
}

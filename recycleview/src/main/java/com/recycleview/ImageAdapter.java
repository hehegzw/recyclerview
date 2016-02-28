package com.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gzw on 2016/2/28.
 */
public class ImageAdapter extends RecyclerView.Adapter {
    private List<Image> images;
    private LayoutInflater inflater;
    private OnclickListener onclickListener;


    public ImageAdapter(Context context,List<Image> images) {
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.sub_imageadapter,viewGroup,false);
        ImageHolder holder = new ImageHolder(view);
        holder.imageView = (ImageView) view.findViewById(R.id.image);
        holder.textView = (TextView) view.findViewById(R.id.text);
        holder.position = i;
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ImageHolder holder = (ImageHolder) viewHolder;
        holder.imageView.setImageResource(images.get(i).imageId);
        holder.textView.setText(images.get(i).iamgeName);
        holder.position = i;
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
    private class ImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        public int position;
        public ImageHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onclickListener!=null){
                onclickListener.click(position);
            }
        }
    }
    public interface OnclickListener{
        void click(int position);
    }
}

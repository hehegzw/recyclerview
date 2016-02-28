package com.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by gzw on 2016/2/28.
 */
public class WordAdapter extends RecyclerView.Adapter {
    private List<String> words;
    private LayoutInflater inflater;

    public WordAdapter(Context context,List<String> words) {
        this.words = words;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.sub_wordadapter,viewGroup,false);

        return new WordHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        WordHolder holder = (WordHolder) viewHolder;
        holder.text.setText(words.get(i));
        ViewGroup.LayoutParams lp = holder.text.getLayoutParams();
        lp.height = (int) (100+Math.random()*300);
        holder.text.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }
    private class WordHolder extends RecyclerView.ViewHolder{
        public TextView text;
        public WordHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}

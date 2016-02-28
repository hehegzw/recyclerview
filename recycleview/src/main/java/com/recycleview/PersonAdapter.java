package com.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gzw on 2016/2/27.
 */
public class PersonAdapter extends RecyclerView.Adapter {
    private OnRecyclerViewListener onRecyclerViewListener;
    private List<Person> persons;

    public PersonAdapter(List<Person> persons) {
        this.persons = persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_recyclerview,null);

        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        PersonViewHolder holder = (PersonViewHolder) viewHolder;
        holder.position = i;
        String name = persons.get(i).name;
        holder.nameText.setText(name);
        holder.ageText.setText(persons.get(i).age+"");
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
    private class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public View view;
        public TextView nameText;
        public TextView ageText;
        public int position;
        public ViewGroup rootView;
        public PersonViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            nameText = (TextView) view.findViewById(R.id.name);
            ageText = (TextView) view.findViewById(R.id.age);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onRecyclerViewListener!=null){
                onRecyclerViewListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(onRecyclerViewListener!=null){
                onRecyclerViewListener.onItemLongClick(position);
            }
            return false;
        }
    }
    public static interface OnRecyclerViewListener{
        void onItemClick(int position);
        boolean onItemLongClick(int position);
    }
}

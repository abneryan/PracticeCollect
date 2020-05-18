package com.abner.practicecollect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private List<String> mData = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    public MainAdapter(List<String> data){
        mData = data;
    }
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mian_recyclerview_item, parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainViewHolder holder, final int position) {
        holder.titleTV.setText(mData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(holder.itemView,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener{
        void onItemClick(View view, int pisition);
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTV;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.main_recyclerView_title);
        }
    }
}

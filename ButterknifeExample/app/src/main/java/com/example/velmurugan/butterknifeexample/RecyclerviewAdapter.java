package com.example.velmurugan.butterknifeexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private List<Movie> movieList;
    RecyclerviewAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerviewAdapter.MyViewHolder holder, int position) {
        holder.title.setText(movieList.get(position).getTitle());
        holder.desc.setText(movieList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewTitle)
        TextView title;
        @BindView(R.id.textViewDesc) TextView desc;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

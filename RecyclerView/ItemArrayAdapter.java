package com.example.hasibuzzaman.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hasibuzzaman on 2/21/2018.
 */

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.MyViewHolder> {

    Context mContext; ArrayList<String> myDatas;

    ItemArrayAdapter(Context mContext,ArrayList<String> myDatas)
    {
        this.mContext = mContext;
        this.myDatas = myDatas;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder // implements View.OnClickListener
    {
        public TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textNames);
        }

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_recylerview, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView names = holder.name;
        names.setText(myDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return myDatas.size();
    }
}

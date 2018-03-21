package com.manre.airappproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by manre on 21/03/2018.
 */

public abstract class  BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHolder> {

    private List<T> mData;
    private Context mContext;

    public BaseRecyclerAdapter()
    {

    }
    public BaseRecyclerAdapter(Context context,List<T> data)
    {
        this.mData = data;
        this.mContext = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public abstract BaseRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(@NonNull BaseRecyclerHolder holder, int position);


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}

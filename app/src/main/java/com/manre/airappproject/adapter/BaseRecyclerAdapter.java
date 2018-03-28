package com.manre.airappproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manre.airappproject.R;
import com.manre.airappproject.common.OnItemClickLitener;

import java.util.List;

/**
 * Created by manre on 21/03/2018.
 */

public abstract class  BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHolder> {

    private List<T> mDataList;
    private Context mContext;
    private int replaceLayout;
    private OnItemClickLitener mOnItemClickLitener;
    IMulItemViewType<T> mMulItemViewType;



    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public BaseRecyclerAdapter()
    {

    }
    public void BaseRecyclerAdapter(Context context,List<T> mDataList,int replaceLayout)
    {
        this.mDataList = mDataList;
        this.mContext = context;
        this.replaceLayout=replaceLayout;
    }

    public List<T> getDataList() {
        return mDataList;
    }

    public void setDataList(List<T> dataList) {
        mDataList = dataList;
    }

    @NonNull
    @Override
    public  BaseRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(replaceLayout,parent,false);
        BaseRecyclerHolder holder = BaseRecyclerHolder.get(null,view);
        return holder;
    }

    @Override
    public  void onBindViewHolder(@NonNull BaseRecyclerHolder holder, final int position){
        if( mOnItemClickLitener!= null){
            holder.itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(position);
                }
            });
            holder. itemView.setOnLongClickListener( new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickLitener.onItemLongClick(position);
                    return false;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }
    
    @Override
    public int getItemViewType(int position) {
        if (mMulItemViewType != null) {
            return mMulItemViewType.getItemViewType(position, mDataList.get(position));
        }else{
            return super.getItemViewType(position);
        }
    }
}

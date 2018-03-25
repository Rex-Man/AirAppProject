package com.manre.airappproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by manre on 21/03/2018.
 */

public class BaseRecyclerHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> childViews = new SparseArray<>();
    protected BaseRecyclerHolder(View itemView) {
        super(itemView);
    }

    public static BaseRecyclerHolder get(View convertView, View itemView) {
        BaseRecyclerHolder holder;
        if (convertView == null) {
            holder = new BaseRecyclerHolder(itemView);
            convertView = itemView;
            convertView.setTag(holder);
        } else {
            holder = (BaseRecyclerHolder) convertView.getTag();
        }
        return holder;
    }
    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(int id) {
        View childView = childViews.get(id);
        if (childView == null) {
            childView = itemView.findViewById(id);
            if (childView != null)
                childViews.put(id, childView);
            else
                return null;
        }
        return (T) childView;
    }


}

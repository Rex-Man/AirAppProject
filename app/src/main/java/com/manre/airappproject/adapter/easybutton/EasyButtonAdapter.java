package com.manre.airappproject.adapter.easybutton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manre.airappproject.adapter.BaseRecyclerAdapter;
import com.manre.airappproject.adapter.BaseRecyclerHolder;

import java.util.List;

/**
 * Created by manre on 21/03/2018.
 */

public class EasyButtonAdapter extends BaseRecyclerAdapter<String> {

    public void setDataAndContext(Context context, List<String> data)
    {
         BaseRecyclerAdapter(context,data);
    }

    @NonNull
    @Override
    public BaseRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View v= LayoutInflater.from()
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerHolder holder, int position) {

    }
}

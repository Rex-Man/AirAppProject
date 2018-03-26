package com.manre.airappproject.adapter.easybutton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.manre.airappproject.R;
import com.manre.airappproject.adapter.BaseRecyclerAdapter;
import com.manre.airappproject.adapter.BaseRecyclerHolder;

import java.util.List;

/**
 * Created by manre on 21/03/2018.
 */

public class EasyButtonAdapter extends BaseRecyclerAdapter<Integer> {



    public EasyButtonAdapter(Context context, List<Integer> data,int replaceLayout)
    {
        BaseRecyclerAdapter(context,data,replaceLayout);
    }




    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerHolder holder, int position) {
        super.onBindViewHolder(holder,position);
        int buttonResource= getDataList().get(position);

        ImageView shownButton=holder.findViewById(R.id.easy_button);
        shownButton.setImageResource(buttonResource);
        
    }
}

package com.manre.airappproject.adapter.typeinformation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.manre.airappproject.R;
import com.manre.airappproject.adapter.BaseRecyclerAdapter;
import com.manre.airappproject.adapter.BaseRecyclerHolder;
import com.manre.airappproject.adapter.IMulItemViewType;
import com.manre.airappproject.fragment.home.model.TypeInformation;

import java.util.List;

/**
 * Created by manlimeng on 2018/3/28.
 */

public class TypeInformationAdapter extends BaseRecyclerAdapter<TypeInformation> {

    public TypeInformationAdapter (Context context, List<TypeInformation> data, int replaceLayout,IMulItemViewType<TypeInformation> multiItemViewType)
    {
        BaseRecyclerAdapter(context,data,replaceLayout,multiItemViewType);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerHolder holder, int position) {
        super.onBindViewHolder(holder,position);
        TypeInformation mtypeInformation= getDataList().get(position);
        int multType=getItemViewType(position);
        switch(multType)
        {

            case 0:

                break;
            case 1:
                break;
        }
    }

}

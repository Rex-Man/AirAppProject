package com.manre.airappproject.adapter.typeinformation;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.manre.airappproject.R;
import com.manre.airappproject.adapter.BaseRecyclerAdapter;
import com.manre.airappproject.adapter.BaseRecyclerHolder;
import com.manre.airappproject.adapter.IMulItemViewType;
import com.manre.airappproject.fragment.home.model.TypeInformation;
import com.manre.airappproject.fragment.home.model.TypeInformationDetail;

import java.util.ArrayList;
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
                TextView titleShown1=holder.findViewById(R.id.home_information1_title);
                titleShown1.setText(mtypeInformation.getTitle());
                List<TypeInformationDetail> typeInformationDetails=mtypeInformation.getTypeInformationDetails();
                for (TypeInformationDetail typeInformationDetail : typeInformationDetails)
                {
                    switch (typeInformationDetail.getInformationType())
                    {
                        case 0:
                            setOnclickAndResource(holder,R.id.home_information1_bigiv,typeInformationDetail);
                            break;
                        case 1:
                            setOnclickAndResource(holder,R.id.home_information1_smiv1,typeInformationDetail);
                            break;
                        case 2:
                            setOnclickAndResource(holder,R.id.home_information1_smiv2,typeInformationDetail);
                            break;
                        case 3:
                            setOnclickAndResource(holder,R.id.home_information1_smiv3,typeInformationDetail);
                            break;
                    }

                }
                break;
            case 1:
                TextView titleShown2=holder.findViewById(R.id.home_information2_title);
                titleShown2.setText(mtypeInformation.getTitle());
                List<TypeInformationDetail> typeInformationDetails2=mtypeInformation.getTypeInformationDetails();
                for (TypeInformationDetail typeInformationDetail : typeInformationDetails2)
                {
                    switch (typeInformationDetail.getInformationType())
                    {
                        case 0:
                            setOnclickAndResource(holder,R.id.home_information2_bigiv,typeInformationDetail);
                            break;
                        case 1:
                            setOnclickAndResource(holder,R.id.home_information2_smiv1,typeInformationDetail);
                            break;
                        case 2:
                            setOnclickAndResource(holder,R.id.home_information2_smiv2,typeInformationDetail);
                            break;
                        case 3:
                            setOnclickAndResource(holder,R.id.home_information2_smiv3,typeInformationDetail);
                            break;
                    }

                }

                break;
        }
    }

    private void setOnclickAndResource(@NonNull BaseRecyclerHolder holder,int layoutResId,TypeInformationDetail mTypeInformationDetail)
    {


        ImageView shownImage=holder.findViewById(layoutResId);
        shownImage.setImageResource( mTypeInformationDetail.getImageDrawableBigId());
        shownImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(),"你点击", Toast.LENGTH_LONG);//提示被点击了
                toast.show();
            }
        });
    }

}

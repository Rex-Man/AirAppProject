package com.manre.airappproject.adapter;

import android.support.annotation.LayoutRes;

/**
 * Created by manre on 28/03/2018.
 */

public interface IMulItemViewType<T> {

    int getItemViewType(int position, T t);


    @LayoutRes
    int getLayoutId(int viewType);
}

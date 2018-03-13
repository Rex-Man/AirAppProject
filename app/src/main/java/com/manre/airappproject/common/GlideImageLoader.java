package com.manre.airappproject.common;


import android.content.Context;
import android.widget.ImageView;

import com.manre.airappproject.R;
import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by manre on 12/03/2018.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Integer dd=Integer.valueOf(path.toString());
        Picasso.get().load(dd.intValue()).into(imageView);
    }
}

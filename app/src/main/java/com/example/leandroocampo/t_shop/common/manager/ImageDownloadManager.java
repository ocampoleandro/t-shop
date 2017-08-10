package com.example.leandroocampo.t_shop.common.manager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Manager to download images and insert them into {@link android.widget.ImageView}
 */
public class ImageDownloadManager {

    public static void downloadImageIntoImageView(Context context, ImageView imageView, String url, int width, int height){
        Glide.with(context).load(url)
                .override(width, height)
                .into(imageView);
    }

}

package com.example.imageloaderlib;

import android.view.View;

public interface ImageLoader {

    void showImage(View v, String url, ImageLoaderOptions options);

    void showImage(View v, int drawable, ImageLoaderOptions options);

    void defaultImage(View v, String url);
}

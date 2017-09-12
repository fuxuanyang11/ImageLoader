package com.example.imageloaderlib;

import android.view.View;

public class ImageLoaderManager implements ImageLoader {

    private static final ImageLoaderManager INSTANCE = new ImageLoaderManager();

    private ImageLoader imageLoader;
    private ImageLoaderManager(){
        //默认使用Glide
        imageLoader=new GlideImageLoader();
    }
    public static ImageLoaderManager getInstance(){
        return INSTANCE;
    }
    //可实时替换图片加载框架
    public void setImageLoader(ImageLoader loader) {
        if (loader != null) {
            imageLoader=loader;
        }
    }

    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        imageLoader.showImage(v, url, options);
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        imageLoader.showImage(v, drawable, options);
    }

    @Override
    public void defaultImage(View v, String url) {
        imageLoader.defaultImage(v, url);
    }
}

package com.example.imageloaderlib;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;


public class GlideImageLoader implements ImageLoader {

    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            //加载基本参数
            DrawableTypeRequest typeRequest = Glide.with(imageView.getContext()).load(url);
            //装载附加参数
            loadOptions(typeRequest, options).into(imageView);
        }
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            //加载基本参数
            DrawableTypeRequest typeRequest = Glide.with(imageView.getContext()).load(drawable);
            //装载附加参数
            loadOptions(typeRequest, options).into(imageView);
        }
    }

    @Override
    public void defaultImage(View v, String url) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            Glide.with(imageView.getContext())
                    .load(url)
                    .placeholder(R.drawable.ic_default_image)
                    .error(R.drawable.ic_default_image)
                    .into(imageView);
        }
    }


    //这个方法用来装载由外部设置的参数
    private DrawableTypeRequest loadOptions(DrawableTypeRequest dtr,ImageLoaderOptions options){

        if (options==null) {
            return dtr;
        }
        if (options.getPlaceHolder()!=-1) {
            dtr.placeholder(options.getPlaceHolder());
        }
        if (options.getErrorDrawable()!=-1){
            dtr.error(options.getErrorDrawable());
        }
        if (options.isCrossFade()) {
            dtr.crossFade();
        }
        if (options.isSkipMemoryCache()){
            dtr.skipMemoryCache(options.isSkipMemoryCache());
        }
        if (options.getSize()!=null) {
            dtr.override(options.getSize().reWidth,options.getSize().reHeight);
        }
        return dtr;
    }

}

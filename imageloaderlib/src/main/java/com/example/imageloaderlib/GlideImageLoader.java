package com.example.imageloaderlib;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;


public class GlideImageLoader implements ImageLoader {

    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            //加载基本参数
//            DrawableTypeRequest typeRequest = Glide.with(imageView.getContext()).load(url);
            RequestOptions requestOptions = new RequestOptions();
            Glide.with(imageView.getContext()).load(url)
                    .apply(loadOptions(requestOptions, options))
                    .into(imageView);


        }
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            //加载基本参数
            RequestOptions requestOptions = new RequestOptions();
            Glide.with(imageView.getContext()).load(drawable)
                    .apply(loadOptions(requestOptions, options))
                    .into(imageView);
        }
    }

    @Override
    public void defaultImage(View v, String url) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            Glide.with(imageView.getContext())
                    .load(url)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_default_image)
                            .error(R.drawable.ic_default_image))
                    .into(imageView);
        }
    }


    private RequestOptions loadOptions(RequestOptions requestOptions, ImageLoaderOptions options){

        if (options==null) {
            return requestOptions;
        }
        if (options.getPlaceHolder()!=-1) {
            requestOptions.placeholder(options.getPlaceHolder());

        }
        if (options.getErrorDrawable()!=-1){
            requestOptions.error(options.getErrorDrawable());
        }
        if (options.isCrossFade()) {
//            requestOptions.crossFade();
        }
        if (options.isSkipMemoryCache()){
            requestOptions.skipMemoryCache(options.isSkipMemoryCache());
        }
        if (options.getSize()!=null) {
            requestOptions.override(options.getSize().reWidth,options.getSize().reHeight);
        }
        return requestOptions;
    }


}

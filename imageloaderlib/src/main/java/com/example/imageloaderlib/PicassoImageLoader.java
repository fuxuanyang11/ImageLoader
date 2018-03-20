package com.example.imageloaderlib;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import static com.squareup.picasso.MemoryPolicy.NO_CACHE;
import static com.squareup.picasso.MemoryPolicy.NO_STORE;


public class PicassoImageLoader implements ImageLoader {

    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            //加载基本参数
            RequestCreator requestCreator = Picasso.with(imageView.getContext()).load(url);
            //装载附加参数
            loadOptions(requestCreator, options).into(imageView);
        }
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            //加载基本参数
            RequestCreator requestCreator = Picasso.with(imageView.getContext()).load(drawable);
            //装载附加参数
            loadOptions(requestCreator, options).into(imageView);
        }
    }

    @Override
    public void defaultImage(View v, String url) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            Picasso.with(imageView.getContext())
                    .load(url)
                    .placeholder(R.drawable.ic_default_image)
                    .error(R.drawable.ic_default_image)
                    .into(imageView);
        }
    }


    //这个方法用来装载由外部设置的参数
    private RequestCreator loadOptions(RequestCreator requestCreator,ImageLoaderOptions options){

        if (options==null) {
            return requestCreator;
        }
        if (options.getPlaceHolder()!=-1) {
            requestCreator.placeholder(options.getPlaceHolder());
        }
        if (options.getErrorDrawable()!=-1){
            requestCreator.error(options.getErrorDrawable());
        }
        if (options.isCrossFade()) {
            requestCreator.noFade();
        }
        if (options.isSkipMemoryCache()){
            requestCreator.memoryPolicy(NO_CACHE, NO_STORE);
        }
        if (options.getSize()!=null) {
            requestCreator.resize(options.getSize().reWidth,options.getSize().reHeight);
        }
        return requestCreator;
    }

}

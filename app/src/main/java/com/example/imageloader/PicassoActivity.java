package com.example.imageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.imageloaderlib.GlideImageLoader;
import com.example.imageloaderlib.ImageLoaderManager;
import com.example.imageloaderlib.ImageLoaderOptions;
import com.example.imageloaderlib.PicassoImageLoader;

public class PicassoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);


        final String url = "http://imgstore04.cdn.sogou.com/app/a/100520024/877e990117d6a7ebc68f46c5e76fc47a";
        final ImageView imageView = findViewById(R.id.picasso_img);
        Button loadNet = findViewById(R.id.load_net);
        Button loadLocal = findViewById(R.id.load_local);


        //动态配置图片加载库
        ImageLoaderManager.getInstance().setImageLoader(new PicassoImageLoader());

        //图片
        final ImageLoaderOptions imageLoaderOptions = new ImageLoaderOptions.Builder()
                .placeHolder(R.drawable.ic_launcher_background)//设置占位图
                .errorDrawable(R.drawable.ic_default_image)//设置错误显示图片
                .isCrossFade(true)//是否渐变平滑的显示图片
                .isSkipMemoryCache(true)//是否跳过内存缓存
                .reSize(new ImageLoaderOptions.ImageReSize(500, 500))//重新设定容器宽高
                .build();


        loadNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //默认使用Glide，简单使用方式.
//                ImageLoaderManager.getInstance().defaultImage(imageView, url);
                //加载网络图片
                ImageLoaderManager.getInstance().showImage(imageView, url, imageLoaderOptions);
            }
        });

        loadLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //加载本地图片
                ImageLoaderManager.getInstance().showImage(imageView, R.drawable.e_bw, imageLoaderOptions);
            }
        });
    }
}

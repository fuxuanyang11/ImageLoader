package com.example.imageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.imageloaderlib.GlideImageLoader;
import com.example.imageloaderlib.ImageLoaderManager;
import com.example.imageloaderlib.ImageLoaderOptions;

public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        final String url = "http://img.7139.com/file/201207/04/299ac0ab2be96c216c6bd5255945cb6c.jpg";
        final ImageView imageView = findViewById(R.id.glide_img);
        Button loadNet = findViewById(R.id.load_net);
        Button loadLocal = findViewById(R.id.load_local);


        //动态配置图片加载库
        ImageLoaderManager.getInstance().setImageLoader(new GlideImageLoader());

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

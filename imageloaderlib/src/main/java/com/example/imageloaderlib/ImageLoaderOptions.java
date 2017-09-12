package com.example.imageloaderlib;

public class ImageLoaderOptions {

    private int placeHolder=-1; //当没有成功加载的时候显示的图片
    private ImageReSize size=null; //重新设定容器宽高
    private int errorDrawable=-1;  //加载错误的时候显示的drawable
    private boolean isCrossFade=false; //是否渐变平滑的显示图片

    public int getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(int placeHolder) {
        this.placeHolder = placeHolder;
    }

    public ImageReSize getSize() {
        return size;
    }

    public void setSize(ImageReSize size) {
        this.size = size;
    }

    public int getErrorDrawable() {
        return errorDrawable;
    }

    public void setErrorDrawable(int errorDrawable) {
        this.errorDrawable = errorDrawable;
    }

    public boolean isCrossFade() {
        return isCrossFade;
    }

    public void setCrossFade(boolean crossFade) {
        isCrossFade = crossFade;
    }

    public boolean isSkipMemoryCache() {
        return isSkipMemoryCache;
    }

    public void setSkipMemoryCache(boolean skipMemoryCache) {
        isSkipMemoryCache = skipMemoryCache;
    }

    private  boolean isSkipMemoryCache = false; //是否跳过内存缓存
    private ImageLoaderOptions(ImageReSize resize, int placeHolder, int errorDrawable, boolean isCrossFade, boolean isSkipMemoryCache){
        this.placeHolder=placeHolder;
        this.size=resize;
        this.errorDrawable=errorDrawable;
        this.isCrossFade=isCrossFade;
        this.isSkipMemoryCache=isSkipMemoryCache;
    }



    public static class ImageReSize{
        int reWidth=0;
        int reHeight=0;
        public ImageReSize(int reWidth,int reHeight){
            if (reHeight<=0){
                reHeight=0;
            }
            if (reWidth<=0) {
                reWidth=0;
            }
            this.reHeight=reHeight;
            this.reWidth=reWidth;

        }
    }

    public static final  class Builder {
        private int placeHolder = -1;
        private ImageReSize size = null;
        private int errorDrawable = -1;
        private boolean isCrossFade = false;
        private boolean isSkipMemoryCache = false;

        public Builder() {

        }

        public Builder placeHolder(int drawable){
            this.placeHolder=drawable;
            return  this;
        }

        public Builder reSize(ImageReSize size){
            this.size=size;
            return  this;
        }


        public Builder errorDrawable(int errorDrawable){
            this.errorDrawable=errorDrawable;
            return  this;
        }
        public Builder isCrossFade(boolean isCrossFade){
            this.isCrossFade=isCrossFade;
            return  this;
        }
        public Builder isSkipMemoryCache(boolean isSkipMemoryCache){
            this.isSkipMemoryCache=isSkipMemoryCache;
            return  this;
        }

        public ImageLoaderOptions build(){

            return new ImageLoaderOptions(this.size,this.placeHolder,this.errorDrawable,this.isCrossFade,this.isSkipMemoryCache);
        }
    }
}

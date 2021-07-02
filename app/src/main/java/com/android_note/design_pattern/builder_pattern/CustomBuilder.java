package com.android_note.design_pattern.builder_pattern;

import android.util.Log;

/**
 *  建造者模式模拟自定义dialog等写法
 */
public class CustomBuilder {

    public final static String TAG = "CustomBuilder";
    private static String mTitle;//标题
    private static String mContent;//描述内容

    public void init(){
        //初始化相关的操作
    }

    public void doTask(){
        Log.i(TAG,"----"+mTitle+"--------"+mContent);
    }

    //创建builder ：可控制不同展示内容
    public static class Builder{

        public Builder setTitle(String title){
            mTitle = title;
            return this;
        }

        public Builder setContent(String content){
            mContent = content;
            return this;
        }

        public CustomBuilder build(){
            return new CustomBuilder();
        }
    }

}

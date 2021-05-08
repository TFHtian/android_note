package com.android_note.app;

import androidx.multidex.MultiDexApplication;

import com.android_note.client.R;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class BaseApplication extends MultiDexApplication {

    public static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        /*全局字体*/
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/DFPHannotateW5-GB.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

    }
}

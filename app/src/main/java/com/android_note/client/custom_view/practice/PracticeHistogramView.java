package com.android_note.client.custom_view.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PracticeHistogramView extends View {

    public PracticeHistogramView(Context context) {
        super(context);
    }

    public PracticeHistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeHistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }
}

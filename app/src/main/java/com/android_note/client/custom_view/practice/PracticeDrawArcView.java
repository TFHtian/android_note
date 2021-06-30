package com.android_note.client.custom_view.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PracticeDrawArcView extends View {

    private Paint paint = new Paint();

    public PracticeDrawArcView(Context context) {
        super(context);
        init();
    }

    public PracticeDrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeDrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawArc(getWidth()/2 - 200,getHeight()/2 - 100,getWidth()/2 + 200,getHeight()/2 + 100,-80,90,true,paint);
        canvas.drawArc(getWidth()/2 - 200,getHeight()/2 - 100,getWidth()/2 + 200,getHeight()/2 + 100,120,60,false,paint);

    }
}

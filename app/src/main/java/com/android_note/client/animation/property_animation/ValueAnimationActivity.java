package com.android_note.client.animation.property_animation;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

public class ValueAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCustom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);
        initView();
    }

    private void initView() {
        btnCustom = findViewById(R.id.btn_custom);
        btnCustom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_custom:
                animPropertyValues();
                break;
        }
    }

    private void animOfInt(){
        //获取到屏幕宽度
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        //起始值为btn最开始的坐标的x位置， 结束值为 屏幕的最右边，
        ValueAnimator valueAnimator = ValueAnimator.ofInt((int) btnCustom.getTranslationX(), widthPixels);

        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setStartDelay(500);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int currentValue = (int) valueAnimator.getAnimatedValue();
                btnCustom.setTranslationX(currentValue);
                System.out.println("current value:" + currentValue);

            }
        });
        valueAnimator.start();
    }

    private void animOfFloat(){
        //获取到屏幕宽度
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;


        //起始值为btn最开始的宽度， 结束值为 屏幕的宽度。
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(btnCustom.getMeasuredWidth(),widthPixels);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float currentValue = (float) valueAnimator.getAnimatedValue();
                btnCustom.getLayoutParams().width = (int) currentValue;
                //重新绘制
                btnCustom.requestLayout();
                System.out.println("current value:" + currentValue);
            }
        });
        valueAnimator.start();
    }

    private void animPropertyValues(){
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;

        PropertyValuesHolder holder1 = PropertyValuesHolder.ofInt("width", btnCustom.getMeasuredWidth(), widthPixels);
        PropertyValuesHolder holder2 =PropertyValuesHolder.ofInt("height",btnCustom.getMeasuredHeight(),heightPixels-btnCustom.getTop());

        ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(holder1, holder2);
        valueAnimator.setDuration(5000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int width = (int) valueAnimator.getAnimatedValue("width");
                int height = (int) valueAnimator.getAnimatedValue("height");

                btnCustom.getLayoutParams().width = width;
                btnCustom.getLayoutParams().height = height;
                btnCustom.requestLayout();
                System.out.println("width:"+width+"height:"+height);
            }
        });

        valueAnimator.start();
    }

}

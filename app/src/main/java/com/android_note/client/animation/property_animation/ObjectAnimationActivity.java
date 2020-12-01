package com.android_note.client.animation.property_animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

public class ObjectAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCommon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation);
        initView();
    }

    private void initView() {
        btnCommon = findViewById(R.id.btn_common);
        btnCommon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_common:
                setAnim();
                break;
        }
    }

    /**
     * 平移动画
     */
    private void translateAnim(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(btnCommon,"translationX",0f,200f,0f);
        animator.setDuration(2000);
        animator.start();
    }

    /**
     * 旋转动画
     */
    private void rotateAnim(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(btnCommon,"rotation",0,360);
        animator.setDuration(2000);
        animator.start();
    }


    /**
     * 缩放动画
     */
    private void scaleAnim(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(btnCommon,"ScaleX",1f,2f,1f);
        animator.setDuration(2000);
        animator.start();
    }

    /**
     * 透明动画
     */
    private void alphaAnim(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(btnCommon,"Alpha",1f,0.5f,0f,0.5f,1f);
        animator.setDuration(3000);
        animator.start();
    }

    /**
     * 背景颜色切换
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void bgColorAnim(){
        ObjectAnimator animator = ObjectAnimator.ofArgb(btnCommon,"textColor",getResources().getColor(R.color.color_Green),getResources().getColor(R.color.color_Red),getResources().getColor(R.color.color_Blue));
        animator.setRepeatCount(ValueAnimator.INFINITE);//循环
        animator.setRepeatMode(ValueAnimator.REVERSE);//翻转
        animator.setDuration(3000);
        animator.start();
    }

    /**
     * 组合动画
     */
    private void setAnim(){
        AnimatorSet animator = new AnimatorSet();
        animator.playTogether(
                ObjectAnimator.ofFloat(btnCommon,"rotation",0,360,0),
                ObjectAnimator.ofFloat(btnCommon,"scaleX",0,1,1.5f,1),
                ObjectAnimator.ofFloat(btnCommon,"scaleY",0,1,1.5f,1),
                ObjectAnimator.ofFloat(btnCommon,"translationX",0,150),
                ObjectAnimator.ofFloat(btnCommon,"translationY",0,150)
        );
        animator.setDuration(5000);
        animator.start();
    }


}

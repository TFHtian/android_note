package com.android_note.client.animation.view_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 视图动画（view动画，补间动画）
 */
public class CommonViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_view_animation);
        initView();
    }

    private void initView() {
        tvResult = findViewById(R.id.tv_result);
        findViewById(R.id.btn_tran).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_set).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tran:
                translateAnim();
                break;
            case R.id.btn_scale:
                scaleAnim();
                break;
            case R.id.btn_rotate:
                rotateAnim();
                break;
            case R.id.btn_alpha:
                alphaAnim();
                break;
            case R.id.btn_set:
                setAnim();
                break;
        }
    }

    /**
     * 平移动画
     */
    private void translateAnim(){
        //Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        //tvResult.startAnimation(animation);

        TranslateAnimation translateAn = new TranslateAnimation(0,0,0,500);
        translateAn.setDuration(2000);
        translateAn.setRepeatCount(2);
        tvResult.startAnimation(translateAn);
    }

    /**
     * 缩放动画
     */
    private void scaleAnim(){
        //Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        //tvResult.startAnimation(animation);

        ScaleAnimation animation = new ScaleAnimation(1f,2f,1f,2f,getWidth()/2,getHeight()/2);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        tvResult.startAnimation(animation);
    }

    /**
     * 旋转动画
     */
    private void rotateAnim(){
        //Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
        //tvResult.startAnimation(animation);

        RotateAnimation animation = new RotateAnimation(0,360,getWidth()/2,getHeight()/2);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        tvResult.startAnimation(animation);
    }

    /**
     * 透明动画
     */
    private void alphaAnim(){
        //Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
        //tvResult.startAnimation(animation);

        AlphaAnimation animation = new AlphaAnimation(1f,0f);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        tvResult.startAnimation(animation);
    }

    /**
     * 动画集合
     */
    private void setAnim(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.set_anim);
        tvResult.startAnimation(animation);
    }

    private int getWidth() {
        return tvResult.getWidth();
    }

    private int getHeight() {
        return tvResult.getHeight();
    }

}

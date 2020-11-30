package com.android_note.client.animation.drawable_animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

public class DrawableAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imAnim;
    private AnimationDrawable drawableAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);
        initView();
    }

    private void initView() {
        imAnim = findViewById(R.id.im_anim);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                startAnim();
                break;
            case R.id.btn_stop:
                stopAnim();
                break;
        }
    }

    private void startAnim(){
        imAnim.setBackgroundResource(R.drawable.drawable_run);
        drawableAnim = (AnimationDrawable) imAnim.getBackground();
        drawableAnim.start();
    }

    private void stopAnim(){
        if (drawableAnim != null){
            drawableAnim.stop();
        }
    }
}

package com.android_note.client.animation.drawable_animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 逐帧动画 （drawable动画）类似幻灯片（播放一组连续的图片资源） 实质就是drawable 视觉残留效果。
 *
 * 缺陷 ：oom原因 ：给ImageView 设置图片资源 （因为是一系列图片素材） 系统会按顺序把图片都读到内存中
 *          读取方式为bitmap位图形式 所以为内存溢出
 *
 * 方案 ：每次只读一次，过大进行压缩
 */

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

//        //方式一 通过addFrame 添加帧
//        drawableAnim = new AnimationDrawable();
//        drawableAnim.addFrame(getDrawable(R.drawable.run1),100);
//        drawableAnim.addFrame(getDrawable(R.drawable.run2),100);
//        drawableAnim.addFrame(getDrawable(R.drawable.run3),100);
//        for (int i = 0; i <= 10; i++) {
//            int id = getResources().getIdentifier("run" + i, "drawable", getPackageName());
//            Drawable drawable = getResources().getDrawable(id);
//            drawableAnim.addFrame(drawable, 100);
//        }
//        imAnim.setBackground(drawableAnim);//imAnim.setImageDrawable(drawableAnim);
//        drawableAnim.start();

//        //方式二 通过drawable 资源 创建节点animation—list
//        drawableAnim = (AnimationDrawable) getDrawable(R.drawable.drawable_run);
//        imAnim.setBackground(drawableAnim);
//        drawableAnim.start();

        //方式三 通过resource 获取
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

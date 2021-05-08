package com.android_note.client.animation.property_animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 详解：https://juejin.cn/post/6844903908356128775
 * view动画（补间动画，逐帧动画）：
 *      1.只能作用在view视图上 （若只改变颜色动画，即修改的是属性，而非整个视图view）
 *      2.只改变视觉效果，没有改变属性：如view平移之后，只是效果在结束为止，本身还在初始位置，即点击结束位置无效
 *      3.除了本身4种类型效果外的动画。无法实现，单一性
 *
 * 属性动画 ；任意java对象
 *       实质：在一定时间间隔内，通过不断对值进行改变，不断将值赋给对象属性，实现对象属性上动画
 */

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        initView();
    }

    private void initView() {
        imAnim = findViewById(R.id.im_anim);
        imAnim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_anim:
                customAnim();
                break;
        }
    }

    /**
     * 属性动画：实现步骤
     * 第一步：设置动画运行时长，动画效果对应属性的初始值和结束值
     * 第二步：设置初始值 过度到 结束值的变化逻辑 （应用到辅助类 估值器和插值器）
     * 第三步：根据变化逻辑 不断改变值
     * 第四步：值改变一次就给对象属性赋值一次
     * 第五步：每次赋值调用invalidate 不断刷新视图 (即调用onDraw 重新绘制视图)
     * end：  不断循环到初始值等于结束值
     */
    private void customAnim(){
        // 步骤1：设置属性数值的初始值 & 结束值
        ValueAnimator valueAnimator = ValueAnimator.ofInt(imAnim.getLayoutParams().width, 500);
        // 初始值 = 当前按钮的宽度，此处在xml文件中设置为150
        // 结束值 = 500
        // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置
        // 即默认设置了如何从初始值150 过渡到 结束值500

        // 步骤2：设置动画的播放各种属性
        valueAnimator.setDuration(2000);
        // 设置动画运行时长:1s

        // 步骤3：将属性数值手动赋值给对象的属性:此处是将 值 赋给 按钮的宽度
        // 设置更新监听器：即数值每次变化更新都会调用该方法
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {

                int currentValue = (Integer) animator.getAnimatedValue();
                // 获得每次变化后的属性值
                System.out.println(currentValue);
                // 输出每次变化后的属性值进行查看

                imAnim.getLayoutParams().width = currentValue;
                // 每次值变化时，将值手动赋值给对象的属性
                // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化

                // 步骤4：刷新视图，即重新绘制，从而实现动画效果
                imAnim.requestLayout();

            }
        });
        // 启动动画
        valueAnimator.start();
    }

}

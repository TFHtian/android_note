package com.android_note.client.animation.transition_animation.material;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.android_note.client.R;

/**
 * @author fenghui
 * @date 2021/5/8.
 * @description
 *
 * 场景过渡动画（转场动画）：以动画的形式实现view两个场景的切换（从一个场景切换到另一个场景），切换过程中通过不同的动画来过渡
 * 应用场景：
 *              一：两个activity切换时的界面的过渡效果
 *              二：两个activity/fragment中的元素共享效果
 *              三：同一个activity中view的动画效果
 * activity切换：
 *             1、Explode：从屏幕的中间进入或退出。
 *             2、Slide：从屏幕的一边向另一边进入或退出。
 *             3、Fade：通过改变透明度来出现或消失。
 *
 *             Window.setEnterTransition() 设置进场动画
 *             Window.setExitTransition() 设置出场动画
 *             Window().setReturnTransition() 设置返回activity时动画
 *             Window().setReenterTransition()  设置重新进入时动画
 *
 *              界面的进退出设置对应的过渡动画
 *
 *              5.0之前通过overridePendingTransition来实现进出场动画
 *              5.0之后通过 过渡动画 ActivityOptionsCompat
 *              第一种:  ActivityOptionsCompat.makeCustomAnimation() -> 设置进出场：第二个参数是进场动画，第三个是出场动画
 *              第二种：ActivityOptionsCompat.makeScaleUpAnimation() -> 某个小的区域放大至全屏显示：第二、三个参数是起始坐标，第四,五个参数是过度效果开始的宽高度
 *              第三种：ActivityOptionsCompat makeThumbnailScaleUpAnimation（） -> 展示的一块的Bitmpat进行拉伸的动画: 第二参数是需要放大的图片，第四,五个参数是起始坐标
 *              第四种：ActivityOptionsCompat makeClipRevealAnimation() -> 从一个点以圆形渐变到满屏 : 第二、三个参数是起始坐标，第四,五个参数是过度效果开始的宽高度
 *              第五种：ActivityOptions CompatmakeSceneTransitionAnimation -> 用于展示 Explode Slide Fade效果
 */

public class TransitionMainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_main);
        setupWindowAnimations();
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.bar);
        toolbar.setTitle(R.string.transition_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        findViewById(R.id.ll_transitions).setOnClickListener(this);
        findViewById(R.id.ll_shared).setOnClickListener(this);
        findViewById(R.id.ll_view).setOnClickListener(this);
        findViewById(R.id.ll_reveal).setOnClickListener(this);
    }

    //设置退场
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(500);
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_transitions:
                //两个activity之间的切换
                Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
                toStartActivity(Transition1Activity.class,pairs,"Transitions");
                break;
            case R.id.ll_shared:
                break;
            case R.id.ll_view:
                break;
            case R.id.ll_reveal:
                break;
        }
    }

    //跳转
    private void toStartActivity(Class target, Pair<View, String>[] pairs, String type) {
        Intent i = new Intent(this, target);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(TransitionMainActivity.this, pairs);
        i.putExtra("type", type);
        startActivity(i, transitionActivityOptions.toBundle());
    }

}

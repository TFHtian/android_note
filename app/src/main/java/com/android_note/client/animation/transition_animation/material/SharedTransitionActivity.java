package com.android_note.client.animation.transition_animation.material;

import android.os.Bundle;
import android.view.Gravity;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.transition.ChangeBounds;
import androidx.transition.Slide;

import com.android_note.client.R;
import com.gyf.immersionbar.ImmersionBar;

/**
 * @author TFHtian
 * @date 2021/5/10.
 * @description 转场动画元素共享
 *
 * 界面中 元素共享
 * 第一 Pair 参数 共享的view 与 共享view共享value名 new Pair<>(shareView, shareName)
 * 第二 在跳转的页面共享view设置属性transitionName 复制 Pair中对应的shareName
 * activity 中任用 makeSceneTransitionAnimation（）添加Pair参数
 * fragment中 使用  getFragmentManager().beginTransaction()
 *                 .replace(group, Fragment)
 *                 .addToBackStack(null)
 *                 .addSharedElement(shareView , shareName)
 *                 .commit();
 *
 */
public class SharedTransitionActivity extends BaseTransitionActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_transition);
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .statusBarColor(R.color.color_Green)
                .navigationBarColor(R.color.color_Green)
                .init();
        initView();
        setupWindowAnimations();
        setupLayout();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.bar);
        toolbar.setTitle(R.string.share_element);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void setupWindowAnimations() {
        // We are not interested in defining a new Enter Transition. Instead we change default transition duration
        getWindow().getEnterTransition().setDuration(500);
    }

    private void setupLayout() {
        // Transition for fragment1
        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.setDuration(500);
        // Create fragment and define some of it transitions
        SharedElementFragment1 sharedElementFragment1 = SharedElementFragment1.newInstance();
        sharedElementFragment1.setReenterTransition(slideTransition);
        sharedElementFragment1.setExitTransition(slideTransition);
        sharedElementFragment1.setSharedElementEnterTransition(new ChangeBounds());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_content, sharedElementFragment1)
                .commit();
    }

}

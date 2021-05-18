package com.android_note.client.animation.transition_animation.material;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Visibility;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android_note.client.R;
import com.gyf.immersionbar.ImmersionBar;

/**
 * @author fenghui
 * @date 2021/5/8.
 * @description 界面切换过渡动画activity
 */

public class Transition1Activity extends BaseTransitionActivity implements View.OnClickListener{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition1);
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .statusBarColor(R.color.color_Red)
                .navigationBarColor(R.color.color_Red)
                .init();
        setupWindowAnimations();
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.bar);
        toolbar.setTitle(R.string.transition_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        findViewById(R.id.sample1_button1).setOnClickListener(this);
        findViewById(R.id.sample1_button2).setOnClickListener(this);
        findViewById(R.id.sample1_button3).setOnClickListener(this);
        findViewById(R.id.sample1_button4).setOnClickListener(this);
        findViewById(R.id.sample1_button5).setOnClickListener(this);
        findViewById(R.id.sample1_button6).setOnClickListener(this);
    }

    private void setupWindowAnimations() {
        Visibility enterTransition = buildEnterTransition();
        getWindow().setEnterTransition(enterTransition);

        getWindow().setReenterTransition(enterTransition);
        getWindow().setExitTransition(enterTransition);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sample1_button1:
                Intent i = new Intent(Transition1Activity.this, Transition2Activity.class);
                i.putExtra(EXTRA_TYPE, TYPE_PROGRAMMATICALLY);
                transitionTo(i);
                break;
            case R.id.sample1_button2:
                Intent exi_xml = new Intent(Transition1Activity.this, Transition2Activity.class);
                exi_xml.putExtra(EXTRA_TYPE, TYPE_XML);
                transitionTo(exi_xml);
                break;
            case R.id.sample1_button3:
                Intent sle_i = new Intent(Transition1Activity.this, Transition3Activity.class);
                sle_i.putExtra(EXTRA_TYPE, TYPE_PROGRAMMATICALLY);
                transitionTo(sle_i);
                break;
            case R.id.sample1_button4:
                Intent sle_i_xml = new Intent(Transition1Activity.this, Transition3Activity.class);
                sle_i_xml.putExtra(EXTRA_TYPE, TYPE_XML);
                transitionTo(sle_i_xml);
                break;
            case R.id.sample1_button5:
                Visibility returnTransition = buildReturnTransition();
                getWindow().setReturnTransition(returnTransition);

                finishAfterTransition();
                break;
            case R.id.sample1_button6:
                finishAfterTransition();
                break;
        }
    }

    private Visibility buildEnterTransition() {
        Fade enterTransition = new Fade();
        enterTransition.setDuration(500);
        // This view will not be affected by enter transition animation
        //enterTransition.excludeTarget(R.id.square_red, true);
        return enterTransition;
    }

    private Visibility buildReturnTransition() {
        Visibility enterTransition = new Slide();
        enterTransition.setDuration(500);
        return enterTransition;
    }

}

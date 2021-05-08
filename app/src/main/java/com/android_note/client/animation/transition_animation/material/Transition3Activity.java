package com.android_note.client.animation.transition_animation.material;

import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.android_note.client.R;

/**
 * @author fenghui
 * @date 2021/5/8.
 * @description 界面切换过渡动画activity
 */

public class Transition3Activity extends BaseTransitionActivity {

    private int type;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition3);
        initData();
        setupWindowAnimations();
        initView();
    }

    private void initData() {
        type = getIntent().getExtras().getInt(EXTRA_TYPE);
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.bar);
        toolbar.setTitle(R.string.transition_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }

    private void setupWindowAnimations() {
        Transition transition;

        if (type == TYPE_PROGRAMMATICALLY) {
            transition = buildEnterTransition();
        }  else {
            transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_from_bottom);
        }
        getWindow().setEnterTransition(transition);
    }

    private Visibility buildEnterTransition() {
        Slide enterTransition = new Slide();
        enterTransition.setDuration(500);
        enterTransition.setSlideEdge(Gravity.RIGHT);
        return enterTransition;
    }

}

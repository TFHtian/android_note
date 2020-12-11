package com.android_note.client.animation.transition_animation;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android_note.client.R;

public class TransitionEveryActivity extends AppCompatActivity {

    private Transition mTransition;
    private LinearLayout root;
    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_every);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.bar);
        toolbar.setTitle(R.string.transition_every);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        transitionAnim();

    }

    private void transitionAnim(){
        mTransition = new Fade();
        root = findViewById(R.id.root);
        text = findViewById(R.id.text);
        findViewById(R.id.button).setOnClickListener(new VisibleToggleClickListener() {
            @Override
            protected void changeVisibility(boolean visible) {
                TransitionManager.beginDelayedTransition(root, mTransition);
                text.setVisibility(visible? View.VISIBLE:View.GONE);
            }
        });
    }

}

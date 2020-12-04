package com.android_note.client.animation.transition_animation;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android_note.client.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TransitionDetailActivity extends AppCompatActivity {

    private ImageView imDetail;
    private ImageView imIcon;
    private TextView tvItem;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_detail);
        initView();
        init();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.bar);
        toolbar.setTitle(R.string.transition_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imDetail = findViewById(R.id.im_detail);
        imIcon = findViewById(R.id.im_icon);
        tvItem = findViewById(R.id.tv_item);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {
        CustomTransitionBean item = (CustomTransitionBean) getIntent().getSerializableExtra("item");
        switch (item.getName()){
            case "Explode":
                getWindow().setEnterTransition(new Explode());
                getWindow().setExitTransition(new Explode());
                break;
            case "Slide":
                getWindow().setEnterTransition(new Slide());
                getWindow().setExitTransition(new Slide());
                break;
            case "Fade":
                getWindow().setEnterTransition(new Fade());
                getWindow().setExitTransition(new Fade());
                break;
        }

        Glide.with(this)
                .load(item.getImResId())
                .apply(new RequestOptions().skipMemoryCache(true))
                .into(imDetail);
        tvItem.setText(item.getName());
    }

}

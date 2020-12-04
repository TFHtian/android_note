package com.android_note.client.animation.transition_animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.android_note.client.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ShareElementActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imItem, imIcon;
    private TextView tvContent;
    private CustomTransitionBean itemBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.share_element);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.ll_share).setOnClickListener(this);
        imItem = findViewById(R.id.item_img);
        imIcon = findViewById(R.id.im_icon);
        tvContent = findViewById(R.id.tv_item);

        itemBean = new CustomTransitionBean("Share Element",R.drawable.img1);
        tvContent.setText(itemBean.getName());
        Glide.with(this)
                .load(itemBean.getImResId())
                .apply(new RequestOptions().skipMemoryCache(true))
                .into(imItem);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_share:
                shareMore();
                break;
        }
    }

    /*单一元素共享*/
    private void shareSingle(){
        Intent intent = new Intent(ShareElementActivity.this,TransitionDetailActivity.class);
        intent.putExtra("item",itemBean);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(ShareElementActivity.this,imItem,getResources().getString(R.string.share_element_im_cover)).toBundle());
    }

    /*多元素共享*/
    private void shareMore(){
        Intent intent = new Intent(ShareElementActivity.this,TransitionDetailActivity.class);
        intent.putExtra("item",itemBean);
        Pair<View, String> pair1 = new Pair<View, String>(imItem, getResources().getString(R.string.share_element_im_cover));
        Pair<View, String> pair2 = new Pair<View, String>(imIcon,getResources().getString(R.string.share_element_im_header));
        Pair<View, String> pair3 = new Pair<View, String>(tvContent, getResources().getString(R.string.share_element_tv_info));
        startActivity(intent,ActivityOptionsCompat.makeSceneTransitionAnimation(ShareElementActivity.this,pair1, pair2, pair3).toBundle());
    }
}

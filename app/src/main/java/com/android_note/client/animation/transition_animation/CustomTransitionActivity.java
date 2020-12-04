package com.android_note.client.animation.transition_animation;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android_note.client.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CustomTransitionActivity extends AppCompatActivity {

    private RecyclerView rvTransition;
    private CustomTransitionAdapter adapter;
    private List<CustomTransitionBean> dataList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_transition);
        initView();
        initListData();
        initListener();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.transition_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvTransition = findViewById(R.id.rv_transition);
        adapter = new CustomTransitionAdapter(R.layout.item_custom_transition,dataList,this);
        rvTransition.setLayoutManager(new LinearLayoutManager(this));
        rvTransition.setAdapter(adapter);
    }

    private void initListener(){
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                CustomTransitionBean item = (CustomTransitionBean) adapter.getItem(position);
                Intent intent = new Intent(CustomTransitionActivity.this,TransitionDetailActivity.class);
                intent.putExtra("item",item);
                switch (item.getName()){
                    case "makeCustom":
                        startActivity(intent,ActivityOptionsCompat.makeCustomAnimation(CustomTransitionActivity.this, android.R.anim.fade_in, android.R.anim.fade_out).toBundle());
                        break;
                    case "makeScaleUp":
                        startActivity(intent,ActivityOptionsCompat.makeScaleUpAnimation(view,view.getMeasuredWidth()/2,
                                view.getMeasuredHeight()/2,0, 0).toBundle());
                        break;
                    case "makeThumbnailScaleUp":
                        startActivity(intent,ActivityOptionsCompat.makeThumbnailScaleUpAnimation(view, BitmapFactory.decodeResource(getResources(),item.getImResId()),view.getMeasuredWidth()/2,
                                view.getMeasuredHeight()/2).toBundle());
                        break;
                    case "makeClipReveal":
                        startActivity(intent,ActivityOptionsCompat.makeClipRevealAnimation(view,view.getMeasuredWidth()/2,
                                view.getMeasuredHeight()/2,0, 0).toBundle());
                        break;
                    case "ShareElement1":
                        /*共享元素图片*/
                        startActivity(intent,ActivityOptionsCompat.makeSceneTransitionAnimation(CustomTransitionActivity.this,view.findViewById(R.id.item_img),"shareImg").toBundle());
                        break;
                    case "ShareElement2":
                        Pair<View, String> pair1 = new Pair<View, String>(view.findViewById(R.id.item_img), "shareImgDetail");
                        Pair<View, String> pair2 = new Pair<View, String>(view.findViewById(R.id.im_icon),"shareImgIcon");
                        Pair<View, String> pair3 = new Pair<View, String>(view.findViewById(R.id.tv_item), "shareText");
                        startActivity(intent,ActivityOptionsCompat.makeSceneTransitionAnimation(CustomTransitionActivity.this,pair1, pair2, pair3).toBundle());
                        break;
                    default:
                        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(CustomTransitionActivity.this).toBundle());
                        break;
                }
            }
        });
    }

    private void initListData(){
        dataList.add(new CustomTransitionBean("Explode",R.drawable.img1));
        dataList.add(new CustomTransitionBean("Slide",R.drawable.img2));
        dataList.add(new CustomTransitionBean("Fade",R.drawable.img3));
        dataList.add(new CustomTransitionBean("makeCustom",R.drawable.img4));
        dataList.add(new CustomTransitionBean("makeScaleUp",R.drawable.img5));
        dataList.add(new CustomTransitionBean("makeThumbnailScaleUp",R.drawable.img6));
        dataList.add(new CustomTransitionBean("makeClipReveal",R.drawable.img1));
        dataList.add(new CustomTransitionBean("ShareElement1",R.drawable.img2));
        dataList.add(new CustomTransitionBean("ShareElement2",R.drawable.img3));
        adapter.notifyDataSetChanged();
    }

}

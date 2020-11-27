package com.android_note.client.animation.view_animation;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

public class PopupLayoutAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llResult;
    private PopupWindow imPopup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_layout_anim);
        initView();
    }

    private void initView() {
        llResult = findViewById(R.id.ll_result);
        findViewById(R.id.btn_popup).setOnClickListener(this);
        findViewById(R.id.btn_layout).setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_popup:
                showImgPopupWindow(v);
                break;
            case R.id.btn_layout:
                //llResult.setVisibility(View.VISIBLE);
                //llResult.setAnimation(moveToViewLocation());
                llResult.setVisibility(View.GONE);
                llResult.setAnimation(moveToViewBottom());
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showImgPopupWindow(View anchor) {
        if (imPopup == null) {
            ImageView view = new ImageView(this);
            view.setImageDrawable(getDrawable(R.drawable.img_popup));

            imPopup = new PopupWindow(view, anchor.getMeasuredWidth(), anchor.getMeasuredWidth());
            imPopup.setAnimationStyle(R.style.popup_anim_style);
        }
        if (imPopup.isShowing()) {
            imPopup.dismiss();
        } else {
            imPopup.showAsDropDown(anchor);
        }
    }

    /*退出*/
    private void layoutOut(){
        // 向右边移出
        llResult.setVisibility(View.GONE);
        llResult.setAnimation(AnimationUtils.makeOutAnimation(this, true));
        // 向左边移出
        //llResult.setAnimation(AnimationUtils.makeOutAnimation(this, false));
    }

    /*进入*/
    private void layoutIn(){
        // 向右边移入
        llResult.setVisibility(View.VISIBLE);
        llResult.setAnimation(AnimationUtils.makeInAnimation(this, true));
        // 向左边移入
        //llResult.setAnimation(AnimationUtils.makeInAnimation(this, false));
    }

    /**
     * 从控件所在位置移动到控件的底部
     *
     * @return
     */
    public static TranslateAnimation moveToViewBottom() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }

    /**
     * 从控件的底部移动到控件所在位置
     *
     * @return
     */
    public static TranslateAnimation moveToViewLocation() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }

}

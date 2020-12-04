package com.android_note.client.animation.transition_animation;

import android.content.Context;
import android.widget.ImageView;

import com.android_note.client.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomTransitionAdapter extends BaseQuickAdapter<CustomTransitionBean, BaseViewHolder> {

    private Context context;

    public CustomTransitionAdapter(int layoutResId, @Nullable List<CustomTransitionBean> data,Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, CustomTransitionBean item) {
        helper.setText(R.id.tv_item,item.getName());
        Glide.with(context)
                .load(item.getImResId())
                .apply(new RequestOptions().skipMemoryCache(true))
                .into((ImageView) helper.getView(R.id.item_img));
    }
}

package com.android_note.client.flex_box;

import android.view.ViewGroup;

import com.android_note.client.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FlexBoxRecyclerAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public FlexBoxRecyclerAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        ViewGroup.LayoutParams layoutParams = baseViewHolder.itemView.getLayoutParams();
        //加上这句话，保证主轴上的子view均分主轴剩余空间
        if (layoutParams instanceof FlexboxLayoutManager.LayoutParams) {
            ((FlexboxLayoutManager.LayoutParams) layoutParams).setFlexGrow(1f);
            baseViewHolder.setText(R.id.tv_content, s);
        }
    }

}

package com.android_note.client.animation.transition_animation.material.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.android_note.client.R;

/**
 * @author fenghui
 * @date 2021/6/8.
 * @description 场景转换动画主页
 */

public class SceneMainFragment extends ListFragment {
    private OnListItemClickListener onListItemClickListener;

    public interface OnListItemClickListener{
        void onListItemClick(int position);
    }

    public SceneMainFragment(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onListItemClickListener = (OnListItemClickListener) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String listData[] = getResources().getStringArray(R.array.list_scene_name);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, listData);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        onListItemClickListener.onListItemClick(position);
    }

}


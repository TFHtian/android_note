package com.android_note.util_code.fragment_util.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android_note.client.R;
import com.blankj.utilcode.util.FragmentUtils;

public class ChildFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_child,container,false);
        initView(contentView);
        return contentView;
    }

    private void initView(View v) {
        v.findViewById(R.id.btn_add).setOnClickListener(this);
        v.findViewById(R.id.btn_replace).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                FragmentUtils.add(getChildFragmentManager(),new BottomSecondFragment(),R.id.content_container);
                break;
            case R.id.btn_replace:
                FragmentUtils.replace(getChildFragmentManager(),new BottomThirdFragment(),R.id.content_container);
                break;
        }
    }

}

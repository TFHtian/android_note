package com.android_note.client.animation.transition_animation.material.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.ChangeScroll;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.android_note.client.R;

/**
 * @author fenghui
 * @date 2021/6/8.
 * @description ChangeScroll
 */

public class ChangeScrollFragment extends Fragment {

    private FrameLayout mRoot;
    private View mTarget;
    private Transition mTransition;

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_scroll, container, false);
        mRoot = view.findViewById(R.id.root);
        mTarget = view.findViewById(R.id.target);
        mTransition = new ChangeScroll();
        view.findViewById(R.id.move).setOnClickListener(v -> move());
        return view;
    }

    void move(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mTarget.scrollBy(-100, -100);
    }

}


package com.android_note.client.animation.transition_animation.material.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.ChangeTransform;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.android_note.client.R;

/**
 * @author fenghui
 * @date 2021/6/8.
 * @description ChangeTransform
 */

public class ChangeTransformFragment extends Fragment {

    private LinearLayout mRoot;
    private FrameLayout mContainer1;
    private FrameLayout mContainer2;
    private Transition mTransition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_transform, container, false);
        mRoot = view.findViewById(R.id.root);
        mContainer1 = view.findViewById(R.id.container_1);
        mContainer2 = view.findViewById(R.id.container_2);
        mTransition = new ChangeTransform();
        showRedSquare(mContainer1);
        view.findViewById(R.id.toggle).setOnClickListener(v -> toggle());
        return view;
    }

    void toggle(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        if (mContainer2.getChildCount() > 0) {
            mContainer2.removeAllViews();
            showRedSquare(mContainer1);
        } else {
            mContainer1.removeAllViews();
            showRedSquare(mContainer2);
            mContainer2.getChildAt(0).setRotation(45);
        }
    }

    private void showRedSquare(FrameLayout container) {
        final View view = LayoutInflater.from(getContext())
                .inflate(R.layout.red_square, container, false);
        container.addView(view);
    }

}


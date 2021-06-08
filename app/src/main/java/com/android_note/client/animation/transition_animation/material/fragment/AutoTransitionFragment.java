package com.android_note.client.animation.transition_animation.material.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.android_note.client.R;
import com.android_note.client.animation.transition_animation.VisibleToggleClickListener;

/**
 * @author fenghui
 * @date 2021/6/8.
 * @description AutoTransition
 */

public class AutoTransitionFragment extends Fragment {

    private TextView mTextView;
    private LinearLayout mRoot;
    private Transition mTransition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auto_transition, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mTextView = view.findViewById(R.id.message);
        mRoot = view.findViewById(R.id.root);
        mTransition = new AutoTransition();

        view.findViewById(R.id.button).setOnClickListener(new VisibleToggleClickListener() {
            @Override
            protected void changeVisibility(boolean visible) {
                TransitionManager.beginDelayedTransition(mRoot, mTransition);
                mTextView.setVisibility(visible? View.VISIBLE:View.GONE);
            }
        });
    }

}


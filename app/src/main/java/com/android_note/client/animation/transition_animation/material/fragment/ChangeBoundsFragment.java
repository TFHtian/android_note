package com.android_note.client.animation.transition_animation.material.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.ArcMotion;
import androidx.transition.AutoTransition;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.android_note.client.R;

/**
 * @author fenghui
 * @date 2021/6/8.
 * @description ChangeBounds
 */

public class ChangeBoundsFragment extends Fragment {

    private Button mButton;
    private FrameLayout mRoot;
    private View mTarget;
    private Transition mTransition;
    private AutoTransition autoTransition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_bounds, container, false);
        mRoot = view.findViewById(R.id.root);
        mTarget = view.findViewById(R.id.target);
        mButton = view.findViewById(R.id.move);
        //mTransition = new ChangeBounds();
        autoTransition = new AutoTransition();
        autoTransition.setPathMotion(new ArcMotion());
        mButton.setOnClickListener(view1 -> move());
        return view;
    }

    private void move() {
        TransitionManager.beginDelayedTransition(mRoot, autoTransition);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mTarget.getLayoutParams();
        if ((lp.gravity & Gravity.START) == Gravity.START) {
            lp.gravity = Gravity.BOTTOM | Gravity.END;
        } else {
            lp.gravity = Gravity.TOP | Gravity.START;
        }
        mTarget.setLayoutParams(lp);
    }
}


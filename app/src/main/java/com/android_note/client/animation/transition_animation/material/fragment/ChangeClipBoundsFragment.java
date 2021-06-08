package com.android_note.client.animation.transition_animation.material.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.ChangeClipBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.android_note.client.R;

public class ChangeClipBoundsFragment extends Fragment {

    private LinearLayout mRoot;
    private ImageView mImageView;
    private Transition mTransition;
    private static final Rect BOUNDS = new Rect(50, 50, 200, 200);//坐标

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_clip_bounds, container, false);
        mRoot = view.findViewById(R.id.root);
        mImageView = view.findViewById(R.id.photo);
        mTransition = new ChangeClipBounds();
        view.findViewById(R.id.toggle).setOnClickListener(v -> {
            toggle();
        });
        return view;
    }

    void toggle(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        if (BOUNDS.equals(ViewCompat.getClipBounds(mImageView))) {
            ViewCompat.setClipBounds(mImageView, null);
        } else {
            ViewCompat.setClipBounds(mImageView, BOUNDS);
        }
    }

}

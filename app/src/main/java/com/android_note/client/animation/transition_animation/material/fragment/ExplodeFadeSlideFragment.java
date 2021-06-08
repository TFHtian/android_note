package com.android_note.client.animation.transition_animation.material.fragment;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android_note.client.R;

import java.util.ArrayList;

/**
 * @author fenghui
 * @date 2021/6/8.
 * @description ExplodeFadeSlide
 */

public class ExplodeFadeSlideFragment extends Fragment {

    private FrameLayout mRoot;
    private View view1;
    private View view2;
    private View view3;
    private View view4;
    private ArrayList<View> mViews = new ArrayList<>();
    private Transition mTransition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explode, container, false);
        mRoot = view.findViewById(R.id.root);
        view1 = view.findViewById(R.id.view_1);
        view2 = view.findViewById(R.id.view_2);
        view3 = view.findViewById(R.id.view_3);
        view4 = view.findViewById(R.id.view_4);
        if (mViews.isEmpty()){
            mViews.add(view1);
            mViews.add(view2);
            mViews.add(view3);
            mViews.add(view4);
        }
        // mTransition = new Explode();
        //mTransition = new Fade();
        mTransition = new Slide();
        view.findViewById(R.id.toggle).setOnClickListener(v -> toggle());
        return view;
    }

    void toggle(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        int vis = mViews.get(0).getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
        for (View view : mViews) {
            view.setVisibility(vis);
        }
    }

}

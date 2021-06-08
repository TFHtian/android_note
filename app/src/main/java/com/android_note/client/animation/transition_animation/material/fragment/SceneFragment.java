package com.android_note.client.animation.transition_animation.material.fragment;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android_note.client.R;

/**
 * @author fenghui
 * @date 2021/6/8.
 * @description Scene
 */

public class SceneFragment extends Fragment {

    private FrameLayout mSceneRoot;
    private Scene[] mScenes;
    private Scene mScene0;
    private Scene mScene1;
    private Transition mTransition;
    private Button mButton;
    private int mCurrentScene;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scene, container, false);
        mButton = view.findViewById(R.id.toggle);
        mSceneRoot = view.findViewById(R.id.root);
        mScene0 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene0, getContext());
        mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene1, getContext());
        mScenes = new Scene[]{mScene0, mScene1};
        mTransition = new Fade();
        TransitionManager.go(mScenes[0],mTransition);
        mButton.setOnClickListener(view1 -> {
            mCurrentScene = (mCurrentScene + 1) % mScenes.length;
            TransitionManager.go(mScenes[mCurrentScene]);
        });
        return view;
    }

}


package com.android_note.client.animation.transition_animation.material;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android_note.client.R;

import org.jetbrains.annotations.NotNull;

/**
 * @author TFHtian
 * @date 2021/5/11.
 * @description
 */
public class SharedElementFragment2 extends Fragment {

    public static SharedElementFragment2 newInstance() {
        Bundle args = new Bundle();
        SharedElementFragment2 fragment = new SharedElementFragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_element2, container, false);
        return view;
    }

}

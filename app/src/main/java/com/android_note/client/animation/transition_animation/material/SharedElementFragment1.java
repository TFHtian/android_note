package com.android_note.client.animation.transition_animation.material;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.ChangeBounds;
import androidx.transition.Slide;

import com.android_note.client.R;

import org.jetbrains.annotations.NotNull;

/**
 * @author TFHtian
 * @date 2021/5/10.
 * @description
 */
public class SharedElementFragment1 extends Fragment {

    public static SharedElementFragment1 newInstance() {
        Bundle args = new Bundle();
        SharedElementFragment1 fragment = new SharedElementFragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_element1, container, false);
        final ImageView squareBlue = view.findViewById(R.id.square_red);
        view.findViewById(R.id.sample2_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNextFragment(squareBlue, false);
            }
        });

        view.findViewById(R.id.sample2_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNextFragment(squareBlue, true);
            }
        });

        return view;
    }

    private void addNextFragment(ImageView squareBlue, boolean overlap) {
        SharedElementFragment2 sharedElementFragment2 = SharedElementFragment2.newInstance();

        Slide slideTransition = new Slide(Gravity.RIGHT);
        slideTransition.setDuration(500);

        ChangeBounds changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(500);

        sharedElementFragment2.setEnterTransition(slideTransition);
        sharedElementFragment2.setAllowEnterTransitionOverlap(overlap);
        sharedElementFragment2.setAllowReturnTransitionOverlap(overlap);
        sharedElementFragment2.setSharedElementEnterTransition(changeBoundsTransition);

        getFragmentManager().beginTransaction()
                .replace(R.id.fr_content, sharedElementFragment2)
                .addToBackStack(null)
                .addSharedElement(squareBlue, getActivity().getResources().getString(R.string.share_element_im_btn))
                .commit();
    }

}

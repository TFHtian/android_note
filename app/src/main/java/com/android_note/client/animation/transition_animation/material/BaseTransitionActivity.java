package com.android_note.client.animation.transition_animation.material;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

/**
 * @author fenghui
 * @date 2021/5/8.
 * @description
 */

public class BaseTransitionActivity extends AppCompatActivity {

    static final String EXTRA_TYPE = "type";
    static final int TYPE_PROGRAMMATICALLY = 0;
    static final int TYPE_XML = 1;

    @SuppressWarnings("unchecked") void transitionTo(Intent i) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }

}

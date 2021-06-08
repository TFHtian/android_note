package com.android_note.client.animation.transition_animation.material;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android_note.client.R;
import com.android_note.client.animation.transition_animation.material.fragment.AutoTransitionFragment;
import com.android_note.client.animation.transition_animation.material.fragment.ChangeBoundsFragment;
import com.android_note.client.animation.transition_animation.material.fragment.ChangeClipBoundsFragment;
import com.android_note.client.animation.transition_animation.material.fragment.ChangeScrollFragment;
import com.android_note.client.animation.transition_animation.material.fragment.ChangeTransformFragment;
import com.android_note.client.animation.transition_animation.material.fragment.ExplodeFadeSlideFragment;
import com.android_note.client.animation.transition_animation.material.fragment.SceneFragment;
import com.android_note.client.animation.transition_animation.material.fragment.SceneMainFragment;

/**
 * @author fenghui
 * @date 2021/5/17.
 * @description
 * 切换Scene :切换场景，viewgroup中的view布局切换
 *
 * Scene场景，用于保存布局中所有View的属性值，创建Scene的方式可以通过getSceneForLayout方法getSceneForLayout(ViewGroup sceneRoot, int layoutId, Context context)
 * Transition：过渡动画
 * TransitionManager：用于将Scene和Transition联系起来
 *                              setTransition(Scene fromScene, Scene toScene, Transition transition)指明起始场景和结束场景、他们的过渡动画是什么，
 *                              go(Scene scene, Transition transition)，到指定的场景所使用的过渡动画是什么，
 *                              beginDelayedTransition(ViewGroup sceneRoot, Transition transition),在当前场景到下一帧的过渡效果是什么
 */
public class MaterialAnimation1Activity extends AppCompatActivity implements SceneMainFragment.OnListItemClickListener{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_animation1);
        if (savedInstanceState == null) {
            SceneMainFragment mainFragment = new SceneMainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, mainFragment)
                    .commit();
        }
    }

    @Override
    public void onListItemClick(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AutoTransitionFragment();
                break;
            case 1:
                fragment = new ChangeBoundsFragment();
                break;
            case 2:
                fragment = new ChangeClipBoundsFragment();
                break;
            case 3:
                fragment = new ChangeScrollFragment();
                break;
            case 4:
                fragment = new ChangeTransformFragment();
                break;
            case 5:
                fragment = new ExplodeFadeSlideFragment();
                break;
            case 6:
                fragment = new SceneFragment();
                break;
            default:
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }

}

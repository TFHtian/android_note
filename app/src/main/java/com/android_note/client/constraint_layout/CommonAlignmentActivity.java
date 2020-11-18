package com.android_note.client.constraint_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android_note.client.R;

/**
 *相对位置属性 :
 *
 * layout_constraintTop_toTopOf — 期望视图的上边对齐另一个视图的上边。
 * layout_constraintTop_toBottomOf — 期望视图的上边对齐另一个视图的底边。
 * layout_constraintTop_toLeftOf — 期望视图的上边对齐另一个视图的左边。
 * layout_constraintTop_toRightOf — 期望视图的上边对齐另一个视图的右边。
 * layout_constraintBottom_toTopOf — 期望视图的下边对齐另一个视图的上边。
 * layout_constraintBottom_toBottomOf — 期望视图的底边对齐另一个视图的底边。
 * layout_constraintBottom_toLeftOf — 期望视图的底边对齐另一个视图的左边。
 * layout_constraintBottom_toRightOf — 期望视图的底边对齐另一个视图的右边。
 * layout_constraintLeft_toTopOf — 期望视图的左边对齐另一个视图的上边。
 * layout_constraintLeft_toBottomOf — 期望视图的左边对齐另一个视图的底边。
 * layout_constraintLeft_toLeftOf — 期望视图的左边对齐另一个视图的左边。
 * layout_constraintLeft_toRightOf — 期望视图的左边对齐另一个视图的右边。
 * layout_constraintRight_toTopOf — 期望视图的右边对齐另一个视图的上边。
 * layout_constraintRight_toBottomOf — 期望视图的右边对齐另一个视图的底边。
 * layout_constraintRight_toLeftOf — 期望视图的右边对齐另一个视图的左边。
 * layout_constraintRight_toRightOf — 期望视图的右边对齐另一个视图的右边。
 *
 */

public class CommonAlignmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_alignment);
    }
}

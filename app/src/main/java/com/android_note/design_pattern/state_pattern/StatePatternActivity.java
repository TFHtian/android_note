package com.android_note.design_pattern.state_pattern;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.android_note.client.R;

/**
 * 状态模式
 * 视频播放器 , 有 : 暂停 , 播放 , 快进 , 停止 , 四个状态 ;
 * 在 停止 状态下 , 无法快进 , 如果当前是 停止 状态 , 此时要转为 快进 状态 , 需要进行校验 ;
 * 如果不使用 状态模式 , 则需要进行 if else 判断 ;
 * 如果使用 状态模式 , 就很容易实现 ;
 *
 */
public class StatePatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {

            VideoContext videoContext = new VideoContext();
            videoContext.setVideoState(VideoContext.PLAY_STATE);
            System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());
            videoContext.getVideoState().play();
            videoContext.pause();
            System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());
            videoContext.getVideoState().pause();

            videoContext.speed();
            System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());

            videoContext.stop();
            System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());

            videoContext.speed();
            System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());

        });

    }

}

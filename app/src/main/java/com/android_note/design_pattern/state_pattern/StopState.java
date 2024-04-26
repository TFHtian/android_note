package com.android_note.design_pattern.state_pattern;

/**
 * 视频的停止状态
 * 可以进行 播放 操作
 * 不能进行 快进 , 暂停 操作
 */
public class StopState extends VideoState{

    /**
     * 播放时 , 只需要调用 PlayState 父类 VideoState 的上下文 VideoContext
     * 将上下文 VideoContext 中的状态 , 设置为 播放 的状态即可
     */
    @Override
    public void play() {
        super.videoContext.setVideoState(VideoContext.PLAY_STATE);
    }

    /**
     * 不能暂停
     */
    @Override
    public void pause() {
        System.out.println("停止状态不能暂停");
    }

    /**
     * 不能快进
     */
    @Override
    public void speed() {
        System.out.println("停止状态不能快进");
    }

    @Override
    public void stop() {
        System.out.println("停止播放视频");
    }
}

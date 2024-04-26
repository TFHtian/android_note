package com.android_note.design_pattern.state_pattern;

/**
 * 视频的播放状态
 * 可以进行 快进 , 暂停 , 停止 操作
 */
public class PlayState extends VideoState{

    @Override
    public void play() {
        System.out.println("正常播放视频");
    }

    /**
     * 暂停时 , 只需要调用 PlayState 父类 VideoState 的上下文 VideoContext
     * 将上下文 VideoContext 中的状态 , 设置为 暂停 的状态即可
     */
    @Override
    public void pause() {
        super.videoContext.setVideoState(VideoContext.PAUSE_STATE);
    }

    /**
     * 快进时 , 只需要调用 PlayState 父类 VideoState 的上下文 VideoContext
     * 将上下文 VideoContext 中的状态 , 设置为 快进 的状态即可
     */
    @Override
    public void speed() {
        super.videoContext.setVideoState(VideoContext.SPEED_STATE);
    }

    /**
     * 停止时 , 只需要调用 PlayState 父类 VideoState 的上下文 VideoContext
     * 将上下文 VideoContext 中的状态 , 设置为 停止 的状态即可
     */
    @Override
    public void stop() {
        super.videoContext.setVideoState(VideoContext.STOP_STATE);
    }

}

package com.android_note.design_pattern.state_pattern;

/**
 * 视频快进状态
 * 快进状态下 , 可以进行 播放 , 暂停 , 停止操作
 */
public class SpeedState extends VideoState{

    /**
     * 播放时 , 只需要调用 PlayState 父类 VideoState 的上下文 VideoContext
     *      将上下文 VideoContext 中的状态 , 设置为 播放 的状态即可
     */
    @Override
    public void play() {
        super.videoContext.setVideoState(VideoContext.PLAY_STATE);
    }

    /**
     * 暂停时 , 只需要调用 PlayState 父类 VideoState 的上下文 VideoContext
     *      将上下文 VideoContext 中的状态 , 设置为 暂停 的状态即可
     */
    @Override
    public void pause() {
        System.out.println("快进播放视频");
    }

    /**
     * 快进时 , 只需要调用 PlayState 父类 VideoState 的上下文 VideoContext
     *      将上下文 VideoContext 中的状态 , 设置为 快进 的状态即可
     */
    @Override
    public void speed() {
        super.videoContext.setVideoState(VideoContext.SPEED_STATE);
    }

    /**
     * 停止时 , 只需要调用 PlayState 父类 VideoState 的上下文 VideoContext
     *      将上下文 VideoContext 中的状态 , 设置为 停止 的状态即可
     */
    @Override
    public void stop() {
        super.videoContext.setVideoState(VideoContext.STOP_STATE);
    }

}

package com.android_note.design_pattern.state_pattern;

/**
 * 视频状态 父类
 * 所有的视频状态 , 都要继承该类
 */
public abstract class VideoState {

    /**
     * 视频播放上下文
     * 声明为 protected , 子类可以拿到该成员变量
     */
    protected VideoContext videoContext;

    public void setVideoContext(VideoContext videoContext) {
        this.videoContext = videoContext;
    }

    /**
     * 播放
     * 对应播放状态
     */
    public abstract void play();

    /**
     * 停止
     * 对应停止状态
     */
    public abstract void pause();

    /**
     * 快进
     * 对应快进状态
     */
    public abstract void speed();

    /**
     * 停止
     * 对应停止状态
     */
    public abstract void stop();

}

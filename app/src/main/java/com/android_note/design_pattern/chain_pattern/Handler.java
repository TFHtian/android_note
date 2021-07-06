package com.android_note.design_pattern.chain_pattern;

public interface Handler {

    // 处理请求
    void handleRequest(int dayNum);

    // 设置下一个执行者
    void setSuccessor(Handler handler);

    //获取下一个执行者
    Handler getNextSuccessor();
}
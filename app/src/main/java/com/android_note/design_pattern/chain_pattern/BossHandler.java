package com.android_note.design_pattern.chain_pattern;

public class BossHandler extends AbstractHandler<Number> {

    @Override
    protected void doHandler(Number data) {
        System.out.println("BOSS已审批");
        // 根据业务判断是否需要到下一链
        nextHandler.doHandler(data);
    }
}
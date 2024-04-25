package com.android_note.design_pattern.chain_pattern;

public class BaseHandler extends AbstractHandler<Number> {

    @Override
    protected void doHandler(Number data) {
        System.out.println("流程结束");
    }
}

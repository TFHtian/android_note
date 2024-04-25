package com.android_note.design_pattern.chain_pattern;

public class PMHandler extends AbstractHandler<Number> {

    @Override
    protected void doHandler(Number data) {
        System.out.println("项目经理已审批");
        // 根据业务判断是否需要到下一链
        nextHandler.doHandler(data);
    }
}

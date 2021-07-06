package com.android_note.design_pattern.template_pattern;

public class CodeBicycle extends AbstractClass{

    @Override
    protected void unlock() {
        System.out.println("========" + "密码开锁" + "========");
    }

    @Override
    protected void ride() {
        System.out.println(getClass().getSimpleName() + "骑起来很拉风");
    }

    protected void isNeedUnlock(boolean isNeedUnlock) {
        this.isNeedUnlock = isNeedUnlock;
    }

}

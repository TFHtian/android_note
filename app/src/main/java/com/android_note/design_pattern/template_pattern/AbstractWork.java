package com.android_note.design_pattern.template_pattern;

public abstract class AbstractWork {

    protected void getUp(){
        System.out.println("起床");
    }

    //上班有各种交通工具，让子类灵活的实现
    protected abstract void goToWork();

    protected abstract void work();

    protected abstract void getOffWork();

    /**
     * TemplateMethod:每个子类都拥有共同的执行步骤
     * final：不能改变、继承
     */
    public final void newDay(){
        getUp();
        goToWork();
        work();
        getOffWork();
    }
}


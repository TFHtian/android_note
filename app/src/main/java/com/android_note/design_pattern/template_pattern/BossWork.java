package com.android_note.design_pattern.template_pattern;

public class BossWork extends AbstractWork{

    @Override
    protected void goToWork() {
        System.out.println("老板开着奔驰去上班");
    }

    @Override
    protected void work() {
        System.out.println("老板分配工作给员工");
    }

    @Override
    protected void getOffWork() {
        System.out.println("老板开着奔驰回家");
    }

}

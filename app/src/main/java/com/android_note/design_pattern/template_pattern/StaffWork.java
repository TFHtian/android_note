package com.android_note.design_pattern.template_pattern;

public class StaffWork extends AbstractWork{

    @Override
    protected void goToWork() {
        System.out.println("员工挤地铁公交去上班");
    }

    @Override
    protected void work() {
        System.out.println("员工处理具体工作");
    }

    @Override
    protected void getOffWork() {
        System.out.println("员工加班到晚上十点，然后地铁和公交还是好挤，身心疲惫的回家了");
    }

}


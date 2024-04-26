package com.android_note.design_pattern.composite_pattern;

public class Staff extends DepartmentComponent {

    public Staff(String name) {
        super(name);
    }

    @Override
    void print() {
        System.out.println("员工：" + super.getName());
    }
}


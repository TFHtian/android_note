package com.android_note.design_pattern.composite_pattern;

import java.util.ArrayList;
import java.util.List;

public class Department extends DepartmentComponent {

    private final Integer level;

    private final List<DepartmentComponent> dept = new ArrayList<>();

    public Department(String name, Integer level) {
        super(name);
        this.level = level;
    }

    @Override
    void addChild(DepartmentComponent component) {
        dept.add(component);
    }

    @Override
    void removeChild(DepartmentComponent component) {
        dept.remove(component);
    }

    @Override
    void print() {
        System.out.println("部门-" + super.getName());
        for (DepartmentComponent component : dept) {
            if (this.level != null) {
                for (int i = 0; i < level; i++) {
                    System.out.print("--");
                }
            }
            component.print();
        }
    }
}

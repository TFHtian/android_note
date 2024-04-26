package com.android_note.design_pattern.composite_pattern;

public abstract class DepartmentComponent {

    private final String name;
    public DepartmentComponent(String name){
        this.name = name;
    }

    void print(){
        throw new UnsupportedOperationException("不支持操作");
    }

    String getName(){
        return this.name;
    }

    void addChild(DepartmentComponent component){
        throw new UnsupportedOperationException("不支持操作");
    }

    void removeChild(DepartmentComponent component){
        throw new UnsupportedOperationException("不支持操作");
    }

}

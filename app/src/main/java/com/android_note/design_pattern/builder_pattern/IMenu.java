package com.android_note.design_pattern.builder_pattern;

public interface IMenu {

    IMenu appendCeiling(Matter matter); // 吊顶

    IMenu appendFloor(Matter matter);   // 地板

    String getDetail();
}

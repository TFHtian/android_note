package com.android_note.design_pattern.builder_pattern;

public class LevelOneCeiling implements Matter{

    @Override
    public String scene() {
        return "一级吊顶";
    }

    @Override
    public String desc() {
        return "造型只做低一级";
    }

}

package com.android_note.design_pattern.builder_pattern;

public class CreateBuilder {

    public IMenu levelOne() {
        return new CreateMenu()
                .appendCeiling(new LevelOneCeiling())
                .appendFloor(new DerFloor());
    }

    public IMenu levelTwo(){
        return new CreateMenu()
                .appendCeiling(new LevelTwoCeiling())
                .appendFloor(new DerFloor());
    }

}

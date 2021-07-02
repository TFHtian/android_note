package com.android_note.design_pattern.builder_pattern;

import java.util.ArrayList;
import java.util.List;

public class CreateMenu implements IMenu{

    private List<Matter> list = new ArrayList<>();  //清单

    @Override
    public IMenu appendCeiling(Matter matter) {
        list.add(matter);
        return this;
    }

    @Override
    public IMenu appendFloor(Matter matter) {
        list.add(matter);
        return this;
    }

    @Override
    public String getDetail() {
        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "清单：\r\n");
        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.scene()).append("、").append(matter.desc());
        }
        return detail.toString();
    }

}

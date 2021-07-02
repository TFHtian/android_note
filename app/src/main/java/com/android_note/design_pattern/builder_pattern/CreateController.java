package com.android_note.design_pattern.builder_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 传统堆积写法
 */
public class CreateController {

    public String getDetail(int level){
        List<Matter> list = new ArrayList<>();

        // 模式一
        if (1 == level) {
            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();
            DerFloor derFloor = new DerFloor();
            list.add(levelOneCeiling);
            list.add(derFloor);
        }

        //模式二
        if (2 == level) {
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            DerFloor derFloor = new DerFloor();
            list.add(levelTwoCeiling);
            list.add(derFloor);
        }
        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "清单：\r\n");
        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.scene()).append("、").append(matter.desc());
        }
        return detail.toString();
    }

}

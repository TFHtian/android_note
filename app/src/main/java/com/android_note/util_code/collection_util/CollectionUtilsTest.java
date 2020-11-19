package com.android_note.util_code.collection_util;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;
import com.blankj.utilcode.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtilsTest extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_utils_test);
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_test:
                exists();
                break;
        }
    }

    /**
     * 获取并集
     */
    private void union(){
        ArrayList<String> l0 = CollectionUtils.newArrayList("00", "01", "02");
        ArrayList<String> l1 = CollectionUtils.newArrayList("00", "11", "12");
        Collection unionL0L1 = CollectionUtils.union(l0, l1);
        System.out.println(unionL0L1);
    }

    /**
     * 获取交集
     */
    private void intersection(){
        ArrayList<String> l0 = CollectionUtils.newArrayList("00", "01", "02");
        ArrayList<String> l1 = CollectionUtils.newArrayList("00", "11", "12");
        Collection intersectionL0L1 = CollectionUtils.intersection(l0, l1);
        System.out.println(intersectionL0L1);
    }

    /**
     * 获取并集减交集
     */
    private void disjunction(){
        ArrayList<String> l0 = CollectionUtils.newArrayList("00", "01", "02");
        ArrayList<String> l1 = CollectionUtils.newArrayList("00", "11", "12");
        Collection disjunctionL0L1 = CollectionUtils.disjunction(l0, l1);
        System.out.println(disjunctionL0L1);
    }

    /**
     * 获取差集
     */
    private void subtract(){
        ArrayList<String> l0 = CollectionUtils.newArrayList("00", "01", "02");
        ArrayList<String> l1 = CollectionUtils.newArrayList("00", "11", "12");
        Collection subtractL0L1 = CollectionUtils.subtract(l0, l1);
        System.out.println(subtractL0L1);
    }

    /**
     * 获取集合中所有元素的基数
     */
    private void getCardinalityMap(){
        ArrayList<String> l0 = CollectionUtils.newArrayList("0", "0", "1", "1", "2");
        System.out.println(CollectionUtils.getCardinalityMap(l0));
    }

    /**
     * 判断集合是否相等
     */
    private void isEqualCollection(){
        ArrayList<Integer> l0 = CollectionUtils.newArrayList(0, 1, 2);
        ArrayList<Integer> l1 = CollectionUtils.newArrayList(1, 0, 2);
        System.out.println(CollectionUtils.isEqualCollection(l0, l1));
    }

    /**
     * 查找第一个符合条件的元素
     */

    private void find(){
        ArrayList<String> list = CollectionUtils.newArrayList("0", "1", "1", "2");
        String result = CollectionUtils.find(list, new CollectionUtils.Predicate<String>() {
            @Override
            public boolean evaluate(String item) {
                return "1".equals(item);
            }
        });
        System.out.println(result);
    }

    /**
     * 删除原集合中不符合条件的元素
     */
    private void filter(){
        ArrayList<Integer> l1 = CollectionUtils.newArrayList(0, 1, 2, 3);
        CollectionUtils.filter(l1, new CollectionUtils.Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer item) {
                return item > 1;
            }
        });
        System.out.println(l1);
    }

    /**
     * 查找出所有符合条件的元素并返回新集合
     * selectRejected  (不符合的)
     */
    private void select(){
        ArrayList<Integer> list = CollectionUtils.newArrayList(0, 1, 2, 3);
        Collection<Integer> lists = CollectionUtils.select(list, new CollectionUtils.Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer item) {
                return item > 1;
            }
        });
        System.out.println(lists);
    }

    /**
     * 查找到匹配的元素个数
     */
    private void countMatches(){
        ArrayList<Integer> list = CollectionUtils.newArrayList(0, 1, 2, 3);
        int count = CollectionUtils.countMatches(list, new CollectionUtils.Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer item) {
                return item > 1;
            }
        });
        System.out.println(count);
    }

    /**
     * 判断集合是否存在符合条件的元素
     */
    private void exists(){
        ArrayList<Integer> list = CollectionUtils.newArrayList(0, 1, 2, 3);
        boolean result = CollectionUtils.exists(list, new CollectionUtils.Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer item) {
                return item > 1;
            }
        });
        System.out.println(result);
    }
}

package com.android_note.client.flex_box;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android_note.client.R;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 可伸缩布局列表
 */
public class FlexBoxRecyclerViewActivity extends AppCompatActivity {

    private FlexBoxRecyclerAdapter adapter;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex_box_recycler_view);
        initView();
        initData();
    }

    private void initView(){
        RecyclerView rvFlexBox = findViewById(R.id.rv_flex_box);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        adapter = new FlexBoxRecyclerAdapter(R.layout.item_flex_box_recycler,dataList);
        rvFlexBox.setLayoutManager(layoutManager);
        rvFlexBox.setAdapter(adapter);
    }

    private void initData(){
        dataList.add("你说什么");
        dataList.add("自己去看看啊");
        dataList.add("开心");
        dataList.add("你可真是个啥子哦哈哈");
        dataList.add("你走开");
        dataList.add("笑");
        dataList.add("你知道你多烦人不");
        dataList.add("我啦啦啦啦啦啦啦哦哦哦");
        dataList.add("烦死人的开发");
        dataList.add("一点都不喜欢");
        dataList.add("你想知道就自己去看啊");
        dataList.add("哦豁");
        dataList.add("有些微笑背后是紧咬牙关的灵魂");
        adapter.notifyDataSetChanged();
    }

}

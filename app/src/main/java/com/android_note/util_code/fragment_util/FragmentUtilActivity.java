package com.android_note.util_code.fragment_util;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.android_note.client.R;
import com.android_note.util_code.fragment_util.fragment.BottomFirstFragment;
import com.android_note.util_code.fragment_util.fragment.BottomSecondFragment;
import com.android_note.util_code.fragment_util.fragment.BottomThirdFragment;
import com.blankj.utilcode.util.FragmentUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class FragmentUtilActivity extends AppCompatActivity {

    private BottomNavigationView bt_nav;
    private int curIndex = 0;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] title = {"Fragment1","Fragment2","Fragment3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_util);
        initView();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.bt_fra_1:
                    showCurrentFragment(0);
                    break;
                case R.id.bt_fra_2:
                    showCurrentFragment(1);
                    break;
                case R.id.bt_fra_3:
                    showCurrentFragment(2);
                    break;
            }
            return true;
        }
    };

    private void initView(){
        bt_nav = findViewById(R.id.fra_nav);
        bt_nav.setOnNavigationItemSelectedListener(selectedListener);
        fragmentList.add(new BottomFirstFragment());
        fragmentList.add(new BottomSecondFragment());
        fragmentList.add(new BottomThirdFragment());
        FragmentUtils.add(getSupportFragmentManager(),fragmentList,R.id.fra_container,title,curIndex);
    }

    private void showCurrentFragment(int index){
        curIndex = index;
        FragmentUtils.showHide(index,fragmentList);
    }

}

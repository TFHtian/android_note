package com.android_note.rxjava_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android_note.client.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "AppCompatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        initView();
    }

    private void initView(){
        findViewById(R.id.btn_filter).setOnClickListener(this);
        findViewById(R.id.btn_distinct).setOnClickListener(this);
        findViewById(R.id.btn_skip).setOnClickListener(this);
        findViewById(R.id.btn_take).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_filter:
                doFilter();
                break;
            case R.id.btn_distinct:
                doDistinct();
                break;
            case R.id.btn_skip:
                doSkip();
                break;
            case R.id.btn_take:
                doTake();
                break;
        }
    }

    /*filter过滤*/
    private void doFilter(){
        /*如果返回 true 则会发送事件，否则不会发送   ofType() 可以过滤不符合该类型事件*/
        List<Integer> testList = new ArrayList<>();
        testList.add(1);testList.add(2);testList.add(3);testList.add(4);
        Observable.fromIterable(testList).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer>2 ? true : false;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "accept: ---"+integer);
            }
        });
    }

    /*distinct过滤*/
    private void doDistinct(){
        /*去重*/
        Observable.just(1,3,6,5,8,3,2,7,4,8).distinct().subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "accept: -----"+integer);
            }
        });
    }

    /*skip过滤*/
    private void doSkip(){
        /*过滤前n项*/
        Observable.just(1,8,9,7,6).skip(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "accept: ---"+integer);
            }
        });
    }

    /*take过滤*/
    private void doTake(){
        /*取前n项*/
        Observable.just(5,9,3,5,1,9,3).take(3).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "accept: ----"+integer);
            }
        });
    }

}

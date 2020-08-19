package com.android_note.rxjava_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android_note.client.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class TransformationActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "TransformationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformation);
        initView();
    }

    private void initView(){
        findViewById(R.id.btn_map).setOnClickListener(this);
        findViewById(R.id.btn_flat_map).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_map:
                doMap();
                break;
            case R.id.btn_flat_map:
                doFlatMap();
                break;
        }
    }

    /*map转换*/
    private void doMap(){
        /*map 可以将被观察者发送的数据类型转变成其他的类型*/
        List<String> fromList = new ArrayList<>();
        fromList.add("小灰灰");fromList.add("中灰灰");fromList.add("大灰灰");
        Observable.fromIterable(fromList).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s+"猛人";
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: -----"+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /*flatMap转换*/
    private void doFlatMap(){
        /*flatMap()//无序的concatMap()//有序的*/
        List<String> fromList = new ArrayList<>();
        fromList.add("小灰灰");fromList.add("中灰灰");fromList.add("大灰灰");
        Observable.fromIterable(fromList).flatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Exception {
                return Observable.just(s+"可爱");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG, "accept: ---"+s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "accept: ---"+throwable.getMessage());
            }
        });
    }

}

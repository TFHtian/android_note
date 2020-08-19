package com.android_note.rxjava_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android_note.client.R;

import java.io.Serializable;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class CombinationActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "CombinationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination);
        initView();
    }

    private void initView(){
        findViewById(R.id.btn_merge).setOnClickListener(this);
        findViewById(R.id.btn_concat).setOnClickListener(this);
        findViewById(R.id.btn_zip).setOnClickListener(this);
        findViewById(R.id.btn_concat_eager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_merge:
                doMerge();
                break;
            case R.id.btn_concat:
                doConcat();
                break;
            case R.id.btn_zip:
                doZip();
                break;
            case R.id.btn_concat_eager:
                doConcatEager();
                break;
        }
    }

    /*merge组合*/
    private void doMerge(){
        /*merge是将多个操作符合并到一个Observable中进行发射*/
        Observable<Integer> observable1=Observable.just(1,2,3);
        Observable<Integer> observable2=Observable.just(1,2,3);
        Observable.merge(observable1,observable2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "accept: -----"+integer);
            }
        });
    }

    /*concat组合*/
    private void doConcat(){
        /*与merge区别为merge无序，contact有序*/
        Observable<Integer> observable1=Observable.just(1,2,3);
        Observable<Integer> observable2=Observable.just(4,5,6);
        Observable.concat(observable1,observable2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "accept: "+integer);
            }
        });
    }

    /*zip组合*/
    private void doZip(){
        /*类型就行重新变换*/
        Observable<Integer> observable1=Observable.just(1,2,3);
        Observable<String> observable2=Observable.just("a","b","c");
        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer+s;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG, "apply: "+s);
            }
        });
    }

    /*concat_eager组合*/
    private void doConcatEager(){
        Observable<Integer> observable1=Observable.just(1,2,3);
        Observable<String> observable2=Observable.just("a","b","c");
        Observable.concatEager(Observable.fromArray(observable1,observable2)).subscribe(new Consumer<Serializable>() {
            @Override
            public void accept(Serializable serializable) throws Exception {
                Log.i(TAG, "accept: "+serializable);
            }
        });
    }

}

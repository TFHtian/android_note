package com.android_note.rxjava_learn;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * rxjava创建操作符create just，fromarray和interval
 */

public class CreateOperatorActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "CreateOperatorActivity";

    private CompositeDisposable getIntervalDisposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operator);
        initView();
    }

    private void initView(){
        findViewById(R.id.custom_one).setOnClickListener(this);
        findViewById(R.id.custom_two).setOnClickListener(this);
        findViewById(R.id.btn_just).setOnClickListener(this);
        findViewById(R.id.btn_from).setOnClickListener(this);
        findViewById(R.id.interval).setOnClickListener(this);
        findViewById(R.id.timer).setOnClickListener(this);
        findViewById(R.id.btn_from_iterable).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.custom_one:
                commonStep();
                break;
            case R.id.custom_two:
                commonChain();
                break;
            case R.id.btn_just:
                doJust();
                break;
            case R.id.btn_from:
                doFrom();
                break;
            case R.id.interval:
                doInterval();
                break;
            case R.id.timer:
                doTimer();
                break;
            case R.id.btn_from_iterable:
                doFromIterable();
                break;

        }
    }

    /*基础create分步*/
    private void commonStep(){
        /*是否通知观察者*/
        List<String> testList = new ArrayList<>();
        /*被观察者*/
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("你是狗");
                testList.add("你是狗");
            }
        });

        /*观察者*/
        Observer observer = new Observer<String>() {
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
                Log.i(TAG, "onComplete: ---"+testList.size());
            }
        };

        /*订阅*/
        observable.subscribe(observer);

        Log.i(TAG, "commonStep: ---"+testList.size());
    }

    /*基础create链式*/
    private void commonChain(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("你是猪");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: ----"+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /*just创建符*/
    private void doJust(){
        /*创建一个被观察者，并发送事件，但是发送的事件不可以超过10个以上,将传入的参数依次发出来*/
        Observable.just("小灰灰","中灰灰","大灰灰").subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: ---"+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ---");
            }
        });
    }

    /*from创建符*/
    private void doFrom(){
        List<String> fromList = new ArrayList<>();
        fromList.add("小灰灰");fromList.add("中灰灰");fromList.add("大灰灰");
        Observable.fromArray(fromList).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {
                Log.i(TAG, "onNext: ----"+strings);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /*fromIterable创建符*/
    private void doFromIterable(){
        List<String> fromList = new ArrayList<>();
        fromList.add("小灰灰");fromList.add("中灰灰");fromList.add("大灰灰");
        Observable.fromIterable(fromList).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: -------"+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ---完成----");
            }
        });
    }

    /*interval创建符*/
    private void doInterval(){
        /*当到指定时间后就会发送一个 0 的值给观察者(类似计时器，倒计时之类)*/
        Observable.interval(1, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                getIntervalDisposables.add(disposable);
            }

            @Override
            public void onNext(Long aLong) {
                if (aLong==10){
                    getIntervalDisposables.remove(disposable);
                    //disposable.dispose();
                }
                Log.i(TAG, "onNext: ---"+aLong+"");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                getIntervalDisposables.remove(disposable);
            }
        });
    }

    /*timer创建符*/
    private void doTimer(){
        /*当到指定时间后就会发送一个 0 的值给观察者(定时器)*/
        Observable.timer(10,TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                getIntervalDisposables.add(disposable);
            }

            @Override
            public void onNext(Long aLong) {
                Log.i(TAG, "onNext: ----时间到----");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                getIntervalDisposables.remove(disposable);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getIntervalDisposables != null) {
            getIntervalDisposables.clear();
        }
    }
}

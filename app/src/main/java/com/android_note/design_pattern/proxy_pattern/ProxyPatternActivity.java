package com.android_note.design_pattern.proxy_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 代理模式：静态代理和动态代理
 */
public class ProxyPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            /*
             * 静态代理
             * 分忧委托角色和代理角色
             * 特点：
             *     1、委托角色和代理角色共同继承同一个接口或者实现抽象类
             *     2、代理角色持有委托角色对象的引用
             * 示例：
             *      公司A（原对象）为海外公司，消费者B（某一个对象）直接从公司A购买商品需要各种各样复杂的步骤，
             *      这时候就出现了代理人C（代理对象），让他来替我们去处理那些复杂的步骤，我们只需要告诉代理人C我们需要什么商品就可以了，
             *      由代理人C去跟公司A进行购买，消费只需要等着收快递，其他的不用关心。
             * 缺点：
             * 一对一（一个代理只代理一个公司）
             */
            IFactoryA factoryA = new FactoryA();
            ProxyC proxyC = new ProxyC(factoryA);
            proxyC.saleManTools("36D");
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            /*
             * 动态代理
             * 使用动态代理不必要自己在去实现代理类，只需要一个动态代理类 (代理公司) 就可以让程序运行在期间动态的创建接口的实现。
             * 1、InvocationHandler
             * 2、Proxy类
             */
            // 创建动态代理对象
            ProxyCompany proxyCompany = new ProxyCompany();
            // 公司A
            IFactoryA factoryA = new FactoryA();
            // 动态代理引入真实对象
            proxyCompany.setFactory(factoryA);
            // 动态的创建代理类
            IFactoryA proxyA = (IFactoryA) proxyCompany.getDynamicProxy();
            proxyA.saleManTools("F");

        });
    }

}

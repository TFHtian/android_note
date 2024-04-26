package com.android_note.design_pattern.proxy_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 态代理类，必须实现InvocationHandler接口
 */
public class ProxyCompany implements InvocationHandler {

    /**
     * 依旧持有真实对象
     */
    private Object mFactory;

    public void setFactory(Object factory) {
        this.mFactory = factory;
    }

    /**
     * 获取动态代理对象
     * @return
     */
    public Object getDynamicProxy() {
        /**
         * 拿到动态代理对象
         * ClassLoader loader ：真实对象的ClassLoader
         * lass<?>[] interfaces : 真实对象实现的接口
         * InvocationHandler h  : InvocationHandler对象
         */
        return Proxy.newProxyInstance(mFactory.getClass().getClassLoader()
                , mFactory.getClass().getInterfaces(), this);
    }

    /**
     * InvocationHandler 接口方法
     * @param proxy  代理类本身
     * @param method 我们所要调用某个对象真实的方法的 Method 对象
     * @param args   method 对象中本身需要传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        // 调用真实对象方法
        Object result = method.invoke(mFactory, args);
        doAfter();
        return result;
    }

    private void doBefore() {
        System.out.println("代理公司——>方案制定");
    }

    private void doAfter() {
        System.out.println("代理公司——>收集反馈");
    }

}

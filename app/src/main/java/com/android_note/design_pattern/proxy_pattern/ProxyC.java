package com.android_note.design_pattern.proxy_pattern;

/**
 * 代理C，实现IFactory,并持有真实对象FactoryA引用
 */
public class ProxyC implements IFactoryA{

    private final IFactoryA factory;

    /**
     * 持有被代理角色的引用
     * @param factory
     */
    public ProxyC(IFactoryA factory) {
        this.factory = factory;
    }

    /**
     * 对真实对象方法进行增强
     * @param size
     */
    @Override
    public void saleManTools(String size) {
        doBefore();
        factory.saleManTools(size);
        doAfter();
    }

    private void doBefore() {
        System.out.println("代理C——>根据客户需求定制方案");
    }

    private void doAfter() {
        System.out.println("代理C——>收集使用反馈");
    }

}

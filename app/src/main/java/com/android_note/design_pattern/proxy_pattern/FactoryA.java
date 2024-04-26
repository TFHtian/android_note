package com.android_note.design_pattern.proxy_pattern;

/**
 * 公司A, 实现IFactory
 */
public class FactoryA implements IFactoryA{

    /**
     * 实现具体的业务逻辑
     * @param size
     */
    @Override
    public void saleManTools(String size) {
        System.out.println("公司A——>出货:" + size + "MM");
    }

}

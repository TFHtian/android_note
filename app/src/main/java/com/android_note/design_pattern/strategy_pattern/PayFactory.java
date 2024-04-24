package com.android_note.design_pattern.strategy_pattern;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PayFactory {
    private static final Map<String,IPay> METHOD = new HashMap<>();

    static {
        METHOD.put(MethodKey.ALIPAY, AliPay.getInstance());
        METHOD.put(MethodKey.WECHAT_PAY, WeChatPay.getInstance());
        METHOD.put(MethodKey.UNION_PAY, UnionPay.getInstance());
    }

    private interface MethodKey {
        String ALIPAY = "ALIPAY";
        String WECHAT_PAY = "WECHAT_PAY";
        String UNION_PAY = "UNION_PAY";
    }

    private static final IPay defaultPay = new AliPay();

    public static IPay getMethod(String key){
        if(METHOD.containsKey(key)){
            return METHOD.get(key);
        }
        return defaultPay;
    }

    public static Set<String> getMethodKey(){
        return METHOD.keySet();
    }

    /**
     * 通过反射获取
     */
    public static IPay create(Class<? extends IPay> clz){
        try {
            return clz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}


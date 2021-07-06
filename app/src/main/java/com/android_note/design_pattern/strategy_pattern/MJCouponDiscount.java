package com.android_note.design_pattern.strategy_pattern;

import java.util.Map;

public class MJCouponDiscount implements ICouponDiscount<Map<String,Double>>{

    /**
     * 满减计算
     * 判断满足x元后-n元，否则不减
     */
    @Override
    public double discountAmount(Map<String,Double> couponInfo, double price) {
        double x = couponInfo.get("x");
        double n = couponInfo.get("n");
        if (price>=x) return price -n;
        return price;
    }

}

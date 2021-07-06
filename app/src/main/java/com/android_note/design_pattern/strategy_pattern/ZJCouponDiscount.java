package com.android_note.design_pattern.strategy_pattern;

public class ZJCouponDiscount implements ICouponDiscount<Double>{

    //直接减
    @Override
    public double discountAmount(Double couponInfo, double price) {
        return price - couponInfo;
    }
}

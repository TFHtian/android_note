package com.android_note.design_pattern.strategy_pattern;

public class ZKCouponDiscount implements ICouponDiscount<Float>{

    //折扣
    @Override
    public double discountAmount(Float couponInfo, double price) {
        return price*couponInfo;
    }
}

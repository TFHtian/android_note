package com.android_note.design_pattern.strategy_pattern;

public interface ICouponDiscount<T> {

    double discountAmount(T couponInfo, double price);
}

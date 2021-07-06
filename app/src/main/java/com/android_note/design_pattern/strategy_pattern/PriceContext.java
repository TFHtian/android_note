package com.android_note.design_pattern.strategy_pattern;

public class PriceContext<T> {

    private ICouponDiscount<T> couponDiscount;

    public PriceContext(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Double discountAmount(T couponInfo, Double price) {
        return couponDiscount.discountAmount(couponInfo, price);
    }

}

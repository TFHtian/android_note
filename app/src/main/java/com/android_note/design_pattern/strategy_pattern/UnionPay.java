package com.android_note.design_pattern.strategy_pattern;

public class UnionPay implements IPay{

    public UnionPay() {}

    public static class UnionPayHelper{
        private static final UnionPay instance = new UnionPay();
    }

    public static UnionPay getInstance() {
        return UnionPayHelper.instance;
    }

    @Override
    public String getName() {
        return "银行卡";
    }

    @Override
    public Double queryBalance(String uid) {
        return 10000.0;
    }
}


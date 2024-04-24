package com.android_note.design_pattern.strategy_pattern;

public class AliPay implements IPay{

    public AliPay() {}

    public static class AliPayHelper{
        private final static AliPay instance = new AliPay();
    }

    public static AliPay getInstance() {
        return AliPayHelper.instance;
    }

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    public Double queryBalance(String uid) {
        return 900.0;
    }

}
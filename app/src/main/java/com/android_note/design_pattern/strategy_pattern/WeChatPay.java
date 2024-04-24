package com.android_note.design_pattern.strategy_pattern;

public class WeChatPay implements IPay{

    public WeChatPay() {}

    public static class WeChatPayHelper{
        private final static WeChatPay instance = new WeChatPay();
    }

    public static WeChatPay getInstance() {
        return WeChatPayHelper.instance;
    }

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    public Double queryBalance(String uid) {
        return 200.0;
    }
}


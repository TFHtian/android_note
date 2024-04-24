package com.android_note.design_pattern.strategy_pattern;

public interface IPay {

    String getName();

    Double queryBalance(String uid);

    default void pay(String uid,Double price){
        Double currentAmount  = queryBalance(uid);
        if(currentAmount < price){
            System.out.println(getName() + "余额不足");
        }else{
            System.out.println(getName() + "支付成功");
        }
    }

}

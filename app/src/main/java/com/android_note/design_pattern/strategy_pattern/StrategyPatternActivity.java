package com.android_note.design_pattern.strategy_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式 ：
 *      定义了一系列的算法，把它们一个个封装起来，并且使它们可以互相替换。
 *      策略模式的重心不是如何实现算法，而是如何组织、调用这些算法，从而让程序结构更灵活、可维护、可扩展。
 *      解决在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 *
 *      //案例:减价活动（1.满减 2.折扣 3.优惠券）
 */
public class StrategyPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            PriceContext<Map<String,Double>> context = new PriceContext<Map<String, Double>>(new MJCouponDiscount());
            Map<String,Double> mapReq = new HashMap<String, Double>();
            mapReq.put("x",100D);
            mapReq.put("n",10D);
            Double discountAmount = context.discountAmount(mapReq, 100D);
            System.out.println("支付金额："+discountAmount);
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            //IPay pay = PayFactory.getMethod("WECHAT_PAY");
            IPay pay = PayFactory.create(WeChatPay.class);
            pay.pay("",400D);
        });
    }

}

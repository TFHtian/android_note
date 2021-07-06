package com.android_note.design_pattern.chain_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 责任裂解模式 ：
 *                   使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系
 *
 * 组成内容：
 *              Handler（抽象处理者）：定义了处理请求的接口或抽象类，提供了处理请求的方法和设置下一个处理者的方法。
 *              ConcreteHandler（具体处理者）：具体处理者接受到请求后，可以选择立即处理这个请求或者将请求传递给下家。由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。
 *
 *  案例：层层审批
 */
public class ChainPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            Leader directLeader = new TeamLeader("TeamLeader", 3);
            Leader departmentDirector = new DepartmentDirector("DepartmentDirector", 7);
            Leader generalManager = new GeneralManager("GeneralManager", 10);

            directLeader.setSuccessor(departmentDirector);
            departmentDirector.setSuccessor(generalManager);

            // 请假三天
            directLeader.handleRequest(3);
            // 请假六天
            directLeader.handleRequest(6);
            // 请假10天
            directLeader.handleRequest(10);
        });
    }

}

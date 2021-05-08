package com.android_note.client.animation.view_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 视图动画（view动画，补间动画）作用于View 不能改变其属性的值
 *  实质 ：通过确定开始视图样式和结束视图样式 中间的变化过程由系统来补全确定的动画 （可通过估值器和插值器修改轨迹）
 * 分类：渐变透明（AlphaAnimation）旋转（RotateAnimation）平移（TranslateAnimation）缩放（ScaleAnimation）
 *
 * 公共属性：
 *     android:duration="3000" // 动画持续时间（ms），必须设置，动画才有效果
 *     android:startOffset ="1000" // 动画延迟开始时间（ms）
 *     android:fillBefore = “true” // 动画播放完后，视图是否会停留在动画开始的状态，默认为true
 *     android:fillAfter = “false” // 动画播放完后，视图是否会停留在动画结束的状态，优先于fillBefore值，默认为false
 *     android:fillEnabled= “true” // 是否应用fillBefore值，对fillAfter值无影响，默认为true
 *     android:repeatMode= “restart” // 选择重复播放动画模式，restart代表正序重放，reverse代表倒序回放，默认为restart|
 *     android:repeatCount = “0” // 重放次数（所以动画的播放次数=重放次数+1），为infinite时无限重复
 *     android:interpolator = @[package:]anim/interpolator_resource // 插值器，即影响动画的播放速度
 *
 */
public class CommonViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_view_animation);
        initView();
    }

    private void initView() {
        tvResult = findViewById(R.id.tv_result);
        findViewById(R.id.btn_tran).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_set).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tran:
                translateAnim();
                break;
            case R.id.btn_scale:
                scaleAnim();
                break;
            case R.id.btn_rotate:
                rotateAnim();
                break;
            case R.id.btn_alpha:
                alphaAnim();
                break;
            case R.id.btn_set:
                setAnim();
                break;
        }
    }

    /**
     * 平移动画 TranslateAnimation （横竖方向）
     * 属性 ：from ->起始位开始  to->结束位置
     *          fromXDelta 视图水平方向开始位置差值  toXDelta 视图水平方向结束位置差值
     *          fromYDelta 视图垂直方向开始位置差值  toYDelta  视图水垂直向结束位置差值
     */
    private void translateAnim(){

//        //方式一 xml形式 ：anim 文件下 创建节点translate的动画 设置duration时长和属性 父类Animation  通过AnimationUtils.loadAnimation获取动画
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
//        tvResult.startAnimation(animation);

        //方式二 ：通常创建平移动画类实例 TranslateAnimation
        TranslateAnimation translateAn = new TranslateAnimation(0,0,0,500);
        translateAn.setDuration(2000);
        translateAn.setRepeatCount(2);
        tvResult.startAnimation(translateAn);
    }

    /**
     * 缩放动画 （缩放中心点横竖方向上伸缩）
     * 属性 ：from ->起始位开始  to->结束位置
     *          fromXScale ：动画在水平方向X的开始缩放倍数（0.0表示收缩到没有；1.0表示正常无伸缩 值小于1.0表示收缩；值大于1.0表示放大）
     *          toXScale：     动画在水平方向X的结束缩放倍数
     *          fromYScale： 动画开始前在竖直方向Y的起始缩放倍数
     *          toYScale：     动画在竖直方向Y的结束缩放倍数
     *          pivotX：        缩放轴点的x坐标
     *          pivotY：        缩放轴点的y坐标
     *        （pivotX + pivotY）组成轴点 = 视图缩放的中心点 （数值 则为左上角原点 在x,y 方向加数值组成的坐标  百分比：则为view本身宽高比组成坐标）
     *          %** 为相对自身 %p 相对父控件
     */
    private void scaleAnim(){

//        //方式一 anim 文件下创建节点scale的动画 AnimationUtils.loadAnimation获取
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
//        tvResult.startAnimation(animation);

        //方式二 ：通常创建缩放动画类实例 ScaleAnimation
        // pivotXType:缩放轴点的x坐标的模式
        // pivotXValue:缩放轴点x坐标的相对值
        //  pivotYType:缩放轴点的y坐标的模式
        // pivotYValue:缩放轴点y坐标的相对值
        // pivotXType = Animation.ABSOLUTE:缩放轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
        // pivotXType = Animation.RELATIVE_TO_SELF:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
        // pivotXType = Animation.RELATIVE_TO_PARENT:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
        ScaleAnimation animation = new ScaleAnimation(1f,2f,1f,2f,getWidth()/2,getHeight()/2);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        tvResult.startAnimation(animation);
    }

    /**
     * 旋转动画 （轴点 顺逆时针旋转）
     * 与缩放类似
     * 属性：
     *      fromDegrees： 动画开始时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
     *      toDegrees：     动画结束时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
     *      pivotX + pivotY）组成轴点 = 旋转中心点（围绕点旋转）
     */
    private void rotateAnim(){

//        //方式一 anim 文件下创建节点rotate的动画 AnimationUtils.loadAnimation获取
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
//        tvResult.startAnimation(animation);

        //方式二 ：通常创建缩放动画类实例 RotateAnimation
        RotateAnimation animation = new RotateAnimation(0,360,getWidth()/2,getHeight()/2);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        tvResult.startAnimation(animation);
    }

    /**
     * 透明动画（视图透明度从1-0，即从有到无）
     * 属性：
     *      fromAlpha： 动画开始时视图的透明度(取值范围: -1 ~ 1)
     *      toAlpha：     动画结束时视图的透明度(取值范围: -1 ~ 1)
     */
    private void alphaAnim(){

        //方式一 anim 文件下创建节点alpha的动画 AnimationUtils.loadAnimation获取
        //Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
        //tvResult.startAnimation(animation);

        //方式二 ：通常创建缩放动画类实例 AlphaAnimation
        AlphaAnimation animation = new AlphaAnimation(1f,0f);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        tvResult.startAnimation(animation);
    }

    /**
     * 动画集合
     */
    private void setAnim(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.set_anim);
        tvResult.startAnimation(animation);
    }

    private int getWidth() {
        return tvResult.getWidth();
    }

    private int getHeight() {
        return tvResult.getHeight();
    }

}

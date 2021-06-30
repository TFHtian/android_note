package com.android_note.client.custom_view.custom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

public class PPCircleProgressView extends View {

    /**
     * 画笔
     */
    private Paint mPaint;

    /**
     * 笔画描边的宽度
     */
    private float mStrokeWidth;

    /**
     * 开始角度(默认从12点钟方向开始)
     */
    private int mStartAngle = 270;

    /**
     * 扫描角度(一个圆)
     */
    private int mSweepAngle = 360;

    /**
     * 圆心坐标x
     */
    private float mCircleCenterX;

    /**
     * 圆心坐标y
     */
    private float mCircleCenterY;

    /**
     * 半径
     */
    private float mRadius;

    /**
     * 弧形 正常颜色
     */
    private int mNormalColor = Color.YELLOW;

    /**
     * 进度颜色
     */
    private int mProgressColor = Color.RED;

    /**
     * 最大进度
     */
    private int mMax = 100;

    /**
     * 当前进度
     */
    private int mProgress = 0;

    /**
     * 动画持续的时间
     */
    private int mDuration = 500;

    public PPCircleProgressView(Context context) {
        super(context);
    }

    public PPCircleProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PPCircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs){
        mStrokeWidth = 20;
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int defaultValue = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200, getResources().getDisplayMetrics());

        int width = measureHandler(widthMeasureSpec,defaultValue);
        int height = measureHandler(heightMeasureSpec,defaultValue);

        //圆心坐标
        mCircleCenterX = (width + getPaddingLeft() - getPaddingRight())/ 2.0f;
        mCircleCenterY = (height + getPaddingTop() - getPaddingBottom())/ 2.0f;
        //计算间距
        int padding = Math.max(getPaddingLeft() + getPaddingRight(),getPaddingTop() + getPaddingBottom());
        //半径=视图宽度-横向或纵向内间距值 - 画笔宽度
        mRadius = (width - padding - mStrokeWidth) / 2.0f;

        setMeasuredDimension(width,height);
    }

    /**
     * 测量
     * @param measureSpec
     * @param defaultSize
     * @return
     */
    private int measureHandler(int measureSpec,int defaultSize){

        int result = defaultSize;
        int measureMode = MeasureSpec.getMode(measureSpec);
        int measureSize = MeasureSpec.getSize(measureSpec);
        if(measureMode == MeasureSpec.EXACTLY){
            result = measureSize;
        }else if(measureMode == MeasureSpec.AT_MOST){
            result = Math.min(defaultSize,measureSize);
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawArc(canvas);
    }

    /**
        * 绘制弧形(默认为一个圆)
     * @param canvas
     */
    private void drawArc(Canvas canvas){
        //绘制圆环
        mPaint.reset();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //伞形所在
        float diameter = mRadius * 2;
        float startX = mCircleCenterX - mRadius;
        float startY = mCircleCenterY - mRadius;
        RectF rectF1 = new RectF(startX,startY,startX + diameter,startY + diameter);
        mPaint.setColor(mNormalColor);
        //绘制底层弧形
        canvas.drawArc(rectF1,mStartAngle,mSweepAngle,false,mPaint);

        //进度
        mPaint.setColor(mProgressColor);
        float ratio = getRatio();
        if(ratio != 0){
            //绘制当前进度弧形
            canvas.drawArc(rectF1,mStartAngle,mSweepAngle * ratio,false,mPaint);
        }

        //画线
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setColor(mNormalColor);
        for (int r = 0; r < 360; r = r + 15) {
            canvas.drawLine(mCircleCenterX + (float) ((mCircleCenterX + mStrokeWidth) * Math.sin(Math.toRadians(r))),
                    mCircleCenterY - (float) ((mCircleCenterY + mStrokeWidth) * Math.cos(Math.toRadians(r))),
                    mCircleCenterX - (float) ((mCircleCenterX + mStrokeWidth) * Math.sin(Math.toRadians(r))),
                    mCircleCenterY + (float) ((mCircleCenterY + mStrokeWidth) * Math.cos(Math.toRadians(r))), mPaint);
        }
    }

    /**
     * 显示进度动画效果，从from到to变化
     * @param from
     * @param to
     * @param duration 动画时长
     */
    public void showAnimation(int from,int to,int duration){
        showAnimation(from,to,duration,null);
    }

    /**
     * 显示进度动画效果，从from到to变化
     * @param from
     * @param to
     * @param duration 动画时长
     * @param listener
     */
    public void showAnimation(int from, int to, int duration, Animator.AnimatorListener listener){
        this.mDuration = duration;
        this.mProgress = from;
        ValueAnimator valueAnimator = ValueAnimator.ofInt(from,to);
        valueAnimator.setDuration(duration);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setProgress((int)animation.getAnimatedValue());
            }
        });

        if(listener!=null){
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.addListener(listener);
        }

        valueAnimator.start();
    }

    /**
     * 进度比例
     * @return
     */
    private float getRatio(){
        return mProgress * 1.0f /mMax;
    }

    /**
     * 设置最大进度
     * @param max
     */
    public void setMax(int max){
        if(max > 0){
            this.mMax = max;
            invalidate();
        }
    }

    /**
     * 设置当前进度
     * @param progress
     */
    public void setProgress(int progress){
        setProgress(progress,false);
    }

    private void setProgress(int progress,boolean fromUser){
        if(progress < 0){
            progress = 0;
        }else if(progress > mMax){
            progress = mMax;
        }
        this.mProgress = progress;
        invalidate();
    }

}

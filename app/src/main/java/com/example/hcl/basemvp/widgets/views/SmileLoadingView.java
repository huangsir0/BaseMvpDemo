package com.example.hcl.basemvp.widgets.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class SmileLoadingView extends BaseView {

    private Paint mPaint;

    private float mWidth =0f;
    private float mEyeWidth=0f;

    private float mPadding=0f;

    private float startAngle=0f;

    private boolean isSmile=false;

    RectF rectF=new RectF();


    public SmileLoadingView(Context context) {
        super(context);
    }

    public SmileLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SmileLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredWidth()>getHeight())
            mWidth=getMeasuredHeight();
        else
            mWidth=getMeasuredWidth();
        mPadding=dip2px(10);
        mEyeWidth=dip2px(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF =new RectF(mPadding, mPadding, mWidth - mPadding, mWidth - mPadding);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF,startAngle,180,false,mPaint);
        if (isSmile) {
            canvas.drawCircle(mPadding + mEyeWidth + mEyeWidth / 2, mWidth / 3, mEyeWidth, mPaint);
            canvas.drawCircle(mWidth - mPadding - mEyeWidth - mEyeWidth / 2, mWidth / 3, mEyeWidth, mPaint);
        }
    }

    @Override
    protected void InitPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(dip2px(2));
    }


    /**
     * 外部调用
     * @param color
     */
    public void setViewColor(int color){
        mPaint.setColor(color);
        postInvalidate();
    }


    float mAnimatedValue = 0f;

    @Override
    protected void OnAnimationUpdate(ValueAnimator valueAnimator) {
        mAnimatedValue = (float) valueAnimator.getAnimatedValue();
        if (mAnimatedValue < 0.5) {
            isSmile = false;
            startAngle = 720 * mAnimatedValue;
        } else {
            startAngle = 720;
            isSmile = true;
        }

        invalidate();
    }

    @Override
    protected void OnAnimationRepeat(Animator animation) {

    }

    @Override
    protected int OnStopAnim() {
        isSmile = false;
        mAnimatedValue = 0f;
        startAngle = 0f;
        return 0;
    }

    @Override
    protected int SetAnimRepeatMode() {
        return ValueAnimator.RESTART;
    }

    @Override
    protected int SetAnimRepeatCount() {
        return ValueAnimator.INFINITE;
    }

    @Override
    protected void AinmIsRunning() {

    }
}

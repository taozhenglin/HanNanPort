package com.guideelectric.loadingdialog.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;


public class LoadCircleView extends View {
    public final String TAG = getClass().getSimpleName();

    private float mPadding = 0f;
    private RectF rectF;
    private Context mContext;
    private Paint mPaint;
    private int mWidth = 0;
    private int currentLineIndex = 0;
    private ValueAnimator mValueAnimator;

    public LoadCircleView(Context context) {
        this(context, null);
    }

    public LoadCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode != MeasureSpec.AT_MOST && heightSpecMode != MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize >= heightSpecSize ? widthSpecSize : heightSpecSize;
        } else if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode != MeasureSpec.AT_MOST) {
            mWidth = heightSpecSize;
        } else if (widthSpecMode != MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize;
        } else {
            mWidth = SizeUtils.dip2px(mContext, 50);
        }
        setMeasuredDimension(mWidth, mWidth);
        mPadding = 8;
//        rectF = new RectF(mPadding, mPadding, mWidth - mPadding, mWidth - mPadding);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 圆心坐标 (center,center)
        int center = mWidth >> 1;
        int radius = (mWidth >> 1) - 8;
        if (currentLineIndex >= 12)
            currentLineIndex = 0;
//        canvas.rotate(currentLineIndex * 30, center, center);
        // 画12根线
        for (int i = 0; i < 12; i++) {
            if (i < currentLineIndex + 4 && i >= currentLineIndex) {
                mPaint.setColor(Color.parseColor("#03DAC5"));
            } else if (currentLineIndex > 8 && i < currentLineIndex + 4 - 12) {
                mPaint.setColor(Color.parseColor("#03DAC5"));
            } else {
                mPaint.setColor(Color.parseColor("#03DAC5"));
            }

//            canvas.drawLine(center, (float) (center + 1.0 / 4 * center),
//                    center, (float) (center + 1.0 / 2 * radius), mPaint);
            canvas.drawLine(center, (float) (center + 1.0 / 2 * radius),
                    center, 2 * radius, mPaint);
            canvas.rotate(30, center, center);
        }
        currentLineIndex++;
        postInvalidateDelayed(50);
    }


    public void startAnim(final LoadCircleView loadingDialog) {
        mValueAnimator = new ValueAnimator();
        mValueAnimator.setFloatValues(0.0f,1.0f,2.0f,3.0f);
        mValueAnimator.setDuration(3000);
        mValueAnimator.setInterpolator(new BounceInterpolator());
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.setFloatValues(0.0f,360f);
        ValueAnimator.AnimatorUpdateListener mRotateX = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                loadingDialog.setRotation(value);
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(mRotateX);
        mValueAnimator.start();
    }
}

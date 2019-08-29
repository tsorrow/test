package com.tsorrow.junior.device.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TurnView extends View {
    private Paint mPaint;
    private RectF mRectF;
    private int mBeginAngle = 0;
    private boolean bRunning = false;

    public TurnView(Context context) {
        super(context);
    }

    public TurnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int diameter = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        mRectF = new RectF(getPaddingLeft(),getPaddingTop(),getPaddingLeft() + diameter,getPaddingTop() + diameter);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawArc(mRectF,mBeginAngle,30,true,mPaint);
    }

    private Handler mHandler = new Handler();
    private Runnable drawRunnable = new Runnable() {
        @Override
        public void run() {
            if (bRunning == true){
                mHandler.postDelayed(this,70);
                mBeginAngle += 1;
                invalidate();
            }else {
                mHandler.removeCallbacks(this);
            }
        }
    };

    public void start(){
        bRunning = true;
        mHandler.postDelayed(drawRunnable,0);
    }

    public void stop(){
        bRunning = false;
    }
}

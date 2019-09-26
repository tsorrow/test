package com.tsorrow.test.network.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class TextProgressBar extends ProgressBar {
    private String mProgressText = "";
    private Paint mPaint;
    private int mTextColor = Color.WHITE;
    private int mTextSize = 30;

    public TextProgressBar(Context context) {
        this(context,null);
    }

    public TextProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TextProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(mTextColor);
        mPaint.setTextSize(mTextSize);
    }

    public String getmProgressText() {
        return mProgressText;
    }

    public void setmProgressText(String mProgressText) {
        this.mProgressText = mProgressText;
    }

    public int getmTextColor() {
        return mTextColor;
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public int getmTextSize() {
        return mTextSize;
    }

    public void setmTextSize(int mTextSize) {
        this.mTextSize = mTextSize;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Rect rect = new Rect();
        mPaint.getTextBounds(mProgressText, 0, mProgressText.length(), rect);
        int x = (getWidth() / 2) - rect.centerX();
        int y = (getHeight() / 2) - rect.centerY();
        canvas.drawText(mProgressText, x, y, this.mPaint);
    }
}

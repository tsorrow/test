package com.tsorrow.test.network.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class TextProgressCircle extends View {
    private final static String TAG = "TextProgressCircle";
    private Context mContext;
    private int mProgress = 0;
    private float mTextSize = 50.0f;
    private Paint mPaintText;
    private Paint mPaintFore;
    private Paint mPaintBack;
    private int mLineWidth = 10;
    private int mLineColor = Color.WHITE;
    private RectF mRect;

    public TextProgressCircle(Context context) {
        this(context,null);
    }

    public TextProgressCircle(Context context,AttributeSet attrs) {
        super(context, attrs);
        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setColor(Color.BLUE);
        mPaintText.setTextSize(mTextSize);
        mPaintFore = new Paint();
        mPaintFore.setAntiAlias(true);
        mPaintFore.setColor(mLineColor);
        mPaintFore.setStrokeWidth(mLineWidth);
        mPaintFore.setStyle(Paint.Style.STROKE);
        mPaintBack = new Paint();
        mPaintBack.setAntiAlias(true);
        mPaintBack.setColor(Color.LTGRAY);
        mPaintBack.setStrokeWidth(mLineWidth);
        mPaintBack.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (width < 0 || height < 0){
            return;
        }
        int diameter = Math.min(width,height);
        mRect = new RectF((width-diameter)/2+mLineWidth, (height-diameter)/2+mLineWidth,
                (width+diameter)/2-mLineWidth, (height+diameter)/2-mLineWidth);
        canvas.drawArc(mRect, 0, 360, false, mPaintBack);
        canvas.drawArc(mRect, 0, mProgress*360/100, false, mPaintFore);
        String text = mProgress + "%";
        Rect rect = new Rect();
        mPaintText.getTextBounds(text, 0, text.length(), rect);
        int x = (getWidth() / 2) - rect.centerX();
        int y = (getHeight() / 2) - rect.centerY();
        canvas.drawText(text, x, y, mPaintText);
    }

    public void setProgress(int progress,float textSize){
        mProgress = progress;
        if (textSize > 0){
            mTextSize = textSize;
            mPaintText.setTextSize(mTextSize);
        }
        invalidate();
    }

    public void setProgressStyle(int lineWidth,int lineColor){
        if (lineWidth > 0){
            mLineWidth = lineWidth;
            mPaintFore.setStrokeWidth(mLineWidth);
        }
        if (lineColor > 0){
            mLineColor = lineColor;
            mPaintFore.setColor(mLineColor);
        }
        invalidate();
    }
}

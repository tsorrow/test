package com.tsorrow.junior.custom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class BeforeRelativeLayout extends RelativeLayout {
    private int mDrawType = 0;
    private Paint mPaint = new Paint();

    public BeforeRelativeLayout(Context context) {
        super(context);
    }

    public BeforeRelativeLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (width>0 && height>0){
            if (mDrawType == 1){
                Rect rect = new Rect(0,0,width,height);
                canvas.drawRect(rect,mPaint);
            } else if (mDrawType == 2){
                RectF rectF = new RectF(0,0,width,height);
                canvas.drawRoundRect(rectF,30,30,mPaint);
            } else if (mDrawType == 3){
                int radius = Math.min(width, height)/2;
                canvas.drawCircle(width/2, height/2, radius, mPaint);
            } else if (mDrawType == 4){
                RectF oval = new RectF(0, 0, width, height);
                canvas.drawOval(oval, mPaint);
            } else if (mDrawType == 5){
                Rect rect = new Rect(0, 0, width, height);
                canvas.drawRect(rect, mPaint);
                canvas.drawLine(0, 0, width, height, mPaint);
                canvas.drawLine(0, height, width, 0, mPaint);
            }
        }
    }

    public void setDrawType(int type){
        setBackgroundColor(Color.WHITE);
        mDrawType = type;
        invalidate();
    }
}

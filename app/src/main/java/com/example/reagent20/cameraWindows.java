package com.example.reagent20;

import android.widget.*;
import android.content.*;
import android.util.*;
import android.graphics.*;
import android.view.View;

public class cameraWindows extends androidx.appcompat.widget.AppCompatImageView
{
    private static Rect getbounds;
    private int linesX;
    private int linesY;
    private Paint mAreaPaint;
    private Paint mFramePaint;
    private Paint mPaint;
    private Paint paint;

    public cameraWindows(final Context context, final AttributeSet set) {
        super(context, set);
        this.linesX = 10;
        this.linesY = 10;
        this.mAreaPaint = new Paint(1);
        this.paint = new Paint();
        (this.mFramePaint = new Paint()).setColor(-16711936);
        this.mFramePaint.setStrokeWidth(2.0f);
        this.mFramePaint.setStyle(Paint.Style.STROKE);
    }

    public static void getBounds(final Rect getbounds) {
        cameraWindows.getbounds = new Rect();
        cameraWindows.getbounds = getbounds;
    }

    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        final float n = (float)canvas.getWidth();
        final float n2 = (float)canvas.getHeight();
        final int n3 = (int)(n / 3.0f);
        final int n4 = (int)(n3 * 3.5);
        final int n5 = (int)(n / 25.0f);
        this.mAreaPaint.setColor(-16777216);
        this.mAreaPaint.setStyle(Paint.Style.FILL);
        this.mAreaPaint.setAlpha(110);
        this.paint.setColor(-16711936);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(7.0f);
        canvas.drawRect(0.0f, 0.0f, n, (n2 - n4) / 2.0f, this.mAreaPaint);
        canvas.drawRect(0.0f, (n2 - n4) / 2.0f, (n - n3) / 2.0f, n2, this.mAreaPaint);
        canvas.drawRect(n3 + (n - n3) / 2.0f, (n2 - n4) / 2.0f, n, n2, this.mAreaPaint);
        canvas.drawRect((n - n3) / 2.0f, (n2 - n4) / 2.0f + n4, (n - n3) / 2.0f + n3, n2, this.mAreaPaint);
        canvas.drawLine((n - n3) / 2.0f, (n2 - n4) / 2.0f, (n - n3) / 2.0f + n5, (n2 - n4) / 2.0f, this.paint);
        canvas.drawLine((n - n3) / 2.0f, (n2 - n4) / 2.0f, (n - n3) / 2.0f, (n2 - n4) / 2.0f + n5, this.paint);
        canvas.drawLine((n - n3) / 2.0f + n3 - n5, (n2 - n4) / 2.0f, (n - n3) / 2.0f + n3, (n2 - n4) / 2.0f, this.paint);
        canvas.drawLine((n - n3) / 2.0f + n3, (n2 - n4) / 2.0f, (n - n3) / 2.0f + n3, (n2 - n4) / 2.0f + n5, this.paint);
        canvas.drawLine((n - n3) / 2.0f, (n2 - n4) / 2.0f + n4 - n5, (n - n3) / 2.0f, (n2 - n4) / 2.0f + n4, this.paint);
        canvas.drawLine((n - n3) / 2.0f, (n2 - n4) / 2.0f + n4, (n - n3) / 2.0f + n5, (n2 - n4) / 2.0f + n4, this.paint);
        canvas.drawLine((n - n3) / 2.0f + n3, (n2 - n4) / 2.0f + n4 - n5, (n - n3) / 2.0f + n3, (n2 - n4) / 2.0f + n4, this.paint);
        canvas.drawLine((n - n3) / 2.0f + n3 - n5, (n2 - n4) / 2.0f + n4, (n - n3) / 2.0f + n3, (n2 - n4) / 2.0f + n4, this.paint);
        if (cameraWindows.getbounds != null) {
            canvas.drawRect(cameraWindows.getbounds, this.mFramePaint);
            return;
        }
        this.invalidate();
    }
}

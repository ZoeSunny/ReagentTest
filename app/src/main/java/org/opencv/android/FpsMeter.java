package org.opencv.android;

import java.text.*;
import android.graphics.*;
import android.util.*;
import org.opencv.core.*;

public class FpsMeter
{
    private static final DecimalFormat FPS_FORMAT;
    private static final int STEP = 20;
    private static final String TAG = "FpsMeter";
    private int mFramesCouner;
    private double mFrequency;
    int mHeight;
    boolean mIsInitialized;
    Paint mPaint;
    private String mStrfps;
    int mWidth;
    private long mprevFrameTime;
    
    static {
        FPS_FORMAT = new DecimalFormat("0.00");
    }
    
    public FpsMeter() {
        this.mIsInitialized = false;
        this.mWidth = 0;
        this.mHeight = 0;
    }
    
    public void draw(final Canvas canvas, final float n, final float n2) {
        Log.d("FpsMeter", this.mStrfps);
        canvas.drawText(this.mStrfps, n, n2, this.mPaint);
    }
    
    public void init() {
        this.mFramesCouner = 0;
        this.mFrequency = Core.getTickFrequency();
        this.mprevFrameTime = Core.getTickCount();
        this.mStrfps = "";
        (this.mPaint = new Paint()).setColor(-16776961);
        this.mPaint.setTextSize(20.0f);
    }
    
    public void measure() {
        if (!this.mIsInitialized) {
            this.init();
            this.mIsInitialized = true;
        }
        else {
            ++this.mFramesCouner;
            if (this.mFramesCouner % 20 == 0) {
                final long tickCount = Core.getTickCount();
                final double n = 20.0 * this.mFrequency / (tickCount - this.mprevFrameTime);
                this.mprevFrameTime = tickCount;
                if (this.mWidth != 0 && this.mHeight != 0) {
                    this.mStrfps = FpsMeter.FPS_FORMAT.format(n) + " FPS@" + (Object)this.mWidth + "x" + (Object)this.mHeight;
                }
                else {
                    this.mStrfps = FpsMeter.FPS_FORMAT.format(n) + " FPS";
                }
                Log.i("FpsMeter", this.mStrfps);
            }
        }
    }
    
    public void setResolution(final int mWidth, final int mHeight) {
        this.mWidth = mWidth;
        this.mHeight = mHeight;
    }
}

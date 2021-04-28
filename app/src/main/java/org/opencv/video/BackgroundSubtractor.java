package org.opencv.video;

import org.opencv.core.*;

public class BackgroundSubtractor extends Algorithm
{
    protected BackgroundSubtractor(final long n) {
        super(n);
    }
    
    private static native void apply_0(final long p0, final long p1, final long p2, final double p3);
    
    private static native void apply_1(final long p0, final long p1, final long p2);
    
    private static native void delete(final long p0);
    
    private static native void getBackgroundImage_0(final long p0, final long p1);
    
    public void apply(final Mat mat, final Mat mat2) {
        apply_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public void apply(final Mat mat, final Mat mat2, final double n) {
        apply_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, n);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public void getBackgroundImage(final Mat mat) {
        getBackgroundImage_0(this.nativeObj, mat.nativeObj);
    }
}

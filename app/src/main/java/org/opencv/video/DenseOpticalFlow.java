package org.opencv.video;

import org.opencv.core.*;

public class DenseOpticalFlow extends Algorithm
{
    protected DenseOpticalFlow(final long n) {
        super(n);
    }
    
    private static native void calc_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void collectGarbage_0(final long p0);
    
    private static native void delete(final long p0);
    
    public void calc(final Mat mat, final Mat mat2, final Mat mat3) {
        calc_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public void collectGarbage() {
        collectGarbage_0(this.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}

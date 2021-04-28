package org.opencv.photo;

import org.opencv.core.*;

public class Tonemap extends Algorithm
{
    protected Tonemap(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native float getGamma_0(final long p0);
    
    private static native void process_0(final long p0, final long p1, final long p2);
    
    private static native void setGamma_0(final long p0, final float p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float getGamma() {
        return getGamma_0(this.nativeObj);
    }
    
    public void process(final Mat mat, final Mat mat2) {
        process_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public void setGamma(final float n) {
        setGamma_0(this.nativeObj, n);
    }
}

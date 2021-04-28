package org.opencv.photo;

import org.opencv.core.*;

public class CalibrateRobertson extends CalibrateCRF
{
    protected CalibrateRobertson(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native int getMaxIter_0(final long p0);
    
    private static native long getRadiance_0(final long p0);
    
    private static native float getThreshold_0(final long p0);
    
    private static native void setMaxIter_0(final long p0, final int p1);
    
    private static native void setThreshold_0(final long p0, final float p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getMaxIter() {
        return getMaxIter_0(this.nativeObj);
    }
    
    public Mat getRadiance() {
        return new Mat(getRadiance_0(this.nativeObj));
    }
    
    public float getThreshold() {
        return getThreshold_0(this.nativeObj);
    }
    
    public void setMaxIter(final int n) {
        setMaxIter_0(this.nativeObj, n);
    }
    
    public void setThreshold(final float n) {
        setThreshold_0(this.nativeObj, n);
    }
}

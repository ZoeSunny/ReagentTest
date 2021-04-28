package org.opencv.imgproc;

import org.opencv.core.*;

public class CLAHE extends Algorithm
{
    protected CLAHE(final long n) {
        super(n);
    }
    
    private static native void apply_0(final long p0, final long p1, final long p2);
    
    private static native void collectGarbage_0(final long p0);
    
    private static native void delete(final long p0);
    
    private static native double getClipLimit_0(final long p0);
    
    private static native double[] getTilesGridSize_0(final long p0);
    
    private static native void setClipLimit_0(final long p0, final double p1);
    
    private static native void setTilesGridSize_0(final long p0, final double p1, final double p2);
    
    public void apply(final Mat mat, final Mat mat2) {
        apply_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public void collectGarbage() {
        collectGarbage_0(this.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public double getClipLimit() {
        return getClipLimit_0(this.nativeObj);
    }
    
    public Size getTilesGridSize() {
        return new Size(getTilesGridSize_0(this.nativeObj));
    }
    
    public void setClipLimit(final double n) {
        setClipLimit_0(this.nativeObj, n);
    }
    
    public void setTilesGridSize(final Size size) {
        setTilesGridSize_0(this.nativeObj, size.width, size.height);
    }
}

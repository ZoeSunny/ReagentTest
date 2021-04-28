package org.opencv.calib3d;

import org.opencv.core.*;

public class StereoMatcher extends Algorithm
{
    public static final int DISP_SCALE = 16;
    public static final int DISP_SHIFT = 4;
    
    protected StereoMatcher(final long n) {
        super(n);
    }
    
    private static native void compute_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void delete(final long p0);
    
    private static native int getBlockSize_0(final long p0);
    
    private static native int getDisp12MaxDiff_0(final long p0);
    
    private static native int getMinDisparity_0(final long p0);
    
    private static native int getNumDisparities_0(final long p0);
    
    private static native int getSpeckleRange_0(final long p0);
    
    private static native int getSpeckleWindowSize_0(final long p0);
    
    private static native void setBlockSize_0(final long p0, final int p1);
    
    private static native void setDisp12MaxDiff_0(final long p0, final int p1);
    
    private static native void setMinDisparity_0(final long p0, final int p1);
    
    private static native void setNumDisparities_0(final long p0, final int p1);
    
    private static native void setSpeckleRange_0(final long p0, final int p1);
    
    private static native void setSpeckleWindowSize_0(final long p0, final int p1);
    
    public void compute(final Mat mat, final Mat mat2, final Mat mat3) {
        compute_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getBlockSize() {
        return getBlockSize_0(this.nativeObj);
    }
    
    public int getDisp12MaxDiff() {
        return getDisp12MaxDiff_0(this.nativeObj);
    }
    
    public int getMinDisparity() {
        return getMinDisparity_0(this.nativeObj);
    }
    
    public int getNumDisparities() {
        return getNumDisparities_0(this.nativeObj);
    }
    
    public int getSpeckleRange() {
        return getSpeckleRange_0(this.nativeObj);
    }
    
    public int getSpeckleWindowSize() {
        return getSpeckleWindowSize_0(this.nativeObj);
    }
    
    public void setBlockSize(final int n) {
        setBlockSize_0(this.nativeObj, n);
    }
    
    public void setDisp12MaxDiff(final int n) {
        setDisp12MaxDiff_0(this.nativeObj, n);
    }
    
    public void setMinDisparity(final int n) {
        setMinDisparity_0(this.nativeObj, n);
    }
    
    public void setNumDisparities(final int n) {
        setNumDisparities_0(this.nativeObj, n);
    }
    
    public void setSpeckleRange(final int n) {
        setSpeckleRange_0(this.nativeObj, n);
    }
    
    public void setSpeckleWindowSize(final int n) {
        setSpeckleWindowSize_0(this.nativeObj, n);
    }
}

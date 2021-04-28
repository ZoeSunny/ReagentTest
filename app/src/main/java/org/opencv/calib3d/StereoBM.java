package org.opencv.calib3d;

import org.opencv.core.*;

public class StereoBM extends StereoMatcher
{
    public static final int PREFILTER_NORMALIZED_RESPONSE = 0;
    public static final int PREFILTER_XSOBEL = 1;
    
    protected StereoBM(final long n) {
        super(n);
    }
    
    public static StereoBM create() {
        return new StereoBM(create_1());
    }
    
    public static StereoBM create(final int n, final int n2) {
        return new StereoBM(create_0(n, n2));
    }
    
    private static native long create_0(final int p0, final int p1);
    
    private static native long create_1();
    
    private static native void delete(final long p0);
    
    private static native int getPreFilterCap_0(final long p0);
    
    private static native int getPreFilterSize_0(final long p0);
    
    private static native int getPreFilterType_0(final long p0);
    
    private static native double[] getROI1_0(final long p0);
    
    private static native double[] getROI2_0(final long p0);
    
    private static native int getSmallerBlockSize_0(final long p0);
    
    private static native int getTextureThreshold_0(final long p0);
    
    private static native int getUniquenessRatio_0(final long p0);
    
    private static native void setPreFilterCap_0(final long p0, final int p1);
    
    private static native void setPreFilterSize_0(final long p0, final int p1);
    
    private static native void setPreFilterType_0(final long p0, final int p1);
    
    private static native void setROI1_0(final long p0, final int p1, final int p2, final int p3, final int p4);
    
    private static native void setROI2_0(final long p0, final int p1, final int p2, final int p3, final int p4);
    
    private static native void setSmallerBlockSize_0(final long p0, final int p1);
    
    private static native void setTextureThreshold_0(final long p0, final int p1);
    
    private static native void setUniquenessRatio_0(final long p0, final int p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getPreFilterCap() {
        return getPreFilterCap_0(this.nativeObj);
    }
    
    public int getPreFilterSize() {
        return getPreFilterSize_0(this.nativeObj);
    }
    
    public int getPreFilterType() {
        return getPreFilterType_0(this.nativeObj);
    }
    
    public Rect getROI1() {
        return new Rect(getROI1_0(this.nativeObj));
    }
    
    public Rect getROI2() {
        return new Rect(getROI2_0(this.nativeObj));
    }
    
    public int getSmallerBlockSize() {
        return getSmallerBlockSize_0(this.nativeObj);
    }
    
    public int getTextureThreshold() {
        return getTextureThreshold_0(this.nativeObj);
    }
    
    public int getUniquenessRatio() {
        return getUniquenessRatio_0(this.nativeObj);
    }
    
    public void setPreFilterCap(final int n) {
        setPreFilterCap_0(this.nativeObj, n);
    }
    
    public void setPreFilterSize(final int n) {
        setPreFilterSize_0(this.nativeObj, n);
    }
    
    public void setPreFilterType(final int n) {
        setPreFilterType_0(this.nativeObj, n);
    }
    
    public void setROI1(final Rect rect) {
        setROI1_0(this.nativeObj, rect.x, rect.y, rect.width, rect.height);
    }
    
    public void setROI2(final Rect rect) {
        setROI2_0(this.nativeObj, rect.x, rect.y, rect.width, rect.height);
    }
    
    public void setSmallerBlockSize(final int n) {
        setSmallerBlockSize_0(this.nativeObj, n);
    }
    
    public void setTextureThreshold(final int n) {
        setTextureThreshold_0(this.nativeObj, n);
    }
    
    public void setUniquenessRatio(final int n) {
        setUniquenessRatio_0(this.nativeObj, n);
    }
}

package org.opencv.calib3d;

public class StereoSGBM extends StereoMatcher
{
    public static final int MODE_HH = 1;
    public static final int MODE_SGBM = 0;
    public static final int MODE_SGBM_3WAY = 2;
    
    protected StereoSGBM(final long n) {
        super(n);
    }
    
    public static StereoSGBM create(final int n, final int n2, final int n3) {
        return new StereoSGBM(create_1(n, n2, n3));
    }
    
    public static StereoSGBM create(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11) {
        return new StereoSGBM(create_0(n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11));
    }
    
    private static native long create_0(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final int p7, final int p8, final int p9, final int p10);
    
    private static native long create_1(final int p0, final int p1, final int p2);
    
    private static native void delete(final long p0);
    
    private static native int getMode_0(final long p0);
    
    private static native int getP1_0(final long p0);
    
    private static native int getP2_0(final long p0);
    
    private static native int getPreFilterCap_0(final long p0);
    
    private static native int getUniquenessRatio_0(final long p0);
    
    private static native void setMode_0(final long p0, final int p1);
    
    private static native void setP1_0(final long p0, final int p1);
    
    private static native void setP2_0(final long p0, final int p1);
    
    private static native void setPreFilterCap_0(final long p0, final int p1);
    
    private static native void setUniquenessRatio_0(final long p0, final int p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getMode() {
        return getMode_0(this.nativeObj);
    }
    
    public int getP1() {
        return getP1_0(this.nativeObj);
    }
    
    public int getP2() {
        return getP2_0(this.nativeObj);
    }
    
    public int getPreFilterCap() {
        return getPreFilterCap_0(this.nativeObj);
    }
    
    public int getUniquenessRatio() {
        return getUniquenessRatio_0(this.nativeObj);
    }
    
    public void setMode(final int n) {
        setMode_0(this.nativeObj, n);
    }
    
    public void setP1(final int n) {
        setP1_0(this.nativeObj, n);
    }
    
    public void setP2(final int n) {
        setP2_0(this.nativeObj, n);
    }
    
    public void setPreFilterCap(final int n) {
        setPreFilterCap_0(this.nativeObj, n);
    }
    
    public void setUniquenessRatio(final int n) {
        setUniquenessRatio_0(this.nativeObj, n);
    }
}

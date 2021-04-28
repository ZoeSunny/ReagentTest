package org.opencv.ml;

import org.opencv.core.*;

public class KNearest extends StatModel
{
    public static final int BRUTE_FORCE = 1;
    public static final int KDTREE = 2;
    
    protected KNearest(final long n) {
        super(n);
    }
    
    public static KNearest create() {
        return new KNearest(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native float findNearest_0(final long p0, final long p1, final int p2, final long p3, final long p4, final long p5);
    
    private static native float findNearest_1(final long p0, final long p1, final int p2, final long p3);
    
    private static native int getAlgorithmType_0(final long p0);
    
    private static native int getDefaultK_0(final long p0);
    
    private static native int getEmax_0(final long p0);
    
    private static native boolean getIsClassifier_0(final long p0);
    
    private static native void setAlgorithmType_0(final long p0, final int p1);
    
    private static native void setDefaultK_0(final long p0, final int p1);
    
    private static native void setEmax_0(final long p0, final int p1);
    
    private static native void setIsClassifier_0(final long p0, final boolean p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float findNearest(final Mat mat, final int n, final Mat mat2) {
        return findNearest_1(this.nativeObj, mat.nativeObj, n, mat2.nativeObj);
    }
    
    public float findNearest(final Mat mat, final int n, final Mat mat2, final Mat mat3, final Mat mat4) {
        return findNearest_0(this.nativeObj, mat.nativeObj, n, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public int getAlgorithmType() {
        return getAlgorithmType_0(this.nativeObj);
    }
    
    public int getDefaultK() {
        return getDefaultK_0(this.nativeObj);
    }
    
    public int getEmax() {
        return getEmax_0(this.nativeObj);
    }
    
    public boolean getIsClassifier() {
        return getIsClassifier_0(this.nativeObj);
    }
    
    public void setAlgorithmType(final int n) {
        setAlgorithmType_0(this.nativeObj, n);
    }
    
    public void setDefaultK(final int n) {
        setDefaultK_0(this.nativeObj, n);
    }
    
    public void setEmax(final int n) {
        setEmax_0(this.nativeObj, n);
    }
    
    public void setIsClassifier(final boolean b) {
        setIsClassifier_0(this.nativeObj, b);
    }
}

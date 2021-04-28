package org.opencv.ml;

import org.opencv.core.*;

public class NormalBayesClassifier extends StatModel
{
    protected NormalBayesClassifier(final long n) {
        super(n);
    }
    
    public static NormalBayesClassifier create() {
        return new NormalBayesClassifier(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native float predictProb_0(final long p0, final long p1, final long p2, final long p3, final int p4);
    
    private static native float predictProb_1(final long p0, final long p1, final long p2, final long p3);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float predictProb(final Mat mat, final Mat mat2, final Mat mat3) {
        return predictProb_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public float predictProb(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        return predictProb_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
}

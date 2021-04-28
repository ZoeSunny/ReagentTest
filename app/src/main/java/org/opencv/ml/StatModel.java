package org.opencv.ml;

import org.opencv.core.*;

public class StatModel extends Algorithm
{
    public static final int COMPRESSED_INPUT = 2;
    public static final int PREPROCESSED_INPUT = 4;
    public static final int RAW_OUTPUT = 1;
    public static final int UPDATE_MODEL = 1;
    
    protected StatModel(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native boolean empty_0(final long p0);
    
    private static native int getVarCount_0(final long p0);
    
    private static native boolean isClassifier_0(final long p0);
    
    private static native boolean isTrained_0(final long p0);
    
    private static native float predict_0(final long p0, final long p1, final long p2, final int p3);
    
    private static native float predict_1(final long p0, final long p1);
    
    private static native boolean train_0(final long p0, final long p1, final int p2, final long p3);
    
    public boolean empty() {
        return empty_0(this.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getVarCount() {
        return getVarCount_0(this.nativeObj);
    }
    
    public boolean isClassifier() {
        return isClassifier_0(this.nativeObj);
    }
    
    public boolean isTrained() {
        return isTrained_0(this.nativeObj);
    }
    
    public float predict(final Mat mat) {
        return predict_1(this.nativeObj, mat.nativeObj);
    }
    
    public float predict(final Mat mat, final Mat mat2, final int n) {
        return predict_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, n);
    }
    
    public boolean train(final Mat mat, final int n, final Mat mat2) {
        return train_0(this.nativeObj, mat.nativeObj, n, mat2.nativeObj);
    }
}

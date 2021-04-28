package org.opencv.ml;

import org.opencv.core.*;

public class DTrees extends StatModel
{
    public static final int PREDICT_AUTO = 0;
    public static final int PREDICT_MASK = 768;
    public static final int PREDICT_MAX_VOTE = 512;
    public static final int PREDICT_SUM = 256;
    
    protected DTrees(final long n) {
        super(n);
    }
    
    public static DTrees create() {
        return new DTrees(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native int getCVFolds_0(final long p0);
    
    private static native int getMaxCategories_0(final long p0);
    
    private static native int getMaxDepth_0(final long p0);
    
    private static native int getMinSampleCount_0(final long p0);
    
    private static native long getPriors_0(final long p0);
    
    private static native float getRegressionAccuracy_0(final long p0);
    
    private static native boolean getTruncatePrunedTree_0(final long p0);
    
    private static native boolean getUse1SERule_0(final long p0);
    
    private static native boolean getUseSurrogates_0(final long p0);
    
    private static native void setCVFolds_0(final long p0, final int p1);
    
    private static native void setMaxCategories_0(final long p0, final int p1);
    
    private static native void setMaxDepth_0(final long p0, final int p1);
    
    private static native void setMinSampleCount_0(final long p0, final int p1);
    
    private static native void setPriors_0(final long p0, final long p1);
    
    private static native void setRegressionAccuracy_0(final long p0, final float p1);
    
    private static native void setTruncatePrunedTree_0(final long p0, final boolean p1);
    
    private static native void setUse1SERule_0(final long p0, final boolean p1);
    
    private static native void setUseSurrogates_0(final long p0, final boolean p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getCVFolds() {
        return getCVFolds_0(this.nativeObj);
    }
    
    public int getMaxCategories() {
        return getMaxCategories_0(this.nativeObj);
    }
    
    public int getMaxDepth() {
        return getMaxDepth_0(this.nativeObj);
    }
    
    public int getMinSampleCount() {
        return getMinSampleCount_0(this.nativeObj);
    }
    
    public Mat getPriors() {
        return new Mat(getPriors_0(this.nativeObj));
    }
    
    public float getRegressionAccuracy() {
        return getRegressionAccuracy_0(this.nativeObj);
    }
    
    public boolean getTruncatePrunedTree() {
        return getTruncatePrunedTree_0(this.nativeObj);
    }
    
    public boolean getUse1SERule() {
        return getUse1SERule_0(this.nativeObj);
    }
    
    public boolean getUseSurrogates() {
        return getUseSurrogates_0(this.nativeObj);
    }
    
    public void setCVFolds(final int n) {
        setCVFolds_0(this.nativeObj, n);
    }
    
    public void setMaxCategories(final int n) {
        setMaxCategories_0(this.nativeObj, n);
    }
    
    public void setMaxDepth(final int n) {
        setMaxDepth_0(this.nativeObj, n);
    }
    
    public void setMinSampleCount(final int n) {
        setMinSampleCount_0(this.nativeObj, n);
    }
    
    public void setPriors(final Mat mat) {
        setPriors_0(this.nativeObj, mat.nativeObj);
    }
    
    public void setRegressionAccuracy(final float n) {
        setRegressionAccuracy_0(this.nativeObj, n);
    }
    
    public void setTruncatePrunedTree(final boolean b) {
        setTruncatePrunedTree_0(this.nativeObj, b);
    }
    
    public void setUse1SERule(final boolean b) {
        setUse1SERule_0(this.nativeObj, b);
    }
    
    public void setUseSurrogates(final boolean b) {
        setUseSurrogates_0(this.nativeObj, b);
    }
}

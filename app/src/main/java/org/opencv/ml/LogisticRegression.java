package org.opencv.ml;

import org.opencv.core.*;

public class LogisticRegression extends StatModel
{
    public static final int BATCH = 0;
    public static final int MINI_BATCH = 1;
    public static final int REG_DISABLE = -1;
    public static final int REG_L1 = 0;
    public static final int REG_L2 = 1;
    
    protected LogisticRegression(final long n) {
        super(n);
    }
    
    public static LogisticRegression create() {
        return new LogisticRegression(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native int getIterations_0(final long p0);
    
    private static native double getLearningRate_0(final long p0);
    
    private static native int getMiniBatchSize_0(final long p0);
    
    private static native int getRegularization_0(final long p0);
    
    private static native double[] getTermCriteria_0(final long p0);
    
    private static native int getTrainMethod_0(final long p0);
    
    private static native long get_learnt_thetas_0(final long p0);
    
    private static native float predict_0(final long p0, final long p1, final long p2, final int p3);
    
    private static native float predict_1(final long p0, final long p1);
    
    private static native void setIterations_0(final long p0, final int p1);
    
    private static native void setLearningRate_0(final long p0, final double p1);
    
    private static native void setMiniBatchSize_0(final long p0, final int p1);
    
    private static native void setRegularization_0(final long p0, final int p1);
    
    private static native void setTermCriteria_0(final long p0, final int p1, final int p2, final double p3);
    
    private static native void setTrainMethod_0(final long p0, final int p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getIterations() {
        return getIterations_0(this.nativeObj);
    }
    
    public double getLearningRate() {
        return getLearningRate_0(this.nativeObj);
    }
    
    public int getMiniBatchSize() {
        return getMiniBatchSize_0(this.nativeObj);
    }
    
    public int getRegularization() {
        return getRegularization_0(this.nativeObj);
    }
    
    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }
    
    public int getTrainMethod() {
        return getTrainMethod_0(this.nativeObj);
    }
    
    public Mat get_learnt_thetas() {
        return new Mat(get_learnt_thetas_0(this.nativeObj));
    }
    
    @Override
    public float predict(final Mat mat) {
        return predict_1(this.nativeObj, mat.nativeObj);
    }
    
    @Override
    public float predict(final Mat mat, final Mat mat2, final int n) {
        return predict_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, n);
    }
    
    public void setIterations(final int n) {
        setIterations_0(this.nativeObj, n);
    }
    
    public void setLearningRate(final double n) {
        setLearningRate_0(this.nativeObj, n);
    }
    
    public void setMiniBatchSize(final int n) {
        setMiniBatchSize_0(this.nativeObj, n);
    }
    
    public void setRegularization(final int n) {
        setRegularization_0(this.nativeObj, n);
    }
    
    public void setTermCriteria(final TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
    
    public void setTrainMethod(final int n) {
        setTrainMethod_0(this.nativeObj, n);
    }
}

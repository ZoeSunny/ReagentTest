package org.opencv.ml;

import org.opencv.core.*;

public class SVM extends StatModel
{
    public static final int C = 0;
    public static final int CHI2 = 4;
    public static final int COEF = 4;
    public static final int CUSTOM = -1;
    public static final int C_SVC = 100;
    public static final int DEGREE = 5;
    public static final int EPS_SVR = 103;
    public static final int GAMMA = 1;
    public static final int INTER = 5;
    public static final int LINEAR = 0;
    public static final int NU = 3;
    public static final int NU_SVC = 101;
    public static final int NU_SVR = 104;
    public static final int ONE_CLASS = 102;
    public static final int P = 2;
    public static final int POLY = 1;
    public static final int RBF = 2;
    public static final int SIGMOID = 3;
    
    protected SVM(final long n) {
        super(n);
    }
    
    public static SVM create() {
        return new SVM(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native double getC_0(final long p0);
    
    private static native long getClassWeights_0(final long p0);
    
    private static native double getCoef0_0(final long p0);
    
    private static native double getDecisionFunction_0(final long p0, final int p1, final long p2, final long p3);
    
    private static native double getDegree_0(final long p0);
    
    private static native double getGamma_0(final long p0);
    
    private static native int getKernelType_0(final long p0);
    
    private static native double getNu_0(final long p0);
    
    private static native double getP_0(final long p0);
    
    private static native long getSupportVectors_0(final long p0);
    
    private static native double[] getTermCriteria_0(final long p0);
    
    private static native int getType_0(final long p0);
    
    private static native long getUncompressedSupportVectors_0(final long p0);
    
    private static native void setC_0(final long p0, final double p1);
    
    private static native void setClassWeights_0(final long p0, final long p1);
    
    private static native void setCoef0_0(final long p0, final double p1);
    
    private static native void setDegree_0(final long p0, final double p1);
    
    private static native void setGamma_0(final long p0, final double p1);
    
    private static native void setKernel_0(final long p0, final int p1);
    
    private static native void setNu_0(final long p0, final double p1);
    
    private static native void setP_0(final long p0, final double p1);
    
    private static native void setTermCriteria_0(final long p0, final int p1, final int p2, final double p3);
    
    private static native void setType_0(final long p0, final int p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public double getC() {
        return getC_0(this.nativeObj);
    }
    
    public Mat getClassWeights() {
        return new Mat(getClassWeights_0(this.nativeObj));
    }
    
    public double getCoef0() {
        return getCoef0_0(this.nativeObj);
    }
    
    public double getDecisionFunction(final int n, final Mat mat, final Mat mat2) {
        return getDecisionFunction_0(this.nativeObj, n, mat.nativeObj, mat2.nativeObj);
    }
    
    public double getDegree() {
        return getDegree_0(this.nativeObj);
    }
    
    public double getGamma() {
        return getGamma_0(this.nativeObj);
    }
    
    public int getKernelType() {
        return getKernelType_0(this.nativeObj);
    }
    
    public double getNu() {
        return getNu_0(this.nativeObj);
    }
    
    public double getP() {
        return getP_0(this.nativeObj);
    }
    
    public Mat getSupportVectors() {
        return new Mat(getSupportVectors_0(this.nativeObj));
    }
    
    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }
    
    public int getType() {
        return getType_0(this.nativeObj);
    }
    
    public Mat getUncompressedSupportVectors() {
        return new Mat(getUncompressedSupportVectors_0(this.nativeObj));
    }
    
    public void setC(final double n) {
        setC_0(this.nativeObj, n);
    }
    
    public void setClassWeights(final Mat mat) {
        setClassWeights_0(this.nativeObj, mat.nativeObj);
    }
    
    public void setCoef0(final double n) {
        setCoef0_0(this.nativeObj, n);
    }
    
    public void setDegree(final double n) {
        setDegree_0(this.nativeObj, n);
    }
    
    public void setGamma(final double n) {
        setGamma_0(this.nativeObj, n);
    }
    
    public void setKernel(final int n) {
        setKernel_0(this.nativeObj, n);
    }
    
    public void setNu(final double n) {
        setNu_0(this.nativeObj, n);
    }
    
    public void setP(final double n) {
        setP_0(this.nativeObj, n);
    }
    
    public void setTermCriteria(final TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
    
    public void setType(final int n) {
        setType_0(this.nativeObj, n);
    }
}

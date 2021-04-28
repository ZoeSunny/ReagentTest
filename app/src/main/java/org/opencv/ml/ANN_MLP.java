package org.opencv.ml;

import org.opencv.core.*;

public class ANN_MLP extends StatModel
{
    public static final int BACKPROP = 0;
    public static final int GAUSSIAN = 2;
    public static final int IDENTITY = 0;
    public static final int NO_INPUT_SCALE = 2;
    public static final int NO_OUTPUT_SCALE = 4;
    public static final int RPROP = 1;
    public static final int SIGMOID_SYM = 1;
    public static final int UPDATE_WEIGHTS = 1;
    
    protected ANN_MLP(final long n) {
        super(n);
    }
    
    public static ANN_MLP create() {
        return new ANN_MLP(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native double getBackpropMomentumScale_0(final long p0);
    
    private static native double getBackpropWeightScale_0(final long p0);
    
    private static native long getLayerSizes_0(final long p0);
    
    private static native double getRpropDW0_0(final long p0);
    
    private static native double getRpropDWMax_0(final long p0);
    
    private static native double getRpropDWMin_0(final long p0);
    
    private static native double getRpropDWMinus_0(final long p0);
    
    private static native double getRpropDWPlus_0(final long p0);
    
    private static native double[] getTermCriteria_0(final long p0);
    
    private static native int getTrainMethod_0(final long p0);
    
    private static native long getWeights_0(final long p0, final int p1);
    
    private static native void setActivationFunction_0(final long p0, final int p1, final double p2, final double p3);
    
    private static native void setActivationFunction_1(final long p0, final int p1);
    
    private static native void setBackpropMomentumScale_0(final long p0, final double p1);
    
    private static native void setBackpropWeightScale_0(final long p0, final double p1);
    
    private static native void setLayerSizes_0(final long p0, final long p1);
    
    private static native void setRpropDW0_0(final long p0, final double p1);
    
    private static native void setRpropDWMax_0(final long p0, final double p1);
    
    private static native void setRpropDWMin_0(final long p0, final double p1);
    
    private static native void setRpropDWMinus_0(final long p0, final double p1);
    
    private static native void setRpropDWPlus_0(final long p0, final double p1);
    
    private static native void setTermCriteria_0(final long p0, final int p1, final int p2, final double p3);
    
    private static native void setTrainMethod_0(final long p0, final int p1, final double p2, final double p3);
    
    private static native void setTrainMethod_1(final long p0, final int p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public double getBackpropMomentumScale() {
        return getBackpropMomentumScale_0(this.nativeObj);
    }
    
    public double getBackpropWeightScale() {
        return getBackpropWeightScale_0(this.nativeObj);
    }
    
    public Mat getLayerSizes() {
        return new Mat(getLayerSizes_0(this.nativeObj));
    }
    
    public double getRpropDW0() {
        return getRpropDW0_0(this.nativeObj);
    }
    
    public double getRpropDWMax() {
        return getRpropDWMax_0(this.nativeObj);
    }
    
    public double getRpropDWMin() {
        return getRpropDWMin_0(this.nativeObj);
    }
    
    public double getRpropDWMinus() {
        return getRpropDWMinus_0(this.nativeObj);
    }
    
    public double getRpropDWPlus() {
        return getRpropDWPlus_0(this.nativeObj);
    }
    
    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }
    
    public int getTrainMethod() {
        return getTrainMethod_0(this.nativeObj);
    }
    
    public Mat getWeights(final int n) {
        return new Mat(getWeights_0(this.nativeObj, n));
    }
    
    public void setActivationFunction(final int n) {
        setActivationFunction_1(this.nativeObj, n);
    }
    
    public void setActivationFunction(final int n, final double n2, final double n3) {
        setActivationFunction_0(this.nativeObj, n, n2, n3);
    }
    
    public void setBackpropMomentumScale(final double n) {
        setBackpropMomentumScale_0(this.nativeObj, n);
    }
    
    public void setBackpropWeightScale(final double n) {
        setBackpropWeightScale_0(this.nativeObj, n);
    }
    
    public void setLayerSizes(final Mat mat) {
        setLayerSizes_0(this.nativeObj, mat.nativeObj);
    }
    
    public void setRpropDW0(final double n) {
        setRpropDW0_0(this.nativeObj, n);
    }
    
    public void setRpropDWMax(final double n) {
        setRpropDWMax_0(this.nativeObj, n);
    }
    
    public void setRpropDWMin(final double n) {
        setRpropDWMin_0(this.nativeObj, n);
    }
    
    public void setRpropDWMinus(final double n) {
        setRpropDWMinus_0(this.nativeObj, n);
    }
    
    public void setRpropDWPlus(final double n) {
        setRpropDWPlus_0(this.nativeObj, n);
    }
    
    public void setTermCriteria(final TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
    
    public void setTrainMethod(final int n) {
        setTrainMethod_1(this.nativeObj, n);
    }
    
    public void setTrainMethod(final int n, final double n2, final double n3) {
        setTrainMethod_0(this.nativeObj, n, n2, n3);
    }
}

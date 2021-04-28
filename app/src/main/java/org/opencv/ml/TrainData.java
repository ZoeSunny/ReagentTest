package org.opencv.ml;

import org.opencv.core.*;

public class TrainData
{
    protected final long nativeObj;
    
    protected TrainData(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    private static native void delete(final long p0);
    
    private static native int getCatCount_0(final long p0, final int p1);
    
    private static native long getCatMap_0(final long p0);
    
    private static native long getCatOfs_0(final long p0);
    
    private static native long getClassLabels_0(final long p0);
    
    private static native long getDefaultSubstValues_0(final long p0);
    
    private static native int getLayout_0(final long p0);
    
    private static native long getMissing_0(final long p0);
    
    private static native int getNAllVars_0(final long p0);
    
    private static native int getNSamples_0(final long p0);
    
    private static native int getNTestSamples_0(final long p0);
    
    private static native int getNTrainSamples_0(final long p0);
    
    private static native int getNVars_0(final long p0);
    
    private static native long getNormCatResponses_0(final long p0);
    
    private static native int getResponseType_0(final long p0);
    
    private static native long getResponses_0(final long p0);
    
    private static native long getSampleWeights_0(final long p0);
    
    private static native void getSample_0(final long p0, final long p1, final int p2, final float p3);
    
    private static native long getSamples_0(final long p0);
    
    public static Mat getSubVector(final Mat mat, final Mat mat2) {
        return new Mat(getSubVector_0(mat.nativeObj, mat2.nativeObj));
    }
    
    private static native long getSubVector_0(final long p0, final long p1);
    
    private static native long getTestNormCatResponses_0(final long p0);
    
    private static native long getTestResponses_0(final long p0);
    
    private static native long getTestSampleIdx_0(final long p0);
    
    private static native long getTestSampleWeights_0(final long p0);
    
    private static native long getTrainNormCatResponses_0(final long p0);
    
    private static native long getTrainResponses_0(final long p0);
    
    private static native long getTrainSampleIdx_0(final long p0);
    
    private static native long getTrainSampleWeights_0(final long p0);
    
    private static native long getTrainSamples_0(final long p0, final int p1, final boolean p2, final boolean p3);
    
    private static native long getTrainSamples_1(final long p0);
    
    private static native void getValues_0(final long p0, final int p1, final long p2, final float p3);
    
    private static native long getVarIdx_0(final long p0);
    
    private static native long getVarType_0(final long p0);
    
    private static native void setTrainTestSplitRatio_0(final long p0, final double p1, final boolean p2);
    
    private static native void setTrainTestSplitRatio_1(final long p0, final double p1);
    
    private static native void setTrainTestSplit_0(final long p0, final int p1, final boolean p2);
    
    private static native void setTrainTestSplit_1(final long p0, final int p1);
    
    private static native void shuffleTrainTest_0(final long p0);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getCatCount(final int n) {
        return getCatCount_0(this.nativeObj, n);
    }
    
    public Mat getCatMap() {
        return new Mat(getCatMap_0(this.nativeObj));
    }
    
    public Mat getCatOfs() {
        return new Mat(getCatOfs_0(this.nativeObj));
    }
    
    public Mat getClassLabels() {
        return new Mat(getClassLabels_0(this.nativeObj));
    }
    
    public Mat getDefaultSubstValues() {
        return new Mat(getDefaultSubstValues_0(this.nativeObj));
    }
    
    public int getLayout() {
        return getLayout_0(this.nativeObj);
    }
    
    public Mat getMissing() {
        return new Mat(getMissing_0(this.nativeObj));
    }
    
    public int getNAllVars() {
        return getNAllVars_0(this.nativeObj);
    }
    
    public int getNSamples() {
        return getNSamples_0(this.nativeObj);
    }
    
    public int getNTestSamples() {
        return getNTestSamples_0(this.nativeObj);
    }
    
    public int getNTrainSamples() {
        return getNTrainSamples_0(this.nativeObj);
    }
    
    public int getNVars() {
        return getNVars_0(this.nativeObj);
    }
    
    public Mat getNormCatResponses() {
        return new Mat(getNormCatResponses_0(this.nativeObj));
    }
    
    public int getResponseType() {
        return getResponseType_0(this.nativeObj);
    }
    
    public Mat getResponses() {
        return new Mat(getResponses_0(this.nativeObj));
    }
    
    public void getSample(final Mat mat, final int n, final float n2) {
        getSample_0(this.nativeObj, mat.nativeObj, n, n2);
    }
    
    public Mat getSampleWeights() {
        return new Mat(getSampleWeights_0(this.nativeObj));
    }
    
    public Mat getSamples() {
        return new Mat(getSamples_0(this.nativeObj));
    }
    
    public Mat getTestNormCatResponses() {
        return new Mat(getTestNormCatResponses_0(this.nativeObj));
    }
    
    public Mat getTestResponses() {
        return new Mat(getTestResponses_0(this.nativeObj));
    }
    
    public Mat getTestSampleIdx() {
        return new Mat(getTestSampleIdx_0(this.nativeObj));
    }
    
    public Mat getTestSampleWeights() {
        return new Mat(getTestSampleWeights_0(this.nativeObj));
    }
    
    public Mat getTrainNormCatResponses() {
        return new Mat(getTrainNormCatResponses_0(this.nativeObj));
    }
    
    public Mat getTrainResponses() {
        return new Mat(getTrainResponses_0(this.nativeObj));
    }
    
    public Mat getTrainSampleIdx() {
        return new Mat(getTrainSampleIdx_0(this.nativeObj));
    }
    
    public Mat getTrainSampleWeights() {
        return new Mat(getTrainSampleWeights_0(this.nativeObj));
    }
    
    public Mat getTrainSamples() {
        return new Mat(getTrainSamples_1(this.nativeObj));
    }
    
    public Mat getTrainSamples(final int n, final boolean b, final boolean b2) {
        return new Mat(getTrainSamples_0(this.nativeObj, n, b, b2));
    }
    
    public void getValues(final int n, final Mat mat, final float n2) {
        getValues_0(this.nativeObj, n, mat.nativeObj, n2);
    }
    
    public Mat getVarIdx() {
        return new Mat(getVarIdx_0(this.nativeObj));
    }
    
    public Mat getVarType() {
        return new Mat(getVarType_0(this.nativeObj));
    }
    
    public void setTrainTestSplit(final int n) {
        setTrainTestSplit_1(this.nativeObj, n);
    }
    
    public void setTrainTestSplit(final int n, final boolean b) {
        setTrainTestSplit_0(this.nativeObj, n, b);
    }
    
    public void setTrainTestSplitRatio(final double n) {
        setTrainTestSplitRatio_1(this.nativeObj, n);
    }
    
    public void setTrainTestSplitRatio(final double n, final boolean b) {
        setTrainTestSplitRatio_0(this.nativeObj, n, b);
    }
    
    public void shuffleTrainTest() {
        shuffleTrainTest_0(this.nativeObj);
    }
}

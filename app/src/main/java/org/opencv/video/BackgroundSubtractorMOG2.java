package org.opencv.video;

public class BackgroundSubtractorMOG2 extends BackgroundSubtractor
{
    protected BackgroundSubtractorMOG2(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native double getBackgroundRatio_0(final long p0);
    
    private static native double getComplexityReductionThreshold_0(final long p0);
    
    private static native boolean getDetectShadows_0(final long p0);
    
    private static native int getHistory_0(final long p0);
    
    private static native int getNMixtures_0(final long p0);
    
    private static native double getShadowThreshold_0(final long p0);
    
    private static native int getShadowValue_0(final long p0);
    
    private static native double getVarInit_0(final long p0);
    
    private static native double getVarMax_0(final long p0);
    
    private static native double getVarMin_0(final long p0);
    
    private static native double getVarThresholdGen_0(final long p0);
    
    private static native double getVarThreshold_0(final long p0);
    
    private static native void setBackgroundRatio_0(final long p0, final double p1);
    
    private static native void setComplexityReductionThreshold_0(final long p0, final double p1);
    
    private static native void setDetectShadows_0(final long p0, final boolean p1);
    
    private static native void setHistory_0(final long p0, final int p1);
    
    private static native void setNMixtures_0(final long p0, final int p1);
    
    private static native void setShadowThreshold_0(final long p0, final double p1);
    
    private static native void setShadowValue_0(final long p0, final int p1);
    
    private static native void setVarInit_0(final long p0, final double p1);
    
    private static native void setVarMax_0(final long p0, final double p1);
    
    private static native void setVarMin_0(final long p0, final double p1);
    
    private static native void setVarThresholdGen_0(final long p0, final double p1);
    
    private static native void setVarThreshold_0(final long p0, final double p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public double getBackgroundRatio() {
        return getBackgroundRatio_0(this.nativeObj);
    }
    
    public double getComplexityReductionThreshold() {
        return getComplexityReductionThreshold_0(this.nativeObj);
    }
    
    public boolean getDetectShadows() {
        return getDetectShadows_0(this.nativeObj);
    }
    
    public int getHistory() {
        return getHistory_0(this.nativeObj);
    }
    
    public int getNMixtures() {
        return getNMixtures_0(this.nativeObj);
    }
    
    public double getShadowThreshold() {
        return getShadowThreshold_0(this.nativeObj);
    }
    
    public int getShadowValue() {
        return getShadowValue_0(this.nativeObj);
    }
    
    public double getVarInit() {
        return getVarInit_0(this.nativeObj);
    }
    
    public double getVarMax() {
        return getVarMax_0(this.nativeObj);
    }
    
    public double getVarMin() {
        return getVarMin_0(this.nativeObj);
    }
    
    public double getVarThreshold() {
        return getVarThreshold_0(this.nativeObj);
    }
    
    public double getVarThresholdGen() {
        return getVarThresholdGen_0(this.nativeObj);
    }
    
    public void setBackgroundRatio(final double n) {
        setBackgroundRatio_0(this.nativeObj, n);
    }
    
    public void setComplexityReductionThreshold(final double n) {
        setComplexityReductionThreshold_0(this.nativeObj, n);
    }
    
    public void setDetectShadows(final boolean b) {
        setDetectShadows_0(this.nativeObj, b);
    }
    
    public void setHistory(final int n) {
        setHistory_0(this.nativeObj, n);
    }
    
    public void setNMixtures(final int n) {
        setNMixtures_0(this.nativeObj, n);
    }
    
    public void setShadowThreshold(final double n) {
        setShadowThreshold_0(this.nativeObj, n);
    }
    
    public void setShadowValue(final int n) {
        setShadowValue_0(this.nativeObj, n);
    }
    
    public void setVarInit(final double n) {
        setVarInit_0(this.nativeObj, n);
    }
    
    public void setVarMax(final double n) {
        setVarMax_0(this.nativeObj, n);
    }
    
    public void setVarMin(final double n) {
        setVarMin_0(this.nativeObj, n);
    }
    
    public void setVarThreshold(final double n) {
        setVarThreshold_0(this.nativeObj, n);
    }
    
    public void setVarThresholdGen(final double n) {
        setVarThresholdGen_0(this.nativeObj, n);
    }
}

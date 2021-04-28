package org.opencv.video;

public class BackgroundSubtractorKNN extends BackgroundSubtractor
{
    protected BackgroundSubtractorKNN(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native boolean getDetectShadows_0(final long p0);
    
    private static native double getDist2Threshold_0(final long p0);
    
    private static native int getHistory_0(final long p0);
    
    private static native int getNSamples_0(final long p0);
    
    private static native double getShadowThreshold_0(final long p0);
    
    private static native int getShadowValue_0(final long p0);
    
    private static native int getkNNSamples_0(final long p0);
    
    private static native void setDetectShadows_0(final long p0, final boolean p1);
    
    private static native void setDist2Threshold_0(final long p0, final double p1);
    
    private static native void setHistory_0(final long p0, final int p1);
    
    private static native void setNSamples_0(final long p0, final int p1);
    
    private static native void setShadowThreshold_0(final long p0, final double p1);
    
    private static native void setShadowValue_0(final long p0, final int p1);
    
    private static native void setkNNSamples_0(final long p0, final int p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public boolean getDetectShadows() {
        return getDetectShadows_0(this.nativeObj);
    }
    
    public double getDist2Threshold() {
        return getDist2Threshold_0(this.nativeObj);
    }
    
    public int getHistory() {
        return getHistory_0(this.nativeObj);
    }
    
    public int getNSamples() {
        return getNSamples_0(this.nativeObj);
    }
    
    public double getShadowThreshold() {
        return getShadowThreshold_0(this.nativeObj);
    }
    
    public int getShadowValue() {
        return getShadowValue_0(this.nativeObj);
    }
    
    public int getkNNSamples() {
        return getkNNSamples_0(this.nativeObj);
    }
    
    public void setDetectShadows(final boolean b) {
        setDetectShadows_0(this.nativeObj, b);
    }
    
    public void setDist2Threshold(final double n) {
        setDist2Threshold_0(this.nativeObj, n);
    }
    
    public void setHistory(final int n) {
        setHistory_0(this.nativeObj, n);
    }
    
    public void setNSamples(final int n) {
        setNSamples_0(this.nativeObj, n);
    }
    
    public void setShadowThreshold(final double n) {
        setShadowThreshold_0(this.nativeObj, n);
    }
    
    public void setShadowValue(final int n) {
        setShadowValue_0(this.nativeObj, n);
    }
    
    public void setkNNSamples(final int n) {
        setkNNSamples_0(this.nativeObj, n);
    }
}

package org.opencv.photo;

public class CalibrateDebevec extends CalibrateCRF
{
    protected CalibrateDebevec(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native float getLambda_0(final long p0);
    
    private static native boolean getRandom_0(final long p0);
    
    private static native int getSamples_0(final long p0);
    
    private static native void setLambda_0(final long p0, final float p1);
    
    private static native void setRandom_0(final long p0, final boolean p1);
    
    private static native void setSamples_0(final long p0, final int p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float getLambda() {
        return getLambda_0(this.nativeObj);
    }
    
    public boolean getRandom() {
        return getRandom_0(this.nativeObj);
    }
    
    public int getSamples() {
        return getSamples_0(this.nativeObj);
    }
    
    public void setLambda(final float n) {
        setLambda_0(this.nativeObj, n);
    }
    
    public void setRandom(final boolean b) {
        setRandom_0(this.nativeObj, b);
    }
    
    public void setSamples(final int n) {
        setSamples_0(this.nativeObj, n);
    }
}

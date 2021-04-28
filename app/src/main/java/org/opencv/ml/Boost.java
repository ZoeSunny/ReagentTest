package org.opencv.ml;

public class Boost extends DTrees
{
    public static final int DISCRETE = 0;
    public static final int GENTLE = 3;
    public static final int LOGIT = 2;
    public static final int REAL = 1;
    
    protected Boost(final long n) {
        super(n);
    }
    
    public static Boost create() {
        return new Boost(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native int getBoostType_0(final long p0);
    
    private static native int getWeakCount_0(final long p0);
    
    private static native double getWeightTrimRate_0(final long p0);
    
    private static native void setBoostType_0(final long p0, final int p1);
    
    private static native void setWeakCount_0(final long p0, final int p1);
    
    private static native void setWeightTrimRate_0(final long p0, final double p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getBoostType() {
        return getBoostType_0(this.nativeObj);
    }
    
    public int getWeakCount() {
        return getWeakCount_0(this.nativeObj);
    }
    
    public double getWeightTrimRate() {
        return getWeightTrimRate_0(this.nativeObj);
    }
    
    public void setBoostType(final int n) {
        setBoostType_0(this.nativeObj, n);
    }
    
    public void setWeakCount(final int n) {
        setWeakCount_0(this.nativeObj, n);
    }
    
    public void setWeightTrimRate(final double n) {
        setWeightTrimRate_0(this.nativeObj, n);
    }
}

package org.opencv.photo;

public class TonemapDrago extends Tonemap
{
    protected TonemapDrago(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native float getBias_0(final long p0);
    
    private static native float getSaturation_0(final long p0);
    
    private static native void setBias_0(final long p0, final float p1);
    
    private static native void setSaturation_0(final long p0, final float p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float getBias() {
        return getBias_0(this.nativeObj);
    }
    
    public float getSaturation() {
        return getSaturation_0(this.nativeObj);
    }
    
    public void setBias(final float n) {
        setBias_0(this.nativeObj, n);
    }
    
    public void setSaturation(final float n) {
        setSaturation_0(this.nativeObj, n);
    }
}

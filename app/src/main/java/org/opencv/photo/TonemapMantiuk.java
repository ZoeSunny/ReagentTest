package org.opencv.photo;

public class TonemapMantiuk extends Tonemap
{
    protected TonemapMantiuk(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native float getSaturation_0(final long p0);
    
    private static native float getScale_0(final long p0);
    
    private static native void setSaturation_0(final long p0, final float p1);
    
    private static native void setScale_0(final long p0, final float p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float getSaturation() {
        return getSaturation_0(this.nativeObj);
    }
    
    public float getScale() {
        return getScale_0(this.nativeObj);
    }
    
    public void setSaturation(final float n) {
        setSaturation_0(this.nativeObj, n);
    }
    
    public void setScale(final float n) {
        setScale_0(this.nativeObj, n);
    }
}

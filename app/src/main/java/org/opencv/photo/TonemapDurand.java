package org.opencv.photo;

public class TonemapDurand extends Tonemap
{
    protected TonemapDurand(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native float getContrast_0(final long p0);
    
    private static native float getSaturation_0(final long p0);
    
    private static native float getSigmaColor_0(final long p0);
    
    private static native float getSigmaSpace_0(final long p0);
    
    private static native void setContrast_0(final long p0, final float p1);
    
    private static native void setSaturation_0(final long p0, final float p1);
    
    private static native void setSigmaColor_0(final long p0, final float p1);
    
    private static native void setSigmaSpace_0(final long p0, final float p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float getContrast() {
        return getContrast_0(this.nativeObj);
    }
    
    public float getSaturation() {
        return getSaturation_0(this.nativeObj);
    }
    
    public float getSigmaColor() {
        return getSigmaColor_0(this.nativeObj);
    }
    
    public float getSigmaSpace() {
        return getSigmaSpace_0(this.nativeObj);
    }
    
    public void setContrast(final float n) {
        setContrast_0(this.nativeObj, n);
    }
    
    public void setSaturation(final float n) {
        setSaturation_0(this.nativeObj, n);
    }
    
    public void setSigmaColor(final float n) {
        setSigmaColor_0(this.nativeObj, n);
    }
    
    public void setSigmaSpace(final float n) {
        setSigmaSpace_0(this.nativeObj, n);
    }
}

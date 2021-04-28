package org.opencv.photo;

public class TonemapReinhard extends Tonemap
{
    protected TonemapReinhard(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native float getColorAdaptation_0(final long p0);
    
    private static native float getIntensity_0(final long p0);
    
    private static native float getLightAdaptation_0(final long p0);
    
    private static native void setColorAdaptation_0(final long p0, final float p1);
    
    private static native void setIntensity_0(final long p0, final float p1);
    
    private static native void setLightAdaptation_0(final long p0, final float p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float getColorAdaptation() {
        return getColorAdaptation_0(this.nativeObj);
    }
    
    public float getIntensity() {
        return getIntensity_0(this.nativeObj);
    }
    
    public float getLightAdaptation() {
        return getLightAdaptation_0(this.nativeObj);
    }
    
    public void setColorAdaptation(final float n) {
        setColorAdaptation_0(this.nativeObj, n);
    }
    
    public void setIntensity(final float n) {
        setIntensity_0(this.nativeObj, n);
    }
    
    public void setLightAdaptation(final float n) {
        setLightAdaptation_0(this.nativeObj, n);
    }
}

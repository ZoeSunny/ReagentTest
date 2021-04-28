package org.opencv.core;

public class Algorithm
{
    protected final long nativeObj;
    
    protected Algorithm(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    private static native void clear_0(final long p0);
    
    private static native void delete(final long p0);
    
    private static native String getDefaultName_0(final long p0);
    
    private static native void save_0(final long p0, final String p1);
    
    public void clear() {
        clear_0(this.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }
    
    public void save(final String s) {
        save_0(this.nativeObj, s);
    }
}

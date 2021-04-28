package org.opencv.video;

public class DualTVL1OpticalFlow extends DenseOpticalFlow
{
    protected DualTVL1OpticalFlow(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}

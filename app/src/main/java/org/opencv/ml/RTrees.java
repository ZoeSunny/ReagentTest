package org.opencv.ml;

import org.opencv.core.*;

public class RTrees extends DTrees
{
    protected RTrees(final long n) {
        super(n);
    }
    
    public static RTrees create() {
        return new RTrees(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native int getActiveVarCount_0(final long p0);
    
    private static native boolean getCalculateVarImportance_0(final long p0);
    
    private static native double[] getTermCriteria_0(final long p0);
    
    private static native long getVarImportance_0(final long p0);
    
    private static native void setActiveVarCount_0(final long p0, final int p1);
    
    private static native void setCalculateVarImportance_0(final long p0, final boolean p1);
    
    private static native void setTermCriteria_0(final long p0, final int p1, final int p2, final double p3);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getActiveVarCount() {
        return getActiveVarCount_0(this.nativeObj);
    }
    
    public boolean getCalculateVarImportance() {
        return getCalculateVarImportance_0(this.nativeObj);
    }
    
    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }
    
    public Mat getVarImportance() {
        return new Mat(getVarImportance_0(this.nativeObj));
    }
    
    public void setActiveVarCount(final int n) {
        setActiveVarCount_0(this.nativeObj, n);
    }
    
    public void setCalculateVarImportance(final boolean b) {
        setCalculateVarImportance_0(this.nativeObj, b);
    }
    
    public void setTermCriteria(final TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
}

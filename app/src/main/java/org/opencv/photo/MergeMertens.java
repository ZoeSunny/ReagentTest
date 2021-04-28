package org.opencv.photo;

import java.util.*;
import org.opencv.core.*;
import org.opencv.utils.*;

public class MergeMertens extends MergeExposures
{
    protected MergeMertens(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native float getContrastWeight_0(final long p0);
    
    private static native float getExposureWeight_0(final long p0);
    
    private static native float getSaturationWeight_0(final long p0);
    
    private static native void process_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    private static native void process_1(final long p0, final long p1, final long p2);
    
    private static native void setContrastWeight_0(final long p0, final float p1);
    
    private static native void setExposureWeight_0(final long p0, final float p1);
    
    private static native void setSaturationWeight_0(final long p0, final float p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public float getContrastWeight() {
        return getContrastWeight_0(this.nativeObj);
    }
    
    public float getExposureWeight() {
        return getExposureWeight_0(this.nativeObj);
    }
    
    public float getSaturationWeight() {
        return getSaturationWeight_0(this.nativeObj);
    }
    
    public void process(final List<Mat> list, final Mat mat) {
        process_1(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }
    
    @Override
    public void process(final List<Mat> list, final Mat mat, final Mat mat2, final Mat mat3) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public void setContrastWeight(final float n) {
        setContrastWeight_0(this.nativeObj, n);
    }
    
    public void setExposureWeight(final float n) {
        setExposureWeight_0(this.nativeObj, n);
    }
    
    public void setSaturationWeight(final float n) {
        setSaturationWeight_0(this.nativeObj, n);
    }
}

package org.opencv.photo;

import org.opencv.core.*;
import java.util.*;
import org.opencv.utils.*;

public class AlignMTB extends AlignExposures
{
    protected AlignMTB(final long n) {
        super(n);
    }
    
    private static native double[] calculateShift_0(final long p0, final long p1, final long p2);
    
    private static native void computeBitmaps_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void delete(final long p0);
    
    private static native boolean getCut_0(final long p0);
    
    private static native int getExcludeRange_0(final long p0);
    
    private static native int getMaxBits_0(final long p0);
    
    private static native void process_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    private static native void process_1(final long p0, final long p1, final long p2);
    
    private static native void setCut_0(final long p0, final boolean p1);
    
    private static native void setExcludeRange_0(final long p0, final int p1);
    
    private static native void setMaxBits_0(final long p0, final int p1);
    
    private static native void shiftMat_0(final long p0, final long p1, final long p2, final double p3, final double p4);
    
    public Point calculateShift(final Mat mat, final Mat mat2) {
        return new Point(calculateShift_0(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }
    
    public void computeBitmaps(final Mat mat, final Mat mat2, final Mat mat3) {
        computeBitmaps_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public boolean getCut() {
        return getCut_0(this.nativeObj);
    }
    
    public int getExcludeRange() {
        return getExcludeRange_0(this.nativeObj);
    }
    
    public int getMaxBits() {
        return getMaxBits_0(this.nativeObj);
    }
    
    public void process(final List<Mat> list, final List<Mat> list2) {
        process_1(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj);
    }
    
    @Override
    public void process(final List<Mat> list, final List<Mat> list2, final Mat mat, final Mat mat2) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public void setCut(final boolean b) {
        setCut_0(this.nativeObj, b);
    }
    
    public void setExcludeRange(final int n) {
        setExcludeRange_0(this.nativeObj, n);
    }
    
    public void setMaxBits(final int n) {
        setMaxBits_0(this.nativeObj, n);
    }
    
    public void shiftMat(final Mat mat, final Mat mat2, final Point point) {
        shiftMat_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, point.x, point.y);
    }
}

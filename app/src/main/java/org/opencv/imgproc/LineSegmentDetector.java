package org.opencv.imgproc;

import org.opencv.core.*;

public class LineSegmentDetector extends Algorithm
{
    protected LineSegmentDetector(final long n) {
        super(n);
    }
    
    private static native int compareSegments_0(final long p0, final double p1, final double p2, final long p3, final long p4, final long p5);
    
    private static native int compareSegments_1(final long p0, final double p1, final double p2, final long p3, final long p4);
    
    private static native void delete(final long p0);
    
    private static native void detect_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    private static native void detect_1(final long p0, final long p1, final long p2);
    
    private static native void drawSegments_0(final long p0, final long p1, final long p2);
    
    public int compareSegments(final Size size, final Mat mat, final Mat mat2) {
        return compareSegments_1(this.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj);
    }
    
    public int compareSegments(final Size size, final Mat mat, final Mat mat2, final Mat mat3) {
        return compareSegments_0(this.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public void detect(final Mat mat, final Mat mat2) {
        detect_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public void detect(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5) {
        detect_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }
    
    public void drawSegments(final Mat mat, final Mat mat2) {
        drawSegments_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}

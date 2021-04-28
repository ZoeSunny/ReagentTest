package org.opencv.objdetect;

import org.opencv.core.*;

public class CascadeClassifier
{
    protected final long nativeObj;
    
    public CascadeClassifier() {
        this.nativeObj = CascadeClassifier_1();
    }
    
    protected CascadeClassifier(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    public CascadeClassifier(final String s) {
        this.nativeObj = CascadeClassifier_0(s);
    }
    
    private static native long CascadeClassifier_0(final String p0);
    
    private static native long CascadeClassifier_1();
    
    public static boolean convert(final String s, final String s2) {
        return convert_0(s, s2);
    }
    
    private static native boolean convert_0(final String p0, final String p1);
    
    private static native void delete(final long p0);
    
    private static native void detectMultiScale2_0(final long p0, final long p1, final long p2, final long p3, final double p4, final int p5, final int p6, final double p7, final double p8, final double p9, final double p10);
    
    private static native void detectMultiScale2_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native void detectMultiScale3_0(final long p0, final long p1, final long p2, final long p3, final long p4, final double p5, final int p6, final int p7, final double p8, final double p9, final double p10, final double p11, final boolean p12);
    
    private static native void detectMultiScale3_1(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    private static native void detectMultiScale_0(final long p0, final long p1, final long p2, final double p3, final int p4, final int p5, final double p6, final double p7, final double p8, final double p9);
    
    private static native void detectMultiScale_1(final long p0, final long p1, final long p2);
    
    private static native boolean empty_0(final long p0);
    
    private static native int getFeatureType_0(final long p0);
    
    private static native double[] getOriginalWindowSize_0(final long p0);
    
    private static native boolean isOldFormatCascade_0(final long p0);
    
    private static native boolean load_0(final long p0, final String p1);
    
    public void detectMultiScale(final Mat mat, final MatOfRect matOfRect) {
        detectMultiScale_1(this.nativeObj, mat.nativeObj, matOfRect.nativeObj);
    }
    
    public void detectMultiScale(final Mat mat, final MatOfRect matOfRect, final double n, final int n2, final int n3, final Size size, final Size size2) {
        detectMultiScale_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, n, n2, n3, size.width, size.height, size2.width, size2.height);
    }
    
    public void detectMultiScale2(final Mat mat, final MatOfRect matOfRect, final MatOfInt matOfInt) {
        detectMultiScale2_1(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj);
    }
    
    public void detectMultiScale2(final Mat mat, final MatOfRect matOfRect, final MatOfInt matOfInt, final double n, final int n2, final int n3, final Size size, final Size size2) {
        detectMultiScale2_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, n, n2, n3, size.width, size.height, size2.width, size2.height);
    }
    
    public void detectMultiScale3(final Mat mat, final MatOfRect matOfRect, final MatOfInt matOfInt, final MatOfDouble matOfDouble) {
        detectMultiScale3_1(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj);
    }
    
    public void detectMultiScale3(final Mat mat, final MatOfRect matOfRect, final MatOfInt matOfInt, final MatOfDouble matOfDouble, final double n, final int n2, final int n3, final Size size, final Size size2, final boolean b) {
        detectMultiScale3_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj, n, n2, n3, size.width, size.height, size2.width, size2.height, b);
    }
    
    public boolean empty() {
        return empty_0(this.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getFeatureType() {
        return getFeatureType_0(this.nativeObj);
    }
    
    public Size getOriginalWindowSize() {
        return new Size(getOriginalWindowSize_0(this.nativeObj));
    }
    
    public boolean isOldFormatCascade() {
        return isOldFormatCascade_0(this.nativeObj);
    }
    
    public boolean load(final String s) {
        return load_0(this.nativeObj, s);
    }
}

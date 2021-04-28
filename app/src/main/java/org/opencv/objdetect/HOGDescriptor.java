package org.opencv.objdetect;

import org.opencv.core.*;

public class HOGDescriptor
{
    public static final int DEFAULT_NLEVELS = 64;
    public static final int L2Hys = 0;
    protected final long nativeObj;
    
    public HOGDescriptor() {
        this.nativeObj = HOGDescriptor_3();
    }
    
    protected HOGDescriptor(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    public HOGDescriptor(final String s) {
        this.nativeObj = HOGDescriptor_2(s);
    }
    
    public HOGDescriptor(final Size size, final Size size2, final Size size3, final Size size4, final int n) {
        this.nativeObj = HOGDescriptor_1(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, n);
    }
    
    public HOGDescriptor(final Size size, final Size size2, final Size size3, final Size size4, final int n, final int n2, final double n3, final int n4, final double n5, final boolean b, final int n6, final boolean b2) {
        this.nativeObj = HOGDescriptor_0(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, n, n2, n3, n4, n5, b, n6, b2);
    }
    
    private static native long HOGDescriptor_0(final double p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final int p8, final int p9, final double p10, final int p11, final double p12, final boolean p13, final int p14, final boolean p15);
    
    private static native long HOGDescriptor_1(final double p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final int p8);
    
    private static native long HOGDescriptor_2(final String p0);
    
    private static native long HOGDescriptor_3();
    
    private static native boolean checkDetectorSize_0(final long p0);
    
    private static native void computeGradient_0(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final double p6, final double p7);
    
    private static native void computeGradient_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native void compute_0(final long p0, final long p1, final long p2, final double p3, final double p4, final double p5, final double p6, final long p7);
    
    private static native void compute_1(final long p0, final long p1, final long p2);
    
    private static native void delete(final long p0);
    
    private static native void detectMultiScale_0(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9, final double p10, final boolean p11);
    
    private static native void detectMultiScale_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native void detect_0(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final double p6, final double p7, final double p8, final long p9);
    
    private static native void detect_1(final long p0, final long p1, final long p2, final long p3);
    
    public static MatOfFloat getDaimlerPeopleDetector() {
        return MatOfFloat.fromNativeAddr(getDaimlerPeopleDetector_0());
    }
    
    private static native long getDaimlerPeopleDetector_0();
    
    public static MatOfFloat getDefaultPeopleDetector() {
        return MatOfFloat.fromNativeAddr(getDefaultPeopleDetector_0());
    }
    
    private static native long getDefaultPeopleDetector_0();
    
    private static native long getDescriptorSize_0(final long p0);
    
    private static native double getWinSigma_0(final long p0);
    
    private static native double get_L2HysThreshold_0(final long p0);
    
    private static native double[] get_blockSize_0(final long p0);
    
    private static native double[] get_blockStride_0(final long p0);
    
    private static native double[] get_cellSize_0(final long p0);
    
    private static native int get_derivAperture_0(final long p0);
    
    private static native boolean get_gammaCorrection_0(final long p0);
    
    private static native int get_histogramNormType_0(final long p0);
    
    private static native int get_nbins_0(final long p0);
    
    private static native int get_nlevels_0(final long p0);
    
    private static native boolean get_signedGradient_0(final long p0);
    
    private static native long get_svmDetector_0(final long p0);
    
    private static native double get_winSigma_0(final long p0);
    
    private static native double[] get_winSize_0(final long p0);
    
    private static native boolean load_0(final long p0, final String p1, final String p2);
    
    private static native boolean load_1(final long p0, final String p1);
    
    private static native void save_0(final long p0, final String p1, final String p2);
    
    private static native void save_1(final long p0, final String p1);
    
    private static native void setSVMDetector_0(final long p0, final long p1);
    
    public boolean checkDetectorSize() {
        return checkDetectorSize_0(this.nativeObj);
    }
    
    public void compute(final Mat mat, final MatOfFloat matOfFloat) {
        compute_1(this.nativeObj, mat.nativeObj, matOfFloat.nativeObj);
    }
    
    public void compute(final Mat mat, final MatOfFloat matOfFloat, final Size size, final Size size2, final MatOfPoint matOfPoint) {
        compute_0(this.nativeObj, mat.nativeObj, matOfFloat.nativeObj, size.width, size.height, size2.width, size2.height, matOfPoint.nativeObj);
    }
    
    public void computeGradient(final Mat mat, final Mat mat2, final Mat mat3) {
        computeGradient_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public void computeGradient(final Mat mat, final Mat mat2, final Mat mat3, final Size size, final Size size2) {
        computeGradient_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, size2.width, size2.height);
    }
    
    public void detect(final Mat mat, final MatOfPoint matOfPoint, final MatOfDouble matOfDouble) {
        detect_1(this.nativeObj, mat.nativeObj, matOfPoint.nativeObj, matOfDouble.nativeObj);
    }
    
    public void detect(final Mat mat, final MatOfPoint matOfPoint, final MatOfDouble matOfDouble, final double n, final Size size, final Size size2, final MatOfPoint matOfPoint2) {
        detect_0(this.nativeObj, mat.nativeObj, matOfPoint.nativeObj, matOfDouble.nativeObj, n, size.width, size.height, size2.width, size2.height, matOfPoint2.nativeObj);
    }
    
    public void detectMultiScale(final Mat mat, final MatOfRect matOfRect, final MatOfDouble matOfDouble) {
        detectMultiScale_1(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj);
    }
    
    public void detectMultiScale(final Mat mat, final MatOfRect matOfRect, final MatOfDouble matOfDouble, final double n, final Size size, final Size size2, final double n2, final double n3, final boolean b) {
        detectMultiScale_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj, n, size.width, size.height, size2.width, size2.height, n2, n3, b);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public long getDescriptorSize() {
        return getDescriptorSize_0(this.nativeObj);
    }
    
    public double getWinSigma() {
        return getWinSigma_0(this.nativeObj);
    }
    
    public double get_L2HysThreshold() {
        return get_L2HysThreshold_0(this.nativeObj);
    }
    
    public Size get_blockSize() {
        return new Size(get_blockSize_0(this.nativeObj));
    }
    
    public Size get_blockStride() {
        return new Size(get_blockStride_0(this.nativeObj));
    }
    
    public Size get_cellSize() {
        return new Size(get_cellSize_0(this.nativeObj));
    }
    
    public int get_derivAperture() {
        return get_derivAperture_0(this.nativeObj);
    }
    
    public boolean get_gammaCorrection() {
        return get_gammaCorrection_0(this.nativeObj);
    }
    
    public int get_histogramNormType() {
        return get_histogramNormType_0(this.nativeObj);
    }
    
    public int get_nbins() {
        return get_nbins_0(this.nativeObj);
    }
    
    public int get_nlevels() {
        return get_nlevels_0(this.nativeObj);
    }
    
    public boolean get_signedGradient() {
        return get_signedGradient_0(this.nativeObj);
    }
    
    public MatOfFloat get_svmDetector() {
        return MatOfFloat.fromNativeAddr(get_svmDetector_0(this.nativeObj));
    }
    
    public double get_winSigma() {
        return get_winSigma_0(this.nativeObj);
    }
    
    public Size get_winSize() {
        return new Size(get_winSize_0(this.nativeObj));
    }
    
    public boolean load(final String s) {
        return load_1(this.nativeObj, s);
    }
    
    public boolean load(final String s, final String s2) {
        return load_0(this.nativeObj, s, s2);
    }
    
    public void save(final String s) {
        save_1(this.nativeObj, s);
    }
    
    public void save(final String s, final String s2) {
        save_0(this.nativeObj, s, s2);
    }
    
    public void setSVMDetector(final Mat mat) {
        setSVMDetector_0(this.nativeObj, mat.nativeObj);
    }
}

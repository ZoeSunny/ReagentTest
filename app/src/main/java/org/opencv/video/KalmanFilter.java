package org.opencv.video;

import org.opencv.core.*;

public class KalmanFilter
{
    protected final long nativeObj;
    
    public KalmanFilter() {
        this.nativeObj = KalmanFilter_2();
    }
    
    public KalmanFilter(final int n, final int n2) {
        this.nativeObj = KalmanFilter_1(n, n2);
    }
    
    public KalmanFilter(final int n, final int n2, final int n3, final int n4) {
        this.nativeObj = KalmanFilter_0(n, n2, n3, n4);
    }
    
    protected KalmanFilter(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    private static native long KalmanFilter_0(final int p0, final int p1, final int p2, final int p3);
    
    private static native long KalmanFilter_1(final int p0, final int p1);
    
    private static native long KalmanFilter_2();
    
    private static native long correct_0(final long p0, final long p1);
    
    private static native void delete(final long p0);
    
    private static native long get_controlMatrix_0(final long p0);
    
    private static native long get_errorCovPost_0(final long p0);
    
    private static native long get_errorCovPre_0(final long p0);
    
    private static native long get_gain_0(final long p0);
    
    private static native long get_measurementMatrix_0(final long p0);
    
    private static native long get_measurementNoiseCov_0(final long p0);
    
    private static native long get_processNoiseCov_0(final long p0);
    
    private static native long get_statePost_0(final long p0);
    
    private static native long get_statePre_0(final long p0);
    
    private static native long get_transitionMatrix_0(final long p0);
    
    private static native long predict_0(final long p0, final long p1);
    
    private static native long predict_1(final long p0);
    
    private static native void set_controlMatrix_0(final long p0, final long p1);
    
    private static native void set_errorCovPost_0(final long p0, final long p1);
    
    private static native void set_errorCovPre_0(final long p0, final long p1);
    
    private static native void set_gain_0(final long p0, final long p1);
    
    private static native void set_measurementMatrix_0(final long p0, final long p1);
    
    private static native void set_measurementNoiseCov_0(final long p0, final long p1);
    
    private static native void set_processNoiseCov_0(final long p0, final long p1);
    
    private static native void set_statePost_0(final long p0, final long p1);
    
    private static native void set_statePre_0(final long p0, final long p1);
    
    private static native void set_transitionMatrix_0(final long p0, final long p1);
    
    public Mat correct(final Mat mat) {
        return new Mat(correct_0(this.nativeObj, mat.nativeObj));
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public Mat get_controlMatrix() {
        return new Mat(get_controlMatrix_0(this.nativeObj));
    }
    
    public Mat get_errorCovPost() {
        return new Mat(get_errorCovPost_0(this.nativeObj));
    }
    
    public Mat get_errorCovPre() {
        return new Mat(get_errorCovPre_0(this.nativeObj));
    }
    
    public Mat get_gain() {
        return new Mat(get_gain_0(this.nativeObj));
    }
    
    public Mat get_measurementMatrix() {
        return new Mat(get_measurementMatrix_0(this.nativeObj));
    }
    
    public Mat get_measurementNoiseCov() {
        return new Mat(get_measurementNoiseCov_0(this.nativeObj));
    }
    
    public Mat get_processNoiseCov() {
        return new Mat(get_processNoiseCov_0(this.nativeObj));
    }
    
    public Mat get_statePost() {
        return new Mat(get_statePost_0(this.nativeObj));
    }
    
    public Mat get_statePre() {
        return new Mat(get_statePre_0(this.nativeObj));
    }
    
    public Mat get_transitionMatrix() {
        return new Mat(get_transitionMatrix_0(this.nativeObj));
    }
    
    public Mat predict() {
        return new Mat(predict_1(this.nativeObj));
    }
    
    public Mat predict(final Mat mat) {
        return new Mat(predict_0(this.nativeObj, mat.nativeObj));
    }
    
    public void set_controlMatrix(final Mat mat) {
        set_controlMatrix_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_errorCovPost(final Mat mat) {
        set_errorCovPost_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_errorCovPre(final Mat mat) {
        set_errorCovPre_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_gain(final Mat mat) {
        set_gain_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_measurementMatrix(final Mat mat) {
        set_measurementMatrix_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_measurementNoiseCov(final Mat mat) {
        set_measurementNoiseCov_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_processNoiseCov(final Mat mat) {
        set_processNoiseCov_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_statePost(final Mat mat) {
        set_statePost_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_statePre(final Mat mat) {
        set_statePre_0(this.nativeObj, mat.nativeObj);
    }
    
    public void set_transitionMatrix(final Mat mat) {
        set_transitionMatrix_0(this.nativeObj, mat.nativeObj);
    }
}

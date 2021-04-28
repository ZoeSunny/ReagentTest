package org.opencv.videoio;

import org.opencv.core.*;

public class VideoCapture
{
    protected final long nativeObj;
    
    public VideoCapture() {
        this.nativeObj = VideoCapture_3();
    }
    
    public VideoCapture(final int n) {
        this.nativeObj = VideoCapture_2(n);
    }
    
    protected VideoCapture(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    public VideoCapture(final String s) {
        this.nativeObj = VideoCapture_1(s);
    }
    
    public VideoCapture(final String s, final int n) {
        this.nativeObj = VideoCapture_0(s, n);
    }
    
    private static native long VideoCapture_0(final String p0, final int p1);
    
    private static native long VideoCapture_1(final String p0);
    
    private static native long VideoCapture_2(final int p0);
    
    private static native long VideoCapture_3();
    
    private static native void delete(final long p0);
    
    private static native double get_0(final long p0, final int p1);
    
    private static native boolean grab_0(final long p0);
    
    private static native boolean isOpened_0(final long p0);
    
    private static native boolean open_0(final long p0, final String p1, final int p2);
    
    private static native boolean open_1(final long p0, final String p1);
    
    private static native boolean open_2(final long p0, final int p1);
    
    private static native boolean read_0(final long p0, final long p1);
    
    private static native void release_0(final long p0);
    
    private static native boolean retrieve_0(final long p0, final long p1, final int p2);
    
    private static native boolean retrieve_1(final long p0, final long p1);
    
    private static native boolean set_0(final long p0, final int p1, final double p2);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public double get(final int n) {
        return get_0(this.nativeObj, n);
    }
    
    public boolean grab() {
        return grab_0(this.nativeObj);
    }
    
    public boolean isOpened() {
        return isOpened_0(this.nativeObj);
    }
    
    public boolean open(final int n) {
        return open_2(this.nativeObj, n);
    }
    
    public boolean open(final String s) {
        return open_1(this.nativeObj, s);
    }
    
    public boolean open(final String s, final int n) {
        return open_0(this.nativeObj, s, n);
    }
    
    public boolean read(final Mat mat) {
        return read_0(this.nativeObj, mat.nativeObj);
    }
    
    public void release() {
        release_0(this.nativeObj);
    }
    
    public boolean retrieve(final Mat mat) {
        return retrieve_1(this.nativeObj, mat.nativeObj);
    }
    
    public boolean retrieve(final Mat mat, final int n) {
        return retrieve_0(this.nativeObj, mat.nativeObj, n);
    }
    
    public boolean set(final int n, final double n2) {
        return set_0(this.nativeObj, n, n2);
    }
}

package org.opencv.videoio;

import org.opencv.core.*;

public class VideoWriter
{
    protected final long nativeObj;
    
    public VideoWriter() {
        this.nativeObj = VideoWriter_2();
    }
    
    protected VideoWriter(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    public VideoWriter(final String s, final int n, final double n2, final Size size) {
        this.nativeObj = VideoWriter_1(s, n, n2, size.width, size.height);
    }
    
    public VideoWriter(final String s, final int n, final double n2, final Size size, final boolean b) {
        this.nativeObj = VideoWriter_0(s, n, n2, size.width, size.height, b);
    }
    
    private static native long VideoWriter_0(final String p0, final int p1, final double p2, final double p3, final double p4, final boolean p5);
    
    private static native long VideoWriter_1(final String p0, final int p1, final double p2, final double p3, final double p4);
    
    private static native long VideoWriter_2();
    
    private static native void delete(final long p0);
    
    public static int fourcc(final char c, final char c2, final char c3, final char c4) {
        return fourcc_0(c, c2, c3, c4);
    }
    
    private static native int fourcc_0(final char p0, final char p1, final char p2, final char p3);
    
    private static native double get_0(final long p0, final int p1);
    
    private static native boolean isOpened_0(final long p0);
    
    private static native boolean open_0(final long p0, final String p1, final int p2, final double p3, final double p4, final double p5, final boolean p6);
    
    private static native boolean open_1(final long p0, final String p1, final int p2, final double p3, final double p4, final double p5);
    
    private static native void release_0(final long p0);
    
    private static native boolean set_0(final long p0, final int p1, final double p2);
    
    private static native void write_0(final long p0, final long p1);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public double get(final int n) {
        return get_0(this.nativeObj, n);
    }
    
    public boolean isOpened() {
        return isOpened_0(this.nativeObj);
    }
    
    public boolean open(final String s, final int n, final double n2, final Size size) {
        return open_1(this.nativeObj, s, n, n2, size.width, size.height);
    }
    
    public boolean open(final String s, final int n, final double n2, final Size size, final boolean b) {
        return open_0(this.nativeObj, s, n, n2, size.width, size.height, b);
    }
    
    public void release() {
        release_0(this.nativeObj);
    }
    
    public boolean set(final int n, final double n2) {
        return set_0(this.nativeObj, n, n2);
    }
    
    public void write(final Mat mat) {
        write_0(this.nativeObj, mat.nativeObj);
    }
}

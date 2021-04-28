package org.opencv.features2d;

import org.opencv.utils.*;
import java.util.*;
import org.opencv.core.*;

public class DescriptorMatcher
{
    public static final int BRUTEFORCE = 2;
    public static final int BRUTEFORCE_HAMMING = 4;
    public static final int BRUTEFORCE_HAMMINGLUT = 5;
    public static final int BRUTEFORCE_L1 = 3;
    public static final int BRUTEFORCE_SL2 = 6;
    public static final int FLANNBASED = 1;
    protected final long nativeObj;
    
    protected DescriptorMatcher(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    private static native void add_0(final long p0, final long p1);
    
    private static native void clear_0(final long p0);
    
    private static native long clone_0(final long p0, final boolean p1);
    
    private static native long clone_1(final long p0);
    
    public static DescriptorMatcher create(final int n) {
        return new DescriptorMatcher(create_0(n));
    }
    
    private static native long create_0(final int p0);
    
    private static native void delete(final long p0);
    
    private static native boolean empty_0(final long p0);
    
    private static native long getTrainDescriptors_0(final long p0);
    
    private static native boolean isMaskSupported_0(final long p0);
    
    private static native void knnMatch_0(final long p0, final long p1, final long p2, final long p3, final int p4, final long p5, final boolean p6);
    
    private static native void knnMatch_1(final long p0, final long p1, final long p2, final long p3, final int p4);
    
    private static native void knnMatch_2(final long p0, final long p1, final long p2, final int p3, final long p4, final boolean p5);
    
    private static native void knnMatch_3(final long p0, final long p1, final long p2, final int p3);
    
    private static native void match_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    private static native void match_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native void match_2(final long p0, final long p1, final long p2, final long p3);
    
    private static native void match_3(final long p0, final long p1, final long p2);
    
    private static native void radiusMatch_0(final long p0, final long p1, final long p2, final long p3, final float p4, final long p5, final boolean p6);
    
    private static native void radiusMatch_1(final long p0, final long p1, final long p2, final long p3, final float p4);
    
    private static native void radiusMatch_2(final long p0, final long p1, final long p2, final float p3, final long p4, final boolean p5);
    
    private static native void radiusMatch_3(final long p0, final long p1, final long p2, final float p3);
    
    private static native void read_0(final long p0, final String p1);
    
    private static native void train_0(final long p0);
    
    private static native void write_0(final long p0, final String p1);
    
    public void add(final List<Mat> list) {
        add_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj);
    }
    
    public void clear() {
        clear_0(this.nativeObj);
    }
    
    public DescriptorMatcher clone() {
        return new DescriptorMatcher(clone_1(this.nativeObj));
    }
    
    public DescriptorMatcher clone(final boolean b) {
        return new DescriptorMatcher(clone_0(this.nativeObj, b));
    }
    
    public boolean empty() {
        return empty_0(this.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public List<Mat> getTrainDescriptors() {
        final ArrayList<Mat> list = new ArrayList<Mat>();
        Converters.Mat_to_vector_Mat(new Mat(getTrainDescriptors_0(this.nativeObj)), list);
        return list;
    }
    
    public boolean isMaskSupported() {
        return isMaskSupported_0(this.nativeObj);
    }
    
    public void knnMatch(final Mat mat, final List<MatOfDMatch> list, final int n) {
        final Mat mat2 = new Mat();
        knnMatch_3(this.nativeObj, mat.nativeObj, mat2.nativeObj, n);
        Converters.Mat_to_vector_vector_DMatch(mat2, list);
        mat2.release();
    }
    
    public void knnMatch(final Mat mat, final List<MatOfDMatch> list, final int n, final List<Mat> list2, final boolean b) {
        final Mat mat2 = new Mat();
        knnMatch_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, n, Converters.vector_Mat_to_Mat(list2).nativeObj, b);
        Converters.Mat_to_vector_vector_DMatch(mat2, list);
        mat2.release();
    }
    
    public void knnMatch(final Mat mat, final Mat mat2, final List<MatOfDMatch> list, final int n) {
        final Mat mat3 = new Mat();
        knnMatch_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
        Converters.Mat_to_vector_vector_DMatch(mat3, list);
        mat3.release();
    }
    
    public void knnMatch(final Mat mat, final Mat mat2, final List<MatOfDMatch> list, final int n, final Mat mat3, final boolean b) {
        final Mat mat4 = new Mat();
        knnMatch_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat4.nativeObj, n, mat3.nativeObj, b);
        Converters.Mat_to_vector_vector_DMatch(mat4, list);
        mat4.release();
    }
    
    public void match(final Mat mat, final Mat mat2, final MatOfDMatch matOfDMatch) {
        match_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, matOfDMatch.nativeObj);
    }
    
    public void match(final Mat mat, final Mat mat2, final MatOfDMatch matOfDMatch, final Mat mat3) {
        match_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, matOfDMatch.nativeObj, mat3.nativeObj);
    }
    
    public void match(final Mat mat, final MatOfDMatch matOfDMatch) {
        match_3(this.nativeObj, mat.nativeObj, matOfDMatch.nativeObj);
    }
    
    public void match(final Mat mat, final MatOfDMatch matOfDMatch, final List<Mat> list) {
        match_2(this.nativeObj, mat.nativeObj, matOfDMatch.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj);
    }
    
    public void radiusMatch(final Mat mat, final List<MatOfDMatch> list, final float n) {
        final Mat mat2 = new Mat();
        radiusMatch_3(this.nativeObj, mat.nativeObj, mat2.nativeObj, n);
        Converters.Mat_to_vector_vector_DMatch(mat2, list);
        mat2.release();
    }
    
    public void radiusMatch(final Mat mat, final List<MatOfDMatch> list, final float n, final List<Mat> list2, final boolean b) {
        final Mat mat2 = new Mat();
        radiusMatch_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, n, Converters.vector_Mat_to_Mat(list2).nativeObj, b);
        Converters.Mat_to_vector_vector_DMatch(mat2, list);
        mat2.release();
    }
    
    public void radiusMatch(final Mat mat, final Mat mat2, final List<MatOfDMatch> list, final float n) {
        final Mat mat3 = new Mat();
        radiusMatch_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
        Converters.Mat_to_vector_vector_DMatch(mat3, list);
        mat3.release();
    }
    
    public void radiusMatch(final Mat mat, final Mat mat2, final List<MatOfDMatch> list, final float n, final Mat mat3, final boolean b) {
        final Mat mat4 = new Mat();
        radiusMatch_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat4.nativeObj, n, mat3.nativeObj, b);
        Converters.Mat_to_vector_vector_DMatch(mat4, list);
        mat4.release();
    }
    
    public void read(final String s) {
        read_0(this.nativeObj, s);
    }
    
    public void train() {
        train_0(this.nativeObj);
    }
    
    public void write(final String s) {
        write_0(this.nativeObj, s);
    }
}

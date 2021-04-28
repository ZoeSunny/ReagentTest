package org.opencv.features2d;

import org.opencv.core.*;
import org.opencv.utils.*;
import java.util.*;

public class DescriptorExtractor
{
    public static final int AKAZE = 7;
    public static final int BRIEF = 4;
    public static final int BRISK = 5;
    public static final int FREAK = 6;
    private static final int OPPONENTEXTRACTOR = 1000;
    public static final int OPPONENT_AKAZE = 1007;
    public static final int OPPONENT_BRIEF = 1004;
    public static final int OPPONENT_BRISK = 1005;
    public static final int OPPONENT_FREAK = 1006;
    public static final int OPPONENT_ORB = 1003;
    public static final int OPPONENT_SIFT = 1001;
    public static final int OPPONENT_SURF = 1002;
    public static final int ORB = 3;
    public static final int SIFT = 1;
    public static final int SURF = 2;
    protected final long nativeObj;
    
    protected DescriptorExtractor(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    private static native void compute_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void compute_1(final long p0, final long p1, final long p2, final long p3);
    
    public static DescriptorExtractor create(final int n) {
        return new DescriptorExtractor(create_0(n));
    }
    
    private static native long create_0(final int p0);
    
    private static native void delete(final long p0);
    
    private static native int descriptorSize_0(final long p0);
    
    private static native int descriptorType_0(final long p0);
    
    private static native boolean empty_0(final long p0);
    
    private static native void read_0(final long p0, final String p1);
    
    private static native void write_0(final long p0, final String p1);
    
    public void compute(final List<Mat> list, final List<MatOfKeyPoint> list2, final List<Mat> list3) {
        final Mat vector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        int size;
        if (list2 != null) {
            size = list2.size();
        }
        else {
            size = 0;
        }
        final Mat vector_vector_KeyPoint_to_Mat = Converters.vector_vector_KeyPoint_to_Mat(list2, new ArrayList<Mat>(size));
        final Mat mat = new Mat();
        compute_1(this.nativeObj, vector_Mat_to_Mat.nativeObj, vector_vector_KeyPoint_to_Mat.nativeObj, mat.nativeObj);
        Converters.Mat_to_vector_vector_KeyPoint(vector_vector_KeyPoint_to_Mat, list2);
        vector_vector_KeyPoint_to_Mat.release();
        Converters.Mat_to_vector_Mat(mat, list3);
        mat.release();
    }
    
    public void compute(final Mat mat, final MatOfKeyPoint matOfKeyPoint, final Mat mat2) {
        compute_0(this.nativeObj, mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj);
    }
    
    public int descriptorSize() {
        return descriptorSize_0(this.nativeObj);
    }
    
    public int descriptorType() {
        return descriptorType_0(this.nativeObj);
    }
    
    public boolean empty() {
        return empty_0(this.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public void read(final String s) {
        read_0(this.nativeObj, s);
    }
    
    public void write(final String s) {
        write_0(this.nativeObj, s);
    }
}

package org.opencv.features2d;

import org.opencv.core.*;
import java.util.*;
import org.opencv.utils.*;

public class Features2d
{
    public static final int DRAW_OVER_OUTIMG = 1;
    public static final int DRAW_RICH_KEYPOINTS = 4;
    public static final int NOT_DRAW_SINGLE_POINTS = 2;
    
    public static void drawKeypoints(final Mat mat, final MatOfKeyPoint matOfKeyPoint, final Mat mat2) {
        drawKeypoints_1(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj);
    }
    
    public static void drawKeypoints(final Mat mat, final MatOfKeyPoint matOfKeyPoint, final Mat mat2, final Scalar scalar, final int n) {
        drawKeypoints_0(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n);
    }
    
    private static native void drawKeypoints_0(final long p0, final long p1, final long p2, final double p3, final double p4, final double p5, final double p6, final int p7);
    
    private static native void drawKeypoints_1(final long p0, final long p1, final long p2);
    
    public static void drawMatches(final Mat mat, final MatOfKeyPoint matOfKeyPoint, final Mat mat2, final MatOfKeyPoint matOfKeyPoint2, final MatOfDMatch matOfDMatch, final Mat mat3) {
        drawMatches_1(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj, matOfKeyPoint2.nativeObj, matOfDMatch.nativeObj, mat3.nativeObj);
    }
    
    public static void drawMatches(final Mat mat, final MatOfKeyPoint matOfKeyPoint, final Mat mat2, final MatOfKeyPoint matOfKeyPoint2, final MatOfDMatch matOfDMatch, final Mat mat3, final Scalar scalar, final Scalar scalar2, final MatOfByte matOfByte, final int n) {
        drawMatches_0(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj, matOfKeyPoint2.nativeObj, matOfDMatch.nativeObj, mat3.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], matOfByte.nativeObj, n);
    }
    
    public static void drawMatches2(final Mat mat, final MatOfKeyPoint matOfKeyPoint, final Mat mat2, final MatOfKeyPoint matOfKeyPoint2, final List<MatOfDMatch> list, final Mat mat3) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        drawMatches2_1(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj, matOfKeyPoint2.nativeObj, Converters.vector_vector_DMatch_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, mat3.nativeObj);
    }
    
    public static void drawMatches2(final Mat mat, final MatOfKeyPoint matOfKeyPoint, final Mat mat2, final MatOfKeyPoint matOfKeyPoint2, final List<MatOfDMatch> list, final Mat mat3, final Scalar scalar, final Scalar scalar2, final List<MatOfByte> list2, final int n) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        final Mat vector_vector_DMatch_to_Mat = Converters.vector_vector_DMatch_to_Mat(list, new ArrayList<Mat>(size));
        int size2;
        if (list2 != null) {
            size2 = list2.size();
        }
        else {
            size2 = 0;
        }
        drawMatches2_0(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj, matOfKeyPoint2.nativeObj, vector_vector_DMatch_to_Mat.nativeObj, mat3.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], Converters.vector_vector_char_to_Mat(list2, new ArrayList<Mat>(size2)).nativeObj, n);
    }
    
    private static native void drawMatches2_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final double p6, final double p7, final double p8, final double p9, final double p10, final double p11, final double p12, final double p13, final long p14, final int p15);
    
    private static native void drawMatches2_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    private static native void drawMatches_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final double p6, final double p7, final double p8, final double p9, final double p10, final double p11, final double p12, final double p13, final long p14, final int p15);
    
    private static native void drawMatches_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
}

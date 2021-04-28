package org.opencv.video;

import java.util.*;
import org.opencv.utils.*;
import org.opencv.core.*;

public class Video
{
    private static final int CV_LKFLOW_GET_MIN_EIGENVALS = 8;
    private static final int CV_LKFLOW_INITIAL_GUESSES = 4;
    public static final int MOTION_AFFINE = 2;
    public static final int MOTION_EUCLIDEAN = 1;
    public static final int MOTION_HOMOGRAPHY = 3;
    public static final int MOTION_TRANSLATION = 0;
    public static final int OPTFLOW_FARNEBACK_GAUSSIAN = 256;
    public static final int OPTFLOW_LK_GET_MIN_EIGENVALS = 8;
    public static final int OPTFLOW_USE_INITIAL_FLOW = 4;
    
    public static RotatedRect CamShift(final Mat mat, final Rect rect, final TermCriteria termCriteria) {
        final double[] array = new double[4];
        final RotatedRect rotatedRect = new RotatedRect(CamShift_0(mat.nativeObj, rect.x, rect.y, rect.width, rect.height, array, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon));
        if (rect != null) {
            rect.x = (int)array[0];
            rect.y = (int)array[1];
            rect.width = (int)array[2];
            rect.height = (int)array[3];
        }
        return rotatedRect;
    }
    
    private static native double[] CamShift_0(final long p0, final int p1, final int p2, final int p3, final int p4, final double[] p5, final int p6, final int p7, final double p8);
    
    public static int buildOpticalFlowPyramid(final Mat mat, final List<Mat> list, final Size size, int buildOpticalFlowPyramid_1) {
        final Mat mat2 = new Mat();
        buildOpticalFlowPyramid_1 = buildOpticalFlowPyramid_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, buildOpticalFlowPyramid_1);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
        return buildOpticalFlowPyramid_1;
    }
    
    public static int buildOpticalFlowPyramid(final Mat mat, final List<Mat> list, final Size size, int buildOpticalFlowPyramid_0, final boolean b, final int n, final int n2, final boolean b2) {
        final Mat mat2 = new Mat();
        buildOpticalFlowPyramid_0 = buildOpticalFlowPyramid_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, buildOpticalFlowPyramid_0, b, n, n2, b2);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
        return buildOpticalFlowPyramid_0;
    }
    
    private static native int buildOpticalFlowPyramid_0(final long p0, final long p1, final double p2, final double p3, final int p4, final boolean p5, final int p6, final int p7, final boolean p8);
    
    private static native int buildOpticalFlowPyramid_1(final long p0, final long p1, final double p2, final double p3, final int p4);
    
    public static void calcOpticalFlowFarneback(final Mat mat, final Mat mat2, final Mat mat3, final double n, final int n2, final int n3, final int n4, final int n5, final double n6, final int n7) {
        calcOpticalFlowFarneback_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2, n3, n4, n5, n6, n7);
    }
    
    private static native void calcOpticalFlowFarneback_0(final long p0, final long p1, final long p2, final double p3, final int p4, final int p5, final int p6, final int p7, final double p8, final int p9);
    
    public static void calcOpticalFlowPyrLK(final Mat mat, final Mat mat2, final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final MatOfByte matOfByte, final MatOfFloat matOfFloat) {
        calcOpticalFlowPyrLK_2(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj);
    }
    
    public static void calcOpticalFlowPyrLK(final Mat mat, final Mat mat2, final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final MatOfByte matOfByte, final MatOfFloat matOfFloat, final Size size, final int n) {
        calcOpticalFlowPyrLK_1(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj, size.width, size.height, n);
    }
    
    public static void calcOpticalFlowPyrLK(final Mat mat, final Mat mat2, final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final MatOfByte matOfByte, final MatOfFloat matOfFloat, final Size size, final int n, final TermCriteria termCriteria, final int n2, final double n3) {
        calcOpticalFlowPyrLK_0(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj, size.width, size.height, n, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, n2, n3);
    }
    
    private static native void calcOpticalFlowPyrLK_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final double p6, final double p7, final int p8, final int p9, final int p10, final double p11, final int p12, final double p13);
    
    private static native void calcOpticalFlowPyrLK_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final double p6, final double p7, final int p8);
    
    private static native void calcOpticalFlowPyrLK_2(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    public static BackgroundSubtractorKNN createBackgroundSubtractorKNN() {
        return new BackgroundSubtractorKNN(createBackgroundSubtractorKNN_1());
    }
    
    public static BackgroundSubtractorKNN createBackgroundSubtractorKNN(final int n, final double n2, final boolean b) {
        return new BackgroundSubtractorKNN(createBackgroundSubtractorKNN_0(n, n2, b));
    }
    
    private static native long createBackgroundSubtractorKNN_0(final int p0, final double p1, final boolean p2);
    
    private static native long createBackgroundSubtractorKNN_1();
    
    public static BackgroundSubtractorMOG2 createBackgroundSubtractorMOG2() {
        return new BackgroundSubtractorMOG2(createBackgroundSubtractorMOG2_1());
    }
    
    public static BackgroundSubtractorMOG2 createBackgroundSubtractorMOG2(final int n, final double n2, final boolean b) {
        return new BackgroundSubtractorMOG2(createBackgroundSubtractorMOG2_0(n, n2, b));
    }
    
    private static native long createBackgroundSubtractorMOG2_0(final int p0, final double p1, final boolean p2);
    
    private static native long createBackgroundSubtractorMOG2_1();
    
    public static DualTVL1OpticalFlow createOptFlow_DualTVL1() {
        return new DualTVL1OpticalFlow(createOptFlow_DualTVL1_0());
    }
    
    private static native long createOptFlow_DualTVL1_0();
    
    public static Mat estimateRigidTransform(final Mat mat, final Mat mat2, final boolean b) {
        return new Mat(estimateRigidTransform_0(mat.nativeObj, mat2.nativeObj, b));
    }
    
    private static native long estimateRigidTransform_0(final long p0, final long p1, final boolean p2);
    
    public static double findTransformECC(final Mat mat, final Mat mat2, final Mat mat3) {
        return findTransformECC_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static double findTransformECC(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        return findTransformECC_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static double findTransformECC(final Mat mat, final Mat mat2, final Mat mat3, final int n, final TermCriteria termCriteria, final Mat mat4) {
        return findTransformECC_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, mat4.nativeObj);
    }
    
    private static native double findTransformECC_0(final long p0, final long p1, final long p2, final int p3, final int p4, final int p5, final double p6, final long p7);
    
    private static native double findTransformECC_1(final long p0, final long p1, final long p2, final int p3);
    
    private static native double findTransformECC_2(final long p0, final long p1, final long p2);
    
    public static int meanShift(final Mat mat, final Rect rect, final TermCriteria termCriteria) {
        final double[] array = new double[4];
        final int meanShift_0 = meanShift_0(mat.nativeObj, rect.x, rect.y, rect.width, rect.height, array, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        if (rect != null) {
            rect.x = (int)array[0];
            rect.y = (int)array[1];
            rect.width = (int)array[2];
            rect.height = (int)array[3];
        }
        return meanShift_0;
    }
    
    private static native int meanShift_0(final long p0, final int p1, final int p2, final int p3, final int p4, final double[] p5, final int p6, final int p7, final double p8);
}

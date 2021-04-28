package org.opencv.calib3d;

import org.opencv.utils.*;
import java.util.*;
import org.opencv.core.*;

public class Calib3d
{
    public static final int CALIB_CB_ADAPTIVE_THRESH = 1;
    public static final int CALIB_CB_ASYMMETRIC_GRID = 2;
    public static final int CALIB_CB_CLUSTERING = 4;
    public static final int CALIB_CB_FAST_CHECK = 8;
    public static final int CALIB_CB_FILTER_QUADS = 4;
    public static final int CALIB_CB_NORMALIZE_IMAGE = 2;
    public static final int CALIB_CB_SYMMETRIC_GRID = 1;
    public static final int CALIB_CHECK_COND = 4;
    public static final int CALIB_FIX_ASPECT_RATIO = 2;
    public static final int CALIB_FIX_FOCAL_LENGTH = 16;
    public static final int CALIB_FIX_INTRINSIC = 256;
    public static final int CALIB_FIX_K1 = 16;
    public static final int CALIB_FIX_K2 = 32;
    public static final int CALIB_FIX_K3 = 64;
    public static final int CALIB_FIX_K4 = 128;
    public static final int CALIB_FIX_K5 = 4096;
    public static final int CALIB_FIX_K6 = 8192;
    public static final int CALIB_FIX_PRINCIPAL_POINT = 4;
    public static final int CALIB_FIX_S1_S2_S3_S4 = 65536;
    public static final int CALIB_FIX_SKEW = 8;
    public static final int CALIB_FIX_TAUX_TAUY = 524288;
    public static final int CALIB_RATIONAL_MODEL = 16384;
    public static final int CALIB_RECOMPUTE_EXTRINSIC = 2;
    public static final int CALIB_SAME_FOCAL_LENGTH = 512;
    public static final int CALIB_THIN_PRISM_MODEL = 32768;
    public static final int CALIB_TILTED_MODEL = 262144;
    public static final int CALIB_USE_INTRINSIC_GUESS = 1;
    public static final int CALIB_USE_LU = 131072;
    public static final int CALIB_ZERO_DISPARITY = 1024;
    public static final int CALIB_ZERO_TANGENT_DIST = 8;
    public static final int CV_DLS = 3;
    public static final int CV_EPNP = 1;
    public static final int CV_ITERATIVE = 0;
    public static final int CV_P3P = 2;
    public static final int FM_7POINT = 1;
    public static final int FM_8POINT = 2;
    public static final int FM_LMEDS = 4;
    public static final int FM_RANSAC = 8;
    public static final int LMEDS = 4;
    public static final int RANSAC = 8;
    public static final int RHO = 16;
    public static final int SOLVEPNP_DLS = 3;
    public static final int SOLVEPNP_EPNP = 1;
    public static final int SOLVEPNP_ITERATIVE = 0;
    public static final int SOLVEPNP_P3P = 2;
    public static final int SOLVEPNP_UPNP = 4;
    
    public static double[] RQDecomp3x3(final Mat mat, final Mat mat2, final Mat mat3) {
        return RQDecomp3x3_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static double[] RQDecomp3x3(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6) {
        return RQDecomp3x3_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }
    
    private static native double[] RQDecomp3x3_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    private static native double[] RQDecomp3x3_1(final long p0, final long p1, final long p2);
    
    public static void Rodrigues(final Mat mat, final Mat mat2) {
        Rodrigues_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void Rodrigues(final Mat mat, final Mat mat2, final Mat mat3) {
        Rodrigues_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void Rodrigues_0(final long p0, final long p1, final long p2);
    
    private static native void Rodrigues_1(final long p0, final long p1);
    
    public static double calibrate(final List<Mat> list, final List<Mat> list2, final Size size, final Mat mat, final Mat mat2, final List<Mat> list3, final List<Mat> list4) {
        final Mat vector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        final Mat vector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        final Mat mat3 = new Mat();
        final Mat mat4 = new Mat();
        final double calibrate_2 = calibrate_2(vector_Mat_to_Mat.nativeObj, vector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
        Converters.Mat_to_vector_Mat(mat3, list3);
        mat3.release();
        Converters.Mat_to_vector_Mat(mat4, list4);
        mat4.release();
        return calibrate_2;
    }
    
    public static double calibrate(final List<Mat> list, final List<Mat> list2, final Size size, final Mat mat, final Mat mat2, final List<Mat> list3, final List<Mat> list4, final int n) {
        final Mat vector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        final Mat vector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        final Mat mat3 = new Mat();
        final Mat mat4 = new Mat();
        final double calibrate_1 = calibrate_1(vector_Mat_to_Mat.nativeObj, vector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n);
        Converters.Mat_to_vector_Mat(mat3, list3);
        mat3.release();
        Converters.Mat_to_vector_Mat(mat4, list4);
        mat4.release();
        return calibrate_1;
    }
    
    public static double calibrate(final List<Mat> list, final List<Mat> list2, final Size size, final Mat mat, final Mat mat2, final List<Mat> list3, final List<Mat> list4, final int n, final TermCriteria termCriteria) {
        final Mat vector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        final Mat vector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        final Mat mat3 = new Mat();
        final Mat mat4 = new Mat();
        final double calibrate_0 = calibrate_0(vector_Mat_to_Mat.nativeObj, vector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        Converters.Mat_to_vector_Mat(mat3, list3);
        mat3.release();
        Converters.Mat_to_vector_Mat(mat4, list4);
        mat4.release();
        return calibrate_0;
    }
    
    public static double calibrateCamera(final List<Mat> list, final List<Mat> list2, final Size size, final Mat mat, final Mat mat2, final List<Mat> list3, final List<Mat> list4) {
        final Mat vector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        final Mat vector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        final Mat mat3 = new Mat();
        final Mat mat4 = new Mat();
        final double calibrateCamera_2 = calibrateCamera_2(vector_Mat_to_Mat.nativeObj, vector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
        Converters.Mat_to_vector_Mat(mat3, list3);
        mat3.release();
        Converters.Mat_to_vector_Mat(mat4, list4);
        mat4.release();
        return calibrateCamera_2;
    }
    
    public static double calibrateCamera(final List<Mat> list, final List<Mat> list2, final Size size, final Mat mat, final Mat mat2, final List<Mat> list3, final List<Mat> list4, final int n) {
        final Mat vector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        final Mat vector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        final Mat mat3 = new Mat();
        final Mat mat4 = new Mat();
        final double calibrateCamera_1 = calibrateCamera_1(vector_Mat_to_Mat.nativeObj, vector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n);
        Converters.Mat_to_vector_Mat(mat3, list3);
        mat3.release();
        Converters.Mat_to_vector_Mat(mat4, list4);
        mat4.release();
        return calibrateCamera_1;
    }
    
    public static double calibrateCamera(final List<Mat> list, final List<Mat> list2, final Size size, final Mat mat, final Mat mat2, final List<Mat> list3, final List<Mat> list4, final int n, final TermCriteria termCriteria) {
        final Mat vector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        final Mat vector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        final Mat mat3 = new Mat();
        final Mat mat4 = new Mat();
        final double calibrateCamera_0 = calibrateCamera_0(vector_Mat_to_Mat.nativeObj, vector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        Converters.Mat_to_vector_Mat(mat3, list3);
        mat3.release();
        Converters.Mat_to_vector_Mat(mat4, list4);
        mat4.release();
        return calibrateCamera_0;
    }
    
    private static native double calibrateCamera_0(final long p0, final long p1, final double p2, final double p3, final long p4, final long p5, final long p6, final long p7, final int p8, final int p9, final int p10, final double p11);
    
    private static native double calibrateCamera_1(final long p0, final long p1, final double p2, final double p3, final long p4, final long p5, final long p6, final long p7, final int p8);
    
    private static native double calibrateCamera_2(final long p0, final long p1, final double p2, final double p3, final long p4, final long p5, final long p6, final long p7);
    
    private static native double calibrate_0(final long p0, final long p1, final double p2, final double p3, final long p4, final long p5, final long p6, final long p7, final int p8, final int p9, final int p10, final double p11);
    
    private static native double calibrate_1(final long p0, final long p1, final double p2, final double p3, final long p4, final long p5, final long p6, final long p7, final int p8);
    
    private static native double calibrate_2(final long p0, final long p1, final double p2, final double p3, final long p4, final long p5, final long p6, final long p7);
    
    public static void calibrationMatrixValues(final Mat mat, final Size size, final double n, final double n2, final double[] array, final double[] array2, final double[] array3, final Point point, final double[] array4) {
        final double[] array5 = { 0.0 };
        final double[] array6 = { 0.0 };
        final double[] array7 = { 0.0 };
        final double[] array8 = new double[2];
        final double[] array9 = { 0.0 };
        calibrationMatrixValues_0(mat.nativeObj, size.width, size.height, n, n2, array5, array6, array7, array8, array9);
        if (array != null) {
            array[0] = array5[0];
        }
        if (array2 != null) {
            array2[0] = array6[0];
        }
        if (array3 != null) {
            array3[0] = array7[0];
        }
        if (point != null) {
            point.x = array8[0];
            point.y = array8[1];
        }
        if (array4 != null) {
            array4[0] = array9[0];
        }
    }
    
    private static native void calibrationMatrixValues_0(final long p0, final double p1, final double p2, final double p3, final double p4, final double[] p5, final double[] p6, final double[] p7, final double[] p8, final double[] p9);
    
    public static void composeRT(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6) {
        composeRT_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }
    
    public static void composeRT(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8, final Mat mat9, final Mat mat10, final Mat mat11, final Mat mat12, final Mat mat13, final Mat mat14) {
        composeRT_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, mat12.nativeObj, mat13.nativeObj, mat14.nativeObj);
    }
    
    private static native void composeRT_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final long p7, final long p8, final long p9, final long p10, final long p11, final long p12, final long p13);
    
    private static native void composeRT_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    public static void computeCorrespondEpilines(final Mat mat, final int n, final Mat mat2, final Mat mat3) {
        computeCorrespondEpilines_0(mat.nativeObj, n, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void computeCorrespondEpilines_0(final long p0, final int p1, final long p2, final long p3);
    
    public static void convertPointsFromHomogeneous(final Mat mat, final Mat mat2) {
        convertPointsFromHomogeneous_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void convertPointsFromHomogeneous_0(final long p0, final long p1);
    
    public static void convertPointsToHomogeneous(final Mat mat, final Mat mat2) {
        convertPointsToHomogeneous_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void convertPointsToHomogeneous_0(final long p0, final long p1);
    
    public static void correctMatches(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5) {
        correctMatches_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }
    
    private static native void correctMatches_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    public static void decomposeEssentialMat(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        decomposeEssentialMat_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void decomposeEssentialMat_0(final long p0, final long p1, final long p2, final long p3);
    
    public static int decomposeHomographyMat(final Mat mat, final Mat mat2, final List<Mat> list, final List<Mat> list2, final List<Mat> list3) {
        final Mat mat3 = new Mat();
        final Mat mat4 = new Mat();
        final Mat mat5 = new Mat();
        final int decomposeHomographyMat_0 = decomposeHomographyMat_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
        Converters.Mat_to_vector_Mat(mat3, list);
        mat3.release();
        Converters.Mat_to_vector_Mat(mat4, list2);
        mat4.release();
        Converters.Mat_to_vector_Mat(mat5, list3);
        mat5.release();
        return decomposeHomographyMat_0;
    }
    
    private static native int decomposeHomographyMat_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    public static void decomposeProjectionMatrix(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        decomposeProjectionMatrix_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void decomposeProjectionMatrix(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8) {
        decomposeProjectionMatrix_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj);
    }
    
    private static native void decomposeProjectionMatrix_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final long p7);
    
    private static native void decomposeProjectionMatrix_1(final long p0, final long p1, final long p2, final long p3);
    
    public static void distortPoints(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        distortPoints_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void distortPoints(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final double n) {
        distortPoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n);
    }
    
    private static native void distortPoints_0(final long p0, final long p1, final long p2, final long p3, final double p4);
    
    private static native void distortPoints_1(final long p0, final long p1, final long p2, final long p3);
    
    public static void drawChessboardCorners(final Mat mat, final Size size, final MatOfPoint2f matOfPoint2f, final boolean b) {
        drawChessboardCorners_0(mat.nativeObj, size.width, size.height, matOfPoint2f.nativeObj, b);
    }
    
    private static native void drawChessboardCorners_0(final long p0, final double p1, final double p2, final long p3, final boolean p4);
    
    public static int estimateAffine3D(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        return estimateAffine3D_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static int estimateAffine3D(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final double n, final double n2) {
        return estimateAffine3D_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n, n2);
    }
    
    private static native int estimateAffine3D_0(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5);
    
    private static native int estimateAffine3D_1(final long p0, final long p1, final long p2, final long p3);
    
    public static void estimateNewCameraMatrixForUndistortRectify(final Mat mat, final Mat mat2, final Size size, final Mat mat3, final Mat mat4) {
        estimateNewCameraMatrixForUndistortRectify_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void estimateNewCameraMatrixForUndistortRectify(final Mat mat, final Mat mat2, final Size size, final Mat mat3, final Mat mat4, final double n, final Size size2, final double n2) {
        estimateNewCameraMatrixForUndistortRectify_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, mat3.nativeObj, mat4.nativeObj, n, size2.width, size2.height, n2);
    }
    
    private static native void estimateNewCameraMatrixForUndistortRectify_0(final long p0, final long p1, final double p2, final double p3, final long p4, final long p5, final double p6, final double p7, final double p8, final double p9);
    
    private static native void estimateNewCameraMatrixForUndistortRectify_1(final long p0, final long p1, final double p2, final double p3, final long p4, final long p5);
    
    public static void filterSpeckles(final Mat mat, final double n, final int n2, final double n3) {
        filterSpeckles_1(mat.nativeObj, n, n2, n3);
    }
    
    public static void filterSpeckles(final Mat mat, final double n, final int n2, final double n3, final Mat mat2) {
        filterSpeckles_0(mat.nativeObj, n, n2, n3, mat2.nativeObj);
    }
    
    private static native void filterSpeckles_0(final long p0, final double p1, final int p2, final double p3, final long p4);
    
    private static native void filterSpeckles_1(final long p0, final double p1, final int p2, final double p3);
    
    public static boolean findChessboardCorners(final Mat mat, final Size size, final MatOfPoint2f matOfPoint2f) {
        return findChessboardCorners_1(mat.nativeObj, size.width, size.height, matOfPoint2f.nativeObj);
    }
    
    public static boolean findChessboardCorners(final Mat mat, final Size size, final MatOfPoint2f matOfPoint2f, final int n) {
        return findChessboardCorners_0(mat.nativeObj, size.width, size.height, matOfPoint2f.nativeObj, n);
    }
    
    private static native boolean findChessboardCorners_0(final long p0, final double p1, final double p2, final long p3, final int p4);
    
    private static native boolean findChessboardCorners_1(final long p0, final double p1, final double p2, final long p3);
    
    public static boolean findCirclesGrid(final Mat mat, final Size size, final Mat mat2) {
        return findCirclesGrid_1(mat.nativeObj, size.width, size.height, mat2.nativeObj);
    }
    
    public static boolean findCirclesGrid(final Mat mat, final Size size, final Mat mat2, final int n) {
        return findCirclesGrid_0(mat.nativeObj, size.width, size.height, mat2.nativeObj, n);
    }
    
    private static native boolean findCirclesGrid_0(final long p0, final double p1, final double p2, final long p3, final int p4);
    
    private static native boolean findCirclesGrid_1(final long p0, final double p1, final double p2, final long p3);
    
    public static Mat findEssentialMat(final Mat mat, final Mat mat2) {
        return new Mat(findEssentialMat_5(mat.nativeObj, mat2.nativeObj));
    }
    
    public static Mat findEssentialMat(final Mat mat, final Mat mat2, final double n, final Point point, final int n2, final double n3, final double n4) {
        return new Mat(findEssentialMat_4(mat.nativeObj, mat2.nativeObj, n, point.x, point.y, n2, n3, n4));
    }
    
    public static Mat findEssentialMat(final Mat mat, final Mat mat2, final double n, final Point point, final int n2, final double n3, final double n4, final Mat mat3) {
        return new Mat(findEssentialMat_3(mat.nativeObj, mat2.nativeObj, n, point.x, point.y, n2, n3, n4, mat3.nativeObj));
    }
    
    public static Mat findEssentialMat(final Mat mat, final Mat mat2, final Mat mat3) {
        return new Mat(findEssentialMat_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj));
    }
    
    public static Mat findEssentialMat(final Mat mat, final Mat mat2, final Mat mat3, final int n, final double n2, final double n3) {
        return new Mat(findEssentialMat_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2, n3));
    }
    
    public static Mat findEssentialMat(final Mat mat, final Mat mat2, final Mat mat3, final int n, final double n2, final double n3, final Mat mat4) {
        return new Mat(findEssentialMat_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2, n3, mat4.nativeObj));
    }
    
    private static native long findEssentialMat_0(final long p0, final long p1, final long p2, final int p3, final double p4, final double p5, final long p6);
    
    private static native long findEssentialMat_1(final long p0, final long p1, final long p2, final int p3, final double p4, final double p5);
    
    private static native long findEssentialMat_2(final long p0, final long p1, final long p2);
    
    private static native long findEssentialMat_3(final long p0, final long p1, final double p2, final double p3, final double p4, final int p5, final double p6, final double p7, final long p8);
    
    private static native long findEssentialMat_4(final long p0, final long p1, final double p2, final double p3, final double p4, final int p5, final double p6, final double p7);
    
    private static native long findEssentialMat_5(final long p0, final long p1);
    
    public static Mat findFundamentalMat(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2) {
        return new Mat(findFundamentalMat_2(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj));
    }
    
    public static Mat findFundamentalMat(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final int n, final double n2, final double n3) {
        return new Mat(findFundamentalMat_1(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, n, n2, n3));
    }
    
    public static Mat findFundamentalMat(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final int n, final double n2, final double n3, final Mat mat) {
        return new Mat(findFundamentalMat_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, n, n2, n3, mat.nativeObj));
    }
    
    private static native long findFundamentalMat_0(final long p0, final long p1, final int p2, final double p3, final double p4, final long p5);
    
    private static native long findFundamentalMat_1(final long p0, final long p1, final int p2, final double p3, final double p4);
    
    private static native long findFundamentalMat_2(final long p0, final long p1);
    
    public static Mat findHomography(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2) {
        return new Mat(findHomography_2(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj));
    }
    
    public static Mat findHomography(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final int n, final double n2) {
        return new Mat(findHomography_1(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, n, n2));
    }
    
    public static Mat findHomography(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final int n, final double n2, final Mat mat, final int n3, final double n4) {
        return new Mat(findHomography_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, n, n2, mat.nativeObj, n3, n4));
    }
    
    private static native long findHomography_0(final long p0, final long p1, final int p2, final double p3, final long p4, final int p5, final double p6);
    
    private static native long findHomography_1(final long p0, final long p1, final int p2, final double p3);
    
    private static native long findHomography_2(final long p0, final long p1);
    
    public static Mat getOptimalNewCameraMatrix(final Mat mat, final Mat mat2, final Size size, final double n) {
        return new Mat(getOptimalNewCameraMatrix_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, n));
    }
    
    public static Mat getOptimalNewCameraMatrix(Mat mat, final Mat mat2, final Size size, final double n, final Size size2, final Rect rect, final boolean b) {
        final double[] array = new double[4];
        mat = new Mat(getOptimalNewCameraMatrix_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, n, size2.width, size2.height, array, b));
        if (rect != null) {
            rect.x = (int)array[0];
            rect.y = (int)array[1];
            rect.width = (int)array[2];
            rect.height = (int)array[3];
        }
        return mat;
    }
    
    private static native long getOptimalNewCameraMatrix_0(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double[] p7, final boolean p8);
    
    private static native long getOptimalNewCameraMatrix_1(final long p0, final long p1, final double p2, final double p3, final double p4);
    
    public static Rect getValidDisparityROI(final Rect rect, final Rect rect2, final int n, final int n2, final int n3) {
        return new Rect(getValidDisparityROI_0(rect.x, rect.y, rect.width, rect.height, rect2.x, rect2.y, rect2.width, rect2.height, n, n2, n3));
    }
    
    private static native double[] getValidDisparityROI_0(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final int p7, final int p8, final int p9, final int p10);
    
    public static Mat initCameraMatrix2D(final List<MatOfPoint3f> list, final List<MatOfPoint2f> list2, final Size size) {
        final int n = 0;
        int size2;
        if (list != null) {
            size2 = list.size();
        }
        else {
            size2 = 0;
        }
        final Mat vector_vector_Point3f_to_Mat = Converters.vector_vector_Point3f_to_Mat(list, new ArrayList<Mat>(size2));
        int size3 = n;
        if (list2 != null) {
            size3 = list2.size();
        }
        return new Mat(initCameraMatrix2D_1(vector_vector_Point3f_to_Mat.nativeObj, Converters.vector_vector_Point2f_to_Mat(list2, new ArrayList<Mat>(size3)).nativeObj, size.width, size.height));
    }
    
    public static Mat initCameraMatrix2D(final List<MatOfPoint3f> list, final List<MatOfPoint2f> list2, final Size size, final double n) {
        int size2;
        if (list != null) {
            size2 = list.size();
        }
        else {
            size2 = 0;
        }
        final Mat vector_vector_Point3f_to_Mat = Converters.vector_vector_Point3f_to_Mat(list, new ArrayList<Mat>(size2));
        int size3;
        if (list2 != null) {
            size3 = list2.size();
        }
        else {
            size3 = 0;
        }
        return new Mat(initCameraMatrix2D_0(vector_vector_Point3f_to_Mat.nativeObj, Converters.vector_vector_Point2f_to_Mat(list2, new ArrayList<Mat>(size3)).nativeObj, size.width, size.height, n));
    }
    
    private static native long initCameraMatrix2D_0(final long p0, final long p1, final double p2, final double p3, final double p4);
    
    private static native long initCameraMatrix2D_1(final long p0, final long p1, final double p2, final double p3);
    
    public static void initUndistortRectifyMap(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final int n, final Mat mat5, final Mat mat6) {
        initUndistortRectifyMap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, n, mat5.nativeObj, mat6.nativeObj);
    }
    
    private static native void initUndistortRectifyMap_0(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final int p6, final long p7, final long p8);
    
    public static void matMulDeriv(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        matMulDeriv_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void matMulDeriv_0(final long p0, final long p1, final long p2, final long p3);
    
    public static void projectPoints(final MatOfPoint3f matOfPoint3f, final Mat mat, final Mat mat2, final Mat mat3, final MatOfDouble matOfDouble, final MatOfPoint2f matOfPoint2f) {
        projectPoints_1(matOfPoint3f.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, matOfDouble.nativeObj, matOfPoint2f.nativeObj);
    }
    
    public static void projectPoints(final MatOfPoint3f matOfPoint3f, final Mat mat, final Mat mat2, final Mat mat3, final MatOfDouble matOfDouble, final MatOfPoint2f matOfPoint2f, final Mat mat4, final double n) {
        projectPoints_0(matOfPoint3f.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, matOfDouble.nativeObj, matOfPoint2f.nativeObj, mat4.nativeObj, n);
    }
    
    public static void projectPoints(final MatOfPoint3f matOfPoint3f, final MatOfPoint2f matOfPoint2f, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        projectPoints_3(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void projectPoints(final MatOfPoint3f matOfPoint3f, final MatOfPoint2f matOfPoint2f, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final double n, final Mat mat5) {
        projectPoints_2(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n, mat5.nativeObj);
    }
    
    private static native void projectPoints_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final double p7);
    
    private static native void projectPoints_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    private static native void projectPoints_2(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final double p6, final long p7);
    
    private static native void projectPoints_3(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    public static int recoverPose(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5) {
        return recoverPose_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }
    
    public static int recoverPose(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final double n, final Point point) {
        return recoverPose_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, n, point.x, point.y);
    }
    
    public static int recoverPose(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final double n, final Point point, final Mat mat6) {
        return recoverPose_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, n, point.x, point.y, mat6.nativeObj);
    }
    
    public static int recoverPose(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6) {
        return recoverPose_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }
    
    public static int recoverPose(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6, final Mat mat7) {
        return recoverPose_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj);
    }
    
    private static native int recoverPose_0(final long p0, final long p1, final long p2, final long p3, final long p4, final double p5, final double p6, final double p7, final long p8);
    
    private static native int recoverPose_1(final long p0, final long p1, final long p2, final long p3, final long p4, final double p5, final double p6, final double p7);
    
    private static native int recoverPose_2(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    private static native int recoverPose_3(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6);
    
    private static native int recoverPose_4(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    public static float rectify3Collinear(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6, final List<Mat> list, final List<Mat> list2, final Size size, final Mat mat7, final Mat mat8, final Mat mat9, final Mat mat10, final Mat mat11, final Mat mat12, final Mat mat13, final Mat mat14, final Mat mat15, final Mat mat16, final Mat mat17, final double n, final Size size2, final Rect rect, final Rect rect2, final int n2) {
        final Mat vector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        final Mat vector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        final double[] array = new double[4];
        final double[] array2 = new double[4];
        final float rectify3Collinear_0 = rectify3Collinear_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, vector_Mat_to_Mat.nativeObj, vector_Mat_to_Mat2.nativeObj, size.width, size.height, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, mat12.nativeObj, mat13.nativeObj, mat14.nativeObj, mat15.nativeObj, mat16.nativeObj, mat17.nativeObj, n, size2.width, size2.height, array, array2, n2);
        if (rect != null) {
            rect.x = (int)array[0];
            rect.y = (int)array[1];
            rect.width = (int)array[2];
            rect.height = (int)array[3];
        }
        if (rect2 != null) {
            rect2.x = (int)array2[0];
            rect2.y = (int)array2[1];
            rect2.width = (int)array2[2];
            rect2.height = (int)array2[3];
        }
        return rectify3Collinear_0;
    }
    
    private static native float rectify3Collinear_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final long p7, final double p8, final double p9, final long p10, final long p11, final long p12, final long p13, final long p14, final long p15, final long p16, final long p17, final long p18, final long p19, final long p20, final double p21, final double p22, final double p23, final double[] p24, final double[] p25, final int p26);
    
    public static void reprojectImageTo3D(final Mat mat, final Mat mat2, final Mat mat3) {
        reprojectImageTo3D_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void reprojectImageTo3D(final Mat mat, final Mat mat2, final Mat mat3, final boolean b) {
        reprojectImageTo3D_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, b);
    }
    
    public static void reprojectImageTo3D(final Mat mat, final Mat mat2, final Mat mat3, final boolean b, final int n) {
        reprojectImageTo3D_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, b, n);
    }
    
    private static native void reprojectImageTo3D_0(final long p0, final long p1, final long p2, final boolean p3, final int p4);
    
    private static native void reprojectImageTo3D_1(final long p0, final long p1, final long p2, final boolean p3);
    
    private static native void reprojectImageTo3D_2(final long p0, final long p1, final long p2);
    
    public static double sampsonDistance(final Mat mat, final Mat mat2, final Mat mat3) {
        return sampsonDistance_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native double sampsonDistance_0(final long p0, final long p1, final long p2);
    
    public static boolean solvePnP(final MatOfPoint3f matOfPoint3f, final MatOfPoint2f matOfPoint2f, final Mat mat, final MatOfDouble matOfDouble, final Mat mat2, final Mat mat3) {
        return solvePnP_1(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static boolean solvePnP(final MatOfPoint3f matOfPoint3f, final MatOfPoint2f matOfPoint2f, final Mat mat, final MatOfDouble matOfDouble, final Mat mat2, final Mat mat3, final boolean b, final int n) {
        return solvePnP_0(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, b, n);
    }
    
    public static boolean solvePnPRansac(final MatOfPoint3f matOfPoint3f, final MatOfPoint2f matOfPoint2f, final Mat mat, final MatOfDouble matOfDouble, final Mat mat2, final Mat mat3) {
        return solvePnPRansac_1(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static boolean solvePnPRansac(final MatOfPoint3f matOfPoint3f, final MatOfPoint2f matOfPoint2f, final Mat mat, final MatOfDouble matOfDouble, final Mat mat2, final Mat mat3, final boolean b, final int n, final float n2, final double n3, final Mat mat4, final int n4) {
        return solvePnPRansac_0(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, b, n, n2, n3, mat4.nativeObj, n4);
    }
    
    private static native boolean solvePnPRansac_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final boolean p6, final int p7, final float p8, final double p9, final long p10, final int p11);
    
    private static native boolean solvePnPRansac_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    private static native boolean solvePnP_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final boolean p6, final int p7);
    
    private static native boolean solvePnP_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    public static double stereoCalibrate(final List<Mat> list, final List<Mat> list2, final List<Mat> list3, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6) {
        return stereoCalibrate_5(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj);
    }
    
    public static double stereoCalibrate(final List<Mat> list, final List<Mat> list2, final List<Mat> list3, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final int n) {
        return stereoCalibrate_4(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, n);
    }
    
    public static double stereoCalibrate(final List<Mat> list, final List<Mat> list2, final List<Mat> list3, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final int n, final TermCriteria termCriteria) {
        return stereoCalibrate_3(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, n, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
    
    public static double stereoCalibrate(final List<Mat> list, final List<Mat> list2, final List<Mat> list3, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8) {
        return stereoCalibrate_2(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj);
    }
    
    public static double stereoCalibrate(final List<Mat> list, final List<Mat> list2, final List<Mat> list3, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8, final int n) {
        return stereoCalibrate_1(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, n);
    }
    
    public static double stereoCalibrate(final List<Mat> list, final List<Mat> list2, final List<Mat> list3, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8, final int n, final TermCriteria termCriteria) {
        return stereoCalibrate_0(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, n, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
    
    private static native double stereoCalibrate_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final double p7, final double p8, final long p9, final long p10, final long p11, final long p12, final int p13, final int p14, final int p15, final double p16);
    
    private static native double stereoCalibrate_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final double p7, final double p8, final long p9, final long p10, final long p11, final long p12, final int p13);
    
    private static native double stereoCalibrate_2(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final double p7, final double p8, final long p9, final long p10, final long p11, final long p12);
    
    private static native double stereoCalibrate_3(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final double p7, final double p8, final long p9, final long p10, final int p11, final int p12, final int p13, final double p14);
    
    private static native double stereoCalibrate_4(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final double p7, final double p8, final long p9, final long p10, final int p11);
    
    private static native double stereoCalibrate_5(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final double p7, final double p8, final long p9, final long p10);
    
    public static void stereoRectify(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8, final Mat mat9, final Mat mat10, final Mat mat11) {
        stereoRectify_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj);
    }
    
    public static void stereoRectify(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8, final Mat mat9, final Mat mat10, final Mat mat11, final int n) {
        stereoRectify_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, n);
    }
    
    public static void stereoRectify(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8, final Mat mat9, final Mat mat10, final Mat mat11, final int n, final double n2, final Size size2, final Rect rect, final Rect rect2) {
        final double[] array = new double[4];
        final double[] array2 = new double[4];
        stereoRectify_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, n, n2, size2.width, size2.height, array, array2);
        if (rect != null) {
            rect.x = (int)array[0];
            rect.y = (int)array[1];
            rect.width = (int)array[2];
            rect.height = (int)array[3];
        }
        if (rect2 != null) {
            rect2.x = (int)array2[0];
            rect2.y = (int)array2[1];
            rect2.width = (int)array2[2];
            rect2.height = (int)array2[3];
        }
    }
    
    public static void stereoRectify(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final Mat mat5, final Mat mat6, final Mat mat7, final Mat mat8, final Mat mat9, final Mat mat10, final Mat mat11, final int n, final Size size2, final double n2, final double n3) {
        stereoRectify_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, n, size2.width, size2.height, n2, n3);
    }
    
    public static boolean stereoRectifyUncalibrated(final Mat mat, final Mat mat2, final Mat mat3, final Size size, final Mat mat4, final Mat mat5) {
        return stereoRectifyUncalibrated_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, mat4.nativeObj, mat5.nativeObj);
    }
    
    public static boolean stereoRectifyUncalibrated(final Mat mat, final Mat mat2, final Mat mat3, final Size size, final Mat mat4, final Mat mat5, final double n) {
        return stereoRectifyUncalibrated_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, mat4.nativeObj, mat5.nativeObj, n);
    }
    
    private static native boolean stereoRectifyUncalibrated_0(final long p0, final long p1, final long p2, final double p3, final double p4, final long p5, final long p6, final double p7);
    
    private static native boolean stereoRectifyUncalibrated_1(final long p0, final long p1, final long p2, final double p3, final double p4, final long p5, final long p6);
    
    private static native void stereoRectify_0(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final long p6, final long p7, final long p8, final long p9, final long p10, final long p11, final long p12, final int p13, final double p14, final double p15, final double p16, final double[] p17, final double[] p18);
    
    private static native void stereoRectify_1(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final long p6, final long p7, final long p8, final long p9, final long p10, final long p11, final long p12);
    
    private static native void stereoRectify_2(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final long p6, final long p7, final long p8, final long p9, final long p10, final long p11, final long p12, final int p13, final double p14, final double p15, final double p16, final double p17);
    
    private static native void stereoRectify_3(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final long p6, final long p7, final long p8, final long p9, final long p10, final long p11, final long p12, final int p13);
    
    public static void triangulatePoints(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5) {
        triangulatePoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }
    
    private static native void triangulatePoints_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    public static void undistortImage(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        undistortImage_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void undistortImage(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Size size) {
        undistortImage_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, size.width, size.height);
    }
    
    private static native void undistortImage_0(final long p0, final long p1, final long p2, final long p3, final long p4, final double p5, final double p6);
    
    private static native void undistortImage_1(final long p0, final long p1, final long p2, final long p3);
    
    public static void undistortPoints(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        undistortPoints_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void undistortPoints(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6) {
        undistortPoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }
    
    private static native void undistortPoints_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    private static native void undistortPoints_1(final long p0, final long p1, final long p2, final long p3);
    
    public static void validateDisparity(final Mat mat, final Mat mat2, final int n, final int n2) {
        validateDisparity_1(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    public static void validateDisparity(final Mat mat, final Mat mat2, final int n, final int n2, final int n3) {
        validateDisparity_0(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    private static native void validateDisparity_0(final long p0, final long p1, final int p2, final int p3, final int p4);
    
    private static native void validateDisparity_1(final long p0, final long p1, final int p2, final int p3);
}

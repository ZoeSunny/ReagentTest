package org.opencv.core;

import java.util.*;
import org.opencv.utils.*;

public class Core
{
    public static final int BORDER_CONSTANT = 0;
    public static final int BORDER_DEFAULT = 4;
    public static final int BORDER_ISOLATED = 16;
    public static final int BORDER_REFLECT = 2;
    public static final int BORDER_REFLECT101 = 4;
    public static final int BORDER_REFLECT_101 = 4;
    public static final int BORDER_REPLICATE = 1;
    public static final int BORDER_TRANSPARENT = 5;
    public static final int BORDER_WRAP = 3;
    public static final int BadAlign = -21;
    public static final int BadAlphaChannel = -18;
    public static final int BadCOI = -24;
    public static final int BadCallBack = -22;
    public static final int BadDataPtr = -12;
    public static final int BadDepth = -17;
    public static final int BadImageSize = -10;
    public static final int BadModelOrChSeq = -14;
    public static final int BadNumChannel1U = -16;
    public static final int BadNumChannels = -15;
    public static final int BadOffset = -11;
    public static final int BadOrder = -19;
    public static final int BadOrigin = -20;
    public static final int BadROISize = -25;
    public static final int BadStep = -13;
    public static final int BadTileSize = -23;
    public static final int CMP_EQ = 0;
    public static final int CMP_GE = 2;
    public static final int CMP_GT = 1;
    public static final int CMP_LE = 4;
    public static final int CMP_LT = 3;
    public static final int CMP_NE = 5;
    public static final int COVAR_COLS = 16;
    public static final int COVAR_NORMAL = 1;
    public static final int COVAR_ROWS = 8;
    public static final int COVAR_SCALE = 4;
    public static final int COVAR_SCRAMBLED = 0;
    public static final int COVAR_USE_AVG = 2;
    private static final int CV_16S = 3;
    private static final int CV_16U = 2;
    private static final int CV_32F = 5;
    private static final int CV_32S = 4;
    private static final int CV_64F = 6;
    private static final int CV_8S = 1;
    private static final int CV_8U = 0;
    private static final int CV_USRTYPE1 = 7;
    public static final int DCT_INVERSE = 1;
    public static final int DCT_ROWS = 4;
    public static final int DECOMP_CHOLESKY = 3;
    public static final int DECOMP_EIG = 2;
    public static final int DECOMP_LU = 0;
    public static final int DECOMP_NORMAL = 16;
    public static final int DECOMP_QR = 4;
    public static final int DECOMP_SVD = 1;
    public static final int DFT_COMPLEX_OUTPUT = 16;
    public static final int DFT_INVERSE = 1;
    public static final int DFT_REAL_OUTPUT = 32;
    public static final int DFT_ROWS = 4;
    public static final int DFT_SCALE = 2;
    public static final int FILLED = -1;
    public static final int FONT_HERSHEY_COMPLEX = 3;
    public static final int FONT_HERSHEY_COMPLEX_SMALL = 5;
    public static final int FONT_HERSHEY_DUPLEX = 2;
    public static final int FONT_HERSHEY_PLAIN = 1;
    public static final int FONT_HERSHEY_SCRIPT_COMPLEX = 7;
    public static final int FONT_HERSHEY_SCRIPT_SIMPLEX = 6;
    public static final int FONT_HERSHEY_SIMPLEX = 0;
    public static final int FONT_HERSHEY_TRIPLEX = 4;
    public static final int FONT_ITALIC = 16;
    public static final int GEMM_1_T = 1;
    public static final int GEMM_2_T = 2;
    public static final int GEMM_3_T = 4;
    public static final int GpuApiCallError = -217;
    public static final int GpuNotSupported = -216;
    public static final int HeaderIsNull = -9;
    public static final int KMEANS_PP_CENTERS = 2;
    public static final int KMEANS_RANDOM_CENTERS = 0;
    public static final int KMEANS_USE_INITIAL_LABELS = 1;
    public static final int LINE_4 = 4;
    public static final int LINE_8 = 8;
    public static final int LINE_AA = 16;
    public static final int MaskIsTiled = -26;
    public static final String NATIVE_LIBRARY_NAME;
    public static final int NORM_HAMMING = 6;
    public static final int NORM_HAMMING2 = 7;
    public static final int NORM_INF = 1;
    public static final int NORM_L1 = 2;
    public static final int NORM_L2 = 4;
    public static final int NORM_L2SQR = 5;
    public static final int NORM_MINMAX = 32;
    public static final int NORM_RELATIVE = 8;
    public static final int NORM_TYPE_MASK = 7;
    public static final int OpenCLApiCallError = -220;
    public static final int OpenCLDoubleNotSupported = -221;
    public static final int OpenCLInitError = -222;
    public static final int OpenCLNoAMDBlasFft = -223;
    public static final int OpenGlApiCallError = -219;
    public static final int OpenGlNotSupported = -218;
    public static final int REDUCE_AVG = 1;
    public static final int REDUCE_MAX = 2;
    public static final int REDUCE_MIN = 3;
    public static final int REDUCE_SUM = 0;
    public static final int SORT_ASCENDING = 0;
    public static final int SORT_DESCENDING = 16;
    public static final int SORT_EVERY_COLUMN = 1;
    public static final int SORT_EVERY_ROW = 0;
    public static final int SVD_FULL_UV = 4;
    public static final int SVD_MODIFY_A = 1;
    public static final int SVD_NO_UV = 2;
    public static final int StsAssert = -215;
    public static final int StsAutoTrace = -8;
    public static final int StsBackTrace = -1;
    public static final int StsBadArg = -5;
    public static final int StsBadFlag = -206;
    public static final int StsBadFunc = -6;
    public static final int StsBadMask = -208;
    public static final int StsBadMemBlock = -214;
    public static final int StsBadPoint = -207;
    public static final int StsBadSize = -201;
    public static final int StsDivByZero = -202;
    public static final int StsError = -2;
    public static final int StsFilterOffsetErr = -31;
    public static final int StsFilterStructContentErr = -29;
    public static final int StsInplaceNotSupported = -203;
    public static final int StsInternal = -3;
    public static final int StsKernelStructContentErr = -30;
    public static final int StsNoConv = -7;
    public static final int StsNoMem = -4;
    public static final int StsNotImplemented = -213;
    public static final int StsNullPtr = -27;
    public static final int StsObjectNotFound = -204;
    public static final int StsOk = 0;
    public static final int StsOutOfRange = -211;
    public static final int StsParseError = -212;
    public static final int StsUnmatchedFormats = -205;
    public static final int StsUnmatchedSizes = -209;
    public static final int StsUnsupportedFormat = -210;
    public static final int StsVecLengthErr = -28;
    public static final String VERSION;
    public static final int VERSION_MAJOR;
    public static final int VERSION_MINOR;
    public static final int VERSION_REVISION;
    public static final String VERSION_STATUS;
    
    static {
        VERSION = getVersion();
        NATIVE_LIBRARY_NAME = getNativeLibraryName();
        VERSION_MAJOR = getVersionMajor();
        VERSION_MINOR = getVersionMinor();
        VERSION_REVISION = getVersionRevision();
        VERSION_STATUS = getVersionStatus();
    }
    
    public static void LUT(final Mat mat, final Mat mat2, final Mat mat3) {
        LUT_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void LUT_0(final long p0, final long p1, final long p2);
    
    public static double Mahalanobis(final Mat mat, final Mat mat2, final Mat mat3) {
        return Mahalanobis_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native double Mahalanobis_0(final long p0, final long p1, final long p2);
    
    public static void PCABackProject(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        PCABackProject_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void PCABackProject_0(final long p0, final long p1, final long p2, final long p3);
    
    public static void PCACompute(final Mat mat, final Mat mat2, final Mat mat3) {
        PCACompute_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void PCACompute(final Mat mat, final Mat mat2, final Mat mat3, final double n) {
        PCACompute_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void PCACompute(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        PCACompute_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    private static native void PCACompute_0(final long p0, final long p1, final long p2, final double p3);
    
    private static native void PCACompute_1(final long p0, final long p1, final long p2, final int p3);
    
    private static native void PCACompute_2(final long p0, final long p1, final long p2);
    
    public static void PCAProject(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        PCAProject_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void PCAProject_0(final long p0, final long p1, final long p2, final long p3);
    
    public static double PSNR(final Mat mat, final Mat mat2) {
        return PSNR_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native double PSNR_0(final long p0, final long p1);
    
    public static void SVBackSubst(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5) {
        SVBackSubst_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }
    
    private static native void SVBackSubst_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    public static void SVDecomp(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        SVDecomp_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void SVDecomp(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n) {
        SVDecomp_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n);
    }
    
    private static native void SVDecomp_0(final long p0, final long p1, final long p2, final long p3, final int p4);
    
    private static native void SVDecomp_1(final long p0, final long p1, final long p2, final long p3);
    
    public static void absdiff(final Mat mat, final Mat mat2, final Mat mat3) {
        absdiff_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void absdiff(final Mat mat, final Scalar scalar, final Mat mat2) {
        absdiff_1(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }
    
    private static native void absdiff_0(final long p0, final long p1, final long p2);
    
    private static native void absdiff_1(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    public static void add(final Mat mat, final Mat mat2, final Mat mat3) {
        add_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void add(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        add_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void add(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n) {
        add_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n);
    }
    
    public static void add(final Mat mat, final Scalar scalar, final Mat mat2) {
        add_5(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }
    
    public static void add(final Mat mat, final Scalar scalar, final Mat mat2, final Mat mat3) {
        add_4(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void add(final Mat mat, final Scalar scalar, final Mat mat2, final Mat mat3, final int n) {
        add_3(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void addWeighted(final Mat mat, final double n, final Mat mat2, final double n2, final double n3, final Mat mat3) {
        addWeighted_1(mat.nativeObj, n, mat2.nativeObj, n2, n3, mat3.nativeObj);
    }
    
    public static void addWeighted(final Mat mat, final double n, final Mat mat2, final double n2, final double n3, final Mat mat3, final int n4) {
        addWeighted_0(mat.nativeObj, n, mat2.nativeObj, n2, n3, mat3.nativeObj, n4);
    }
    
    private static native void addWeighted_0(final long p0, final double p1, final long p2, final double p3, final double p4, final long p5, final int p6);
    
    private static native void addWeighted_1(final long p0, final double p1, final long p2, final double p3, final double p4, final long p5);
    
    private static native void add_0(final long p0, final long p1, final long p2, final long p3, final int p4);
    
    private static native void add_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native void add_2(final long p0, final long p1, final long p2);
    
    private static native void add_3(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final long p6, final int p7);
    
    private static native void add_4(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final long p6);
    
    private static native void add_5(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    public static void batchDistance(final Mat mat, final Mat mat2, final Mat mat3, final int n, final Mat mat4) {
        batchDistance_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, mat4.nativeObj);
    }
    
    public static void batchDistance(final Mat mat, final Mat mat2, final Mat mat3, final int n, final Mat mat4, final int n2, final int n3) {
        batchDistance_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, mat4.nativeObj, n2, n3);
    }
    
    public static void batchDistance(final Mat mat, final Mat mat2, final Mat mat3, final int n, final Mat mat4, final int n2, final int n3, final Mat mat5, final int n4, final boolean b) {
        batchDistance_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, mat4.nativeObj, n2, n3, mat5.nativeObj, n4, b);
    }
    
    private static native void batchDistance_0(final long p0, final long p1, final long p2, final int p3, final long p4, final int p5, final int p6, final long p7, final int p8, final boolean p9);
    
    private static native void batchDistance_1(final long p0, final long p1, final long p2, final int p3, final long p4, final int p5, final int p6);
    
    private static native void batchDistance_2(final long p0, final long p1, final long p2, final int p3, final long p4);
    
    public static void bitwise_and(final Mat mat, final Mat mat2, final Mat mat3) {
        bitwise_and_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void bitwise_and(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        bitwise_and_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void bitwise_and_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void bitwise_and_1(final long p0, final long p1, final long p2);
    
    public static void bitwise_not(final Mat mat, final Mat mat2) {
        bitwise_not_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void bitwise_not(final Mat mat, final Mat mat2, final Mat mat3) {
        bitwise_not_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void bitwise_not_0(final long p0, final long p1, final long p2);
    
    private static native void bitwise_not_1(final long p0, final long p1);
    
    public static void bitwise_or(final Mat mat, final Mat mat2, final Mat mat3) {
        bitwise_or_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void bitwise_or(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        bitwise_or_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void bitwise_or_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void bitwise_or_1(final long p0, final long p1, final long p2);
    
    public static void bitwise_xor(final Mat mat, final Mat mat2, final Mat mat3) {
        bitwise_xor_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void bitwise_xor(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        bitwise_xor_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void bitwise_xor_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void bitwise_xor_1(final long p0, final long p1, final long p2);
    
    public static int borderInterpolate(final int n, final int n2, final int n3) {
        return borderInterpolate_0(n, n2, n3);
    }
    
    private static native int borderInterpolate_0(final int p0, final int p1, final int p2);
    
    public static void calcCovarMatrix(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        calcCovarMatrix_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void calcCovarMatrix(final Mat mat, final Mat mat2, final Mat mat3, final int n, final int n2) {
        calcCovarMatrix_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2);
    }
    
    private static native void calcCovarMatrix_0(final long p0, final long p1, final long p2, final int p3, final int p4);
    
    private static native void calcCovarMatrix_1(final long p0, final long p1, final long p2, final int p3);
    
    public static void cartToPolar(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        cartToPolar_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void cartToPolar(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final boolean b) {
        cartToPolar_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, b);
    }
    
    private static native void cartToPolar_0(final long p0, final long p1, final long p2, final long p3, final boolean p4);
    
    private static native void cartToPolar_1(final long p0, final long p1, final long p2, final long p3);
    
    public static boolean checkRange(final Mat mat) {
        return checkRange_1(mat.nativeObj);
    }
    
    public static boolean checkRange(final Mat mat, final boolean b, final double n, final double n2) {
        return checkRange_0(mat.nativeObj, b, n, n2);
    }
    
    private static native boolean checkRange_0(final long p0, final boolean p1, final double p2, final double p3);
    
    private static native boolean checkRange_1(final long p0);
    
    public static void compare(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        compare_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void compare(final Mat mat, final Scalar scalar, final Mat mat2, final int n) {
        compare_1(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, n);
    }
    
    private static native void compare_0(final long p0, final long p1, final long p2, final int p3);
    
    private static native void compare_1(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final int p6);
    
    public static void completeSymm(final Mat mat) {
        completeSymm_1(mat.nativeObj);
    }
    
    public static void completeSymm(final Mat mat, final boolean b) {
        completeSymm_0(mat.nativeObj, b);
    }
    
    private static native void completeSymm_0(final long p0, final boolean p1);
    
    private static native void completeSymm_1(final long p0);
    
    public static void convertScaleAbs(final Mat mat, final Mat mat2) {
        convertScaleAbs_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void convertScaleAbs(final Mat mat, final Mat mat2, final double n, final double n2) {
        convertScaleAbs_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native void convertScaleAbs_0(final long p0, final long p1, final double p2, final double p3);
    
    private static native void convertScaleAbs_1(final long p0, final long p1);
    
    public static void copyMakeBorder(final Mat mat, final Mat mat2, final int n, final int n2, final int n3, final int n4, final int n5) {
        copyMakeBorder_1(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5);
    }
    
    public static void copyMakeBorder(final Mat mat, final Mat mat2, final int n, final int n2, final int n3, final int n4, final int n5, final Scalar scalar) {
        copyMakeBorder_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    private static native void copyMakeBorder_0(final long p0, final long p1, final int p2, final int p3, final int p4, final int p5, final int p6, final double p7, final double p8, final double p9, final double p10);
    
    private static native void copyMakeBorder_1(final long p0, final long p1, final int p2, final int p3, final int p4, final int p5, final int p6);
    
    public static int countNonZero(final Mat mat) {
        return countNonZero_0(mat.nativeObj);
    }
    
    private static native int countNonZero_0(final long p0);
    
    public static float cubeRoot(final float n) {
        return cubeRoot_0(n);
    }
    
    private static native float cubeRoot_0(final float p0);
    
    public static void dct(final Mat mat, final Mat mat2) {
        dct_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void dct(final Mat mat, final Mat mat2, final int n) {
        dct_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native void dct_0(final long p0, final long p1, final int p2);
    
    private static native void dct_1(final long p0, final long p1);
    
    public static double determinant(final Mat mat) {
        return determinant_0(mat.nativeObj);
    }
    
    private static native double determinant_0(final long p0);
    
    public static void dft(final Mat mat, final Mat mat2) {
        dft_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void dft(final Mat mat, final Mat mat2, final int n, final int n2) {
        dft_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native void dft_0(final long p0, final long p1, final int p2, final int p3);
    
    private static native void dft_1(final long p0, final long p1);
    
    public static void divide(final double n, final Mat mat, final Mat mat2) {
        divide_7(n, mat.nativeObj, mat2.nativeObj);
    }
    
    public static void divide(final double n, final Mat mat, final Mat mat2, final int n2) {
        divide_6(n, mat.nativeObj, mat2.nativeObj, n2);
    }
    
    public static void divide(final Mat mat, final Mat mat2, final Mat mat3) {
        divide_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void divide(final Mat mat, final Mat mat2, final Mat mat3, final double n) {
        divide_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void divide(final Mat mat, final Mat mat2, final Mat mat3, final double n, final int n2) {
        divide_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2);
    }
    
    public static void divide(final Mat mat, final Scalar scalar, final Mat mat2) {
        divide_5(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }
    
    public static void divide(final Mat mat, final Scalar scalar, final Mat mat2, final double n) {
        divide_4(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, n);
    }
    
    public static void divide(final Mat mat, final Scalar scalar, final Mat mat2, final double n, final int n2) {
        divide_3(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, n, n2);
    }
    
    private static native void divide_0(final long p0, final long p1, final long p2, final double p3, final int p4);
    
    private static native void divide_1(final long p0, final long p1, final long p2, final double p3);
    
    private static native void divide_2(final long p0, final long p1, final long p2);
    
    private static native void divide_3(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final double p6, final int p7);
    
    private static native void divide_4(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final double p6);
    
    private static native void divide_5(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    private static native void divide_6(final double p0, final long p1, final long p2, final int p3);
    
    private static native void divide_7(final double p0, final long p1, final long p2);
    
    public static boolean eigen(final Mat mat, final Mat mat2) {
        return eigen_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static boolean eigen(final Mat mat, final Mat mat2, final Mat mat3) {
        return eigen_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native boolean eigen_0(final long p0, final long p1, final long p2);
    
    private static native boolean eigen_1(final long p0, final long p1);
    
    public static void exp(final Mat mat, final Mat mat2) {
        exp_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void exp_0(final long p0, final long p1);
    
    public static void extractChannel(final Mat mat, final Mat mat2, final int n) {
        extractChannel_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native void extractChannel_0(final long p0, final long p1, final int p2);
    
    public static float fastAtan2(final float n, final float n2) {
        return fastAtan2_0(n, n2);
    }
    
    private static native float fastAtan2_0(final float p0, final float p1);
    
    public static void findNonZero(final Mat mat, final Mat mat2) {
        findNonZero_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void findNonZero_0(final long p0, final long p1);
    
    public static void flip(final Mat mat, final Mat mat2, final int n) {
        flip_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native void flip_0(final long p0, final long p1, final int p2);
    
    public static void gemm(final Mat mat, final Mat mat2, final double n, final Mat mat3, final double n2, final Mat mat4) {
        gemm_1(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, n2, mat4.nativeObj);
    }
    
    public static void gemm(final Mat mat, final Mat mat2, final double n, final Mat mat3, final double n2, final Mat mat4, final int n3) {
        gemm_0(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, n2, mat4.nativeObj, n3);
    }
    
    private static native void gemm_0(final long p0, final long p1, final double p2, final long p3, final double p4, final long p5, final int p6);
    
    private static native void gemm_1(final long p0, final long p1, final double p2, final long p3, final double p4, final long p5);
    
    public static String getBuildInformation() {
        return getBuildInformation_0();
    }
    
    private static native String getBuildInformation_0();
    
    public static long getCPUTickCount() {
        return getCPUTickCount_0();
    }
    
    private static native long getCPUTickCount_0();
    
    private static String getNativeLibraryName() {
        return "opencv_java310";
    }
    
    public static int getNumThreads() {
        return getNumThreads_0();
    }
    
    private static native int getNumThreads_0();
    
    public static int getNumberOfCPUs() {
        return getNumberOfCPUs_0();
    }
    
    private static native int getNumberOfCPUs_0();
    
    public static int getOptimalDFTSize(final int n) {
        return getOptimalDFTSize_0(n);
    }
    
    private static native int getOptimalDFTSize_0(final int p0);
    
    public static int getThreadNum() {
        return getThreadNum_0();
    }
    
    private static native int getThreadNum_0();
    
    public static long getTickCount() {
        return getTickCount_0();
    }
    
    private static native long getTickCount_0();
    
    public static double getTickFrequency() {
        return getTickFrequency_0();
    }
    
    private static native double getTickFrequency_0();
    
    private static String getVersion() {
        return "3.1.0";
    }
    
    private static int getVersionMajor() {
        return 3;
    }
    
    private static int getVersionMinor() {
        return 1;
    }
    
    private static int getVersionRevision() {
        return 0;
    }
    
    private static String getVersionStatus() {
        return "";
    }
    
    public static void hconcat(final List<Mat> list, final Mat mat) {
        hconcat_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }
    
    private static native void hconcat_0(final long p0, final long p1);
    
    public static void idct(final Mat mat, final Mat mat2) {
        idct_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void idct(final Mat mat, final Mat mat2, final int n) {
        idct_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native void idct_0(final long p0, final long p1, final int p2);
    
    private static native void idct_1(final long p0, final long p1);
    
    public static void idft(final Mat mat, final Mat mat2) {
        idft_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void idft(final Mat mat, final Mat mat2, final int n, final int n2) {
        idft_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native void idft_0(final long p0, final long p1, final int p2, final int p3);
    
    private static native void idft_1(final long p0, final long p1);
    
    public static void inRange(final Mat mat, final Scalar scalar, final Scalar scalar2, final Mat mat2) {
        inRange_0(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj);
    }
    
    private static native void inRange_0(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final long p9);
    
    public static void insertChannel(final Mat mat, final Mat mat2, final int n) {
        insertChannel_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native void insertChannel_0(final long p0, final long p1, final int p2);
    
    public static double invert(final Mat mat, final Mat mat2) {
        return invert_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static double invert(final Mat mat, final Mat mat2, final int n) {
        return invert_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native double invert_0(final long p0, final long p1, final int p2);
    
    private static native double invert_1(final long p0, final long p1);
    
    public static double kmeans(final Mat mat, final int n, final Mat mat2, final TermCriteria termCriteria, final int n2, final int n3) {
        return kmeans_1(mat.nativeObj, n, mat2.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, n2, n3);
    }
    
    public static double kmeans(final Mat mat, final int n, final Mat mat2, final TermCriteria termCriteria, final int n2, final int n3, final Mat mat3) {
        return kmeans_0(mat.nativeObj, n, mat2.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, n2, n3, mat3.nativeObj);
    }
    
    private static native double kmeans_0(final long p0, final int p1, final long p2, final int p3, final int p4, final double p5, final int p6, final int p7, final long p8);
    
    private static native double kmeans_1(final long p0, final int p1, final long p2, final int p3, final int p4, final double p5, final int p6, final int p7);
    
    public static void log(final Mat mat, final Mat mat2) {
        log_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void log_0(final long p0, final long p1);
    
    public static void magnitude(final Mat mat, final Mat mat2, final Mat mat3) {
        magnitude_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void magnitude_0(final long p0, final long p1, final long p2);
    
    public static void max(final Mat mat, final Mat mat2, final Mat mat3) {
        max_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void max(final Mat mat, final Scalar scalar, final Mat mat2) {
        max_1(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }
    
    private static native void max_0(final long p0, final long p1, final long p2);
    
    private static native void max_1(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    public static Scalar mean(final Mat mat) {
        return new Scalar(mean_1(mat.nativeObj));
    }
    
    public static Scalar mean(final Mat mat, final Mat mat2) {
        return new Scalar(mean_0(mat.nativeObj, mat2.nativeObj));
    }
    
    public static void meanStdDev(final Mat mat, final MatOfDouble matOfDouble, final MatOfDouble matOfDouble2) {
        meanStdDev_1(mat.nativeObj, matOfDouble.nativeObj, matOfDouble2.nativeObj);
    }
    
    public static void meanStdDev(final Mat mat, final MatOfDouble matOfDouble, final MatOfDouble matOfDouble2, final Mat mat2) {
        meanStdDev_0(mat.nativeObj, matOfDouble.nativeObj, matOfDouble2.nativeObj, mat2.nativeObj);
    }
    
    private static native void meanStdDev_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void meanStdDev_1(final long p0, final long p1, final long p2);
    
    private static native double[] mean_0(final long p0, final long p1);
    
    private static native double[] mean_1(final long p0);
    
    public static void merge(final List<Mat> list, final Mat mat) {
        merge_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }
    
    private static native void merge_0(final long p0, final long p1);
    
    public static void min(final Mat mat, final Mat mat2, final Mat mat3) {
        min_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void min(final Mat mat, final Scalar scalar, final Mat mat2) {
        min_1(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }
    
    public static MinMaxLocResult minMaxLoc(final Mat mat) {
        return minMaxLoc(mat, null);
    }
    
    public static MinMaxLocResult minMaxLoc(final Mat mat, final Mat mat2) {
        final MinMaxLocResult minMaxLocResult = new MinMaxLocResult();
        long nativeObj = 0L;
        if (mat2 != null) {
            nativeObj = mat2.nativeObj;
        }
        final double[] n_minMaxLocManual = n_minMaxLocManual(mat.nativeObj, nativeObj);
        minMaxLocResult.minVal = n_minMaxLocManual[0];
        minMaxLocResult.maxVal = n_minMaxLocManual[1];
        minMaxLocResult.minLoc.x = n_minMaxLocManual[2];
        minMaxLocResult.minLoc.y = n_minMaxLocManual[3];
        minMaxLocResult.maxLoc.x = n_minMaxLocManual[4];
        minMaxLocResult.maxLoc.y = n_minMaxLocManual[5];
        return minMaxLocResult;
    }
    
    private static native void min_0(final long p0, final long p1, final long p2);
    
    private static native void min_1(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    public static void mixChannels(final List<Mat> list, final List<Mat> list2, final MatOfInt matOfInt) {
        mixChannels_0(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, matOfInt.nativeObj);
    }
    
    private static native void mixChannels_0(final long p0, final long p1, final long p2);
    
    public static void mulSpectrums(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        mulSpectrums_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void mulSpectrums(final Mat mat, final Mat mat2, final Mat mat3, final int n, final boolean b) {
        mulSpectrums_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, b);
    }
    
    private static native void mulSpectrums_0(final long p0, final long p1, final long p2, final int p3, final boolean p4);
    
    private static native void mulSpectrums_1(final long p0, final long p1, final long p2, final int p3);
    
    public static void mulTransposed(final Mat mat, final Mat mat2, final boolean b) {
        mulTransposed_2(mat.nativeObj, mat2.nativeObj, b);
    }
    
    public static void mulTransposed(final Mat mat, final Mat mat2, final boolean b, final Mat mat3, final double n) {
        mulTransposed_1(mat.nativeObj, mat2.nativeObj, b, mat3.nativeObj, n);
    }
    
    public static void mulTransposed(final Mat mat, final Mat mat2, final boolean b, final Mat mat3, final double n, final int n2) {
        mulTransposed_0(mat.nativeObj, mat2.nativeObj, b, mat3.nativeObj, n, n2);
    }
    
    private static native void mulTransposed_0(final long p0, final long p1, final boolean p2, final long p3, final double p4, final int p5);
    
    private static native void mulTransposed_1(final long p0, final long p1, final boolean p2, final long p3, final double p4);
    
    private static native void mulTransposed_2(final long p0, final long p1, final boolean p2);
    
    public static void multiply(final Mat mat, final Mat mat2, final Mat mat3) {
        multiply_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void multiply(final Mat mat, final Mat mat2, final Mat mat3, final double n) {
        multiply_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void multiply(final Mat mat, final Mat mat2, final Mat mat3, final double n, final int n2) {
        multiply_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2);
    }
    
    public static void multiply(final Mat mat, final Scalar scalar, final Mat mat2) {
        multiply_5(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }
    
    public static void multiply(final Mat mat, final Scalar scalar, final Mat mat2, final double n) {
        multiply_4(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, n);
    }
    
    public static void multiply(final Mat mat, final Scalar scalar, final Mat mat2, final double n, final int n2) {
        multiply_3(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, n, n2);
    }
    
    private static native void multiply_0(final long p0, final long p1, final long p2, final double p3, final int p4);
    
    private static native void multiply_1(final long p0, final long p1, final long p2, final double p3);
    
    private static native void multiply_2(final long p0, final long p1, final long p2);
    
    private static native void multiply_3(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final double p6, final int p7);
    
    private static native void multiply_4(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final double p6);
    
    private static native void multiply_5(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    private static native double[] n_minMaxLocManual(final long p0, final long p1);
    
    public static double norm(final Mat mat) {
        return norm_5(mat.nativeObj);
    }
    
    public static double norm(final Mat mat, final int n) {
        return norm_4(mat.nativeObj, n);
    }
    
    public static double norm(final Mat mat, final int n, final Mat mat2) {
        return norm_3(mat.nativeObj, n, mat2.nativeObj);
    }
    
    public static double norm(final Mat mat, final Mat mat2) {
        return norm_2(mat.nativeObj, mat2.nativeObj);
    }
    
    public static double norm(final Mat mat, final Mat mat2, final int n) {
        return norm_1(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static double norm(final Mat mat, final Mat mat2, final int n, final Mat mat3) {
        return norm_0(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj);
    }
    
    private static native double norm_0(final long p0, final long p1, final int p2, final long p3);
    
    private static native double norm_1(final long p0, final long p1, final int p2);
    
    private static native double norm_2(final long p0, final long p1);
    
    private static native double norm_3(final long p0, final int p1, final long p2);
    
    private static native double norm_4(final long p0, final int p1);
    
    private static native double norm_5(final long p0);
    
    public static void normalize(final Mat mat, final Mat mat2) {
        normalize_3(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void normalize(final Mat mat, final Mat mat2, final double n, final double n2, final int n3) {
        normalize_2(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void normalize(final Mat mat, final Mat mat2, final double n, final double n2, final int n3, final int n4) {
        normalize_1(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4);
    }
    
    public static void normalize(final Mat mat, final Mat mat2, final double n, final double n2, final int n3, final int n4, final Mat mat3) {
        normalize_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, mat3.nativeObj);
    }
    
    private static native void normalize_0(final long p0, final long p1, final double p2, final double p3, final int p4, final int p5, final long p6);
    
    private static native void normalize_1(final long p0, final long p1, final double p2, final double p3, final int p4, final int p5);
    
    private static native void normalize_2(final long p0, final long p1, final double p2, final double p3, final int p4);
    
    private static native void normalize_3(final long p0, final long p1);
    
    public static void patchNaNs(final Mat mat) {
        patchNaNs_1(mat.nativeObj);
    }
    
    public static void patchNaNs(final Mat mat, final double n) {
        patchNaNs_0(mat.nativeObj, n);
    }
    
    private static native void patchNaNs_0(final long p0, final double p1);
    
    private static native void patchNaNs_1(final long p0);
    
    public static void perspectiveTransform(final Mat mat, final Mat mat2, final Mat mat3) {
        perspectiveTransform_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void perspectiveTransform_0(final long p0, final long p1, final long p2);
    
    public static void phase(final Mat mat, final Mat mat2, final Mat mat3) {
        phase_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void phase(final Mat mat, final Mat mat2, final Mat mat3, final boolean b) {
        phase_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, b);
    }
    
    private static native void phase_0(final long p0, final long p1, final long p2, final boolean p3);
    
    private static native void phase_1(final long p0, final long p1, final long p2);
    
    public static void polarToCart(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        polarToCart_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void polarToCart(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final boolean b) {
        polarToCart_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, b);
    }
    
    private static native void polarToCart_0(final long p0, final long p1, final long p2, final long p3, final boolean p4);
    
    private static native void polarToCart_1(final long p0, final long p1, final long p2, final long p3);
    
    public static void pow(final Mat mat, final double n, final Mat mat2) {
        pow_0(mat.nativeObj, n, mat2.nativeObj);
    }
    
    private static native void pow_0(final long p0, final double p1, final long p2);
    
    public static void randShuffle(final Mat mat) {
        randShuffle_1(mat.nativeObj);
    }
    
    public static void randShuffle(final Mat mat, final double n) {
        randShuffle_0(mat.nativeObj, n);
    }
    
    private static native void randShuffle_0(final long p0, final double p1);
    
    private static native void randShuffle_1(final long p0);
    
    public static void randn(final Mat mat, final double n, final double n2) {
        randn_0(mat.nativeObj, n, n2);
    }
    
    private static native void randn_0(final long p0, final double p1, final double p2);
    
    public static void randu(final Mat mat, final double n, final double n2) {
        randu_0(mat.nativeObj, n, n2);
    }
    
    private static native void randu_0(final long p0, final double p1, final double p2);
    
    public static void reduce(final Mat mat, final Mat mat2, final int n, final int n2) {
        reduce_1(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    public static void reduce(final Mat mat, final Mat mat2, final int n, final int n2, final int n3) {
        reduce_0(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    private static native void reduce_0(final long p0, final long p1, final int p2, final int p3, final int p4);
    
    private static native void reduce_1(final long p0, final long p1, final int p2, final int p3);
    
    public static void repeat(final Mat mat, final int n, final int n2, final Mat mat2) {
        repeat_0(mat.nativeObj, n, n2, mat2.nativeObj);
    }
    
    private static native void repeat_0(final long p0, final int p1, final int p2, final long p3);
    
    public static void scaleAdd(final Mat mat, final double n, final Mat mat2, final Mat mat3) {
        scaleAdd_0(mat.nativeObj, n, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void scaleAdd_0(final long p0, final double p1, final long p2, final long p3);
    
    public static void setErrorVerbosity(final boolean errorVerbosity_0) {
        setErrorVerbosity_0(errorVerbosity_0);
    }
    
    private static native void setErrorVerbosity_0(final boolean p0);
    
    public static void setIdentity(final Mat mat) {
        setIdentity_1(mat.nativeObj);
    }
    
    public static void setIdentity(final Mat mat, final Scalar scalar) {
        setIdentity_0(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    private static native void setIdentity_0(final long p0, final double p1, final double p2, final double p3, final double p4);
    
    private static native void setIdentity_1(final long p0);
    
    public static void setNumThreads(final int numThreads_0) {
        setNumThreads_0(numThreads_0);
    }
    
    private static native void setNumThreads_0(final int p0);
    
    public static boolean solve(final Mat mat, final Mat mat2, final Mat mat3) {
        return solve_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static boolean solve(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        return solve_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static int solveCubic(final Mat mat, final Mat mat2) {
        return solveCubic_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native int solveCubic_0(final long p0, final long p1);
    
    public static double solvePoly(final Mat mat, final Mat mat2) {
        return solvePoly_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static double solvePoly(final Mat mat, final Mat mat2, final int n) {
        return solvePoly_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native double solvePoly_0(final long p0, final long p1, final int p2);
    
    private static native double solvePoly_1(final long p0, final long p1);
    
    private static native boolean solve_0(final long p0, final long p1, final long p2, final int p3);
    
    private static native boolean solve_1(final long p0, final long p1, final long p2);
    
    public static void sort(final Mat mat, final Mat mat2, final int n) {
        sort_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static void sortIdx(final Mat mat, final Mat mat2, final int n) {
        sortIdx_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native void sortIdx_0(final long p0, final long p1, final int p2);
    
    private static native void sort_0(final long p0, final long p1, final int p2);
    
    public static void split(final Mat mat, final List<Mat> list) {
        final Mat mat2 = new Mat();
        split_0(mat.nativeObj, mat2.nativeObj);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
    }
    
    private static native void split_0(final long p0, final long p1);
    
    public static void sqrt(final Mat mat, final Mat mat2) {
        sqrt_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void sqrt_0(final long p0, final long p1);
    
    public static void subtract(final Mat mat, final Mat mat2, final Mat mat3) {
        subtract_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void subtract(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        subtract_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void subtract(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n) {
        subtract_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n);
    }
    
    public static void subtract(final Mat mat, final Scalar scalar, final Mat mat2) {
        subtract_5(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }
    
    public static void subtract(final Mat mat, final Scalar scalar, final Mat mat2, final Mat mat3) {
        subtract_4(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void subtract(final Mat mat, final Scalar scalar, final Mat mat2, final Mat mat3, final int n) {
        subtract_3(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj, mat3.nativeObj, n);
    }
    
    private static native void subtract_0(final long p0, final long p1, final long p2, final long p3, final int p4);
    
    private static native void subtract_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native void subtract_2(final long p0, final long p1, final long p2);
    
    private static native void subtract_3(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final long p6, final int p7);
    
    private static native void subtract_4(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final long p6);
    
    private static native void subtract_5(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    public static Scalar sumElems(final Mat mat) {
        return new Scalar(sumElems_0(mat.nativeObj));
    }
    
    private static native double[] sumElems_0(final long p0);
    
    public static Scalar trace(final Mat mat) {
        return new Scalar(trace_0(mat.nativeObj));
    }
    
    private static native double[] trace_0(final long p0);
    
    public static void transform(final Mat mat, final Mat mat2, final Mat mat3) {
        transform_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void transform_0(final long p0, final long p1, final long p2);
    
    public static void transpose(final Mat mat, final Mat mat2) {
        transpose_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void transpose_0(final long p0, final long p1);
    
    public static void vconcat(final List<Mat> list, final Mat mat) {
        vconcat_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }
    
    private static native void vconcat_0(final long p0, final long p1);
    
    public static class MinMaxLocResult
    {
        public Point maxLoc;
        public double maxVal;
        public Point minLoc;
        public double minVal;
        
        public MinMaxLocResult() {
            this.minVal = 0.0;
            this.maxVal = 0.0;
            this.minLoc = new Point();
            this.maxLoc = new Point();
        }
    }
}

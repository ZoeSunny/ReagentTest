package org.opencv.imgproc;

import org.opencv.utils.*;
import org.opencv.core.*;
import java.util.*;

public class Imgproc
{
    public static final int ADAPTIVE_THRESH_GAUSSIAN_C = 1;
    public static final int ADAPTIVE_THRESH_MEAN_C = 0;
    public static final int CC_STAT_AREA = 4;
    public static final int CC_STAT_HEIGHT = 3;
    public static final int CC_STAT_LEFT = 0;
    public static final int CC_STAT_MAX = 5;
    public static final int CC_STAT_TOP = 1;
    public static final int CC_STAT_WIDTH = 2;
    public static final int CHAIN_APPROX_NONE = 1;
    public static final int CHAIN_APPROX_SIMPLE = 2;
    public static final int CHAIN_APPROX_TC89_KCOS = 4;
    public static final int CHAIN_APPROX_TC89_L1 = 3;
    public static final int COLORMAP_AUTUMN = 0;
    public static final int COLORMAP_BONE = 1;
    public static final int COLORMAP_COOL = 8;
    public static final int COLORMAP_HOT = 11;
    public static final int COLORMAP_HSV = 9;
    public static final int COLORMAP_JET = 2;
    public static final int COLORMAP_OCEAN = 5;
    public static final int COLORMAP_PARULA = 12;
    public static final int COLORMAP_PINK = 10;
    public static final int COLORMAP_RAINBOW = 4;
    public static final int COLORMAP_SPRING = 7;
    public static final int COLORMAP_SUMMER = 6;
    public static final int COLORMAP_WINTER = 3;
    public static final int COLOR_BGR2BGR555 = 22;
    public static final int COLOR_BGR2BGR565 = 12;
    public static final int COLOR_BGR2BGRA = 0;
    public static final int COLOR_BGR2GRAY = 6;
    public static final int COLOR_BGR2HLS = 52;
    public static final int COLOR_BGR2HLS_FULL = 68;
    public static final int COLOR_BGR2HSV = 40;
    public static final int COLOR_BGR2HSV_FULL = 66;
    public static final int COLOR_BGR2Lab = 44;
    public static final int COLOR_BGR2Luv = 50;
    public static final int COLOR_BGR2RGB = 4;
    public static final int COLOR_BGR2RGBA = 2;
    public static final int COLOR_BGR2XYZ = 32;
    public static final int COLOR_BGR2YCrCb = 36;
    public static final int COLOR_BGR2YUV = 82;
    public static final int COLOR_BGR2YUV_I420 = 128;
    public static final int COLOR_BGR2YUV_IYUV = 128;
    public static final int COLOR_BGR2YUV_YV12 = 132;
    public static final int COLOR_BGR5552BGR = 24;
    public static final int COLOR_BGR5552BGRA = 28;
    public static final int COLOR_BGR5552GRAY = 31;
    public static final int COLOR_BGR5552RGB = 25;
    public static final int COLOR_BGR5552RGBA = 29;
    public static final int COLOR_BGR5652BGR = 14;
    public static final int COLOR_BGR5652BGRA = 18;
    public static final int COLOR_BGR5652GRAY = 21;
    public static final int COLOR_BGR5652RGB = 15;
    public static final int COLOR_BGR5652RGBA = 19;
    public static final int COLOR_BGRA2BGR = 1;
    public static final int COLOR_BGRA2BGR555 = 26;
    public static final int COLOR_BGRA2BGR565 = 16;
    public static final int COLOR_BGRA2GRAY = 10;
    public static final int COLOR_BGRA2RGB = 3;
    public static final int COLOR_BGRA2RGBA = 5;
    public static final int COLOR_BGRA2YUV_I420 = 130;
    public static final int COLOR_BGRA2YUV_IYUV = 130;
    public static final int COLOR_BGRA2YUV_YV12 = 134;
    public static final int COLOR_BayerBG2BGR = 46;
    public static final int COLOR_BayerBG2BGR_EA = 135;
    public static final int COLOR_BayerBG2BGR_VNG = 62;
    public static final int COLOR_BayerBG2GRAY = 86;
    public static final int COLOR_BayerBG2RGB = 48;
    public static final int COLOR_BayerBG2RGB_EA = 137;
    public static final int COLOR_BayerBG2RGB_VNG = 64;
    public static final int COLOR_BayerGB2BGR = 47;
    public static final int COLOR_BayerGB2BGR_EA = 136;
    public static final int COLOR_BayerGB2BGR_VNG = 63;
    public static final int COLOR_BayerGB2GRAY = 87;
    public static final int COLOR_BayerGB2RGB = 49;
    public static final int COLOR_BayerGB2RGB_EA = 138;
    public static final int COLOR_BayerGB2RGB_VNG = 65;
    public static final int COLOR_BayerGR2BGR = 49;
    public static final int COLOR_BayerGR2BGR_EA = 138;
    public static final int COLOR_BayerGR2BGR_VNG = 65;
    public static final int COLOR_BayerGR2GRAY = 89;
    public static final int COLOR_BayerGR2RGB = 47;
    public static final int COLOR_BayerGR2RGB_EA = 136;
    public static final int COLOR_BayerGR2RGB_VNG = 63;
    public static final int COLOR_BayerRG2BGR = 48;
    public static final int COLOR_BayerRG2BGR_EA = 137;
    public static final int COLOR_BayerRG2BGR_VNG = 64;
    public static final int COLOR_BayerRG2GRAY = 88;
    public static final int COLOR_BayerRG2RGB = 46;
    public static final int COLOR_BayerRG2RGB_EA = 135;
    public static final int COLOR_BayerRG2RGB_VNG = 62;
    public static final int COLOR_COLORCVT_MAX = 139;
    public static final int COLOR_GRAY2BGR = 8;
    public static final int COLOR_GRAY2BGR555 = 30;
    public static final int COLOR_GRAY2BGR565 = 20;
    public static final int COLOR_GRAY2BGRA = 9;
    public static final int COLOR_GRAY2RGB = 8;
    public static final int COLOR_GRAY2RGBA = 9;
    public static final int COLOR_HLS2BGR = 60;
    public static final int COLOR_HLS2BGR_FULL = 72;
    public static final int COLOR_HLS2RGB = 61;
    public static final int COLOR_HLS2RGB_FULL = 73;
    public static final int COLOR_HSV2BGR = 54;
    public static final int COLOR_HSV2BGR_FULL = 70;
    public static final int COLOR_HSV2RGB = 55;
    public static final int COLOR_HSV2RGB_FULL = 71;
    public static final int COLOR_LBGR2Lab = 74;
    public static final int COLOR_LBGR2Luv = 76;
    public static final int COLOR_LRGB2Lab = 75;
    public static final int COLOR_LRGB2Luv = 77;
    public static final int COLOR_Lab2BGR = 56;
    public static final int COLOR_Lab2LBGR = 78;
    public static final int COLOR_Lab2LRGB = 79;
    public static final int COLOR_Lab2RGB = 57;
    public static final int COLOR_Luv2BGR = 58;
    public static final int COLOR_Luv2LBGR = 80;
    public static final int COLOR_Luv2LRGB = 81;
    public static final int COLOR_Luv2RGB = 59;
    public static final int COLOR_RGB2BGR = 4;
    public static final int COLOR_RGB2BGR555 = 23;
    public static final int COLOR_RGB2BGR565 = 13;
    public static final int COLOR_RGB2BGRA = 2;
    public static final int COLOR_RGB2GRAY = 7;
    public static final int COLOR_RGB2HLS = 53;
    public static final int COLOR_RGB2HLS_FULL = 69;
    public static final int COLOR_RGB2HSV = 41;
    public static final int COLOR_RGB2HSV_FULL = 67;
    public static final int COLOR_RGB2Lab = 45;
    public static final int COLOR_RGB2Luv = 51;
    public static final int COLOR_RGB2RGBA = 0;
    public static final int COLOR_RGB2XYZ = 33;
    public static final int COLOR_RGB2YCrCb = 37;
    public static final int COLOR_RGB2YUV = 83;
    public static final int COLOR_RGB2YUV_I420 = 127;
    public static final int COLOR_RGB2YUV_IYUV = 127;
    public static final int COLOR_RGB2YUV_YV12 = 131;
    public static final int COLOR_RGBA2BGR = 3;
    public static final int COLOR_RGBA2BGR555 = 27;
    public static final int COLOR_RGBA2BGR565 = 17;
    public static final int COLOR_RGBA2BGRA = 5;
    public static final int COLOR_RGBA2GRAY = 11;
    public static final int COLOR_RGBA2RGB = 1;
    public static final int COLOR_RGBA2YUV_I420 = 129;
    public static final int COLOR_RGBA2YUV_IYUV = 129;
    public static final int COLOR_RGBA2YUV_YV12 = 133;
    public static final int COLOR_RGBA2mRGBA = 125;
    public static final int COLOR_XYZ2BGR = 34;
    public static final int COLOR_XYZ2RGB = 35;
    public static final int COLOR_YCrCb2BGR = 38;
    public static final int COLOR_YCrCb2RGB = 39;
    public static final int COLOR_YUV2BGR = 84;
    public static final int COLOR_YUV2BGRA_I420 = 105;
    public static final int COLOR_YUV2BGRA_IYUV = 105;
    public static final int COLOR_YUV2BGRA_NV12 = 95;
    public static final int COLOR_YUV2BGRA_NV21 = 97;
    public static final int COLOR_YUV2BGRA_UYNV = 112;
    public static final int COLOR_YUV2BGRA_UYVY = 112;
    public static final int COLOR_YUV2BGRA_Y422 = 112;
    public static final int COLOR_YUV2BGRA_YUNV = 120;
    public static final int COLOR_YUV2BGRA_YUY2 = 120;
    public static final int COLOR_YUV2BGRA_YUYV = 120;
    public static final int COLOR_YUV2BGRA_YV12 = 103;
    public static final int COLOR_YUV2BGRA_YVYU = 122;
    public static final int COLOR_YUV2BGR_I420 = 101;
    public static final int COLOR_YUV2BGR_IYUV = 101;
    public static final int COLOR_YUV2BGR_NV12 = 91;
    public static final int COLOR_YUV2BGR_NV21 = 93;
    public static final int COLOR_YUV2BGR_UYNV = 108;
    public static final int COLOR_YUV2BGR_UYVY = 108;
    public static final int COLOR_YUV2BGR_Y422 = 108;
    public static final int COLOR_YUV2BGR_YUNV = 116;
    public static final int COLOR_YUV2BGR_YUY2 = 116;
    public static final int COLOR_YUV2BGR_YUYV = 116;
    public static final int COLOR_YUV2BGR_YV12 = 99;
    public static final int COLOR_YUV2BGR_YVYU = 118;
    public static final int COLOR_YUV2GRAY_420 = 106;
    public static final int COLOR_YUV2GRAY_I420 = 106;
    public static final int COLOR_YUV2GRAY_IYUV = 106;
    public static final int COLOR_YUV2GRAY_NV12 = 106;
    public static final int COLOR_YUV2GRAY_NV21 = 106;
    public static final int COLOR_YUV2GRAY_UYNV = 123;
    public static final int COLOR_YUV2GRAY_UYVY = 123;
    public static final int COLOR_YUV2GRAY_Y422 = 123;
    public static final int COLOR_YUV2GRAY_YUNV = 124;
    public static final int COLOR_YUV2GRAY_YUY2 = 124;
    public static final int COLOR_YUV2GRAY_YUYV = 124;
    public static final int COLOR_YUV2GRAY_YV12 = 106;
    public static final int COLOR_YUV2GRAY_YVYU = 124;
    public static final int COLOR_YUV2RGB = 85;
    public static final int COLOR_YUV2RGBA_I420 = 104;
    public static final int COLOR_YUV2RGBA_IYUV = 104;
    public static final int COLOR_YUV2RGBA_NV12 = 94;
    public static final int COLOR_YUV2RGBA_NV21 = 96;
    public static final int COLOR_YUV2RGBA_UYNV = 111;
    public static final int COLOR_YUV2RGBA_UYVY = 111;
    public static final int COLOR_YUV2RGBA_Y422 = 111;
    public static final int COLOR_YUV2RGBA_YUNV = 119;
    public static final int COLOR_YUV2RGBA_YUY2 = 119;
    public static final int COLOR_YUV2RGBA_YUYV = 119;
    public static final int COLOR_YUV2RGBA_YV12 = 102;
    public static final int COLOR_YUV2RGBA_YVYU = 121;
    public static final int COLOR_YUV2RGB_I420 = 100;
    public static final int COLOR_YUV2RGB_IYUV = 100;
    public static final int COLOR_YUV2RGB_NV12 = 90;
    public static final int COLOR_YUV2RGB_NV21 = 92;
    public static final int COLOR_YUV2RGB_UYNV = 107;
    public static final int COLOR_YUV2RGB_UYVY = 107;
    public static final int COLOR_YUV2RGB_Y422 = 107;
    public static final int COLOR_YUV2RGB_YUNV = 115;
    public static final int COLOR_YUV2RGB_YUY2 = 115;
    public static final int COLOR_YUV2RGB_YUYV = 115;
    public static final int COLOR_YUV2RGB_YV12 = 98;
    public static final int COLOR_YUV2RGB_YVYU = 117;
    public static final int COLOR_YUV420p2BGR = 99;
    public static final int COLOR_YUV420p2BGRA = 103;
    public static final int COLOR_YUV420p2GRAY = 106;
    public static final int COLOR_YUV420p2RGB = 98;
    public static final int COLOR_YUV420p2RGBA = 102;
    public static final int COLOR_YUV420sp2BGR = 93;
    public static final int COLOR_YUV420sp2BGRA = 97;
    public static final int COLOR_YUV420sp2GRAY = 106;
    public static final int COLOR_YUV420sp2RGB = 92;
    public static final int COLOR_YUV420sp2RGBA = 96;
    public static final int COLOR_mRGBA2RGBA = 126;
    public static final int CV_BILATERAL = 4;
    public static final int CV_BLUR = 1;
    public static final int CV_BLUR_NO_SCALE = 0;
    public static final int CV_CANNY_L2_GRADIENT = Integer.MIN_VALUE;
    private static final int CV_CHAIN_APPROX_NONE = 1;
    private static final int CV_CHAIN_APPROX_SIMPLE = 2;
    private static final int CV_CHAIN_APPROX_TC89_KCOS = 4;
    private static final int CV_CHAIN_APPROX_TC89_L1 = 3;
    public static final int CV_CHAIN_CODE = 0;
    public static final int CV_CLOCKWISE = 1;
    public static final int CV_COMP_BHATTACHARYYA = 3;
    public static final int CV_COMP_CHISQR = 1;
    public static final int CV_COMP_CHISQR_ALT = 4;
    public static final int CV_COMP_CORREL = 0;
    public static final int CV_COMP_HELLINGER = 3;
    public static final int CV_COMP_INTERSECT = 2;
    public static final int CV_COMP_KL_DIV = 5;
    public static final int CV_CONTOURS_MATCH_I1 = 1;
    public static final int CV_CONTOURS_MATCH_I2 = 2;
    public static final int CV_CONTOURS_MATCH_I3 = 3;
    public static final int CV_COUNTER_CLOCKWISE = 2;
    public static final int CV_DIST_C = 3;
    public static final int CV_DIST_FAIR = 5;
    public static final int CV_DIST_HUBER = 7;
    public static final int CV_DIST_L1 = 1;
    public static final int CV_DIST_L12 = 4;
    public static final int CV_DIST_L2 = 2;
    public static final int CV_DIST_LABEL_CCOMP = 0;
    public static final int CV_DIST_LABEL_PIXEL = 1;
    public static final int CV_DIST_MASK_3 = 3;
    public static final int CV_DIST_MASK_5 = 5;
    public static final int CV_DIST_MASK_PRECISE = 0;
    public static final int CV_DIST_USER = -1;
    public static final int CV_DIST_WELSCH = 6;
    public static final int CV_GAUSSIAN = 2;
    public static final int CV_GAUSSIAN_5x5 = 7;
    public static final int CV_HOUGH_GRADIENT = 3;
    public static final int CV_HOUGH_MULTI_SCALE = 2;
    public static final int CV_HOUGH_PROBABILISTIC = 1;
    public static final int CV_HOUGH_STANDARD = 0;
    private static final int CV_INTER_AREA = 3;
    private static final int CV_INTER_CUBIC = 2;
    private static final int CV_INTER_LANCZOS4 = 4;
    private static final int CV_INTER_LINEAR = 1;
    private static final int CV_INTER_NN = 0;
    public static final int CV_LINK_RUNS = 5;
    public static final int CV_MAX_SOBEL_KSIZE = 7;
    public static final int CV_MEDIAN = 3;
    private static final int CV_MOP_BLACKHAT = 6;
    private static final int CV_MOP_CLOSE = 3;
    private static final int CV_MOP_DILATE = 1;
    private static final int CV_MOP_ERODE = 0;
    private static final int CV_MOP_GRADIENT = 4;
    private static final int CV_MOP_OPEN = 2;
    private static final int CV_MOP_TOPHAT = 5;
    public static final int CV_POLY_APPROX_DP = 0;
    private static final int CV_RETR_CCOMP = 2;
    private static final int CV_RETR_EXTERNAL = 0;
    private static final int CV_RETR_FLOODFILL = 4;
    private static final int CV_RETR_LIST = 1;
    private static final int CV_RETR_TREE = 3;
    public static final int CV_RGBA2mRGBA = 125;
    public static final int CV_SCHARR = -1;
    public static final int CV_SHAPE_CROSS = 1;
    public static final int CV_SHAPE_CUSTOM = 100;
    public static final int CV_SHAPE_ELLIPSE = 2;
    public static final int CV_SHAPE_RECT = 0;
    private static final int CV_THRESH_BINARY = 0;
    private static final int CV_THRESH_BINARY_INV = 1;
    private static final int CV_THRESH_MASK = 7;
    private static final int CV_THRESH_OTSU = 8;
    private static final int CV_THRESH_TOZERO = 3;
    private static final int CV_THRESH_TOZERO_INV = 4;
    private static final int CV_THRESH_TRIANGLE = 16;
    private static final int CV_THRESH_TRUNC = 2;
    public static final int CV_WARP_FILL_OUTLIERS = 8;
    public static final int CV_WARP_INVERSE_MAP = 16;
    public static final int CV_mRGBA2RGBA = 126;
    public static final int DIST_C = 3;
    public static final int DIST_FAIR = 5;
    public static final int DIST_HUBER = 7;
    public static final int DIST_L1 = 1;
    public static final int DIST_L12 = 4;
    public static final int DIST_L2 = 2;
    public static final int DIST_LABEL_CCOMP = 0;
    public static final int DIST_LABEL_PIXEL = 1;
    public static final int DIST_MASK_3 = 3;
    public static final int DIST_MASK_5 = 5;
    public static final int DIST_MASK_PRECISE = 0;
    public static final int DIST_USER = -1;
    public static final int DIST_WELSCH = 6;
    public static final int FLOODFILL_FIXED_RANGE = 65536;
    public static final int FLOODFILL_MASK_ONLY = 131072;
    public static final int GC_BGD = 0;
    public static final int GC_EVAL = 2;
    public static final int GC_FGD = 1;
    public static final int GC_INIT_WITH_MASK = 1;
    public static final int GC_INIT_WITH_RECT = 0;
    public static final int GC_PR_BGD = 2;
    public static final int GC_PR_FGD = 3;
    public static final int HISTCMP_BHATTACHARYYA = 3;
    public static final int HISTCMP_CHISQR = 1;
    public static final int HISTCMP_CHISQR_ALT = 4;
    public static final int HISTCMP_CORREL = 0;
    public static final int HISTCMP_HELLINGER = 3;
    public static final int HISTCMP_INTERSECT = 2;
    public static final int HISTCMP_KL_DIV = 5;
    public static final int HOUGH_GRADIENT = 3;
    public static final int HOUGH_MULTI_SCALE = 2;
    public static final int HOUGH_PROBABILISTIC = 1;
    public static final int HOUGH_STANDARD = 0;
    public static final int INTERSECT_FULL = 2;
    public static final int INTERSECT_NONE = 0;
    public static final int INTERSECT_PARTIAL = 1;
    public static final int INTER_AREA = 3;
    public static final int INTER_BITS = 5;
    public static final int INTER_BITS2 = 10;
    public static final int INTER_CUBIC = 2;
    public static final int INTER_LANCZOS4 = 4;
    public static final int INTER_LINEAR = 1;
    public static final int INTER_MAX = 7;
    public static final int INTER_NEAREST = 0;
    public static final int INTER_TAB_SIZE = 32;
    public static final int INTER_TAB_SIZE2 = 1024;
    private static final int IPL_BORDER_CONSTANT = 0;
    private static final int IPL_BORDER_REFLECT = 2;
    private static final int IPL_BORDER_REFLECT_101 = 4;
    private static final int IPL_BORDER_REPLICATE = 1;
    private static final int IPL_BORDER_TRANSPARENT = 5;
    private static final int IPL_BORDER_WRAP = 3;
    public static final int LINE_4 = 4;
    public static final int LINE_8 = 8;
    public static final int LINE_AA = 16;
    public static final int LSD_REFINE_ADV = 2;
    public static final int LSD_REFINE_NONE = 0;
    public static final int LSD_REFINE_STD = 1;
    public static final int MARKER_CROSS = 0;
    public static final int MARKER_DIAMOND = 3;
    public static final int MARKER_SQUARE = 4;
    public static final int MARKER_STAR = 2;
    public static final int MARKER_TILTED_CROSS = 1;
    public static final int MARKER_TRIANGLE_DOWN = 6;
    public static final int MARKER_TRIANGLE_UP = 5;
    public static final int MORPH_BLACKHAT = 6;
    public static final int MORPH_CLOSE = 3;
    public static final int MORPH_CROSS = 1;
    public static final int MORPH_DILATE = 1;
    public static final int MORPH_ELLIPSE = 2;
    public static final int MORPH_ERODE = 0;
    public static final int MORPH_GRADIENT = 4;
    public static final int MORPH_HITMISS = 7;
    public static final int MORPH_OPEN = 2;
    public static final int MORPH_RECT = 0;
    public static final int MORPH_TOPHAT = 5;
    public static final int PROJ_SPHERICAL_EQRECT = 1;
    public static final int PROJ_SPHERICAL_ORTHO = 0;
    public static final int RETR_CCOMP = 2;
    public static final int RETR_EXTERNAL = 0;
    public static final int RETR_FLOODFILL = 4;
    public static final int RETR_LIST = 1;
    public static final int RETR_TREE = 3;
    public static final int THRESH_BINARY = 0;
    public static final int THRESH_BINARY_INV = 1;
    public static final int THRESH_MASK = 7;
    public static final int THRESH_OTSU = 8;
    public static final int THRESH_TOZERO = 3;
    public static final int THRESH_TOZERO_INV = 4;
    public static final int THRESH_TRIANGLE = 16;
    public static final int THRESH_TRUNC = 2;
    public static final int TM_CCOEFF = 4;
    public static final int TM_CCOEFF_NORMED = 5;
    public static final int TM_CCORR = 2;
    public static final int TM_CCORR_NORMED = 3;
    public static final int TM_SQDIFF = 0;
    public static final int TM_SQDIFF_NORMED = 1;
    public static final int WARP_FILL_OUTLIERS = 8;
    public static final int WARP_INVERSE_MAP = 16;
    
    public static void Canny(final Mat mat, final Mat mat2, final double n, final double n2) {
        Canny_1(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    public static void Canny(final Mat mat, final Mat mat2, final double n, final double n2, final int n3, final boolean b) {
        Canny_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, b);
    }
    
    private static native void Canny_0(final long p0, final long p1, final double p2, final double p3, final int p4, final boolean p5);
    
    private static native void Canny_1(final long p0, final long p1, final double p2, final double p3);
    
    public static void GaussianBlur(final Mat mat, final Mat mat2, final Size size, final double n) {
        GaussianBlur_2(mat.nativeObj, mat2.nativeObj, size.width, size.height, n);
    }
    
    public static void GaussianBlur(final Mat mat, final Mat mat2, final Size size, final double n, final double n2) {
        GaussianBlur_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, n, n2);
    }
    
    public static void GaussianBlur(final Mat mat, final Mat mat2, final Size size, final double n, final double n2, final int n3) {
        GaussianBlur_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, n, n2, n3);
    }
    
    private static native void GaussianBlur_0(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final int p6);
    
    private static native void GaussianBlur_1(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5);
    
    private static native void GaussianBlur_2(final long p0, final long p1, final double p2, final double p3, final double p4);
    
    public static void HoughCircles(final Mat mat, final Mat mat2, final int n, final double n2, final double n3) {
        HoughCircles_1(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void HoughCircles(final Mat mat, final Mat mat2, final int n, final double n2, final double n3, final double n4, final double n5, final int n6, final int n7) {
        HoughCircles_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5, n6, n7);
    }
    
    private static native void HoughCircles_0(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5, final double p6, final int p7, final int p8);
    
    private static native void HoughCircles_1(final long p0, final long p1, final int p2, final double p3, final double p4);
    
    public static void HoughLines(final Mat mat, final Mat mat2, final double n, final double n2, final int n3) {
        HoughLines_1(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void HoughLines(final Mat mat, final Mat mat2, final double n, final double n2, final int n3, final double n4, final double n5, final double n6, final double n7) {
        HoughLines_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5, n6, n7);
    }
    
    public static void HoughLinesP(final Mat mat, final Mat mat2, final double n, final double n2, final int n3) {
        HoughLinesP_1(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void HoughLinesP(final Mat mat, final Mat mat2, final double n, final double n2, final int n3, final double n4, final double n5) {
        HoughLinesP_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5);
    }
    
    private static native void HoughLinesP_0(final long p0, final long p1, final double p2, final double p3, final int p4, final double p5, final double p6);
    
    private static native void HoughLinesP_1(final long p0, final long p1, final double p2, final double p3, final int p4);
    
    private static native void HoughLines_0(final long p0, final long p1, final double p2, final double p3, final int p4, final double p5, final double p6, final double p7, final double p8);
    
    private static native void HoughLines_1(final long p0, final long p1, final double p2, final double p3, final int p4);
    
    public static void HuMoments(final Moments moments, final Mat mat) {
        HuMoments_0(moments.m00, moments.m10, moments.m01, moments.m20, moments.m11, moments.m02, moments.m30, moments.m21, moments.m12, moments.m03, mat.nativeObj);
    }
    
    private static native void HuMoments_0(final double p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9, final long p10);
    
    public static void Laplacian(final Mat mat, final Mat mat2, final int n) {
        Laplacian_2(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static void Laplacian(final Mat mat, final Mat mat2, final int n, final int n2, final double n3, final double n4) {
        Laplacian_1(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4);
    }
    
    public static void Laplacian(final Mat mat, final Mat mat2, final int n, final int n2, final double n3, final double n4, final int n5) {
        Laplacian_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5);
    }
    
    private static native void Laplacian_0(final long p0, final long p1, final int p2, final int p3, final double p4, final double p5, final int p6);
    
    private static native void Laplacian_1(final long p0, final long p1, final int p2, final int p3, final double p4, final double p5);
    
    private static native void Laplacian_2(final long p0, final long p1, final int p2);
    
    public static void Scharr(final Mat mat, final Mat mat2, final int n, final int n2, final int n3) {
        Scharr_2(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void Scharr(final Mat mat, final Mat mat2, final int n, final int n2, final int n3, final double n4, final double n5) {
        Scharr_1(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5);
    }
    
    public static void Scharr(final Mat mat, final Mat mat2, final int n, final int n2, final int n3, final double n4, final double n5, final int n6) {
        Scharr_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5, n6);
    }
    
    private static native void Scharr_0(final long p0, final long p1, final int p2, final int p3, final int p4, final double p5, final double p6, final int p7);
    
    private static native void Scharr_1(final long p0, final long p1, final int p2, final int p3, final int p4, final double p5, final double p6);
    
    private static native void Scharr_2(final long p0, final long p1, final int p2, final int p3, final int p4);
    
    public static void Sobel(final Mat mat, final Mat mat2, final int n, final int n2, final int n3) {
        Sobel_2(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void Sobel(final Mat mat, final Mat mat2, final int n, final int n2, final int n3, final int n4, final double n5, final double n6) {
        Sobel_1(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5, n6);
    }
    
    public static void Sobel(final Mat mat, final Mat mat2, final int n, final int n2, final int n3, final int n4, final double n5, final double n6, final int n7) {
        Sobel_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5, n6, n7);
    }
    
    private static native void Sobel_0(final long p0, final long p1, final int p2, final int p3, final int p4, final int p5, final double p6, final double p7, final int p8);
    
    private static native void Sobel_1(final long p0, final long p1, final int p2, final int p3, final int p4, final int p5, final double p6, final double p7);
    
    private static native void Sobel_2(final long p0, final long p1, final int p2, final int p3, final int p4);
    
    public static void accumulate(final Mat mat, final Mat mat2) {
        accumulate_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void accumulate(final Mat mat, final Mat mat2, final Mat mat3) {
        accumulate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void accumulateProduct(final Mat mat, final Mat mat2, final Mat mat3) {
        accumulateProduct_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void accumulateProduct(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        accumulateProduct_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void accumulateProduct_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void accumulateProduct_1(final long p0, final long p1, final long p2);
    
    public static void accumulateSquare(final Mat mat, final Mat mat2) {
        accumulateSquare_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void accumulateSquare(final Mat mat, final Mat mat2, final Mat mat3) {
        accumulateSquare_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void accumulateSquare_0(final long p0, final long p1, final long p2);
    
    private static native void accumulateSquare_1(final long p0, final long p1);
    
    public static void accumulateWeighted(final Mat mat, final Mat mat2, final double n) {
        accumulateWeighted_1(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static void accumulateWeighted(final Mat mat, final Mat mat2, final double n, final Mat mat3) {
        accumulateWeighted_0(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj);
    }
    
    private static native void accumulateWeighted_0(final long p0, final long p1, final double p2, final long p3);
    
    private static native void accumulateWeighted_1(final long p0, final long p1, final double p2);
    
    private static native void accumulate_0(final long p0, final long p1, final long p2);
    
    private static native void accumulate_1(final long p0, final long p1);
    
    public static void adaptiveThreshold(final Mat mat, final Mat mat2, final double n, final int n2, final int n3, final int n4, final double n5) {
        adaptiveThreshold_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4, n5);
    }
    
    private static native void adaptiveThreshold_0(final long p0, final long p1, final double p2, final int p3, final int p4, final int p5, final double p6);
    
    public static void applyColorMap(final Mat mat, final Mat mat2, final int n) {
        applyColorMap_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native void applyColorMap_0(final long p0, final long p1, final int p2);
    
    public static void approxPolyDP(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final double n, final boolean b) {
        approxPolyDP_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, n, b);
    }
    
    private static native void approxPolyDP_0(final long p0, final long p1, final double p2, final boolean p3);
    
    public static double arcLength(final MatOfPoint2f matOfPoint2f, final boolean b) {
        return arcLength_0(matOfPoint2f.nativeObj, b);
    }
    
    private static native double arcLength_0(final long p0, final boolean p1);
    
    public static void arrowedLine(final Mat mat, final Point point, final Point point2, final Scalar scalar) {
        arrowedLine_1(mat.nativeObj, point.x, point.y, point2.x, point2.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void arrowedLine(final Mat mat, final Point point, final Point point2, final Scalar scalar, final int n, final int n2, final int n3, final double n4) {
        arrowedLine_0(mat.nativeObj, point.x, point.y, point2.x, point2.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n, n2, n3, n4);
    }
    
    private static native void arrowedLine_0(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final int p9, final int p10, final int p11, final double p12);
    
    private static native void arrowedLine_1(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8);
    
    public static void bilateralFilter(final Mat mat, final Mat mat2, final int n, final double n2, final double n3) {
        bilateralFilter_1(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void bilateralFilter(final Mat mat, final Mat mat2, final int n, final double n2, final double n3, final int n4) {
        bilateralFilter_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4);
    }
    
    private static native void bilateralFilter_0(final long p0, final long p1, final int p2, final double p3, final double p4, final int p5);
    
    private static native void bilateralFilter_1(final long p0, final long p1, final int p2, final double p3, final double p4);
    
    public static void blur(final Mat mat, final Mat mat2, final Size size) {
        blur_2(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }
    
    public static void blur(final Mat mat, final Mat mat2, final Size size, final Point point) {
        blur_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, point.x, point.y);
    }
    
    public static void blur(final Mat mat, final Mat mat2, final Size size, final Point point, final int n) {
        blur_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, point.x, point.y, n);
    }
    
    private static native void blur_0(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final int p6);
    
    private static native void blur_1(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5);
    
    private static native void blur_2(final long p0, final long p1, final double p2, final double p3);
    
    public static Rect boundingRect(final MatOfPoint matOfPoint) {
        return new Rect(boundingRect_0(matOfPoint.nativeObj));
    }
    
    private static native double[] boundingRect_0(final long p0);
    
    public static void boxFilter(final Mat mat, final Mat mat2, final int n, final Size size) {
        boxFilter_2(mat.nativeObj, mat2.nativeObj, n, size.width, size.height);
    }
    
    public static void boxFilter(final Mat mat, final Mat mat2, final int n, final Size size, final Point point, final boolean b) {
        boxFilter_1(mat.nativeObj, mat2.nativeObj, n, size.width, size.height, point.x, point.y, b);
    }
    
    public static void boxFilter(final Mat mat, final Mat mat2, final int n, final Size size, final Point point, final boolean b, final int n2) {
        boxFilter_0(mat.nativeObj, mat2.nativeObj, n, size.width, size.height, point.x, point.y, b, n2);
    }
    
    private static native void boxFilter_0(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5, final double p6, final boolean p7, final int p8);
    
    private static native void boxFilter_1(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5, final double p6, final boolean p7);
    
    private static native void boxFilter_2(final long p0, final long p1, final int p2, final double p3, final double p4);
    
    public static void boxPoints(final RotatedRect rotatedRect, final Mat mat) {
        boxPoints_0(rotatedRect.center.x, rotatedRect.center.y, rotatedRect.size.width, rotatedRect.size.height, rotatedRect.angle, mat.nativeObj);
    }
    
    private static native void boxPoints_0(final double p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    public static void calcBackProject(final List<Mat> list, final MatOfInt matOfInt, final Mat mat, final Mat mat2, final MatOfFloat matOfFloat, final double n) {
        calcBackProject_0(Converters.vector_Mat_to_Mat(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, n);
    }
    
    private static native void calcBackProject_0(final long p0, final long p1, final long p2, final long p3, final long p4, final double p5);
    
    public static void calcHist(final List<Mat> list, final MatOfInt matOfInt, final Mat mat, final Mat mat2, final MatOfInt matOfInt2, final MatOfFloat matOfFloat) {
        calcHist_1(Converters.vector_Mat_to_Mat(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfInt2.nativeObj, matOfFloat.nativeObj);
    }
    
    public static void calcHist(final List<Mat> list, final MatOfInt matOfInt, final Mat mat, final Mat mat2, final MatOfInt matOfInt2, final MatOfFloat matOfFloat, final boolean b) {
        calcHist_0(Converters.vector_Mat_to_Mat(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfInt2.nativeObj, matOfFloat.nativeObj, b);
    }
    
    private static native void calcHist_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final boolean p6);
    
    private static native void calcHist_1(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    public static void circle(final Mat mat, final Point point, final int n, final Scalar scalar) {
        circle_2(mat.nativeObj, point.x, point.y, n, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void circle(final Mat mat, final Point point, final int n, final Scalar scalar, final int n2) {
        circle_1(mat.nativeObj, point.x, point.y, n, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n2);
    }
    
    public static void circle(final Mat mat, final Point point, final int n, final Scalar scalar, final int n2, final int n3, final int n4) {
        circle_0(mat.nativeObj, point.x, point.y, n, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n2, n3, n4);
    }
    
    private static native void circle_0(final long p0, final double p1, final double p2, final int p3, final double p4, final double p5, final double p6, final double p7, final int p8, final int p9, final int p10);
    
    private static native void circle_1(final long p0, final double p1, final double p2, final int p3, final double p4, final double p5, final double p6, final double p7, final int p8);
    
    private static native void circle_2(final long p0, final double p1, final double p2, final int p3, final double p4, final double p5, final double p6, final double p7);
    
    public static boolean clipLine(final Rect rect, final Point point, final Point point2) {
        final double[] array = new double[2];
        final double[] array2 = new double[2];
        final boolean clipLine_0 = clipLine_0(rect.x, rect.y, rect.width, rect.height, point.x, point.y, array, point2.x, point2.y, array2);
        if (point != null) {
            point.x = array[0];
            point.y = array[1];
        }
        if (point2 != null) {
            point2.x = array2[0];
            point2.y = array2[1];
        }
        return clipLine_0;
    }
    
    private static native boolean clipLine_0(final int p0, final int p1, final int p2, final int p3, final double p4, final double p5, final double[] p6, final double p7, final double p8, final double[] p9);
    
    public static double compareHist(final Mat mat, final Mat mat2, final int n) {
        return compareHist_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native double compareHist_0(final long p0, final long p1, final int p2);
    
    public static int connectedComponents(final Mat mat, final Mat mat2) {
        return connectedComponents_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static int connectedComponents(final Mat mat, final Mat mat2, final int n, final int n2) {
        return connectedComponents_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    public static int connectedComponentsWithStats(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        return connectedComponentsWithStats_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static int connectedComponentsWithStats(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n, final int n2) {
        return connectedComponentsWithStats_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n, n2);
    }
    
    private static native int connectedComponentsWithStats_0(final long p0, final long p1, final long p2, final long p3, final int p4, final int p5);
    
    private static native int connectedComponentsWithStats_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native int connectedComponents_0(final long p0, final long p1, final int p2, final int p3);
    
    private static native int connectedComponents_1(final long p0, final long p1);
    
    public static double contourArea(final Mat mat) {
        return contourArea_1(mat.nativeObj);
    }
    
    public static double contourArea(final Mat mat, final boolean b) {
        return contourArea_0(mat.nativeObj, b);
    }
    
    private static native double contourArea_0(final long p0, final boolean p1);
    
    private static native double contourArea_1(final long p0);
    
    public static void convertMaps(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n) {
        convertMaps_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n);
    }
    
    public static void convertMaps(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n, final boolean b) {
        convertMaps_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n, b);
    }
    
    private static native void convertMaps_0(final long p0, final long p1, final long p2, final long p3, final int p4, final boolean p5);
    
    private static native void convertMaps_1(final long p0, final long p1, final long p2, final long p3, final int p4);
    
    public static void convexHull(final MatOfPoint matOfPoint, final MatOfInt matOfInt) {
        convexHull_1(matOfPoint.nativeObj, matOfInt.nativeObj);
    }
    
    public static void convexHull(final MatOfPoint matOfPoint, final MatOfInt matOfInt, final boolean b) {
        convexHull_0(matOfPoint.nativeObj, matOfInt.nativeObj, b);
    }
    
    private static native void convexHull_0(final long p0, final long p1, final boolean p2);
    
    private static native void convexHull_1(final long p0, final long p1);
    
    public static void convexityDefects(final MatOfPoint matOfPoint, final MatOfInt matOfInt, final MatOfInt4 matOfInt2) {
        convexityDefects_0(matOfPoint.nativeObj, matOfInt.nativeObj, matOfInt2.nativeObj);
    }
    
    private static native void convexityDefects_0(final long p0, final long p1, final long p2);
    
    public static void cornerEigenValsAndVecs(final Mat mat, final Mat mat2, final int n, final int n2) {
        cornerEigenValsAndVecs_1(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    public static void cornerEigenValsAndVecs(final Mat mat, final Mat mat2, final int n, final int n2, final int n3) {
        cornerEigenValsAndVecs_0(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    private static native void cornerEigenValsAndVecs_0(final long p0, final long p1, final int p2, final int p3, final int p4);
    
    private static native void cornerEigenValsAndVecs_1(final long p0, final long p1, final int p2, final int p3);
    
    public static void cornerHarris(final Mat mat, final Mat mat2, final int n, final int n2, final double n3) {
        cornerHarris_1(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void cornerHarris(final Mat mat, final Mat mat2, final int n, final int n2, final double n3, final int n4) {
        cornerHarris_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4);
    }
    
    private static native void cornerHarris_0(final long p0, final long p1, final int p2, final int p3, final double p4, final int p5);
    
    private static native void cornerHarris_1(final long p0, final long p1, final int p2, final int p3, final double p4);
    
    public static void cornerMinEigenVal(final Mat mat, final Mat mat2, final int n) {
        cornerMinEigenVal_2(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static void cornerMinEigenVal(final Mat mat, final Mat mat2, final int n, final int n2) {
        cornerMinEigenVal_1(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    public static void cornerMinEigenVal(final Mat mat, final Mat mat2, final int n, final int n2, final int n3) {
        cornerMinEigenVal_0(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    private static native void cornerMinEigenVal_0(final long p0, final long p1, final int p2, final int p3, final int p4);
    
    private static native void cornerMinEigenVal_1(final long p0, final long p1, final int p2, final int p3);
    
    private static native void cornerMinEigenVal_2(final long p0, final long p1, final int p2);
    
    public static void cornerSubPix(final Mat mat, final MatOfPoint2f matOfPoint2f, final Size size, final Size size2, final TermCriteria termCriteria) {
        cornerSubPix_0(mat.nativeObj, matOfPoint2f.nativeObj, size.width, size.height, size2.width, size2.height, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
    
    private static native void cornerSubPix_0(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final int p6, final int p7, final double p8);
    
    public static CLAHE createCLAHE() {
        return new CLAHE(createCLAHE_1());
    }
    
    public static CLAHE createCLAHE(final double n, final Size size) {
        return new CLAHE(createCLAHE_0(n, size.width, size.height));
    }
    
    private static native long createCLAHE_0(final double p0, final double p1, final double p2);
    
    private static native long createCLAHE_1();
    
    public static void createHanningWindow(final Mat mat, final Size size, final int n) {
        createHanningWindow_0(mat.nativeObj, size.width, size.height, n);
    }
    
    private static native void createHanningWindow_0(final long p0, final double p1, final double p2, final int p3);
    
    public static LineSegmentDetector createLineSegmentDetector() {
        return new LineSegmentDetector(createLineSegmentDetector_1());
    }
    
    public static LineSegmentDetector createLineSegmentDetector(final int n, final double n2, final double n3, final double n4, final double n5, final double n6, final double n7, final int n8) {
        return new LineSegmentDetector(createLineSegmentDetector_0(n, n2, n3, n4, n5, n6, n7, n8));
    }
    
    private static native long createLineSegmentDetector_0(final int p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final int p7);
    
    private static native long createLineSegmentDetector_1();
    
    public static void cvtColor(final Mat mat, final Mat mat2, final int n) {
        cvtColor_1(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static void cvtColor(final Mat mat, final Mat mat2, final int n, final int n2) {
        cvtColor_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native void cvtColor_0(final long p0, final long p1, final int p2, final int p3);
    
    private static native void cvtColor_1(final long p0, final long p1, final int p2);
    
    public static void demosaicing(final Mat mat, final Mat mat2, final int n) {
        demosaicing_1(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static void demosaicing(final Mat mat, final Mat mat2, final int n, final int n2) {
        demosaicing_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native void demosaicing_0(final long p0, final long p1, final int p2, final int p3);
    
    private static native void demosaicing_1(final long p0, final long p1, final int p2);
    
    public static void dilate(final Mat mat, final Mat mat2, final Mat mat3) {
        dilate_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void dilate(final Mat mat, final Mat mat2, final Mat mat3, final Point point, final int n) {
        dilate_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y, n);
    }
    
    public static void dilate(final Mat mat, final Mat mat2, final Mat mat3, final Point point, final int n, final int n2, final Scalar scalar) {
        dilate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y, n, n2, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    private static native void dilate_0(final long p0, final long p1, final long p2, final double p3, final double p4, final int p5, final int p6, final double p7, final double p8, final double p9, final double p10);
    
    private static native void dilate_1(final long p0, final long p1, final long p2, final double p3, final double p4, final int p5);
    
    private static native void dilate_2(final long p0, final long p1, final long p2);
    
    public static void distanceTransform(final Mat mat, final Mat mat2, final int n, final int n2) {
        distanceTransform_1(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    public static void distanceTransform(final Mat mat, final Mat mat2, final int n, final int n2, final int n3) {
        distanceTransform_0(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void distanceTransformWithLabels(final Mat mat, final Mat mat2, final Mat mat3, final int n, final int n2) {
        distanceTransformWithLabels_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2);
    }
    
    public static void distanceTransformWithLabels(final Mat mat, final Mat mat2, final Mat mat3, final int n, final int n2, final int n3) {
        distanceTransformWithLabels_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2, n3);
    }
    
    private static native void distanceTransformWithLabels_0(final long p0, final long p1, final long p2, final int p3, final int p4, final int p5);
    
    private static native void distanceTransformWithLabels_1(final long p0, final long p1, final long p2, final int p3, final int p4);
    
    private static native void distanceTransform_0(final long p0, final long p1, final int p2, final int p3, final int p4);
    
    private static native void distanceTransform_1(final long p0, final long p1, final int p2, final int p3);
    
    public static void drawContours(final Mat mat, final List<MatOfPoint> list, final int n, final Scalar scalar) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        drawContours_2(mat.nativeObj, Converters.vector_vector_Point_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, n, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void drawContours(final Mat mat, final List<MatOfPoint> list, final int n, final Scalar scalar, final int n2) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        drawContours_1(mat.nativeObj, Converters.vector_vector_Point_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, n, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n2);
    }
    
    public static void drawContours(final Mat mat, final List<MatOfPoint> list, final int n, final Scalar scalar, final int n2, final int n3, final Mat mat2, final int n4, final Point point) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        drawContours_0(mat.nativeObj, Converters.vector_vector_Point_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, n, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n2, n3, mat2.nativeObj, n4, point.x, point.y);
    }
    
    private static native void drawContours_0(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5, final double p6, final int p7, final int p8, final long p9, final int p10, final double p11, final double p12);
    
    private static native void drawContours_1(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5, final double p6, final int p7);
    
    private static native void drawContours_2(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5, final double p6);
    
    public static void drawMarker(final Mat mat, final Point point, final Scalar scalar) {
        drawMarker_1(mat.nativeObj, point.x, point.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void drawMarker(final Mat mat, final Point point, final Scalar scalar, final int n, final int n2, final int n3, final int n4) {
        drawMarker_0(mat.nativeObj, point.x, point.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n, n2, n3, n4);
    }
    
    private static native void drawMarker_0(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final int p7, final int p8, final int p9, final int p10);
    
    private static native void drawMarker_1(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6);
    
    public static void ellipse(final Mat mat, final Point point, final Size size, final double n, final double n2, final double n3, final Scalar scalar) {
        ellipse_2(mat.nativeObj, point.x, point.y, size.width, size.height, n, n2, n3, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void ellipse(final Mat mat, final Point point, final Size size, final double n, final double n2, final double n3, final Scalar scalar, final int n4) {
        ellipse_1(mat.nativeObj, point.x, point.y, size.width, size.height, n, n2, n3, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n4);
    }
    
    public static void ellipse(final Mat mat, final Point point, final Size size, final double n, final double n2, final double n3, final Scalar scalar, final int n4, final int n5, final int n6) {
        ellipse_0(mat.nativeObj, point.x, point.y, size.width, size.height, n, n2, n3, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n4, n5, n6);
    }
    
    public static void ellipse(final Mat mat, final RotatedRect rotatedRect, final Scalar scalar) {
        ellipse_5(mat.nativeObj, rotatedRect.center.x, rotatedRect.center.y, rotatedRect.size.width, rotatedRect.size.height, rotatedRect.angle, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void ellipse(final Mat mat, final RotatedRect rotatedRect, final Scalar scalar, final int n) {
        ellipse_4(mat.nativeObj, rotatedRect.center.x, rotatedRect.center.y, rotatedRect.size.width, rotatedRect.size.height, rotatedRect.angle, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n);
    }
    
    public static void ellipse(final Mat mat, final RotatedRect rotatedRect, final Scalar scalar, final int n, final int n2) {
        ellipse_3(mat.nativeObj, rotatedRect.center.x, rotatedRect.center.y, rotatedRect.size.width, rotatedRect.size.height, rotatedRect.angle, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n, n2);
    }
    
    public static void ellipse2Poly(final Point point, final Size size, final int n, final int n2, final int n3, final int n4, final MatOfPoint matOfPoint) {
        ellipse2Poly_0(point.x, point.y, size.width, size.height, n, n2, n3, n4, matOfPoint.nativeObj);
    }
    
    private static native void ellipse2Poly_0(final double p0, final double p1, final double p2, final double p3, final int p4, final int p5, final int p6, final int p7, final long p8);
    
    private static native void ellipse_0(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9, final double p10, final double p11, final int p12, final int p13, final int p14);
    
    private static native void ellipse_1(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9, final double p10, final double p11, final int p12);
    
    private static native void ellipse_2(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9, final double p10, final double p11);
    
    private static native void ellipse_3(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9, final int p10, final int p11);
    
    private static native void ellipse_4(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9, final int p10);
    
    private static native void ellipse_5(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9);
    
    public static void equalizeHist(final Mat mat, final Mat mat2) {
        equalizeHist_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void equalizeHist_0(final long p0, final long p1);
    
    public static void erode(final Mat mat, final Mat mat2, final Mat mat3) {
        erode_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void erode(final Mat mat, final Mat mat2, final Mat mat3, final Point point, final int n) {
        erode_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y, n);
    }
    
    public static void erode(final Mat mat, final Mat mat2, final Mat mat3, final Point point, final int n, final int n2, final Scalar scalar) {
        erode_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y, n, n2, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    private static native void erode_0(final long p0, final long p1, final long p2, final double p3, final double p4, final int p5, final int p6, final double p7, final double p8, final double p9, final double p10);
    
    private static native void erode_1(final long p0, final long p1, final long p2, final double p3, final double p4, final int p5);
    
    private static native void erode_2(final long p0, final long p1, final long p2);
    
    public static void fillConvexPoly(final Mat mat, final MatOfPoint matOfPoint, final Scalar scalar) {
        fillConvexPoly_1(mat.nativeObj, matOfPoint.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void fillConvexPoly(final Mat mat, final MatOfPoint matOfPoint, final Scalar scalar, final int n, final int n2) {
        fillConvexPoly_0(mat.nativeObj, matOfPoint.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n, n2);
    }
    
    private static native void fillConvexPoly_0(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final int p6, final int p7);
    
    private static native void fillConvexPoly_1(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5);
    
    public static void fillPoly(final Mat mat, final List<MatOfPoint> list, final Scalar scalar) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        fillPoly_1(mat.nativeObj, Converters.vector_vector_Point_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void fillPoly(final Mat mat, final List<MatOfPoint> list, final Scalar scalar, final int n, final int n2, final Point point) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        fillPoly_0(mat.nativeObj, Converters.vector_vector_Point_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n, n2, point.x, point.y);
    }
    
    private static native void fillPoly_0(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final int p6, final int p7, final double p8, final double p9);
    
    private static native void fillPoly_1(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5);
    
    public static void filter2D(final Mat mat, final Mat mat2, final int n, final Mat mat3) {
        filter2D_2(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj);
    }
    
    public static void filter2D(final Mat mat, final Mat mat2, final int n, final Mat mat3, final Point point, final double n2) {
        filter2D_1(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, point.x, point.y, n2);
    }
    
    public static void filter2D(final Mat mat, final Mat mat2, final int n, final Mat mat3, final Point point, final double n2, final int n3) {
        filter2D_0(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, point.x, point.y, n2, n3);
    }
    
    private static native void filter2D_0(final long p0, final long p1, final int p2, final long p3, final double p4, final double p5, final double p6, final int p7);
    
    private static native void filter2D_1(final long p0, final long p1, final int p2, final long p3, final double p4, final double p5, final double p6);
    
    private static native void filter2D_2(final long p0, final long p1, final int p2, final long p3);
    
    public static void findContours(final Mat mat, final List<MatOfPoint> list, final Mat mat2, final int n, final int n2) {
        final Mat mat3 = new Mat();
        findContours_1(mat.nativeObj, mat3.nativeObj, mat2.nativeObj, n, n2);
        Converters.Mat_to_vector_vector_Point(mat3, list);
        mat3.release();
    }
    
    public static void findContours(final Mat mat, final List<MatOfPoint> list, final Mat mat2, final int n, final int n2, final Point point) {
        final Mat mat3 = new Mat();
        findContours_0(mat.nativeObj, mat3.nativeObj, mat2.nativeObj, n, n2, point.x, point.y);
        Converters.Mat_to_vector_vector_Point(mat3, list);
        mat3.release();
    }
    
    private static native void findContours_0(final long p0, final long p1, final long p2, final int p3, final int p4, final double p5, final double p6);
    
    private static native void findContours_1(final long p0, final long p1, final long p2, final int p3, final int p4);
    
    public static RotatedRect fitEllipse(final MatOfPoint2f matOfPoint2f) {
        return new RotatedRect(fitEllipse_0(matOfPoint2f.nativeObj));
    }
    
    private static native double[] fitEllipse_0(final long p0);
    
    public static void fitLine(final Mat mat, final Mat mat2, final int n, final double n2, final double n3, final double n4) {
        fitLine_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4);
    }
    
    private static native void fitLine_0(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5);
    
    public static int floodFill(final Mat mat, final Mat mat2, final Point point, final Scalar scalar) {
        return floodFill_1(mat.nativeObj, mat2.nativeObj, point.x, point.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static int floodFill(final Mat mat, final Mat mat2, final Point point, final Scalar scalar, final Rect rect, final Scalar scalar2, final Scalar scalar3, int floodFill_0) {
        final double[] array = new double[4];
        floodFill_0 = floodFill_0(mat.nativeObj, mat2.nativeObj, point.x, point.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], array, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], scalar3.val[0], scalar3.val[1], scalar3.val[2], scalar3.val[3], floodFill_0);
        if (rect != null) {
            rect.x = (int)array[0];
            rect.y = (int)array[1];
            rect.width = (int)array[2];
            rect.height = (int)array[3];
        }
        return floodFill_0;
    }
    
    private static native int floodFill_0(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double[] p8, final double p9, final double p10, final double p11, final double p12, final double p13, final double p14, final double p15, final double p16, final int p17);
    
    private static native int floodFill_1(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7);
    
    public static Mat getAffineTransform(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2) {
        return new Mat(getAffineTransform_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj));
    }
    
    private static native long getAffineTransform_0(final long p0, final long p1);
    
    public static Mat getDefaultNewCameraMatrix(final Mat mat) {
        return new Mat(getDefaultNewCameraMatrix_1(mat.nativeObj));
    }
    
    public static Mat getDefaultNewCameraMatrix(final Mat mat, final Size size, final boolean b) {
        return new Mat(getDefaultNewCameraMatrix_0(mat.nativeObj, size.width, size.height, b));
    }
    
    private static native long getDefaultNewCameraMatrix_0(final long p0, final double p1, final double p2, final boolean p3);
    
    private static native long getDefaultNewCameraMatrix_1(final long p0);
    
    public static void getDerivKernels(final Mat mat, final Mat mat2, final int n, final int n2, final int n3) {
        getDerivKernels_1(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void getDerivKernels(final Mat mat, final Mat mat2, final int n, final int n2, final int n3, final boolean b, final int n4) {
        getDerivKernels_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, b, n4);
    }
    
    private static native void getDerivKernels_0(final long p0, final long p1, final int p2, final int p3, final int p4, final boolean p5, final int p6);
    
    private static native void getDerivKernels_1(final long p0, final long p1, final int p2, final int p3, final int p4);
    
    public static Mat getGaborKernel(final Size size, final double n, final double n2, final double n3, final double n4) {
        return new Mat(getGaborKernel_1(size.width, size.height, n, n2, n3, n4));
    }
    
    public static Mat getGaborKernel(final Size size, final double n, final double n2, final double n3, final double n4, final double n5, final int n6) {
        return new Mat(getGaborKernel_0(size.width, size.height, n, n2, n3, n4, n5, n6));
    }
    
    private static native long getGaborKernel_0(final double p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final int p7);
    
    private static native long getGaborKernel_1(final double p0, final double p1, final double p2, final double p3, final double p4, final double p5);
    
    public static Mat getGaussianKernel(final int n, final double n2) {
        return new Mat(getGaussianKernel_1(n, n2));
    }
    
    public static Mat getGaussianKernel(final int n, final double n2, final int n3) {
        return new Mat(getGaussianKernel_0(n, n2, n3));
    }
    
    private static native long getGaussianKernel_0(final int p0, final double p1, final int p2);
    
    private static native long getGaussianKernel_1(final int p0, final double p1);
    
    public static Mat getPerspectiveTransform(final Mat mat, final Mat mat2) {
        return new Mat(getPerspectiveTransform_0(mat.nativeObj, mat2.nativeObj));
    }
    
    private static native long getPerspectiveTransform_0(final long p0, final long p1);
    
    public static void getRectSubPix(final Mat mat, final Size size, final Point point, final Mat mat2) {
        getRectSubPix_1(mat.nativeObj, size.width, size.height, point.x, point.y, mat2.nativeObj);
    }
    
    public static void getRectSubPix(final Mat mat, final Size size, final Point point, final Mat mat2, final int n) {
        getRectSubPix_0(mat.nativeObj, size.width, size.height, point.x, point.y, mat2.nativeObj, n);
    }
    
    private static native void getRectSubPix_0(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5, final int p6);
    
    private static native void getRectSubPix_1(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    public static Mat getRotationMatrix2D(final Point point, final double n, final double n2) {
        return new Mat(getRotationMatrix2D_0(point.x, point.y, n, n2));
    }
    
    private static native long getRotationMatrix2D_0(final double p0, final double p1, final double p2, final double p3);
    
    public static Mat getStructuringElement(final int n, final Size size) {
        return new Mat(getStructuringElement_1(n, size.width, size.height));
    }
    
    public static Mat getStructuringElement(final int n, final Size size, final Point point) {
        return new Mat(getStructuringElement_0(n, size.width, size.height, point.x, point.y));
    }
    
    private static native long getStructuringElement_0(final int p0, final double p1, final double p2, final double p3, final double p4);
    
    private static native long getStructuringElement_1(final int p0, final double p1, final double p2);
    
    public static Size getTextSize(final String s, final int n, final double n2, final int n3, final int[] array) {
        if (array != null && array.length != 1) {
            throw new IllegalArgumentException("'baseLine' must be 'int[1]' or 'null'.");
        }
        return new Size(n_getTextSize(s, n, n2, n3, array));
    }
    
    public static void goodFeaturesToTrack(final Mat mat, final MatOfPoint matOfPoint, final int n, final double n2, final double n3) {
        goodFeaturesToTrack_1(mat.nativeObj, matOfPoint.nativeObj, n, n2, n3);
    }
    
    public static void goodFeaturesToTrack(final Mat mat, final MatOfPoint matOfPoint, final int n, final double n2, final double n3, final Mat mat2, final int n4, final boolean b, final double n5) {
        goodFeaturesToTrack_0(mat.nativeObj, matOfPoint.nativeObj, n, n2, n3, mat2.nativeObj, n4, b, n5);
    }
    
    private static native void goodFeaturesToTrack_0(final long p0, final long p1, final int p2, final double p3, final double p4, final long p5, final int p6, final boolean p7, final double p8);
    
    private static native void goodFeaturesToTrack_1(final long p0, final long p1, final int p2, final double p3, final double p4);
    
    public static void grabCut(final Mat mat, final Mat mat2, final Rect rect, final Mat mat3, final Mat mat4, final int n) {
        grabCut_1(mat.nativeObj, mat2.nativeObj, rect.x, rect.y, rect.width, rect.height, mat3.nativeObj, mat4.nativeObj, n);
    }
    
    public static void grabCut(final Mat mat, final Mat mat2, final Rect rect, final Mat mat3, final Mat mat4, final int n, final int n2) {
        grabCut_0(mat.nativeObj, mat2.nativeObj, rect.x, rect.y, rect.width, rect.height, mat3.nativeObj, mat4.nativeObj, n, n2);
    }
    
    private static native void grabCut_0(final long p0, final long p1, final int p2, final int p3, final int p4, final int p5, final long p6, final long p7, final int p8, final int p9);
    
    private static native void grabCut_1(final long p0, final long p1, final int p2, final int p3, final int p4, final int p5, final long p6, final long p7, final int p8);
    
    public static void initUndistortRectifyMap(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Size size, final int n, final Mat mat5, final Mat mat6) {
        initUndistortRectifyMap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, n, mat5.nativeObj, mat6.nativeObj);
    }
    
    private static native void initUndistortRectifyMap_0(final long p0, final long p1, final long p2, final long p3, final double p4, final double p5, final int p6, final long p7, final long p8);
    
    public static float initWideAngleProjMap(final Mat mat, final Mat mat2, final Size size, final int n, final int n2, final Mat mat3, final Mat mat4) {
        return initWideAngleProjMap_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, n, n2, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static float initWideAngleProjMap(final Mat mat, final Mat mat2, final Size size, final int n, final int n2, final Mat mat3, final Mat mat4, final int n3, final double n4) {
        return initWideAngleProjMap_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, n, n2, mat3.nativeObj, mat4.nativeObj, n3, n4);
    }
    
    private static native float initWideAngleProjMap_0(final long p0, final long p1, final double p2, final double p3, final int p4, final int p5, final long p6, final long p7, final int p8, final double p9);
    
    private static native float initWideAngleProjMap_1(final long p0, final long p1, final double p2, final double p3, final int p4, final int p5, final long p6, final long p7);
    
    public static void integral(final Mat mat, final Mat mat2) {
        integral_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void integral(final Mat mat, final Mat mat2, final int n) {
        integral_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static void integral2(final Mat mat, final Mat mat2, final Mat mat3) {
        integral2_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void integral2(final Mat mat, final Mat mat2, final Mat mat3, final int n, final int n2) {
        integral2_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2);
    }
    
    private static native void integral2_0(final long p0, final long p1, final long p2, final int p3, final int p4);
    
    private static native void integral2_1(final long p0, final long p1, final long p2);
    
    public static void integral3(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        integral3_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void integral3(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n, final int n2) {
        integral3_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n, n2);
    }
    
    private static native void integral3_0(final long p0, final long p1, final long p2, final long p3, final int p4, final int p5);
    
    private static native void integral3_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native void integral_0(final long p0, final long p1, final int p2);
    
    private static native void integral_1(final long p0, final long p1);
    
    public static float intersectConvexConvex(final Mat mat, final Mat mat2, final Mat mat3) {
        return intersectConvexConvex_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static float intersectConvexConvex(final Mat mat, final Mat mat2, final Mat mat3, final boolean b) {
        return intersectConvexConvex_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, b);
    }
    
    private static native float intersectConvexConvex_0(final long p0, final long p1, final long p2, final boolean p3);
    
    private static native float intersectConvexConvex_1(final long p0, final long p1, final long p2);
    
    public static void invertAffineTransform(final Mat mat, final Mat mat2) {
        invertAffineTransform_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void invertAffineTransform_0(final long p0, final long p1);
    
    public static boolean isContourConvex(final MatOfPoint matOfPoint) {
        return isContourConvex_0(matOfPoint.nativeObj);
    }
    
    private static native boolean isContourConvex_0(final long p0);
    
    public static void line(final Mat mat, final Point point, final Point point2, final Scalar scalar) {
        line_2(mat.nativeObj, point.x, point.y, point2.x, point2.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void line(final Mat mat, final Point point, final Point point2, final Scalar scalar, final int n) {
        line_1(mat.nativeObj, point.x, point.y, point2.x, point2.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n);
    }
    
    public static void line(final Mat mat, final Point point, final Point point2, final Scalar scalar, final int n, final int n2, final int n3) {
        line_0(mat.nativeObj, point.x, point.y, point2.x, point2.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n, n2, n3);
    }
    
    private static native void line_0(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final int p9, final int p10, final int p11);
    
    private static native void line_1(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final int p9);
    
    private static native void line_2(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8);
    
    public static void linearPolar(final Mat mat, final Mat mat2, final Point point, final double n, final int n2) {
        linearPolar_0(mat.nativeObj, mat2.nativeObj, point.x, point.y, n, n2);
    }
    
    private static native void linearPolar_0(final long p0, final long p1, final double p2, final double p3, final double p4, final int p5);
    
    public static void logPolar(final Mat mat, final Mat mat2, final Point point, final double n, final int n2) {
        logPolar_0(mat.nativeObj, mat2.nativeObj, point.x, point.y, n, n2);
    }
    
    private static native void logPolar_0(final long p0, final long p1, final double p2, final double p3, final double p4, final int p5);
    
    public static double matchShapes(final Mat mat, final Mat mat2, final int n, final double n2) {
        return matchShapes_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native double matchShapes_0(final long p0, final long p1, final int p2, final double p3);
    
    public static void matchTemplate(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        matchTemplate_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void matchTemplate(final Mat mat, final Mat mat2, final Mat mat3, final int n, final Mat mat4) {
        matchTemplate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, mat4.nativeObj);
    }
    
    private static native void matchTemplate_0(final long p0, final long p1, final long p2, final int p3, final long p4);
    
    private static native void matchTemplate_1(final long p0, final long p1, final long p2, final int p3);
    
    public static void medianBlur(final Mat mat, final Mat mat2, final int n) {
        medianBlur_0(mat.nativeObj, mat2.nativeObj, n);
    }
    
    private static native void medianBlur_0(final long p0, final long p1, final int p2);
    
    public static RotatedRect minAreaRect(final MatOfPoint2f matOfPoint2f) {
        return new RotatedRect(minAreaRect_0(matOfPoint2f.nativeObj));
    }
    
    private static native double[] minAreaRect_0(final long p0);
    
    public static void minEnclosingCircle(final MatOfPoint2f matOfPoint2f, final Point point, final float[] array) {
        final double[] array2 = new double[2];
        final double[] array3 = { 0.0 };
        minEnclosingCircle_0(matOfPoint2f.nativeObj, array2, array3);
        if (point != null) {
            point.x = array2[0];
            point.y = array2[1];
        }
        if (array != null) {
            array[0] = (float)array3[0];
        }
    }
    
    private static native void minEnclosingCircle_0(final long p0, final double[] p1, final double[] p2);
    
    public static double minEnclosingTriangle(final Mat mat, final Mat mat2) {
        return minEnclosingTriangle_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native double minEnclosingTriangle_0(final long p0, final long p1);
    
    public static Moments moments(final Mat mat) {
        return new Moments(moments_1(mat.nativeObj));
    }
    
    public static Moments moments(final Mat mat, final boolean b) {
        return new Moments(moments_0(mat.nativeObj, b));
    }
    
    private static native double[] moments_0(final long p0, final boolean p1);
    
    private static native double[] moments_1(final long p0);
    
    public static void morphologyEx(final Mat mat, final Mat mat2, final int n, final Mat mat3) {
        morphologyEx_2(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj);
    }
    
    public static void morphologyEx(final Mat mat, final Mat mat2, final int n, final Mat mat3, final Point point, final int n2) {
        morphologyEx_1(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, point.x, point.y, n2);
    }
    
    public static void morphologyEx(final Mat mat, final Mat mat2, final int n, final Mat mat3, final Point point, final int n2, final int n3, final Scalar scalar) {
        morphologyEx_0(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, point.x, point.y, n2, n3, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    private static native void morphologyEx_0(final long p0, final long p1, final int p2, final long p3, final double p4, final double p5, final int p6, final int p7, final double p8, final double p9, final double p10, final double p11);
    
    private static native void morphologyEx_1(final long p0, final long p1, final int p2, final long p3, final double p4, final double p5, final int p6);
    
    private static native void morphologyEx_2(final long p0, final long p1, final int p2, final long p3);
    
    private static native double[] n_getTextSize(final String p0, final int p1, final double p2, final int p3, final int[] p4);
    
    public static Point phaseCorrelate(final Mat mat, final Mat mat2) {
        return new Point(phaseCorrelate_1(mat.nativeObj, mat2.nativeObj));
    }
    
    public static Point phaseCorrelate(final Mat mat, final Mat mat2, final Mat mat3, final double[] array) {
        final double[] array2 = { 0.0 };
        final Point point = new Point(phaseCorrelate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, array2));
        if (array != null) {
            array[0] = array2[0];
        }
        return point;
    }
    
    private static native double[] phaseCorrelate_0(final long p0, final long p1, final long p2, final double[] p3);
    
    private static native double[] phaseCorrelate_1(final long p0, final long p1);
    
    public static double pointPolygonTest(final MatOfPoint2f matOfPoint2f, final Point point, final boolean b) {
        return pointPolygonTest_0(matOfPoint2f.nativeObj, point.x, point.y, b);
    }
    
    private static native double pointPolygonTest_0(final long p0, final double p1, final double p2, final boolean p3);
    
    public static void polylines(final Mat mat, final List<MatOfPoint> list, final boolean b, final Scalar scalar) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        polylines_2(mat.nativeObj, Converters.vector_vector_Point_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, b, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void polylines(final Mat mat, final List<MatOfPoint> list, final boolean b, final Scalar scalar, final int n) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        polylines_1(mat.nativeObj, Converters.vector_vector_Point_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, b, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n);
    }
    
    public static void polylines(final Mat mat, final List<MatOfPoint> list, final boolean b, final Scalar scalar, final int n, final int n2, final int n3) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        polylines_0(mat.nativeObj, Converters.vector_vector_Point_to_Mat(list, new ArrayList<Mat>(size)).nativeObj, b, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n, n2, n3);
    }
    
    private static native void polylines_0(final long p0, final long p1, final boolean p2, final double p3, final double p4, final double p5, final double p6, final int p7, final int p8, final int p9);
    
    private static native void polylines_1(final long p0, final long p1, final boolean p2, final double p3, final double p4, final double p5, final double p6, final int p7);
    
    private static native void polylines_2(final long p0, final long p1, final boolean p2, final double p3, final double p4, final double p5, final double p6);
    
    public static void preCornerDetect(final Mat mat, final Mat mat2, final int n) {
        preCornerDetect_1(mat.nativeObj, mat2.nativeObj, n);
    }
    
    public static void preCornerDetect(final Mat mat, final Mat mat2, final int n, final int n2) {
        preCornerDetect_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native void preCornerDetect_0(final long p0, final long p1, final int p2, final int p3);
    
    private static native void preCornerDetect_1(final long p0, final long p1, final int p2);
    
    public static void putText(final Mat mat, final String s, final Point point, final int n, final double n2, final Scalar scalar) {
        putText_2(mat.nativeObj, s, point.x, point.y, n, n2, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void putText(final Mat mat, final String s, final Point point, final int n, final double n2, final Scalar scalar, final int n3) {
        putText_1(mat.nativeObj, s, point.x, point.y, n, n2, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n3);
    }
    
    public static void putText(final Mat mat, final String s, final Point point, final int n, final double n2, final Scalar scalar, final int n3, final int n4, final boolean b) {
        putText_0(mat.nativeObj, s, point.x, point.y, n, n2, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n3, n4, b);
    }
    
    private static native void putText_0(final long p0, final String p1, final double p2, final double p3, final int p4, final double p5, final double p6, final double p7, final double p8, final double p9, final int p10, final int p11, final boolean p12);
    
    private static native void putText_1(final long p0, final String p1, final double p2, final double p3, final int p4, final double p5, final double p6, final double p7, final double p8, final double p9, final int p10);
    
    private static native void putText_2(final long p0, final String p1, final double p2, final double p3, final int p4, final double p5, final double p6, final double p7, final double p8, final double p9);
    
    public static void pyrDown(final Mat mat, final Mat mat2) {
        pyrDown_2(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void pyrDown(final Mat mat, final Mat mat2, final Size size) {
        pyrDown_1(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }
    
    public static void pyrDown(final Mat mat, final Mat mat2, final Size size, final int n) {
        pyrDown_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, n);
    }
    
    private static native void pyrDown_0(final long p0, final long p1, final double p2, final double p3, final int p4);
    
    private static native void pyrDown_1(final long p0, final long p1, final double p2, final double p3);
    
    private static native void pyrDown_2(final long p0, final long p1);
    
    public static void pyrMeanShiftFiltering(final Mat mat, final Mat mat2, final double n, final double n2) {
        pyrMeanShiftFiltering_1(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    public static void pyrMeanShiftFiltering(final Mat mat, final Mat mat2, final double n, final double n2, final int n3, final TermCriteria termCriteria) {
        pyrMeanShiftFiltering_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
    
    private static native void pyrMeanShiftFiltering_0(final long p0, final long p1, final double p2, final double p3, final int p4, final int p5, final int p6, final double p7);
    
    private static native void pyrMeanShiftFiltering_1(final long p0, final long p1, final double p2, final double p3);
    
    public static void pyrUp(final Mat mat, final Mat mat2) {
        pyrUp_2(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void pyrUp(final Mat mat, final Mat mat2, final Size size) {
        pyrUp_1(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }
    
    public static void pyrUp(final Mat mat, final Mat mat2, final Size size, final int n) {
        pyrUp_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, n);
    }
    
    private static native void pyrUp_0(final long p0, final long p1, final double p2, final double p3, final int p4);
    
    private static native void pyrUp_1(final long p0, final long p1, final double p2, final double p3);
    
    private static native void pyrUp_2(final long p0, final long p1);
    
    public static void rectangle(final Mat mat, final Point point, final Point point2, final Scalar scalar) {
        rectangle_2(mat.nativeObj, point.x, point.y, point2.x, point2.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static void rectangle(final Mat mat, final Point point, final Point point2, final Scalar scalar, final int n) {
        rectangle_1(mat.nativeObj, point.x, point.y, point2.x, point2.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n);
    }
    
    public static void rectangle(final Mat mat, final Point point, final Point point2, final Scalar scalar, final int n, final int n2, final int n3) {
        rectangle_0(mat.nativeObj, point.x, point.y, point2.x, point2.y, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], n, n2, n3);
    }
    
    private static native void rectangle_0(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final int p9, final int p10, final int p11);
    
    private static native void rectangle_1(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final int p9);
    
    private static native void rectangle_2(final long p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8);
    
    public static void remap(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n) {
        remap_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n);
    }
    
    public static void remap(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final int n, final int n2, final Scalar scalar) {
        remap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, n, n2, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    private static native void remap_0(final long p0, final long p1, final long p2, final long p3, final int p4, final int p5, final double p6, final double p7, final double p8, final double p9);
    
    private static native void remap_1(final long p0, final long p1, final long p2, final long p3, final int p4);
    
    public static void resize(final Mat mat, final Mat mat2, final Size size) {
        resize_1(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }
    
    public static void resize(final Mat mat, final Mat mat2, final Size size, final double n, final double n2, final int n3) {
        resize_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, n, n2, n3);
    }
    
    private static native void resize_0(final long p0, final long p1, final double p2, final double p3, final double p4, final double p5, final int p6);
    
    private static native void resize_1(final long p0, final long p1, final double p2, final double p3);
    
    public static int rotatedRectangleIntersection(final RotatedRect rotatedRect, final RotatedRect rotatedRect2, final Mat mat) {
        return rotatedRectangleIntersection_0(rotatedRect.center.x, rotatedRect.center.y, rotatedRect.size.width, rotatedRect.size.height, rotatedRect.angle, rotatedRect2.center.x, rotatedRect2.center.y, rotatedRect2.size.width, rotatedRect2.size.height, rotatedRect2.angle, mat.nativeObj);
    }
    
    private static native int rotatedRectangleIntersection_0(final double p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final double p8, final double p9, final long p10);
    
    public static void sepFilter2D(final Mat mat, final Mat mat2, final int n, final Mat mat3, final Mat mat4) {
        sepFilter2D_2(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void sepFilter2D(final Mat mat, final Mat mat2, final int n, final Mat mat3, final Mat mat4, final Point point, final double n2) {
        sepFilter2D_1(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, mat4.nativeObj, point.x, point.y, n2);
    }
    
    public static void sepFilter2D(final Mat mat, final Mat mat2, final int n, final Mat mat3, final Mat mat4, final Point point, final double n2, final int n3) {
        sepFilter2D_0(mat.nativeObj, mat2.nativeObj, n, mat3.nativeObj, mat4.nativeObj, point.x, point.y, n2, n3);
    }
    
    private static native void sepFilter2D_0(final long p0, final long p1, final int p2, final long p3, final long p4, final double p5, final double p6, final double p7, final int p8);
    
    private static native void sepFilter2D_1(final long p0, final long p1, final int p2, final long p3, final long p4, final double p5, final double p6, final double p7);
    
    private static native void sepFilter2D_2(final long p0, final long p1, final int p2, final long p3, final long p4);
    
    public static void spatialGradient(final Mat mat, final Mat mat2, final Mat mat3) {
        spatialGradient_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void spatialGradient(final Mat mat, final Mat mat2, final Mat mat3, final int n) {
        spatialGradient_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n);
    }
    
    public static void spatialGradient(final Mat mat, final Mat mat2, final Mat mat3, final int n, final int n2) {
        spatialGradient_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2);
    }
    
    private static native void spatialGradient_0(final long p0, final long p1, final long p2, final int p3, final int p4);
    
    private static native void spatialGradient_1(final long p0, final long p1, final long p2, final int p3);
    
    private static native void spatialGradient_2(final long p0, final long p1, final long p2);
    
    public static void sqrBoxFilter(final Mat mat, final Mat mat2, final int n, final Size size) {
        sqrBoxFilter_2(mat.nativeObj, mat2.nativeObj, n, size.width, size.height);
    }
    
    public static void sqrBoxFilter(final Mat mat, final Mat mat2, final int n, final Size size, final Point point, final boolean b) {
        sqrBoxFilter_1(mat.nativeObj, mat2.nativeObj, n, size.width, size.height, point.x, point.y, b);
    }
    
    public static void sqrBoxFilter(final Mat mat, final Mat mat2, final int n, final Size size, final Point point, final boolean b, final int n2) {
        sqrBoxFilter_0(mat.nativeObj, mat2.nativeObj, n, size.width, size.height, point.x, point.y, b, n2);
    }
    
    private static native void sqrBoxFilter_0(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5, final double p6, final boolean p7, final int p8);
    
    private static native void sqrBoxFilter_1(final long p0, final long p1, final int p2, final double p3, final double p4, final double p5, final double p6, final boolean p7);
    
    private static native void sqrBoxFilter_2(final long p0, final long p1, final int p2, final double p3, final double p4);
    
    public static double threshold(final Mat mat, final Mat mat2, final double n, final double n2, final int n3) {
        return threshold_0(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    private static native double threshold_0(final long p0, final long p1, final double p2, final double p3, final int p4);
    
    public static void undistort(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        undistort_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public static void undistort(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5) {
        undistort_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }
    
    public static void undistortPoints(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final Mat mat, final Mat mat2) {
        undistortPoints_1(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public static void undistortPoints(final MatOfPoint2f matOfPoint2f, final MatOfPoint2f matOfPoint2f2, final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        undistortPoints_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    private static native void undistortPoints_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    private static native void undistortPoints_1(final long p0, final long p1, final long p2, final long p3);
    
    private static native void undistort_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    private static native void undistort_1(final long p0, final long p1, final long p2, final long p3);
    
    public static void warpAffine(final Mat mat, final Mat mat2, final Mat mat3, final Size size) {
        warpAffine_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height);
    }
    
    public static void warpAffine(final Mat mat, final Mat mat2, final Mat mat3, final Size size, final int n) {
        warpAffine_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, n);
    }
    
    public static void warpAffine(final Mat mat, final Mat mat2, final Mat mat3, final Size size, final int n, final int n2, final Scalar scalar) {
        warpAffine_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, n, n2, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    private static native void warpAffine_0(final long p0, final long p1, final long p2, final double p3, final double p4, final int p5, final int p6, final double p7, final double p8, final double p9, final double p10);
    
    private static native void warpAffine_1(final long p0, final long p1, final long p2, final double p3, final double p4, final int p5);
    
    private static native void warpAffine_2(final long p0, final long p1, final long p2, final double p3, final double p4);
    
    public static void warpPerspective(final Mat mat, final Mat mat2, final Mat mat3, final Size size) {
        warpPerspective_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height);
    }
    
    public static void warpPerspective(final Mat mat, final Mat mat2, final Mat mat3, final Size size, final int n) {
        warpPerspective_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, n);
    }
    
    public static void warpPerspective(final Mat mat, final Mat mat2, final Mat mat3, final Size size, final int n, final int n2, final Scalar scalar) {
        warpPerspective_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, n, n2, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    private static native void warpPerspective_0(final long p0, final long p1, final long p2, final double p3, final double p4, final int p5, final int p6, final double p7, final double p8, final double p9, final double p10);
    
    private static native void warpPerspective_1(final long p0, final long p1, final long p2, final double p3, final double p4, final int p5);
    
    private static native void warpPerspective_2(final long p0, final long p1, final long p2, final double p3, final double p4);
    
    public static void watershed(final Mat mat, final Mat mat2) {
        watershed_0(mat.nativeObj, mat2.nativeObj);
    }
    
    private static native void watershed_0(final long p0, final long p1);
}

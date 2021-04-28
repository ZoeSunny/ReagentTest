package org.opencv.imgcodecs;

import org.opencv.core.*;
import java.util.*;
import org.opencv.utils.*;

public class Imgcodecs
{
    public static final int CV_CVTIMG_FLIP = 1;
    public static final int CV_CVTIMG_SWAP_RB = 2;
    public static final int CV_IMWRITE_JPEG_CHROMA_QUALITY = 6;
    public static final int CV_IMWRITE_JPEG_LUMA_QUALITY = 5;
    public static final int CV_IMWRITE_JPEG_OPTIMIZE = 3;
    public static final int CV_IMWRITE_JPEG_PROGRESSIVE = 2;
    public static final int CV_IMWRITE_JPEG_QUALITY = 1;
    public static final int CV_IMWRITE_JPEG_RST_INTERVAL = 4;
    public static final int CV_IMWRITE_PNG_BILEVEL = 18;
    public static final int CV_IMWRITE_PNG_COMPRESSION = 16;
    public static final int CV_IMWRITE_PNG_STRATEGY = 17;
    public static final int CV_IMWRITE_PNG_STRATEGY_DEFAULT = 0;
    public static final int CV_IMWRITE_PNG_STRATEGY_FILTERED = 1;
    public static final int CV_IMWRITE_PNG_STRATEGY_FIXED = 4;
    public static final int CV_IMWRITE_PNG_STRATEGY_HUFFMAN_ONLY = 2;
    public static final int CV_IMWRITE_PNG_STRATEGY_RLE = 3;
    public static final int CV_IMWRITE_PXM_BINARY = 32;
    public static final int CV_IMWRITE_WEBP_QUALITY = 64;
    public static final int CV_LOAD_IMAGE_ANYCOLOR = 4;
    public static final int CV_LOAD_IMAGE_ANYDEPTH = 2;
    public static final int CV_LOAD_IMAGE_COLOR = 1;
    public static final int CV_LOAD_IMAGE_GRAYSCALE = 0;
    public static final int CV_LOAD_IMAGE_UNCHANGED = -1;
    public static final int IMREAD_ANYCOLOR = 4;
    public static final int IMREAD_ANYDEPTH = 2;
    public static final int IMREAD_COLOR = 1;
    public static final int IMREAD_GRAYSCALE = 0;
    public static final int IMREAD_LOAD_GDAL = 8;
    public static final int IMREAD_REDUCED_COLOR_2 = 17;
    public static final int IMREAD_REDUCED_COLOR_4 = 33;
    public static final int IMREAD_REDUCED_COLOR_8 = 65;
    public static final int IMREAD_REDUCED_GRAYSCALE_2 = 16;
    public static final int IMREAD_REDUCED_GRAYSCALE_4 = 32;
    public static final int IMREAD_REDUCED_GRAYSCALE_8 = 64;
    public static final int IMREAD_UNCHANGED = -1;
    public static final int IMWRITE_JPEG_CHROMA_QUALITY = 6;
    public static final int IMWRITE_JPEG_LUMA_QUALITY = 5;
    public static final int IMWRITE_JPEG_OPTIMIZE = 3;
    public static final int IMWRITE_JPEG_PROGRESSIVE = 2;
    public static final int IMWRITE_JPEG_QUALITY = 1;
    public static final int IMWRITE_JPEG_RST_INTERVAL = 4;
    public static final int IMWRITE_PNG_BILEVEL = 18;
    public static final int IMWRITE_PNG_COMPRESSION = 16;
    public static final int IMWRITE_PNG_STRATEGY = 17;
    public static final int IMWRITE_PNG_STRATEGY_DEFAULT = 0;
    public static final int IMWRITE_PNG_STRATEGY_FILTERED = 1;
    public static final int IMWRITE_PNG_STRATEGY_FIXED = 4;
    public static final int IMWRITE_PNG_STRATEGY_HUFFMAN_ONLY = 2;
    public static final int IMWRITE_PNG_STRATEGY_RLE = 3;
    public static final int IMWRITE_PXM_BINARY = 32;
    public static final int IMWRITE_WEBP_QUALITY = 64;
    
    public static Mat imdecode(final Mat mat, final int n) {
        return new Mat(imdecode_0(mat.nativeObj, n));
    }
    
    private static native long imdecode_0(final long p0, final int p1);
    
    public static boolean imencode(final String s, final Mat mat, final MatOfByte matOfByte) {
        return imencode_1(s, mat.nativeObj, matOfByte.nativeObj);
    }
    
    public static boolean imencode(final String s, final Mat mat, final MatOfByte matOfByte, final MatOfInt matOfInt) {
        return imencode_0(s, mat.nativeObj, matOfByte.nativeObj, matOfInt.nativeObj);
    }
    
    private static native boolean imencode_0(final String p0, final long p1, final long p2, final long p3);
    
    private static native boolean imencode_1(final String p0, final long p1, final long p2);
    
    public static Mat imread(final String s) {
        return new Mat(imread_1(s));
    }
    
    public static Mat imread(final String s, final int n) {
        return new Mat(imread_0(s, n));
    }
    
    private static native long imread_0(final String p0, final int p1);
    
    private static native long imread_1(final String p0);
    
    public static boolean imreadmulti(final String s, final List<Mat> list) {
        return imreadmulti_1(s, Converters.vector_Mat_to_Mat(list).nativeObj);
    }
    
    public static boolean imreadmulti(final String s, final List<Mat> list, final int n) {
        return imreadmulti_0(s, Converters.vector_Mat_to_Mat(list).nativeObj, n);
    }
    
    private static native boolean imreadmulti_0(final String p0, final long p1, final int p2);
    
    private static native boolean imreadmulti_1(final String p0, final long p1);
    
    public static boolean imwrite(final String s, final Mat mat) {
        return imwrite_1(s, mat.nativeObj);
    }
    
    public static boolean imwrite(final String s, final Mat mat, final MatOfInt matOfInt) {
        return imwrite_0(s, mat.nativeObj, matOfInt.nativeObj);
    }
    
    private static native boolean imwrite_0(final String p0, final long p1, final long p2);
    
    private static native boolean imwrite_1(final String p0, final long p1);
}

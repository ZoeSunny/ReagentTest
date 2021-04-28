package org.opencv.photo;

import java.util.*;
import org.opencv.utils.*;
import org.opencv.core.*;

public class Photo
{
    private static final int CV_INPAINT_NS = 0;
    private static final int CV_INPAINT_TELEA = 1;
    public static final int INPAINT_NS = 0;
    public static final int INPAINT_TELEA = 1;
    public static final int LDR_SIZE = 256;
    public static final int MIXED_CLONE = 2;
    public static final int MONOCHROME_TRANSFER = 3;
    public static final int NORMAL_CLONE = 1;
    public static final int NORMCONV_FILTER = 2;
    public static final int RECURS_FILTER = 1;
    
    public static void colorChange(final Mat mat, final Mat mat2, final Mat mat3) {
        colorChange_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void colorChange(final Mat mat, final Mat mat2, final Mat mat3, final float n, final float n2, final float n3) {
        colorChange_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2, n3);
    }
    
    private static native void colorChange_0(final long p0, final long p1, final long p2, final float p3, final float p4, final float p5);
    
    private static native void colorChange_1(final long p0, final long p1, final long p2);
    
    public static AlignMTB createAlignMTB() {
        return new AlignMTB(createAlignMTB_1());
    }
    
    public static AlignMTB createAlignMTB(final int n, final int n2, final boolean b) {
        return new AlignMTB(createAlignMTB_0(n, n2, b));
    }
    
    private static native long createAlignMTB_0(final int p0, final int p1, final boolean p2);
    
    private static native long createAlignMTB_1();
    
    public static CalibrateDebevec createCalibrateDebevec() {
        return new CalibrateDebevec(createCalibrateDebevec_1());
    }
    
    public static CalibrateDebevec createCalibrateDebevec(final int n, final float n2, final boolean b) {
        return new CalibrateDebevec(createCalibrateDebevec_0(n, n2, b));
    }
    
    private static native long createCalibrateDebevec_0(final int p0, final float p1, final boolean p2);
    
    private static native long createCalibrateDebevec_1();
    
    public static CalibrateRobertson createCalibrateRobertson() {
        return new CalibrateRobertson(createCalibrateRobertson_1());
    }
    
    public static CalibrateRobertson createCalibrateRobertson(final int n, final float n2) {
        return new CalibrateRobertson(createCalibrateRobertson_0(n, n2));
    }
    
    private static native long createCalibrateRobertson_0(final int p0, final float p1);
    
    private static native long createCalibrateRobertson_1();
    
    public static MergeDebevec createMergeDebevec() {
        return new MergeDebevec(createMergeDebevec_0());
    }
    
    private static native long createMergeDebevec_0();
    
    public static MergeMertens createMergeMertens() {
        return new MergeMertens(createMergeMertens_1());
    }
    
    public static MergeMertens createMergeMertens(final float n, final float n2, final float n3) {
        return new MergeMertens(createMergeMertens_0(n, n2, n3));
    }
    
    private static native long createMergeMertens_0(final float p0, final float p1, final float p2);
    
    private static native long createMergeMertens_1();
    
    public static MergeRobertson createMergeRobertson() {
        return new MergeRobertson(createMergeRobertson_0());
    }
    
    private static native long createMergeRobertson_0();
    
    public static Tonemap createTonemap() {
        return new Tonemap(createTonemap_1());
    }
    
    public static Tonemap createTonemap(final float n) {
        return new Tonemap(createTonemap_0(n));
    }
    
    public static TonemapDrago createTonemapDrago() {
        return new TonemapDrago(createTonemapDrago_1());
    }
    
    public static TonemapDrago createTonemapDrago(final float n, final float n2, final float n3) {
        return new TonemapDrago(createTonemapDrago_0(n, n2, n3));
    }
    
    private static native long createTonemapDrago_0(final float p0, final float p1, final float p2);
    
    private static native long createTonemapDrago_1();
    
    public static TonemapDurand createTonemapDurand() {
        return new TonemapDurand(createTonemapDurand_1());
    }
    
    public static TonemapDurand createTonemapDurand(final float n, final float n2, final float n3, final float n4, final float n5) {
        return new TonemapDurand(createTonemapDurand_0(n, n2, n3, n4, n5));
    }
    
    private static native long createTonemapDurand_0(final float p0, final float p1, final float p2, final float p3, final float p4);
    
    private static native long createTonemapDurand_1();
    
    public static TonemapMantiuk createTonemapMantiuk() {
        return new TonemapMantiuk(createTonemapMantiuk_1());
    }
    
    public static TonemapMantiuk createTonemapMantiuk(final float n, final float n2, final float n3) {
        return new TonemapMantiuk(createTonemapMantiuk_0(n, n2, n3));
    }
    
    private static native long createTonemapMantiuk_0(final float p0, final float p1, final float p2);
    
    private static native long createTonemapMantiuk_1();
    
    public static TonemapReinhard createTonemapReinhard() {
        return new TonemapReinhard(createTonemapReinhard_1());
    }
    
    public static TonemapReinhard createTonemapReinhard(final float n, final float n2, final float n3, final float n4) {
        return new TonemapReinhard(createTonemapReinhard_0(n, n2, n3, n4));
    }
    
    private static native long createTonemapReinhard_0(final float p0, final float p1, final float p2, final float p3);
    
    private static native long createTonemapReinhard_1();
    
    private static native long createTonemap_0(final float p0);
    
    private static native long createTonemap_1();
    
    public static void decolor(final Mat mat, final Mat mat2, final Mat mat3) {
        decolor_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    private static native void decolor_0(final long p0, final long p1, final long p2);
    
    public static void denoise_TVL1(final List<Mat> list, final Mat mat) {
        denoise_TVL1_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }
    
    public static void denoise_TVL1(final List<Mat> list, final Mat mat, final double n, final int n2) {
        denoise_TVL1_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, n, n2);
    }
    
    private static native void denoise_TVL1_0(final long p0, final long p1, final double p2, final int p3);
    
    private static native void denoise_TVL1_1(final long p0, final long p1);
    
    public static void detailEnhance(final Mat mat, final Mat mat2) {
        detailEnhance_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void detailEnhance(final Mat mat, final Mat mat2, final float n, final float n2) {
        detailEnhance_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native void detailEnhance_0(final long p0, final long p1, final float p2, final float p3);
    
    private static native void detailEnhance_1(final long p0, final long p1);
    
    public static void edgePreservingFilter(final Mat mat, final Mat mat2) {
        edgePreservingFilter_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void edgePreservingFilter(final Mat mat, final Mat mat2, final int n, final float n2, final float n3) {
        edgePreservingFilter_0(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    private static native void edgePreservingFilter_0(final long p0, final long p1, final int p2, final float p3, final float p4);
    
    private static native void edgePreservingFilter_1(final long p0, final long p1);
    
    public static void fastNlMeansDenoising(final Mat mat, final Mat mat2) {
        fastNlMeansDenoising_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void fastNlMeansDenoising(final Mat mat, final Mat mat2, final float n, final int n2, final int n3) {
        fastNlMeansDenoising_0(mat.nativeObj, mat2.nativeObj, n, n2, n3);
    }
    
    public static void fastNlMeansDenoising(final Mat mat, final Mat mat2, final MatOfFloat matOfFloat) {
        fastNlMeansDenoising_3(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj);
    }
    
    public static void fastNlMeansDenoising(final Mat mat, final Mat mat2, final MatOfFloat matOfFloat, final int n, final int n2, final int n3) {
        fastNlMeansDenoising_2(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, n, n2, n3);
    }
    
    public static void fastNlMeansDenoisingColored(final Mat mat, final Mat mat2) {
        fastNlMeansDenoisingColored_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void fastNlMeansDenoisingColored(final Mat mat, final Mat mat2, final float n, final float n2, final int n3, final int n4) {
        fastNlMeansDenoisingColored_0(mat.nativeObj, mat2.nativeObj, n, n2, n3, n4);
    }
    
    public static void fastNlMeansDenoisingColoredMulti(final List<Mat> list, final Mat mat, final int n, final int n2) {
        fastNlMeansDenoisingColoredMulti_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, n, n2);
    }
    
    public static void fastNlMeansDenoisingColoredMulti(final List<Mat> list, final Mat mat, final int n, final int n2, final float n3, final float n4, final int n5, final int n6) {
        fastNlMeansDenoisingColoredMulti_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, n, n2, n3, n4, n5, n6);
    }
    
    private static native void fastNlMeansDenoisingColoredMulti_0(final long p0, final long p1, final int p2, final int p3, final float p4, final float p5, final int p6, final int p7);
    
    private static native void fastNlMeansDenoisingColoredMulti_1(final long p0, final long p1, final int p2, final int p3);
    
    private static native void fastNlMeansDenoisingColored_0(final long p0, final long p1, final float p2, final float p3, final int p4, final int p5);
    
    private static native void fastNlMeansDenoisingColored_1(final long p0, final long p1);
    
    public static void fastNlMeansDenoisingMulti(final List<Mat> list, final Mat mat, final int n, final int n2) {
        fastNlMeansDenoisingMulti_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, n, n2);
    }
    
    public static void fastNlMeansDenoisingMulti(final List<Mat> list, final Mat mat, final int n, final int n2, final float n3, final int n4, final int n5) {
        fastNlMeansDenoisingMulti_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, n, n2, n3, n4, n5);
    }
    
    public static void fastNlMeansDenoisingMulti(final List<Mat> list, final Mat mat, final int n, final int n2, final MatOfFloat matOfFloat) {
        fastNlMeansDenoisingMulti_3(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, n, n2, matOfFloat.nativeObj);
    }
    
    public static void fastNlMeansDenoisingMulti(final List<Mat> list, final Mat mat, final int n, final int n2, final MatOfFloat matOfFloat, final int n3, final int n4, final int n5) {
        fastNlMeansDenoisingMulti_2(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, n, n2, matOfFloat.nativeObj, n3, n4, n5);
    }
    
    private static native void fastNlMeansDenoisingMulti_0(final long p0, final long p1, final int p2, final int p3, final float p4, final int p5, final int p6);
    
    private static native void fastNlMeansDenoisingMulti_1(final long p0, final long p1, final int p2, final int p3);
    
    private static native void fastNlMeansDenoisingMulti_2(final long p0, final long p1, final int p2, final int p3, final long p4, final int p5, final int p6, final int p7);
    
    private static native void fastNlMeansDenoisingMulti_3(final long p0, final long p1, final int p2, final int p3, final long p4);
    
    private static native void fastNlMeansDenoising_0(final long p0, final long p1, final float p2, final int p3, final int p4);
    
    private static native void fastNlMeansDenoising_1(final long p0, final long p1);
    
    private static native void fastNlMeansDenoising_2(final long p0, final long p1, final long p2, final int p3, final int p4, final int p5);
    
    private static native void fastNlMeansDenoising_3(final long p0, final long p1, final long p2);
    
    public static void illuminationChange(final Mat mat, final Mat mat2, final Mat mat3) {
        illuminationChange_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void illuminationChange(final Mat mat, final Mat mat2, final Mat mat3, final float n, final float n2) {
        illuminationChange_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2);
    }
    
    private static native void illuminationChange_0(final long p0, final long p1, final long p2, final float p3, final float p4);
    
    private static native void illuminationChange_1(final long p0, final long p1, final long p2);
    
    public static void inpaint(final Mat mat, final Mat mat2, final Mat mat3, final double n, final int n2) {
        inpaint_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2);
    }
    
    private static native void inpaint_0(final long p0, final long p1, final long p2, final double p3, final int p4);
    
    public static void pencilSketch(final Mat mat, final Mat mat2, final Mat mat3) {
        pencilSketch_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void pencilSketch(final Mat mat, final Mat mat2, final Mat mat3, final float n, final float n2, final float n3) {
        pencilSketch_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2, n3);
    }
    
    private static native void pencilSketch_0(final long p0, final long p1, final long p2, final float p3, final float p4, final float p5);
    
    private static native void pencilSketch_1(final long p0, final long p1, final long p2);
    
    public static void seamlessClone(final Mat mat, final Mat mat2, final Mat mat3, final Point point, final Mat mat4, final int n) {
        seamlessClone_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y, mat4.nativeObj, n);
    }
    
    private static native void seamlessClone_0(final long p0, final long p1, final long p2, final double p3, final double p4, final long p5, final int p6);
    
    public static void stylization(final Mat mat, final Mat mat2) {
        stylization_1(mat.nativeObj, mat2.nativeObj);
    }
    
    public static void stylization(final Mat mat, final Mat mat2, final float n, final float n2) {
        stylization_0(mat.nativeObj, mat2.nativeObj, n, n2);
    }
    
    private static native void stylization_0(final long p0, final long p1, final float p2, final float p3);
    
    private static native void stylization_1(final long p0, final long p1);
    
    public static void textureFlattening(final Mat mat, final Mat mat2, final Mat mat3) {
        textureFlattening_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
    
    public static void textureFlattening(final Mat mat, final Mat mat2, final Mat mat3, final float n, final float n2, final int n3) {
        textureFlattening_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, n, n2, n3);
    }
    
    private static native void textureFlattening_0(final long p0, final long p1, final long p2, final float p3, final float p4, final int p5);
    
    private static native void textureFlattening_1(final long p0, final long p1, final long p2);
}

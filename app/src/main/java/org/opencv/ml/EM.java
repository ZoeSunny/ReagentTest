package org.opencv.ml;

import java.util.*;
import org.opencv.utils.*;
import org.opencv.core.*;

public class EM extends StatModel
{
    public static final int COV_MAT_DEFAULT = 1;
    public static final int COV_MAT_DIAGONAL = 1;
    public static final int COV_MAT_GENERIC = 2;
    public static final int COV_MAT_SPHERICAL = 0;
    public static final int DEFAULT_MAX_ITERS = 100;
    public static final int DEFAULT_NCLUSTERS = 5;
    public static final int START_AUTO_STEP = 0;
    public static final int START_E_STEP = 1;
    public static final int START_M_STEP = 2;
    
    protected EM(final long n) {
        super(n);
    }
    
    public static EM create() {
        return new EM(create_0());
    }
    
    private static native long create_0();
    
    private static native void delete(final long p0);
    
    private static native int getClustersNumber_0(final long p0);
    
    private static native int getCovarianceMatrixType_0(final long p0);
    
    private static native void getCovs_0(final long p0, final long p1);
    
    private static native long getMeans_0(final long p0);
    
    private static native double[] getTermCriteria_0(final long p0);
    
    private static native long getWeights_0(final long p0);
    
    private static native double[] predict2_0(final long p0, final long p1, final long p2);
    
    private static native void setClustersNumber_0(final long p0, final int p1);
    
    private static native void setCovarianceMatrixType_0(final long p0, final int p1);
    
    private static native void setTermCriteria_0(final long p0, final int p1, final int p2, final double p3);
    
    private static native boolean trainEM_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    private static native boolean trainEM_1(final long p0, final long p1);
    
    private static native boolean trainE_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5, final long p6, final long p7);
    
    private static native boolean trainE_1(final long p0, final long p1, final long p2);
    
    private static native boolean trainM_0(final long p0, final long p1, final long p2, final long p3, final long p4, final long p5);
    
    private static native boolean trainM_1(final long p0, final long p1, final long p2);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int getClustersNumber() {
        return getClustersNumber_0(this.nativeObj);
    }
    
    public int getCovarianceMatrixType() {
        return getCovarianceMatrixType_0(this.nativeObj);
    }
    
    public void getCovs(final List<Mat> list) {
        final Mat mat = new Mat();
        getCovs_0(this.nativeObj, mat.nativeObj);
        Converters.Mat_to_vector_Mat(mat, list);
        mat.release();
    }
    
    public Mat getMeans() {
        return new Mat(getMeans_0(this.nativeObj));
    }
    
    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }
    
    public Mat getWeights() {
        return new Mat(getWeights_0(this.nativeObj));
    }
    
    public double[] predict2(final Mat mat, final Mat mat2) {
        return predict2_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public void setClustersNumber(final int n) {
        setClustersNumber_0(this.nativeObj, n);
    }
    
    public void setCovarianceMatrixType(final int n) {
        setCovarianceMatrixType_0(this.nativeObj, n);
    }
    
    public void setTermCriteria(final TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }
    
    public boolean trainE(final Mat mat, final Mat mat2) {
        return trainE_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public boolean trainE(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5, final Mat mat6, final Mat mat7) {
        return trainE_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj);
    }
    
    public boolean trainEM(final Mat mat) {
        return trainEM_1(this.nativeObj, mat.nativeObj);
    }
    
    public boolean trainEM(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4) {
        return trainEM_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }
    
    public boolean trainM(final Mat mat, final Mat mat2) {
        return trainM_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public boolean trainM(final Mat mat, final Mat mat2, final Mat mat3, final Mat mat4, final Mat mat5) {
        return trainM_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }
}

package org.opencv.core;

public class Mat
{
    public final long nativeObj;
    
    public Mat() {
        this.nativeObj = n_Mat();
    }
    
    public Mat(final int n, final int n2, final int n3) {
        this.nativeObj = n_Mat(n, n2, n3);
    }
    
    public Mat(final int n, final int n2, final int n3, final Scalar scalar) {
        this.nativeObj = n_Mat(n, n2, n3, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public Mat(final long nativeObj) {
        if (nativeObj == 0L) {
            throw new UnsupportedOperationException("Native object address is NULL");
        }
        this.nativeObj = nativeObj;
    }
    
    public Mat(final Mat mat, final Range range) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end);
    }
    
    public Mat(final Mat mat, final Range range, final Range range2) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end, range2.start, range2.end);
    }
    
    public Mat(final Mat mat, final Rect rect) {
        this.nativeObj = n_Mat(mat.nativeObj, rect.y, rect.y + rect.height, rect.x, rect.x + rect.width);
    }
    
    public Mat(final Size size, final int n) {
        this.nativeObj = n_Mat(size.width, size.height, n);
    }
    
    public Mat(final Size size, final int n, final Scalar scalar) {
        this.nativeObj = n_Mat(size.width, size.height, n, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }
    
    public static Mat diag(final Mat mat) {
        return new Mat(n_diag(mat.nativeObj));
    }
    
    public static Mat eye(final int n, final int n2, final int n3) {
        return new Mat(n_eye(n, n2, n3));
    }
    
    public static Mat eye(final Size size, final int n) {
        return new Mat(n_eye(size.width, size.height, n));
    }
    
    private static native void locateROI_0(final long p0, final double[] p1, final double[] p2);
    
    private static native String nDump(final long p0);
    
    private static native double[] nGet(final long p0, final int p1, final int p2);
    
    private static native int nGetB(final long p0, final int p1, final int p2, final int p3, final byte[] p4);
    
    private static native int nGetD(final long p0, final int p1, final int p2, final int p3, final double[] p4);
    
    private static native int nGetF(final long p0, final int p1, final int p2, final int p3, final float[] p4);
    
    private static native int nGetI(final long p0, final int p1, final int p2, final int p3, final int[] p4);
    
    private static native int nGetS(final long p0, final int p1, final int p2, final int p3, final short[] p4);
    
    private static native int nPutB(final long p0, final int p1, final int p2, final int p3, final byte[] p4);
    
    private static native int nPutD(final long p0, final int p1, final int p2, final int p3, final double[] p4);
    
    private static native int nPutF(final long p0, final int p1, final int p2, final int p3, final float[] p4);
    
    private static native int nPutI(final long p0, final int p1, final int p2, final int p3, final int[] p4);
    
    private static native int nPutS(final long p0, final int p1, final int p2, final int p3, final short[] p4);
    
    private static native long n_Mat();
    
    private static native long n_Mat(final double p0, final double p1, final int p2);
    
    private static native long n_Mat(final double p0, final double p1, final int p2, final double p3, final double p4, final double p5, final double p6);
    
    private static native long n_Mat(final int p0, final int p1, final int p2);
    
    private static native long n_Mat(final int p0, final int p1, final int p2, final double p3, final double p4, final double p5, final double p6);
    
    private static native long n_Mat(final long p0, final int p1, final int p2);
    
    private static native long n_Mat(final long p0, final int p1, final int p2, final int p3, final int p4);
    
    private static native long n_adjustROI(final long p0, final int p1, final int p2, final int p3, final int p4);
    
    private static native void n_assignTo(final long p0, final long p1);
    
    private static native void n_assignTo(final long p0, final long p1, final int p2);
    
    private static native int n_channels(final long p0);
    
    private static native int n_checkVector(final long p0, final int p1);
    
    private static native int n_checkVector(final long p0, final int p1, final int p2);
    
    private static native int n_checkVector(final long p0, final int p1, final int p2, final boolean p3);
    
    private static native long n_clone(final long p0);
    
    private static native long n_col(final long p0, final int p1);
    
    private static native long n_colRange(final long p0, final int p1, final int p2);
    
    private static native int n_cols(final long p0);
    
    private static native void n_convertTo(final long p0, final long p1, final int p2);
    
    private static native void n_convertTo(final long p0, final long p1, final int p2, final double p3);
    
    private static native void n_convertTo(final long p0, final long p1, final int p2, final double p3, final double p4);
    
    private static native void n_copyTo(final long p0, final long p1);
    
    private static native void n_copyTo(final long p0, final long p1, final long p2);
    
    private static native void n_create(final long p0, final double p1, final double p2, final int p3);
    
    private static native void n_create(final long p0, final int p1, final int p2, final int p3);
    
    private static native long n_cross(final long p0, final long p1);
    
    private static native long n_dataAddr(final long p0);
    
    private static native void n_delete(final long p0);
    
    private static native int n_depth(final long p0);
    
    private static native long n_diag(final long p0);
    
    private static native long n_diag(final long p0, final int p1);
    
    private static native int n_dims(final long p0);
    
    private static native double n_dot(final long p0, final long p1);
    
    private static native long n_elemSize(final long p0);
    
    private static native long n_elemSize1(final long p0);
    
    private static native boolean n_empty(final long p0);
    
    private static native long n_eye(final double p0, final double p1, final int p2);
    
    private static native long n_eye(final int p0, final int p1, final int p2);
    
    private static native long n_inv(final long p0);
    
    private static native long n_inv(final long p0, final int p1);
    
    private static native boolean n_isContinuous(final long p0);
    
    private static native boolean n_isSubmatrix(final long p0);
    
    private static native long n_mul(final long p0, final long p1);
    
    private static native long n_mul(final long p0, final long p1, final double p2);
    
    private static native long n_ones(final double p0, final double p1, final int p2);
    
    private static native long n_ones(final int p0, final int p1, final int p2);
    
    private static native void n_push_back(final long p0, final long p1);
    
    private static native void n_release(final long p0);
    
    private static native long n_reshape(final long p0, final int p1);
    
    private static native long n_reshape(final long p0, final int p1, final int p2);
    
    private static native long n_row(final long p0, final int p1);
    
    private static native long n_rowRange(final long p0, final int p1, final int p2);
    
    private static native int n_rows(final long p0);
    
    private static native long n_setTo(final long p0, final double p1, final double p2, final double p3, final double p4);
    
    private static native long n_setTo(final long p0, final double p1, final double p2, final double p3, final double p4, final long p5);
    
    private static native long n_setTo(final long p0, final long p1);
    
    private static native long n_setTo(final long p0, final long p1, final long p2);
    
    private static native double[] n_size(final long p0);
    
    private static native long n_step1(final long p0);
    
    private static native long n_step1(final long p0, final int p1);
    
    private static native long n_submat(final long p0, final int p1, final int p2, final int p3, final int p4);
    
    private static native long n_submat_rr(final long p0, final int p1, final int p2, final int p3, final int p4);
    
    private static native long n_t(final long p0);
    
    private static native long n_total(final long p0);
    
    private static native int n_type(final long p0);
    
    private static native long n_zeros(final double p0, final double p1, final int p2);
    
    private static native long n_zeros(final int p0, final int p1, final int p2);
    
    public static Mat ones(final int n, final int n2, final int n3) {
        return new Mat(n_ones(n, n2, n3));
    }
    
    public static Mat ones(final Size size, final int n) {
        return new Mat(n_ones(size.width, size.height, n));
    }
    
    public static Mat zeros(final int n, final int n2, final int n3) {
        return new Mat(n_zeros(n, n2, n3));
    }
    
    public static Mat zeros(final Size size, final int n) {
        return new Mat(n_zeros(size.width, size.height, n));
    }
    
    public Mat adjustROI(final int n, final int n2, final int n3, final int n4) {
        return new Mat(n_adjustROI(this.nativeObj, n, n2, n3, n4));
    }
    
    public void assignTo(final Mat mat) {
        n_assignTo(this.nativeObj, mat.nativeObj);
    }
    
    public void assignTo(final Mat mat, final int n) {
        n_assignTo(this.nativeObj, mat.nativeObj, n);
    }
    
    public int channels() {
        return n_channels(this.nativeObj);
    }
    
    public int checkVector(final int n) {
        return n_checkVector(this.nativeObj, n);
    }
    
    public int checkVector(final int n, final int n2) {
        return n_checkVector(this.nativeObj, n, n2);
    }
    
    public int checkVector(final int n, final int n2, final boolean b) {
        return n_checkVector(this.nativeObj, n, n2, b);
    }
    
    public Mat clone() {
        return new Mat(n_clone(this.nativeObj));
    }
    
    public Mat col(final int n) {
        return new Mat(n_col(this.nativeObj, n));
    }
    
    public Mat colRange(final int n, final int n2) {
        return new Mat(n_colRange(this.nativeObj, n, n2));
    }
    
    public Mat colRange(final Range range) {
        return new Mat(n_colRange(this.nativeObj, range.start, range.end));
    }
    
    public int cols() {
        return n_cols(this.nativeObj);
    }
    
    public void convertTo(final Mat mat, final int n) {
        n_convertTo(this.nativeObj, mat.nativeObj, n);
    }
    
    public void convertTo(final Mat mat, final int n, final double n2) {
        n_convertTo(this.nativeObj, mat.nativeObj, n, n2);
    }
    
    public void convertTo(final Mat mat, final int n, final double n2, final double n3) {
        n_convertTo(this.nativeObj, mat.nativeObj, n, n2, n3);
    }
    
    public void copyTo(final Mat mat) {
        n_copyTo(this.nativeObj, mat.nativeObj);
    }
    
    public void copyTo(final Mat mat, final Mat mat2) {
        n_copyTo(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
    
    public void create(final int n, final int n2, final int n3) {
        n_create(this.nativeObj, n, n2, n3);
    }
    
    public void create(final Size size, final int n) {
        n_create(this.nativeObj, size.width, size.height, n);
    }
    
    public Mat cross(final Mat mat) {
        return new Mat(n_cross(this.nativeObj, mat.nativeObj));
    }
    
    public long dataAddr() {
        return n_dataAddr(this.nativeObj);
    }
    
    public int depth() {
        return n_depth(this.nativeObj);
    }
    
    public Mat diag() {
        return new Mat(n_diag(this.nativeObj, 0));
    }
    
    public Mat diag(final int n) {
        return new Mat(n_diag(this.nativeObj, n));
    }
    
    public int dims() {
        return n_dims(this.nativeObj);
    }
    
    public double dot(final Mat mat) {
        return n_dot(this.nativeObj, mat.nativeObj);
    }
    
    public String dump() {
        return nDump(this.nativeObj);
    }
    
    public long elemSize() {
        return n_elemSize(this.nativeObj);
    }
    
    public long elemSize1() {
        return n_elemSize1(this.nativeObj);
    }
    
    public boolean empty() {
        return n_empty(this.nativeObj);
    }
    
    @Override
    protected void finalize() throws Throwable {
        n_delete(this.nativeObj);
        super.finalize();
    }
    
    public int get(int length, final int n, final byte[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nGetB(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public int get(int length, final int n, final double[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 6) {
            return nGetD(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public int get(int length, final int n, final float[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 5) {
            return nGetF(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public int get(int length, final int n, final int[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 4) {
            return nGetI(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public int get(int length, final int n, final short[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 2 || CvType.depth(type) == 3) {
            return nGetS(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public double[] get(final int n, final int n2) {
        return nGet(this.nativeObj, n, n2);
    }
    
    public long getNativeObjAddr() {
        return this.nativeObj;
    }
    
    public int height() {
        return this.rows();
    }
    
    public Mat inv() {
        return new Mat(n_inv(this.nativeObj));
    }
    
    public Mat inv(final int n) {
        return new Mat(n_inv(this.nativeObj, n));
    }
    
    public boolean isContinuous() {
        return n_isContinuous(this.nativeObj);
    }
    
    public boolean isSubmatrix() {
        return n_isSubmatrix(this.nativeObj);
    }
    
    public void locateROI(final Size size, final Point point) {
        final double[] array = new double[2];
        final double[] array2 = new double[2];
        locateROI_0(this.nativeObj, array, array2);
        if (size != null) {
            size.width = array[0];
            size.height = array[1];
        }
        if (point != null) {
            point.x = array2[0];
            point.y = array2[1];
        }
    }
    
    public Mat mul(final Mat mat) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj));
    }
    
    public Mat mul(final Mat mat, final double n) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj, n));
    }
    
    public void push_back(final Mat mat) {
        n_push_back(this.nativeObj, mat.nativeObj);
    }
    
    public int put(int length, final int n, final byte[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nPutB(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public int put(int length, final int n, final double... array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        return nPutD(this.nativeObj, length, n, array.length, array);
    }
    
    public int put(int length, final int n, final float[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 5) {
            return nPutF(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public int put(int length, final int n, final int[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 4) {
            return nPutI(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public int put(int length, final int n, final short[] array) {
        final int type = this.type();
        if (array == null || array.length % CvType.channels(type) != 0) {
            final StringBuilder append = new StringBuilder().append("Provided data element number (");
            if (array == null) {
                length = 0;
            }
            else {
                length = array.length;
            }
            throw new UnsupportedOperationException(append.append(length).append(") should be multiple of the Mat channels count (").append(CvType.channels(type)).append(")").toString());
        }
        if (CvType.depth(type) == 2 || CvType.depth(type) == 3) {
            return nPutS(this.nativeObj, length, n, array.length, array);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
    }
    
    public void release() {
        n_release(this.nativeObj);
    }
    
    public Mat reshape(final int n) {
        return new Mat(n_reshape(this.nativeObj, n));
    }
    
    public Mat reshape(final int n, final int n2) {
        return new Mat(n_reshape(this.nativeObj, n, n2));
    }
    
    public Mat row(final int n) {
        return new Mat(n_row(this.nativeObj, n));
    }
    
    public Mat rowRange(final int n, final int n2) {
        return new Mat(n_rowRange(this.nativeObj, n, n2));
    }
    
    public Mat rowRange(final Range range) {
        return new Mat(n_rowRange(this.nativeObj, range.start, range.end));
    }
    
    public int rows() {
        return n_rows(this.nativeObj);
    }
    
    public Mat setTo(final Mat mat) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj));
    }
    
    public Mat setTo(final Mat mat, final Mat mat2) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }
    
    public Mat setTo(final Scalar scalar) {
        return new Mat(n_setTo(this.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]));
    }
    
    public Mat setTo(final Scalar scalar, final Mat mat) {
        return new Mat(n_setTo(this.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat.nativeObj));
    }
    
    public Size size() {
        return new Size(n_size(this.nativeObj));
    }
    
    public long step1() {
        return n_step1(this.nativeObj);
    }
    
    public long step1(final int n) {
        return n_step1(this.nativeObj, n);
    }
    
    public Mat submat(final int n, final int n2, final int n3, final int n4) {
        return new Mat(n_submat_rr(this.nativeObj, n, n2, n3, n4));
    }
    
    public Mat submat(final Range range, final Range range2) {
        return new Mat(n_submat_rr(this.nativeObj, range.start, range.end, range2.start, range2.end));
    }
    
    public Mat submat(final Rect rect) {
        return new Mat(n_submat(this.nativeObj, rect.x, rect.y, rect.width, rect.height));
    }
    
    public Mat t() {
        return new Mat(n_t(this.nativeObj));
    }
    
    @Override
    public String toString() {
        return "Mat [ " + this.rows() + "*" + this.cols() + "*" + CvType.typeToString(this.type()) + ", isCont=" + this.isContinuous() + ", isSubmat=" + this.isSubmatrix() + ", nativeObj=0x" + Long.toHexString(this.nativeObj) + ", dataAddr=0x" + Long.toHexString(this.dataAddr()) + " ]";
    }
    
    public long total() {
        return n_total(this.nativeObj);
    }
    
    public int type() {
        return n_type(this.nativeObj);
    }
    
    public int width() {
        return this.cols();
    }
}

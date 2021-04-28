package org.opencv.photo;

import java.util.*;
import org.opencv.core.*;
import org.opencv.utils.*;

public class CalibrateCRF extends Algorithm
{
    protected CalibrateCRF(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native void process_0(final long p0, final long p1, final long p2, final long p3);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public void process(final List<Mat> list, final Mat mat, final Mat mat2) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}

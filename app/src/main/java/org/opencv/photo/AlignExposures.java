package org.opencv.photo;

import java.util.*;
import org.opencv.core.*;
import org.opencv.utils.*;

public class AlignExposures extends Algorithm
{
    protected AlignExposures(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    private static native void process_0(final long p0, final long p1, final long p2, final long p3, final long p4);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public void process(final List<Mat> list, final List<Mat> list2, final Mat mat, final Mat mat2) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}

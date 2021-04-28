package org.opencv.objdetect;

import org.opencv.core.*;

public class Objdetect
{
    public static final int CASCADE_DO_CANNY_PRUNING = 1;
    public static final int CASCADE_DO_ROUGH_SEARCH = 8;
    public static final int CASCADE_FIND_BIGGEST_OBJECT = 4;
    public static final int CASCADE_SCALE_IMAGE = 2;
    
    public static void groupRectangles(final MatOfRect matOfRect, final MatOfInt matOfInt, final int n) {
        groupRectangles_1(matOfRect.nativeObj, matOfInt.nativeObj, n);
    }
    
    public static void groupRectangles(final MatOfRect matOfRect, final MatOfInt matOfInt, final int n, final double n2) {
        groupRectangles_0(matOfRect.nativeObj, matOfInt.nativeObj, n, n2);
    }
    
    private static native void groupRectangles_0(final long p0, final long p1, final int p2, final double p3);
    
    private static native void groupRectangles_1(final long p0, final long p1, final int p2);
}

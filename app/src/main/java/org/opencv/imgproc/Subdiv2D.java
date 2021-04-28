package org.opencv.imgproc;

import java.util.*;
import org.opencv.core.*;
import org.opencv.utils.*;

public class Subdiv2D
{
    public static final int NEXT_AROUND_DST = 34;
    public static final int NEXT_AROUND_LEFT = 19;
    public static final int NEXT_AROUND_ORG = 0;
    public static final int NEXT_AROUND_RIGHT = 49;
    public static final int PREV_AROUND_DST = 51;
    public static final int PREV_AROUND_LEFT = 32;
    public static final int PREV_AROUND_ORG = 17;
    public static final int PREV_AROUND_RIGHT = 2;
    public static final int PTLOC_ERROR = -2;
    public static final int PTLOC_INSIDE = 0;
    public static final int PTLOC_ON_EDGE = 2;
    public static final int PTLOC_OUTSIDE_RECT = -1;
    public static final int PTLOC_VERTEX = 1;
    protected final long nativeObj;
    
    public Subdiv2D() {
        this.nativeObj = Subdiv2D_1();
    }
    
    protected Subdiv2D(final long nativeObj) {
        this.nativeObj = nativeObj;
    }
    
    public Subdiv2D(final Rect rect) {
        this.nativeObj = Subdiv2D_0(rect.x, rect.y, rect.width, rect.height);
    }
    
    private static native long Subdiv2D_0(final int p0, final int p1, final int p2, final int p3);
    
    private static native long Subdiv2D_1();
    
    private static native void delete(final long p0);
    
    private static native int edgeDst_0(final long p0, final int p1, final double[] p2);
    
    private static native int edgeDst_1(final long p0, final int p1);
    
    private static native int edgeOrg_0(final long p0, final int p1, final double[] p2);
    
    private static native int edgeOrg_1(final long p0, final int p1);
    
    private static native int findNearest_0(final long p0, final double p1, final double p2, final double[] p3);
    
    private static native int findNearest_1(final long p0, final double p1, final double p2);
    
    private static native void getEdgeList_0(final long p0, final long p1);
    
    private static native int getEdge_0(final long p0, final int p1, final int p2);
    
    private static native void getTriangleList_0(final long p0, final long p1);
    
    private static native double[] getVertex_0(final long p0, final int p1, final double[] p2);
    
    private static native double[] getVertex_1(final long p0, final int p1);
    
    private static native void getVoronoiFacetList_0(final long p0, final long p1, final long p2, final long p3);
    
    private static native void initDelaunay_0(final long p0, final int p1, final int p2, final int p3, final int p4);
    
    private static native int insert_0(final long p0, final double p1, final double p2);
    
    private static native void insert_1(final long p0, final long p1);
    
    private static native int locate_0(final long p0, final double p1, final double p2, final double[] p3, final double[] p4);
    
    private static native int nextEdge_0(final long p0, final int p1);
    
    private static native int rotateEdge_0(final long p0, final int p1, final int p2);
    
    private static native int symEdge_0(final long p0, final int p1);
    
    public int edgeDst(final int n) {
        return edgeDst_1(this.nativeObj, n);
    }
    
    public int edgeDst(int edgeDst_0, final Point point) {
        final double[] array = new double[2];
        edgeDst_0 = edgeDst_0(this.nativeObj, edgeDst_0, array);
        if (point != null) {
            point.x = array[0];
            point.y = array[1];
        }
        return edgeDst_0;
    }
    
    public int edgeOrg(final int n) {
        return edgeOrg_1(this.nativeObj, n);
    }
    
    public int edgeOrg(int edgeOrg_0, final Point point) {
        final double[] array = new double[2];
        edgeOrg_0 = edgeOrg_0(this.nativeObj, edgeOrg_0, array);
        if (point != null) {
            point.x = array[0];
            point.y = array[1];
        }
        return edgeOrg_0;
    }
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
    
    public int findNearest(final Point point) {
        return findNearest_1(this.nativeObj, point.x, point.y);
    }
    
    public int findNearest(final Point point, final Point point2) {
        final double[] array = new double[2];
        final int nearest_0 = findNearest_0(this.nativeObj, point.x, point.y, array);
        if (point2 != null) {
            point2.x = array[0];
            point2.y = array[1];
        }
        return nearest_0;
    }
    
    public int getEdge(final int n, final int n2) {
        return getEdge_0(this.nativeObj, n, n2);
    }
    
    public void getEdgeList(final MatOfFloat4 matOfFloat4) {
        getEdgeList_0(this.nativeObj, matOfFloat4.nativeObj);
    }
    
    public void getTriangleList(final MatOfFloat6 matOfFloat6) {
        getTriangleList_0(this.nativeObj, matOfFloat6.nativeObj);
    }
    
    public Point getVertex(final int n) {
        return new Point(getVertex_1(this.nativeObj, n));
    }
    
    public Point getVertex(final int n, final int[] array) {
        final double[] array2 = { 0.0 };
        final Point point = new Point(getVertex_0(this.nativeObj, n, array2));
        if (array != null) {
            array[0] = (int)array2[0];
        }
        return point;
    }
    
    public void getVoronoiFacetList(final MatOfInt matOfInt, final List<MatOfPoint2f> list, final MatOfPoint2f matOfPoint2f) {
        final Mat mat = new Mat();
        getVoronoiFacetList_0(this.nativeObj, matOfInt.nativeObj, mat.nativeObj, matOfPoint2f.nativeObj);
        Converters.Mat_to_vector_vector_Point2f(mat, list);
        mat.release();
    }
    
    public void initDelaunay(final Rect rect) {
        initDelaunay_0(this.nativeObj, rect.x, rect.y, rect.width, rect.height);
    }
    
    public int insert(final Point point) {
        return insert_0(this.nativeObj, point.x, point.y);
    }
    
    public void insert(final MatOfPoint2f matOfPoint2f) {
        insert_1(this.nativeObj, matOfPoint2f.nativeObj);
    }
    
    public int locate(final Point point, final int[] array, final int[] array2) {
        final double[] array3 = { 0.0 };
        final double[] array4 = { 0.0 };
        final int locate_0 = locate_0(this.nativeObj, point.x, point.y, array3, array4);
        if (array != null) {
            array[0] = (int)array3[0];
        }
        if (array2 != null) {
            array2[0] = (int)array4[0];
        }
        return locate_0;
    }
    
    public int nextEdge(final int n) {
        return nextEdge_0(this.nativeObj, n);
    }
    
    public int rotateEdge(final int n, final int n2) {
        return rotateEdge_0(this.nativeObj, n, n2);
    }
    
    public int symEdge(final int n) {
        return symEdge_0(this.nativeObj, n);
    }
}

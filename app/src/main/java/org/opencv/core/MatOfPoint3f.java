package org.opencv.core;

import java.util.*;

public class MatOfPoint3f extends Mat
{
    private static final int _channels = 3;
    private static final int _depth = 5;
    
    public MatOfPoint3f() {
    }
    
    protected MatOfPoint3f(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(3, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfPoint3f(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(3, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfPoint3f(final Point3... array) {
        this.fromArray(array);
    }
    
    public static MatOfPoint3f fromNativeAddr(final long n) {
        return new MatOfPoint3f(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(5, 3));
        }
    }
    
    public void fromArray(final Point3... array) {
        if (array == null || array.length == 0) {
            return;
        }
        final int length = array.length;
        this.alloc(length);
        final float[] array2 = new float[length * 3];
        for (int i = 0; i < length; ++i) {
            final Point3 point3 = array[i];
            array2[i * 3 + 0] = (float)point3.x;
            array2[i * 3 + 1] = (float)point3.y;
            array2[i * 3 + 2] = (float)point3.z;
        }
        this.put(0, 0, array2);
    }
    
    public void fromList(final List<Point3> list) {
        this.fromArray((Point3[])list.toArray(new Point3[0]));
    }
    
    public Point3[] toArray() {
        final int n = (int)this.total();
        final Point3[] array = new Point3[n];
        if (n != 0) {
            final float[] array2 = new float[n * 3];
            this.get(0, 0, array2);
            for (int i = 0; i < n; ++i) {
                array[i] = new Point3(array2[i * 3], array2[i * 3 + 1], array2[i * 3 + 2]);
            }
        }
        return array;
    }
    
    public List<Point3> toList() {
        return Arrays.asList(this.toArray());
    }
}

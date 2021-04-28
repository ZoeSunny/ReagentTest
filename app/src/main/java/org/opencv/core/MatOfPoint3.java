package org.opencv.core;

import java.util.*;

public class MatOfPoint3 extends Mat
{
    private static final int _channels = 3;
    private static final int _depth = 4;
    
    public MatOfPoint3() {
    }
    
    protected MatOfPoint3(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(3, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfPoint3(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(3, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfPoint3(final Point3... array) {
        this.fromArray(array);
    }
    
    public static MatOfPoint3 fromNativeAddr(final long n) {
        return new MatOfPoint3(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(4, 3));
        }
    }
    
    public void fromArray(final Point3... array) {
        if (array == null || array.length == 0) {
            return;
        }
        final int length = array.length;
        this.alloc(length);
        final int[] array2 = new int[length * 3];
        for (int i = 0; i < length; ++i) {
            final Point3 point3 = array[i];
            array2[i * 3 + 0] = (int)point3.x;
            array2[i * 3 + 1] = (int)point3.y;
            array2[i * 3 + 2] = (int)point3.z;
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
            final int[] array2 = new int[n * 3];
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

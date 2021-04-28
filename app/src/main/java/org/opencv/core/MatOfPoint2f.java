package org.opencv.core;

import java.util.*;

public class MatOfPoint2f extends Mat
{
    private static final int _channels = 2;
    private static final int _depth = 5;
    
    public MatOfPoint2f() {
    }
    
    protected MatOfPoint2f(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(2, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfPoint2f(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(2, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfPoint2f(final Point... array) {
        this.fromArray(array);
    }
    
    public static MatOfPoint2f fromNativeAddr(final long n) {
        return new MatOfPoint2f(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(5, 2));
        }
    }
    
    public void fromArray(final Point... array) {
        if (array == null || array.length == 0) {
            return;
        }
        final int length = array.length;
        this.alloc(length);
        final float[] array2 = new float[length * 2];
        for (int i = 0; i < length; ++i) {
            final Point point = array[i];
            array2[i * 2 + 0] = (float)point.x;
            array2[i * 2 + 1] = (float)point.y;
        }
        this.put(0, 0, array2);
    }
    
    public void fromList(final List<Point> list) {
        this.fromArray((Point[])list.toArray(new Point[0]));
    }
    
    public Point[] toArray() {
        final int n = (int)this.total();
        final Point[] array = new Point[n];
        if (n != 0) {
            final float[] array2 = new float[n * 2];
            this.get(0, 0, array2);
            for (int i = 0; i < n; ++i) {
                array[i] = new Point(array2[i * 2], array2[i * 2 + 1]);
            }
        }
        return array;
    }
    
    public List<Point> toList() {
        return Arrays.asList(this.toArray());
    }
}

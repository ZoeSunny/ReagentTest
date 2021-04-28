package org.opencv.core;

import java.util.*;

public class MatOfPoint extends Mat
{
    private static final int _channels = 2;
    private static final int _depth = 4;
    
    public MatOfPoint() {
    }
    
    protected MatOfPoint(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfPoint(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfPoint(final Point... array) {
        this.fromArray(array);
    }
    
    public static MatOfPoint fromNativeAddr(final long n) {
        return new MatOfPoint(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(4, 2));
        }
    }
    
    public void fromArray(final Point... array) {
        if (array == null || array.length == 0) {
            return;
        }
        final int length = array.length;
        this.alloc(length);
        final int[] array2 = new int[length * 2];
        for (int i = 0; i < length; ++i) {
            final Point point = array[i];
            array2[i * 2 + 0] = (int)point.x;
            array2[i * 2 + 1] = (int)point.y;
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
            final int[] array2 = new int[n * 2];
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

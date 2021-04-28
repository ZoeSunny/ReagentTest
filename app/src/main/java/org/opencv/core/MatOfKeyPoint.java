package org.opencv.core;

import java.util.*;

public class MatOfKeyPoint extends Mat
{
    private static final int _channels = 7;
    private static final int _depth = 5;
    
    public MatOfKeyPoint() {
    }
    
    protected MatOfKeyPoint(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(7, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfKeyPoint(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(7, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfKeyPoint(final KeyPoint... array) {
        this.fromArray(array);
    }
    
    public static MatOfKeyPoint fromNativeAddr(final long n) {
        return new MatOfKeyPoint(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(5, 7));
        }
    }
    
    public void fromArray(final KeyPoint... array) {
        if (array == null || array.length == 0) {
            return;
        }
        final int length = array.length;
        this.alloc(length);
        final float[] array2 = new float[length * 7];
        for (int i = 0; i < length; ++i) {
            final KeyPoint keyPoint = array[i];
            array2[i * 7 + 0] = (float)keyPoint.pt.x;
            array2[i * 7 + 1] = (float)keyPoint.pt.y;
            array2[i * 7 + 2] = keyPoint.size;
            array2[i * 7 + 3] = keyPoint.angle;
            array2[i * 7 + 4] = keyPoint.response;
            array2[i * 7 + 5] = (float)keyPoint.octave;
            array2[i * 7 + 6] = (float)keyPoint.class_id;
        }
        this.put(0, 0, array2);
    }
    
    public void fromList(final List<KeyPoint> list) {
        this.fromArray((KeyPoint[])list.toArray(new KeyPoint[0]));
    }
    
    public KeyPoint[] toArray() {
        final int n = (int)this.total();
        final KeyPoint[] array = new KeyPoint[n];
        if (n != 0) {
            final float[] array2 = new float[n * 7];
            this.get(0, 0, array2);
            for (int i = 0; i < n; ++i) {
                array[i] = new KeyPoint(array2[i * 7 + 0], array2[i * 7 + 1], array2[i * 7 + 2], array2[i * 7 + 3], array2[i * 7 + 4], (int)array2[i * 7 + 5], (int)array2[i * 7 + 6]);
            }
        }
        return array;
    }
    
    public List<KeyPoint> toList() {
        return Arrays.asList(this.toArray());
    }
}

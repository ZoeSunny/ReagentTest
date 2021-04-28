package org.opencv.core;

import java.util.*;

public class MatOfDMatch extends Mat
{
    private static final int _channels = 4;
    private static final int _depth = 5;
    
    public MatOfDMatch() {
    }
    
    protected MatOfDMatch(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(4, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat: " + this.toString());
        }
    }
    
    public MatOfDMatch(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(4, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat: " + this.toString());
        }
    }
    
    public MatOfDMatch(final DMatch... array) {
        this.fromArray(array);
    }
    
    public static MatOfDMatch fromNativeAddr(final long n) {
        return new MatOfDMatch(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(5, 4));
        }
    }
    
    public void fromArray(final DMatch... array) {
        if (array == null || array.length == 0) {
            return;
        }
        final int length = array.length;
        this.alloc(length);
        final float[] array2 = new float[length * 4];
        for (int i = 0; i < length; ++i) {
            final DMatch dMatch = array[i];
            array2[i * 4 + 0] = (float)dMatch.queryIdx;
            array2[i * 4 + 1] = (float)dMatch.trainIdx;
            array2[i * 4 + 2] = (float)dMatch.imgIdx;
            array2[i * 4 + 3] = dMatch.distance;
        }
        this.put(0, 0, array2);
    }
    
    public void fromList(final List<DMatch> list) {
        this.fromArray((DMatch[])list.toArray(new DMatch[0]));
    }
    
    public DMatch[] toArray() {
        final int n = (int)this.total();
        final DMatch[] array = new DMatch[n];
        if (n != 0) {
            final float[] array2 = new float[n * 4];
            this.get(0, 0, array2);
            for (int i = 0; i < n; ++i) {
                array[i] = new DMatch((int)array2[i * 4 + 0], (int)array2[i * 4 + 1], (int)array2[i * 4 + 2], array2[i * 4 + 3]);
            }
        }
        return array;
    }
    
    public List<DMatch> toList() {
        return Arrays.asList(this.toArray());
    }
}

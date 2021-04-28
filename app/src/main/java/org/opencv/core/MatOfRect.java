package org.opencv.core;

import java.util.*;

public class MatOfRect extends Mat
{
    private static final int _channels = 4;
    private static final int _depth = 4;
    
    public MatOfRect() {
    }
    
    protected MatOfRect(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfRect(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfRect(final Rect... array) {
        this.fromArray(array);
    }
    
    public static MatOfRect fromNativeAddr(final long n) {
        return new MatOfRect(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(4, 4));
        }
    }
    
    public void fromArray(final Rect... array) {
        if (array == null || array.length == 0) {
            return;
        }
        final int length = array.length;
        this.alloc(length);
        final int[] array2 = new int[length * 4];
        for (int i = 0; i < length; ++i) {
            final Rect rect = array[i];
            array2[i * 4 + 0] = rect.x;
            array2[i * 4 + 1] = rect.y;
            array2[i * 4 + 2] = rect.width;
            array2[i * 4 + 3] = rect.height;
        }
        this.put(0, 0, array2);
    }
    
    public void fromList(final List<Rect> list) {
        this.fromArray((Rect[])list.toArray(new Rect[0]));
    }
    
    public Rect[] toArray() {
        final int n = (int)this.total();
        final Rect[] array = new Rect[n];
        if (n != 0) {
            final int[] array2 = new int[n * 4];
            this.get(0, 0, array2);
            for (int i = 0; i < n; ++i) {
                array[i] = new Rect(array2[i * 4], array2[i * 4 + 1], array2[i * 4 + 2], array2[i * 4 + 3]);
            }
        }
        return array;
    }
    
    public List<Rect> toList() {
        return Arrays.asList(this.toArray());
    }
}

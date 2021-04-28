package org.opencv.core;

import java.util.*;

public class MatOfInt4 extends Mat
{
    private static final int _channels = 4;
    private static final int _depth = 4;
    
    public MatOfInt4() {
    }
    
    protected MatOfInt4(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfInt4(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfInt4(final int... array) {
        this.fromArray(array);
    }
    
    public static MatOfInt4 fromNativeAddr(final long n) {
        return new MatOfInt4(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(4, 4));
        }
    }
    
    public void fromArray(final int... array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.alloc(array.length / 4);
        this.put(0, 0, array);
    }
    
    public void fromList(final List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        final Integer[] array = list.toArray(new Integer[0]);
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        this.fromArray(array2);
    }
    
    public int[] toArray() {
        final int checkVector = this.checkVector(4, 4);
        if (checkVector < 0) {
            throw new RuntimeException("Native Mat has unexpected type or size: " + this.toString());
        }
        final int[] array = new int[checkVector * 4];
        if (checkVector == 0) {
            return array;
        }
        this.get(0, 0, array);
        return array;
    }
    
    public List<Integer> toList() {
        final int[] array = this.toArray();
        final Integer[] array2 = new Integer[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return Arrays.asList(array2);
    }
}

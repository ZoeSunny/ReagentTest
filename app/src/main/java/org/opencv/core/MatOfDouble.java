package org.opencv.core;

import java.util.*;

public class MatOfDouble extends Mat
{
    private static final int _channels = 1;
    private static final int _depth = 6;
    
    public MatOfDouble() {
    }
    
    protected MatOfDouble(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfDouble(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfDouble(final double... array) {
        this.fromArray(array);
    }
    
    public static MatOfDouble fromNativeAddr(final long n) {
        return new MatOfDouble(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(6, 1));
        }
    }
    
    public void fromArray(final double... array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.alloc(array.length / 1);
        this.put(0, 0, array);
    }
    
    public void fromList(final List<Double> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        final Double[] array = list.toArray(new Double[0]);
        final double[] array2 = new double[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        this.fromArray(array2);
    }
    
    public double[] toArray() {
        final int checkVector = this.checkVector(1, 6);
        if (checkVector < 0) {
            throw new RuntimeException("Native Mat has unexpected type or size: " + this.toString());
        }
        final double[] array = new double[checkVector * 1];
        if (checkVector == 0) {
            return array;
        }
        this.get(0, 0, array);
        return array;
    }
    
    public List<Double> toList() {
        final double[] array = this.toArray();
        final Double[] array2 = new Double[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return Arrays.asList(array2);
    }
}

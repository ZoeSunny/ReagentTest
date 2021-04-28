package org.opencv.core;

import java.util.*;

public class MatOfFloat extends Mat
{
    private static final int _channels = 1;
    private static final int _depth = 5;
    
    public MatOfFloat() {
    }
    
    protected MatOfFloat(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(1, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfFloat(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(1, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfFloat(final float... array) {
        this.fromArray(array);
    }
    
    public static MatOfFloat fromNativeAddr(final long n) {
        return new MatOfFloat(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(5, 1));
        }
    }
    
    public void fromArray(final float... array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.alloc(array.length / 1);
        this.put(0, 0, array);
    }
    
    public void fromList(final List<Float> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        final Float[] array = list.toArray(new Float[0]);
        final float[] array2 = new float[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        this.fromArray(array2);
    }
    
    public float[] toArray() {
        final int checkVector = this.checkVector(1, 5);
        if (checkVector < 0) {
            throw new RuntimeException("Native Mat has unexpected type or size: " + this.toString());
        }
        final float[] array = new float[checkVector * 1];
        if (checkVector == 0) {
            return array;
        }
        this.get(0, 0, array);
        return array;
    }
    
    public List<Float> toList() {
        final float[] array = this.toArray();
        final Float[] array2 = new Float[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return Arrays.asList(array2);
    }
}

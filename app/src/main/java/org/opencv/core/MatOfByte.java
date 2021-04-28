package org.opencv.core;

import java.util.*;

public class MatOfByte extends Mat
{
    private static final int _channels = 1;
    private static final int _depth = 0;
    
    public MatOfByte() {
    }
    
    protected MatOfByte(final long n) {
        super(n);
        if (!this.empty() && this.checkVector(1, 0) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfByte(final Mat mat) {
        super(mat, Range.all());
        if (!this.empty() && this.checkVector(1, 0) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
    
    public MatOfByte(final byte... array) {
        this.fromArray(array);
    }
    
    public static MatOfByte fromNativeAddr(final long n) {
        return new MatOfByte(n);
    }
    
    public void alloc(final int n) {
        if (n > 0) {
            super.create(n, 1, CvType.makeType(0, 1));
        }
    }
    
    public void fromArray(final byte... array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.alloc(array.length / 1);
        this.put(0, 0, array);
    }
    
    public void fromList(final List<Byte> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        final Byte[] array = list.toArray(new Byte[0]);
        final byte[] array2 = new byte[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        this.fromArray(array2);
    }
    
    public byte[] toArray() {
        final int checkVector = this.checkVector(1, 0);
        if (checkVector < 0) {
            throw new RuntimeException("Native Mat has unexpected type or size: " + this.toString());
        }
        final byte[] array = new byte[checkVector * 1];
        if (checkVector == 0) {
            return array;
        }
        this.get(0, 0, array);
        return array;
    }
    
    public List<Byte> toList() {
        final byte[] array = this.toArray();
        final Byte[] array2 = new Byte[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return Arrays.asList(array2);
    }
}

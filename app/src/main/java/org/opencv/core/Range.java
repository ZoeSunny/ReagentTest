package org.opencv.core;

public class Range
{
    public int end;
    public int start;
    
    public Range() {
        this(0, 0);
    }
    
    public Range(final int start, final int end) {
        this.start = start;
        this.end = end;
    }
    
    public Range(final double[] array) {
        this.set(array);
    }
    
    public static Range all() {
        return new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public Range clone() {
        return new Range(this.start, this.end);
    }
    
    public boolean empty() {
        return this.end <= this.start;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof Range)) {
                return false;
            }
            final Range range = (Range)o;
            if (this.start != range.start || this.end != range.end) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.start);
        final int n = (int)(doubleToLongBits >>> 32 ^ doubleToLongBits);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.end);
        return (n + 31) * 31 + (int)(doubleToLongBits2 >>> 32 ^ doubleToLongBits2);
    }
    
    public Range intersection(Range range) {
        range = new Range(Math.max(range.start, this.start), Math.min(range.end, this.end));
        range.end = Math.max(range.end, range.start);
        return range;
    }
    
    public void set(final double[] array) {
        final int n = 0;
        if (array != null) {
            int start;
            if (array.length > 0) {
                start = (int)array[0];
            }
            else {
                start = 0;
            }
            this.start = start;
            int end = n;
            if (array.length > 1) {
                end = (int)array[1];
            }
            this.end = end;
            return;
        }
        this.start = 0;
        this.end = 0;
    }
    
    public Range shift(final int n) {
        return new Range(this.start + n, this.end + n);
    }
    
    public int size() {
        if (this.empty()) {
            return 0;
        }
        return this.end - this.start;
    }
    
    @Override
    public String toString() {
        return "[" + this.start + ", " + this.end + ")";
    }
}

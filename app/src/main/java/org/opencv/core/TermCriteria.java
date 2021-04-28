package org.opencv.core;

public class TermCriteria
{
    public static final int COUNT = 1;
    public static final int EPS = 2;
    public static final int MAX_ITER = 1;
    public double epsilon;
    public int maxCount;
    public int type;
    
    public TermCriteria() {
        this(0, 0, 0.0);
    }
    
    public TermCriteria(final int type, final int maxCount, final double epsilon) {
        this.type = type;
        this.maxCount = maxCount;
        this.epsilon = epsilon;
    }
    
    public TermCriteria(final double[] array) {
        this.set(array);
    }
    
    public TermCriteria clone() {
        return new TermCriteria(this.type, this.maxCount, this.epsilon);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof TermCriteria)) {
                return false;
            }
            final TermCriteria termCriteria = (TermCriteria)o;
            if (this.type != termCriteria.type || this.maxCount != termCriteria.maxCount || this.epsilon != termCriteria.epsilon) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.type);
        final int n = (int)(doubleToLongBits >>> 32 ^ doubleToLongBits);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.maxCount);
        final int n2 = (int)(doubleToLongBits2 >>> 32 ^ doubleToLongBits2);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.epsilon);
        return ((n + 31) * 31 + n2) * 31 + (int)(doubleToLongBits3 >>> 32 ^ doubleToLongBits3);
    }
    
    public void set(final double[] array) {
        final int n = 0;
        if (array != null) {
            int type;
            if (array.length > 0) {
                type = (int)array[0];
            }
            else {
                type = 0;
            }
            this.type = type;
            int maxCount = n;
            if (array.length > 1) {
                maxCount = (int)array[1];
            }
            this.maxCount = maxCount;
            double epsilon;
            if (array.length > 2) {
                epsilon = array[2];
            }
            else {
                epsilon = 0.0;
            }
            this.epsilon = epsilon;
            return;
        }
        this.type = 0;
        this.maxCount = 0;
        this.epsilon = 0.0;
    }
    
    @Override
    public String toString() {
        return "{ type: " + this.type + ", maxCount: " + this.maxCount + ", epsilon: " + this.epsilon + "}";
    }
}

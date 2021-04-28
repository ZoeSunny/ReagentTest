package org.opencv.core;

public class Point
{
    public double x;
    public double y;
    
    public Point() {
        this(0.0, 0.0);
    }
    
    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(final double[] array) {
        this();
        this.set(array);
    }
    
    public Point clone() {
        return new Point(this.x, this.y);
    }
    
    public double dot(final Point point) {
        return this.x * point.x + this.y * point.y;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof Point)) {
                return false;
            }
            final Point point = (Point)o;
            if (this.x != point.x || this.y != point.y) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.x);
        final int n = (int)(doubleToLongBits >>> 32 ^ doubleToLongBits);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        return (n + 31) * 31 + (int)(doubleToLongBits2 >>> 32 ^ doubleToLongBits2);
    }
    
    public boolean inside(final Rect rect) {
        return rect.contains(this);
    }
    
    public void set(final double[] array) {
        final double n = 0.0;
        if (array != null) {
            double x;
            if (array.length > 0) {
                x = array[0];
            }
            else {
                x = 0.0;
            }
            this.x = x;
            double y = n;
            if (array.length > 1) {
                y = array[1];
            }
            this.y = y;
            return;
        }
        this.x = 0.0;
        this.y = 0.0;
    }
    
    @Override
    public String toString() {
        return "{" + this.x + ", " + this.y + "}";
    }
}

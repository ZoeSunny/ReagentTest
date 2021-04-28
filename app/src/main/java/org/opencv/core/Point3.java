package org.opencv.core;

public class Point3
{
    public double x;
    public double y;
    public double z;
    
    public Point3() {
        this(0.0, 0.0, 0.0);
    }
    
    public Point3(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Point3(final Point point) {
        this.x = point.x;
        this.y = point.y;
        this.z = 0.0;
    }
    
    public Point3(final double[] array) {
        this();
        this.set(array);
    }
    
    public Point3 clone() {
        return new Point3(this.x, this.y, this.z);
    }
    
    public Point3 cross(final Point3 point3) {
        return new Point3(this.y * point3.z - this.z * point3.y, this.z * point3.x - this.x * point3.z, this.x * point3.y - this.y * point3.x);
    }
    
    public double dot(final Point3 point3) {
        return this.x * point3.x + this.y * point3.y + this.z * point3.z;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof Point3)) {
                return false;
            }
            final Point3 point3 = (Point3)o;
            if (this.x != point3.x || this.y != point3.y || this.z != point3.z) {
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
        final int n2 = (int)(doubleToLongBits2 >>> 32 ^ doubleToLongBits2);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.z);
        return ((n + 31) * 31 + n2) * 31 + (int)(doubleToLongBits3 >>> 32 ^ doubleToLongBits3);
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
            double y;
            if (array.length > 1) {
                y = array[1];
            }
            else {
                y = 0.0;
            }
            this.y = y;
            double z = n;
            if (array.length > 2) {
                z = array[2];
            }
            this.z = z;
            return;
        }
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    
    @Override
    public String toString() {
        return "{" + this.x + ", " + this.y + ", " + this.z + "}";
    }
}

package org.opencv.core;

public class Size
{
    public double height;
    public double width;
    
    public Size() {
        this(0.0, 0.0);
    }
    
    public Size(final double width, final double height) {
        this.width = width;
        this.height = height;
    }
    
    public Size(final Point point) {
        this.width = point.x;
        this.height = point.y;
    }
    
    public Size(final double[] array) {
        this.set(array);
    }
    
    public double area() {
        return this.width * this.height;
    }
    
    public Size clone() {
        return new Size(this.width, this.height);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof Size)) {
                return false;
            }
            final Size size = (Size)o;
            if (this.width != size.width || this.height != size.height) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.height);
        final int n = (int)(doubleToLongBits >>> 32 ^ doubleToLongBits);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        return (n + 31) * 31 + (int)(doubleToLongBits2 >>> 32 ^ doubleToLongBits2);
    }
    
    public void set(final double[] array) {
        final double n = 0.0;
        if (array != null) {
            double width;
            if (array.length > 0) {
                width = array[0];
            }
            else {
                width = 0.0;
            }
            this.width = width;
            double height = n;
            if (array.length > 1) {
                height = array[1];
            }
            this.height = height;
            return;
        }
        this.width = 0.0;
        this.height = 0.0;
    }
    
    @Override
    public String toString() {
        return (int)this.width + "x" + (int)this.height;
    }
}

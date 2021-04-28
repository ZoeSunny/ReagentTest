package org.opencv.core;

public class Rect
{
    public int height;
    public int width;
    public int x;
    public int y;
    
    public Rect() {
        this(0, 0, 0, 0);
    }
    
    public Rect(final int x, final int y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public Rect(final Point point, final Point point2) {
        double n;
        if (point.x < point2.x) {
            n = point.x;
        }
        else {
            n = point2.x;
        }
        this.x = (int)n;
        double n2;
        if (point.y < point2.y) {
            n2 = point.y;
        }
        else {
            n2 = point2.y;
        }
        this.y = (int)n2;
        double n3;
        if (point.x > point2.x) {
            n3 = point.x;
        }
        else {
            n3 = point2.x;
        }
        this.width = (int)n3 - this.x;
        double n4;
        if (point.y > point2.y) {
            n4 = point.y;
        }
        else {
            n4 = point2.y;
        }
        this.height = (int)n4 - this.y;
    }
    
    public Rect(final Point point, final Size size) {
        this((int)point.x, (int)point.y, (int)size.width, (int)size.height);
    }
    
    public Rect(final double[] array) {
        this.set(array);
    }
    
    public double area() {
        return this.width * this.height;
    }
    
    public Point br() {
        return new Point(this.x + this.width, this.y + this.height);
    }
    
    public Rect clone() {
        return new Rect(this.x, this.y, this.width, this.height);
    }
    
    public boolean contains(final Point point) {
        return this.x <= point.x && point.x < this.x + this.width && this.y <= point.y && point.y < this.y + this.height;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof Rect)) {
                return false;
            }
            final Rect rect = (Rect)o;
            if (this.x != rect.x || this.y != rect.y || this.width != rect.width || this.height != rect.height) {
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
        final int n2 = (int)(doubleToLongBits2 >>> 32 ^ doubleToLongBits2);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.x);
        final int n3 = (int)(doubleToLongBits3 >>> 32 ^ doubleToLongBits3);
        final long doubleToLongBits4 = Double.doubleToLongBits(this.y);
        return (((n + 31) * 31 + n2) * 31 + n3) * 31 + (int)(doubleToLongBits4 >>> 32 ^ doubleToLongBits4);
    }
    
    public void set(final double[] array) {
        final int n = 0;
        if (array != null) {
            int x;
            if (array.length > 0) {
                x = (int)array[0];
            }
            else {
                x = 0;
            }
            this.x = x;
            int y;
            if (array.length > 1) {
                y = (int)array[1];
            }
            else {
                y = 0;
            }
            this.y = y;
            int width;
            if (array.length > 2) {
                width = (int)array[2];
            }
            else {
                width = 0;
            }
            this.width = width;
            int height = n;
            if (array.length > 3) {
                height = (int)array[3];
            }
            this.height = height;
            return;
        }
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }
    
    public Size size() {
        return new Size(this.width, this.height);
    }
    
    public Point tl() {
        return new Point(this.x, this.y);
    }
    
    @Override
    public String toString() {
        return "{" + this.x + ", " + this.y + ", " + this.width + "x" + this.height + "}";
    }
}

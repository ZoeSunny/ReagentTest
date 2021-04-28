package org.opencv.core;

public class RotatedRect
{
    public double angle;
    public Point center;
    public Size size;
    
    public RotatedRect() {
        this.center = new Point();
        this.size = new Size();
        this.angle = 0.0;
    }
    
    public RotatedRect(final Point point, final Size size, final double angle) {
        this.center = point.clone();
        this.size = size.clone();
        this.angle = angle;
    }
    
    public RotatedRect(final double[] array) {
        this();
        this.set(array);
    }
    
    public Rect boundingRect() {
        final Point[] array = new Point[4];
        this.points(array);
        final Rect rect = new Rect((int)Math.floor(Math.min(Math.min(Math.min(array[0].x, array[1].x), array[2].x), array[3].x)), (int)Math.floor(Math.min(Math.min(Math.min(array[0].y, array[1].y), array[2].y), array[3].y)), (int)Math.ceil(Math.max(Math.max(Math.max(array[0].x, array[1].x), array[2].x), array[3].x)), (int)Math.ceil(Math.max(Math.max(Math.max(array[0].y, array[1].y), array[2].y), array[3].y)));
        rect.width -= rect.x - 1;
        rect.height -= rect.y - 1;
        return rect;
    }
    
    public RotatedRect clone() {
        return new RotatedRect(this.center, this.size, this.angle);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof RotatedRect)) {
                return false;
            }
            final RotatedRect rotatedRect = (RotatedRect)o;
            if (!this.center.equals(rotatedRect.center) || !this.size.equals(rotatedRect.size) || this.angle != rotatedRect.angle) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.center.x);
        final int n = (int)(doubleToLongBits >>> 32 ^ doubleToLongBits);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.center.y);
        final int n2 = (int)(doubleToLongBits2 >>> 32 ^ doubleToLongBits2);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.size.width);
        final int n3 = (int)(doubleToLongBits3 >>> 32 ^ doubleToLongBits3);
        final long doubleToLongBits4 = Double.doubleToLongBits(this.size.height);
        final int n4 = (int)(doubleToLongBits4 >>> 32 ^ doubleToLongBits4);
        final long doubleToLongBits5 = Double.doubleToLongBits(this.angle);
        return ((((n + 31) * 31 + n2) * 31 + n3) * 31 + n4) * 31 + (int)(doubleToLongBits5 >>> 32 ^ doubleToLongBits5);
    }
    
    public void points(final Point[] array) {
        final double n = this.angle * 3.141592653589793 / 180.0;
        final double n2 = Math.cos(n) * 0.5;
        final double n3 = Math.sin(n) * 0.5;
        array[0] = new Point(this.center.x - this.size.height * n3 - this.size.width * n2, this.center.y + this.size.height * n2 - this.size.width * n3);
        array[1] = new Point(this.center.x + this.size.height * n3 - this.size.width * n2, this.center.y - this.size.height * n2 - this.size.width * n3);
        array[2] = new Point(2.0 * this.center.x - array[0].x, 2.0 * this.center.y - array[0].y);
        array[3] = new Point(2.0 * this.center.x - array[1].x, 2.0 * this.center.y - array[1].y);
    }
    
    public void set(final double[] array) {
        final double n = 0.0;
        if (array != null) {
            final Point center = this.center;
            double x;
            if (array.length > 0) {
                x = array[0];
            }
            else {
                x = 0.0;
            }
            center.x = x;
            final Point center2 = this.center;
            double y;
            if (array.length > 1) {
                y = array[1];
            }
            else {
                y = 0.0;
            }
            center2.y = y;
            final Size size = this.size;
            double width;
            if (array.length > 2) {
                width = array[2];
            }
            else {
                width = 0.0;
            }
            size.width = width;
            final Size size2 = this.size;
            double height;
            if (array.length > 3) {
                height = array[3];
            }
            else {
                height = 0.0;
            }
            size2.height = height;
            double angle = n;
            if (array.length > 4) {
                angle = array[4];
            }
            this.angle = angle;
            return;
        }
        this.center.x = 0.0;
        this.center.x = 0.0;
        this.size.width = 0.0;
        this.size.height = 0.0;
        this.angle = 0.0;
    }
    
    @Override
    public String toString() {
        return "{ " + this.center + " " + this.size + " * " + this.angle + " }";
    }
}

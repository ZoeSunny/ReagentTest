package org.opencv.core;

public class KeyPoint
{
    public float angle;
    public int class_id;
    public int octave;
    public Point pt;
    public float response;
    public float size;
    
    public KeyPoint() {
        this(0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0, -1);
    }
    
    public KeyPoint(final float n, final float n2, final float n3) {
        this(n, n2, n3, -1.0f, 0.0f, 0, -1);
    }
    
    public KeyPoint(final float n, final float n2, final float n3, final float n4) {
        this(n, n2, n3, n4, 0.0f, 0, -1);
    }
    
    public KeyPoint(final float n, final float n2, final float n3, final float n4, final float n5) {
        this(n, n2, n3, n4, n5, 0, -1);
    }
    
    public KeyPoint(final float n, final float n2, final float n3, final float n4, final float n5, final int n6) {
        this(n, n2, n3, n4, n5, n6, -1);
    }
    
    public KeyPoint(final float n, final float n2, final float size, final float angle, final float response, final int octave, final int class_id) {
        this.pt = new Point(n, n2);
        this.size = size;
        this.angle = angle;
        this.response = response;
        this.octave = octave;
        this.class_id = class_id;
    }
    
    @Override
    public String toString() {
        return "KeyPoint [pt=" + this.pt + ", size=" + this.size + ", angle=" + this.angle + ", response=" + this.response + ", octave=" + this.octave + ", class_id=" + this.class_id + "]";
    }
}

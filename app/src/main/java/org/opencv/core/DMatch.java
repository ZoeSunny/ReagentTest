package org.opencv.core;

public class DMatch
{
    public float distance;
    public int imgIdx;
    public int queryIdx;
    public int trainIdx;
    
    public DMatch() {
        this(-1, -1, Float.MAX_VALUE);
    }
    
    public DMatch(final int queryIdx, final int trainIdx, final float distance) {
        this.queryIdx = queryIdx;
        this.trainIdx = trainIdx;
        this.imgIdx = -1;
        this.distance = distance;
    }
    
    public DMatch(final int queryIdx, final int trainIdx, final int imgIdx, final float distance) {
        this.queryIdx = queryIdx;
        this.trainIdx = trainIdx;
        this.imgIdx = imgIdx;
        this.distance = distance;
    }
    
    public boolean lessThan(final DMatch dMatch) {
        return this.distance < dMatch.distance;
    }
    
    @Override
    public String toString() {
        return "DMatch [queryIdx=" + this.queryIdx + ", trainIdx=" + this.trainIdx + ", imgIdx=" + this.imgIdx + ", distance=" + this.distance + "]";
    }
}

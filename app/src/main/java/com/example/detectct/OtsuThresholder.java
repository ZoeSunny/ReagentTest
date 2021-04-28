package com.example.detectct;

public class OtsuThresholder
{
    private int[] histData;
    private int maxLevelValue;
    private int threshold;
    
    public OtsuThresholder() {
        this.histData = new int[256];
    }
    
    public int doThreshold(final int[] array) {
        for (int i = 0; i < this.histData.length; ++i) {
            this.histData[i] = 0;
        }
        int j = 0;
        this.maxLevelValue = 0;
        while (j < array.length) {
            final int n = array[j] & 0xFF;
            final int[] histData = this.histData;
            ++histData[n];
            if (this.histData[n] > this.maxLevelValue) {
                this.maxLevelValue = this.histData[n];
            }
            ++j;
        }
        final int length = array.length;
        float n2 = 0.0f;
        for (int k = 0; k < 256; ++k) {
            n2 += this.histData[k] * k;
        }
        float n3 = 0.0f;
        int n4 = 0;
        float n5 = 0.0f;
        this.threshold = 0;
        float n6;
        for (int l = 0; l < 256; ++l, n5 = n6) {
            n4 += this.histData[l];
            if (n4 == 0) {
                n6 = n5;
            }
            else {
                final int n7 = length - n4;
                if (n7 == 0) {
                    break;
                }
                final float n8 = n3 + this.histData[l] * l;
                final float n9 = n8 / n4;
                final float n10 = (n2 - n8) / n7;
                final float n11 = n4 * (float)n7 * (n9 - n10) * (n9 - n10);
                n3 = n8;
                n6 = n5;
                if (n11 > n5) {
                    n6 = n11;
                    this.threshold = l;
                    n3 = n8;
                }
            }
        }
        return this.threshold;
    }
    
    public int[] getHistData() {
        return this.histData;
    }
    
    public int getMaxLevelValue() {
        return this.maxLevelValue;
    }
    
    public int getThreshold() {
        return this.threshold;
    }
}

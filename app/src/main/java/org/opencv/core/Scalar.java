package org.opencv.core;

import java.util.*;

public class Scalar
{
    public double[] val;
    
    public Scalar(final double n) {
        this.val = new double[] { n, 0.0, 0.0, 0.0 };
    }
    
    public Scalar(final double n, final double n2) {
        this.val = new double[] { n, n2, 0.0, 0.0 };
    }
    
    public Scalar(final double n, final double n2, final double n3) {
        this.val = new double[] { n, n2, n3, 0.0 };
    }
    
    public Scalar(final double n, final double n2, final double n3, final double n4) {
        this.val = new double[] { n, n2, n3, n4 };
    }
    
    public Scalar(final double[] array) {
        if (array != null && array.length == 4) {
            this.val = array.clone();
            return;
        }
        this.val = new double[4];
        this.set(array);
    }
    
    public static Scalar all(final double n) {
        return new Scalar(n, n, n, n);
    }
    
    public Scalar clone() {
        return new Scalar(this.val);
    }
    
    public Scalar conj() {
        return new Scalar(this.val[0], -this.val[1], -this.val[2], -this.val[3]);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof Scalar)) {
                return false;
            }
            if (!Arrays.equals(this.val, ((Scalar)o).val)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.val) + 31;
    }
    
    public boolean isReal() {
        return this.val[1] == 0.0 && this.val[2] == 0.0 && this.val[3] == 0.0;
    }
    
    public Scalar mul(final Scalar scalar) {
        return this.mul(scalar, 1.0);
    }
    
    public Scalar mul(final Scalar scalar, final double n) {
        return new Scalar(this.val[0] * scalar.val[0] * n, this.val[1] * scalar.val[1] * n, this.val[2] * scalar.val[2] * n, this.val[3] * scalar.val[3] * n);
    }
    
    public void set(double[] val) {
        final double n = 0.0;
        if (val != null) {
            final double[] val2 = this.val;
            double n2;
            if (val.length > 0) {
                n2 = val[0];
            }
            else {
                n2 = 0.0;
            }
            val2[0] = n2;
            final double[] val3 = this.val;
            double n3;
            if (val.length > 1) {
                n3 = val[1];
            }
            else {
                n3 = 0.0;
            }
            val3[1] = n3;
            final double[] val4 = this.val;
            double n4;
            if (val.length > 2) {
                n4 = val[2];
            }
            else {
                n4 = 0.0;
            }
            val4[2] = n4;
            final double[] val5 = this.val;
            double n5 = n;
            if (val.length > 3) {
                n5 = val[3];
            }
            val5[3] = n5;
            return;
        }
        val = this.val;
        final double[] val6 = this.val;
        this.val[2] = (this.val[3] = 0.0);
        val[0] = (val6[1] = 0.0);
    }
    
    @Override
    public String toString() {
        return "[" + this.val[0] + ", " + this.val[1] + ", " + this.val[2] + ", " + this.val[3] + "]";
    }
}

package org.opencv.imgproc;

public class Moments
{
    public double m00;
    public double m01;
    public double m02;
    public double m03;
    public double m10;
    public double m11;
    public double m12;
    public double m20;
    public double m21;
    public double m30;
    public double mu02;
    public double mu03;
    public double mu11;
    public double mu12;
    public double mu20;
    public double mu21;
    public double mu30;
    public double nu02;
    public double nu03;
    public double nu11;
    public double nu12;
    public double nu20;
    public double nu21;
    public double nu30;
    
    public Moments() {
        this(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }
    
    public Moments(final double m00, final double m2, final double m3, final double m4, final double m5, final double m6, final double m7, final double m8, final double m9, final double m10) {
        this.m00 = m00;
        this.m10 = m2;
        this.m01 = m3;
        this.m20 = m4;
        this.m11 = m5;
        this.m02 = m6;
        this.m30 = m7;
        this.m21 = m8;
        this.m12 = m9;
        this.m03 = m10;
        this.completeState();
    }
    
    public Moments(final double[] array) {
        this.set(array);
    }
    
    protected void completeState() {
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        if (Math.abs(this.m00) > 1.0E-8) {
            n3 = 1.0 / this.m00;
            n = this.m10 * n3;
            n2 = this.m01 * n3;
        }
        final double mu20 = this.m20 - this.m10 * n;
        final double mu21 = this.m11 - this.m10 * n2;
        final double mu22 = this.m02 - this.m01 * n2;
        this.mu20 = mu20;
        this.mu11 = mu21;
        this.mu02 = mu22;
        this.mu30 = this.m30 - (3.0 * mu20 + this.m10 * n) * n;
        final double n4 = mu21 + mu21;
        this.mu21 = this.m21 - (this.m01 * n + n4) * n - n2 * mu20;
        this.mu12 = this.m12 - (this.m10 * n2 + n4) * n2 - n * mu22;
        this.mu03 = this.m03 - (3.0 * mu22 + this.m01 * n2) * n2;
        final double sqrt = Math.sqrt(Math.abs(n3));
        final double n5 = n3 * n3;
        final double n6 = n5 * sqrt;
        this.nu20 = this.mu20 * n5;
        this.nu11 = this.mu11 * n5;
        this.nu02 = this.mu02 * n5;
        this.nu30 = this.mu30 * n6;
        this.nu21 = this.mu21 * n6;
        this.nu12 = this.mu12 * n6;
        this.nu03 = this.mu03 * n6;
    }
    
    public double get_m00() {
        return this.m00;
    }
    
    public double get_m01() {
        return this.m01;
    }
    
    public double get_m02() {
        return this.m02;
    }
    
    public double get_m03() {
        return this.m03;
    }
    
    public double get_m10() {
        return this.m10;
    }
    
    public double get_m11() {
        return this.m11;
    }
    
    public double get_m12() {
        return this.m12;
    }
    
    public double get_m20() {
        return this.m20;
    }
    
    public double get_m21() {
        return this.m21;
    }
    
    public double get_m30() {
        return this.m30;
    }
    
    public double get_mu02() {
        return this.mu02;
    }
    
    public double get_mu03() {
        return this.mu03;
    }
    
    public double get_mu11() {
        return this.mu11;
    }
    
    public double get_mu12() {
        return this.mu12;
    }
    
    public double get_mu20() {
        return this.mu20;
    }
    
    public double get_mu21() {
        return this.mu21;
    }
    
    public double get_mu30() {
        return this.mu30;
    }
    
    public double get_nu02() {
        return this.nu02;
    }
    
    public double get_nu03() {
        return this.nu03;
    }
    
    public double get_nu11() {
        return this.nu11;
    }
    
    public double get_nu12() {
        return this.nu12;
    }
    
    public double get_nu20() {
        return this.nu20;
    }
    
    public double get_nu21() {
        return this.nu21;
    }
    
    public double get_nu30() {
        return this.nu30;
    }
    
    public void set(final double[] array) {
        final double n = 0.0;
        if (array != null) {
            double m00;
            if (array.length > 0) {
                m00 = (int)array[0];
            }
            else {
                m00 = 0.0;
            }
            this.m00 = m00;
            double m2;
            if (array.length > 1) {
                m2 = (int)array[1];
            }
            else {
                m2 = 0.0;
            }
            this.m10 = m2;
            double m3;
            if (array.length > 2) {
                m3 = (int)array[2];
            }
            else {
                m3 = 0.0;
            }
            this.m01 = m3;
            double m4;
            if (array.length > 3) {
                m4 = (int)array[3];
            }
            else {
                m4 = 0.0;
            }
            this.m20 = m4;
            double m5;
            if (array.length > 4) {
                m5 = (int)array[4];
            }
            else {
                m5 = 0.0;
            }
            this.m11 = m5;
            double m6;
            if (array.length > 5) {
                m6 = (int)array[5];
            }
            else {
                m6 = 0.0;
            }
            this.m02 = m6;
            double m7;
            if (array.length > 6) {
                m7 = (int)array[6];
            }
            else {
                m7 = 0.0;
            }
            this.m30 = m7;
            double m8;
            if (array.length > 7) {
                m8 = (int)array[7];
            }
            else {
                m8 = 0.0;
            }
            this.m21 = m8;
            double m9;
            if (array.length > 8) {
                m9 = (int)array[8];
            }
            else {
                m9 = 0.0;
            }
            this.m12 = m9;
            double m10 = n;
            if (array.length > 9) {
                m10 = (int)array[9];
            }
            this.m03 = m10;
            this.completeState();
            return;
        }
        this.m00 = 0.0;
        this.m10 = 0.0;
        this.m01 = 0.0;
        this.m20 = 0.0;
        this.m11 = 0.0;
        this.m02 = 0.0;
        this.m30 = 0.0;
        this.m21 = 0.0;
        this.m12 = 0.0;
        this.m03 = 0.0;
        this.mu20 = 0.0;
        this.mu11 = 0.0;
        this.mu02 = 0.0;
        this.mu30 = 0.0;
        this.mu21 = 0.0;
        this.mu12 = 0.0;
        this.mu03 = 0.0;
        this.nu20 = 0.0;
        this.nu11 = 0.0;
        this.nu02 = 0.0;
        this.nu30 = 0.0;
        this.nu21 = 0.0;
        this.nu12 = 0.0;
        this.nu03 = 0.0;
    }
    
    public void set_m00(final double m00) {
        this.m00 = m00;
    }
    
    public void set_m01(final double m01) {
        this.m01 = m01;
    }
    
    public void set_m02(final double m02) {
        this.m02 = m02;
    }
    
    public void set_m03(final double m03) {
        this.m03 = m03;
    }
    
    public void set_m10(final double m10) {
        this.m10 = m10;
    }
    
    public void set_m11(final double m11) {
        this.m11 = m11;
    }
    
    public void set_m12(final double m12) {
        this.m12 = m12;
    }
    
    public void set_m20(final double m20) {
        this.m20 = m20;
    }
    
    public void set_m21(final double m21) {
        this.m21 = m21;
    }
    
    public void set_m30(final double m30) {
        this.m30 = m30;
    }
    
    public void set_mu02(final double mu02) {
        this.mu02 = mu02;
    }
    
    public void set_mu03(final double mu03) {
        this.mu03 = mu03;
    }
    
    public void set_mu11(final double mu11) {
        this.mu11 = mu11;
    }
    
    public void set_mu12(final double mu12) {
        this.mu12 = mu12;
    }
    
    public void set_mu20(final double mu20) {
        this.mu20 = mu20;
    }
    
    public void set_mu21(final double mu21) {
        this.mu21 = mu21;
    }
    
    public void set_mu30(final double mu30) {
        this.mu30 = mu30;
    }
    
    public void set_nu02(final double nu02) {
        this.nu02 = nu02;
    }
    
    public void set_nu03(final double nu03) {
        this.nu03 = nu03;
    }
    
    public void set_nu11(final double nu11) {
        this.nu11 = nu11;
    }
    
    public void set_nu12(final double nu12) {
        this.nu12 = nu12;
    }
    
    public void set_nu20(final double nu20) {
        this.nu20 = nu20;
    }
    
    public void set_nu21(final double nu21) {
        this.nu21 = nu21;
    }
    
    public void set_nu30(final double nu30) {
        this.nu30 = nu30;
    }
    
    @Override
    public String toString() {
        return "Moments [ \nm00=" + this.m00 + ", \nm10=" + this.m10 + ", m01=" + this.m01 + ", \nm20=" + this.m20 + ", m11=" + this.m11 + ", m02=" + this.m02 + ", \nm30=" + this.m30 + ", m21=" + this.m21 + ", m12=" + this.m12 + ", m03=" + this.m03 + ", \nmu20=" + this.mu20 + ", mu11=" + this.mu11 + ", mu02=" + this.mu02 + ", \nmu30=" + this.mu30 + ", mu21=" + this.mu21 + ", mu12=" + this.mu12 + ", mu03=" + this.mu03 + ", \nnu20=" + this.nu20 + ", nu11=" + this.nu11 + ", nu02=" + this.nu02 + ", \nnu30=" + this.nu30 + ", nu21=" + this.nu21 + ", nu12=" + this.nu12 + ", nu03=" + this.nu03 + ", \n]";
    }
}

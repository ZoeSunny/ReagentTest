package com.example.detectct;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.lang.reflect.Array;

public class Detect
{
    private int Nit;
    private double T0;
    private Mat image;
    private double lam;
    private int loc_c;
    private int loc_t;
    private int[][] seg_c;
    private int[][] seg_t;
    private double th_c;
    private double th_t;
    
    public Detect() {
        this.lam = 0.5;
        this.Nit = 100;
        this.loc_c = -1;
        this.loc_t = -1;
        this.th_c = 0.2;
        this.th_t = 0.1;
        this.T0 = 0.005;
    }
    
    public Mat detectCT(final String s, final int[] array) {
        this.image = Imgcodecs.imread(s);
        final Mat mat = new Mat(this.image, new Rect(array[0] - 1, array[1] - 1, array[2] - array[0] + 1, array[3] - array[1] + 1));
        Imgproc.resize(mat, mat, new Size(100.0, 320.0));
        Imgproc.GaussianBlur(mat, mat, new Size(7.0, 7.0), 0.5);
        final Mat mat2 = new Mat(mat, new Rect(29, 0, mat.width() - 60 + 1, mat.height()));
        Imgproc.cvtColor(mat2, mat2, 6);
        final double[] tvd_mm = com.example.detectct.Tvd.tvd_mm(com.example.detectct.Tool.mean(mat2, 2), this.lam, this.Nit);
        com.example.detectct.Tvd.returnCost();
        this.findCT(com.example.detectct.Tool.findPeaks_prominece(tvd_mm, 5, 10), tvd_mm, mat, array);
        return mat;
    }
    
    public void findCT(final double[][] array, final double[] array2, final Mat mat, int[] array3) {
        final double[] array4 = new double[array[0].length];
        array3 = new int[array[0].length];
        for (int i = 0; i < array[0].length; ++i) {
            array4[i] = array[0][i];
            array3[i] = (int)array[1][i] + 1;
        }
        final double floor = Math.floor(array2.length / 2);
        final int[] array5 = new int[array3.length];
        final int[] array6 = new int[array3.length];
        final int[] array7 = new int[array3.length];
        final int[] array8 = new int[array3.length];
        int n = 0;
        int n2 = 0;
        int n3;
        int n4;
        for (int j = 0; j < array3.length; ++j, n = n3, n2 = n4) {
            if (array3[j] < floor && array3[j] != 1 && array3[j] > 30) {
                array5[n] = j;
                array6[n] = array3[j];
                n3 = n + 1;
                n4 = n2;
            }
            else {
                n3 = n;
                n4 = n2;
                if (array3[j] > floor) {
                    n3 = n;
                    n4 = n2;
                    if (array3[j] <= mat.height() - 30) {
                        array7[n2] = j;
                        array8[n2] = array3[j];
                        n4 = n2 + 1;
                        n3 = n;
                    }
                }
            }
        }
        for (int k = n - 1; k >= 0; --k) {
            final double[] array9 = new double[11];
            for (int n5 = 0, l = array6[k] - 5 - 1; l <= array6[k] + 4; ++l, ++n5) {
                array9[n5] = array2[l];
            }
            if (com.example.detectct.Tool.var(array9) >= this.th_c) {
                this.loc_c = array6[k];
                break;
            }
        }
        System.out.println("LOC_C??" + this.loc_c);
        if (this.loc_c != -1) {
            final Mat mat2 = new Mat(mat, new Rect(0, this.loc_c - 30 - 1, mat.width(), 61));
            Imgproc.cvtColor(mat2, mat2, 6);
            this.getThresh(0, this.loc_c, mat2, this.T0);
        }
        if (n2 != 0) {
            for (int n6 = 0; n6 < n2; ++n6) {
                final double[] array10 = new double[11];
                for (int n7 = 0, n8 = array8[n6] - 5 - 1; n8 <= array8[n6] + 4; ++n8, ++n7) {
                    array10[n7] = array2[n8];
                }
                if (com.example.detectct.Tool.var(array10) >= this.th_t) {
                    this.loc_t = array8[n6];
                    break;
                }
            }
        }
        if (this.loc_t != -1) {
            final Mat mat3 = new Mat(mat, new Rect(0, this.loc_t - 30 - 1, mat.width(), 61));
            Imgproc.cvtColor(mat3, mat3, 6);
            this.getThresh(1, this.loc_t, mat3, this.T0);
        }
    }
    
    public int[] getLoc() {
        return new int[] { this.loc_c, this.loc_t };
    }
    
    public int[][] getSegC() {
        return this.seg_c;
    }
    
    public int[][] getSegT() {
        return this.seg_t;
    }
    
    public void getThresh(int i, int j, Mat mat, final double n) {
        mat = new Mat(mat, new Rect(29, 0, mat.width() - 60 + 1, mat.height()));
        final int[] array = new int[(int)(mat.total() * mat.channels())];
        mat.convertTo(mat, 4);
        mat.get(0, 0, array);
        final double n2 = new com.example.detectct.OtsuThresholder().doThreshold(array);
        j = mat.rows();
        final int[][] array2 = (int[][])Array.newInstance(Integer.TYPE, j, mat.cols());
        int n3 = 0;
        j = 0;
        double n4;
        while (true) {
            n4 = n2;
            if (j >= mat.rows()) {
                break;
            }
            for (int k = 0; k < mat.cols(); ++k) {
                array2[j][k] = array[n3];
                ++n3;
            }
            ++j;
        }
        double n5;
        do {
            double n6 = 0.0;
            double n7 = 0.0;
            int n8 = 0;
            int n9 = 0;
            int l;
            double n10;
            double n11;
            for (j = 0; j < array2.length; ++j, n6 = n11, n7 = n10) {
                l = 0;
                n10 = n7;
                n11 = n6;
                while (l < array2[0].length) {
                    if (array2[j][l] <= n4) {
                        n11 += array2[j][l];
                        ++n8;
                    }
                    else {
                        n10 += array2[j][l];
                        ++n9;
                    }
                    ++l;
                }
            }
            double n12 = n6 / n8;
            double n13 = n7 / n9;
            double n14 = n4;
            double n15;
            double n16;
            while (true) {
                n5 = n14;
                n15 = n12;
                n16 = n13;
                if (n14 <= 0.0) {
                    break;
                }
                if (!Double.isNaN(n12)) {
                    n5 = n14;
                    n15 = n12;
                    n16 = n13;
                    if (!Double.isNaN(n13)) {
                        break;
                    }
                }
                final double n17 = n14 - 5.0;
                double n18 = 0.0;
                double n19 = 0.0;
                int n20 = 0;
                int n21 = 0;
                int n22;
                double n23;
                double n24;
                for (j = 0; j < array2.length; ++j, n18 = n24, n19 = n23) {
                    n22 = 0;
                    n23 = n19;
                    n24 = n18;
                    while (n22 < array2[0].length) {
                        if (array2[j][n22] <= n17) {
                            n24 += array2[j][n22];
                            ++n20;
                        }
                        else {
                            n23 += array2[j][n22];
                            ++n21;
                        }
                        ++n22;
                    }
                }
                n12 = n18 / n20;
                final double n25 = n19 / n21;
                n14 = n17;
                n13 = n25;
            }
            while (n5 < 255.0 && (Double.isNaN(n15) || Double.isNaN(n16))) {
                n5 += 5.0;
                double n26 = 0.0;
                double n27 = 0.0;
                int n28 = 0;
                int n29 = 0;
                int n30;
                double n31;
                double n32;
                for (j = 0; j < array2.length; ++j, n26 = n32, n27 = n31) {
                    n30 = 0;
                    n31 = n27;
                    n32 = n26;
                    while (n30 < array2[0].length) {
                        if (array2[j][n30] <= n5) {
                            n32 += array2[j][n30];
                            ++n28;
                        }
                        else {
                            n31 += array2[j][n30];
                            ++n29;
                        }
                        ++n30;
                    }
                }
                n15 = n26 / n28;
                n16 = n27 / n29;
            }
            double n33 = n15;
            if (Double.isNaN(n15)) {
                n33 = 0.0;
            }
            double n34 = n16;
            if (Double.isNaN(n16)) {
                n34 = 0.0;
            }
            n4 = (n33 + n34) * 0.5;
        } while (Math.abs(n4 - n5) >= n);
        if (i == 0) {
            i = mat.rows();
            j = mat.cols();
            this.seg_c = (int[][])Array.newInstance(Integer.TYPE, i, j);
            for (i = 0; i < array2.length; ++i) {
                for (j = 0; j < array2[0].length; ++j) {
                    if (array2[i][j] <= n5) {
                        this.seg_c[i][j] = 1;
                    }
                }
            }
        }
        else {
            i = mat.rows();
            j = mat.cols();
            this.seg_t = (int[][])Array.newInstance(Integer.TYPE, i, j);
            for (i = 0; i < array2.length; ++i) {
                for (j = 0; j < array2[0].length; ++j) {
                    if (array2[i][j] <= n5) {
                        this.seg_t[i][j] = 1;
                    }
                }
            }
        }
    }
}

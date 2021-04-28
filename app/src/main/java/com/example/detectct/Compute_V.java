package com.example.detectct;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

public class Compute_V
{
    private boolean GAMMA_CORRECTION;
    private int[] box;
    private Mat centerbox;
    private int loc_c;
    private int loc_t;
    private int[][] seg_c;
    private int[][] seg_t;
    
    public Compute_V(final Mat centerbox, final int[] array, final int[][] seg_c, final int[][] seg_t, final int[] box, final boolean gamma_CORRECTION) {
        this.centerbox = centerbox;
        this.loc_c = array[0];
        this.loc_t = array[1];
        this.seg_c = seg_c;
        this.seg_t = seg_t;
        this.box = box;
        this.GAMMA_CORRECTION = gamma_CORRECTION;
    }
    
    public double[] computeCT_method1() {
        final double[] array2;
        final double[] array = array2 = new double[3];
        array2[0] = -1.0;
        array2[2] = (array2[1] = -1.0);
        if (this.loc_c == -1 || this.loc_t == -1) {
            return array;
        }
        final Mat mat = new Mat(this.centerbox, new Rect(29, this.loc_c - 30 - 1, this.centerbox.width() - 60 + 1, 61));
        Imgproc.cvtColor(mat, mat, 6);
        final int[][] mat2int = com.example.detectct.Tool.mat2int(mat);
        final Mat mat2 = new Mat(this.centerbox, new Rect(29, this.loc_t - 30 - 1, this.centerbox.width() - 60 + 1, 61));
        Imgproc.cvtColor(mat2, mat2, 6);
        final int[][] mat2int2 = com.example.detectct.Tool.mat2int(mat2);
        double n = 0.0;
        int n2 = 0;
        for (int i = 0; i < mat2int.length; ++i) {
            int n3;
            double n4;
            for (int j = 0; j < mat2int[0].length; ++j, n2 = n3, n = n4) {
                n3 = n2;
                n4 = n;
                if (this.seg_c[i][j] != 0) {
                    n4 = n + mat2int[i][j];
                    n3 = n2 + 1;
                }
            }
        }
        final double n5 = n / n2;
        double n6 = 0.0;
        int n7 = 0;
        for (int k = 0; k < mat2int2.length; ++k) {
            int n8;
            double n9;
            for (int l = 0; l < mat2int2[0].length; ++l, n7 = n8, n6 = n9) {
                n8 = n7;
                n9 = n6;
                if (this.seg_t[k][l] != 0) {
                    n9 = n6 + mat2int2[k][l];
                    n8 = n7 + 1;
                }
            }
        }
        final double n10 = n6 / n7;
        array[0] = n5 / n10;
        array[1] = n5;
        array[2] = n10;
        return array;
    }
    
    public double[] computeCT_method2() {
        final double[] array2;
        final double[] array = array2 = new double[3];
        array2[0] = -1.0;
        array2[2] = (array2[1] = -1.0);
        if (this.loc_c == -1 || this.loc_t == -1) {
            return array;
        }
        final Mat mat = new Mat(this.centerbox, new Rect(29, this.loc_c - 30 - 1, this.centerbox.width() - 60 + 1, 61));
        Imgproc.cvtColor(mat, mat, 6);
        final int[][] mat2int = com.example.detectct.Tool.mat2int(mat);
        final Mat mat2 = new Mat(this.centerbox, new Rect(29, this.loc_t - 30 - 1, this.centerbox.width() - 60 + 1, 61));
        Imgproc.cvtColor(mat2, mat2, 6);
        final int[][] mat2int2 = com.example.detectct.Tool.mat2int(mat2);
        final int[] sumArray = com.example.detectct.Tool.sumArray(this.seg_c, 2);
        for (int i = 0; i < sumArray.length; ++i) {
            if (sumArray[i] < this.seg_c[0].length / 2) {
                for (int j = 0; j < this.seg_c[0].length; ++j) {
                    this.seg_c[i][j] = 0;
                }
            }
        }
        double n = 0.0;
        int n2 = 0;
        for (int k = 0; k < mat2int.length; ++k) {
            int n3;
            double n4;
            for (int l = 0; l < mat2int[0].length; ++l, n2 = n3, n = n4) {
                n3 = n2;
                n4 = n;
                if (this.seg_c[k][l] != 0) {
                    n4 = n + mat2int[k][l];
                    n3 = n2 + 1;
                }
            }
        }
        final double n5 = n / n2;
        final int[] sumArray2 = com.example.detectct.Tool.sumArray(this.seg_t, 2);
        for (int n6 = 0; n6 < sumArray2.length; ++n6) {
            if (sumArray2[n6] < this.seg_t[0].length / 2) {
                for (int n7 = 0; n7 < this.seg_t[0].length; ++n7) {
                    this.seg_t[n6][n7] = 0;
                }
            }
        }
        double n8 = 0.0;
        int n9 = 0;
        for (int n10 = 0; n10 < mat2int2.length; ++n10) {
            int n12;
            double n13;
            for (int n11 = 0; n11 < mat2int2[0].length; ++n11, n9 = n12, n8 = n13) {
                n12 = n9;
                n13 = n8;
                if (this.seg_t[n10][n11] != 0) {
                    n13 = n8 + mat2int2[n10][n11];
                    n12 = n9 + 1;
                }
            }
        }
        final double n14 = n8 / n9;
        array[0] = n5 / n14;
        array[1] = n5;
        array[2] = n14;
        return array;
    }
    
    public double[] computeCT_method3() {
        final double[] array2;
        final double[] array = array2 = new double[3];
        array2[0] = -1.0;
        array2[2] = (array2[1] = -1.0);
        if (this.loc_c == -1 || this.loc_t == -1) {
            return array;
        }
        final Mat mat = new Mat(this.centerbox, new Rect(29, this.loc_c - 30 - 1, this.centerbox.width() - 60 + 1, 61));
        Imgproc.cvtColor(mat, mat, 6);
        final int[][] mat2int = com.example.detectct.Tool.mat2int(mat);
        final Mat mat2 = new Mat(this.centerbox, new Rect(29, this.loc_t - 30 - 1, this.centerbox.width() - 60 + 1, 61));
        Imgproc.cvtColor(mat2, mat2, 6);
        final int[][] mat2int2 = com.example.detectct.Tool.mat2int(mat2);
        final int[] sumArray = com.example.detectct.Tool.sumArray(this.seg_c, 2);
        for (int i = 0; i < sumArray.length; ++i) {
            if (sumArray[i] < this.seg_c[0].length / 2) {
                for (int j = 0; j < this.seg_c[0].length; ++j) {
                    this.seg_c[i][j] = 0;
                }
            }
        }
        double n = 0.0;
        int n2 = 0;
        double n3 = 0.0;
        int n4 = 0;
        for (int k = 0; k < mat2int.length; ++k) {
            for (int l = 0; l < mat2int[0].length; ++l) {
                if (this.seg_c[k][l] != 0) {
                    n += mat2int[k][l];
                    ++n2;
                }
                else {
                    n3 += mat2int[k][l];
                    ++n4;
                }
            }
        }
        final double n5 = n / n2;
        final double n6 = n3 / n4;
        final double n7 = (n6 - n5) / n6;
        final int[] sumArray2 = com.example.detectct.Tool.sumArray(this.seg_t, 2);
        for (int n8 = 0; n8 < sumArray2.length; ++n8) {
            if (sumArray2[n8] < this.seg_t[0].length / 2) {
                for (int n9 = 0; n9 < this.seg_t[0].length; ++n9) {
                    this.seg_t[n8][n9] = 0;
                }
            }
        }
        double n10 = 0.0;
        int n11 = 0;
        double n12 = 0.0;
        int n13 = 0;
        for (int n14 = 0; n14 < mat2int2.length; ++n14) {
            for (int n15 = 0; n15 < mat2int2[0].length; ++n15) {
                if (this.seg_t[n14][n15] != 0) {
                    n10 += mat2int2[n14][n15];
                    ++n11;
                }
                else {
                    n12 += mat2int2[n14][n15];
                    ++n13;
                }
            }
        }
        final double n16 = n10 / n11;
        final double n17 = n12 / n13;
        final double n18 = (n17 - n16) / n17;
        array[0] = n7 / n18;
        array[1] = n7;
        array[2] = n18;
        return array;
    }
    
    public double computeCT_method4() {
        if (this.loc_c == -1) {
            return -2.0;
        }
        if (this.loc_t == -1) {
            return -1.0;
        }
        System.out.println("1");
        Imgproc.cvtColor(this.centerbox, this.centerbox, 6);
        System.out.println("2");
        final Mat mat = new Mat(this.centerbox, new Rect(0, this.loc_c - 10 - 1, this.centerbox.width(), 21));
        System.out.println("3");
        final Mat mat2 = new Mat(this.centerbox, new Rect(0, this.loc_t - 10 - 1, this.centerbox.width(), 21));
        System.out.println("4");
        final Mat mat3 = new Mat(this.centerbox, new Rect(0, this.loc_c - 40 - 1, this.centerbox.width(), 11));
        System.out.println("5");
        final Mat mat4 = new Mat(this.centerbox, new Rect(0, this.loc_t - 40 - 1, this.centerbox.width(), 11));
        System.out.println("6");
        double[] array;
        double[] array2;
        double[] array3;
        double[] array4;
        if (this.GAMMA_CORRECTION) {
            System.out.println("7");
            final double[][] gamma_correction = com.example.detectct.Tool.gamma_correction(mat);
            final double[][] gamma_correction2 = com.example.detectct.Tool.gamma_correction(mat2);
            final double[][] gamma_correction3 = com.example.detectct.Tool.gamma_correction(mat3);
            final double[][] gamma_correction4 = com.example.detectct.Tool.gamma_correction(mat4);
            System.out.println("8");
            array = com.example.detectct.Tool.mean(gamma_correction, 1);
            array2 = com.example.detectct.Tool.mean(gamma_correction2, 1);
            array3 = com.example.detectct.Tool.mean(gamma_correction3, 1);
            array4 = com.example.detectct.Tool.mean(gamma_correction4, 1);
        }
        else {
            System.out.println("9");
            array = com.example.detectct.Tool.mean(mat, 1);
            array2 = com.example.detectct.Tool.mean(mat2, 1);
            array3 = com.example.detectct.Tool.mean(mat3, 1);
            array4 = com.example.detectct.Tool.mean(mat4, 1);
        }
        System.out.println("10");
        final double[] array5 = new double[array.length];
        final double[] array6 = new double[array2.length];
        for (int i = 0; i < array.length; ++i) {
            array5[i] = array[i] - array3[i];
            array6[i] = array2[i] - array4[i];
        }
        System.out.println("11");
        final double martixrightDivide = com.example.detectct.Tool.martixrightDivide(array5, array3);
        final double martixrightDivide2 = com.example.detectct.Tool.martixrightDivide(array6, array4);
        System.out.println("12");
        final double n = martixrightDivide / martixrightDivide2;
        System.out.println("13" + n);
        return n;
    }
}

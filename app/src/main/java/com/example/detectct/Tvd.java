package com.example.detectct;

import java.lang.reflect.Array;

import Jama.Matrix;

public class Tvd
{
    private static double[] cost;
    private static double[][] x;
    
    public static double[] returnCost() {
        return com.example.detectct.Tvd.cost;
    }
    
    public static double[] tvd_mm(double[] array, final double n, int i) {
        final double[][] array2 = (double[][])Array.newInstance(Double.TYPE, array.length, 1);
        com.example.detectct.Tvd.cost = new double[i];
        final int length = array2.length;
        for (int j = 0; j < array.length; ++j) {
            array2[j][0] = array[j];
        }
        System.out.println("1");
        final int[][] array3 = (int[][])Array.newInstance(Integer.TYPE, length, length);
        for (int k = 0; k < length; ++k) {
            for (int l = 0; l < length; ++l) {
                if (k == l) {
                    array3[k][l] = 1;
                    break;
                }
            }
        }
        System.out.println("2");
        final double[][] array4 = (double[][])Array.newInstance(Double.TYPE, length - 1, length);
        final double[][] array5 = (double[][])Array.newInstance(Double.TYPE, length, length - 1);
        for (int n2 = 0; n2 < length - 1; ++n2) {
            for (int n3 = 0; n3 < length; ++n3) {
                if (n2 == n3) {
                    array4[n2][n3] = -4616189618054758400L;
                    array4[n2][n3 + 1] = 4607182418800017408L;
                    array5[n3][n2] = -4616189618054758400L;
                    array5[n3 + 1][n2] = 4607182418800017408L;
                    break;
                }
            }
        }
        final double[][] martix = com.example.detectct.Tool.martix(array4, array5);
        com.example.detectct.Tvd.x = (double[][])Array.newInstance(Double.TYPE, array2.length, array2[0].length);
        for (int n4 = 0; n4 < array2.length; ++n4) {
            for (int n5 = 0; n5 < array2[0].length; ++n5) {
                com.example.detectct.Tvd.x[n4][n5] = array2[n4][n5];
            }
        }
        double[][] array6 = com.example.detectct.Tool.martix(array4, com.example.detectct.Tvd.x);
        final double[][] martix2 = com.example.detectct.Tool.martix(array4, array2);
        for (int n6 = 0; n6 < i; ++n6) {
            final double[][] array7 = (double[][])Array.newInstance(Double.TYPE, array6.length, array6[0].length);
            for (int n7 = 0; n7 < array7.length; ++n7) {
                for (int n8 = 0; n8 < array7[0].length; ++n8) {
                    array7[n7][n8] = Math.abs(array6[n7][n8]) / n;
                }
            }
            int n9 = 0;
            final double[][] array8 = (double[][])Array.newInstance(Double.TYPE, length - 1, length - 1);
            for (int n10 = 0; n10 < length - 1; ++n10) {
                for (int n11 = 0; n11 < length - 1; ++n11) {
                    if (n10 == n11) {
                        array8[n10][n11] = array7[n9][0] + martix[n10][n11];
                        ++n9;
                    }
                    else {
                        array8[n10][n11] = martix[n10][n11];
                    }
                }
            }
            final Matrix inverse = new Matrix(array8).inverse();
            final double[][] array9 = (double[][])Array.newInstance(Double.TYPE, array8.length, array8[0].length);
            final double[][] martix3 = com.example.detectct.Tool.martix(array5, com.example.detectct.Tool.martix(inverse.getArray(), martix2));
            for (int n12 = 0; n12 < com.example.detectct.Tvd.x.length; ++n12) {
                for (int n13 = 0; n13 < com.example.detectct.Tvd.x[0].length; ++n13) {
                    com.example.detectct.Tvd.x[n12][n13] = array2[n12][n13] - martix3[n12][n13];
                }
            }
            array6 = com.example.detectct.Tool.martix(array4, com.example.detectct.Tvd.x);
            double n14 = 0.0;
            double n15 = 0.0;
            for (int n16 = 0; n16 < com.example.detectct.Tvd.x.length; ++n16) {
                for (int n17 = 0; n17 < com.example.detectct.Tvd.x[0].length; ++n17) {
                    n14 += Math.pow(Math.abs(com.example.detectct.Tvd.x[n16][n17] - array2[n16][n17]), 2.0);
                }
            }
            for (int n18 = 0; n18 < array6.length; ++n18) {
                for (int n19 = 0; n19 < array6[0].length; ++n19) {
                    n15 += Math.abs(array6[n18][n19]);
                }
            }
            com.example.detectct.Tvd.cost[n6] = 0.5 * n14 + n * n15;
        }
        array = new double[com.example.detectct.Tvd.x.length];
        for (i = 0; i < com.example.detectct.Tvd.x.length; ++i) {
            array[i] = com.example.detectct.Tvd.x[i][0];
        }
        return array;
    }
}

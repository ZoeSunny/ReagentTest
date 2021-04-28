package com.example.detectct;

import org.opencv.core.Mat;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import Jama.Matrix;

public class Tool
{
    public static String createFile(final String s, final String s2) {
        final File file = new File(s);
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(file, s2);
        if (file2.exists()) {
            file2.delete();
        }
        Label_0055: {
            if (file2.exists()) {
                break Label_0055;
            }
            try {
                file2.createNewFile();
                return s + "/" + s2;
            }
            catch (IOException ex) {
                ex.printStackTrace();
                return s + "/" + s2;
            }
        }
        return s;
    }
    
    public static double[][] findPeaks_distance(final double[] array, int i, final int n) {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 1; j < array.length; ++j) {
            final double n2 = array[j] - array[j - 1];
            if (n2 > 0.0) {
                list.add(1);
            }
            else if (n2 < 0.0) {
                list.add(-1);
            }
            else {
                list.add(0);
            }
        }
        final ArrayList<Integer> list2 = new ArrayList<Integer>();
        final ArrayList<Integer> list3 = new ArrayList<Integer>();
        for (int k = 1; k < list.size(); ++k) {
            final int n3 = list.get(k) - list.get(k - 1);
            if (n3 < 0) {
                list2.add(k);
            }
            else if (n3 > 0) {
                list3.add(k);
            }
        }
        final double[][] array2 = (double[][])Array.newInstance(Double.TYPE, 2, list3.size());
        for (int l = 0; l < list3.size(); ++l) {
            array2[0][l] = array[(int)list3.get(l)];
            array2[1][l] = (int)list3.get(l);
        }
        int n4 = 0;
        int n5 = -1;
        final double[][] array3 = (double[][])Array.newInstance(Double.TYPE, 2, n);
        while (n4 < n) {
            double n6 = 65536.0;
            int n7 = -1;
            double n9;
            for (int n8 = 0; n8 < array2[0].length; ++n8, n6 = n9) {
                n9 = n6;
                if (array2[0][n8] < n6) {
                    n9 = array2[0][n8];
                    n5 = (int)array2[1][n8];
                    n7 = n8;
                }
            }
            if (n6 == 65536.0) {
                break;
            }
            for (int n10 = n7 - 1; n10 >= 0; --n10) {
                if (array2[1][n10] != -1.0) {
                    if (n5 - array2[1][n10] > i) {
                        break;
                    }
                    array2[1][n10] = -4616189618054758400L;
                    array2[0][n10] = 4679240012837945344L;
                }
            }
            for (int n11 = n7 + 1; n11 < array2[0].length; ++n11) {
                if (array2[1][n11] == -1.0) {}
                if (array2[1][n11] - n5 > i) {
                    break;
                }
                array2[1][n11] = -4616189618054758400L;
                array2[0][n11] = 4679240012837945344L;
            }
            array3[0][n4] = n6;
            array3[1][n4] = n5;
            array2[0][n7] = 4679240012837945344L;
            array2[1][n7] = -4616189618054758400L;
            ++n4;
        }
        i = array3[0].length;
        final double[][] array4 = (double[][])Array.newInstance(Double.TYPE, 2, i);
        for (i = 0; i < array3[0].length; ++i) {
            array4[0][i] = array3[0][i];
            array4[1][i] = array3[1][i];
        }
        return array4;
    }
    
    public static double[][] findPeaks_prominece(double[] array, int i, int j) {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k = 1; k < array.length; ++k) {
            final double n = array[k] - array[k - 1];
            if (n > 0.0) {
                list.add(1);
            }
            else if (n < 0.0) {
                list.add(-1);
            }
            else {
                list.add(0);
            }
        }
        final ArrayList<Integer> list2 = new ArrayList<Integer>();
        final ArrayList<Integer> list3 = new ArrayList<Integer>();
        for (int l = 1; l < list.size(); ++l) {
            final int n2 = list.get(l) - list.get(l - 1);
            if (n2 < 0) {
                list2.add(l);
            }
            else if (n2 > 0) {
                list3.add(l);
            }
        }
        final double[][] array2 = (double[][])Array.newInstance(Double.TYPE, 2, 100);
        int n3 = 0;
        int n4 = 0;
        int n5;
        int n6;
        int n7 = 0;
        Label_0326_Outer:Label_0418_Outer:
        while (n4 < list3.size()) {
            n5 = list3.get(n4) - 1;
        Label_0418:
            while (true) {
                while (true) {
                    Label_0431: {
                        while (true) {
                            n6 = n3;
                            if (n5 < 0) {
                                break;
                            }
                            if (array[n5] - array[list3.get(n4)] > i) {
                                n7 = list3.get(n4) + 1;
                                while (true) {
                                    n6 = n3;
                                    if (n7 >= array.length) {
                                        break Label_0418;
                                    }
                                    if (array[n7] - array[list3.get(n4)] > i) {
                                        array2[0][n3] = array[(int)list3.get(n4)];
                                        array2[1][n3] = (int)list3.get(n4);
                                        n6 = n3 + 1;
                                        break Label_0418;
                                    }
                                    break Label_0431;
                                }
                            }
                            else {
                                n6 = n3;
                                if (array[n5] < array[list3.get(n4)]) {
                                    break;
                                }
                                --n5;
                            }
                        }
                        ++n4;
                        n3 = n6;
                        continue Label_0418_Outer;
                    }
                    n6 = n3;
                    if (array[n7] >= array[list3.get(n4)]) {
                        ++n7;
                        continue Label_0418_Outer;
                    }
                    break;
                }
                continue Label_0418;
            }
        }
        double[][] array3 = (double[][])Array.newInstance(Double.TYPE, 2, n3);
        i = 0;
        for (int n8 = 0; n8 < n3; ++n8) {
            int n9 = i;
            if (n8 == 0) {
                array3[0][i] = array2[0][n8];
                array3[1][i] = array2[1][n8];
                n9 = i + 1;
            }
            i = n9;
            if (n8 > 0) {
                i = n9;
                if (array2[0][n8] != array2[0][n8 - 1]) {
                    array3[0][n9] = array2[0][n8];
                    array3[1][n9] = array2[1][n8];
                    i = n9 + 1;
                }
            }
        }
        final double[][] array4 = (double[][])Array.newInstance(Double.TYPE, 2, 10);
        int n10 = 0;
        if (i > j) {
            for (int n11 = 0; n11 < j; ++n11) {
                double n12 = 1000.0;
                double n13 = -4616189618054758400L;
                int n14 = -1;
                double n16;
                for (int n15 = 0; n15 < i; ++n15, n12 = n16) {
                    n16 = n12;
                    if (array3[0][n15] < n12) {
                        n16 = array3[0][n15];
                        n13 = array3[1][n15];
                        n14 = n15;
                    }
                }
                array4[0][n11] = n12;
                array4[1][n11] = n13;
                ++n10;
                array3[0][n14] = 4666723172467343360L;
            }
            final double[][] array5 = (double[][])Array.newInstance(Double.TYPE, 2, n10);
            for (i = 0; i < n10; ++i) {
                array5[0][i] = array4[0][i];
                array5[1][i] = array4[1][i];
            }
            final int length = array5[0].length;
            i = 0;
            while (true) {
                array3 = array4;
                if (i >= length - 1) {
                    break;
                }
                for (j = i + 1; j < length; ++j) {
                    if (array5[1][i] > array5[1][j]) {
                        array = new double[] { array5[0][i], array5[1][i] };
                        array5[0][i] = array5[0][j];
                        array5[1][i] = array5[1][j];
                        array5[0][j] = array[0];
                        array5[1][j] = array[1];
                    }
                }
                ++i;
            }
        }

        return array3;

    }
    
    public static double[][] gamma_correction(final Mat mat) {
        final int[][] mat2int = mat2int(mat);
        final double[][] array = (double[][])Array.newInstance(Double.TYPE, mat2int.length, mat2int[0].length);
        for (int i = 0; i < mat2int.length; ++i) {
            for (int j = 0; j < mat2int[0].length; ++j) {
                array[i][j] = Math.pow(mat2int[i][j], 0.45);
            }
        }
        return array;
    }
    
    public static double[][] martix(final double[][] array, final double[][] array2) {
        final double[][] array3 = (double[][])Array.newInstance(Double.TYPE, array.length, array2[0].length);
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array2[0].length; ++j) {
                double n = 0.0;
                for (int k = 0; k < array2.length; ++k) {
                    n += array[i][k] * array2[k][j];
                }
                array3[i][j] = n;
            }
        }
        return array3;
    }
    
    public static double martixrightDivide(final double[] array, final double[] array2) {
        final double[][] array3 = (double[][])Array.newInstance(Double.TYPE, 1, array.length);
        final double[][] array4 = (double[][])Array.newInstance(Double.TYPE, 1, array2.length);
        array3[0] = array;
        array4[0] = array2;
        final Matrix matrix = new Matrix(array3);
        final Matrix matrix2 = new Matrix(array4);
        return matrix2.times(matrix2.transpose()).inverse().times(matrix2).times(matrix.transpose()).transpose().getArray()[0][0];
    }
    
    public static int[][] mat2int(final Mat mat) {
        final int[] array = new int[(int)(mat.total() * mat.channels())];
        mat.convertTo(mat, 4);
        mat.get(0, 0, array);
        int n = 0;
        final int[][] array2 = (int[][])Array.newInstance(Integer.TYPE, mat.rows(), mat.cols());
        for (int i = 0; i < mat.rows(); ++i) {
            for (int j = 0; j < mat.cols(); ++j) {
                array2[i][j] = array[n];
                ++n;
            }
        }
        return array2;
    }
    
    public static double[] mean(final Mat mat, int n) {
        final int[][] mat2int = mat2int(mat);
        double[] array = null;
        if (n == 2) {
            final double[] array2 = new double[mat.rows()];
            int n2 = 0;
            while (true) {
                array = array2;
                if (n2 >= mat.rows()) {
                    break;
                }
                double n3 = 0.0;
                for (int i = 0; i < mat.cols(); ++i) {
                    n3 += mat2int[n2][i];
                }
                array2[n2] = n3 / mat.cols();
                ++n2;
            }
        }
        if (n == 1) {
            final double[] array3 = new double[mat.cols()];
            n = 0;
            while (true) {
                array = array3;
                if (n >= mat.cols()) {
                    break;
                }
                double n4 = 0.0;
                for (int j = 0; j < mat.rows(); ++j) {
                    n4 += mat2int[j][n];
                }
                array3[n] = n4 / mat.rows();
                ++n;
            }
        }
        return array;
    }
    
    public static double[] mean(final double[][] array, int n) {
        double[] array2 = null;
        if (n == 2) {
            final double[] array3 = new double[array.length];
            int n2 = 0;
            while (true) {
                array2 = array3;
                if (n2 >= array.length) {
                    break;
                }
                double n3 = 0.0;
                for (int i = 0; i < array[0].length; ++i) {
                    n3 += array[n2][i];
                }
                array3[n2] = n3 / array[0].length;
                ++n2;
            }
        }
        if (n == 1) {
            final double[] array4 = new double[array[0].length];
            n = 0;
            while (true) {
                array2 = array4;
                if (n >= array[0].length) {
                    break;
                }
                double n4 = 0.0;
                for (int j = 0; j < array.length; ++j) {
                    n4 += array[j][n];
                }
                array4[n] = n4 / array.length;
                ++n;
            }
        }
        return array2;
    }
    
    public static void merge(final int[] array, int i, final int n, final int n2) {
        final int[] array2 = new int[array.length];
        int n3 = i;
        int n4 = n + 1;
        int n5 = i;
        int n6;
        int n7;
        while (true) {
            n6 = n4;
            n7 = n3;
            if (n5 > n) {
                break;
            }
            n6 = n4;
            n7 = n3;
            if (n4 > n2) {
                break;
            }
            if (array[n5] <= array[n4]) {
                array2[n3] = array[n5];
                ++n3;
                ++n5;
            }
            else {
                array2[n3] = array[n4];
                ++n3;
                ++n4;
            }
        }
        int j;
        int n8;
        while (true) {
            j = n5;
            n8 = n7;
            if (n6 > n2) {
                break;
            }
            array2[n7] = array[n6];
            ++n7;
            ++n6;
        }
        while (j <= n) {
            array2[n8] = array[j];
            ++n8;
            ++j;
        }
        while (i <= n2) {
            array[i] = array2[i];
            ++i;
        }
    }
    
    public static void mergeSort(final int[] array) {
        sort(array, 0, array.length - 1);
    }
    
    public static void sort(final int[] array, final int n, final int n2) {
        if (n >= n2) {
            return;
        }
        final int n3 = (n + n2) / 2;
        sort(array, n, n3);
        sort(array, n3 + 1, n2);
        merge(array, n, n3, n2);
    }
    
    public static int[] sumArray(final int[][] array, int n) {
        int[] array2 = null;
        if (n == 2) {
            final int[] array3 = new int[array.length];
            int n2 = 0;
            while (true) {
                array2 = array3;
                if (n2 >= array.length) {
                    break;
                }
                for (int i = 0; i < array[0].length; ++i) {
                    array3[n2] += array[n2][i];
                }
                ++n2;
            }
        }
        if (n == 1) {
            final int[] array4 = new int[array[0].length];
            n = 0;
            while (true) {
                array2 = array4;
                if (n >= array[0].length) {
                    break;
                }
                for (int j = 0; j < array.length; ++j) {
                    array4[n] += array[j][n];
                }
                ++n;
            }
        }
        return array2;
    }
    
    public static double var(final double[] array) {
        double n = 0.0;
        for (int i = 0; i < array.length; ++i) {
            n += array[i];
        }
        final double n2 = n / array.length;
        double n3 = 0.0;
        for (int j = 0; j < array.length; ++j) {
            n3 += (array[j] - n2) * (array[j] - n2);
        }
        return n3 / array.length;
    }
}

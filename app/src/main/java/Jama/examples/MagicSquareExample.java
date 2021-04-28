package Jama.examples;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Date;

import Jama.EigenvalueDecomposition;
import Jama.LUDecomposition;
import Jama.Matrix;
import Jama.QRDecomposition;

public class MagicSquareExample
{
    public static String fixedWidthDoubletoString(final double n, final int n2, final int n3) {
        final DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(n3);
        decimalFormat.setMinimumFractionDigits(n3);
        decimalFormat.setGroupingUsed(false);
        String s;
        for (s = decimalFormat.format(n); s.length() < n2; s = " " + s) {}
        return s;
    }
    
    public static String fixedWidthIntegertoString(final int n, final int n2) {
        String s;
        for (s = Integer.toString(n); s.length() < n2; s = " " + s) {}
        return s;
    }
    
    public static Matrix magic(final int n) {
        final double[][] array = (double[][])Array.newInstance(Double.TYPE, n, n);
        if (n % 2 == 1) {
            final int n2 = (n + 1) / 2;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    array[j][i] = (j + i + n2) % n * n + (i * 2 + j + (n + 1)) % n + 1;
                }
            }
        }
        else if (n % 4 == 0) {
            for (int k = 0; k < n; ++k) {
                for (int l = 0; l < n; ++l) {
                    if ((l + 1) / 2 % 2 == (k + 1) / 2 % 2) {
                        array[l][k] = n * n - n * l - k;
                    }
                    else {
                        array[l][k] = n * l + k + 1;
                    }
                }
            }
        }
        else {
            final int n3 = n / 2;
            final int n4 = (n - 2) / 4;
            final Matrix magic = magic(n3);
            for (int n5 = 0; n5 < n3; ++n5) {
                for (int n6 = 0; n6 < n3; ++n6) {
                    final double value = magic.get(n6, n5);
                    array[n6][n5] = value;
                    array[n6][n5 + n3] = n3 * 2 * n3 + value;
                    array[n6 + n3][n5] = n3 * 3 * n3 + value;
                    array[n6 + n3][n5 + n3] = value + n3 * n3;
                }
            }
            for (int n7 = 0; n7 < n3; ++n7) {
                for (int n8 = 0; n8 < n4; ++n8) {
                    final double n9 = array[n7][n8];
                    array[n7][n8] = array[n7 + n3][n8];
                    array[n7 + n3][n8] = n9;
                }
                for (int n10 = n - n4 + 1; n10 < n; ++n10) {
                    final double n11 = array[n7][n10];
                    array[n7][n10] = array[n7 + n3][n10];
                    array[n7 + n3][n10] = n11;
                }
            }
            final double n12 = array[n4][0];
            array[n4][0] = array[n4 + n3][0];
            array[n4 + n3][0] = n12;
            final double n13 = array[n4][n4];
            array[n4][n4] = array[n4 + n3][n4];
            array[n4 + n3][n4] = n13;
        }
        return new Matrix(array);
    }
    
    public static void main(final String[] array) {
        print("\n    Test of Matrix Class, using magic squares.\n");
        print("    See MagicSquareExample.main() for an explanation.\n");
        print("\n      n     trace       max_eig   rank        cond      lu_res      qr_res\n\n");
        final Date date = new Date();
        final double pow = Math.pow(2.0, -52.0);
        for (int i = 3; i <= 32; ++i) {
            print(fixedWidthIntegertoString(i, 7));
            final Matrix magic = magic(i);
            print(fixedWidthIntegertoString((int)magic.trace(), 10));
            print(fixedWidthDoubletoString(new EigenvalueDecomposition(magic.plus(magic.transpose()).times(0.5)).getRealEigenvalues()[i - 1], 14, 3));
            print(fixedWidthIntegertoString(magic.rank(), 7));
            final double cond = magic.cond();
            String fixedWidthDoubletoString;
            if (cond < 1.0 / pow) {
                fixedWidthDoubletoString = fixedWidthDoubletoString(cond, 12, 3);
            }
            else {
                fixedWidthDoubletoString = "         Inf";
            }
            print(fixedWidthDoubletoString);
            final LUDecomposition luDecomposition = new LUDecomposition(magic);
            print(fixedWidthDoubletoString(luDecomposition.getL().times(luDecomposition.getU()).minus(magic.getMatrix(luDecomposition.getPivot(), 0, i - 1)).norm1() / (i * pow), 12, 3));
            final QRDecomposition qrDecomposition = new QRDecomposition(magic);
            print(fixedWidthDoubletoString(qrDecomposition.getQ().times(qrDecomposition.getR()).minus(magic).norm1() / (i * pow), 12, 3));
            print("\n");
        }
        print("\nElapsed Time = " + fixedWidthDoubletoString((new Date().getTime() - date.getTime()) / 1000.0, 12, 3) + " seconds\n");
        print("Adios\n");
    }
    
    private static void print(final String s) {
        System.out.print(s);
    }
}

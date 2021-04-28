package Jama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

import Jama.util.Maths;

public class Matrix implements Cloneable, Serializable
{
    private static final long serialVersionUID = 1L;
    private double[][] A;
    private int m;
    private int n;
    
    public Matrix(final int m, final int n) {
        this.m = m;
        this.n = n;
        this.A = (double[][])Array.newInstance(Double.TYPE, m, n);
    }
    
    public Matrix(final int m, final int n, final double n2) {
        this.m = m;
        this.n = n;
        this.A = (double[][])Array.newInstance(Double.TYPE, m, n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                this.A[i][j] = n2;
            }
        }
    }
    
    public Matrix(final double[] array, final int m) {
        this.m = m;
        int n;
        if (m != 0) {
            n = array.length / m;
        }
        else {
            n = 0;
        }
        this.n = n;
        if (this.n * m != array.length) {
            throw new IllegalArgumentException("Array length must be a multiple of m.");
        }
        this.A = (double[][])Array.newInstance(Double.TYPE, m, this.n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                this.A[i][j] = array[j * m + i];
            }
        }
    }
    
    public Matrix(final double[][] a) {
        int i = 0;
        this.m = a.length;
        this.n = a[0].length;
        while (i < this.m) {
            if (a[i].length != this.n) {
                throw new IllegalArgumentException("All rows must have the same length.");
            }
            ++i;
        }
        this.A = a;
    }
    
    public Matrix(final double[][] a, final int m, final int n) {
        this.A = a;
        this.m = m;
        this.n = n;
    }
    
    private void checkMatrixDimensions(final Matrix matrix) {
        if (matrix.m != this.m || matrix.n != this.n) {
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
    }
    
    public static Matrix constructWithCopy(final double[][] array) {
        final int length = array.length;
        final int length2 = array[0].length;
        final Matrix matrix = new Matrix(length, length2);
        final double[][] array2 = matrix.getArray();
        for (int i = 0; i < length; ++i) {
            if (array[i].length != length2) {
                throw new IllegalArgumentException("All rows must have the same length.");
            }
            for (int j = 0; j < length2; ++j) {
                array2[i][j] = array[i][j];
            }
        }
        return matrix;
    }
    
    public static Matrix identity(final int n, final int n2) {
        final Matrix matrix = new Matrix(n, n2);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                final double[] array2 = array[i];
                long n3;
                if (i == j) {
                    n3 = 4607182418800017408L;
                }
                else {
                    n3 = 0L;
                }
                array2[j] = n3;
            }
        }
        return matrix;
    }
    
    public static Matrix random(final int n, final int n2) {
        final Matrix matrix = new Matrix(n, n2);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = Math.random();
            }
        }
        return matrix;
    }
    
    public static Matrix read(final BufferedReader bufferedReader) throws IOException {
        final StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
        streamTokenizer.resetSyntax();
        streamTokenizer.wordChars(0, 255);
        streamTokenizer.whitespaceChars(0, 32);
        streamTokenizer.eolIsSignificant(true);
        final Vector<Double> vector = new Vector<Double>();
        while (streamTokenizer.nextToken() == 10) {}
        if (streamTokenizer.ttype == -1) {
            throw new IOException("Unexpected EOF on matrix read.");
        }
        do {
            vector.addElement(Double.valueOf(streamTokenizer.sval));
        } while (streamTokenizer.nextToken() == -3);
        final int size = vector.size();
        final double[] array = new double[size];
        for (int i = 0; i < size; ++i) {
            array[i] = vector.elementAt(i);
        }
        final Vector<double[]> vector2 = new Vector<double[]>();
        vector2.addElement(array);
    Label_0147:
        while (streamTokenizer.nextToken() == -3) {
            final double[] array2 = new double[size];
            vector2.addElement(array2);
            int j = 0;
            while (j < size) {
                final int n = j + 1;
                array2[j] = Double.valueOf(streamTokenizer.sval);
                if (streamTokenizer.nextToken() != -3) {
                    if (n < size) {
                        throw new IOException("Row " + vector2.size() + " is too short.");
                    }
                    continue Label_0147;
                }
                else {
                    j = n;
                }
            }
            throw new IOException("Row " + vector2.size() + " is too long.");
        }
        final double[][] array3 = new double[vector2.size()][];
        vector2.copyInto(array3);
        return new Matrix(array3);
    }
    
    public Matrix arrayLeftDivide(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        final Matrix matrix2 = new Matrix(this.m, this.n);
        final double[][] array = matrix2.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = matrix.A[i][j] / this.A[i][j];
            }
        }
        return matrix2;
    }
    
    public Matrix arrayLeftDivideEquals(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                this.A[i][j] = matrix.A[i][j] / this.A[i][j];
            }
        }
        return this;
    }
    
    public Matrix arrayRightDivide(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        final Matrix matrix2 = new Matrix(this.m, this.n);
        final double[][] array = matrix2.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = this.A[i][j] / matrix.A[i][j];
            }
        }
        return matrix2;
    }
    
    public Matrix arrayRightDivideEquals(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                this.A[i][j] /= matrix.A[i][j];
            }
        }
        return this;
    }
    
    public Matrix arrayTimes(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        final Matrix matrix2 = new Matrix(this.m, this.n);
        final double[][] array = matrix2.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = this.A[i][j] * matrix.A[i][j];
            }
        }
        return matrix2;
    }
    
    public Matrix arrayTimesEquals(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                this.A[i][j] *= matrix.A[i][j];
            }
        }
        return this;
    }
    
    public CholeskyDecomposition chol() {
        return new CholeskyDecomposition(this);
    }
    
    public Object clone() {
        return this.copy();
    }
    
    public double cond() {
        return new SingularValueDecomposition(this).cond();
    }
    
    public Matrix copy() {
        final Matrix matrix = new Matrix(this.m, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = this.A[i][j];
            }
        }
        return matrix;
    }
    
    public double det() {
        return new LUDecomposition(this).det();
    }
    
    public EigenvalueDecomposition eig() {
        return new EigenvalueDecomposition(this);
    }
    
    public double get(final int n, final int n2) {
        return this.A[n][n2];
    }
    
    public double[][] getArray() {
        return this.A;
    }
    
    public double[][] getArrayCopy() {
        final double[][] array = (double[][])Array.newInstance(Double.TYPE, this.m, this.n);
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = this.A[i][j];
            }
        }
        return array;
    }
    
    public int getColumnDimension() {
        return this.n;
    }
    
    public double[] getColumnPackedCopy() {
        final double[] array = new double[this.m * this.n];
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[this.m * j + i] = this.A[i][j];
            }
        }
        return array;
    }
    
    public Matrix getMatrix(final int n, final int n2, final int n3, final int n4) {
        final Matrix matrix = new Matrix(n2 - n + 1, n4 - n3 + 1);
        final double[][] array = matrix.getArray();
    Label_0098:
        for (int i = n; i <= n2; ++i) {
            int n5 = n3;
        Label_0077_Outer:
            while (true) {
                while (true) {
                    if (n5 <= n4) {
                        try {
                            array[i - n][n5 - n3] = this.A[i][n5];
                            ++n5;
                            continue Label_0077_Outer;
                            //break;
                        }
                        catch (ArrayIndexOutOfBoundsException ex) {
                            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
                        }
                      //  break Label_0098;
                    }
                    continue;
                }
            }
        }
        return matrix;
    }
    
    public Matrix getMatrix(final int n, final int n2, final int[] array) {
        final Matrix matrix = new Matrix(n2 - n + 1, array.length);
        final double[][] array2 = matrix.getArray();
        int i = n;
        while (i <= n2) {
            int j = 0;
            try {
                while (j < array.length) {
                    array2[i - n][j] = this.A[i][array[j]];
                    ++j;
                }
                ++i;
                continue;
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                throw new ArrayIndexOutOfBoundsException("Submatrix indices");
            }
            //break;
        }
        return matrix;
    }
    
    public Matrix getMatrix(final int[] array, final int n, final int n2) {
        final Matrix matrix = new Matrix(array.length, n2 - n + 1);
        final double[][] array2 = matrix.getArray();
        int i = 0;
        try {
            while (i < array.length) {
                for (int j = n; j <= n2; ++j) {
                    array2[i][j - n] = this.A[array[i]][j];
                }
                ++i;
            }
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
        }
        return matrix;
    }
    
    public Matrix getMatrix(final int[] array, final int[] array2) {
        final Matrix matrix = new Matrix(array.length, array2.length);
        final double[][] array3 = matrix.getArray();
        int i = 0;
        try {
            while (i < array.length) {
                for (int j = 0; j < array2.length; ++j) {
                    array3[i][j] = this.A[array[i]][array2[j]];
                }
                ++i;
            }
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
        }
        return matrix;
    }
    
    public int getRowDimension() {
        return this.m;
    }
    
    public double[] getRowPackedCopy() {
        final double[] array = new double[this.m * this.n];
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[this.n * i + j] = this.A[i][j];
            }
        }
        return array;
    }
    
    public Matrix inverse() {
        return this.solve(identity(this.m, this.m));
    }
    
    public LUDecomposition lu() {
        return new LUDecomposition(this);
    }
    
    public Matrix minus(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        final Matrix matrix2 = new Matrix(this.m, this.n);
        final double[][] array = matrix2.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = this.A[i][j] - matrix.A[i][j];
            }
        }
        return matrix2;
    }
    
    public Matrix minusEquals(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                this.A[i][j] -= matrix.A[i][j];
            }
        }
        return this;
    }
    
    public double norm1() {
        int i = 0;
        double max = 0.0;
        while (i < this.n) {
            int j = 0;
            double n = 0.0;
            while (j < this.m) {
                n += Math.abs(this.A[j][i]);
                ++j;
            }
            max = Math.max(max, n);
            ++i;
        }
        return max;
    }
    
    public double norm2() {
        return new SingularValueDecomposition(this).norm2();
    }
    
    public double normF() {
        double hypot = 0.0;
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                hypot = Maths.hypot(hypot, this.A[i][j]);
            }
        }
        return hypot;
    }
    
    public double normInf() {
        int i = 0;
        double max = 0.0;
        while (i < this.m) {
            int j = 0;
            double n = 0.0;
            while (j < this.n) {
                n += Math.abs(this.A[i][j]);
                ++j;
            }
            max = Math.max(max, n);
            ++i;
        }
        return max;
    }
    
    public Matrix plus(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        final Matrix matrix2 = new Matrix(this.m, this.n);
        final double[][] array = matrix2.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = this.A[i][j] + matrix.A[i][j];
            }
        }
        return matrix2;
    }
    
    public Matrix plusEquals(final Matrix matrix) {
        this.checkMatrixDimensions(matrix);
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                this.A[i][j] += matrix.A[i][j];
            }
        }
        return this;
    }
    
    public void print(final int n, final int n2) {
        this.print(new PrintWriter(System.out, true), n, n2);
    }
    
    public void print(final PrintWriter printWriter, final int n, final int n2) {
        final DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
        decimalFormat.setMinimumIntegerDigits(1);
        decimalFormat.setMaximumFractionDigits(n2);
        decimalFormat.setMinimumFractionDigits(n2);
        decimalFormat.setGroupingUsed(false);
        this.print(printWriter, decimalFormat, n + 2);
    }
    
    public void print(final PrintWriter printWriter, final NumberFormat numberFormat, final int n) {
        printWriter.println();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                final String format = numberFormat.format(this.A[i][j]);
                for (int max = Math.max(1, n - format.length()), k = 0; k < max; ++k) {
                    printWriter.print(' ');
                }
                printWriter.print(format);
            }
            printWriter.println();
        }
        printWriter.println();
    }
    
    public void print(final NumberFormat numberFormat, final int n) {
        this.print(new PrintWriter(System.out, true), numberFormat, n);
    }
    
    public QRDecomposition qr() {
        return new QRDecomposition(this);
    }
    
    public int rank() {
        return new SingularValueDecomposition(this).rank();
    }
    
    public void set(final int n, final int n2, final double n3) {
        this.A[n][n2] = n3;
    }
    
    public void setMatrix(final int n, final int n2, final int n3, final int n4, final Matrix matrix) {
    Label_0072:
        for (int i = n; i <= n2; ++i) {
            int n5 = n3;
        Label_0051_Outer:
            while (true) {
                while (true) {
                    if (n5 <= n4) {
                        try {
                            this.A[i][n5] = matrix.get(i - n, n5 - n3);
                            ++n5;
                            continue Label_0051_Outer;
                            //break;
                        }
                        catch (ArrayIndexOutOfBoundsException ex) {
                            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
                        }
                        //break Label_0072;
                    }
                    continue;
                }
            }
        }
    }
    
    public void setMatrix(final int n, final int n2, final int[] array, final Matrix matrix) {
        int i = n;
        while (i <= n2) {
            int j = 0;
            try {
                while (j < array.length) {
                    this.A[i][array[j]] = matrix.get(i - n, j);
                    ++j;
                }
                ++i;
                continue;
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                throw new ArrayIndexOutOfBoundsException("Submatrix indices");
            }
           // break;
        }
    }
    
    public void setMatrix(final int[] array, final int n, final int n2, final Matrix matrix) {
        int i = 0;
        try {
            while (i < array.length) {
                for (int j = n; j <= n2; ++j) {
                    this.A[array[i]][j] = matrix.get(i, j - n);
                }
                ++i;
            }
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
        }
    }
    
    public void setMatrix(final int[] array, final int[] array2, final Matrix matrix) {
        int i = 0;
        try {
            while (i < array.length) {
                for (int j = 0; j < array2.length; ++j) {
                    this.A[array[i]][array2[j]] = matrix.get(i, j);
                }
                ++i;
            }
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
        }
    }
    
    public Matrix solve(final Matrix matrix) {
        if (this.m == this.n) {
            return new LUDecomposition(this).solve(matrix);
        }
        return new QRDecomposition(this).solve(matrix);
    }
    
    public Matrix solveTranspose(final Matrix matrix) {
        return this.transpose().solve(matrix.transpose());
    }
    
    public SingularValueDecomposition svd() {
        return new SingularValueDecomposition(this);
    }
    
    public Matrix times(final double n) {
        final Matrix matrix = new Matrix(this.m, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = this.A[i][j] * n;
            }
        }
        return matrix;
    }
    
    public Matrix times(final Matrix matrix) {
        if (matrix.m != this.n) {
            throw new IllegalArgumentException("Matrix inner dimensions must agree.");
        }
        final Matrix matrix2 = new Matrix(this.m, matrix.n);
        final double[][] array = matrix2.getArray();
        final double[] array2 = new double[this.n];
        for (int i = 0; i < matrix.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array2[j] = matrix.A[j][i];
            }
            for (int k = 0; k < this.m; ++k) {
                final double[] array3 = this.A[k];
                double n = 0.0;
                for (int l = 0; l < this.n; ++l) {
                    n += array3[l] * array2[l];
                }
                array[k][i] = n;
            }
        }
        return matrix2;
    }
    
    public Matrix timesEquals(final double n) {
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                this.A[i][j] *= n;
            }
        }
        return this;
    }
    
    public double trace() {
        double n = 0.0;
        for (int i = 0; i < Math.min(this.m, this.n); ++i) {
            n += this.A[i][i];
        }
        return n;
    }
    
    public Matrix transpose() {
        final Matrix matrix = new Matrix(this.n, this.m);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[j][i] = this.A[i][j];
            }
        }
        return matrix;
    }
    
    public Matrix uminus() {
        final Matrix matrix = new Matrix(this.m, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = -this.A[i][j];
            }
        }
        return matrix;
    }
}

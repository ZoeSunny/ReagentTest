package Jama;

import java.io.Serializable;
import java.lang.reflect.Array;

public class CholeskyDecomposition implements Serializable
{
    private static final long serialVersionUID = 1L;
    private double[][] L;
    private boolean isspd;
    private int n;
    
    public CholeskyDecomposition(final Matrix matrix) {
        final double[][] array = matrix.getArray();
        this.n = matrix.getRowDimension();
        this.L = (double[][])Array.newInstance(Double.TYPE, this.n, this.n);
        this.isspd = (matrix.getColumnDimension() == this.n);
        for (int i = 0; i < this.n; ++i) {
            final double[] array2 = this.L[i];
            int j;
            double n;
            double[] array3;
            double n2;
            int k;
            double n3;
            boolean isspd;
            boolean b;
            for (j = 0, n = 0.0; j < i; ++j, n += n3 * n3) {
                array3 = this.L[j];
                n2 = 0.0;
                for (k = 0; k < j; ++k) {
                    n2 += array3[k] * array2[k];
                }
                n3 = (array[i][j] - n2) / this.L[j][j];
                array2[j] = n3;
                isspd = this.isspd;
                if (array[j][i] == array[i][j]) {
                    b = true;
                }
                else {
                    b = false;
                }
                this.isspd = (b & isspd);
            }
            final double n4 = array[i][i] - n;
            final boolean isspd2 = this.isspd;
            boolean b2;
            if (n4 > 0.0) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            this.isspd = (b2 & isspd2);
            this.L[i][i] = Math.sqrt(Math.max(n4, 0.0));
            for (int l = i + 1; l < this.n; ++l) {
                this.L[i][l] = 0L;
            }
        }
    }
    
    public Matrix getL() {
        return new Matrix(this.L, this.n, this.n);
    }
    
    public boolean isSPD() {
        return this.isspd;
    }
    
    public Matrix solve(final Matrix matrix) {
        if (matrix.getRowDimension() != this.n) {
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
        }
        if (!this.isspd) {
            throw new RuntimeException("Matrix is not symmetric positive definite.");
        }
        final double[][] arrayCopy = matrix.getArrayCopy();
        final int columnDimension = matrix.getColumnDimension();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < columnDimension; ++j) {
                for (int k = 0; k < i; ++k) {
                    final double[] array = arrayCopy[i];
                    array[j] -= arrayCopy[k][j] * this.L[i][k];
                }
                final double[] array2 = arrayCopy[i];
                array2[j] /= this.L[i][i];
            }
        }
        for (int l = this.n - 1; l >= 0; --l) {
            for (int n = 0; n < columnDimension; ++n) {
                for (int n2 = l + 1; n2 < this.n; ++n2) {
                    final double[] array3 = arrayCopy[l];
                    array3[n] -= arrayCopy[n2][n] * this.L[n2][l];
                }
                final double[] array4 = arrayCopy[l];
                array4[n] /= this.L[l][l];
            }
        }
        return new Matrix(arrayCopy, this.n, columnDimension);
    }
}

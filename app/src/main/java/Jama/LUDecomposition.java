package Jama;

import java.io.Serializable;

public class LUDecomposition implements Serializable
{
    private static final long serialVersionUID = 1L;
    private double[][] LU;
    private int m;
    private int n;
    private int[] piv;
    private int pivsign;
    
    public LUDecomposition(final Matrix matrix) {
        this.LU = matrix.getArrayCopy();
        this.m = matrix.getRowDimension();
        this.n = matrix.getColumnDimension();
        this.piv = new int[this.m];
        for (int i = 0; i < this.m; ++i) {
            this.piv[i] = i;
        }
        this.pivsign = 1;
        final double[] array = new double[this.m];
        for (int j = 0; j < this.n; ++j) {
            for (int k = 0; k < this.m; ++k) {
                array[k] = this.LU[k][j];
            }
            for (int l = 0; l < this.m; ++l) {
                final double[] array2 = this.LU[l];
                final int min = Math.min(l, j);
                double n = 0.0;
                for (int n2 = 0; n2 < min; ++n2) {
                    n += array2[n2] * array[n2];
                }
                array2[j] = (array[l] -= n);
            }
            int n3 = j + 1;
            int n4 = j;
            while (n3 < this.m) {
                int n5 = n4;
                if (Math.abs(array[n3]) > Math.abs(array[n4])) {
                    n5 = n3;
                }
                ++n3;
                n4 = n5;
            }
            if (n4 != j) {
                for (int n6 = 0; n6 < this.n; ++n6) {
                    final double n7 = this.LU[n4][n6];
                    this.LU[n4][n6] = this.LU[j][n6];
                    this.LU[j][n6] = n7;
                }
                final int n8 = this.piv[n4];
                this.piv[n4] = this.piv[j];
                this.piv[j] = n8;
                this.pivsign = -this.pivsign;
            }
            boolean b;
            if (j < this.m) {
                b = true;
            }
            else {
                b = false;
            }
            boolean b2;
            if (this.LU[j][j] != 0.0) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            if (b & b2) {
                for (int n9 = j + 1; n9 < this.m; ++n9) {
                    final double[] array3 = this.LU[n9];
                    array3[j] /= this.LU[j][j];
                }
            }
        }
    }
    
    public double det() {
        if (this.m != this.n) {
            throw new IllegalArgumentException("Matrix must be square.");
        }
        double n = this.pivsign;
        for (int i = 0; i < this.n; ++i) {
            n *= this.LU[i][i];
        }
        return n;
    }
    
    public double[] getDoublePivot() {
        final double[] array = new double[this.m];
        for (int i = 0; i < this.m; ++i) {
            array[i] = this.piv[i];
        }
        return array;
    }
    
    public Matrix getL() {
        final Matrix matrix = new Matrix(this.m, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                if (i > j) {
                    array[i][j] = this.LU[i][j];
                }
                else if (i == j) {
                    array[i][j] = 4607182418800017408L;
                }
                else {
                    array[i][j] = 0L;
                }
            }
        }
        return matrix;
    }
    
    public int[] getPivot() {
        final int[] array = new int[this.m];
        for (int i = 0; i < this.m; ++i) {
            array[i] = this.piv[i];
        }
        return array;
    }
    
    public Matrix getU() {
        final Matrix matrix = new Matrix(this.n, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                if (i <= j) {
                    array[i][j] = this.LU[i][j];
                }
                else {
                    array[i][j] = 0L;
                }
            }
        }
        return matrix;
    }
    
    public boolean isNonsingular() {
        for (int i = 0; i < this.n; ++i) {
            if (this.LU[i][i] == 0.0) {
                return false;
            }
        }
        return true;
    }
    
    public Matrix solve(Matrix matrix) {
        if (matrix.getRowDimension() != this.m) {
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
        }
        if (!this.isNonsingular()) {
            throw new RuntimeException("Matrix is singular.");
        }
        final int columnDimension = matrix.getColumnDimension();
        matrix = matrix.getMatrix(this.piv, 0, columnDimension - 1);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.n; ++i) {
            for (int j = i + 1; j < this.n; ++j) {
                for (int k = 0; k < columnDimension; ++k) {
                    final double[] array2 = array[j];
                    array2[k] -= array[i][k] * this.LU[j][i];
                }
            }
        }
        for (int l = this.n - 1; l >= 0; --l) {
            for (int n = 0; n < columnDimension; ++n) {
                final double[] array3 = array[l];
                array3[n] /= this.LU[l][l];
            }
            for (int n2 = 0; n2 < l; ++n2) {
                for (int n3 = 0; n3 < columnDimension; ++n3) {
                    final double[] array4 = array[n2];
                    array4[n3] -= array[l][n3] * this.LU[n2][l];
                }
            }
        }
        return matrix;
    }
}

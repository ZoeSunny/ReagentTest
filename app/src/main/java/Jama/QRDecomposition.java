package Jama;

import java.io.Serializable;

import Jama.util.Maths;

public class QRDecomposition implements Serializable
{
    private static final long serialVersionUID = 1L;
    private double[][] QR;
    private double[] Rdiag;
    private int m;
    private int n;
    
    public QRDecomposition(final Matrix matrix) {
        this.QR = matrix.getArrayCopy();
        this.m = matrix.getRowDimension();
        this.n = matrix.getColumnDimension();
        this.Rdiag = new double[this.n];
        for (int i = 0; i < this.n; ++i) {
            int j = i;
            double hypot = 0.0;
            while (j < this.m) {
                hypot = Maths.hypot(hypot, this.QR[j][i]);
                ++j;
            }
            double n = hypot;
            if (hypot != 0.0) {
                double n2 = hypot;
                if (this.QR[i][i] < 0.0) {
                    n2 = -hypot;
                }
                for (int k = i; k < this.m; ++k) {
                    final double[] array = this.QR[k];
                    array[i] /= n2;
                }
                final double[] array2 = this.QR[i];
                ++array2[i];
                int n3 = i + 1;
                while (true) {
                    n = n2;
                    if (n3 >= this.n) {
                        break;
                    }
                    int l = i;
                    double n4 = 0.0;
                    while (l < this.m) {
                        n4 += this.QR[l][i] * this.QR[l][n3];
                        ++l;
                    }
                    final double n5 = -n4 / this.QR[i][i];
                    for (int n6 = i; n6 < this.m; ++n6) {
                        final double[] array3 = this.QR[n6];
                        array3[n3] += this.QR[n6][i] * n5;
                    }
                    ++n3;
                }
            }
            this.Rdiag[i] = -n;
        }
    }
    
    public Matrix getH() {
        final Matrix matrix = new Matrix(this.m, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                if (i >= j) {
                    array[i][j] = this.QR[i][j];
                }
                else {
                    array[i][j] = 0L;
                }
            }
        }
        return matrix;
    }
    
    public Matrix getQ() {
        final Matrix matrix = new Matrix(this.m, this.n);
        final double[][] array = matrix.getArray();
        for (int i = this.n - 1; i >= 0; --i) {
            for (int j = 0; j < this.m; ++j) {
                array[j][i] = 0L;
            }
            array[i][i] = 4607182418800017408L;
            for (int k = i; k < this.n; ++k) {
                if (this.QR[i][i] != 0.0) {
                    int l = i;
                    double n = 0.0;
                    while (l < this.m) {
                        n += this.QR[l][i] * array[l][k];
                        ++l;
                    }
                    final double n2 = -n / this.QR[i][i];
                    for (int n3 = i; n3 < this.m; ++n3) {
                        final double[] array2 = array[n3];
                        array2[k] += this.QR[n3][i] * n2;
                    }
                }
            }
        }
        return matrix;
    }
    
    public Matrix getR() {
        final Matrix matrix = new Matrix(this.n, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                if (i < j) {
                    array[i][j] = this.QR[i][j];
                }
                else if (i == j) {
                    array[i][j] = this.Rdiag[i];
                }
                else {
                    array[i][j] = 0L;
                }
            }
        }
        return matrix;
    }
    
    public boolean isFullRank() {
        for (int i = 0; i < this.n; ++i) {
            if (this.Rdiag[i] == 0.0) {
                return false;
            }
        }
        return true;
    }
    
    public Matrix solve(final Matrix matrix) {
        if (matrix.getRowDimension() != this.m) {
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
        }
        if (!this.isFullRank()) {
            throw new RuntimeException("Matrix is rank deficient.");
        }
        final int columnDimension = matrix.getColumnDimension();
        final double[][] arrayCopy = matrix.getArrayCopy();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < columnDimension; ++j) {
                double n = 0.0;
                for (int k = i; k < this.m; ++k) {
                    n += this.QR[k][i] * arrayCopy[k][j];
                }
                final double n2 = -n / this.QR[i][i];
                for (int l = i; l < this.m; ++l) {
                    final double[] array = arrayCopy[l];
                    array[j] += this.QR[l][i] * n2;
                }
            }
        }
        for (int n3 = this.n - 1; n3 >= 0; --n3) {
            for (int n4 = 0; n4 < columnDimension; ++n4) {
                final double[] array2 = arrayCopy[n3];
                array2[n4] /= this.Rdiag[n3];
            }
            for (int n5 = 0; n5 < n3; ++n5) {
                for (int n6 = 0; n6 < columnDimension; ++n6) {
                    final double[] array3 = arrayCopy[n5];
                    array3[n6] -= arrayCopy[n3][n6] * this.QR[n5][n3];
                }
            }
        }
        return new Matrix(arrayCopy, this.n, columnDimension).getMatrix(0, this.n - 1, 0, columnDimension - 1);
    }
}

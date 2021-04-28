package Jama;

import java.io.Serializable;
import java.lang.reflect.Array;

import Jama.util.Maths;

public class SingularValueDecomposition implements Serializable
{
    private static final long serialVersionUID = 1L;
    private double[][] U;
    private double[][] V;
    private int m;
    private int n;
    private double[] s;
    
    public SingularValueDecomposition(final Matrix matrix) {
        final double[][] arrayCopy = matrix.getArrayCopy();
        this.m = matrix.getRowDimension();
        this.n = matrix.getColumnDimension();
        final int min = Math.min(this.m, this.n);
        this.s = new double[Math.min(this.m + 1, this.n)];
        this.U = (double[][])Array.newInstance(Double.TYPE, this.m, min);
        this.V = (double[][])Array.newInstance(Double.TYPE, this.n, this.n);
        final double[] array = new double[this.n];
        final double[] array2 = new double[this.m];
        final int min2 = Math.min(this.m - 1, this.n);
        final int max = Math.max(0, Math.min(this.n - 2, this.m));
        for (int i = 0; i < Math.max(min2, max); ++i) {
            if (i < min2) {
                this.s[i] = 0.0;
                for (int j = i; j < this.m; ++j) {
                    this.s[i] = Maths.hypot(this.s[i], arrayCopy[j][i]);
                }
                if (this.s[i] != 0.0) {
                    if (arrayCopy[i][i] < 0.0) {
                        this.s[i] = -this.s[i];
                    }
                    for (int k = i; k < this.m; ++k) {
                        final double[] array3 = arrayCopy[k];
                        array3[i] /= this.s[i];
                    }
                    final double[] array4 = arrayCopy[i];
                    ++array4[i];
                }
                this.s[i] = -this.s[i];
            }
            for (int l = i + 1; l < this.n; ++l) {
                boolean b;
                if (i < min2) {
                    b = true;
                }
                else {
                    b = false;
                }
                boolean b2;
                if (this.s[i] != 0.0) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                if (b & b2) {
                    double n = 0.0;
                    for (int n2 = i; n2 < this.m; ++n2) {
                        n += arrayCopy[n2][i] * arrayCopy[n2][l];
                    }
                    final double n3 = -n / arrayCopy[i][i];
                    for (int n4 = i; n4 < this.m; ++n4) {
                        final double[] array5 = arrayCopy[n4];
                        array5[l] += arrayCopy[n4][i] * n3;
                    }
                }
                array[l] = arrayCopy[i][l];
            }
            boolean b3;
            if (i < min2) {
                b3 = true;
            }
            else {
                b3 = false;
            }
            if (b3 & true) {
                for (int n5 = i; n5 < this.m; ++n5) {
                    this.U[n5][i] = arrayCopy[n5][i];
                }
            }
            if (i < max) {
                array[i] = 0.0;
                for (int n6 = i + 1; n6 < this.n; ++n6) {
                    array[i] = Maths.hypot(array[i], array[n6]);
                }
                if (array[i] != 0.0) {
                    if (array[i + 1] < 0.0) {
                        array[i] = -array[i];
                    }
                    for (int n7 = i + 1; n7 < this.n; ++n7) {
                        array[n7] /= array[i];
                    }
                    final int n8 = i + 1;
                    ++array[n8];
                }
                array[i] = -array[i];
                boolean b4;
                if (i + 1 < this.m) {
                    b4 = true;
                }
                else {
                    b4 = false;
                }
                boolean b5;
                if (array[i] != 0.0) {
                    b5 = true;
                }
                else {
                    b5 = false;
                }
                if (b4 & b5) {
                    for (int n9 = i + 1; n9 < this.m; ++n9) {
                        array2[n9] = 0.0;
                    }
                    for (int n10 = i + 1; n10 < this.n; ++n10) {
                        for (int n11 = i + 1; n11 < this.m; ++n11) {
                            array2[n11] += array[n10] * arrayCopy[n11][n10];
                        }
                    }
                    for (int n12 = i + 1; n12 < this.n; ++n12) {
                        final double n13 = -array[n12] / array[i + 1];
                        for (int n14 = i + 1; n14 < this.m; ++n14) {
                            final double[] array6 = arrayCopy[n14];
                            array6[n12] += array2[n14] * n13;
                        }
                    }
                }
                for (int n15 = i + 1; n15 < this.n; ++n15) {
                    this.V[n15][i] = array[n15];
                }
            }
        }
        final int min3 = Math.min(this.n, this.m + 1);
        if (min2 < this.n) {
            this.s[min2] = arrayCopy[min2][min2];
        }
        if (this.m < min3) {
            this.s[min3 - 1] = 0.0;
        }
        if (max + 1 < min3) {
            array[max] = arrayCopy[max][min3 - 1];
        }
        array[min3 - 1] = 0.0;
        for (int n16 = min2; n16 < min; ++n16) {
            for (int n17 = 0; n17 < this.m; ++n17) {
                this.U[n17][n16] = 0L;
            }
            this.U[n16][n16] = 4607182418800017408L;
        }
        for (int n18 = min2 - 1; n18 >= 0; --n18) {
            if (this.s[n18] != 0.0) {
                for (int n19 = n18 + 1; n19 < min; ++n19) {
                    double n20 = 0.0;
                    for (int n21 = n18; n21 < this.m; ++n21) {
                        n20 += this.U[n21][n18] * this.U[n21][n19];
                    }
                    final double n22 = -n20 / this.U[n18][n18];
                    for (int n23 = n18; n23 < this.m; ++n23) {
                        final double[] array7 = this.U[n23];
                        array7[n19] += this.U[n23][n18] * n22;
                    }
                }
                for (int n24 = n18; n24 < this.m; ++n24) {
                    this.U[n24][n18] = -this.U[n24][n18];
                }
                ++this.U[n18][n18];
                for (int n25 = 0; n25 < n18 - 1; ++n25) {
                    this.U[n25][n18] = 0L;
                }
            }
            else {
                for (int n26 = 0; n26 < this.m; ++n26) {
                    this.U[n26][n18] = 0L;
                }
                this.U[n18][n18] = 4607182418800017408L;
            }
        }
        for (int n27 = this.n - 1; n27 >= 0; --n27) {
            boolean b6;
            if (n27 < max) {
                b6 = true;
            }
            else {
                b6 = false;
            }
            boolean b7;
            if (array[n27] != 0.0) {
                b7 = true;
            }
            else {
                b7 = false;
            }
            if (b6 & b7) {
                for (int n28 = n27 + 1; n28 < min; ++n28) {
                    double n29 = 0.0;
                    for (int n30 = n27 + 1; n30 < this.n; ++n30) {
                        n29 += this.V[n30][n27] * this.V[n30][n28];
                    }
                    final double n31 = -n29 / this.V[n27 + 1][n27];
                    for (int n32 = n27 + 1; n32 < this.n; ++n32) {
                        final double[] array8 = this.V[n32];
                        array8[n28] += this.V[n32][n27] * n31;
                    }
                }
            }
            for (int n33 = 0; n33 < this.n; ++n33) {
                this.V[n33][n27] = 0L;
            }
            this.V[n27][n27] = 4607182418800017408L;
        }
        final int n34 = min3 - 1;
        int n35 = 0;
        final double pow = Math.pow(2.0, -52.0);
        final double pow2 = Math.pow(2.0, -966.0);
        int n97;
        for (int n36 = min3; n36 > 0; n36 = n97) {
            int n37;
            for (n37 = n36 - 2; n37 >= -1 && n37 != -1; --n37) {
                if (Math.abs(array[n37]) <= (Math.abs(this.s[n37]) + Math.abs(this.s[n37 + 1])) * pow + pow2) {
                    array[n37] = 0.0;
                    break;
                }
            }
            int n39;
            int n40;
            if (n37 == n36 - 2) {
                final int n38 = 4;
                n39 = n37;
                n40 = n38;
            }
            else {
                for (n39 = n36 - 1; n39 >= n37 && n39 != n37; --n39) {
                    double abs;
                    if (n39 != n36) {
                        abs = Math.abs(array[n39]);
                    }
                    else {
                        abs = 0.0;
                    }
                    double abs2;
                    if (n39 != n37 + 1) {
                        abs2 = Math.abs(array[n39 - 1]);
                    }
                    else {
                        abs2 = 0.0;
                    }
                    if (Math.abs(this.s[n39]) <= (abs2 + abs) * pow + pow2) {
                        this.s[n39] = 0.0;
                        break;
                    }
                }
                if (n39 == n37) {
                    final int n41 = 3;
                    n39 = n37;
                    n40 = n41;
                }
                else if (n39 == n36 - 1) {
                    final int n42 = 1;
                    n39 = n37;
                    n40 = n42;
                }
                else {
                    n40 = 2;
                }
            }
            final int n43 = n39 + 1;
            int n45 = 0;
            int n46 = 0;
            switch (n40) {
                default: {
                    final int n44 = n35;
                    n45 = n36;
                    n46 = n44;
                    break;
                }
                case 1: {
                    double n47 = array[n36 - 2];
                    array[n36 - 2] = 0.0;
                    for (int n48 = n36 - 2; n48 >= n43; --n48) {
                        final double hypot = Maths.hypot(this.s[n48], n47);
                        final double n49 = this.s[n48] / hypot;
                        final double n50 = n47 / hypot;
                        this.s[n48] = hypot;
                        if (n48 != n43) {
                            n47 = -n50 * array[n48 - 1];
                            array[n48 - 1] *= n49;
                        }
                        for (int n51 = 0; n51 < this.n; ++n51) {
                            final double n52 = this.V[n51][n48];
                            final double n53 = this.V[n51][n36 - 1];
                            this.V[n51][n36 - 1] = -n50 * this.V[n51][n48] + this.V[n51][n36 - 1] * n49;
                            this.V[n51][n48] = n52 * n49 + n53 * n50;
                        }
                    }
                    final int n54 = n36;
                    n46 = n35;
                    n45 = n54;
                    break;
                }
                case 2: {
                    double n55 = array[n43 - 1];
                    array[n43 - 1] = 0.0;
                    for (int n56 = n43; n56 < n36; ++n56) {
                        final double hypot2 = Maths.hypot(this.s[n56], n55);
                        final double n57 = this.s[n56] / hypot2;
                        final double n58 = n55 / hypot2;
                        this.s[n56] = hypot2;
                        n55 = -n58 * array[n56];
                        array[n56] *= n57;
                        for (int n59 = 0; n59 < this.m; ++n59) {
                            final double n60 = this.U[n59][n56];
                            final double n61 = this.U[n59][n43 - 1];
                            this.U[n59][n43 - 1] = -n58 * this.U[n59][n56] + this.U[n59][n43 - 1] * n57;
                            this.U[n59][n56] = n60 * n57 + n61 * n58;
                        }
                    }
                    final int n62 = n36;
                    n46 = n35;
                    n45 = n62;
                    break;
                }
                case 3: {
                    final double max2 = Math.max(Math.max(Math.max(Math.max(Math.abs(this.s[n36 - 1]), Math.abs(this.s[n36 - 2])), Math.abs(array[n36 - 2])), Math.abs(this.s[n43])), Math.abs(array[n43]));
                    final double n63 = this.s[n36 - 1] / max2;
                    final double n64 = this.s[n36 - 2] / max2;
                    final double n65 = array[n36 - 2] / max2;
                    final double n66 = this.s[n43] / max2;
                    final double n67 = array[n43] / max2;
                    final double n68 = ((n64 + n63) * (n64 - n63) + n65 * n65) / 2.0;
                    final double n69 = n63 * n65 * (n63 * n65);
                    double n70 = 0.0;
                    boolean b8;
                    if (n68 != 0.0) {
                        b8 = true;
                    }
                    else {
                        b8 = false;
                    }
                    boolean b9;
                    if (n69 != 0.0) {
                        b9 = true;
                    }
                    else {
                        b9 = false;
                    }
                    if (b9 | b8) {
                        double sqrt = Math.sqrt(n68 * n68 + n69);
                        if (n68 < 0.0) {
                            sqrt = -sqrt;
                        }
                        n70 = n69 / (sqrt + n68);
                    }
                    double n71 = (n66 + n63) * (n66 - n63) + n70;
                    double n72 = n66 * n67;
                    for (int n73 = n43; n73 < n36 - 1; ++n73) {
                        final double hypot3 = Maths.hypot(n71, n72);
                        final double n74 = n71 / hypot3;
                        final double n75 = n72 / hypot3;
                        if (n73 != n43) {
                            array[n73 - 1] = hypot3;
                        }
                        final double n76 = this.s[n73] * n74 + array[n73] * n75;
                        array[n73] = array[n73] * n74 - this.s[n73] * n75;
                        final double n77 = this.s[n73 + 1] * n75;
                        this.s[n73 + 1] *= n74;
                        for (int n78 = 0; n78 < this.n; ++n78) {
                            final double n79 = this.V[n78][n73];
                            final double n80 = this.V[n78][n73 + 1];
                            this.V[n78][n73 + 1] = -n75 * this.V[n78][n73] + this.V[n78][n73 + 1] * n74;
                            this.V[n78][n73] = n79 * n74 + n80 * n75;
                        }
                        final double hypot4 = Maths.hypot(n76, n77);
                        final double n81 = n76 / hypot4;
                        final double n82 = n77 / hypot4;
                        this.s[n73] = hypot4;
                        n71 = this.s[n73 + 1] * n82 + array[n73] * n81;
                        this.s[n73 + 1] = -n82 * array[n73] + this.s[n73 + 1] * n81;
                        n72 = array[n73 + 1] * n82;
                        array[n73 + 1] *= n81;
                        if (n73 < this.m - 1) {
                            for (int n83 = 0; n83 < this.m; ++n83) {
                                final double n84 = this.U[n83][n73];
                                final double n85 = this.U[n83][n73 + 1];
                                this.U[n83][n73 + 1] = -n82 * this.U[n83][n73] + this.U[n83][n73 + 1] * n81;
                                this.U[n83][n73] = n84 * n81 + n85 * n82;
                            }
                        }
                    }
                    array[n36 - 2] = n71;
                    final int n86 = n35 + 1;
                    n45 = n36;
                    n46 = n86;
                    break;
                }
                case 4: {
                    if (this.s[n43] <= 0.0) {
                        final double[] s = this.s;
                        double n87;
                        if (this.s[n43] < 0.0) {
                            n87 = -this.s[n43];
                        }
                        else {
                            n87 = 0.0;
                        }
                        s[n43] = n87;
                        for (int n88 = 0; n88 <= n34; ++n88) {
                            this.V[n88][n43] = -this.V[n88][n43];
                        }
                    }
                    for (int n89 = n43; n89 < n34 && this.s[n89] < this.s[n89 + 1]; ++n89) {
                        final double n90 = this.s[n89];
                        this.s[n89] = this.s[n89 + 1];
                        this.s[n89 + 1] = n90;
                        if (n89 < this.n - 1) {
                            for (int n91 = 0; n91 < this.n; ++n91) {
                                final double n92 = this.V[n91][n89 + 1];
                                this.V[n91][n89 + 1] = this.V[n91][n89];
                                this.V[n91][n89] = n92;
                            }
                        }
                        if (n89 < this.m - 1) {
                            for (int n93 = 0; n93 < this.m; ++n93) {
                                final double n94 = this.U[n93][n89 + 1];
                                this.U[n93][n89 + 1] = this.U[n93][n89];
                                this.U[n93][n89] = n94;
                            }
                        }
                    }
                    final int n95 = 0;
                    final int n96 = n36 - 1;
                    n46 = n95;
                    n45 = n96;
                    break;
                }
            }
            n97 = n45;
            n35 = n46;
        }
    }
    
    public double cond() {
        return this.s[0] / this.s[Math.min(this.m, this.n) - 1];
    }
    
    public Matrix getS() {
        final Matrix matrix = new Matrix(this.n, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = 0L;
            }
            array[i][i] = this.s[i];
        }
        return matrix;
    }
    
    public double[] getSingularValues() {
        return this.s;
    }
    
    public Matrix getU() {
        return new Matrix(this.U, this.m, Math.min(this.m + 1, this.n));
    }
    
    public Matrix getV() {
        return new Matrix(this.V, this.n, this.n);
    }
    
    public double norm2() {
        return this.s[0];
    }
    
    public int rank() {
        int i = 0;
        final double pow = Math.pow(2.0, -52.0);
        final double n = Math.max(this.m, this.n);
        final double n2 = this.s[0];
        int n3 = 0;
        while (i < this.s.length) {
            int n4 = n3;
            if (this.s[i] > pow * (n * n2)) {
                n4 = n3 + 1;
            }
            ++i;
            n3 = n4;
        }
        return n3;
    }
}

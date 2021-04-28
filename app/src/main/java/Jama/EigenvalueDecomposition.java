package Jama;

import java.io.Serializable;
import java.lang.reflect.Array;

import Jama.util.Maths;

public class EigenvalueDecomposition implements Serializable
{
    private static final long serialVersionUID = 1L;
    private double[][] H;
    private double[][] V;
    private transient double cdivi;
    private transient double cdivr;
    private double[] d;
    private double[] e;
    private boolean issymmetric;
    private int n;
    private double[] ort;
    
    public EigenvalueDecomposition(final Matrix matrix) {
        final double[][] array = matrix.getArray();
        this.n = matrix.getColumnDimension();
        this.V = (double[][])Array.newInstance(Double.TYPE, this.n, this.n);
        this.d = new double[this.n];
        this.e = new double[this.n];
        this.issymmetric = true;
        for (int n = 0; n < this.n & this.issymmetric; ++n) {
            for (int n2 = 0; n2 < this.n & this.issymmetric; ++n2) {
                this.issymmetric = (array[n2][n] == array[n][n2]);
            }
        }
        if (this.issymmetric) {
            for (int i = 0; i < this.n; ++i) {
                for (int j = 0; j < this.n; ++j) {
                    this.V[i][j] = array[i][j];
                }
            }
            this.tred2();
            this.tql2();
            return;
        }
        this.H = (double[][])Array.newInstance(Double.TYPE, this.n, this.n);
        this.ort = new double[this.n];
        for (int k = 0; k < this.n; ++k) {
            for (int l = 0; l < this.n; ++l) {
                this.H[l][k] = array[l][k];
            }
        }
        this.orthes();
        this.hqr2();
    }
    
    private void cdiv(final double n, final double n2, double n3, final double n4) {
        if (Math.abs(n3) > Math.abs(n4)) {
            final double n5 = n4 / n3;
            n3 += n5 * n4;
            this.cdivr = (n5 * n2 + n) / n3;
            this.cdivi = (n2 - n5 * n) / n3;
            return;
        }
        final double n6 = n3 / n4;
        n3 = n6 * n3 + n4;
        this.cdivr = (n6 * n + n2) / n3;
        this.cdivi = (n6 * n2 - n) / n3;
    }
    
    private void hqr2() {
        final int n = this.n;
        final int n2 = n - 1;
        final int n3 = n - 1;
        final double pow = Math.pow(2.0, -52.0);
        double n4 = 0.0;
        double n5 = 0.0;
        double n6 = 0.0;
        double n7 = 0.0;
        double n8 = 0.0;
        double n9 = 0.0;
        double n10 = 0.0;
        for (int i = 0; i < n; ++i) {
            boolean b;
            if (i < 0) {
                b = true;
            }
            else {
                b = false;
            }
            boolean b2;
            if (i > n3) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            if (b2 | b) {
                this.d[i] = this.H[i][i];
                this.e[i] = 0.0;
            }
            for (int j = Math.max(i - 1, 0); j < n; ++j) {
                n10 += Math.abs(this.H[i][j]);
            }
        }
        int n11 = 0;
        int n12 = 0;
        double n17 = 0.0;
        double n18 = 0.0;
        double n109=0.0;
        double n110=0.0;
    Label_1406_Outer:
        for (int k = n2; k >= 0; k = n12, n7 = n18, n6 = n17, n5 = n109, n4 = n110) {
            int l;
            for (l = k; l > 0; --l) {
                if ((n8 = Math.abs(this.H[l - 1][l - 1]) + Math.abs(this.H[l][l])) == 0.0) {
                    n8 = n10;
                }
                if (Math.abs(this.H[l][l - 1]) < pow * n8) {
                    break;
                }
            }
            int n13 = 0;
            double n15 = 0.0;
            double n16 = 0.0;
            Label_0350: {
                if (l == k) {
                    this.H[k][k] += n4;
                    this.d[k] = this.H[k][k];
                    this.e[k] = 0.0;
                    n12 = k - 1;
                    n13 = 0;
                    final double n14 = n6;
                    n15 = n5;
                    n16 = n4;
                    n17 = n14;
                    n18 = n7;
                }
                else {
                    if (l != k - 1) {
                        final double n19 = this.H[k][k];
                        double n20 = 0.0;
                        double n21 = 0.0;
                        if (l < k) {
                            n20 = this.H[k - 1][k - 1];
                            n21 = this.H[k][k - 1] * this.H[k - 1][k];
                        }
                        double n22;
                        double n24;
                        double n25;
                        double n26;
                        double n27;
                        if (n11 == 10) {
                            n22 = n4 + n19;
                            for (int n23 = 0; n23 <= k; ++n23) {
                                final double[] array = this.H[n23];
                                array[n23] -= n19;
                            }
                            n24 = Math.abs(this.H[k][k - 1]) + Math.abs(this.H[k - 1][k - 2]);
                            n25 = 0.75 * n24;
                            n26 = -0.4375 * n24 * n24;
                            n27 = n25;
                        }
                        else {
                            final double n28 = n4;
                            n25 = n20;
                            n24 = n8;
                            n27 = n19;
                            n26 = n21;
                            n22 = n28;
                        }
                        while (true) {
                            Label_4449: {
                                if (n11 != 30) {
                                    break Label_4449;
                                }
                                final double n29 = (n25 - n27) / 2.0;
                                final double n30 = n24 = n29 * n29 + n26;
                                if (n30 <= 0.0) {
                                    break Label_4449;
                                }
                                double sqrt = Math.sqrt(n30);
                                if (n25 < n27) {
                                    sqrt = -sqrt;
                                }
                                final double n31 = n27 - n26 / (sqrt + (n25 - n27) / 2.0);
                                for (int n32 = 0; n32 <= k; ++n32) {
                                    final double[] array2 = this.H[n32];
                                    array2[n32] -= n31;
                                }
                                final double n33 = 0.964;
                                double n34 = n31;
                                n22 += n31;
                                n27 = 0.964;
                                final double n35 = 0.964;
                                int n36 = k - 2;
                                double n37 = n7;
                                final double n38 = n9;
                                double n39 = n5;
                                double n40 = n6;
                                double n41 = n38;
                                while (true) {
                                    while (n36 >= l) {
                                        final double n42 = this.H[n36][n36];
                                        final double n43 = n27 - n42;
                                        final double n44 = n33 - n42;
                                        final double n45 = (n43 * n44 - n35) / this.H[n36 + 1][n36] + this.H[n36][n36 + 1];
                                        final double n46 = this.H[n36 + 1][n36 + 1] - n42 - n43 - n44;
                                        final double n47 = this.H[n36 + 2][n36 + 1];
                                        n34 = Math.abs(n45) + Math.abs(n46) + Math.abs(n47);
                                        n39 = n45 / n34;
                                        n40 = n46 / n34;
                                        final double n48 = n47 / n34;
                                        double n51;
                                        double n52;
                                        double n53;
                                        if (n36 == l) {
                                            final double n49 = n42;
                                            n37 = n48;
                                            final double n50 = n34;
                                            n15 = n39;
                                            n51 = n40;
                                            n52 = n50;
                                            n53 = n49;
                                        }
                                        else {
                                            if (Math.abs(this.H[n36][n36 - 1]) * (Math.abs(n40) + Math.abs(n48)) >= Math.abs(n39) * (Math.abs(this.H[n36 - 1][n36 - 1]) + Math.abs(n42) + Math.abs(this.H[n36 + 1][n36 + 1])) * pow) {
                                                --n36;
                                                n41 = n42;
                                                n37 = n48;
                                                continue Label_1406_Outer;
                                            }
                                            final double n54 = n42;
                                            n37 = n48;
                                            n15 = n39;
                                            final double n55 = n40;
                                            n53 = n54;
                                            n52 = n34;
                                            n51 = n55;
                                        }
                                        for (int n56 = n36 + 2; n56 <= k; ++n56) {
                                            this.H[n56][n56 - 2] = 0L;
                                            if (n56 > n36 + 2) {
                                                this.H[n56][n56 - 3] = 0L;
                                            }
                                        }
                                        int n57 = n36;
                                        final double n58 = n37;
                                        double n59 = n51;
                                        double n60 = n58;
                                        double n61 = n27;
                                        while (n57 <= k - 1) {
                                            boolean b3;
                                            if (n57 != k - 1) {
                                                b3 = true;
                                            }
                                            else {
                                                b3 = false;
                                            }
                                            while (true) {
                                                Label_1981: {
                                                    if (n57 == n36) {
                                                        break Label_1981;
                                                    }
                                                    final double n62 = this.H[n57][n57 - 1];
                                                    n59 = this.H[n57 + 1][n57 - 1];
                                                    double n63;
                                                    if (b3) {
                                                        n63 = this.H[n57 + 2][n57 - 1];
                                                    }
                                                    else {
                                                        n63 = 0.0;
                                                    }
                                                    final double n64 = Math.abs(n62) + Math.abs(n59) + Math.abs(n63);
                                                    if (n64 != 0.0) {
                                                        n15 = n62 / n64;
                                                        n59 /= n64;
                                                        n60 = n63 / n64;
                                                        n61 = n64;
                                                        break Label_1981;
                                                    }
                                                    final double n65 = n63;
                                                    final double n66 = n52;
                                                    final double n67 = n64;
                                                    ++n57;
                                                    final double n68 = n65;
                                                    n15 = n62;
                                                    final double n69 = n66;
                                                    n61 = n67;
                                                    n60 = n68;
                                                    n52 = n69;
                                                    continue Label_1406_Outer;
                                                }
                                                double sqrt2;
                                                final double n70 = sqrt2 = Math.sqrt(n15 * n15 + n59 * n59 + n60 * n60);
                                                if (n15 < 0.0) {
                                                    sqrt2 = -n70;
                                                }
                                                if (sqrt2 != 0.0) {
                                                    if (n57 != n36) {
                                                        this.H[n57][n57 - 1] = n61 * -sqrt2;
                                                    }
                                                    else if (l != n36) {
                                                        this.H[n57][n57 - 1] = -this.H[n57][n57 - 1];
                                                    }
                                                    double n71 = n15 + sqrt2;
                                                    final double n72 = n71 / sqrt2;
                                                    final double n73 = n59 / sqrt2;
                                                    final double n74 = n60 / sqrt2;
                                                    final double n75 = n59 / n71;
                                                    final double n76 = n60 / n71;
                                                    for (int n77 = n57; n77 < n; ++n77) {
                                                        final double n78 = n71 = this.H[n57][n77] + this.H[n57 + 1][n77] * n75;
                                                        if (b3) {
                                                            n71 = n78 + this.H[n57 + 2][n77] * n76;
                                                            this.H[n57 + 2][n77] -= n71 * n74;
                                                        }
                                                        this.H[n57][n77] -= n71 * n72;
                                                        this.H[n57 + 1][n77] -= n71 * n73;
                                                    }
                                                    for (int n79 = 0; n79 <= Math.min(k, n57 + 3); ++n79) {
                                                        final double n80 = n71 = this.H[n79][n57] * n72 + this.H[n79][n57 + 1] * n73;
                                                        if (b3) {
                                                            n71 = n80 + this.H[n79][n57 + 2] * n74;
                                                            this.H[n79][n57 + 2] -= n71 * n76;
                                                        }
                                                        this.H[n79][n57] -= n71;
                                                        this.H[n79][n57 + 1] -= n71 * n75;
                                                    }
                                                    for (int n81 = 0; n81 <= n3; ++n81) {
                                                        final double n82 = n71 = this.V[n81][n57] * n72 + this.V[n81][n57 + 1] * n73;
                                                        if (b3) {
                                                            n71 = n82 + this.V[n81][n57 + 2] * n74;
                                                            this.V[n81][n57 + 2] -= n71 * n76;
                                                        }
                                                        this.V[n81][n57] -= n71;
                                                        this.V[n81][n57 + 1] -= n71 * n75;
                                                    }
                                                    final double n83 = n72;
                                                    final double n65 = n76;
                                                    final double n84 = sqrt2;
                                                    final double n62 = n71;
                                                    n53 = n74;
                                                    final double n85 = n75;
                                                    final double n67 = n83;
                                                    final double n66 = n84;
                                                    n59 = n85;
                                                    continue;
                                                }
                                                final double n86 = sqrt2;
                                                final double n87 = n15;
                                                final double n65 = n60;
                                                final double n67 = n61;
                                                final double n66 = n86;
                                                final double n62 = n87;
                                                continue;
                                            }
                                        }
                                        final int n88 = n11 + 1;
                                        n12 = k;
                                        n16 = n22;
                                        final double n89 = n59;
                                        n13 = n88;
                                        n8 = n52;
                                        n18 = n60;
                                        n17 = n89;
                                        n9 = n53;
                                        break Label_0350;
                                    }
                                    final double n90 = n41;
                                    n15 = n39;
                                    final double n91 = n40;
                                    double n53 = n90;
                                    double n52 = n34;
                                    double n51 = n91;
                                    continue;
                                }
                            }
                            final double n92 = n24;
                            final double n33 = n25;
                            final double n35 = n26;
                            double n34 = n92;
                            continue;
                        }
                    }
                    final double n93 = this.H[k][k - 1] * this.H[k - 1][k];
                    n15 = (this.H[k - 1][k - 1] - this.H[k][k]) / 2.0;
                    double n94 = n15 * n15 + n93;
                    double sqrt3 = Math.sqrt(Math.abs(n94));
                    this.H[k][k] += n4;
                    this.H[k - 1][k - 1] += n4;
                    final double n95 = this.H[k][k];
                    if (n94 >= 0.0) {
                        double n96;
                        if (n15 >= 0.0) {
                            n96 = sqrt3 + n15;
                        }
                        else {
                            n96 = n15 - sqrt3;
                        }
                        this.d[k - 1] = n95 + n96;
                        this.d[k] = this.d[k - 1];
                        if (n96 != 0.0) {
                            this.d[k] = n95 - n93 / n96;
                        }
                        this.e[k - 1] = 0.0;
                        this.e[k] = 0.0;
                        final double n97 = this.H[k][k - 1];
                        final double n98 = Math.abs(n97) + Math.abs(n96);
                        final double n99 = n97 / n98;
                        final double n100 = n96 / n98;
                        final double sqrt4 = Math.sqrt(n99 * n99 + n100 * n100);
                        final double n101 = n99 / sqrt4;
                        final double n102 = n100 / sqrt4;
                        for (int n103 = k - 1; n103 < n; ++n103) {
                            n96 = this.H[k - 1][n103];
                            this.H[k - 1][n103] = n102 * n96 + this.H[k][n103] * n101;
                            this.H[k][n103] = this.H[k][n103] * n102 - n101 * n96;
                        }
                        for (int n104 = 0; n104 <= k; ++n104) {
                            n96 = this.H[n104][k - 1];
                            this.H[n104][k - 1] = n102 * n96 + this.H[n104][k] * n101;
                            this.H[n104][k] = this.H[n104][k] * n102 - n101 * n96;
                        }
                        int n105 = 0;
                        while (true) {
                            sqrt3 = n96;
                            n8 = n98;
                            n7 = sqrt4;
                            n94 = n102;
                            n15 = n101;
                            if (n105 > n3) {
                                break;
                            }
                            n96 = this.V[n105][k - 1];
                            this.V[n105][k - 1] = n102 * n96 + this.V[n105][k] * n101;
                            this.V[n105][k] = this.V[n105][k] * n102 - n101 * n96;
                            ++n105;
                        }
                    }
                    else {
                        this.d[k - 1] = n95 + n15;
                        this.d[k] = n95 + n15;
                        this.e[k - 1] = sqrt3;
                        this.e[k] = -sqrt3;
                    }
                    final double n106 = n4;
                    final int n107 = 0;
                    final int n108 = k - 2;
                    n13 = n107;
                    n12 = n108;
                    n18 = n7;
                    n17 = n94;
                    n9 = sqrt3;
                    n16 = n106;
                }
            }
            n11 = n13;
            n109 = n15;
            n110 = n16;
        }
        if (n10 != 0.0) {
            int n111 = n - 1;
            final double n112 = n9;
            double n113 = n7;
            double n114 = n8;
            double n115 = n112;
            while (n111 >= 0) {
                final double n116 = this.d[n111];
                final double n117 = this.e[n111];
                double n123;
                double n124;
                if (n117 == 0.0) {
                    this.H[n111][n111] = 4607182418800017408L;
                    int n118 = n111 - 1;
                    int n119 = n111;
                    final double n120 = n115;
                    double n121 = n114;
                    double n122 = n120;
                    while (true) {
                        n123 = n122;
                        n124 = n121;
                        if (n118 < 0) {
                            break;
                        }
                        final double n125 = this.H[n118][n118] - n116;
                        n113 = 0.0;
                        double n127;
                        double n128;
                        for (int n126 = n119; n126 <= n111; ++n126, n113 += n127 * n128) {
                            n127 = this.H[n118][n126];
                            n128 = this.H[n126][n111];
                        }
                        double n129;
                        double n130;
                        if (this.e[n118] < 0.0) {
                            n129 = n113;
                            n130 = n125;
                        }
                        else {
                            if (this.e[n118] == 0.0) {
                                if (n125 != 0.0) {
                                    this.H[n118][n111] = -n113 / n125;
                                }
                                else {
                                    this.H[n118][n111] = -n113 / (pow * n10);
                                }
                            }
                            else {
                                final double n131 = this.H[n118][n118 + 1];
                                final double n132 = this.H[n118 + 1][n118];
                                final double n133 = (n131 * n121 - n122 * n113) / ((this.d[n118] - n116) * (this.d[n118] - n116) + this.e[n118] * this.e[n118]);
                                this.H[n118][n111] = n133;
                                if (Math.abs(n131) > Math.abs(n122)) {
                                    this.H[n118 + 1][n111] = (-n113 - n125 * n133) / n131;
                                }
                                else {
                                    this.H[n118 + 1][n111] = (-n121 - n132 * n133) / n122;
                                }
                            }
                            final double abs = Math.abs(this.H[n118][n111]);
                            if (pow * abs * abs > 1.0) {
                                for (int n134 = n118; n134 <= n111; ++n134) {
                                    this.H[n134][n111] /= abs;
                                }
                            }
                            n119 = n118;
                            final double n135 = n121;
                            n130 = n122;
                            n129 = n135;
                        }
                        --n118;
                        final double n136 = n129;
                        n122 = n130;
                        n121 = n136;
                    }
                }
                else {
                    double n137 = n115;
                    double n138 = n114;
                    double n139 = n113;
                    if (n117 < 0.0) {
                        int n140 = n111 - 1;
                        if (Math.abs(this.H[n111][n111 - 1]) > Math.abs(this.H[n111 - 1][n111])) {
                            this.H[n111 - 1][n111 - 1] = n117 / this.H[n111][n111 - 1];
                            this.H[n111 - 1][n111] = -(this.H[n111][n111] - n116) / this.H[n111][n111 - 1];
                        }
                        else {
                            this.cdiv(0.0, -this.H[n111 - 1][n111], this.H[n111 - 1][n111 - 1] - n116, n117);
                            this.H[n111 - 1][n111 - 1] = this.cdivr;
                            this.H[n111 - 1][n111] = this.cdivi;
                        }
                        this.H[n111][n111 - 1] = 0L;
                        this.H[n111][n111] = 4607182418800017408L;
                        int n141 = n111 - 2;
                        while (true) {
                            n137 = n115;
                            n138 = n114;
                            n139 = n113;
                            if (n141 < 0) {
                                break;
                            }
                            double n142 = 0.0;
                            double n143 = 0.0;
                            for (int n144 = n140; n144 <= n111; ++n144) {
                                n142 += this.H[n141][n144] * this.H[n144][n111 - 1];
                                n143 += this.H[n141][n144] * this.H[n144][n111];
                            }
                            final double n145 = this.H[n141][n141] - n116;
                            double n146;
                            double n147;
                            if (this.e[n141] < 0.0) {
                                n146 = n142;
                                n114 = n143;
                                n147 = n145;
                            }
                            else {
                                if (this.e[n141] == 0.0) {
                                    this.cdiv(-n142, -n143, n145, n117);
                                    this.H[n141][n111 - 1] = this.cdivr;
                                    this.H[n141][n111] = this.cdivi;
                                }
                                else {
                                    final double n148 = this.H[n141][n141 + 1];
                                    final double n149 = this.H[n141 + 1][n141];
                                    double n150 = (this.d[n141] - n116) * (this.d[n141] - n116) + this.e[n141] * this.e[n141] - n117 * n117;
                                    final double n151 = (this.d[n141] - n116) * 2.0 * n117;
                                    boolean b4;
                                    if (n150 == 0.0) {
                                        b4 = true;
                                    }
                                    else {
                                        b4 = false;
                                    }
                                    boolean b5;
                                    if (n151 == 0.0) {
                                        b5 = true;
                                    }
                                    else {
                                        b5 = false;
                                    }
                                    if (b5 & b4) {
                                        n150 = pow * n10 * (Math.abs(n145) + Math.abs(n117) + Math.abs(n148) + Math.abs(n149) + Math.abs(n115));
                                    }
                                    this.cdiv(n117 * n143 + (n148 * n113 - n115 * n142), n148 * n114 - n115 * n143 - n117 * n142, n150, n151);
                                    this.H[n141][n111 - 1] = this.cdivr;
                                    this.H[n141][n111] = this.cdivi;
                                    if (Math.abs(n148) > Math.abs(n115) + Math.abs(n117)) {
                                        this.H[n141 + 1][n111 - 1] = (-n142 - this.H[n141][n111 - 1] * n145 + this.H[n141][n111] * n117) / n148;
                                        this.H[n141 + 1][n111] = (-n143 - this.H[n141][n111] * n145 - this.H[n141][n111 - 1] * n117) / n148;
                                    }
                                    else {
                                        this.cdiv(-n113 - this.H[n141][n111 - 1] * n149, -n114 - this.H[n141][n111] * n149, n115, n117);
                                        this.H[n141 + 1][n111 - 1] = this.cdivr;
                                        this.H[n141 + 1][n111] = this.cdivi;
                                    }
                                }
                                final double max = Math.max(Math.abs(this.H[n141][n111 - 1]), Math.abs(this.H[n141][n111]));
                                if (pow * max * max > 1.0) {
                                    for (int n152 = n141; n152 <= n111; ++n152) {
                                        this.H[n152][n111 - 1] /= max;
                                        this.H[n152][n111] /= max;
                                    }
                                }
                                n140 = n141;
                                final double n153 = n115;
                                n146 = n113;
                                n147 = n153;
                            }
                            --n141;
                            final double n154 = n146;
                            n115 = n147;
                            n113 = n154;
                        }
                    }
                    n113 = n139;
                    n124 = n138;
                    n123 = n137;
                }
                --n111;
                n115 = n123;
                n114 = n124;
            }
            for (int n155 = 0; n155 < n; ++n155) {
                boolean b6;
                if (n155 < 0) {
                    b6 = true;
                }
                else {
                    b6 = false;
                }
                boolean b7;
                if (n155 > n3) {
                    b7 = true;
                }
                else {
                    b7 = false;
                }
                if (b7 | b6) {
                    for (int n156 = n155; n156 < n; ++n156) {
                        this.V[n155][n156] = this.H[n155][n156];
                    }
                }
            }
            for (int n157 = n - 1; n157 >= 0; --n157) {
                for (int n158 = 0; n158 <= n3; ++n158) {
                    double n159 = 0.0;
                    for (int n160 = 0; n160 <= Math.min(n157, n3); ++n160) {
                        n159 += this.V[n158][n160] * this.H[n160][n157];
                    }
                    this.V[n158][n157] = n159;
                }
            }
        }
    }
    
    private void orthes() {
        final int n = this.n - 1;
        for (int i = 1; i <= n - 1; ++i) {
            double n2 = 0.0;
            double abs;
            for (int j = i; j <= n; ++j, n2 += abs) {
                abs = Math.abs(this.H[j][i - 1]);
            }
            if (n2 != 0.0) {
                double n3 = 0.0;
                for (int k = n; k >= i; --k) {
                    this.ort[k] = this.H[k][i - 1] / n2;
                    n3 += this.ort[k] * this.ort[k];
                }
                double sqrt;
                final double n4 = sqrt = Math.sqrt(n3);
                if (this.ort[i] > 0.0) {
                    sqrt = -n4;
                }
                final double n5 = n3 - this.ort[i] * sqrt;
                this.ort[i] -= sqrt;
                for (int l = i; l < this.n; ++l) {
                    double n6 = 0.0;
                    for (int n7 = n; n7 >= i; --n7) {
                        n6 += this.ort[n7] * this.H[n7][l];
                    }
                    final double n8 = n6 / n5;
                    for (int n9 = i; n9 <= n; ++n9) {
                        final double[] array = this.H[n9];
                        array[l] -= this.ort[n9] * n8;
                    }
                }
                for (int n10 = 0; n10 <= n; ++n10) {
                    double n11 = 0.0;
                    for (int n12 = n; n12 >= i; --n12) {
                        n11 += this.ort[n12] * this.H[n10][n12];
                    }
                    final double n13 = n11 / n5;
                    for (int n14 = i; n14 <= n; ++n14) {
                        final double[] array2 = this.H[n10];
                        array2[n14] -= this.ort[n14] * n13;
                    }
                }
                this.ort[i] *= n2;
                this.H[i][i - 1] = sqrt * n2;
            }
        }
        for (int n15 = 0; n15 < this.n; ++n15) {
            for (int n16 = 0; n16 < this.n; ++n16) {
                final double[] array3 = this.V[n15];
                long n17;
                if (n15 == n16) {
                    n17 = 4607182418800017408L;
                }
                else {
                    n17 = 0L;
                }
                array3[n16] = n17;
            }
        }
        for (int n18 = n - 1; n18 >= 1; --n18) {
            if (this.H[n18][n18 - 1] != 0.0) {
                for (int n19 = n18 + 1; n19 <= n; ++n19) {
                    this.ort[n19] = this.H[n19][n18 - 1];
                }
                for (int n20 = n18; n20 <= n; ++n20) {
                    double n21 = 0.0;
                    for (int n22 = n18; n22 <= n; ++n22) {
                        n21 += this.ort[n22] * this.V[n22][n20];
                    }
                    final double n23 = n21 / this.ort[n18] / this.H[n18][n18 - 1];
                    for (int n24 = n18; n24 <= n; ++n24) {
                        final double[] array4 = this.V[n24];
                        array4[n20] += this.ort[n24] * n23;
                    }
                }
            }
        }
    }
    
    private void tql2() {
        for (int i = 1; i < this.n; ++i) {
            this.e[i - 1] = this.e[i];
        }
        this.e[this.n - 1] = 0.0;
        double n = 0.0;
        double n2 = 0.0;
        final double pow = Math.pow(2.0, -52.0);
        double max;
        double n4;
        for (int j = 0; j < this.n; ++j, n2 = max, n = n4) {
            int n3;
            for (max = Math.max(n2, Math.abs(this.d[j]) + Math.abs(this.e[j])), n3 = j; n3 < this.n && Math.abs(this.e[n3]) > pow * max; ++n3) {}
            n4 = n;
            if (n3 > j) {
                int n5 = 0;
                double n12;
                do {
                    final int n6 = n5 + 1;
                    final double n7 = this.d[j];
                    final double n8 = (this.d[j + 1] - n7) / (2.0 * this.e[j]);
                    double hypot;
                    final double n9 = hypot = Maths.hypot(n8, 1.0);
                    if (n8 < 0.0) {
                        hypot = -n9;
                    }
                    this.d[j] = this.e[j] / (n8 + hypot);
                    this.d[j + 1] = (hypot + n8) * this.e[j];
                    final double n10 = this.d[j + 1];
                    final double n11 = n7 - this.d[j];
                    for (int k = j + 2; k < this.n; ++k) {
                        final double[] d = this.d;
                        d[k] -= n11;
                    }
                    n12 = n + n11;
                    double n13 = this.d[n3];
                    final double n14 = this.e[j + 1];
                    double n15 = 0.0;
                    double n16 = 1.0;
                    double n17 = 1.0;
                    double n18 = 1.0;
                    double n19 = 0.0;
                    double n21;
                    double n22;
                    double n23;
                    double n26;
                    for (int l = n3 - 1; l >= j; --l, n26 = n21, n19 = n15, n15 = n26, n18 = n16, n16 = n17, n17 = n22, n13 = n23) {
                        final double n20 = n17 * this.e[l];
                        final double hypot2 = Maths.hypot(n13, this.e[l]);
                        this.e[l + 1] = n15 * hypot2;
                        n21 = this.e[l] / hypot2;
                        n22 = n13 / hypot2;
                        n23 = this.d[l] * n22 - n21 * n20;
                        this.d[l + 1] = (n20 * n22 + this.d[l] * n21) * n21 + n17 * n13;
                        for (int n24 = 0; n24 < this.n; ++n24) {
                            final double n25 = this.V[n24][l + 1];
                            this.V[n24][l + 1] = this.V[n24][l] * n21 + n22 * n25;
                            this.V[n24][l] = this.V[n24][l] * n22 - n25 * n21;
                        }
                    }
                    final double n27 = -n15 * n19 * n18 * n14 * this.e[j] / n10;
                    this.e[j] = n15 * n27;
                    this.d[j] = n27 * n17;
                    n5 = n6;
                    n = n12;
                } while (Math.abs(this.e[j]) > pow * max);
                n4 = n12;
            }
            this.d[j] += n4;
            this.e[j] = 0.0;
        }
        for (int n28 = 0; n28 < this.n - 1; ++n28) {
            double n29 = this.d[n28];
            int n30 = n28 + 1;
            int n31 = n28;
            while (n30 < this.n) {
                double n32 = n29;
                if (this.d[n30] < n29) {
                    n32 = this.d[n30];
                    n31 = n30;
                }
                ++n30;
                n29 = n32;
            }
            if (n31 != n28) {
                this.d[n31] = this.d[n28];
                this.d[n28] = n29;
                for (int n33 = 0; n33 < this.n; ++n33) {
                    final double n34 = this.V[n33][n28];
                    this.V[n33][n28] = this.V[n33][n31];
                    this.V[n33][n31] = n34;
                }
            }
        }
    }
    
    private void tred2() {
        for (int i = 0; i < this.n; ++i) {
            this.d[i] = this.V[this.n - 1][i];
        }
        for (int j = this.n - 1; j > 0; --j) {
            double n = 0.0;
            final double n2 = 0.0;
            for (int k = 0; k < j; ++k) {
                n += Math.abs(this.d[k]);
            }
            double n4;
            if (n == 0.0) {
                this.e[j] = this.d[j - 1];
                int n3 = 0;
                while (true) {
                    n4 = n2;
                    if (n3 >= j) {
                        break;
                    }
                    this.d[n3] = this.V[j - 1][n3];
                    this.V[j][n3] = 0L;
                    this.V[n3][j] = 0L;
                    ++n3;
                }
            }
            else {
                double n5 = 0.0;
                for (int l = 0; l < j; ++l) {
                    final double[] d = this.d;
                    d[l] /= n;
                    n5 += this.d[l] * this.d[l];
                }
                final double n6 = this.d[j - 1];
                double sqrt;
                final double n7 = sqrt = Math.sqrt(n5);
                if (n6 > 0.0) {
                    sqrt = -n7;
                }
                this.e[j] = n * sqrt;
                final double n8 = n5 - n6 * sqrt;
                this.d[j - 1] = n6 - sqrt;
                for (int n9 = 0; n9 < j; ++n9) {
                    this.e[n9] = 0.0;
                }
                for (int n10 = 0; n10 < j; ++n10) {
                    final double n11 = this.d[n10];
                    this.V[n10][j] = n11;
                    double n12 = this.e[n10] + this.V[n10][n10] * n11;
                    for (int n13 = n10 + 1; n13 <= j - 1; ++n13) {
                        n12 += this.V[n13][n10] * this.d[n13];
                        final double[] e = this.e;
                        e[n13] += this.V[n13][n10] * n11;
                    }
                    this.e[n10] = n12;
                }
                double n14 = 0.0;
                for (int n15 = 0; n15 < j; ++n15) {
                    final double[] e2 = this.e;
                    e2[n15] /= n8;
                    n14 += this.e[n15] * this.d[n15];
                }
                final double n16 = n14 / (n8 + n8);
                for (int n17 = 0; n17 < j; ++n17) {
                    final double[] e3 = this.e;
                    e3[n17] -= this.d[n17] * n16;
                }
                for (int n18 = 0; n18 < j; ++n18) {
                    final double n19 = this.d[n18];
                    final double n20 = this.e[n18];
                    for (int n21 = n18; n21 <= j - 1; ++n21) {
                        final double[] array = this.V[n21];
                        array[n18] -= this.e[n21] * n19 + this.d[n21] * n20;
                    }
                    this.d[n18] = this.V[j - 1][n18];
                    this.V[j][n18] = 0L;
                }
                n4 = n8;
            }
            this.d[j] = n4;
        }
        for (int n22 = 0; n22 < this.n - 1; ++n22) {
            this.V[this.n - 1][n22] = this.V[n22][n22];
            this.V[n22][n22] = 4607182418800017408L;
            final double n23 = this.d[n22 + 1];
            if (n23 != 0.0) {
                for (int n24 = 0; n24 <= n22; ++n24) {
                    this.d[n24] = this.V[n24][n22 + 1] / n23;
                }
                for (int n25 = 0; n25 <= n22; ++n25) {
                    double n26 = 0.0;
                    for (int n27 = 0; n27 <= n22; ++n27) {
                        n26 += this.V[n27][n22 + 1] * this.V[n27][n25];
                    }
                    for (int n28 = 0; n28 <= n22; ++n28) {
                        final double[] array2 = this.V[n28];
                        array2[n25] -= this.d[n28] * n26;
                    }
                }
            }
            for (int n29 = 0; n29 <= n22; ++n29) {
                this.V[n29][n22 + 1] = 0L;
            }
        }
        for (int n30 = 0; n30 < this.n; ++n30) {
            this.d[n30] = this.V[this.n - 1][n30];
            this.V[this.n - 1][n30] = 0L;
        }
        this.V[this.n - 1][this.n - 1] = 4607182418800017408L;
        this.e[0] = 0.0;
    }
    
    public Matrix getD() {
        final Matrix matrix = new Matrix(this.n, this.n);
        final double[][] array = matrix.getArray();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                array[i][j] = 0L;
            }
            array[i][i] = this.d[i];
            if (this.e[i] > 0.0) {
                array[i][i + 1] = this.e[i];
            }
            else if (this.e[i] < 0.0) {
                array[i][i - 1] = this.e[i];
            }
        }
        return matrix;
    }
    
    public double[] getImagEigenvalues() {
        return this.e;
    }
    
    public double[] getRealEigenvalues() {
        return this.d;
    }
    
    public Matrix getV() {
        return new Matrix(this.V, this.n, this.n);
    }
}

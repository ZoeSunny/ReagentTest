package Jama.test;

import Jama.Matrix;

public class TestMatrix
{
    private static void check(final double n, final double n2) {
        final double pow = Math.pow(2.0, -52.0);
        boolean b;
        if (n == 0.0) {
            b = true;
        }
        else {
            b = false;
        }
        boolean b2;
        if (Math.abs(n2) < 10.0 * pow) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (!(b & b2)) {
            boolean b3;
            if (n2 == 0.0) {
                b3 = true;
            }
            else {
                b3 = false;
            }
            boolean b4;
            if (Math.abs(n) < 10.0 * pow) {
                b4 = true;
            }
            else {
                b4 = false;
            }
            if (!(b3 & b4) && Math.abs(n - n2) > pow * 10.0 * Math.max(Math.abs(n), Math.abs(n2))) {
                throw new RuntimeException("The difference x-y is too large: x = " + Double.toString(n) + "  y = " + Double.toString(n2));
            }
        }
    }
    
    private static void check(final Matrix matrix, final Matrix matrix2) {
        final boolean b = true;
        final double pow = Math.pow(2.0, -52.0);
        boolean b2;
        if (matrix.norm1() == 0.0) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        boolean b3;
        if (matrix2.norm1() < 10.0 * pow) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        if (!(b2 & b3)) {
            boolean b4;
            if (matrix2.norm1() == 0.0) {
                b4 = true;
            }
            else {
                b4 = false;
            }
            boolean b5;
            if (matrix.norm1() < 10.0 * pow) {
                b5 = b;
            }
            else {
                b5 = false;
            }
            if (!(b4 & b5) && matrix.minus(matrix2).norm1() > 1000.0 * pow * Math.max(matrix.norm1(), matrix2.norm1())) {
                throw new RuntimeException("The norm of (X-Y) is too large: " + Double.toString(matrix.minus(matrix2).norm1()));
            }
        }
    }
    
    private static void check(final double[] array, final double[] array2) {
        if (array.length == array2.length) {
            for (int i = 0; i < array.length; ++i) {
                check(array[i], array2[i]);
            }
            return;
        }
        throw new RuntimeException("Attempt to compare vectors of different lengths");
    }
    
    private static void check(final double[][] array, final double[][] array2) {
        check(new Matrix(array), new Matrix(array2));
    }
    
    public static void main(final String[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_3       
        //     2: bipush          12
        //     4: newarray        D
        //     6: astore          14
        //     8: aload           14
        //    10: dup            
        //    11: iconst_0       
        //    12: dconst_1       
        //    13: dastore        
        //    14: dup            
        //    15: iconst_1       
        //    16: ldc2_w          2.0
        //    19: dastore        
        //    20: dup            
        //    21: iconst_2       
        //    22: ldc2_w          3.0
        //    25: dastore        
        //    26: dup            
        //    27: iconst_3       
        //    28: ldc2_w          4.0
        //    31: dastore        
        //    32: dup            
        //    33: iconst_4       
        //    34: ldc2_w          5.0
        //    37: dastore        
        //    38: dup            
        //    39: iconst_5       
        //    40: ldc2_w          6.0
        //    43: dastore        
        //    44: dup            
        //    45: bipush          6
        //    47: ldc2_w          7.0
        //    50: dastore        
        //    51: dup            
        //    52: bipush          7
        //    54: ldc2_w          8.0
        //    57: dastore        
        //    58: dup            
        //    59: bipush          8
        //    61: ldc2_w          9.0
        //    64: dastore        
        //    65: dup            
        //    66: bipush          9
        //    68: ldc2_w          10.0
        //    71: dastore        
        //    72: dup            
        //    73: bipush          10
        //    75: ldc2_w          11.0
        //    78: dastore        
        //    79: dup            
        //    80: bipush          11
        //    82: ldc2_w          12.0
        //    85: dastore        
        //    86: pop            
        //    87: iconst_3       
        //    88: anewarray       [D
        //    91: astore          13
        //    93: aload           13
        //    95: iconst_0       
        //    96: iconst_4       
        //    97: newarray        D
        //    99: dup            
        //   100: iconst_0       
        //   101: dconst_1       
        //   102: dastore        
        //   103: dup            
        //   104: iconst_1       
        //   105: ldc2_w          4.0
        //   108: dastore        
        //   109: dup            
        //   110: iconst_2       
        //   111: ldc2_w          7.0
        //   114: dastore        
        //   115: dup            
        //   116: iconst_3       
        //   117: ldc2_w          10.0
        //   120: dastore        
        //   121: aastore        
        //   122: aload           13
        //   124: iconst_1       
        //   125: iconst_4       
        //   126: newarray        D
        //   128: dup            
        //   129: iconst_0       
        //   130: ldc2_w          2.0
        //   133: dastore        
        //   134: dup            
        //   135: iconst_1       
        //   136: ldc2_w          5.0
        //   139: dastore        
        //   140: dup            
        //   141: iconst_2       
        //   142: ldc2_w          8.0
        //   145: dastore        
        //   146: dup            
        //   147: iconst_3       
        //   148: ldc2_w          11.0
        //   151: dastore        
        //   152: aastore        
        //   153: aload           13
        //   155: iconst_2       
        //   156: iconst_4       
        //   157: newarray        D
        //   159: dup            
        //   160: iconst_0       
        //   161: ldc2_w          3.0
        //   164: dastore        
        //   165: dup            
        //   166: iconst_1       
        //   167: ldc2_w          6.0
        //   170: dastore        
        //   171: dup            
        //   172: iconst_2       
        //   173: ldc2_w          9.0
        //   176: dastore        
        //   177: dup            
        //   178: iconst_3       
        //   179: ldc2_w          12.0
        //   182: dastore        
        //   183: aastore        
        //   184: iconst_3       
        //   185: newarray        D
        //   187: dup            
        //   188: iconst_0       
        //   189: ldc2_w          4.0
        //   192: dastore        
        //   193: dup            
        //   194: iconst_1       
        //   195: ldc2_w          5.0
        //   198: dastore        
        //   199: dup            
        //   200: iconst_2       
        //   201: ldc2_w          6.0
        //   204: dastore        
        //   205: astore          19
        //   207: iconst_3       
        //   208: anewarray       [D
        //   211: astore          22
        //   213: aload           22
        //   215: iconst_0       
        //   216: iconst_3       
        //   217: newarray        D
        //   219: dup            
        //   220: iconst_0       
        //   221: dconst_1       
        //   222: dastore        
        //   223: dup            
        //   224: iconst_1       
        //   225: ldc2_w          4.0
        //   228: dastore        
        //   229: dup            
        //   230: iconst_2       
        //   231: ldc2_w          7.0
        //   234: dastore        
        //   235: aastore        
        //   236: aload           22
        //   238: iconst_1       
        //   239: iconst_4       
        //   240: newarray        D
        //   242: dup            
        //   243: iconst_0       
        //   244: ldc2_w          2.0
        //   247: dastore        
        //   248: dup            
        //   249: iconst_1       
        //   250: ldc2_w          5.0
        //   253: dastore        
        //   254: dup            
        //   255: iconst_2       
        //   256: ldc2_w          8.0
        //   259: dastore        
        //   260: dup            
        //   261: iconst_3       
        //   262: ldc2_w          11.0
        //   265: dastore        
        //   266: aastore        
        //   267: aload           22
        //   269: iconst_2       
        //   270: iconst_4       
        //   271: newarray        D
        //   273: dup            
        //   274: iconst_0       
        //   275: ldc2_w          3.0
        //   278: dastore        
        //   279: dup            
        //   280: iconst_1       
        //   281: ldc2_w          6.0
        //   284: dastore        
        //   285: dup            
        //   286: iconst_2       
        //   287: ldc2_w          9.0
        //   290: dastore        
        //   291: dup            
        //   292: iconst_3       
        //   293: ldc2_w          12.0
        //   296: dastore        
        //   297: aastore        
        //   298: iconst_4       
        //   299: newarray        D
        //   301: dup            
        //   302: iconst_0       
        //   303: dconst_0       
        //   304: dastore        
        //   305: dup            
        //   306: iconst_1       
        //   307: dconst_0       
        //   308: dastore        
        //   309: dup            
        //   310: iconst_2       
        //   311: dconst_1       
        //   312: dastore        
        //   313: dup            
        //   314: iconst_3       
        //   315: dconst_0       
        //   316: dastore        
        //   317: astore          18
        //   319: iconst_3       
        //   320: newarray        D
        //   322: dup            
        //   323: iconst_0       
        //   324: ldc2_w          166.0
        //   327: dastore        
        //   328: dup            
        //   329: iconst_1       
        //   330: ldc2_w          188.0
        //   333: dastore        
        //   334: dup            
        //   335: iconst_2       
        //   336: ldc2_w          210.0
        //   339: dastore        
        //   340: astore          15
        //   342: iconst_3       
        //   343: newarray        D
        //   345: dup            
        //   346: iconst_0       
        //   347: ldc2_w          188.0
        //   350: dastore        
        //   351: dup            
        //   352: iconst_1       
        //   353: ldc2_w          214.0
        //   356: dastore        
        //   357: dup            
        //   358: iconst_2       
        //   359: ldc2_w          240.0
        //   362: dastore        
        //   363: astore          16
        //   365: iconst_3       
        //   366: newarray        D
        //   368: dup            
        //   369: iconst_0       
        //   370: ldc2_w          210.0
        //   373: dastore        
        //   374: dup            
        //   375: iconst_1       
        //   376: ldc2_w          240.0
        //   379: dastore        
        //   380: dup            
        //   381: iconst_2       
        //   382: ldc2_w          270.0
        //   385: dastore        
        //   386: astore          17
        //   388: iconst_2       
        //   389: newarray        D
        //   391: dup            
        //   392: iconst_0       
        //   393: ldc2_w          7.0
        //   396: dastore        
        //   397: dup            
        //   398: iconst_1       
        //   399: ldc2_w          9.0
        //   402: dastore        
        //   403: astore          12
        //   405: iconst_5       
        //   406: newarray        D
        //   408: dup            
        //   409: iconst_0       
        //   410: dconst_0       
        //   411: dastore        
        //   412: dup            
        //   413: iconst_1       
        //   414: dconst_0       
        //   415: dastore        
        //   416: dup            
        //   417: iconst_2       
        //   418: dconst_0       
        //   419: dastore        
        //   420: dup            
        //   421: iconst_3       
        //   422: dconst_0       
        //   423: dastore        
        //   424: dup            
        //   425: iconst_4       
        //   426: dconst_0       
        //   427: dastore        
        //   428: astore          7
        //   430: iconst_5       
        //   431: newarray        D
        //   433: dup            
        //   434: iconst_0       
        //   435: dconst_0       
        //   436: dastore        
        //   437: dup            
        //   438: iconst_1       
        //   439: dconst_0       
        //   440: dastore        
        //   441: dup            
        //   442: iconst_2       
        //   443: dconst_0       
        //   444: dastore        
        //   445: dup            
        //   446: iconst_3       
        //   447: dconst_0       
        //   448: dastore        
        //   449: dup            
        //   450: iconst_4       
        //   451: dconst_1       
        //   452: dastore        
        //   453: astore          8
        //   455: iconst_5       
        //   456: newarray        D
        //   458: dup            
        //   459: iconst_0       
        //   460: dconst_0       
        //   461: dastore        
        //   462: dup            
        //   463: iconst_1       
        //   464: dconst_0       
        //   465: dastore        
        //   466: dup            
        //   467: iconst_2       
        //   468: dconst_0       
        //   469: dastore        
        //   470: dup            
        //   471: iconst_3       
        //   472: dconst_1       
        //   473: dastore        
        //   474: dup            
        //   475: iconst_4       
        //   476: dconst_0       
        //   477: dastore        
        //   478: astore          9
        //   480: iconst_5       
        //   481: newarray        D
        //   483: dup            
        //   484: iconst_0       
        //   485: dconst_1       
        //   486: dastore        
        //   487: dup            
        //   488: iconst_1       
        //   489: dconst_1       
        //   490: dastore        
        //   491: dup            
        //   492: iconst_2       
        //   493: dconst_0       
        //   494: dastore        
        //   495: dup            
        //   496: iconst_3       
        //   497: dconst_0       
        //   498: dastore        
        //   499: dup            
        //   500: iconst_4       
        //   501: dconst_1       
        //   502: dastore        
        //   503: astore          10
        //   505: iconst_5       
        //   506: newarray        D
        //   508: dup            
        //   509: iconst_0       
        //   510: dconst_1       
        //   511: dastore        
        //   512: dup            
        //   513: iconst_1       
        //   514: dconst_0       
        //   515: dastore        
        //   516: dup            
        //   517: iconst_2       
        //   518: dconst_1       
        //   519: dastore        
        //   520: dup            
        //   521: iconst_3       
        //   522: dconst_0       
        //   523: dastore        
        //   524: dup            
        //   525: iconst_4       
        //   526: dconst_1       
        //   527: dastore        
        //   528: astore          11
        //   530: iconst_2       
        //   531: newarray        I
        //   533: astore_0       
        //   534: aload_0        
        //   535: dup            
        //   536: iconst_0       
        //   537: iconst_1       
        //   538: iastore        
        //   539: dup            
        //   540: iconst_1       
        //   541: iconst_2       
        //   542: iastore        
        //   543: pop            
        //   544: iconst_2       
        //   545: newarray        I
        //   547: astore          20
        //   549: aload           20
        //   551: dup            
        //   552: iconst_0       
        //   553: iconst_1       
        //   554: iastore        
        //   555: dup            
        //   556: iconst_1       
        //   557: iconst_3       
        //   558: iastore        
        //   559: pop            
        //   560: iconst_3       
        //   561: newarray        I
        //   563: astore          6
        //   565: aload           6
        //   567: dup            
        //   568: iconst_0       
        //   569: iconst_1       
        //   570: iastore        
        //   571: dup            
        //   572: iconst_1       
        //   573: iconst_2       
        //   574: iastore        
        //   575: dup            
        //   576: iconst_2       
        //   577: iconst_3       
        //   578: iastore        
        //   579: pop            
        //   580: iconst_3       
        //   581: newarray        I
        //   583: astore          21
        //   585: aload           21
        //   587: dup            
        //   588: iconst_0       
        //   589: iconst_1       
        //   590: iastore        
        //   591: dup            
        //   592: iconst_1       
        //   593: iconst_2       
        //   594: iastore        
        //   595: dup            
        //   596: iconst_2       
        //   597: iconst_4       
        //   598: iastore        
        //   599: pop            
        //   600: ldc             "\nTesting constructors and constructor-like methods...\n"
        //   602: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //   605: new             LJama/Matrix;
        //   608: dup            
        //   609: aload           14
        //   611: iconst_5       
        //   612: invokespecial   Jama/Matrix.<init>:([DI)V
        //   615: pop            
        //   616: iconst_0       
        //   617: ldc             "Catch invalid length in packed constructor... "
        //   619: ldc             "exception not thrown for invalid input"
        //   621: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //   624: istore          4
        //   626: iload           4
        //   628: istore_3       
        //   629: new             LJama/Matrix;
        //   632: dup            
        //   633: aload           22
        //   635: invokespecial   Jama/Matrix.<init>:([[D)V
        //   638: iconst_0       
        //   639: iconst_4       
        //   640: invokevirtual   Jama/Matrix.get:(II)D
        //   643: pop2           
        //   644: aload           22
        //   646: invokestatic    Jama/Matrix.constructWithCopy:([[D)LJama/Matrix;
        //   649: iconst_0       
        //   650: iconst_4       
        //   651: invokevirtual   Jama/Matrix.get:(II)D
        //   654: pop2           
        //   655: new             LJama/Matrix;
        //   658: dup            
        //   659: aload           14
        //   661: iconst_3       
        //   662: invokespecial   Jama/Matrix.<init>:([DI)V
        //   665: astore          22
        //   667: new             LJama/Matrix;
        //   670: dup            
        //   671: aload           13
        //   673: invokespecial   Jama/Matrix.<init>:([[D)V
        //   676: astore          23
        //   678: aload           23
        //   680: iconst_0       
        //   681: iconst_0       
        //   682: invokevirtual   Jama/Matrix.get:(II)D
        //   685: dstore_1       
        //   686: aload           13
        //   688: iconst_0       
        //   689: aaload         
        //   690: iconst_0       
        //   691: lconst_0       
        //   692: lastore        
        //   693: aload           23
        //   695: aload           22
        //   697: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //   700: pop            
        //   701: aload           13
        //   703: iconst_0       
        //   704: aaload         
        //   705: iconst_0       
        //   706: dload_1        
        //   707: dastore        
        //   708: aload           13
        //   710: invokestatic    Jama/Matrix.constructWithCopy:([[D)LJama/Matrix;
        //   713: astore          23
        //   715: aload           23
        //   717: iconst_0       
        //   718: iconst_0       
        //   719: invokevirtual   Jama/Matrix.get:(II)D
        //   722: dstore_1       
        //   723: aload           13
        //   725: iconst_0       
        //   726: aaload         
        //   727: iconst_0       
        //   728: lconst_0       
        //   729: lastore        
        //   730: dload_1        
        //   731: aload           23
        //   733: iconst_0       
        //   734: iconst_0       
        //   735: invokevirtual   Jama/Matrix.get:(II)D
        //   738: dsub           
        //   739: dconst_0       
        //   740: dcmpl          
        //   741: ifeq            3968
        //   744: iload_3        
        //   745: ldc             "constructWithCopy... "
        //   747: ldc             "copy not effected... data visible outside"
        //   749: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //   752: istore_3       
        //   753: aload           13
        //   755: iconst_0       
        //   756: aaload         
        //   757: iconst_0       
        //   758: aload           14
        //   760: iconst_0       
        //   761: daload         
        //   762: dastore        
        //   763: new             LJama/Matrix;
        //   766: dup            
        //   767: iconst_3       
        //   768: anewarray       [D
        //   771: dup            
        //   772: iconst_0       
        //   773: iconst_4       
        //   774: newarray        D
        //   776: dup            
        //   777: iconst_0       
        //   778: dconst_1       
        //   779: dastore        
        //   780: dup            
        //   781: iconst_1       
        //   782: dconst_0       
        //   783: dastore        
        //   784: dup            
        //   785: iconst_2       
        //   786: dconst_0       
        //   787: dastore        
        //   788: dup            
        //   789: iconst_3       
        //   790: dconst_0       
        //   791: dastore        
        //   792: aastore        
        //   793: dup            
        //   794: iconst_1       
        //   795: iconst_4       
        //   796: newarray        D
        //   798: dup            
        //   799: iconst_0       
        //   800: dconst_0       
        //   801: dastore        
        //   802: dup            
        //   803: iconst_1       
        //   804: dconst_1       
        //   805: dastore        
        //   806: dup            
        //   807: iconst_2       
        //   808: dconst_0       
        //   809: dastore        
        //   810: dup            
        //   811: iconst_3       
        //   812: dconst_0       
        //   813: dastore        
        //   814: aastore        
        //   815: dup            
        //   816: iconst_2       
        //   817: aload           18
        //   819: aastore        
        //   820: invokespecial   Jama/Matrix.<init>:([[D)V
        //   823: astore          18
        //   825: aload           18
        //   827: iconst_3       
        //   828: iconst_4       
        //   829: invokestatic    Jama/Matrix.identity:(II)LJama/Matrix;
        //   832: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //   835: ldc             "identity... "
        //   837: ldc             ""
        //   839: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //   842: ldc             "\nTesting access methods...\n"
        //   844: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //   847: new             LJama/Matrix;
        //   850: dup            
        //   851: aload           13
        //   853: invokespecial   Jama/Matrix.<init>:([[D)V
        //   856: astore          18
        //   858: aload           18
        //   860: invokevirtual   Jama/Matrix.getRowDimension:()I
        //   863: iconst_3       
        //   864: if_icmpeq       3993
        //   867: iload_3        
        //   868: ldc             "getRowDimension... "
        //   870: ldc             ""
        //   872: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //   875: istore_3       
        //   876: aload           18
        //   878: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //   881: iconst_4       
        //   882: if_icmpeq       4003
        //   885: iload_3        
        //   886: ldc             "getColumnDimension... "
        //   888: ldc             ""
        //   890: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //   893: istore_3       
        //   894: new             LJama/Matrix;
        //   897: dup            
        //   898: aload           13
        //   900: invokespecial   Jama/Matrix.<init>:([[D)V
        //   903: astore          23
        //   905: aload           23
        //   907: invokevirtual   Jama/Matrix.getArray:()[[D
        //   910: aload           13
        //   912: if_acmpeq       4013
        //   915: iload_3        
        //   916: ldc             "getArray... "
        //   918: ldc             ""
        //   920: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //   923: istore_3       
        //   924: aload           23
        //   926: invokevirtual   Jama/Matrix.getArrayCopy:()[[D
        //   929: astore          18
        //   931: iload_3        
        //   932: istore          4
        //   934: aload           18
        //   936: aload           13
        //   938: if_acmpne       951
        //   941: iload_3        
        //   942: ldc             "getArrayCopy... "
        //   944: ldc             "data not (deep) copied"
        //   946: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //   949: istore          4
        //   951: aload           18
        //   953: aload           13
        //   955: invokestatic    Jama/test/TestMatrix.check:([[D[[D)V
        //   958: ldc             "getArrayCopy... "
        //   960: ldc             ""
        //   962: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //   965: aload           23
        //   967: invokevirtual   Jama/Matrix.getColumnPackedCopy:()[D
        //   970: astore          18
        //   972: aload           18
        //   974: aload           14
        //   976: invokestatic    Jama/test/TestMatrix.check:([D[D)V
        //   979: ldc             "getColumnPackedCopy... "
        //   981: ldc             ""
        //   983: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //   986: iload           4
        //   988: istore_3       
        //   989: aload           23
        //   991: invokevirtual   Jama/Matrix.getRowPackedCopy:()[D
        //   994: astore          18
        //   996: aload           18
        //   998: bipush          12
        //  1000: newarray        D
        //  1002: dup            
        //  1003: iconst_0       
        //  1004: dconst_1       
        //  1005: dastore        
        //  1006: dup            
        //  1007: iconst_1       
        //  1008: ldc2_w          4.0
        //  1011: dastore        
        //  1012: dup            
        //  1013: iconst_2       
        //  1014: ldc2_w          7.0
        //  1017: dastore        
        //  1018: dup            
        //  1019: iconst_3       
        //  1020: ldc2_w          10.0
        //  1023: dastore        
        //  1024: dup            
        //  1025: iconst_4       
        //  1026: ldc2_w          2.0
        //  1029: dastore        
        //  1030: dup            
        //  1031: iconst_5       
        //  1032: ldc2_w          5.0
        //  1035: dastore        
        //  1036: dup            
        //  1037: bipush          6
        //  1039: ldc2_w          8.0
        //  1042: dastore        
        //  1043: dup            
        //  1044: bipush          7
        //  1046: ldc2_w          11.0
        //  1049: dastore        
        //  1050: dup            
        //  1051: bipush          8
        //  1053: ldc2_w          3.0
        //  1056: dastore        
        //  1057: dup            
        //  1058: bipush          9
        //  1060: ldc2_w          6.0
        //  1063: dastore        
        //  1064: dup            
        //  1065: bipush          10
        //  1067: ldc2_w          9.0
        //  1070: dastore        
        //  1071: dup            
        //  1072: bipush          11
        //  1074: ldc2_w          12.0
        //  1077: dastore        
        //  1078: invokestatic    Jama/test/TestMatrix.check:([D[D)V
        //  1081: ldc             "getRowPackedCopy... "
        //  1083: ldc             ""
        //  1085: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1088: aload           23
        //  1090: aload           23
        //  1092: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1095: aload           23
        //  1097: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  1100: iconst_1       
        //  1101: isub           
        //  1102: invokevirtual   Jama/Matrix.get:(II)D
        //  1105: pop2           
        //  1106: iload_3        
        //  1107: ldc             "get(int,int)... "
        //  1109: ldc             "OutOfBoundsException expected but not thrown"
        //  1111: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1114: istore          4
        //  1116: iload           4
        //  1118: istore_3       
        //  1119: aload           23
        //  1121: aload           23
        //  1123: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1126: iconst_1       
        //  1127: isub           
        //  1128: aload           23
        //  1130: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  1133: iconst_1       
        //  1134: isub           
        //  1135: invokevirtual   Jama/Matrix.get:(II)D
        //  1138: aload           13
        //  1140: aload           23
        //  1142: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1145: iconst_1       
        //  1146: isub           
        //  1147: aaload         
        //  1148: aload           23
        //  1150: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  1153: iconst_1       
        //  1154: isub           
        //  1155: daload         
        //  1156: dcmpl          
        //  1157: ifeq            4134
        //  1160: iload_3        
        //  1161: ldc             "get(int,int)... "
        //  1163: ldc             "Matrix entry (i,j) not successfully retreived"
        //  1165: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1168: istore          4
        //  1170: iload           4
        //  1172: istore_3       
        //  1173: new             LJama/Matrix;
        //  1176: dup            
        //  1177: iconst_2       
        //  1178: anewarray       [D
        //  1181: dup            
        //  1182: iconst_0       
        //  1183: iconst_3       
        //  1184: newarray        D
        //  1186: dup            
        //  1187: iconst_0       
        //  1188: ldc2_w          5.0
        //  1191: dastore        
        //  1192: dup            
        //  1193: iconst_1       
        //  1194: ldc2_w          8.0
        //  1197: dastore        
        //  1198: dup            
        //  1199: iconst_2       
        //  1200: ldc2_w          11.0
        //  1203: dastore        
        //  1204: aastore        
        //  1205: dup            
        //  1206: iconst_1       
        //  1207: iconst_3       
        //  1208: newarray        D
        //  1210: dup            
        //  1211: iconst_0       
        //  1212: ldc2_w          6.0
        //  1215: dastore        
        //  1216: dup            
        //  1217: iconst_1       
        //  1218: ldc2_w          9.0
        //  1221: dastore        
        //  1222: dup            
        //  1223: iconst_2       
        //  1224: ldc2_w          12.0
        //  1227: dastore        
        //  1228: aastore        
        //  1229: invokespecial   Jama/Matrix.<init>:([[D)V
        //  1232: astore          18
        //  1234: aload           23
        //  1236: iconst_1       
        //  1237: aload           23
        //  1239: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1242: iconst_2       
        //  1243: iadd           
        //  1244: iconst_1       
        //  1245: iadd           
        //  1246: iconst_1       
        //  1247: iconst_3       
        //  1248: invokevirtual   Jama/Matrix.getMatrix:(IIII)LJama/Matrix;
        //  1251: pop            
        //  1252: iload_3        
        //  1253: ldc             "getMatrix(int,int,int,int)... "
        //  1255: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  1257: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1260: istore          4
        //  1262: iload           4
        //  1264: istore_3       
        //  1265: aload           23
        //  1267: iconst_1       
        //  1268: iconst_2       
        //  1269: iconst_1       
        //  1270: iconst_3       
        //  1271: invokevirtual   Jama/Matrix.getMatrix:(IIII)LJama/Matrix;
        //  1274: astore          24
        //  1276: aload           18
        //  1278: aload           24
        //  1280: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  1283: ldc             "getMatrix(int,int,int,int)... "
        //  1285: ldc             ""
        //  1287: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1290: aload           23
        //  1292: iconst_1       
        //  1293: iconst_2       
        //  1294: aload           21
        //  1296: invokevirtual   Jama/Matrix.getMatrix:(II[I)LJama/Matrix;
        //  1299: pop            
        //  1300: iload_3        
        //  1301: ldc             "getMatrix(int,int,int[])... "
        //  1303: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  1305: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1308: istore          4
        //  1310: iload           4
        //  1312: istore_3       
        //  1313: aload           23
        //  1315: iconst_1       
        //  1316: iconst_2       
        //  1317: aload           6
        //  1319: invokevirtual   Jama/Matrix.getMatrix:(II[I)LJama/Matrix;
        //  1322: astore          24
        //  1324: aload           18
        //  1326: aload           24
        //  1328: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  1331: ldc             "getMatrix(int,int,int[])... "
        //  1333: ldc             ""
        //  1335: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1338: aload           23
        //  1340: aload           20
        //  1342: iconst_1       
        //  1343: iconst_3       
        //  1344: invokevirtual   Jama/Matrix.getMatrix:([III)LJama/Matrix;
        //  1347: pop            
        //  1348: iload_3        
        //  1349: ldc             "getMatrix(int[],int,int)... "
        //  1351: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  1353: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1356: istore          4
        //  1358: iload           4
        //  1360: istore_3       
        //  1361: aload           23
        //  1363: aload_0        
        //  1364: iconst_1       
        //  1365: iconst_3       
        //  1366: invokevirtual   Jama/Matrix.getMatrix:([III)LJama/Matrix;
        //  1369: astore          24
        //  1371: aload           18
        //  1373: aload           24
        //  1375: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  1378: ldc             "getMatrix(int[],int,int)... "
        //  1380: ldc             ""
        //  1382: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1385: aload           23
        //  1387: aload           20
        //  1389: aload           6
        //  1391: invokevirtual   Jama/Matrix.getMatrix:([I[I)LJama/Matrix;
        //  1394: pop            
        //  1395: iload_3        
        //  1396: ldc             "getMatrix(int[],int[])... "
        //  1398: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  1400: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1403: istore          4
        //  1405: iload           4
        //  1407: istore_3       
        //  1408: aload           23
        //  1410: aload_0        
        //  1411: aload           6
        //  1413: invokevirtual   Jama/Matrix.getMatrix:([I[I)LJama/Matrix;
        //  1416: astore          24
        //  1418: aload           18
        //  1420: aload           24
        //  1422: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  1425: ldc             "getMatrix(int[],int[])... "
        //  1427: ldc             ""
        //  1429: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1432: aload           23
        //  1434: aload           23
        //  1436: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1439: aload           23
        //  1441: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  1444: iconst_1       
        //  1445: isub           
        //  1446: dconst_0       
        //  1447: invokevirtual   Jama/Matrix.set:(IID)V
        //  1450: iload_3        
        //  1451: ldc             "set(int,int,double)... "
        //  1453: ldc             "OutOfBoundsException expected but not thrown"
        //  1455: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1458: istore          4
        //  1460: iload           4
        //  1462: istore_3       
        //  1463: aload           23
        //  1465: iconst_1       
        //  1466: iconst_1       
        //  1467: dconst_0       
        //  1468: invokevirtual   Jama/Matrix.set:(IID)V
        //  1471: aload           23
        //  1473: iconst_1       
        //  1474: iconst_1       
        //  1475: invokevirtual   Jama/Matrix.get:(II)D
        //  1478: dstore_1       
        //  1479: dload_1        
        //  1480: dconst_0       
        //  1481: invokestatic    Jama/test/TestMatrix.check:(DD)V
        //  1484: ldc             "set(int,int,double)... "
        //  1486: ldc             ""
        //  1488: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1491: new             LJama/Matrix;
        //  1494: dup            
        //  1495: iconst_2       
        //  1496: iconst_3       
        //  1497: dconst_0       
        //  1498: invokespecial   Jama/Matrix.<init>:(IID)V
        //  1501: astore          24
        //  1503: aload           23
        //  1505: iconst_1       
        //  1506: aload           23
        //  1508: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1511: iconst_2       
        //  1512: iadd           
        //  1513: iconst_1       
        //  1514: iadd           
        //  1515: iconst_1       
        //  1516: iconst_3       
        //  1517: aload           24
        //  1519: invokevirtual   Jama/Matrix.setMatrix:(IIIILJama/Matrix;)V
        //  1522: iload_3        
        //  1523: ldc             "setMatrix(int,int,int,int,Matrix)... "
        //  1525: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  1527: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1530: istore          4
        //  1532: iload           4
        //  1534: istore_3       
        //  1535: aload           23
        //  1537: iconst_1       
        //  1538: iconst_2       
        //  1539: iconst_1       
        //  1540: iconst_3       
        //  1541: aload           24
        //  1543: invokevirtual   Jama/Matrix.setMatrix:(IIIILJama/Matrix;)V
        //  1546: aload           24
        //  1548: aload           23
        //  1550: iconst_1       
        //  1551: iconst_2       
        //  1552: iconst_1       
        //  1553: iconst_3       
        //  1554: invokevirtual   Jama/Matrix.getMatrix:(IIII)LJama/Matrix;
        //  1557: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  1560: aload           24
        //  1562: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  1565: ldc             "setMatrix(int,int,int,int,Matrix)... "
        //  1567: ldc             ""
        //  1569: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1572: aload           23
        //  1574: iconst_1       
        //  1575: iconst_2       
        //  1576: iconst_1       
        //  1577: iconst_3       
        //  1578: aload           18
        //  1580: invokevirtual   Jama/Matrix.setMatrix:(IIIILJama/Matrix;)V
        //  1583: aload           23
        //  1585: iconst_1       
        //  1586: aload           23
        //  1588: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1591: iconst_2       
        //  1592: iadd           
        //  1593: iconst_1       
        //  1594: iadd           
        //  1595: aload           6
        //  1597: aload           24
        //  1599: invokevirtual   Jama/Matrix.setMatrix:(II[ILJama/Matrix;)V
        //  1602: iload_3        
        //  1603: ldc             "setMatrix(int,int,int[],Matrix)... "
        //  1605: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  1607: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1610: istore          4
        //  1612: iload           4
        //  1614: istore_3       
        //  1615: iload_3        
        //  1616: istore          4
        //  1618: aload           23
        //  1620: iconst_1       
        //  1621: iconst_2       
        //  1622: aload           6
        //  1624: aload           24
        //  1626: invokevirtual   Jama/Matrix.setMatrix:(II[ILJama/Matrix;)V
        //  1629: iload_3        
        //  1630: istore          4
        //  1632: aload           24
        //  1634: aload           23
        //  1636: iconst_1       
        //  1637: iconst_2       
        //  1638: aload           6
        //  1640: invokevirtual   Jama/Matrix.getMatrix:(II[I)LJama/Matrix;
        //  1643: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  1646: aload           24
        //  1648: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  1651: iload_3        
        //  1652: istore          4
        //  1654: ldc             "setMatrix(int,int,int[],Matrix)... "
        //  1656: ldc             ""
        //  1658: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1661: iload_3        
        //  1662: istore          4
        //  1664: aload           23
        //  1666: iconst_1       
        //  1667: iconst_2       
        //  1668: iconst_1       
        //  1669: iconst_3       
        //  1670: aload           18
        //  1672: invokevirtual   Jama/Matrix.setMatrix:(IIIILJama/Matrix;)V
        //  1675: aload           23
        //  1677: aload_0        
        //  1678: iconst_1       
        //  1679: aload           23
        //  1681: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  1684: iconst_3       
        //  1685: iadd           
        //  1686: iconst_1       
        //  1687: iadd           
        //  1688: aload           24
        //  1690: invokevirtual   Jama/Matrix.setMatrix:([IIILJama/Matrix;)V
        //  1693: iload_3        
        //  1694: ldc_w           "setMatrix(int[],int,int,Matrix)... "
        //  1697: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  1699: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1702: istore          4
        //  1704: iload           4
        //  1706: istore_3       
        //  1707: iload_3        
        //  1708: istore          4
        //  1710: aload           23
        //  1712: aload_0        
        //  1713: iconst_1       
        //  1714: iconst_3       
        //  1715: aload           24
        //  1717: invokevirtual   Jama/Matrix.setMatrix:([IIILJama/Matrix;)V
        //  1720: iload_3        
        //  1721: istore          4
        //  1723: aload           24
        //  1725: aload           23
        //  1727: aload_0        
        //  1728: iconst_1       
        //  1729: iconst_3       
        //  1730: invokevirtual   Jama/Matrix.getMatrix:([III)LJama/Matrix;
        //  1733: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  1736: aload           24
        //  1738: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  1741: iload_3        
        //  1742: istore          4
        //  1744: ldc_w           "setMatrix(int[],int,int,Matrix)... "
        //  1747: ldc             ""
        //  1749: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1752: iload_3        
        //  1753: istore          4
        //  1755: aload           23
        //  1757: iconst_1       
        //  1758: iconst_2       
        //  1759: iconst_1       
        //  1760: iconst_3       
        //  1761: aload           18
        //  1763: invokevirtual   Jama/Matrix.setMatrix:(IIIILJama/Matrix;)V
        //  1766: aload           23
        //  1768: aload_0        
        //  1769: aload           21
        //  1771: aload           24
        //  1773: invokevirtual   Jama/Matrix.setMatrix:([I[ILJama/Matrix;)V
        //  1776: iload_3        
        //  1777: ldc_w           "setMatrix(int[],int[],Matrix)... "
        //  1780: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  1782: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1785: istore          4
        //  1787: iload           4
        //  1789: istore_3       
        //  1790: aload           23
        //  1792: aload_0        
        //  1793: aload           6
        //  1795: aload           24
        //  1797: invokevirtual   Jama/Matrix.setMatrix:([I[ILJama/Matrix;)V
        //  1800: aload           24
        //  1802: aload           23
        //  1804: aload_0        
        //  1805: aload           6
        //  1807: invokevirtual   Jama/Matrix.getMatrix:([I[I)LJama/Matrix;
        //  1810: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  1813: aload           24
        //  1815: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  1818: ldc_w           "setMatrix(int[],int[],Matrix)... "
        //  1821: ldc             ""
        //  1823: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  1826: ldc_w           "\nTesting array-like methods...\n"
        //  1829: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //  1832: new             LJama/Matrix;
        //  1835: dup            
        //  1836: aload           14
        //  1838: iconst_4       
        //  1839: invokespecial   Jama/Matrix.<init>:([DI)V
        //  1842: astore          6
        //  1844: aload           22
        //  1846: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1849: aload           22
        //  1851: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  1854: invokestatic    Jama/Matrix.random:(II)LJama/Matrix;
        //  1857: astore          21
        //  1859: aload           6
        //  1861: astore_0       
        //  1862: aload           21
        //  1864: aload           6
        //  1866: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  1869: astore          6
        //  1871: aload           6
        //  1873: astore_0       
        //  1874: iload_3        
        //  1875: ldc_w           "minus conformance check... "
        //  1878: ldc_w           "nonconformance not raised"
        //  1881: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1884: istore          4
        //  1886: iload           4
        //  1888: istore_3       
        //  1889: aload           6
        //  1891: astore_0       
        //  1892: aload           21
        //  1894: aload           21
        //  1896: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  1899: invokevirtual   Jama/Matrix.norm1:()D
        //  1902: dconst_0       
        //  1903: dcmpl          
        //  1904: ifeq            5021
        //  1907: iload_3        
        //  1908: ldc_w           "minus... "
        //  1911: ldc_w           "(difference of identical Matrices is nonzero,\nSubsequent use of minus should be suspect)"
        //  1914: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1917: istore_3       
        //  1918: aload           21
        //  1920: invokevirtual   Jama/Matrix.copy:()LJama/Matrix;
        //  1923: astore          6
        //  1925: aload           6
        //  1927: aload           21
        //  1929: invokevirtual   Jama/Matrix.minusEquals:(LJama/Matrix;)LJama/Matrix;
        //  1932: pop            
        //  1933: new             LJama/Matrix;
        //  1936: dup            
        //  1937: aload           6
        //  1939: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  1942: aload           6
        //  1944: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  1947: invokespecial   Jama/Matrix.<init>:(II)V
        //  1950: astore          20
        //  1952: aload           6
        //  1954: aload_0        
        //  1955: invokevirtual   Jama/Matrix.minusEquals:(LJama/Matrix;)LJama/Matrix;
        //  1958: pop            
        //  1959: iload_3        
        //  1960: ldc_w           "minusEquals conformance check... "
        //  1963: ldc_w           "nonconformance not raised"
        //  1966: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1969: istore          4
        //  1971: iload           4
        //  1973: istore_3       
        //  1974: aload           6
        //  1976: aload           20
        //  1978: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  1981: invokevirtual   Jama/Matrix.norm1:()D
        //  1984: dconst_0       
        //  1985: dcmpl          
        //  1986: ifeq            5045
        //  1989: iload_3        
        //  1990: ldc_w           "minusEquals... "
        //  1993: ldc_w           "(difference of identical Matrices is nonzero,\nSubsequent use of minus should be suspect)"
        //  1996: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  1999: istore_3       
        //  2000: aload           21
        //  2002: invokevirtual   Jama/Matrix.copy:()LJama/Matrix;
        //  2005: astore          22
        //  2007: aload           22
        //  2009: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  2012: aload           22
        //  2014: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  2017: invokestatic    Jama/Matrix.random:(II)LJama/Matrix;
        //  2020: astore          23
        //  2022: aload           22
        //  2024: aload           23
        //  2026: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  2029: astore          24
        //  2031: aload_0        
        //  2032: astore          6
        //  2034: aload           22
        //  2036: aload_0        
        //  2037: invokevirtual   Jama/Matrix.plus:(LJama/Matrix;)LJama/Matrix;
        //  2040: astore_0       
        //  2041: aload_0        
        //  2042: astore          6
        //  2044: iload_3        
        //  2045: ldc_w           "plus conformance check... "
        //  2048: ldc_w           "nonconformance not raised"
        //  2051: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  2054: istore          4
        //  2056: iload           4
        //  2058: istore_3       
        //  2059: aload           24
        //  2061: aload           23
        //  2063: invokevirtual   Jama/Matrix.plus:(LJama/Matrix;)LJama/Matrix;
        //  2066: aload           22
        //  2068: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2071: ldc_w           "plus... "
        //  2074: ldc             ""
        //  2076: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2079: aload           22
        //  2081: aload           23
        //  2083: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  2086: astore          6
        //  2088: aload           6
        //  2090: aload           23
        //  2092: invokevirtual   Jama/Matrix.plusEquals:(LJama/Matrix;)LJama/Matrix;
        //  2095: pop            
        //  2096: aload           22
        //  2098: aload_0        
        //  2099: invokevirtual   Jama/Matrix.plusEquals:(LJama/Matrix;)LJama/Matrix;
        //  2102: pop            
        //  2103: iload_3        
        //  2104: ldc_w           "plusEquals conformance check... "
        //  2107: ldc_w           "nonconformance not raised"
        //  2110: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  2113: istore          4
        //  2115: iload           4
        //  2117: istore_3       
        //  2118: aload           6
        //  2120: aload           22
        //  2122: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2125: ldc_w           "plusEquals... "
        //  2128: ldc             ""
        //  2130: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2133: aload           21
        //  2135: invokevirtual   Jama/Matrix.uminus:()LJama/Matrix;
        //  2138: astore          6
        //  2140: aload           6
        //  2142: aload           21
        //  2144: invokevirtual   Jama/Matrix.plus:(LJama/Matrix;)LJama/Matrix;
        //  2147: aload           20
        //  2149: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2152: ldc_w           "uminus... "
        //  2155: ldc             ""
        //  2157: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2160: aload           21
        //  2162: invokevirtual   Jama/Matrix.copy:()LJama/Matrix;
        //  2165: astore          23
        //  2167: new             LJama/Matrix;
        //  2170: dup            
        //  2171: aload           23
        //  2173: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  2176: aload           23
        //  2178: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  2181: dconst_1       
        //  2182: invokespecial   Jama/Matrix.<init>:(IID)V
        //  2185: astore          22
        //  2187: aload           23
        //  2189: aload           21
        //  2191: invokevirtual   Jama/Matrix.arrayLeftDivide:(LJama/Matrix;)LJama/Matrix;
        //  2194: astore          24
        //  2196: aload_0        
        //  2197: astore          6
        //  2199: aload           23
        //  2201: aload_0        
        //  2202: invokevirtual   Jama/Matrix.arrayLeftDivide:(LJama/Matrix;)LJama/Matrix;
        //  2205: astore_0       
        //  2206: aload_0        
        //  2207: astore          6
        //  2209: iload_3        
        //  2210: ldc_w           "arrayLeftDivide conformance check... "
        //  2213: ldc_w           "nonconformance not raised"
        //  2216: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  2219: istore          4
        //  2221: iload           4
        //  2223: istore_3       
        //  2224: aload           24
        //  2226: aload           22
        //  2228: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2231: ldc_w           "arrayLeftDivide... "
        //  2234: ldc             ""
        //  2236: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2239: aload           23
        //  2241: aload_0        
        //  2242: invokevirtual   Jama/Matrix.arrayLeftDivideEquals:(LJama/Matrix;)LJama/Matrix;
        //  2245: pop            
        //  2246: iload_3        
        //  2247: ldc_w           "arrayLeftDivideEquals conformance check... "
        //  2250: ldc_w           "nonconformance not raised"
        //  2253: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  2256: istore          4
        //  2258: iload           4
        //  2260: istore_3       
        //  2261: aload           23
        //  2263: aload           21
        //  2265: invokevirtual   Jama/Matrix.arrayLeftDivideEquals:(LJama/Matrix;)LJama/Matrix;
        //  2268: pop            
        //  2269: aload           23
        //  2271: aload           22
        //  2273: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2276: ldc_w           "arrayLeftDivideEquals... "
        //  2279: ldc             ""
        //  2281: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2284: aload           21
        //  2286: invokevirtual   Jama/Matrix.copy:()LJama/Matrix;
        //  2289: astore          6
        //  2291: aload           6
        //  2293: aload_0        
        //  2294: invokevirtual   Jama/Matrix.arrayRightDivide:(LJama/Matrix;)LJama/Matrix;
        //  2297: pop            
        //  2298: iload_3        
        //  2299: ldc_w           "arrayRightDivide conformance check... "
        //  2302: ldc_w           "nonconformance not raised"
        //  2305: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  2308: istore          4
        //  2310: iload           4
        //  2312: istore_3       
        //  2313: aload           6
        //  2315: aload           21
        //  2317: invokevirtual   Jama/Matrix.arrayRightDivide:(LJama/Matrix;)LJama/Matrix;
        //  2320: astore          23
        //  2322: aload           23
        //  2324: aload           22
        //  2326: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2329: ldc_w           "arrayRightDivide... "
        //  2332: ldc             ""
        //  2334: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2337: aload           6
        //  2339: aload_0        
        //  2340: invokevirtual   Jama/Matrix.arrayRightDivideEquals:(LJama/Matrix;)LJama/Matrix;
        //  2343: pop            
        //  2344: iload_3        
        //  2345: ldc_w           "arrayRightDivideEquals conformance check... "
        //  2348: ldc_w           "nonconformance not raised"
        //  2351: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  2354: istore          4
        //  2356: iload           4
        //  2358: istore_3       
        //  2359: aload           6
        //  2361: aload           21
        //  2363: invokevirtual   Jama/Matrix.arrayRightDivideEquals:(LJama/Matrix;)LJama/Matrix;
        //  2366: pop            
        //  2367: aload           6
        //  2369: aload           22
        //  2371: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2374: ldc_w           "arrayRightDivideEquals... "
        //  2377: ldc             ""
        //  2379: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2382: aload           21
        //  2384: invokevirtual   Jama/Matrix.copy:()LJama/Matrix;
        //  2387: astore          22
        //  2389: aload           22
        //  2391: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  2394: aload           22
        //  2396: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  2399: invokestatic    Jama/Matrix.random:(II)LJama/Matrix;
        //  2402: astore          23
        //  2404: aload_0        
        //  2405: astore          6
        //  2407: aload           22
        //  2409: aload_0        
        //  2410: invokevirtual   Jama/Matrix.arrayTimes:(LJama/Matrix;)LJama/Matrix;
        //  2413: astore_0       
        //  2414: aload_0        
        //  2415: astore          6
        //  2417: iload_3        
        //  2418: ldc_w           "arrayTimes conformance check... "
        //  2421: ldc_w           "nonconformance not raised"
        //  2424: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  2427: istore          4
        //  2429: iload           4
        //  2431: istore_3       
        //  2432: aload_0        
        //  2433: astore          6
        //  2435: aload           22
        //  2437: aload           23
        //  2439: invokevirtual   Jama/Matrix.arrayTimes:(LJama/Matrix;)LJama/Matrix;
        //  2442: astore_0       
        //  2443: aload_0        
        //  2444: aload           23
        //  2446: invokevirtual   Jama/Matrix.arrayRightDivideEquals:(LJama/Matrix;)LJama/Matrix;
        //  2449: aload           22
        //  2451: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2454: ldc_w           "arrayTimes... "
        //  2457: ldc             ""
        //  2459: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2462: aload           22
        //  2464: aload           6
        //  2466: invokevirtual   Jama/Matrix.arrayTimesEquals:(LJama/Matrix;)LJama/Matrix;
        //  2469: pop            
        //  2470: iload_3        
        //  2471: ldc_w           "arrayTimesEquals conformance check... "
        //  2474: ldc_w           "nonconformance not raised"
        //  2477: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  2480: istore          4
        //  2482: iload           4
        //  2484: istore_3       
        //  2485: aload           22
        //  2487: aload           23
        //  2489: invokevirtual   Jama/Matrix.arrayTimesEquals:(LJama/Matrix;)LJama/Matrix;
        //  2492: pop            
        //  2493: aload           22
        //  2495: aload           23
        //  2497: invokevirtual   Jama/Matrix.arrayRightDivideEquals:(LJama/Matrix;)LJama/Matrix;
        //  2500: aload           21
        //  2502: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2505: ldc_w           "arrayTimesEquals... "
        //  2508: ldc             ""
        //  2510: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2513: ldc_w           "\nTesting I/O methods...\n"
        //  2516: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //  2519: new             Ljava/text/DecimalFormat;
        //  2522: dup            
        //  2523: ldc_w           "0.0000E00"
        //  2526: invokespecial   java/text/DecimalFormat.<init>:(Ljava/lang/String;)V
        //  2529: astore_0       
        //  2530: aload_0        
        //  2531: new             Ljava/text/DecimalFormatSymbols;
        //  2534: dup            
        //  2535: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //  2538: invokespecial   java/text/DecimalFormatSymbols.<init>:(Ljava/util/Locale;)V
        //  2541: invokevirtual   java/text/DecimalFormat.setDecimalFormatSymbols:(Ljava/text/DecimalFormatSymbols;)V
        //  2544: new             Ljava/io/PrintWriter;
        //  2547: dup            
        //  2548: new             Ljava/io/FileOutputStream;
        //  2551: dup            
        //  2552: ldc_w           "JamaTestMatrix.out"
        //  2555: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //  2558: invokespecial   java/io/PrintWriter.<init>:(Ljava/io/OutputStream;)V
        //  2561: astore          6
        //  2563: aload           22
        //  2565: aload           6
        //  2567: aload_0        
        //  2568: bipush          10
        //  2570: invokevirtual   Jama/Matrix.print:(Ljava/io/PrintWriter;Ljava/text/NumberFormat;I)V
        //  2573: aload           6
        //  2575: invokevirtual   java/io/PrintWriter.close:()V
        //  2578: aload           22
        //  2580: new             Ljava/io/BufferedReader;
        //  2583: dup            
        //  2584: new             Ljava/io/FileReader;
        //  2587: dup            
        //  2588: ldc_w           "JamaTestMatrix.out"
        //  2591: invokespecial   java/io/FileReader.<init>:(Ljava/lang/String;)V
        //  2594: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //  2597: invokestatic    Jama/Matrix.read:(Ljava/io/BufferedReader;)LJama/Matrix;
        //  2600: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  2603: invokevirtual   Jama/Matrix.norm1:()D
        //  2606: ldc2_w          0.001
        //  2609: dcmpg          
        //  2610: ifge            5304
        //  2613: ldc_w           "print()/read()..."
        //  2616: ldc             ""
        //  2618: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2621: iconst_0       
        //  2622: istore          5
        //  2624: iload_3        
        //  2625: istore          4
        //  2627: iload           5
        //  2629: istore_3       
        //  2630: aload           22
        //  2632: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  2635: aload           22
        //  2637: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  2640: invokestatic    Jama/Matrix.random:(II)LJama/Matrix;
        //  2643: astore_0       
        //  2644: new             Ljava/io/ObjectOutputStream;
        //  2647: dup            
        //  2648: new             Ljava/io/FileOutputStream;
        //  2651: dup            
        //  2652: ldc_w           "TMPMATRIX.serial"
        //  2655: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //  2658: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //  2661: aload_0        
        //  2662: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //  2665: new             Ljava/io/ObjectInputStream;
        //  2668: dup            
        //  2669: new             Ljava/io/FileInputStream;
        //  2672: dup            
        //  2673: ldc_w           "TMPMATRIX.serial"
        //  2676: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //  2679: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //  2682: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //  2685: checkcast       LJama/Matrix;
        //  2688: astore          6
        //  2690: aload           6
        //  2692: aload_0        
        //  2693: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2696: ldc_w           "writeObject(Matrix)/readObject(Matrix)..."
        //  2699: ldc             ""
        //  2701: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2704: iload_3        
        //  2705: istore          5
        //  2707: ldc_w           "\nTesting linear algebra methods...\n"
        //  2710: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //  2713: new             LJama/Matrix;
        //  2716: dup            
        //  2717: aload           14
        //  2719: iconst_3       
        //  2720: invokespecial   Jama/Matrix.<init>:([DI)V
        //  2723: astore_0       
        //  2724: new             LJama/Matrix;
        //  2727: dup            
        //  2728: iconst_4       
        //  2729: anewarray       [D
        //  2732: dup            
        //  2733: iconst_0       
        //  2734: iconst_3       
        //  2735: newarray        D
        //  2737: dup            
        //  2738: iconst_0       
        //  2739: dconst_1       
        //  2740: dastore        
        //  2741: dup            
        //  2742: iconst_1       
        //  2743: ldc2_w          2.0
        //  2746: dastore        
        //  2747: dup            
        //  2748: iconst_2       
        //  2749: ldc2_w          3.0
        //  2752: dastore        
        //  2753: aastore        
        //  2754: dup            
        //  2755: iconst_1       
        //  2756: aload           19
        //  2758: aastore        
        //  2759: dup            
        //  2760: iconst_2       
        //  2761: iconst_3       
        //  2762: newarray        D
        //  2764: dup            
        //  2765: iconst_0       
        //  2766: ldc2_w          7.0
        //  2769: dastore        
        //  2770: dup            
        //  2771: iconst_1       
        //  2772: ldc2_w          8.0
        //  2775: dastore        
        //  2776: dup            
        //  2777: iconst_2       
        //  2778: ldc2_w          9.0
        //  2781: dastore        
        //  2782: aastore        
        //  2783: dup            
        //  2784: iconst_3       
        //  2785: iconst_3       
        //  2786: newarray        D
        //  2788: dup            
        //  2789: iconst_0       
        //  2790: ldc2_w          10.0
        //  2793: dastore        
        //  2794: dup            
        //  2795: iconst_1       
        //  2796: ldc2_w          11.0
        //  2799: dastore        
        //  2800: dup            
        //  2801: iconst_2       
        //  2802: ldc2_w          12.0
        //  2805: dastore        
        //  2806: aastore        
        //  2807: invokespecial   Jama/Matrix.<init>:([[D)V
        //  2810: pop            
        //  2811: aload_0        
        //  2812: invokevirtual   Jama/Matrix.transpose:()LJama/Matrix;
        //  2815: astore          6
        //  2817: aload_0        
        //  2818: invokevirtual   Jama/Matrix.transpose:()LJama/Matrix;
        //  2821: aload           6
        //  2823: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2826: ldc_w           "transpose..."
        //  2829: ldc             ""
        //  2831: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2834: aload_0        
        //  2835: invokevirtual   Jama/Matrix.transpose:()LJama/Matrix;
        //  2838: pop            
        //  2839: aload_0        
        //  2840: invokevirtual   Jama/Matrix.norm1:()D
        //  2843: ldc2_w          33.0
        //  2846: invokestatic    Jama/test/TestMatrix.check:(DD)V
        //  2849: ldc_w           "norm1..."
        //  2852: ldc             ""
        //  2854: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2857: iload           4
        //  2859: istore_3       
        //  2860: aload_0        
        //  2861: invokevirtual   Jama/Matrix.normInf:()D
        //  2864: ldc2_w          30.0
        //  2867: invokestatic    Jama/test/TestMatrix.check:(DD)V
        //  2870: ldc_w           "normInf()..."
        //  2873: ldc             ""
        //  2875: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2878: aload_0        
        //  2879: invokevirtual   Jama/Matrix.normF:()D
        //  2882: ldc2_w          650.0
        //  2885: invokestatic    java/lang/Math.sqrt:(D)D
        //  2888: invokestatic    Jama/test/TestMatrix.check:(DD)V
        //  2891: ldc_w           "normF..."
        //  2894: ldc             ""
        //  2896: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2899: aload_0        
        //  2900: invokevirtual   Jama/Matrix.trace:()D
        //  2903: ldc2_w          15.0
        //  2906: invokestatic    Jama/test/TestMatrix.check:(DD)V
        //  2909: ldc_w           "trace()..."
        //  2912: ldc             ""
        //  2914: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2917: aload_0        
        //  2918: iconst_0       
        //  2919: aload_0        
        //  2920: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  2923: iconst_1       
        //  2924: isub           
        //  2925: iconst_0       
        //  2926: aload_0        
        //  2927: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  2930: iconst_1       
        //  2931: isub           
        //  2932: invokevirtual   Jama/Matrix.getMatrix:(IIII)LJama/Matrix;
        //  2935: invokevirtual   Jama/Matrix.det:()D
        //  2938: dconst_0       
        //  2939: invokestatic    Jama/test/TestMatrix.check:(DD)V
        //  2942: ldc_w           "det()..."
        //  2945: ldc             ""
        //  2947: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2950: new             LJama/Matrix;
        //  2953: dup            
        //  2954: iconst_3       
        //  2955: anewarray       [D
        //  2958: dup            
        //  2959: iconst_0       
        //  2960: aload           15
        //  2962: aastore        
        //  2963: dup            
        //  2964: iconst_1       
        //  2965: aload           16
        //  2967: aastore        
        //  2968: dup            
        //  2969: iconst_2       
        //  2970: aload           17
        //  2972: aastore        
        //  2973: invokespecial   Jama/Matrix.<init>:([[D)V
        //  2976: astore          6
        //  2978: aload_0        
        //  2979: aload_0        
        //  2980: invokevirtual   Jama/Matrix.transpose:()LJama/Matrix;
        //  2983: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  2986: aload           6
        //  2988: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  2991: ldc_w           "times(Matrix)..."
        //  2994: ldc             ""
        //  2996: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  2999: aload_0        
        //  3000: dconst_0       
        //  3001: invokevirtual   Jama/Matrix.times:(D)LJama/Matrix;
        //  3004: aload           20
        //  3006: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3009: ldc_w           "times(double)..."
        //  3012: ldc             ""
        //  3014: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3017: new             LJama/Matrix;
        //  3020: dup            
        //  3021: aload           14
        //  3023: iconst_4       
        //  3024: invokespecial   Jama/Matrix.<init>:([DI)V
        //  3027: astore_0       
        //  3028: aload_0        
        //  3029: invokevirtual   Jama/Matrix.qr:()LJama/QRDecomposition;
        //  3032: astore          6
        //  3034: aload           6
        //  3036: invokevirtual   Jama/QRDecomposition.getR:()LJama/Matrix;
        //  3039: astore          14
        //  3041: aload_0        
        //  3042: aload           6
        //  3044: invokevirtual   Jama/QRDecomposition.getQ:()LJama/Matrix;
        //  3047: aload           14
        //  3049: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3052: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3055: ldc_w           "QRDecomposition..."
        //  3058: ldc             ""
        //  3060: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3063: aload_0        
        //  3064: invokevirtual   Jama/Matrix.svd:()LJama/SingularValueDecomposition;
        //  3067: astore          6
        //  3069: aload_0        
        //  3070: aload           6
        //  3072: invokevirtual   Jama/SingularValueDecomposition.getU:()LJama/Matrix;
        //  3075: aload           6
        //  3077: invokevirtual   Jama/SingularValueDecomposition.getS:()LJama/Matrix;
        //  3080: aload           6
        //  3082: invokevirtual   Jama/SingularValueDecomposition.getV:()LJama/Matrix;
        //  3085: invokevirtual   Jama/Matrix.transpose:()LJama/Matrix;
        //  3088: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3091: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3094: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3097: ldc_w           "SingularValueDecomposition..."
        //  3100: ldc             ""
        //  3102: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3105: new             LJama/Matrix;
        //  3108: dup            
        //  3109: aload           13
        //  3111: invokespecial   Jama/Matrix.<init>:([[D)V
        //  3114: astore          6
        //  3116: aload           6
        //  3118: invokevirtual   Jama/Matrix.rank:()I
        //  3121: i2d            
        //  3122: aload           6
        //  3124: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  3127: aload           6
        //  3129: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  3132: invokestatic    java/lang/Math.min:(II)I
        //  3135: iconst_1       
        //  3136: isub           
        //  3137: i2d            
        //  3138: invokestatic    Jama/test/TestMatrix.check:(DD)V
        //  3141: ldc_w           "rank()..."
        //  3144: ldc             ""
        //  3146: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3149: new             LJama/Matrix;
        //  3152: dup            
        //  3153: iconst_2       
        //  3154: anewarray       [D
        //  3157: dup            
        //  3158: iconst_0       
        //  3159: iconst_2       
        //  3160: newarray        D
        //  3162: dup            
        //  3163: iconst_0       
        //  3164: dconst_1       
        //  3165: dastore        
        //  3166: dup            
        //  3167: iconst_1       
        //  3168: ldc2_w          3.0
        //  3171: dastore        
        //  3172: aastore        
        //  3173: dup            
        //  3174: iconst_1       
        //  3175: aload           12
        //  3177: aastore        
        //  3178: invokespecial   Jama/Matrix.<init>:([[D)V
        //  3181: astore          6
        //  3183: aload           6
        //  3185: invokevirtual   Jama/Matrix.svd:()LJama/SingularValueDecomposition;
        //  3188: invokevirtual   Jama/SingularValueDecomposition.getSingularValues:()[D
        //  3191: astore          12
        //  3193: aload           6
        //  3195: invokevirtual   Jama/Matrix.cond:()D
        //  3198: aload           12
        //  3200: iconst_0       
        //  3201: daload         
        //  3202: aload           12
        //  3204: aload           6
        //  3206: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  3209: aload           6
        //  3211: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  3214: invokestatic    java/lang/Math.min:(II)I
        //  3217: iconst_1       
        //  3218: isub           
        //  3219: daload         
        //  3220: ddiv           
        //  3221: invokestatic    Jama/test/TestMatrix.check:(DD)V
        //  3224: ldc_w           "cond()..."
        //  3227: ldc             ""
        //  3229: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3232: aload_0        
        //  3233: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  3236: istore          4
        //  3238: aload_0        
        //  3239: iconst_0       
        //  3240: iload           4
        //  3242: iconst_1       
        //  3243: isub           
        //  3244: iconst_0       
        //  3245: iload           4
        //  3247: iconst_1       
        //  3248: isub           
        //  3249: invokevirtual   Jama/Matrix.getMatrix:(IIII)LJama/Matrix;
        //  3252: astore_0       
        //  3253: aload_0        
        //  3254: iconst_0       
        //  3255: iconst_0       
        //  3256: dconst_0       
        //  3257: invokevirtual   Jama/Matrix.set:(IID)V
        //  3260: aload_0        
        //  3261: invokevirtual   Jama/Matrix.lu:()LJama/LUDecomposition;
        //  3264: astore          6
        //  3266: aload_0        
        //  3267: aload           6
        //  3269: invokevirtual   Jama/LUDecomposition.getPivot:()[I
        //  3272: iconst_0       
        //  3273: iload           4
        //  3275: iconst_1       
        //  3276: isub           
        //  3277: invokevirtual   Jama/Matrix.getMatrix:([III)LJama/Matrix;
        //  3280: aload           6
        //  3282: invokevirtual   Jama/LUDecomposition.getL:()LJama/Matrix;
        //  3285: aload           6
        //  3287: invokevirtual   Jama/LUDecomposition.getU:()LJama/Matrix;
        //  3290: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3293: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3296: ldc_w           "LUDecomposition..."
        //  3299: ldc             ""
        //  3301: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3304: aload_0        
        //  3305: invokevirtual   Jama/Matrix.inverse:()LJama/Matrix;
        //  3308: astore          6
        //  3310: aload_0        
        //  3311: aload           6
        //  3313: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3316: iconst_3       
        //  3317: iconst_3       
        //  3318: invokestatic    Jama/Matrix.identity:(II)LJama/Matrix;
        //  3321: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3324: ldc_w           "inverse()..."
        //  3327: ldc             ""
        //  3329: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3332: new             LJama/Matrix;
        //  3335: dup            
        //  3336: aload           18
        //  3338: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  3341: iconst_1       
        //  3342: dconst_1       
        //  3343: invokespecial   Jama/Matrix.<init>:(IID)V
        //  3346: astore_0       
        //  3347: new             LJama/Matrix;
        //  3350: dup            
        //  3351: iconst_2       
        //  3352: anewarray       [D
        //  3355: dup            
        //  3356: iconst_0       
        //  3357: iconst_1       
        //  3358: newarray        D
        //  3360: dup            
        //  3361: iconst_0       
        //  3362: ldc2_w          13.0
        //  3365: dastore        
        //  3366: aastore        
        //  3367: dup            
        //  3368: iconst_1       
        //  3369: iconst_1       
        //  3370: newarray        D
        //  3372: dup            
        //  3373: iconst_0       
        //  3374: ldc2_w          15.0
        //  3377: dastore        
        //  3378: aastore        
        //  3379: invokespecial   Jama/Matrix.<init>:([[D)V
        //  3382: astore          6
        //  3384: aload           18
        //  3386: iconst_0       
        //  3387: aload           18
        //  3389: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  3392: iconst_1       
        //  3393: isub           
        //  3394: iconst_0       
        //  3395: aload           18
        //  3397: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  3400: iconst_1       
        //  3401: isub           
        //  3402: invokevirtual   Jama/Matrix.getMatrix:(IIII)LJama/Matrix;
        //  3405: astore          12
        //  3407: aload           12
        //  3409: aload           6
        //  3411: invokevirtual   Jama/Matrix.solve:(LJama/Matrix;)LJama/Matrix;
        //  3414: aload_0        
        //  3415: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3418: ldc_w           "solve()..."
        //  3421: ldc             ""
        //  3423: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3426: new             LJama/Matrix;
        //  3429: dup            
        //  3430: iconst_3       
        //  3431: anewarray       [D
        //  3434: dup            
        //  3435: iconst_0       
        //  3436: iconst_3       
        //  3437: newarray        D
        //  3439: dup            
        //  3440: iconst_0       
        //  3441: ldc2_w          4.0
        //  3444: dastore        
        //  3445: dup            
        //  3446: iconst_1       
        //  3447: dconst_1       
        //  3448: dastore        
        //  3449: dup            
        //  3450: iconst_2       
        //  3451: dconst_1       
        //  3452: dastore        
        //  3453: aastore        
        //  3454: dup            
        //  3455: iconst_1       
        //  3456: iconst_3       
        //  3457: newarray        D
        //  3459: dup            
        //  3460: iconst_0       
        //  3461: dconst_1       
        //  3462: dastore        
        //  3463: dup            
        //  3464: iconst_1       
        //  3465: ldc2_w          2.0
        //  3468: dastore        
        //  3469: dup            
        //  3470: iconst_2       
        //  3471: ldc2_w          3.0
        //  3474: dastore        
        //  3475: aastore        
        //  3476: dup            
        //  3477: iconst_2       
        //  3478: iconst_3       
        //  3479: newarray        D
        //  3481: dup            
        //  3482: iconst_0       
        //  3483: dconst_1       
        //  3484: dastore        
        //  3485: dup            
        //  3486: iconst_1       
        //  3487: ldc2_w          3.0
        //  3490: dastore        
        //  3491: dup            
        //  3492: iconst_2       
        //  3493: ldc2_w          6.0
        //  3496: dastore        
        //  3497: aastore        
        //  3498: invokespecial   Jama/Matrix.<init>:([[D)V
        //  3501: astore_0       
        //  3502: aload_0        
        //  3503: invokevirtual   Jama/Matrix.chol:()LJama/CholeskyDecomposition;
        //  3506: astore          6
        //  3508: aload           6
        //  3510: invokevirtual   Jama/CholeskyDecomposition.getL:()LJama/Matrix;
        //  3513: astore          12
        //  3515: aload_0        
        //  3516: aload           12
        //  3518: aload           12
        //  3520: invokevirtual   Jama/Matrix.transpose:()LJama/Matrix;
        //  3523: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3526: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3529: ldc_w           "CholeskyDecomposition..."
        //  3532: ldc             ""
        //  3534: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3537: aload           6
        //  3539: iconst_3       
        //  3540: iconst_3       
        //  3541: invokestatic    Jama/Matrix.identity:(II)LJama/Matrix;
        //  3544: invokevirtual   Jama/CholeskyDecomposition.solve:(LJama/Matrix;)LJama/Matrix;
        //  3547: astore          6
        //  3549: aload_0        
        //  3550: aload           6
        //  3552: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3555: iconst_3       
        //  3556: iconst_3       
        //  3557: invokestatic    Jama/Matrix.identity:(II)LJama/Matrix;
        //  3560: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3563: ldc_w           "CholeskyDecomposition solve()..."
        //  3566: ldc             ""
        //  3568: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3571: aload_0        
        //  3572: invokevirtual   Jama/Matrix.eig:()LJama/EigenvalueDecomposition;
        //  3575: astore          12
        //  3577: aload           12
        //  3579: invokevirtual   Jama/EigenvalueDecomposition.getD:()LJama/Matrix;
        //  3582: astore          6
        //  3584: aload           12
        //  3586: invokevirtual   Jama/EigenvalueDecomposition.getV:()LJama/Matrix;
        //  3589: astore          12
        //  3591: aload_0        
        //  3592: aload           12
        //  3594: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3597: aload           12
        //  3599: aload           6
        //  3601: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3604: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3607: ldc_w           "EigenvalueDecomposition (symmetric)..."
        //  3610: ldc             ""
        //  3612: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3615: new             LJama/Matrix;
        //  3618: dup            
        //  3619: iconst_4       
        //  3620: anewarray       [D
        //  3623: dup            
        //  3624: iconst_0       
        //  3625: iconst_4       
        //  3626: newarray        D
        //  3628: dup            
        //  3629: iconst_0       
        //  3630: dconst_0       
        //  3631: dastore        
        //  3632: dup            
        //  3633: iconst_1       
        //  3634: dconst_1       
        //  3635: dastore        
        //  3636: dup            
        //  3637: iconst_2       
        //  3638: dconst_0       
        //  3639: dastore        
        //  3640: dup            
        //  3641: iconst_3       
        //  3642: dconst_0       
        //  3643: dastore        
        //  3644: aastore        
        //  3645: dup            
        //  3646: iconst_1       
        //  3647: iconst_4       
        //  3648: newarray        D
        //  3650: dup            
        //  3651: iconst_0       
        //  3652: dconst_1       
        //  3653: dastore        
        //  3654: dup            
        //  3655: iconst_1       
        //  3656: dconst_0       
        //  3657: dastore        
        //  3658: dup            
        //  3659: iconst_2       
        //  3660: ldc2_w          2.0E-7
        //  3663: dastore        
        //  3664: dup            
        //  3665: iconst_3       
        //  3666: dconst_0       
        //  3667: dastore        
        //  3668: aastore        
        //  3669: dup            
        //  3670: iconst_2       
        //  3671: iconst_4       
        //  3672: newarray        D
        //  3674: dup            
        //  3675: iconst_0       
        //  3676: dconst_0       
        //  3677: dastore        
        //  3678: dup            
        //  3679: iconst_1       
        //  3680: ldc2_w          -2.0E-7
        //  3683: dastore        
        //  3684: dup            
        //  3685: iconst_2       
        //  3686: dconst_0       
        //  3687: dastore        
        //  3688: dup            
        //  3689: iconst_3       
        //  3690: dconst_1       
        //  3691: dastore        
        //  3692: aastore        
        //  3693: dup            
        //  3694: iconst_3       
        //  3695: iconst_4       
        //  3696: newarray        D
        //  3698: dup            
        //  3699: iconst_0       
        //  3700: dconst_0       
        //  3701: dastore        
        //  3702: dup            
        //  3703: iconst_1       
        //  3704: dconst_0       
        //  3705: dastore        
        //  3706: dup            
        //  3707: iconst_2       
        //  3708: dconst_1       
        //  3709: dastore        
        //  3710: dup            
        //  3711: iconst_3       
        //  3712: dconst_0       
        //  3713: dastore        
        //  3714: aastore        
        //  3715: invokespecial   Jama/Matrix.<init>:([[D)V
        //  3718: astore_0       
        //  3719: aload_0        
        //  3720: invokevirtual   Jama/Matrix.eig:()LJama/EigenvalueDecomposition;
        //  3723: astore          12
        //  3725: aload           12
        //  3727: invokevirtual   Jama/EigenvalueDecomposition.getD:()LJama/Matrix;
        //  3730: astore          6
        //  3732: aload           12
        //  3734: invokevirtual   Jama/EigenvalueDecomposition.getV:()LJama/Matrix;
        //  3737: astore          12
        //  3739: aload_0        
        //  3740: aload           12
        //  3742: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3745: aload           12
        //  3747: aload           6
        //  3749: invokevirtual   Jama/Matrix.times:(LJama/Matrix;)LJama/Matrix;
        //  3752: invokestatic    Jama/test/TestMatrix.check:(LJama/Matrix;LJama/Matrix;)V
        //  3755: ldc_w           "EigenvalueDecomposition (nonsymmetric)..."
        //  3758: ldc             ""
        //  3760: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3763: ldc_w           "\nTesting Eigenvalue; If this hangs, we've failed\n"
        //  3766: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //  3769: new             LJama/Matrix;
        //  3772: dup            
        //  3773: iconst_5       
        //  3774: anewarray       [D
        //  3777: dup            
        //  3778: iconst_0       
        //  3779: aload           7
        //  3781: aastore        
        //  3782: dup            
        //  3783: iconst_1       
        //  3784: aload           8
        //  3786: aastore        
        //  3787: dup            
        //  3788: iconst_2       
        //  3789: aload           9
        //  3791: aastore        
        //  3792: dup            
        //  3793: iconst_3       
        //  3794: aload           10
        //  3796: aastore        
        //  3797: dup            
        //  3798: iconst_4       
        //  3799: aload           11
        //  3801: aastore        
        //  3802: invokespecial   Jama/Matrix.<init>:([[D)V
        //  3805: invokevirtual   Jama/Matrix.eig:()LJama/EigenvalueDecomposition;
        //  3808: pop            
        //  3809: ldc_w           "EigenvalueDecomposition (hang)..."
        //  3812: ldc             ""
        //  3814: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3817: ldc_w           "\nTestMatrix completed.\n"
        //  3820: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //  3823: new             Ljava/lang/StringBuilder;
        //  3826: dup            
        //  3827: invokespecial   java/lang/StringBuilder.<init>:()V
        //  3830: ldc_w           "Total errors reported: "
        //  3833: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3836: iload_3        
        //  3837: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //  3840: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3843: ldc_w           "\n"
        //  3846: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3849: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  3852: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //  3855: new             Ljava/lang/StringBuilder;
        //  3858: dup            
        //  3859: invokespecial   java/lang/StringBuilder.<init>:()V
        //  3862: ldc_w           "Total warnings reported: "
        //  3865: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3868: iload           5
        //  3870: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //  3873: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3876: ldc_w           "\n"
        //  3879: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3882: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  3885: invokestatic    Jama/test/TestMatrix.print:(Ljava/lang/String;)V
        //  3888: return         
        //  3889: astore          23
        //  3891: ldc             "Catch invalid length in packed constructor... "
        //  3893: aload           23
        //  3895: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //  3898: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3901: goto            629
        //  3904: astore          23
        //  3906: ldc_w           "Catch ragged input to default constructor... "
        //  3909: aload           23
        //  3911: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //  3914: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3917: goto            644
        //  3920: astore          23
        //  3922: iload_3        
        //  3923: ldc_w           "Catch ragged input to constructor... "
        //  3926: ldc_w           "exception not thrown in construction...ArrayIndexOutOfBoundsException thrown later"
        //  3929: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  3932: istore_3       
        //  3933: goto            644
        //  3936: astore          22
        //  3938: ldc_w           "Catch ragged input to constructWithCopy... "
        //  3941: aload           22
        //  3943: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //  3946: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3949: goto            655
        //  3952: astore          22
        //  3954: iload_3        
        //  3955: ldc_w           "Catch ragged input to constructWithCopy... "
        //  3958: ldc_w           "exception not thrown in construction...ArrayIndexOutOfBoundsException thrown later"
        //  3961: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  3964: istore_3       
        //  3965: goto            655
        //  3968: ldc             "constructWithCopy... "
        //  3970: ldc             ""
        //  3972: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  3975: goto            753
        //  3978: astore          18
        //  3980: iload_3        
        //  3981: ldc             "identity... "
        //  3983: ldc_w           "identity Matrix not successfully created"
        //  3986: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  3989: istore_3       
        //  3990: goto            842
        //  3993: ldc             "getRowDimension... "
        //  3995: ldc             ""
        //  3997: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4000: goto            876
        //  4003: ldc             "getColumnDimension... "
        //  4005: ldc             ""
        //  4007: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4010: goto            894
        //  4013: ldc             "getArray... "
        //  4015: ldc             ""
        //  4017: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4020: goto            924
        //  4023: astore          18
        //  4025: iload           4
        //  4027: ldc             "getArrayCopy... "
        //  4029: ldc_w           "data not successfully (deep) copied"
        //  4032: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4035: istore          4
        //  4037: goto            965
        //  4040: astore          18
        //  4042: iload           4
        //  4044: ldc             "getColumnPackedCopy... "
        //  4046: ldc_w           "data not successfully (deep) copied by columns"
        //  4049: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4052: istore_3       
        //  4053: goto            989
        //  4056: astore          18
        //  4058: iload_3        
        //  4059: ldc             "getRowPackedCopy... "
        //  4061: ldc_w           "data not successfully (deep) copied by rows"
        //  4064: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4067: istore_3       
        //  4068: goto            1088
        //  4071: astore          18
        //  4073: aload           23
        //  4075: aload           23
        //  4077: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  4080: iconst_1       
        //  4081: isub           
        //  4082: aload           23
        //  4084: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  4087: invokevirtual   Jama/Matrix.get:(II)D
        //  4090: pop2           
        //  4091: iload_3        
        //  4092: ldc             "get(int,int)... "
        //  4094: ldc             "OutOfBoundsException expected but not thrown"
        //  4096: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4099: istore          4
        //  4101: iload           4
        //  4103: istore_3       
        //  4104: goto            1119
        //  4107: astore          18
        //  4109: ldc_w           "get(int,int)... OutofBoundsException... "
        //  4112: ldc             ""
        //  4114: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4117: goto            1119
        //  4120: astore          18
        //  4122: iload_3        
        //  4123: ldc             "get(int,int)... "
        //  4125: ldc             "OutOfBoundsException expected but not thrown"
        //  4127: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4130: istore_3       
        //  4131: goto            1119
        //  4134: ldc             "get(int,int)... "
        //  4136: ldc             ""
        //  4138: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4141: goto            1173
        //  4144: astore          18
        //  4146: iload_3        
        //  4147: ldc             "get(int,int)... "
        //  4149: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4152: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4155: istore_3       
        //  4156: goto            1173
        //  4159: astore          24
        //  4161: aload           23
        //  4163: iconst_1       
        //  4164: iconst_2       
        //  4165: iconst_1       
        //  4166: aload           23
        //  4168: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  4171: iconst_3       
        //  4172: iadd           
        //  4173: iconst_1       
        //  4174: iadd           
        //  4175: invokevirtual   Jama/Matrix.getMatrix:(IIII)LJama/Matrix;
        //  4178: pop            
        //  4179: iload_3        
        //  4180: ldc             "getMatrix(int,int,int,int)... "
        //  4182: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4184: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4187: istore          4
        //  4189: iload           4
        //  4191: istore_3       
        //  4192: goto            1265
        //  4195: astore          24
        //  4197: ldc_w           "getMatrix(int,int,int,int)... ArrayIndexOutOfBoundsException... "
        //  4200: ldc             ""
        //  4202: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4205: goto            1265
        //  4208: astore          24
        //  4210: iload_3        
        //  4211: ldc             "getMatrix(int,int,int,int)... "
        //  4213: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4215: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4218: istore_3       
        //  4219: goto            1265
        //  4222: astore          24
        //  4224: iload_3        
        //  4225: ldc             "getMatrix(int,int,int,int)... "
        //  4227: ldc_w           "submatrix not successfully retreived"
        //  4230: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4233: istore          4
        //  4235: iload           4
        //  4237: istore_3       
        //  4238: goto            1290
        //  4241: astore          24
        //  4243: iload_3        
        //  4244: ldc             "getMatrix(int,int,int,int)... "
        //  4246: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4249: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4252: istore_3       
        //  4253: goto            1290
        //  4256: astore          24
        //  4258: aload           23
        //  4260: iconst_1       
        //  4261: aload           23
        //  4263: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  4266: iconst_2       
        //  4267: iadd           
        //  4268: iconst_1       
        //  4269: iadd           
        //  4270: aload           6
        //  4272: invokevirtual   Jama/Matrix.getMatrix:(II[I)LJama/Matrix;
        //  4275: pop            
        //  4276: iload_3        
        //  4277: ldc             "getMatrix(int,int,int[])... "
        //  4279: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4281: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4284: istore          4
        //  4286: iload           4
        //  4288: istore_3       
        //  4289: goto            1313
        //  4292: astore          24
        //  4294: ldc_w           "getMatrix(int,int,int[])... ArrayIndexOutOfBoundsException... "
        //  4297: ldc             ""
        //  4299: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4302: goto            1313
        //  4305: astore          24
        //  4307: iload_3        
        //  4308: ldc             "getMatrix(int,int,int[])... "
        //  4310: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4312: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4315: istore_3       
        //  4316: goto            1313
        //  4319: astore          24
        //  4321: iload_3        
        //  4322: ldc             "getMatrix(int,int,int[])... "
        //  4324: ldc_w           "submatrix not successfully retreived"
        //  4327: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4330: istore          4
        //  4332: iload           4
        //  4334: istore_3       
        //  4335: goto            1338
        //  4338: astore          24
        //  4340: iload_3        
        //  4341: ldc             "getMatrix(int,int,int[])... "
        //  4343: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4346: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4349: istore_3       
        //  4350: goto            1338
        //  4353: astore          24
        //  4355: aload           23
        //  4357: aload_0        
        //  4358: iconst_1       
        //  4359: aload           23
        //  4361: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  4364: iconst_3       
        //  4365: iadd           
        //  4366: iconst_1       
        //  4367: iadd           
        //  4368: invokevirtual   Jama/Matrix.getMatrix:([III)LJama/Matrix;
        //  4371: pop            
        //  4372: iload_3        
        //  4373: ldc             "getMatrix(int[],int,int)... "
        //  4375: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4377: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4380: istore          4
        //  4382: iload           4
        //  4384: istore_3       
        //  4385: goto            1361
        //  4388: astore          24
        //  4390: ldc_w           "getMatrix(int[],int,int)... ArrayIndexOutOfBoundsException... "
        //  4393: ldc             ""
        //  4395: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4398: goto            1361
        //  4401: astore          24
        //  4403: iload_3        
        //  4404: ldc             "getMatrix(int[],int,int)... "
        //  4406: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4408: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4411: istore_3       
        //  4412: goto            1361
        //  4415: astore          24
        //  4417: iload_3        
        //  4418: ldc             "getMatrix(int[],int,int)... "
        //  4420: ldc_w           "submatrix not successfully retreived"
        //  4423: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4426: istore          4
        //  4428: iload           4
        //  4430: istore_3       
        //  4431: goto            1385
        //  4434: astore          24
        //  4436: iload_3        
        //  4437: ldc             "getMatrix(int[],int,int)... "
        //  4439: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4442: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4445: istore_3       
        //  4446: goto            1385
        //  4449: astore          24
        //  4451: aload           23
        //  4453: aload_0        
        //  4454: aload           21
        //  4456: invokevirtual   Jama/Matrix.getMatrix:([I[I)LJama/Matrix;
        //  4459: pop            
        //  4460: iload_3        
        //  4461: ldc             "getMatrix(int[],int[])... "
        //  4463: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4465: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4468: istore          4
        //  4470: iload           4
        //  4472: istore_3       
        //  4473: goto            1408
        //  4476: astore          24
        //  4478: ldc_w           "getMatrix(int[],int[])... ArrayIndexOutOfBoundsException... "
        //  4481: ldc             ""
        //  4483: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4486: goto            1408
        //  4489: astore          24
        //  4491: iload_3        
        //  4492: ldc             "getMatrix(int[],int[])... "
        //  4494: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4496: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4499: istore_3       
        //  4500: goto            1408
        //  4503: astore          24
        //  4505: iload_3        
        //  4506: ldc             "getMatrix(int[],int[])... "
        //  4508: ldc_w           "submatrix not successfully retreived"
        //  4511: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4514: istore          4
        //  4516: iload           4
        //  4518: istore_3       
        //  4519: goto            1432
        //  4522: astore          24
        //  4524: iload_3        
        //  4525: ldc             "getMatrix(int[],int[])... "
        //  4527: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4530: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4533: istore_3       
        //  4534: goto            1432
        //  4537: astore          24
        //  4539: aload           23
        //  4541: aload           23
        //  4543: invokevirtual   Jama/Matrix.getRowDimension:()I
        //  4546: iconst_1       
        //  4547: isub           
        //  4548: aload           23
        //  4550: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  4553: dconst_0       
        //  4554: invokevirtual   Jama/Matrix.set:(IID)V
        //  4557: iload_3        
        //  4558: ldc             "set(int,int,double)... "
        //  4560: ldc             "OutOfBoundsException expected but not thrown"
        //  4562: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4565: istore          4
        //  4567: iload           4
        //  4569: istore_3       
        //  4570: goto            1463
        //  4573: astore          24
        //  4575: ldc_w           "set(int,int,double)... OutofBoundsException... "
        //  4578: ldc             ""
        //  4580: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4583: goto            1463
        //  4586: astore          24
        //  4588: iload_3        
        //  4589: ldc             "set(int,int,double)... "
        //  4591: ldc             "OutOfBoundsException expected but not thrown"
        //  4593: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4596: istore_3       
        //  4597: goto            1463
        //  4600: astore          24
        //  4602: iload_3        
        //  4603: ldc             "set(int,int,double)... "
        //  4605: ldc_w           "Matrix element not successfully set"
        //  4608: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4611: istore          4
        //  4613: iload           4
        //  4615: istore_3       
        //  4616: goto            1491
        //  4619: astore          24
        //  4621: iload_3        
        //  4622: ldc             "set(int,int,double)... "
        //  4624: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4627: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4630: istore_3       
        //  4631: goto            1491
        //  4634: astore          25
        //  4636: aload           23
        //  4638: iconst_1       
        //  4639: iconst_2       
        //  4640: iconst_1       
        //  4641: aload           23
        //  4643: invokevirtual   Jama/Matrix.getColumnDimension:()I
        //  4646: iconst_3       
        //  4647: iadd           
        //  4648: iconst_1       
        //  4649: iadd           
        //  4650: aload           24
        //  4652: invokevirtual   Jama/Matrix.setMatrix:(IIIILJama/Matrix;)V
        //  4655: iload_3        
        //  4656: ldc             "setMatrix(int,int,int,int,Matrix)... "
        //  4658: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4660: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4663: istore          4
        //  4665: iload           4
        //  4667: istore_3       
        //  4668: goto            1535
        //  4671: astore          25
        //  4673: ldc_w           "setMatrix(int,int,int,int,Matrix)... ArrayIndexOutOfBoundsException... "
        //  4676: ldc             ""
        //  4678: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4681: goto            4668
        //  4684: astore          25
        //  4686: iload_3        
        //  4687: ldc             "setMatrix(int,int,int,int,Matrix)... "
        //  4689: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4691: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4694: istore_3       
        //  4695: goto            1535
        //  4698: astore          25
        //  4700: iload_3        
        //  4701: ldc             "setMatrix(int,int,int,int,Matrix)... "
        //  4703: ldc_w           "submatrix not successfully set"
        //  4706: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4709: istore          4
        //  4711: iload           4
        //  4713: istore_3       
        //  4714: goto            1572
        //  4717: astore          25
        //  4719: iload_3        
        //  4720: ldc             "setMatrix(int,int,int,int,Matrix)... "
        //  4722: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4725: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4728: istore_3       
        //  4729: goto            1583
        //  4732: astore          25
        //  4734: aload           23
        //  4736: iconst_1       
        //  4737: iconst_2       
        //  4738: aload           21
        //  4740: aload           24
        //  4742: invokevirtual   Jama/Matrix.setMatrix:(II[ILJama/Matrix;)V
        //  4745: iload_3        
        //  4746: ldc             "setMatrix(int,int,int[],Matrix)... "
        //  4748: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4750: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4753: istore          4
        //  4755: iload           4
        //  4757: istore_3       
        //  4758: goto            1615
        //  4761: astore          25
        //  4763: ldc_w           "setMatrix(int,int,int[],Matrix)... ArrayIndexOutOfBoundsException... "
        //  4766: ldc             ""
        //  4768: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4771: goto            1615
        //  4774: astore          25
        //  4776: iload_3        
        //  4777: ldc             "setMatrix(int,int,int[],Matrix)... "
        //  4779: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4781: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4784: istore_3       
        //  4785: goto            1615
        //  4788: astore          25
        //  4790: iload_3        
        //  4791: istore          4
        //  4793: iload_3        
        //  4794: ldc             "setMatrix(int,int,int[],Matrix)... "
        //  4796: ldc_w           "submatrix not successfully set"
        //  4799: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4802: istore_3       
        //  4803: goto            1661
        //  4806: astore          25
        //  4808: iload           4
        //  4810: ldc             "setMatrix(int,int,int[],Matrix)... "
        //  4812: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4815: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4818: istore_3       
        //  4819: goto            1675
        //  4822: astore          25
        //  4824: aload           23
        //  4826: aload           20
        //  4828: iconst_1       
        //  4829: iconst_3       
        //  4830: aload           24
        //  4832: invokevirtual   Jama/Matrix.setMatrix:([IIILJama/Matrix;)V
        //  4835: iload_3        
        //  4836: ldc_w           "setMatrix(int[],int,int,Matrix)... "
        //  4839: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4841: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4844: istore          4
        //  4846: iload           4
        //  4848: istore_3       
        //  4849: goto            1707
        //  4852: astore          25
        //  4854: ldc_w           "setMatrix(int[],int,int,Matrix)... ArrayIndexOutOfBoundsException... "
        //  4857: ldc             ""
        //  4859: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4862: goto            1707
        //  4865: astore          25
        //  4867: iload_3        
        //  4868: ldc_w           "setMatrix(int[],int,int,Matrix)... "
        //  4871: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4873: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4876: istore_3       
        //  4877: goto            1707
        //  4880: astore          25
        //  4882: iload_3        
        //  4883: istore          4
        //  4885: iload_3        
        //  4886: ldc_w           "setMatrix(int[],int,int,Matrix)... "
        //  4889: ldc_w           "submatrix not successfully set"
        //  4892: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4895: istore_3       
        //  4896: goto            1752
        //  4899: astore          25
        //  4901: iload           4
        //  4903: ldc_w           "setMatrix(int[],int,int,Matrix)... "
        //  4906: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  4909: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4912: istore_3       
        //  4913: goto            1766
        //  4916: astore          21
        //  4918: aload           23
        //  4920: aload           20
        //  4922: aload           6
        //  4924: aload           24
        //  4926: invokevirtual   Jama/Matrix.setMatrix:([I[ILJama/Matrix;)V
        //  4929: iload_3        
        //  4930: ldc_w           "setMatrix(int[],int[],Matrix)... "
        //  4933: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4935: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4938: istore          4
        //  4940: iload           4
        //  4942: istore_3       
        //  4943: goto            1790
        //  4946: astore          20
        //  4948: ldc_w           "setMatrix(int[],int[],Matrix)... ArrayIndexOutOfBoundsException... "
        //  4951: ldc             ""
        //  4953: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  4956: goto            1790
        //  4959: astore          20
        //  4961: iload_3        
        //  4962: ldc_w           "setMatrix(int[],int[],Matrix)... "
        //  4965: ldc             "ArrayIndexOutOfBoundsException expected but not thrown"
        //  4967: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4970: istore_3       
        //  4971: goto            1790
        //  4974: astore_0       
        //  4975: iload_3        
        //  4976: ldc_w           "setMatrix(int[],int[],Matrix)... "
        //  4979: ldc_w           "submatrix not successfully set"
        //  4982: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  4985: istore          4
        //  4987: iload           4
        //  4989: istore_3       
        //  4990: goto            1826
        //  4993: astore_0       
        //  4994: iload_3        
        //  4995: ldc_w           "setMatrix(int[],int[],Matrix)... "
        //  4998: ldc_w           "Unexpected ArrayIndexOutOfBoundsException"
        //  5001: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5004: istore_3       
        //  5005: goto            1826
        //  5008: astore          6
        //  5010: ldc_w           "minus conformance check... "
        //  5013: ldc             ""
        //  5015: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5018: goto            1892
        //  5021: ldc_w           "minus... "
        //  5024: ldc             ""
        //  5026: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5029: goto            1918
        //  5032: astore          22
        //  5034: ldc_w           "minusEquals conformance check... "
        //  5037: ldc             ""
        //  5039: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5042: goto            1974
        //  5045: ldc_w           "minusEquals... "
        //  5048: ldc             ""
        //  5050: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5053: goto            2000
        //  5056: astore_0       
        //  5057: ldc_w           "plus conformance check... "
        //  5060: ldc             ""
        //  5062: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5065: aload           6
        //  5067: astore_0       
        //  5068: goto            2059
        //  5071: astore          6
        //  5073: iload_3        
        //  5074: ldc_w           "plus... "
        //  5077: ldc_w           "(C = A - B, but C + B != A)"
        //  5080: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5083: istore_3       
        //  5084: goto            2079
        //  5087: astore          23
        //  5089: ldc_w           "plusEquals conformance check... "
        //  5092: ldc             ""
        //  5094: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5097: goto            2118
        //  5100: astore          6
        //  5102: iload_3        
        //  5103: ldc_w           "plusEquals... "
        //  5106: ldc_w           "(C = A - B, but C = C + B != A)"
        //  5109: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5112: istore_3       
        //  5113: goto            2133
        //  5116: astore          6
        //  5118: iload_3        
        //  5119: ldc_w           "uminus... "
        //  5122: ldc_w           "(-A + A != zeros)"
        //  5125: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5128: istore_3       
        //  5129: goto            2160
        //  5132: astore_0       
        //  5133: ldc_w           "arrayLeftDivide conformance check... "
        //  5136: ldc             ""
        //  5138: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5141: aload           6
        //  5143: astore_0       
        //  5144: goto            2224
        //  5147: astore          6
        //  5149: iload_3        
        //  5150: ldc_w           "arrayLeftDivide... "
        //  5153: ldc_w           "(M.\\M != ones)"
        //  5156: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5159: istore_3       
        //  5160: goto            2239
        //  5163: astore          6
        //  5165: ldc_w           "arrayLeftDivideEquals conformance check... "
        //  5168: ldc             ""
        //  5170: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5173: goto            2261
        //  5176: astore          6
        //  5178: iload_3        
        //  5179: ldc_w           "arrayLeftDivideEquals... "
        //  5182: ldc_w           "(M.\\M != ones)"
        //  5185: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5188: istore_3       
        //  5189: goto            2284
        //  5192: astore          23
        //  5194: ldc_w           "arrayRightDivide conformance check... "
        //  5197: ldc             ""
        //  5199: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5202: goto            2313
        //  5205: astore          23
        //  5207: iload_3        
        //  5208: ldc_w           "arrayRightDivide... "
        //  5211: ldc_w           "(M./M != ones)"
        //  5214: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5217: istore_3       
        //  5218: goto            2337
        //  5221: astore          23
        //  5223: ldc_w           "arrayRightDivideEquals conformance check... "
        //  5226: ldc             ""
        //  5228: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5231: goto            2359
        //  5234: astore          6
        //  5236: iload_3        
        //  5237: ldc_w           "arrayRightDivideEquals... "
        //  5240: ldc_w           "(M./M != ones)"
        //  5243: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5246: istore_3       
        //  5247: goto            2382
        //  5250: astore_0       
        //  5251: ldc_w           "arrayTimes conformance check... "
        //  5254: ldc             ""
        //  5256: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5259: goto            2435
        //  5262: astore_0       
        //  5263: iload_3        
        //  5264: ldc_w           "arrayTimes... "
        //  5267: ldc_w           "(A = R, C = A.*B, but C./B != A)"
        //  5270: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5273: istore_3       
        //  5274: goto            2462
        //  5277: astore_0       
        //  5278: ldc_w           "arrayTimesEquals conformance check... "
        //  5281: ldc             ""
        //  5283: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5286: goto            2485
        //  5289: astore_0       
        //  5290: iload_3        
        //  5291: ldc_w           "arrayTimesEquals... "
        //  5294: ldc_w           "(A = R, A = A.*B, but A./B != R)"
        //  5297: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5300: istore_3       
        //  5301: goto            2513
        //  5304: iload_3        
        //  5305: ldc_w           "print()/read()..."
        //  5308: ldc_w           "Matrix read from file does not match Matrix printed to file"
        //  5311: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5314: istore          4
        //  5316: iload           4
        //  5318: istore_3       
        //  5319: goto            2621
        //  5322: astore_0       
        //  5323: iconst_0       
        //  5324: ldc_w           "print()/read()..."
        //  5327: ldc_w           "unexpected I/O error, unable to run print/read test;  check write permission in current directory and retry"
        //  5330: invokestatic    Jama/test/TestMatrix.try_warning:(ILjava/lang/String;Ljava/lang/String;)I
        //  5333: istore          5
        //  5335: iload_3        
        //  5336: istore          4
        //  5338: iload           5
        //  5340: istore_3       
        //  5341: goto            2630
        //  5344: astore_0       
        //  5345: aload_0        
        //  5346: getstatic       java/lang/System.out:Ljava/io/PrintStream;
        //  5349: invokevirtual   java/lang/Exception.printStackTrace:(Ljava/io/PrintStream;)V
        //  5352: iconst_0       
        //  5353: ldc_w           "print()/read()..."
        //  5356: ldc_w           "Formatting error... will try JDK1.1 reformulation..."
        //  5359: invokestatic    Jama/test/TestMatrix.try_warning:(ILjava/lang/String;Ljava/lang/String;)I
        //  5362: istore          4
        //  5364: new             Ljava/text/DecimalFormat;
        //  5367: dup            
        //  5368: ldc_w           "0.0000"
        //  5371: invokespecial   java/text/DecimalFormat.<init>:(Ljava/lang/String;)V
        //  5374: astore_0       
        //  5375: new             Ljava/io/PrintWriter;
        //  5378: dup            
        //  5379: new             Ljava/io/FileOutputStream;
        //  5382: dup            
        //  5383: ldc_w           "JamaTestMatrix.out"
        //  5386: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //  5389: invokespecial   java/io/PrintWriter.<init>:(Ljava/io/OutputStream;)V
        //  5392: astore          6
        //  5394: aload           22
        //  5396: aload           6
        //  5398: aload_0        
        //  5399: bipush          10
        //  5401: invokevirtual   Jama/Matrix.print:(Ljava/io/PrintWriter;Ljava/text/NumberFormat;I)V
        //  5404: aload           6
        //  5406: invokevirtual   java/io/PrintWriter.close:()V
        //  5409: aload           22
        //  5411: new             Ljava/io/BufferedReader;
        //  5414: dup            
        //  5415: new             Ljava/io/FileReader;
        //  5418: dup            
        //  5419: ldc_w           "JamaTestMatrix.out"
        //  5422: invokespecial   java/io/FileReader.<init>:(Ljava/lang/String;)V
        //  5425: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //  5428: invokestatic    Jama/Matrix.read:(Ljava/io/BufferedReader;)LJama/Matrix;
        //  5431: invokevirtual   Jama/Matrix.minus:(LJama/Matrix;)LJama/Matrix;
        //  5434: invokevirtual   Jama/Matrix.norm1:()D
        //  5437: ldc2_w          0.001
        //  5440: dcmpg          
        //  5441: ifge            5455
        //  5444: ldc_w           "print()/read()..."
        //  5447: ldc             ""
        //  5449: invokestatic    Jama/test/TestMatrix.try_success:(Ljava/lang/String;Ljava/lang/String;)V
        //  5452: goto            5902
        //  5455: iload_3        
        //  5456: ldc_w           "print()/read() (2nd attempt) ..."
        //  5459: ldc_w           "Matrix read from file does not match Matrix printed to file"
        //  5462: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5465: istore          5
        //  5467: iload           5
        //  5469: istore_3       
        //  5470: goto            5902
        //  5473: astore_0       
        //  5474: iconst_0       
        //  5475: istore          4
        //  5477: iload           4
        //  5479: ldc_w           "print()/read()..."
        //  5482: ldc_w           "unexpected I/O error, unable to run print/read test;  check write permission in current directory and retry"
        //  5485: invokestatic    Jama/test/TestMatrix.try_warning:(ILjava/lang/String;Ljava/lang/String;)I
        //  5488: istore          5
        //  5490: iload_3        
        //  5491: istore          4
        //  5493: iload           5
        //  5495: istore_3       
        //  5496: goto            2630
        //  5499: astore_0       
        //  5500: iload           4
        //  5502: ldc_w           "writeObject(Matrix)/readObject(Matrix)..."
        //  5505: ldc_w           "Matrix not serialized correctly"
        //  5508: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5511: istore          5
        //  5513: iload           5
        //  5515: istore          4
        //  5517: iload_3        
        //  5518: istore          5
        //  5520: goto            2707
        //  5523: astore_0       
        //  5524: iload_3        
        //  5525: ldc_w           "writeObject()/readObject()..."
        //  5528: ldc_w           "unexpected I/O error, unable to run serialization test;  check write permission in current directory and retry"
        //  5531: invokestatic    Jama/test/TestMatrix.try_warning:(ILjava/lang/String;Ljava/lang/String;)I
        //  5534: istore          5
        //  5536: goto            2707
        //  5539: astore_0       
        //  5540: iload           4
        //  5542: ldc_w           "writeObject(Matrix)/readObject(Matrix)..."
        //  5545: ldc_w           "unexpected error in serialization test"
        //  5548: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5551: istore          4
        //  5553: iload_3        
        //  5554: istore          5
        //  5556: goto            2707
        //  5559: astore          6
        //  5561: iload           4
        //  5563: ldc_w           "transpose()..."
        //  5566: ldc_w           "transpose unsuccessful"
        //  5569: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5572: istore          4
        //  5574: goto            2834
        //  5577: astore          6
        //  5579: iload           4
        //  5581: ldc_w           "norm1()..."
        //  5584: ldc_w           "incorrect norm calculation"
        //  5587: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5590: istore_3       
        //  5591: goto            2860
        //  5594: astore          6
        //  5596: iload_3        
        //  5597: ldc_w           "normInf()..."
        //  5600: ldc_w           "incorrect norm calculation"
        //  5603: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5606: istore_3       
        //  5607: goto            2878
        //  5610: astore          6
        //  5612: iload_3        
        //  5613: ldc_w           "normF()..."
        //  5616: ldc_w           "incorrect norm calculation"
        //  5619: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5622: istore_3       
        //  5623: goto            2899
        //  5626: astore          6
        //  5628: iload_3        
        //  5629: ldc_w           "trace()..."
        //  5632: ldc_w           "incorrect trace calculation"
        //  5635: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5638: istore_3       
        //  5639: goto            2917
        //  5642: astore          6
        //  5644: iload_3        
        //  5645: ldc_w           "det()..."
        //  5648: ldc_w           "incorrect determinant calculation"
        //  5651: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5654: istore_3       
        //  5655: goto            2950
        //  5658: astore          6
        //  5660: iload_3        
        //  5661: ldc_w           "times(Matrix)..."
        //  5664: ldc_w           "incorrect Matrix-Matrix product calculation"
        //  5667: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5670: istore_3       
        //  5671: goto            2999
        //  5674: astore_0       
        //  5675: iload_3        
        //  5676: ldc_w           "times(double)..."
        //  5679: ldc_w           "incorrect Matrix-scalar product calculation"
        //  5682: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5685: istore_3       
        //  5686: goto            3017
        //  5689: astore          6
        //  5691: iload_3        
        //  5692: ldc_w           "QRDecomposition..."
        //  5695: ldc_w           "incorrect QR decomposition calculation"
        //  5698: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5701: istore_3       
        //  5702: goto            3063
        //  5705: astore          6
        //  5707: iload_3        
        //  5708: ldc_w           "SingularValueDecomposition..."
        //  5711: ldc_w           "incorrect singular value decomposition calculation"
        //  5714: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5717: istore_3       
        //  5718: goto            3105
        //  5721: astore          6
        //  5723: iload_3        
        //  5724: ldc_w           "rank()..."
        //  5727: ldc_w           "incorrect rank calculation"
        //  5730: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5733: istore_3       
        //  5734: goto            3149
        //  5737: astore          6
        //  5739: iload_3        
        //  5740: ldc_w           "cond()..."
        //  5743: ldc_w           "incorrect condition number calculation"
        //  5746: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5749: istore_3       
        //  5750: goto            3232
        //  5753: astore          6
        //  5755: iload_3        
        //  5756: ldc_w           "LUDecomposition..."
        //  5759: ldc_w           "incorrect LU decomposition calculation"
        //  5762: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5765: istore_3       
        //  5766: goto            3304
        //  5769: astore_0       
        //  5770: iload_3        
        //  5771: ldc_w           "inverse()..."
        //  5774: ldc_w           "incorrect inverse calculation"
        //  5777: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5780: istore_3       
        //  5781: goto            3332
        //  5784: astore_0       
        //  5785: iload_3        
        //  5786: ldc_w           "solve()..."
        //  5789: aload_0        
        //  5790: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //  5793: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5796: istore_3       
        //  5797: goto            3426
        //  5800: astore_0       
        //  5801: iload_3        
        //  5802: ldc_w           "solve()..."
        //  5805: aload_0        
        //  5806: invokevirtual   java/lang/RuntimeException.getMessage:()Ljava/lang/String;
        //  5809: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5812: istore_3       
        //  5813: goto            3426
        //  5816: astore          12
        //  5818: iload_3        
        //  5819: ldc_w           "CholeskyDecomposition..."
        //  5822: ldc_w           "incorrect Cholesky decomposition calculation"
        //  5825: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5828: istore_3       
        //  5829: goto            3537
        //  5832: astore          6
        //  5834: iload_3        
        //  5835: ldc_w           "CholeskyDecomposition solve()..."
        //  5838: ldc_w           "incorrect Choleskydecomposition solve calculation"
        //  5841: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5844: istore_3       
        //  5845: goto            3571
        //  5848: astore_0       
        //  5849: iload_3        
        //  5850: ldc_w           "EigenvalueDecomposition (symmetric)..."
        //  5853: ldc_w           "incorrect symmetric Eigenvalue decomposition calculation"
        //  5856: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5859: istore_3       
        //  5860: goto            3615
        //  5863: astore_0       
        //  5864: iload_3        
        //  5865: ldc_w           "EigenvalueDecomposition (nonsymmetric)..."
        //  5868: ldc_w           "incorrect nonsymmetric Eigenvalue decomposition calculation"
        //  5871: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5874: istore_3       
        //  5875: goto            3763
        //  5878: astore_0       
        //  5879: iload_3        
        //  5880: ldc_w           "EigenvalueDecomposition (hang)..."
        //  5883: ldc_w           "incorrect termination"
        //  5886: invokestatic    Jama/test/TestMatrix.try_failure:(ILjava/lang/String;Ljava/lang/String;)I
        //  5889: istore_3       
        //  5890: goto            3817
        //  5893: astore_0       
        //  5894: goto            5477
        //  5897: astore          25
        //  5899: goto            4719
        //  5902: iload_3        
        //  5903: istore          5
        //  5905: iload           4
        //  5907: istore_3       
        //  5908: iload           5
        //  5910: istore          4
        //  5912: goto            2630
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                      
        //  -----  -----  -----  -----  ------------------------------------------
        //  605    626    3889   3904   Ljava/lang/IllegalArgumentException;
        //  629    644    3904   3920   Ljava/lang/IllegalArgumentException;
        //  629    644    3920   3936   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  644    655    3936   3952   Ljava/lang/IllegalArgumentException;
        //  644    655    3952   3968   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  825    842    3978   3993   Ljava/lang/RuntimeException;
        //  951    965    4023   4040   Ljava/lang/RuntimeException;
        //  972    986    4040   4056   Ljava/lang/RuntimeException;
        //  996    1088   4056   4071   Ljava/lang/RuntimeException;
        //  1088   1116   4071   4120   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1088   1116   4120   4134   Ljava/lang/IllegalArgumentException;
        //  1119   1170   4144   4159   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1234   1262   4159   4208   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1234   1262   4208   4222   Ljava/lang/IllegalArgumentException;
        //  1265   1276   4241   4256   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1276   1290   4222   4241   Ljava/lang/RuntimeException;
        //  1276   1290   4241   4256   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1290   1310   4256   4305   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1290   1310   4305   4319   Ljava/lang/IllegalArgumentException;
        //  1313   1324   4338   4353   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1324   1338   4319   4338   Ljava/lang/RuntimeException;
        //  1324   1338   4338   4353   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1338   1358   4353   4401   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1338   1358   4401   4415   Ljava/lang/IllegalArgumentException;
        //  1361   1371   4434   4449   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1371   1385   4415   4434   Ljava/lang/RuntimeException;
        //  1371   1385   4434   4449   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1385   1405   4449   4489   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1385   1405   4489   4503   Ljava/lang/IllegalArgumentException;
        //  1408   1418   4522   4537   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1418   1432   4503   4522   Ljava/lang/RuntimeException;
        //  1418   1432   4522   4537   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1432   1460   4537   4586   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1432   1460   4586   4600   Ljava/lang/IllegalArgumentException;
        //  1463   1479   4619   4634   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1479   1491   4600   4619   Ljava/lang/RuntimeException;
        //  1479   1491   4619   4634   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1503   1532   4634   4684   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1503   1532   4684   4698   Ljava/lang/IllegalArgumentException;
        //  1535   1546   4717   4719   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1546   1572   4698   4717   Ljava/lang/RuntimeException;
        //  1546   1572   4717   4719   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1572   1583   5897   5902   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1583   1612   4732   4774   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1583   1612   4774   4788   Ljava/lang/IllegalArgumentException;
        //  1618   1629   4806   4822   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1632   1651   4788   4806   Ljava/lang/RuntimeException;
        //  1632   1651   4806   4822   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1654   1661   4788   4806   Ljava/lang/RuntimeException;
        //  1654   1661   4806   4822   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1664   1675   4806   4822   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1675   1704   4822   4865   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1675   1704   4865   4880   Ljava/lang/IllegalArgumentException;
        //  1710   1720   4899   4916   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1723   1741   4880   4899   Ljava/lang/RuntimeException;
        //  1723   1741   4899   4916   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1744   1752   4880   4899   Ljava/lang/RuntimeException;
        //  1744   1752   4899   4916   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1755   1766   4899   4916   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1766   1787   4916   4959   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1766   1787   4959   4974   Ljava/lang/IllegalArgumentException;
        //  1790   1800   4993   5008   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1800   1826   4974   4993   Ljava/lang/RuntimeException;
        //  1800   1826   4993   5008   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  1862   1871   5008   5021   Ljava/lang/IllegalArgumentException;
        //  1874   1886   5008   5021   Ljava/lang/IllegalArgumentException;
        //  1952   1971   5032   5045   Ljava/lang/IllegalArgumentException;
        //  2034   2041   5056   5071   Ljava/lang/IllegalArgumentException;
        //  2044   2056   5056   5071   Ljava/lang/IllegalArgumentException;
        //  2059   2079   5071   5087   Ljava/lang/RuntimeException;
        //  2096   2115   5087   5100   Ljava/lang/IllegalArgumentException;
        //  2118   2133   5100   5116   Ljava/lang/RuntimeException;
        //  2140   2160   5116   5132   Ljava/lang/RuntimeException;
        //  2199   2206   5132   5147   Ljava/lang/IllegalArgumentException;
        //  2209   2221   5132   5147   Ljava/lang/IllegalArgumentException;
        //  2224   2239   5147   5163   Ljava/lang/RuntimeException;
        //  2239   2258   5163   5176   Ljava/lang/IllegalArgumentException;
        //  2269   2284   5176   5192   Ljava/lang/RuntimeException;
        //  2291   2310   5192   5205   Ljava/lang/IllegalArgumentException;
        //  2322   2337   5205   5221   Ljava/lang/RuntimeException;
        //  2337   2356   5221   5234   Ljava/lang/IllegalArgumentException;
        //  2367   2382   5234   5250   Ljava/lang/RuntimeException;
        //  2407   2414   5250   5262   Ljava/lang/IllegalArgumentException;
        //  2417   2429   5250   5262   Ljava/lang/IllegalArgumentException;
        //  2443   2462   5262   5277   Ljava/lang/RuntimeException;
        //  2462   2482   5277   5289   Ljava/lang/IllegalArgumentException;
        //  2493   2513   5289   5304   Ljava/lang/RuntimeException;
        //  2519   2621   5322   5344   Ljava/io/IOException;
        //  2519   2621   5344   5915   Ljava/lang/Exception;
        //  2644   2690   5523   5539   Ljava/io/IOException;
        //  2644   2690   5539   5559   Ljava/lang/Exception;
        //  2690   2704   5499   5523   Ljava/lang/RuntimeException;
        //  2690   2704   5523   5539   Ljava/io/IOException;
        //  2690   2704   5539   5559   Ljava/lang/Exception;
        //  2817   2834   5559   5577   Ljava/lang/RuntimeException;
        //  2839   2857   5577   5594   Ljava/lang/RuntimeException;
        //  2860   2878   5594   5610   Ljava/lang/RuntimeException;
        //  2878   2899   5610   5626   Ljava/lang/RuntimeException;
        //  2899   2917   5626   5642   Ljava/lang/RuntimeException;
        //  2917   2950   5642   5658   Ljava/lang/RuntimeException;
        //  2978   2999   5658   5674   Ljava/lang/RuntimeException;
        //  2999   3017   5674   5689   Ljava/lang/RuntimeException;
        //  3041   3063   5689   5705   Ljava/lang/RuntimeException;
        //  3069   3105   5705   5721   Ljava/lang/RuntimeException;
        //  3116   3149   5721   5737   Ljava/lang/RuntimeException;
        //  3193   3232   5737   5753   Ljava/lang/RuntimeException;
        //  3266   3304   5753   5769   Ljava/lang/RuntimeException;
        //  3310   3332   5769   5784   Ljava/lang/RuntimeException;
        //  3407   3426   5784   5800   Ljava/lang/IllegalArgumentException;
        //  3407   3426   5800   5816   Ljava/lang/RuntimeException;
        //  3515   3537   5816   5832   Ljava/lang/RuntimeException;
        //  3549   3571   5832   5848   Ljava/lang/RuntimeException;
        //  3591   3615   5848   5863   Ljava/lang/RuntimeException;
        //  3739   3763   5863   5878   Ljava/lang/RuntimeException;
        //  3763   3817   5878   5893   Ljava/lang/RuntimeException;
        //  4073   4101   4107   4120   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4134   4141   4144   4159   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4161   4189   4195   4208   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4224   4235   4241   4256   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4258   4286   4292   4305   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4321   4332   4338   4353   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4355   4382   4388   4401   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4417   4428   4434   4449   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4451   4470   4476   4489   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4505   4516   4522   4537   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4539   4567   4573   4586   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4602   4613   4619   4634   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4636   4665   4671   4684   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4700   4711   4717   4719   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4734   4755   4761   4774   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4793   4803   4806   4822   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4824   4846   4852   4865   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4885   4896   4899   4916   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4918   4940   4946   4959   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  4975   4987   4993   5008   Ljava/lang/ArrayIndexOutOfBoundsException;
        //  5304   5316   5322   5344   Ljava/io/IOException;
        //  5304   5316   5344   5915   Ljava/lang/Exception;
        //  5345   5364   5473   5477   Ljava/io/IOException;
        //  5364   5452   5893   5897   Ljava/io/IOException;
        //  5455   5467   5893   5897   Ljava/io/IOException;
        //  5500   5513   5523   5539   Ljava/io/IOException;
        //  5500   5513   5539   5559   Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 3115, Size: 3115
        //     at java.util.ArrayList.rangeCheck(Unknown Source)
        //     at java.util.ArrayList.get(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void print(final String s) {
        System.out.print(s);
    }
    
    private static void print(final double[] array, final int n, final int n2) {
        System.out.print("\n");
        new Matrix(array, 1).print(n, n2);
        print("\n");
    }
    
    private static int try_failure(final int n, final String s, final String s2) {
        print(">    " + s + "*** failure ***\n>      Message: " + s2 + "\n");
        return n + 1;
    }
    
    private static void try_success(final String s, final String s2) {
        print(">    " + s + "success\n");
        if (s2 != "") {
            print(">      Message: " + s2 + "\n");
        }
    }
    
    private static int try_warning(final int n, final String s, final String s2) {
        print(">    " + s + "*** warning ***\n>      Message: " + s2 + "\n");
        return n + 1;
    }
}

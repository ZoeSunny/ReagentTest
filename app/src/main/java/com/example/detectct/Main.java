package com.example.detectct;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.util.Log;

import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

public class Main
{
    private static int[] boxConvert(final double[] array, final Bitmap bitmap) {
        final double[] array2 = { 0.0, 0.0, array[2] * bitmap.getWidth(), array[3] * bitmap.getHeight() };
        array2[0] = array[0] * bitmap.getWidth() + 1.0 - array2[2] / 2.0;
        array2[1] = array[1] * bitmap.getHeight() + 1.0 - array2[3] / 2.0;
        array2[2] += array2[0];
        array2[3] += array2[1];
        final int[] array3 = new int[4];
        for (int i = 0; i < 4; ++i) {
            array3[i] = Integer.parseInt(new DecimalFormat("0").format(array2[i]));
        }
        return array3;
    }
    
    private static boolean checkIsImageFile(String lowerCase) {
        lowerCase = lowerCase.substring(lowerCase.lastIndexOf(".") + 1, lowerCase.length()).toLowerCase();
        return lowerCase.equals("jpg") || lowerCase.equals("png") || lowerCase.equals("gif") || lowerCase.equals("jpeg") || lowerCase.equals("bmp");
    }
    
    public static double computeValue(final String s, final int[] array) {
        final Detect detect = new Detect();
        final Mat detectCT = detect.detectCT(s, array);
        final int[][] segC = detect.getSegC();
        final int[][] segT = detect.getSegT();
        final int[] loc = detect.getLoc();
        System.out.println(loc[0] + " " + loc[1]);
        return new com.example.detectct.Compute_V(detectCT, loc, segC, segT, array, true).computeCT_method4();
    }
    
    public static void prepareHashTable(final String p0, final String p1, final ProgressDialog p2) {

        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static double startProcess(final ProgressDialog progressDialog, String string, final int n, final String s, final String s2, final double[] array) throws IOException {
        if (OpenCVLoader.initDebug()) {
            Log.i("CV", "Open CV Libraries loaded...");
        }
        if (n == 1) {
            string = "/sdcard/yolo/standardImg/" + s + "-" + s2;
            prepareHashTable(com.example.detectct.Tool.createFile(string, "HashTable.txt"), string, progressDialog);
            System.out.println("hhhhhhhhhhhhahahaha");
            progressDialog.dismiss();
            return -1000.0;
        }
        return startTest(string, "/sdcard/yolo/standardImg/" + s + "-" + s2 + "/HashTable.txt", array);
    }
    
    public static double startTest(final String s, final String s2, final double[] array) throws IOException {
//        Block_0: {
//            break Block_0;
//        Label_0088:
//            while (true) {
//
//                int[][] array2;
//                do{
//
//                       // int[][] array2;
//                        Label_0066:
//                        {
//                            break Label_0066;
//                            try {
//                                array2 = (int[][]) Array.newInstance(Integer.TYPE, 1, 4);
//                                for (int i = 0; i < 4; ++i) {
//                                    array2[0][i] = Integer.parseInt(new DecimalFormat("0").format(array[i]));
//                                }
//                                continue Label_0088;
//                                return testImage(s2, s, array2[0]);
//                            } catch (Exception ex) {
//                                ex.printStackTrace();
//                                return -200.0;
//                            }
//                        }
//                        continue Label_0088;
//
//                }while (array2[0][0] != 0 && array2[0][1] != 0 && array2[0][2] != 0 && array2[0][3] != 0);
//                break;
//            }
//        }
        return -3.0;
    }
    
    public static double testImage(final String s, final String s2, final int[] array) throws NumberFormatException, IOException {
        final double[][] array2 = (double[][])Array.newInstance(Double.TYPE, 51, 2);
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(s));
        int n = 0;
        while (true) {
            final String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            final String[] split = line.split("\t");
            array2[n][0] = Double.parseDouble(split[0]);
            array2[n][1] = Double.parseDouble(split[1]);
            ++n;
        }
        bufferedReader.close();
        System.out.println("filepath:" + s2);
        final double computeValue = computeValue(s2, array);
        System.out.println("result:" + computeValue);
        double n2 = 100.0;
        double n3 = -1.0;
        if (computeValue != -1.0 && computeValue != -2.0) {
            double abs;
            for (int i = 0; i < n; ++i, n2 = abs) {
                abs = n2;
                if (Math.abs(computeValue - array2[i][1]) < n2) {
                    abs = Math.abs(computeValue - array2[i][1]);
                    n3 = array2[i][0];
                }
            }
            return n3;
        }
        if (computeValue == -1.0) {
            return -1.0;
        }
        return -2.0;
    }
}

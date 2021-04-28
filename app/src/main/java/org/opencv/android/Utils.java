package org.opencv.android;

import android.graphics.*;
import android.content.*;
import org.opencv.core.*;
import java.io.*;
import org.opencv.imgcodecs.*;

public class Utils
{
    public static void bitmapToMat(final Bitmap bitmap, final Mat mat) {
        bitmapToMat(bitmap, mat, false);
    }
    
    public static void bitmapToMat(final Bitmap bitmap, final Mat mat, final boolean b) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        nBitmapToMat2(bitmap, mat.nativeObj, b);
    }
    
    public static String exportResource(final Context context, final int n) throws IOException {
        return exportResource(context, n, "OpenCV_data");
    }
    
    public static String exportResource(final Context context, int read, final String s) throws IOException {
        final String string = context.getResources().getString(read);
        final String substring = string.substring(string.lastIndexOf("/") + 1);
        InputStream openRawResource;
        File file;
        FileOutputStream fileOutputStream;
        try {
            openRawResource = context.getResources().openRawResource(read);
            file = new File(context.getDir(s, 0), substring);
            fileOutputStream = new FileOutputStream(file);
            final byte[] array = new byte[4096];
            while (true) {
                read = openRawResource.read(array);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(array, 0, read);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
            throw new CvException("Failed to export resource " + substring + ". Exception thrown: " + ex);
        }
        openRawResource.close();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }
    
    public static Mat loadResource(final Context context, final int n) throws IOException {
        return loadResource(context, n, -1);
    }
    
    public static Mat loadResource(final Context context, int read, final int n) throws IOException {
        final InputStream openRawResource = context.getResources().openRawResource(read);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(openRawResource.available());
        final byte[] array = new byte[4096];
        while (true) {
            read = openRawResource.read(array);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(array, 0, read);
        }
        openRawResource.close();
        final Mat mat = new Mat(1, byteArrayOutputStream.size(), 0);
        mat.put(0, 0, byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        final Mat imdecode = Imgcodecs.imdecode(mat, n);
        mat.release();
        return imdecode;
    }
    
    public static void matToBitmap(final Mat mat, final Bitmap bitmap) {
        matToBitmap(mat, bitmap, false);
    }
    
    public static void matToBitmap(final Mat mat, final Bitmap bitmap, final boolean b) {
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        nMatToBitmap2(mat.nativeObj, bitmap, b);
    }
    
    private static native void nBitmapToMat2(final Bitmap p0, final long p1, final boolean p2);
    
    private static native void nMatToBitmap2(final long p0, final Bitmap p1, final boolean p2);
}

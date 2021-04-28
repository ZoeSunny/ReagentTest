package com.example.reagent20;


import android.os.*;
import android.util.*;
import java.text.*;
import java.util.*;
import java.io.*;
import android.graphics.*;

public class SaveImage
{
    String PHOTO_FOLDER;
    private Bitmap bitmap;
    private File file;
    private String filePath;

    SaveImage(final Bitmap bitmap, final boolean b, final String s, final String s2) {
        this.bitmap = bitmap;
        if (b) {
            this.PHOTO_FOLDER = new File(Environment.getExternalStorageDirectory(), "").getPath() + "/yolo/standardImg/" + s + "-" + s2 + "/";
        }
        else {
            this.PHOTO_FOLDER = new File(Environment.getExternalStorageDirectory(), "").getPath() + "/yolo/testImg/" + s + "-" + s2 + "/";
        }
        final File file = new File(this.PHOTO_FOLDER);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
    }

    public String save() {
        Log.i("ContentValues", "Environment.getExternalStorageDirectory()=" + Environment.getExternalStorageDirectory());
        final String string = this.PHOTO_FOLDER + new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date());
        try {
            this.filePath = string + ".jpg";
            this.file = new File(this.filePath);
            if (!this.file.exists()) {
                this.file.createNewFile();
            }
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.file));
            this.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return string;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return string;
        }
    }

    public String save(String string) {
        Log.i("ContentValues", "Environment.getExternalStorageDirectory()=" + Environment.getExternalStorageDirectory());
        string = this.PHOTO_FOLDER + string;
        System.out.println("standatdValue4444:" + string);
        try {
            this.filePath = string + ".jpg";
            this.file = new File(this.filePath);
            if (!this.file.exists()) {
                this.file.createNewFile();
            }
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.file));
            this.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return string;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return string;
        }
    }
}

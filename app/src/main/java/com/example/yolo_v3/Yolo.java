package com.example.yolo_v3;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;

public class Yolo
{
    private static final int COPY_FALSE = -1;
    private static final int DETECT_FINISH = 1;
    private static final int RESULT_LOAD_IMAGE = 3;
    private static final String TAG = "Yolo";
    Bitmap dstimg;
    Bitmap srcimg;
    String srcimgpath;
    ImageView view_dstimg;
    ImageView view_srcimg;
    TextView view_status;
    
    static {
        System.loadLibrary("darknetlib");
    }
    
    private void staticLoadCVLibraries() {
        if (OpenCVLoader.initDebug()) {
            Log.i("CV", "Open CV Libraries loaded...");
        }
    }
    
    public native boolean detectimg(final Bitmap p0, final Bitmap p1);
    
    public native void inityolo(final String p0, final String p1);
    
    public native double[] testyolo(final String p0);
}

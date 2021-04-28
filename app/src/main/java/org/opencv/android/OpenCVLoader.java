package org.opencv.android;

import android.content.*;

public class OpenCVLoader
{
    public static final String OPENCV_VERSION_2_4_10 = "2.4.10";
    public static final String OPENCV_VERSION_2_4_11 = "2.4.11";
    public static final String OPENCV_VERSION_2_4_2 = "2.4.2";
    public static final String OPENCV_VERSION_2_4_3 = "2.4.3";
    public static final String OPENCV_VERSION_2_4_4 = "2.4.4";
    public static final String OPENCV_VERSION_2_4_5 = "2.4.5";
    public static final String OPENCV_VERSION_2_4_6 = "2.4.6";
    public static final String OPENCV_VERSION_2_4_7 = "2.4.7";
    public static final String OPENCV_VERSION_2_4_8 = "2.4.8";
    public static final String OPENCV_VERSION_2_4_9 = "2.4.9";
    public static final String OPENCV_VERSION_3_0_0 = "3.0.0";
    public static final String OPENCV_VERSION_3_1_0 = "3.1.0";
    
    public static boolean initAsync(final String s, final Context context, final LoaderCallbackInterface loaderCallbackInterface) {
        return AsyncServiceHelper.initOpenCV(s, context, loaderCallbackInterface);
    }
    
    public static boolean initDebug() {
        return StaticHelper.initOpenCV(false);
    }
    
    public static boolean initDebug(final boolean b) {
        return StaticHelper.initOpenCV(b);
    }
}

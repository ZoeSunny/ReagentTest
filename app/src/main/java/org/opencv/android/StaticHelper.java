package org.opencv.android;

import android.util.*;
import org.opencv.core.*;
import java.util.*;

class StaticHelper
{
    private static final String TAG = "OpenCV/StaticHelper";
    
    private static native String getLibraryList();
    
    public static boolean initOpenCV(final boolean b) {
        Object o = "";
        if (b) {
            loadLibrary("cudart");
            loadLibrary("nppc");
            loadLibrary("nppi");
            loadLibrary("npps");
            loadLibrary("cufft");
            loadLibrary("cublas");
        }
        Log.d("OpenCV/StaticHelper", "Trying to get library list");
        Label_0172: {
            while (true) {
                try {
                    System.loadLibrary("opencv_info");
                    o = getLibraryList();
                    Log.d("OpenCV/StaticHelper", "Library list: \"" + (String)o + "\"");
                    Log.d("OpenCV/StaticHelper", "First attempt to load libs");
                    if (!initOpenCVLibs((String)o)) {
                        break Label_0172;
                    }
                    Log.d("OpenCV/StaticHelper", "First attempt to load libs is OK");
                    o = System.getProperty("line.separator");
                    o = Core.getBuildInformation().split((String)o);
                    for (int length = ((String)o).length(), i = 0; i < length; ++i) {
                       // Log.i("OpenCV/StaticHelper", o[i]);
                    }
                }
                catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                    Log.e("OpenCV/StaticHelper", "OpenCV error: Cannot load info library for OpenCV");
                    continue;
                }
                break;
            }
            return true;
        }
        Log.d("OpenCV/StaticHelper", "First attempt to load libs fails");
        return false;
    }
    
    private static boolean initOpenCVLibs(final String s) {
        Log.d("OpenCV/StaticHelper", "Trying to init OpenCV libs");
        int n = 1;
        boolean b;
        if (s != null && s.length() != 0) {
            Log.d("OpenCV/StaticHelper", "Trying to load libs by dependency list");
            final StringTokenizer stringTokenizer = new StringTokenizer(s, ";");
            while (true) {
                b = (n != 0);
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                n &= (loadLibrary(stringTokenizer.nextToken()) ? 1 : 0);
            }
        }
        else {
            b = (true & loadLibrary("opencv_java3"));
        }
        return b;
    }
    
    private static boolean loadLibrary(final String s) {
        Log.d("OpenCV/StaticHelper", "Trying to load library " + s);
        try {
            System.loadLibrary(s);
            Log.d("OpenCV/StaticHelper", "Library " + s + " loaded");
            return true;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            Log.d("OpenCV/StaticHelper", "Cannot load library \"" + s + "\"");
            unsatisfiedLinkError.printStackTrace();
            return true & false;
        }
    }
}

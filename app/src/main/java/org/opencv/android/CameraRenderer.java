package org.opencv.android;

import android.annotation.*;
import android.util.*;
import android.hardware.*;
import java.util.*;

@TargetApi(15)
public class CameraRenderer extends CameraGLRendererBase
{
    public static final String LOGTAG = "CameraRenderer";
    private Camera mCamera;
    private boolean mPreviewStarted;
    
    CameraRenderer(final CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.mPreviewStarted = false;
    }
    
    @Override
    protected void closeCamera() {
        synchronized (this) {
            Log.i("CameraRenderer", "closeCamera");
            if (this.mCamera != null) {
                this.mCamera.stopPreview();
                this.mPreviewStarted = false;
                this.mCamera.release();
                this.mCamera = null;
            }
        }
    }
    
    @Override
    protected void openCamera(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: ldc             "CameraRenderer"
        //     4: ldc             "openCamera"
        //     6: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //     9: pop            
        //    10: aload_0        
        //    11: invokevirtual   org/opencv/android/CameraRenderer.closeCamera:()V
        //    14: iload_1        
        //    15: iconst_m1      
        //    16: if_icmpne       206
        //    19: ldc             "CameraRenderer"
        //    21: ldc             "Trying to open camera with old open()"
        //    23: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //    26: pop            
        //    27: aload_0        
        //    28: invokestatic    android/hardware/Camera.open:()Landroid/hardware/Camera;
        //    31: putfield        org/opencv/android/CameraRenderer.mCamera:Landroid/hardware/Camera;
        //    34: aload_0        
        //    35: getfield        org/opencv/android/CameraRenderer.mCamera:Landroid/hardware/Camera;
        //    38: ifnonnull       104
        //    41: getstatic       android/os/Build.VERSION.SDK_INT:I
        //    44: bipush          9
        //    46: if_icmplt       104
        //    49: iconst_0       
        //    50: istore_2       
        //    51: iconst_0       
        //    52: istore_1       
        //    53: iload_1        
        //    54: invokestatic    android/hardware/Camera.getNumberOfCameras:()I
        //    57: if_icmpge       104
        //    60: ldc             "CameraRenderer"
        //    62: new             Ljava/lang/StringBuilder;
        //    65: dup            
        //    66: invokespecial   java/lang/StringBuilder.<init>:()V
        //    69: ldc             "Trying to open camera with new open("
        //    71: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    74: iload_1        
        //    75: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    78: ldc             ")"
        //    80: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    83: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    86: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //    89: pop            
        //    90: aload_0        
        //    91: iload_1        
        //    92: invokestatic    android/hardware/Camera.open:(I)Landroid/hardware/Camera;
        //    95: putfield        org/opencv/android/CameraRenderer.mCamera:Landroid/hardware/Camera;
        //    98: iconst_1       
        //    99: istore_2       
        //   100: iload_2        
        //   101: ifeq            546
        //   104: aload_0        
        //   105: getfield        org/opencv/android/CameraRenderer.mCamera:Landroid/hardware/Camera;
        //   108: ifnonnull       449
        //   111: ldc             "CameraRenderer"
        //   113: ldc             "Error: can't open camera"
        //   115: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   118: pop            
        //   119: aload_0        
        //   120: monitorexit    
        //   121: return         
        //   122: astore          4
        //   124: ldc             "CameraRenderer"
        //   126: new             Ljava/lang/StringBuilder;
        //   129: dup            
        //   130: invokespecial   java/lang/StringBuilder.<init>:()V
        //   133: ldc             "Camera is not available (in use or does not exist): "
        //   135: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   138: aload           4
        //   140: invokevirtual   java/lang/Exception.getLocalizedMessage:()Ljava/lang/String;
        //   143: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   146: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   149: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   152: pop            
        //   153: goto            34
        //   156: astore          4
        //   158: aload_0        
        //   159: monitorexit    
        //   160: aload           4
        //   162: athrow         
        //   163: astore          4
        //   165: ldc             "CameraRenderer"
        //   167: new             Ljava/lang/StringBuilder;
        //   170: dup            
        //   171: invokespecial   java/lang/StringBuilder.<init>:()V
        //   174: ldc             "Camera #"
        //   176: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: iload_1        
        //   180: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   183: ldc             "failed to open: "
        //   185: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: aload           4
        //   190: invokevirtual   java/lang/RuntimeException.getLocalizedMessage:()Ljava/lang/String;
        //   193: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   196: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   199: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   202: pop            
        //   203: goto            100
        //   206: getstatic       android/os/Build.VERSION.SDK_INT:I
        //   209: bipush          9
        //   211: if_icmplt       104
        //   214: aload_0        
        //   215: getfield        org/opencv/android/CameraRenderer.mCameraIndex:I
        //   218: istore_3       
        //   219: aload_0        
        //   220: getfield        org/opencv/android/CameraRenderer.mCameraIndex:I
        //   223: bipush          99
        //   225: if_icmpne       289
        //   228: ldc             "CameraRenderer"
        //   230: ldc             "Trying to open BACK camera"
        //   232: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   235: pop            
        //   236: new             Landroid/hardware/Camera.CameraInfo;
        //   239: dup            
        //   240: invokespecial   android/hardware/Camera.CameraInfo.<init>:()V
        //   243: astore          4
        //   245: iconst_0       
        //   246: istore_2       
        //   247: iload_3        
        //   248: istore_1       
        //   249: iload_2        
        //   250: invokestatic    android/hardware/Camera.getNumberOfCameras:()I
        //   253: if_icmpge       272
        //   256: iload_2        
        //   257: aload           4
        //   259: invokestatic    android/hardware/Camera.getCameraInfo:(ILandroid/hardware/Camera.CameraInfo;)V
        //   262: aload           4
        //   264: getfield        android/hardware/Camera.CameraInfo.facing:I
        //   267: ifne            553
        //   270: iload_2        
        //   271: istore_1       
        //   272: iload_1        
        //   273: bipush          99
        //   275: if_icmpne       348
        //   278: ldc             "CameraRenderer"
        //   280: ldc             "Back camera not found!"
        //   282: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   285: pop            
        //   286: goto            104
        //   289: iload_3        
        //   290: istore_1       
        //   291: aload_0        
        //   292: getfield        org/opencv/android/CameraRenderer.mCameraIndex:I
        //   295: bipush          98
        //   297: if_icmpne       272
        //   300: ldc             "CameraRenderer"
        //   302: ldc             "Trying to open FRONT camera"
        //   304: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   307: pop            
        //   308: new             Landroid/hardware/Camera.CameraInfo;
        //   311: dup            
        //   312: invokespecial   android/hardware/Camera.CameraInfo.<init>:()V
        //   315: astore          4
        //   317: iconst_0       
        //   318: istore_2       
        //   319: iload_3        
        //   320: istore_1       
        //   321: iload_2        
        //   322: invokestatic    android/hardware/Camera.getNumberOfCameras:()I
        //   325: if_icmpge       272
        //   328: iload_2        
        //   329: aload           4
        //   331: invokestatic    android/hardware/Camera.getCameraInfo:(ILandroid/hardware/Camera.CameraInfo;)V
        //   334: aload           4
        //   336: getfield        android/hardware/Camera.CameraInfo.facing:I
        //   339: iconst_1       
        //   340: if_icmpne       560
        //   343: iload_2        
        //   344: istore_1       
        //   345: goto            272
        //   348: iload_1        
        //   349: bipush          98
        //   351: if_icmpne       365
        //   354: ldc             "CameraRenderer"
        //   356: ldc             "Front camera not found!"
        //   358: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   361: pop            
        //   362: goto            104
        //   365: ldc             "CameraRenderer"
        //   367: new             Ljava/lang/StringBuilder;
        //   370: dup            
        //   371: invokespecial   java/lang/StringBuilder.<init>:()V
        //   374: ldc             "Trying to open camera with new open("
        //   376: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   379: iload_1        
        //   380: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   383: ldc             ")"
        //   385: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   388: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   391: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   394: pop            
        //   395: aload_0        
        //   396: iload_1        
        //   397: invokestatic    android/hardware/Camera.open:(I)Landroid/hardware/Camera;
        //   400: putfield        org/opencv/android/CameraRenderer.mCamera:Landroid/hardware/Camera;
        //   403: goto            104
        //   406: astore          4
        //   408: ldc             "CameraRenderer"
        //   410: new             Ljava/lang/StringBuilder;
        //   413: dup            
        //   414: invokespecial   java/lang/StringBuilder.<init>:()V
        //   417: ldc             "Camera #"
        //   419: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   422: iload_1        
        //   423: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   426: ldc             "failed to open: "
        //   428: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   431: aload           4
        //   433: invokevirtual   java/lang/RuntimeException.getLocalizedMessage:()Ljava/lang/String;
        //   436: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   439: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   442: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   445: pop            
        //   446: goto            104
        //   449: aload_0        
        //   450: getfield        org/opencv/android/CameraRenderer.mCamera:Landroid/hardware/Camera;
        //   453: invokevirtual   android/hardware/Camera.getParameters:()Landroid/hardware/Camera.Parameters;
        //   456: astore          4
        //   458: aload           4
        //   460: invokevirtual   android/hardware/Camera.Parameters.getSupportedFocusModes:()Ljava/util/List;
        //   463: astore          5
        //   465: aload           5
        //   467: ifnull          489
        //   470: aload           5
        //   472: ldc             "continuous-video"
        //   474: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   479: ifeq            489
        //   482: aload           4
        //   484: ldc             "continuous-video"
        //   486: invokevirtual   android/hardware/Camera.Parameters.setFocusMode:(Ljava/lang/String;)V
        //   489: aload_0        
        //   490: getfield        org/opencv/android/CameraRenderer.mCamera:Landroid/hardware/Camera;
        //   493: aload           4
        //   495: invokevirtual   android/hardware/Camera.setParameters:(Landroid/hardware/Camera.Parameters;)V
        //   498: aload_0        
        //   499: getfield        org/opencv/android/CameraRenderer.mCamera:Landroid/hardware/Camera;
        //   502: aload_0        
        //   503: getfield        org/opencv/android/CameraRenderer.mSTexture:Landroid/graphics/SurfaceTexture;
        //   506: invokevirtual   android/hardware/Camera.setPreviewTexture:(Landroid/graphics/SurfaceTexture;)V
        //   509: goto            119
        //   512: astore          4
        //   514: ldc             "CameraRenderer"
        //   516: new             Ljava/lang/StringBuilder;
        //   519: dup            
        //   520: invokespecial   java/lang/StringBuilder.<init>:()V
        //   523: ldc             "setPreviewTexture() failed: "
        //   525: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   528: aload           4
        //   530: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   533: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   536: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   539: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   542: pop            
        //   543: goto            119
        //   546: iload_1        
        //   547: iconst_1       
        //   548: iadd           
        //   549: istore_1       
        //   550: goto            53
        //   553: iload_2        
        //   554: iconst_1       
        //   555: iadd           
        //   556: istore_2       
        //   557: goto            247
        //   560: iload_2        
        //   561: iconst_1       
        //   562: iadd           
        //   563: istore_2       
        //   564: goto            319
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  2      14     156    163    Any
        //  19     27     156    163    Any
        //  27     34     122    156    Ljava/lang/Exception;
        //  27     34     156    163    Any
        //  34     49     156    163    Any
        //  53     90     156    163    Any
        //  90     98     163    206    Ljava/lang/RuntimeException;
        //  90     98     156    163    Any
        //  104    119    156    163    Any
        //  124    153    156    163    Any
        //  165    203    156    163    Any
        //  206    245    156    163    Any
        //  249    270    156    163    Any
        //  278    286    156    163    Any
        //  291    317    156    163    Any
        //  321    343    156    163    Any
        //  354    362    156    163    Any
        //  365    395    156    163    Any
        //  395    403    406    449    Ljava/lang/RuntimeException;
        //  395    403    156    163    Any
        //  408    446    156    163    Any
        //  449    465    156    163    Any
        //  470    489    156    163    Any
        //  489    498    156    163    Any
        //  498    509    512    546    Ljava/io/IOException;
        //  498    509    156    163    Any
        //  514    543    156    163    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0100:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
        //     at us.deathmarine.luyten.FileSaver.access.300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver.4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void setCameraPreviewSize(int width, int height) {
        int mMaxCameraWidth;
        int mMaxCameraHeight;
        Camera.Parameters parameters;
        List<Camera.Size> supportedPreviewSizes;
        float n;
        int width2;
        int height2;
        Block_17_Outer:Label_0282_Outer:
        while (true) {
        Label_0422_Outer:
            while (true) {
                while (true) {
                Label_0346:
                    while (true) {
                        synchronized (this) {
                            Log.i("CameraRenderer", "setCameraPreviewSize: " + width + "x" + height);
                            while (true) {
                                while (true) {
                                    if (this.mCamera == null) {
                                        Log.e("CameraRenderer", "Camera isn't initialized!");
                                    }
                                    else {
                                        mMaxCameraWidth = width;
                                        if (this.mMaxCameraWidth > 0 && this.mMaxCameraWidth < (mMaxCameraWidth = width)) {
                                            mMaxCameraWidth = this.mMaxCameraWidth;
                                        }
                                        mMaxCameraHeight = height;
                                        if (this.mMaxCameraHeight > 0 && this.mMaxCameraHeight < (mMaxCameraHeight = height)) {
                                            mMaxCameraHeight = this.mMaxCameraHeight;
                                        }
                                        parameters = this.mCamera.getParameters();
                                        supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                                        width = 0;
                                        height = 0;
                                        if (supportedPreviewSizes.size() > 0) {
                                            n = mMaxCameraWidth / (float)mMaxCameraHeight;
                                            for (final Camera.Size cameraSize : supportedPreviewSizes) {
                                                width2 = cameraSize.width;
                                                height2 = cameraSize.height;
                                                Log.d("CameraRenderer", "checking camera preview size: " + width2 + "x" + height2);
                                                if (width2 <= mMaxCameraWidth && height2 <= mMaxCameraHeight && width2 >= width && height2 >= height && Math.abs(n - width2 / (float)height2) < 0.2) {
                                                    width = width2;
                                                    height = height2;
                                                }
                                            }
                                            break Label_0346;
                                        }
                                        parameters.set("orientation", "landscape");
                                        this.mCamera.setParameters(parameters);
                                        this.mCamera.startPreview();
                                        this.mPreviewStarted = true;
                                    }
                                    return;
                                    //this.mCamera.stopPreview();
                                    //this.mPreviewStarted = false;
//                                    Label_0365: {
//                                        //break Label_0365;
//                                        width = supportedPreviewSizes.get(0).width;
//                                        height = supportedPreviewSizes.get(0).height;
//                                        Log.e("CameraRenderer", "Error: best size was not selected, using " + width + " x " + height);
//                                        break Label_0346;
//                                    }
                                   // parameters.setPreviewSize(this.mCameraWidth = width, this.mCameraHeight = height);
                                    //continue Label_0282_Outer;
                                }
                               // continue Label_0282_Outer;
                            }
                        }
                        // iftrue(Label_0365:, !this.mPreviewStarted)
                       // Log.i("CameraRenderer", "Selected best size: " + width + " x " + height);
                       // continue Label_0346;
                    }
                    if (width > 0 && height > 0) {
                        continue;
                    }
                    break;
                }
                continue Label_0422_Outer;
            }
        }
    }
}

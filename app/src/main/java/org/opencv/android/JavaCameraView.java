package org.opencv.android;

import org.opencv.core.*;
import android.graphics.*;
import android.content.*;
import android.hardware.Camera;
import android.util.*;
import org.opencv.imgproc.*;
import android.hardware.*;

public class JavaCameraView extends CameraBridgeViewBase implements Camera.PreviewCallback
{
    private static final int MAGIC_TEXTURE_ID = 10;
    private static final String TAG = "JavaCameraView";
    private byte[] mBuffer;
    protected Camera mCamera;
    protected JavaCameraFrame[] mCameraFrame;
    private boolean mCameraFrameReady;
    private int mChainIdx;
    private Mat[] mFrameChain;
    private boolean mStopThread;
    private SurfaceTexture mSurfaceTexture;
    private Thread mThread;
    
    public JavaCameraView(final Context context, final int n) {
        super(context, n);
        this.mChainIdx = 0;
        this.mCameraFrameReady = false;
    }
    
    public JavaCameraView(final Context context, final AttributeSet set) {
        super(context, set);
        this.mChainIdx = 0;
        this.mCameraFrameReady = false;
    }
    
    @Override
    protected boolean connectCamera(final int n, final int n2) {
        Log.d("JavaCameraView", "Connecting to camera");
        if (!this.initializeCamera(n, n2)) {
            return false;
        }
        this.mCameraFrameReady = false;
        Log.d("JavaCameraView", "Starting processing thread");
        this.mStopThread = false;
        (this.mThread = new Thread(new CameraWorker())).start();
        return true;
    }
    
    @Override
    protected void disconnectCamera() {
        Log.d("JavaCameraView", "Disconnecting from camera");
        try {
            this.mStopThread = true;
            Log.d("JavaCameraView", "Notify thread");
            synchronized (this) {
                this.notify();
                // monitorexit(this)
                Log.d("JavaCameraView", "Wating for thread");
                if (this.mThread != null) {
                    this.mThread.join();
                }
                this.mThread = null;
                this.releaseCamera();
                this.mCameraFrameReady = false;
            }
        }
        catch (InterruptedException ex) {
            try {
                ex.printStackTrace();
            }
            finally {
                this.mThread = null;
            }
        }
    }
    
    protected boolean initializeCamera(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ldc             "Initialize java camera"
        //     4: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //     7: pop            
        //     8: iconst_1       
        //     9: istore          6
        //    11: aload_0        
        //    12: monitorenter   
        //    13: aload_0        
        //    14: aconst_null    
        //    15: putfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //    18: aload_0        
        //    19: getfield        org/opencv/android/JavaCameraView.mCameraIndex:I
        //    22: iconst_m1      
        //    23: if_icmpne       212
        //    26: ldc             "JavaCameraView"
        //    28: ldc             "Trying to open camera with old open()"
        //    30: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //    33: pop            
        //    34: aload_0        
        //    35: invokestatic    android/hardware/Camera.open:()Landroid/hardware/Camera;
        //    38: putfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //    41: aload_0        
        //    42: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //    45: ifnonnull       117
        //    48: getstatic       android/os/Build.VERSION.SDK_INT:I
        //    51: bipush          9
        //    53: if_icmplt       117
        //    56: iconst_0       
        //    57: istore          4
        //    59: iconst_0       
        //    60: istore_3       
        //    61: iload_3        
        //    62: invokestatic    android/hardware/Camera.getNumberOfCameras:()I
        //    65: if_icmpge       117
        //    68: ldc             "JavaCameraView"
        //    70: new             Ljava/lang/StringBuilder;
        //    73: dup            
        //    74: invokespecial   java/lang/StringBuilder.<init>:()V
        //    77: ldc             "Trying to open camera with new open("
        //    79: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    82: iload_3        
        //    83: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    86: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    89: ldc             ")"
        //    91: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    94: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    97: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   100: pop            
        //   101: aload_0        
        //   102: iload_3        
        //   103: invokestatic    android/hardware/Camera.open:(I)Landroid/hardware/Camera;
        //   106: putfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   109: iconst_1       
        //   110: istore          4
        //   112: iload           4
        //   114: ifeq            1037
        //   117: aload_0        
        //   118: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   121: ifnonnull       470
        //   124: aload_0        
        //   125: monitorexit    
        //   126: iconst_0       
        //   127: ireturn        
        //   128: astore          7
        //   130: ldc             "JavaCameraView"
        //   132: new             Ljava/lang/StringBuilder;
        //   135: dup            
        //   136: invokespecial   java/lang/StringBuilder.<init>:()V
        //   139: ldc             "Camera is not available (in use or does not exist): "
        //   141: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   144: aload           7
        //   146: invokevirtual   java/lang/Exception.getLocalizedMessage:()Ljava/lang/String;
        //   149: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   155: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   158: pop            
        //   159: goto            41
        //   162: astore          7
        //   164: aload_0        
        //   165: monitorexit    
        //   166: aload           7
        //   168: athrow         
        //   169: astore          7
        //   171: ldc             "JavaCameraView"
        //   173: new             Ljava/lang/StringBuilder;
        //   176: dup            
        //   177: invokespecial   java/lang/StringBuilder.<init>:()V
        //   180: ldc             "Camera #"
        //   182: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   185: iload_3        
        //   186: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   189: ldc             "failed to open: "
        //   191: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   194: aload           7
        //   196: invokevirtual   java/lang/RuntimeException.getLocalizedMessage:()Ljava/lang/String;
        //   199: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   202: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   205: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   208: pop            
        //   209: goto            112
        //   212: getstatic       android/os/Build.VERSION.SDK_INT:I
        //   215: bipush          9
        //   217: if_icmplt       117
        //   220: aload_0        
        //   221: getfield        org/opencv/android/JavaCameraView.mCameraIndex:I
        //   224: istore          5
        //   226: aload_0        
        //   227: getfield        org/opencv/android/JavaCameraView.mCameraIndex:I
        //   230: bipush          99
        //   232: if_icmpne       301
        //   235: ldc             "JavaCameraView"
        //   237: ldc             "Trying to open back camera"
        //   239: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   242: pop            
        //   243: new             Landroid/hardware/Camera.CameraInfo;
        //   246: dup            
        //   247: invokespecial   android/hardware/Camera.CameraInfo.<init>:()V
        //   250: astore          7
        //   252: iconst_0       
        //   253: istore          4
        //   255: iload           5
        //   257: istore_3       
        //   258: iload           4
        //   260: invokestatic    android/hardware/Camera.getNumberOfCameras:()I
        //   263: if_icmpge       284
        //   266: iload           4
        //   268: aload           7
        //   270: invokestatic    android/hardware/Camera.getCameraInfo:(ILandroid/hardware/Camera.CameraInfo;)V
        //   273: aload           7
        //   275: getfield        android/hardware/Camera.CameraInfo.facing:I
        //   278: ifne            1044
        //   281: iload           4
        //   283: istore_3       
        //   284: iload_3        
        //   285: bipush          99
        //   287: if_icmpne       366
        //   290: ldc             "JavaCameraView"
        //   292: ldc             "Back camera not found!"
        //   294: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   297: pop            
        //   298: goto            117
        //   301: iload           5
        //   303: istore_3       
        //   304: aload_0        
        //   305: getfield        org/opencv/android/JavaCameraView.mCameraIndex:I
        //   308: bipush          98
        //   310: if_icmpne       284
        //   313: ldc             "JavaCameraView"
        //   315: ldc             "Trying to open front camera"
        //   317: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   320: pop            
        //   321: new             Landroid/hardware/Camera.CameraInfo;
        //   324: dup            
        //   325: invokespecial   android/hardware/Camera.CameraInfo.<init>:()V
        //   328: astore          7
        //   330: iconst_0       
        //   331: istore          4
        //   333: iload           5
        //   335: istore_3       
        //   336: iload           4
        //   338: invokestatic    android/hardware/Camera.getNumberOfCameras:()I
        //   341: if_icmpge       284
        //   344: iload           4
        //   346: aload           7
        //   348: invokestatic    android/hardware/Camera.getCameraInfo:(ILandroid/hardware/Camera.CameraInfo;)V
        //   351: aload           7
        //   353: getfield        android/hardware/Camera.CameraInfo.facing:I
        //   356: iconst_1       
        //   357: if_icmpne       1053
        //   360: iload           4
        //   362: istore_3       
        //   363: goto            284
        //   366: iload_3        
        //   367: bipush          98
        //   369: if_icmpne       383
        //   372: ldc             "JavaCameraView"
        //   374: ldc             "Front camera not found!"
        //   376: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   379: pop            
        //   380: goto            117
        //   383: ldc             "JavaCameraView"
        //   385: new             Ljava/lang/StringBuilder;
        //   388: dup            
        //   389: invokespecial   java/lang/StringBuilder.<init>:()V
        //   392: ldc             "Trying to open camera with new open("
        //   394: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   397: iload_3        
        //   398: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   401: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   404: ldc             ")"
        //   406: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   409: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   412: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   415: pop            
        //   416: aload_0        
        //   417: iload_3        
        //   418: invokestatic    android/hardware/Camera.open:(I)Landroid/hardware/Camera;
        //   421: putfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   424: goto            117
        //   427: astore          7
        //   429: ldc             "JavaCameraView"
        //   431: new             Ljava/lang/StringBuilder;
        //   434: dup            
        //   435: invokespecial   java/lang/StringBuilder.<init>:()V
        //   438: ldc             "Camera #"
        //   440: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   443: iload_3        
        //   444: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   447: ldc             "failed to open: "
        //   449: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   452: aload           7
        //   454: invokevirtual   java/lang/RuntimeException.getLocalizedMessage:()Ljava/lang/String;
        //   457: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   460: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   463: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   466: pop            
        //   467: goto            117
        //   470: aload_0        
        //   471: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   474: invokevirtual   android/hardware/Camera.getParameters:()Landroid/hardware/Camera.Parameters;
        //   477: astore          7
        //   479: ldc             "JavaCameraView"
        //   481: ldc             "getSupportedPreviewSizes()"
        //   483: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   486: pop            
        //   487: aload           7
        //   489: invokevirtual   android/hardware/Camera.Parameters.getSupportedPreviewSizes:()Ljava/util/List;
        //   492: astore          8
        //   494: aload           8
        //   496: ifnull          1031
        //   499: aload_0        
        //   500: aload           8
        //   502: new             Lorg/opencv/android/JavaCameraView.JavaCameraSizeAccessor;
        //   505: dup            
        //   506: invokespecial   org/opencv/android/JavaCameraView.JavaCameraSizeAccessor.<init>:()V
        //   509: iload_1        
        //   510: iload_2        
        //   511: invokevirtual   org/opencv/android/JavaCameraView.calculateCameraFrameSize:(Ljava/util/List;Lorg/opencv/android/CameraBridgeViewBase.ListItemAccessor;II)Lorg/opencv/core/Size;
        //   514: astore          8
        //   516: aload           7
        //   518: bipush          17
        //   520: invokevirtual   android/hardware/Camera.Parameters.setPreviewFormat:(I)V
        //   523: ldc             "JavaCameraView"
        //   525: new             Ljava/lang/StringBuilder;
        //   528: dup            
        //   529: invokespecial   java/lang/StringBuilder.<init>:()V
        //   532: ldc             "Set preview size to "
        //   534: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   537: aload           8
        //   539: getfield        org/opencv/core/Size.width:D
        //   542: d2i            
        //   543: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   546: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   549: ldc             "x"
        //   551: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   554: aload           8
        //   556: getfield        org/opencv/core/Size.height:D
        //   559: d2i            
        //   560: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   563: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   566: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   569: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   572: pop            
        //   573: aload           7
        //   575: aload           8
        //   577: getfield        org/opencv/core/Size.width:D
        //   580: d2i            
        //   581: aload           8
        //   583: getfield        org/opencv/core/Size.height:D
        //   586: d2i            
        //   587: invokevirtual   android/hardware/Camera.Parameters.setPreviewSize:(II)V
        //   590: getstatic       android/os/Build.VERSION.SDK_INT:I
        //   593: bipush          14
        //   595: if_icmplt       616
        //   598: getstatic       android/os/Build.MODEL:Ljava/lang/String;
        //   601: ldc_w           "GT-I9100"
        //   604: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   607: ifne            616
        //   610: aload           7
        //   612: iconst_1       
        //   613: invokevirtual   android/hardware/Camera.Parameters.setRecordingHint:(Z)V
        //   616: aload           7
        //   618: invokevirtual   android/hardware/Camera.Parameters.getSupportedFocusModes:()Ljava/util/List;
        //   621: astore          8
        //   623: aload           8
        //   625: ifnull          649
        //   628: aload           8
        //   630: ldc_w           "continuous-video"
        //   633: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   638: ifeq            649
        //   641: aload           7
        //   643: ldc_w           "continuous-video"
        //   646: invokevirtual   android/hardware/Camera.Parameters.setFocusMode:(Ljava/lang/String;)V
        //   649: aload_0        
        //   650: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   653: aload           7
        //   655: invokevirtual   android/hardware/Camera.setParameters:(Landroid/hardware/Camera.Parameters;)V
        //   658: aload_0        
        //   659: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   662: invokevirtual   android/hardware/Camera.getParameters:()Landroid/hardware/Camera.Parameters;
        //   665: astore          7
        //   667: aload_0        
        //   668: aload           7
        //   670: invokevirtual   android/hardware/Camera.Parameters.getPreviewSize:()Landroid/hardware/Camera.Size;
        //   673: getfield        android/hardware/Camera.Size.width:I
        //   676: putfield        org/opencv/android/JavaCameraView.mFrameWidth:I
        //   679: aload_0        
        //   680: aload           7
        //   682: invokevirtual   android/hardware/Camera.Parameters.getPreviewSize:()Landroid/hardware/Camera.Size;
        //   685: getfield        android/hardware/Camera.Size.height:I
        //   688: putfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   691: aload_0        
        //   692: invokevirtual   org/opencv/android/JavaCameraView.getLayoutParams:()Landroid/view/ViewGroup.LayoutParams;
        //   695: getfield        android/view/ViewGroup.LayoutParams.width:I
        //   698: iconst_m1      
        //   699: if_icmpne       999
        //   702: aload_0        
        //   703: invokevirtual   org/opencv/android/JavaCameraView.getLayoutParams:()Landroid/view/ViewGroup.LayoutParams;
        //   706: getfield        android/view/ViewGroup.LayoutParams.height:I
        //   709: iconst_m1      
        //   710: if_icmpne       999
        //   713: aload_0        
        //   714: iload_2        
        //   715: i2f            
        //   716: aload_0        
        //   717: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   720: i2f            
        //   721: fdiv           
        //   722: iload_1        
        //   723: i2f            
        //   724: aload_0        
        //   725: getfield        org/opencv/android/JavaCameraView.mFrameWidth:I
        //   728: i2f            
        //   729: fdiv           
        //   730: invokestatic    java/lang/Math.min:(FF)F
        //   733: putfield        org/opencv/android/JavaCameraView.mScale:F
        //   736: aload_0        
        //   737: getfield        org/opencv/android/JavaCameraView.mFpsMeter:Lorg/opencv/android/FpsMeter;
        //   740: ifnull          758
        //   743: aload_0        
        //   744: getfield        org/opencv/android/JavaCameraView.mFpsMeter:Lorg/opencv/android/FpsMeter;
        //   747: aload_0        
        //   748: getfield        org/opencv/android/JavaCameraView.mFrameWidth:I
        //   751: aload_0        
        //   752: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   755: invokevirtual   org/opencv/android/FpsMeter.setResolution:(II)V
        //   758: aload_0        
        //   759: getfield        org/opencv/android/JavaCameraView.mFrameWidth:I
        //   762: istore_1       
        //   763: aload_0        
        //   764: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   767: istore_2       
        //   768: aload_0        
        //   769: aload           7
        //   771: invokevirtual   android/hardware/Camera.Parameters.getPreviewFormat:()I
        //   774: invokestatic    android/graphics/ImageFormat.getBitsPerPixel:(I)I
        //   777: iload_1        
        //   778: iload_2        
        //   779: imul           
        //   780: imul           
        //   781: bipush          8
        //   783: idiv           
        //   784: newarray        B
        //   786: putfield        org/opencv/android/JavaCameraView.mBuffer:[B
        //   789: aload_0        
        //   790: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   793: aload_0        
        //   794: getfield        org/opencv/android/JavaCameraView.mBuffer:[B
        //   797: invokevirtual   android/hardware/Camera.addCallbackBuffer:([B)V
        //   800: aload_0        
        //   801: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   804: aload_0        
        //   805: invokevirtual   android/hardware/Camera.setPreviewCallbackWithBuffer:(Landroid/hardware/Camera.PreviewCallback;)V
        //   808: aload_0        
        //   809: iconst_2       
        //   810: anewarray       Lorg/opencv/core/Mat;
        //   813: putfield        org/opencv/android/JavaCameraView.mFrameChain:[Lorg/opencv/core/Mat;
        //   816: aload_0        
        //   817: getfield        org/opencv/android/JavaCameraView.mFrameChain:[Lorg/opencv/core/Mat;
        //   820: iconst_0       
        //   821: new             Lorg/opencv/core/Mat;
        //   824: dup            
        //   825: aload_0        
        //   826: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   829: aload_0        
        //   830: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   833: iconst_2       
        //   834: idiv           
        //   835: iadd           
        //   836: aload_0        
        //   837: getfield        org/opencv/android/JavaCameraView.mFrameWidth:I
        //   840: getstatic       org/opencv/core/CvType.CV_8UC1:I
        //   843: invokespecial   org/opencv/core/Mat.<init>:(III)V
        //   846: aastore        
        //   847: aload_0        
        //   848: getfield        org/opencv/android/JavaCameraView.mFrameChain:[Lorg/opencv/core/Mat;
        //   851: iconst_1       
        //   852: new             Lorg/opencv/core/Mat;
        //   855: dup            
        //   856: aload_0        
        //   857: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   860: aload_0        
        //   861: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   864: iconst_2       
        //   865: idiv           
        //   866: iadd           
        //   867: aload_0        
        //   868: getfield        org/opencv/android/JavaCameraView.mFrameWidth:I
        //   871: getstatic       org/opencv/core/CvType.CV_8UC1:I
        //   874: invokespecial   org/opencv/core/Mat.<init>:(III)V
        //   877: aastore        
        //   878: aload_0        
        //   879: invokevirtual   org/opencv/android/JavaCameraView.AllocateCache:()V
        //   882: aload_0        
        //   883: iconst_2       
        //   884: anewarray       Lorg/opencv/android/JavaCameraView.JavaCameraFrame;
        //   887: putfield        org/opencv/android/JavaCameraView.mCameraFrame:[Lorg/opencv/android/JavaCameraView.JavaCameraFrame;
        //   890: aload_0        
        //   891: getfield        org/opencv/android/JavaCameraView.mCameraFrame:[Lorg/opencv/android/JavaCameraView.JavaCameraFrame;
        //   894: iconst_0       
        //   895: new             Lorg/opencv/android/JavaCameraView.JavaCameraFrame;
        //   898: dup            
        //   899: aload_0        
        //   900: aload_0        
        //   901: getfield        org/opencv/android/JavaCameraView.mFrameChain:[Lorg/opencv/core/Mat;
        //   904: iconst_0       
        //   905: aaload         
        //   906: aload_0        
        //   907: getfield        org/opencv/android/JavaCameraView.mFrameWidth:I
        //   910: aload_0        
        //   911: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   914: invokespecial   org/opencv/android/JavaCameraView.JavaCameraFrame.<init>:(Lorg/opencv/android/JavaCameraView;Lorg/opencv/core/Mat;II)V
        //   917: aastore        
        //   918: aload_0        
        //   919: getfield        org/opencv/android/JavaCameraView.mCameraFrame:[Lorg/opencv/android/JavaCameraView.JavaCameraFrame;
        //   922: iconst_1       
        //   923: new             Lorg/opencv/android/JavaCameraView.JavaCameraFrame;
        //   926: dup            
        //   927: aload_0        
        //   928: aload_0        
        //   929: getfield        org/opencv/android/JavaCameraView.mFrameChain:[Lorg/opencv/core/Mat;
        //   932: iconst_1       
        //   933: aaload         
        //   934: aload_0        
        //   935: getfield        org/opencv/android/JavaCameraView.mFrameWidth:I
        //   938: aload_0        
        //   939: getfield        org/opencv/android/JavaCameraView.mFrameHeight:I
        //   942: invokespecial   org/opencv/android/JavaCameraView.JavaCameraFrame.<init>:(Lorg/opencv/android/JavaCameraView;Lorg/opencv/core/Mat;II)V
        //   945: aastore        
        //   946: getstatic       android/os/Build.VERSION.SDK_INT:I
        //   949: bipush          11
        //   951: if_icmplt       1020
        //   954: aload_0        
        //   955: new             Landroid/graphics/SurfaceTexture;
        //   958: dup            
        //   959: bipush          10
        //   961: invokespecial   android/graphics/SurfaceTexture.<init>:(I)V
        //   964: putfield        org/opencv/android/JavaCameraView.mSurfaceTexture:Landroid/graphics/SurfaceTexture;
        //   967: aload_0        
        //   968: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   971: aload_0        
        //   972: getfield        org/opencv/android/JavaCameraView.mSurfaceTexture:Landroid/graphics/SurfaceTexture;
        //   975: invokevirtual   android/hardware/Camera.setPreviewTexture:(Landroid/graphics/SurfaceTexture;)V
        //   978: ldc             "JavaCameraView"
        //   980: ldc_w           "startPreview"
        //   983: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   986: pop            
        //   987: aload_0        
        //   988: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //   991: invokevirtual   android/hardware/Camera.startPreview:()V
        //   994: aload_0        
        //   995: monitorexit    
        //   996: iload           6
        //   998: ireturn        
        //   999: aload_0        
        //  1000: fconst_0       
        //  1001: putfield        org/opencv/android/JavaCameraView.mScale:F
        //  1004: goto            736
        //  1007: astore          7
        //  1009: iconst_0       
        //  1010: istore          6
        //  1012: aload           7
        //  1014: invokevirtual   java/lang/Exception.printStackTrace:()V
        //  1017: goto            994
        //  1020: aload_0        
        //  1021: getfield        org/opencv/android/JavaCameraView.mCamera:Landroid/hardware/Camera;
        //  1024: aconst_null    
        //  1025: invokevirtual   android/hardware/Camera.setPreviewDisplay:(Landroid/view/SurfaceHolder;)V
        //  1028: goto            978
        //  1031: iconst_0       
        //  1032: istore          6
        //  1034: goto            994
        //  1037: iload_3        
        //  1038: iconst_1       
        //  1039: iadd           
        //  1040: istore_3       
        //  1041: goto            61
        //  1044: iload           4
        //  1046: iconst_1       
        //  1047: iadd           
        //  1048: istore          4
        //  1050: goto            255
        //  1053: iload           4
        //  1055: iconst_1       
        //  1056: iadd           
        //  1057: istore          4
        //  1059: goto            333
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  13     34     162    169    Any
        //  34     41     128    162    Ljava/lang/Exception;
        //  34     41     162    169    Any
        //  41     56     162    169    Any
        //  61     101    162    169    Any
        //  101    109    169    212    Ljava/lang/RuntimeException;
        //  101    109    162    169    Any
        //  117    126    162    169    Any
        //  130    159    162    169    Any
        //  164    166    162    169    Any
        //  171    209    162    169    Any
        //  212    252    162    169    Any
        //  258    281    162    169    Any
        //  290    298    162    169    Any
        //  304    330    162    169    Any
        //  336    360    162    169    Any
        //  372    380    162    169    Any
        //  383    416    162    169    Any
        //  416    424    427    470    Ljava/lang/RuntimeException;
        //  416    424    162    169    Any
        //  429    467    162    169    Any
        //  470    494    1007   1020   Ljava/lang/Exception;
        //  470    494    162    169    Any
        //  499    616    1007   1020   Ljava/lang/Exception;
        //  499    616    162    169    Any
        //  616    623    1007   1020   Ljava/lang/Exception;
        //  616    623    162    169    Any
        //  628    649    1007   1020   Ljava/lang/Exception;
        //  628    649    162    169    Any
        //  649    736    1007   1020   Ljava/lang/Exception;
        //  649    736    162    169    Any
        //  736    758    1007   1020   Ljava/lang/Exception;
        //  736    758    162    169    Any
        //  758    978    1007   1020   Ljava/lang/Exception;
        //  758    978    162    169    Any
        //  978    994    1007   1020   Ljava/lang/Exception;
        //  978    994    162    169    Any
        //  994    996    162    169    Any
        //  999    1004   1007   1020   Ljava/lang/Exception;
        //  999    1004   162    169    Any
        //  1012   1017   162    169    Any
        //  1020   1028   1007   1020   Ljava/lang/Exception;
        //  1020   1028   162    169    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0112:
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
    
    public void onPreviewFrame(final byte[] array, final Camera camera) {
        Log.d("JavaCameraView", "Preview Frame received. Frame size: " + array.length);
        synchronized (this) {
            this.mFrameChain[this.mChainIdx].put(0, 0, array);
            this.mCameraFrameReady = true;
            this.notify();
            // monitorexit(this)
            if (this.mCamera != null) {
                this.mCamera.addCallbackBuffer(this.mBuffer);
            }
        }
    }
    
    protected void releaseCamera() {
        synchronized (this) {
            if (this.mCamera != null) {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback((Camera.PreviewCallback)null);
                this.mCamera.release();
            }
            this.mCamera = null;
            if (this.mFrameChain != null) {
                this.mFrameChain[0].release();
                this.mFrameChain[1].release();
            }
            if (this.mCameraFrame != null) {
                this.mCameraFrame[0].release();
                this.mCameraFrame[1].release();
            }
        }
    }
    
    private class CameraWorker implements Runnable
    {
        @Override
        public void run() {
            while (true) {
                boolean b = false;
                synchronized (JavaCameraView.this) {
                    try {
                        while (!JavaCameraView.this.mCameraFrameReady && !JavaCameraView.this.mStopThread) {
                            JavaCameraView.this.wait();
                        }
                    }
                    catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    if (JavaCameraView.this.mCameraFrameReady) {
                        JavaCameraView.this.mChainIdx = 1 - JavaCameraView.this.mChainIdx;
                        JavaCameraView.this.mCameraFrameReady = false;
                        b = true;
                    }
                    // monitorexit(this.this.0)
                    if (!JavaCameraView.this.mStopThread && b && !JavaCameraView.this.mFrameChain[1 - JavaCameraView.this.mChainIdx].empty()) {
                        JavaCameraView.this.deliverAndDrawFrame((CvCameraViewFrame)JavaCameraView.this.mCameraFrame[1 - JavaCameraView.this.mChainIdx]);
                    }
                    if (JavaCameraView.this.mStopThread) {
                        Log.d("JavaCameraView", "Finish processing thread");
                        return;
                    }
                    continue;
                }
            }
        }
    }
    
    private class JavaCameraFrame implements CvCameraViewFrame
    {
        private int mHeight;
        private Mat mRgba;
        private int mWidth;
        private Mat mYuvFrameData;
        
        public JavaCameraFrame(final Mat mYuvFrameData, final int mWidth, final int mHeight) {
            this.mWidth = mWidth;
            this.mHeight = mHeight;
            this.mYuvFrameData = mYuvFrameData;
            this.mRgba = new Mat();
        }
        
        @Override
        public Mat gray() {
            return this.mYuvFrameData.submat(0, this.mHeight, 0, this.mWidth);
        }
        
        public void release() {
            this.mRgba.release();
        }
        
        @Override
        public Mat rgba() {
            Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 96, 4);
            return this.mRgba;
        }
    }
    
    public static class JavaCameraSizeAccessor implements ListItemAccessor
    {
        @Override
        public int getHeight(final Object o) {
            return ((Camera.Size)o).height;
        }
        
        @Override
        public int getWidth(final Object o) {
            return ((Camera.Size)o).width;
        }
    }
}

package com.example.reagent20;

import android.content.*;
import android.graphics.*;
import java.lang.ref.*;
import java.io.*;
import java.util.*;

import android.hardware.Camera;
import android.util.*;
import android.widget.*;
import android.view.*;
import android.hardware.*;
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback
{
    private static String Path;
    private static final String TAG = "CameraSurfaceView";
    private static Bitmap bm;
    Camera.AutoFocusCallback autofocuscallback;
    private SurfaceHolder holder;
    private Camera.PictureCallback jpeg;
    private Camera mCamera;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private Camera.PictureCallback raw;
    private int reagent_strip_type;
    private int reagent_type;
    private Camera.ShutterCallback shutter;
    private Camera.ShutterCallback shutterCallback;
    private String standard_value;

    public CameraSurfaceView() {
        super((Context)null);
        this.standard_value = "";
        this.autofocuscallback = (Camera.AutoFocusCallback)new Camera.AutoFocusCallback() {
            public void onAutoFocus(final boolean b, final Camera camera) {
                if (b) {
                    Log.i("CameraSurfaceView", "onAutoFocus success=" + b);
                    CameraSurfaceView.this.takePicture();
                    return;
                }
                Log.i("CameraSurfaceView", "onAutoFocus fail");
                CameraSurfaceView.this.mCamera.autoFocus(CameraSurfaceView.this.autofocuscallback);
            }
        };
        this.raw = (Camera.PictureCallback)new Camera.PictureCallback() {
            public void onPictureTaken(final byte[] array, final Camera camera) {
                Log.i("CameraSurfaceView", "raw");
            }
        };
        this.shutter = (Camera.ShutterCallback)new Camera.ShutterCallback() {
            public void onShutter() {
                Log.i("CameraSurfaceView", "shutter");
            }
        };
        this.jpeg = (Camera.PictureCallback)new Camera.PictureCallback() {
            public void onPictureTaken(final byte[] array, final Camera camera) {
                try {
                    Log.i("CameraSurfaceView", "take picture");
                    CameraSurfaceView.bm = BitmapFactory.decodeByteArray(array, 0, array.length);
                    if (CameraSurfaceView.bm.getWidth() > CameraSurfaceView.bm.getHeight()) {
                        final Matrix matrix = new Matrix();
                        matrix.postRotate(90.0f);
                        CameraSurfaceView.bm = Bitmap.createBitmap(CameraSurfaceView.bm, 0, 0, CameraSurfaceView.bm.getWidth(), CameraSurfaceView.bm.getHeight(), matrix, true);
                    }
                    if (!CameraSurfaceView.this.standard_value.equals("")) {
                        new SaveImage(CameraSurfaceView.bm, true, String.valueOf(CameraSurfaceView.this.reagent_type), String.valueOf(CameraSurfaceView.this.reagent_strip_type)).save(CameraSurfaceView.this.standard_value);
                        final Intent intent = new Intent();
                        intent.putExtra("reagent_type", CameraSurfaceView.this.reagent_type);
                        intent.putExtra("reagent_strip_type", CameraSurfaceView.this.reagent_strip_type);
                        intent.setClass(CameraSurfaceView.this.mContext, (Class)StandardActivity.class);
                        // intent.setFlags(67108864);
                        CameraSurfaceView.this.mContext.startActivity(intent);
                        return;
                    }
                    final String string = new SaveImage(CameraSurfaceView.bm, false, String.valueOf(CameraSurfaceView.this.reagent_type), String.valueOf(CameraSurfaceView.this.reagent_strip_type)).save() + ".jpg";
                    Log.i("CameraSurfaceView", string);
                    final Intent intent2 = new Intent();
                    intent2.putExtra("Take_Photo_Path", string);
                    intent2.putExtra("reagent_type", CameraSurfaceView.this.reagent_type);
                    intent2.putExtra("reagent_strip_type", CameraSurfaceView.this.reagent_strip_type);
                    intent2.setClass(CameraSurfaceView.this.mContext, (Class)TestActivity.class);
                    // intent2.setFlags(67108864);
                    CameraSurfaceView.this.mContext.startActivity(intent2);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        this.shutterCallback = (Camera.ShutterCallback)new Camera.ShutterCallback() {
            public void onShutter() {
            }
        };
    }

    public CameraSurfaceView(final Context context) {
        this(context, null);
    }

    public CameraSurfaceView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }

    public CameraSurfaceView(final Context mContext, final AttributeSet set, final int n) {
        super(mContext, set, n);
        this.standard_value = "";
        this.autofocuscallback = (Camera.AutoFocusCallback)new Camera.AutoFocusCallback() {
            public void onAutoFocus(final boolean b, final Camera camera) {
                if (b) {
                    Log.i("CameraSurfaceView", "onAutoFocus success=" + b);
                    CameraSurfaceView.this.takePicture();
                    return;
                }
                Log.i("CameraSurfaceView", "onAutoFocus fail");
                CameraSurfaceView.this.mCamera.autoFocus(CameraSurfaceView.this.autofocuscallback);
            }
        };
        this.raw = (Camera.PictureCallback)new Camera.PictureCallback() {
            public void onPictureTaken(final byte[] array, final Camera camera) {
                Log.i("CameraSurfaceView", "raw");
            }
        };
        this.shutter = (Camera.ShutterCallback)new Camera.ShutterCallback() {
            public void onShutter() {
                Log.i("CameraSurfaceView", "shutter");
            }
        };
        this.jpeg = (Camera.PictureCallback)new Camera.PictureCallback() {
            public void onPictureTaken(final byte[] array, final Camera camera) {
                try {
                    Log.i("CameraSurfaceView", "take picture");
                    CameraSurfaceView.bm = BitmapFactory.decodeByteArray(array, 0, array.length);
                    if (CameraSurfaceView.bm.getWidth() > CameraSurfaceView.bm.getHeight()) {
                        final Matrix matrix = new Matrix();
                        matrix.postRotate(90.0f);
                        CameraSurfaceView.bm = Bitmap.createBitmap(CameraSurfaceView.bm, 0, 0, CameraSurfaceView.bm.getWidth(), CameraSurfaceView.bm.getHeight(), matrix, true);
                    }
                    if (!CameraSurfaceView.this.standard_value.equals("")) {
                        new SaveImage(CameraSurfaceView.bm, true, String.valueOf(CameraSurfaceView.this.reagent_type), String.valueOf(CameraSurfaceView.this.reagent_strip_type)).save(CameraSurfaceView.this.standard_value);
                        final Intent intent = new Intent();
                        intent.putExtra("reagent_type", CameraSurfaceView.this.reagent_type);
                        intent.putExtra("reagent_strip_type", CameraSurfaceView.this.reagent_strip_type);
                        intent.setClass(CameraSurfaceView.this.mContext, (Class)StandardActivity.class);
                        //intent.setFlags(67108864);
                        CameraSurfaceView.this.mContext.startActivity(intent);
                        return;
                    }
                    final String string = new SaveImage(CameraSurfaceView.bm, false, String.valueOf(CameraSurfaceView.this.reagent_type), String.valueOf(CameraSurfaceView.this.reagent_strip_type)).save() + ".jpg";
                    Log.i("CameraSurfaceView", string);
                    final Intent intent2 = new Intent();
                    intent2.putExtra("Take_Photo_Path", string);
                    intent2.putExtra("reagent_type", CameraSurfaceView.this.reagent_type);
                    intent2.putExtra("reagent_strip_type", CameraSurfaceView.this.reagent_strip_type);
                    intent2.setClass(CameraSurfaceView.this.mContext, (Class)TestActivity.class);
                    // intent2.setFlags(67108864);
                    CameraSurfaceView.this.mContext.startActivity(intent2);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        this.shutterCallback = (Camera.ShutterCallback)new Camera.ShutterCallback() {
            public void onShutter() {
            }
        };
        this.getScreenMetrix(this.mContext = mContext);
        this.initView();
    }

    public static Bitmap byteToBitmap(final byte[] array) {
        final BitmapFactory.Options bitmapFactoryOptions = new BitmapFactory.Options();
        bitmapFactoryOptions.inSampleSize = 8;
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);
        final Bitmap bitmap = new SoftReference<Bitmap>(BitmapFactory.decodeStream((InputStream)byteArrayInputStream, (Rect)null, bitmapFactoryOptions)).get();
        if (array != null) {}
        if (byteArrayInputStream == null) {
            return bitmap;
        }
        try {
            byteArrayInputStream.close();
            return bitmap;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return bitmap;
        }
    }

    private Camera.Size getProperSize(final List<Camera.Size> list, final float n) {
        Log.i("CameraSurfaceView", "screenRatio=" + n);
        final Camera.Size cameraSize = null;
        final Iterator<Camera.Size> iterator = list.iterator();
        Camera.Size cameraSize2;
        do {
            cameraSize2 = cameraSize;
            if (!iterator.hasNext()) {
                break;
            }
            cameraSize2 = iterator.next();
        } while (cameraSize2.width / (float)cameraSize2.height - n != 0.0f || cameraSize2.width >= 2000 || cameraSize2.width <= 800);
        Camera.Size cameraSize3;
        if ((cameraSize3 = cameraSize2) == null) {
            final Iterator<Camera.Size> iterator2 = list.iterator();
            do {
                cameraSize3 = cameraSize2;
                if (!iterator2.hasNext()) {
                    break;
                }
                cameraSize3 = iterator2.next();
            } while (cameraSize3.width / (float)cameraSize3.height != 1.3333334f || cameraSize3.width >= 2000 || cameraSize3.width <= 800);
        }
        return cameraSize3;
    }

    private void getScreenMetrix(final Context context) {
        final WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
    }

    private void initView() {
        (this.holder = this.getHolder()).addCallback((SurfaceHolder.Callback)this);
        this.holder.setType(3);
    }

    private void setCameraParams(final Camera camera, final int n, final int n2) {
        Log.i("CameraSurfaceView", "setCameraParams  width=" + n + "  height=" + n2);
        final Camera.Parameters parameters = this.mCamera.getParameters();
        Log.i("CameraSurfaceView", "ExposureCompensation():" + parameters.getExposureCompensation());
        final List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        for (final Camera.Size cameraSize : supportedPictureSizes) {
            Log.i("CameraSurfaceView", "pictureSizeList size.width=" + cameraSize.width + "  size.height=" + cameraSize.height);
        }
        Camera.Size cameraSize2;
        if ((cameraSize2 = this.getProperSize(supportedPictureSizes, n2 / (float)n)) == null) {
            Log.i("CameraSurfaceView", "null == picSize");
            cameraSize2 = parameters.getPictureSize();
        }
        Log.i("CameraSurfaceView", "picSize.width=" + cameraSize2.width + "  picSize.height=" + cameraSize2.height);
        final float n3 = (float)cameraSize2.width;
        final float n4 = (float)cameraSize2.height;
        parameters.setPictureSize(cameraSize2.width, cameraSize2.height);
        this.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams((int)(n2 * (n4 / n3)), n2));
        final List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        for ( Camera.Size cameraSize3 : supportedPreviewSizes) {
            Log.i("CameraSurfaceView", "previewSizeList size.width=" + cameraSize3.width + "  size.height=" + cameraSize3.height);
        }
        final Camera.Size properSize = this.getProperSize(supportedPreviewSizes, n2 / (float)n);
        if (properSize != null) {
            Log.i("CameraSurfaceView", "preSize.width=" + properSize.width + "  preSize.height=" + properSize.height);
            parameters.setPreviewSize(properSize.width, properSize.height);
        }
        parameters.setJpegQuality(100);
        if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        }
        this.mCamera.cancelAutoFocus();
        this.mCamera.setDisplayOrientation(90);
        this.mCamera.setParameters(parameters);
    }

    public void focus(final String standard_value, final int reagent_type, final int reagent_strip_type) {
        this.standard_value = standard_value;
        this.reagent_type = reagent_type;
        this.reagent_strip_type = reagent_strip_type;
        final Camera.Parameters parameters = this.mCamera.getParameters();
        parameters.setFocusMode("auto");
        this.mCamera.setParameters(parameters);
        this.mCamera.cancelAutoFocus();
        this.mCamera.autoFocus(this.autofocuscallback);
    }

    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
        Log.i("CameraSurfaceView", "surfaceChanged");
        this.setCameraParams(this.mCamera, this.mScreenWidth, this.mScreenHeight);
        this.mCamera.startPreview();
    }

    public void surfaceCreated(final SurfaceHolder previewDisplay) {
        Log.i("CameraSurfaceView", "surfaceCreated");
        if (this.mCamera != null) {
            return;
        }
        this.mCamera = Camera.open();
        try {
            this.mCamera.setPreviewDisplay(previewDisplay);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
        Log.i("CameraSurfaceView", "surfaceDestroyed");
        this.mCamera.stopPreview();
        cameraWindows.getBounds(null);
        this.mCamera.release();
        this.mCamera = null;
    }

    public void takePicture() {
        this.mCamera.takePicture((Camera.ShutterCallback)null, (Camera.PictureCallback)null, this.jpeg);
    }
}

package org.opencv.android;

import android.annotation.*;
import android.content.Context;
import android.os.*;
import android.util.*;
import android.view.*;
import java.util.*;
import android.hardware.camera2.params.*;
import android.hardware.camera2.*;
import android.graphics.*;
import java.util.concurrent.*;

@androidx.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Camera2Renderer extends CameraGLRendererBase
{
    protected final String LOGTAG;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private CameraDevice mCameraDevice;
    private String mCameraID;
    private Semaphore mCameraOpenCloseLock;
    private CameraCaptureSession mCaptureSession;
    private CaptureRequest.Builder mPreviewRequestBuilder;
    private Size mPreviewSize;
    private final CameraDevice.StateCallback mStateCallback;
    private Object Label_0107;

    Camera2Renderer(final CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.LOGTAG = "Camera2Renderer";
        this.mPreviewSize = new Size(-1, -1);
        this.mCameraOpenCloseLock = new Semaphore(1);
        this.mStateCallback = new CameraDevice.StateCallback() {
            public void onDisconnected(final CameraDevice cameraDevice) {
                cameraDevice.close();
                Camera2Renderer.this.mCameraDevice = null;
                Camera2Renderer.this.mCameraOpenCloseLock.release();
            }
            
            public void onError(final CameraDevice cameraDevice, final int n) {
                cameraDevice.close();
                Camera2Renderer.this.mCameraDevice = null;
                Camera2Renderer.this.mCameraOpenCloseLock.release();
            }
            
            public void onOpened(final CameraDevice cameraDevice) {
                Camera2Renderer.this.mCameraDevice = cameraDevice;
                Camera2Renderer.this.mCameraOpenCloseLock.release();
                try {
                    Camera2Renderer.this.createCameraPreviewSession();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        };
    }
    
    private void createCameraPreviewSession() throws CameraAccessException {
        final int width = this.mPreviewSize.getWidth();
        final int height = this.mPreviewSize.getHeight();
        Log.i("Camera2Renderer", "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width < 0 || height < 0) {
            return;
        }
        try {
            this.mCameraOpenCloseLock.acquire();
            if (this.mCameraDevice == null) {
                this.mCameraOpenCloseLock.release();
                Log.e("Camera2Renderer", "createCameraPreviewSession: camera isn't opened");
                return;
            }
           // goto Label_0107;
        } catch (InterruptedException ex) {
            throw new RuntimeException("Interrupted while createCameraPreviewSession", ex);
        }
        if (this.mSTexture == null) {
            this.mCameraOpenCloseLock.release();
            Log.e("Camera2Renderer", "createCameraPreviewSession: preview SurfaceTexture is null");
            return;
        }
        this.mSTexture.setDefaultBufferSize(width, height);
        final Surface surface = new Surface(this.mSTexture);
        (this.mPreviewRequestBuilder = this.mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)).addTarget(surface);
        this.mCameraDevice.createCaptureSession((List)Arrays.asList(surface), (CameraCaptureSession.StateCallback)new CameraCaptureSession.StateCallback() {
            public void onConfigureFailed(final CameraCaptureSession cameraCaptureSession) {
                Log.e("Camera2Renderer", "createCameraPreviewSession failed");
                Camera2Renderer.this.mCameraOpenCloseLock.release();
            }
            
            public void onConfigured(final CameraCaptureSession cameraCaptureSession) {
                Camera2Renderer.this.mCaptureSession = cameraCaptureSession;
                while (true) {
                    try {
                        Camera2Renderer.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                        Camera2Renderer.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 2);
                        Camera2Renderer.this.mCaptureSession.setRepeatingRequest(Camera2Renderer.this.mPreviewRequestBuilder.build(), (CameraCaptureSession.CaptureCallback)null, Camera2Renderer.this.mBackgroundHandler);
                        Log.i("Camera2Renderer", "CameraPreviewSession has been started");
                        Camera2Renderer.this.mCameraOpenCloseLock.release();
                    }
                    catch (CameraAccessException ex) {
                        Log.e("Camera2Renderer", "createCaptureSession failed");
                        continue;
                    }
                    break;
                }
            }
        }, this.mBackgroundHandler);
    }
    
    private void startBackgroundThread() {
        Log.i("Camera2Renderer", "startBackgroundThread");
        this.stopBackgroundThread();
        (this.mBackgroundThread = new HandlerThread("CameraBackground")).start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }
    
    private void stopBackgroundThread() {
        Log.i("Camera2Renderer", "stopBackgroundThread");
        if (this.mBackgroundThread == null) {
            return;
        }
        this.mBackgroundThread.quitSafely();
        try {
            this.mBackgroundThread.join();
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        }
        catch (InterruptedException ex) {
            Log.e("Camera2Renderer", "stopBackgroundThread");
        }
    }
    
    boolean cacPreviewSize(final int n, final int n2) {
        Log.i("Camera2Renderer", "cacPreviewSize: " + n + "x" + n2);
        if (this.mCameraID == null) {
            Log.e("Camera2Renderer", "Camera isn't initialized!");
            return false;
        }
        while (true) {
            final CameraManager cameraManager = (CameraManager)this.mView.getContext().getSystemService(Context.CAMERA_SERVICE);
            while (true) {
                int n6 = 0;
                int n7 = 0;
                int n8 = 0;
                try {
                    final StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap)cameraManager.getCameraCharacteristics(this.mCameraID).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    final int n3 = 0;
                    final int n4 = 0;
                    final float n5 = n / (float)n2;
                    final Size[] outputSizes = streamConfigurationMap.getOutputSizes((Class)SurfaceTexture.class);
                    final int length = outputSizes.length;
                    n6 = 0;
                    if (n6 < length) {
                        final Size size = outputSizes[n6];
                        final int width = size.getWidth();
                        final int height = size.getHeight();
                        Log.d("Camera2Renderer", "trying size: " + width + "x" + height);
                        n7 = n4;
                        n8 = n3;
                        if (n >= width) {
                            n7 = n4;
                            n8 = n3;
                            if (n2 >= height) {
                                n7 = n4;
                                if ((n8 = n3) <= width) {
                                    n7 = n4;
                                    n8 = n3;
                                    if (n4 <= height) {
                                        n7 = n4;
                                        n8 = n3;
                                        if (Math.abs(n5 - width / (float)height) < 0.2) {
                                            n8 = width;
                                            n7 = height;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else {
                        Log.i("Camera2Renderer", "best size: " + n3 + "x" + n4);
                        if (n3 != 0 && n4 != 0 && (this.mPreviewSize.getWidth() != n3 || this.mPreviewSize.getHeight() != n4)) {
                            this.mPreviewSize = new Size(n3, n4);
                            return true;
                        }
                        break;
                    }
                }
                catch (CameraAccessException ex) {
                    Log.e("Camera2Renderer", "cacPreviewSize - Camera Access Exception");
                }
                catch (IllegalArgumentException ex2) {
                    Log.e("Camera2Renderer", "cacPreviewSize - Illegal Argument Exception");
                   // goto Label_0381;
                }
                catch (SecurityException ex3) {
                    Log.e("Camera2Renderer", "cacPreviewSize - Security Exception");
                    //goto Label_0381;
                }
                ++n6;
                final int n4 = n7;
                final int n3 = n8;
                continue;
            }
        }
       // return false;
    }
    
    @Override
    protected void closeCamera() {
        Log.i("Camera2Renderer", "closeCamera");
        try {
            this.mCameraOpenCloseLock.acquire();
            if (this.mCaptureSession != null) {
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            if (this.mCameraDevice != null) {
                this.mCameraDevice.close();
                this.mCameraDevice = null;
            }
        }
        catch (InterruptedException ex) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", ex);
        }
        finally {
            this.mCameraOpenCloseLock.release();
        }
    }
    
    @Override
    protected void doStart() {
        Log.d("Camera2Renderer", "doStart");
        this.startBackgroundThread();
        super.doStart();
    }
    
    @Override
    protected void doStop() {
        Log.d("Camera2Renderer", "doStop");
        super.doStop();
        this.stopBackgroundThread();
    }
    
    @Override
    protected void openCamera(final int n) {
        Log.i("Camera2Renderer", "openCamera");
        final CameraManager cameraManager = (CameraManager)this.mView.getContext().getSystemService(Context.CAMERA_SERVICE);
        try {
            final String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length == 0) {
                Log.e("Camera2Renderer", "Error: camera isn't detected.");
                return;
            }
            if (n != -1) {
               // goto Label_0108;
            }
            this.mCameraID = cameraIdList[0];
            if (this.mCameraID != null) {
                if (!this.mCameraOpenCloseLock.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                    throw new RuntimeException("Time out waiting to lock camera opening.");
                }
              //  goto Label_0209;
            }
        }
        catch (CameraAccessException ex) {
            Log.e("Camera2Renderer", "OpenCamera - Camera Access Exception");
        }
        catch (IllegalArgumentException ex2) {
            Log.e("Camera2Renderer", "OpenCamera - Illegal Argument Exception");
        }
        catch (SecurityException ex3) {
            Log.e("Camera2Renderer", "OpenCamera - Security Exception");
        }
        catch (InterruptedException ex4) {
            Log.e("Camera2Renderer", "OpenCamera - Interrupted Exception");
        }
    }
    
    @Override
    protected void setCameraPreviewSize(int mMaxCameraHeight, final int n) {
        Log.i("Camera2Renderer", "setCameraPreviewSize(" + mMaxCameraHeight + "x" + n + ")");
        int mMaxCameraWidth = mMaxCameraHeight;
        if (this.mMaxCameraWidth > 0 && this.mMaxCameraWidth < (mMaxCameraWidth = mMaxCameraHeight)) {
            mMaxCameraWidth = this.mMaxCameraWidth;
        }
        mMaxCameraHeight = n;
        if (this.mMaxCameraHeight > 0 && this.mMaxCameraHeight < (mMaxCameraHeight = n)) {
            mMaxCameraHeight = this.mMaxCameraHeight;
        }
        try {
            this.mCameraOpenCloseLock.acquire();
            final boolean cacPreviewSize = this.cacPreviewSize(mMaxCameraWidth, mMaxCameraHeight);
            this.mCameraWidth = this.mPreviewSize.getWidth();
            this.mCameraHeight = this.mPreviewSize.getHeight();
            if (!cacPreviewSize) {
                this.mCameraOpenCloseLock.release();
                return;
            }
            if (this.mCaptureSession != null) {
                Log.d("Camera2Renderer", "closing existing previewSession");
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            this.mCameraOpenCloseLock.release();
            this.createCameraPreviewSession();
        }
        catch (InterruptedException | CameraAccessException ex) {
            this.mCameraOpenCloseLock.release();
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", ex);
        }
    }
}

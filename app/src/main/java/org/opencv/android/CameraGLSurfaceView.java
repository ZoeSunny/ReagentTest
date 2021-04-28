package org.opencv.android;

import android.content.*;
import org.opencv.*;
import android.os.*;
import android.opengl.*;
import android.content.res.*;
import android.util.*;
import android.view.*;

public class CameraGLSurfaceView extends GLSurfaceView
{
    private static final String LOGTAG = "CameraGLSurfaceView";
    private CameraGLRendererBase mRenderer;
    private CameraTextureListener mTexListener;
    
    public CameraGLSurfaceView(final Context context, final AttributeSet set) {
        super(context, set);
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, R.styleable.CameraBridgeViewBase);
        final int int1 = obtainStyledAttributes.getInt(R.styleable.CameraBridgeViewBase_camera_id, -1);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            this.mRenderer = new Camera2Renderer(this);
        }
        else {
            this.mRenderer = new CameraRenderer(this);
        }
        this.setCameraIndex(int1);
        this.setEGLContextClientVersion(2);
        this.setRenderer((GLSurfaceView.Renderer)this.mRenderer);
        this.setRenderMode(0);
    }
    
    public void disableView() {
        this.mRenderer.disableView();
    }
    
    public void enableView() {
        this.mRenderer.enableView();
    }
    
    public CameraTextureListener getCameraTextureListener() {
        return this.mTexListener;
    }
    
    public void onPause() {
        Log.i("CameraGLSurfaceView", "onPause");
        this.mRenderer.onPause();
        super.onPause();
    }
    
    public void onResume() {
        Log.i("CameraGLSurfaceView", "onResume");
        super.onResume();
        this.mRenderer.onResume();
    }
    
    public void setCameraIndex(final int cameraIndex) {
        this.mRenderer.setCameraIndex(cameraIndex);
    }
    
    public void setCameraTextureListener(final CameraTextureListener mTexListener) {
        this.mTexListener = mTexListener;
    }
    
    public void setMaxCameraPreviewSize(final int n, final int n2) {
        this.mRenderer.setMaxCameraPreviewSize(n, n2);
    }
    
    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
        super.surfaceChanged(surfaceHolder, n, n2, n3);
    }
    
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }
    
    public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
        this.mRenderer.mHaveSurface = false;
        super.surfaceDestroyed(surfaceHolder);
    }
    
    public interface CameraTextureListener
    {
        boolean onCameraTexture(final int p0, final int p1, final int p2, final int p3);
        
        void onCameraViewStarted(final int p0, final int p1);
        
        void onCameraViewStopped();
    }
}

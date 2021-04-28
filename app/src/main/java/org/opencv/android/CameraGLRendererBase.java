package org.opencv.android;

import android.annotation.*;
import android.graphics.*;
import android.util.*;
import android.opengl.*;
import android.view.View;

import java.nio.*;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.*;
import javax.microedition.khronos.egl.*;

@TargetApi(15)
public abstract class CameraGLRendererBase implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener
{
    private int[] FBO;
    protected final String LOGTAG;
    private final String fss2D;
    private final String fssOES;
    protected int mCameraHeight;
    protected int mCameraIndex;
    protected int mCameraWidth;
    protected boolean mEnabled;
    protected int mFBOHeight;
    protected int mFBOWidth;
    protected boolean mHaveFBO;
    protected boolean mHaveSurface;
    protected boolean mIsStarted;
    protected int mMaxCameraHeight;
    protected int mMaxCameraWidth;
    protected SurfaceTexture mSTexture;
    protected boolean mUpdateST;
    protected CameraGLSurfaceView mView;
    private int prog2D;
    private int progOES;
    private FloatBuffer tex2D;
    private int[] texCamera;
    private final float[] texCoord2D;
    private final float[] texCoordOES;
    private int[] texDraw;
    private int[] texFBO;
    private FloatBuffer texOES;
    private int vPos2D;
    private int vPosOES;
    private int vTC2D;
    private int vTCOES;
    private FloatBuffer vert;
    private final float[] vertices;
    private final String vss;
    
    public CameraGLRendererBase(final CameraGLSurfaceView mView) {
        this.LOGTAG = "CameraGLRendererBase";
        this.vss = "attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}";
        this.fssOES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";
        this.fss2D = "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";
        this.vertices = new float[] { -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f };
        this.texCoordOES = new float[] { 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f };
        this.texCoord2D = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
        this.texCamera = new int[] { 0 };
        this.texFBO = new int[] { 0 };
        this.texDraw = new int[] { 0 };
        this.FBO = new int[] { 0 };
        this.progOES = -1;
        this.prog2D = -1;
        this.mCameraWidth = -1;
        this.mCameraHeight = -1;
        this.mFBOWidth = -1;
        this.mFBOHeight = -1;
        this.mMaxCameraWidth = -1;
        this.mMaxCameraHeight = -1;
        this.mCameraIndex = -1;
        this.mHaveSurface = false;
        this.mHaveFBO = false;
        this.mUpdateST = false;
        this.mEnabled = true;
        this.mIsStarted = false;
        this.mView = mView;
        final int n = this.vertices.length * 32 / 8;
        this.vert = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.texOES = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.tex2D = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.vert.put(this.vertices).position(0);
        this.texOES.put(this.texCoordOES).position(0);
        this.tex2D.put(this.texCoord2D).position(0);
    }
    
    private void deleteFBO() {
        Log.d("CameraGLRendererBase", "deleteFBO(" + this.mFBOWidth + "x" + this.mFBOHeight + ")");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, this.FBO, 0);
        deleteTex(this.texFBO);
        deleteTex(this.texDraw);
        this.mFBOHeight = 0;
        this.mFBOWidth = 0;
    }
    
    private void deleteSurfaceTexture() {
        Log.d("CameraGLRendererBase", "deleteSurfaceTexture");
        if (this.mSTexture != null) {
            this.mSTexture.release();
            this.mSTexture = null;
            deleteTex(this.texCamera);
        }
    }
    
    private static void deleteTex(final int[] array) {
        if (array.length == 1) {
            GLES20.glDeleteTextures(1, array, 0);
        }
    }
    
    private void drawTex(final int n, final boolean b, final int n2) {
        GLES20.glBindFramebuffer(36160, n2);
        if (n2 == 0) {
            GLES20.glViewport(0, 0, this.mView.getWidth(), this.mView.getHeight());
        }
        else {
            GLES20.glViewport(0, 0, this.mFBOWidth, this.mFBOHeight);
        }
        GLES20.glClear(16384);
        if (b) {
            GLES20.glUseProgram(this.progOES);
            GLES20.glVertexAttribPointer(this.vPosOES, 2, 5126, false, 8, (Buffer)this.vert);
            GLES20.glVertexAttribPointer(this.vTCOES, 2, 5126, false, 8, (Buffer)this.texOES);
        }
        else {
            GLES20.glUseProgram(this.prog2D);
            GLES20.glVertexAttribPointer(this.vPos2D, 2, 5126, false, 8, (Buffer)this.vert);
            GLES20.glVertexAttribPointer(this.vTC2D, 2, 5126, false, 8, (Buffer)this.tex2D);
        }
        GLES20.glActiveTexture(33984);
        if (b) {
            GLES20.glBindTexture(36197, n);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.progOES, "sTexture"), 0);
        }
        else {
            GLES20.glBindTexture(3553, n);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.prog2D, "sTexture"), 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
    }
    
    private void initFBO(final int mfboWidth, final int mfboHeight) {
        Log.d("CameraGLRendererBase", "initFBO(" + mfboWidth + "x" + mfboHeight + ")");
        this.deleteFBO();
        GLES20.glGenTextures(1, this.texDraw, 0);
        GLES20.glBindTexture(3553, this.texDraw[0]);
        GLES20.glTexImage2D(3553, 0, 6408, mfboWidth, mfboHeight, 0, 6408, 5121, (Buffer)null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenTextures(1, this.texFBO, 0);
        GLES20.glBindTexture(3553, this.texFBO[0]);
        GLES20.glTexImage2D(3553, 0, 6408, mfboWidth, mfboHeight, 0, 6408, 5121, (Buffer)null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenFramebuffers(1, this.FBO, 0);
        GLES20.glBindFramebuffer(36160, this.FBO[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texFBO[0], 0);
        Log.d("CameraGLRendererBase", "initFBO error status: " + GLES20.glGetError());
        final int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            Log.e("CameraGLRendererBase", "initFBO failed, status: " + glCheckFramebufferStatus);
        }
        this.mFBOWidth = mfboWidth;
        this.mFBOHeight = mfboHeight;
    }
    
    private void initShaders() {
        final String glGetString = GLES20.glGetString(7938);
        if (glGetString != null) {
            Log.i("CameraGLRendererBase", "OpenGL ES version: " + glGetString);
        }
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.progOES = loadShader("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.vPosOES = GLES20.glGetAttribLocation(this.progOES, "vPosition");
        this.vTCOES = GLES20.glGetAttribLocation(this.progOES, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.vPosOES);
        GLES20.glEnableVertexAttribArray(this.vTCOES);
        this.prog2D = loadShader("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.vPos2D = GLES20.glGetAttribLocation(this.prog2D, "vPosition");
        this.vTC2D = GLES20.glGetAttribLocation(this.prog2D, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.vPos2D);
        GLES20.glEnableVertexAttribArray(this.vTC2D);
    }
    
    private void initSurfaceTexture() {
        Log.d("CameraGLRendererBase", "initSurfaceTexture");
        this.deleteSurfaceTexture();
        this.initTexOES(this.texCamera);
        (this.mSTexture = new SurfaceTexture(this.texCamera[0])).setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
    }
    
    private void initTexOES(final int[] array) {
        if (array.length == 1) {
            GLES20.glGenTextures(1, array, 0);
            GLES20.glBindTexture(36197, array[0]);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glTexParameteri(36197, 10241, 9728);
            GLES20.glTexParameteri(36197, 10240, 9728);
        }
    }
    
    private static int loadShader(final String s, final String s2) {
        Log.d("CameraGLRendererBase", "loadShader");
        final int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, s);
        GLES20.glCompileShader(glCreateShader);
        final int[] array = { 0 };
        GLES20.glGetShaderiv(glCreateShader, 35713, array, 0);
        if (array[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile vertex shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        final int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, s2);
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, array, 0);
        if (array[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile fragment shader:" + GLES20.glGetShaderInfoLog(glCreateShader2));
            GLES20.glDeleteShader(glCreateShader);
            GLES20.glDeleteShader(glCreateShader2);
            return 0;
        }
        final int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, glCreateShader2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        GLES20.glGetProgramiv(glCreateProgram, 35714, array, 0);
        if (array[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not link shader program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            return 0;
        }
        GLES20.glValidateProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35715, array, 0);
        if (array[0] == 0) {
            Log.e("CameraGLRendererBase", "Shader program validation error: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        Log.d("CameraGLRendererBase", "Shader program is built OK");
        return glCreateProgram;
    }
    
    protected abstract void closeCamera();
    
    public void disableView() {
        synchronized (this) {
            Log.d("CameraGLRendererBase", "disableView");
            this.mEnabled = false;
            this.updateState();
        }
    }
    
    protected void doStart() {
        synchronized (this) {
            Log.d("CameraGLRendererBase", "doStart");
            this.initSurfaceTexture();
            this.openCamera(this.mCameraIndex);
            this.mIsStarted = true;
            if (this.mCameraWidth > 0 && this.mCameraHeight > 0) {
                this.setPreviewSize(this.mCameraWidth, this.mCameraHeight);
            }
        }
    }
    
    protected void doStop() {
        Log.d("CameraGLRendererBase", "doStop");
        synchronized (this) {
            this.mUpdateST = false;
            this.mIsStarted = false;
            this.mHaveFBO = false;
            this.closeCamera();
            this.deleteSurfaceTexture();
            // monitorexit(this)
            final CameraGLSurfaceView.CameraTextureListener cameraTextureListener = this.mView.getCameraTextureListener();
            if (cameraTextureListener != null) {
                cameraTextureListener.onCameraViewStopped();
            }
        }
    }
    
    public void enableView() {
        synchronized (this) {
            Log.d("CameraGLRendererBase", "enableView");
            this.mEnabled = true;
            this.updateState();
        }
    }
    
    public void onDrawFrame(final GL10 gl10) {
        if (!this.mHaveFBO) {
            return;
        }
        while (true) {
            Label_0128: {
                synchronized (this) {
                    if (this.mUpdateST) {
                        this.mSTexture.updateTexImage();
                        this.mUpdateST = false;
                    }
                    GLES20.glClear(16384);
                    final CameraGLSurfaceView.CameraTextureListener cameraTextureListener = this.mView.getCameraTextureListener();
                    if (cameraTextureListener == null) {
                        break Label_0128;
                    }
                    this.drawTex(this.texCamera[0], true, this.FBO[0]);
                    if (cameraTextureListener.onCameraTexture(this.texFBO[0], this.texDraw[0], this.mCameraWidth, this.mCameraHeight)) {
                        this.drawTex(this.texDraw[0], false, 0);
                        return;
                    }
                }
                this.drawTex(this.texFBO[0], false, 0);
                return;
            }
            Log.d("CameraGLRendererBase", "texCamera(OES) -> screen");
            this.drawTex(this.texCamera[0], true, 0);
        }
    }
    
    public void onFrameAvailable(final SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.mUpdateST = true;
            this.mView.requestRender();
        }
    }
    
    public void onPause() {
        Log.i("CameraGLRendererBase", "onPause");
        this.mHaveSurface = false;
        this.updateState();
        this.mCameraHeight = -1;
        this.mCameraWidth = -1;
    }
    
    public void onResume() {
        Log.i("CameraGLRendererBase", "onResume");
    }
    
    public void onSurfaceChanged(final GL10 gl10, final int n, final int n2) {
        Log.i("CameraGLRendererBase", "onSurfaceChanged(" + n + "x" + n2 + ")");
        this.mHaveSurface = true;
        this.updateState();
        this.setPreviewSize(n, n2);
    }
    
    public void onSurfaceCreated(final GL10 gl10, final EGLConfig eglConfig) {
        Log.i("CameraGLRendererBase", "onSurfaceCreated");
        this.initShaders();
    }
    
    protected abstract void openCamera(final int p0);
    
    public void setCameraIndex(final int mCameraIndex) {
        this.disableView();
        this.mCameraIndex = mCameraIndex;
        this.enableView();
    }
    
    protected abstract void setCameraPreviewSize(final int p0, final int p1);
    
    public void setMaxCameraPreviewSize(final int mMaxCameraWidth, final int mMaxCameraHeight) {
        this.disableView();
        this.mMaxCameraWidth = mMaxCameraWidth;
        this.mMaxCameraHeight = mMaxCameraHeight;
        this.enableView();
    }
    
    protected void setPreviewSize(final int mCameraWidth, final int mCameraHeight) {
        synchronized (this) {
            this.mHaveFBO = false;
            this.setCameraPreviewSize(this.mCameraWidth = mCameraWidth, this.mCameraHeight = mCameraHeight);
            this.initFBO(this.mCameraWidth, this.mCameraHeight);
            this.mHaveFBO = true;
            // monitorexit(this)
            final CameraGLSurfaceView.CameraTextureListener cameraTextureListener = this.mView.getCameraTextureListener();
            if (cameraTextureListener != null) {
                cameraTextureListener.onCameraViewStarted(this.mCameraWidth, this.mCameraHeight);
            }
        }
    }
    
    protected void updateState() {
        Log.d("CameraGLRendererBase", "updateState");
        Log.d("CameraGLRendererBase", "mEnabled=" + this.mEnabled + ", mHaveSurface=" + this.mHaveSurface);
        final boolean b = this.mEnabled && this.mHaveSurface && this.mView.getVisibility() == View.VISIBLE;
        if (b != this.mIsStarted) {
            if (b) {
                this.doStart();
            }
            else {
                this.doStop();
            }
        }
        else {
            Log.d("CameraGLRendererBase", "keeping State unchanged");
        }
        Log.d("CameraGLRendererBase", "updateState end");
    }
}

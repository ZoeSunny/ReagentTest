package org.opencv.android;

import android.graphics.Rect;
import android.util.*;
import org.opencv.*;
import android.content.res.*;
import android.content.*;
import android.app.*;
import java.util.*;
import org.opencv.core.*;
//import org.opencv.core.Rect;
import org.opencv.core.Size;

import android.graphics.*;
import android.view.*;

public abstract class CameraBridgeViewBase extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int CAMERA_ID_ANY = -1;
    public static final int CAMERA_ID_BACK = 99;
    public static final int CAMERA_ID_FRONT = 98;
    public static final int GRAY = 2;
    private static final int MAX_UNSPECIFIED = -1;
    public static final int RGBA = 1;
    private static final int STARTED = 1;
    private static final int STOPPED = 0;
    private static final String TAG = "CameraBridge";
    private Bitmap mCacheBitmap;
    protected int mCameraIndex;
    protected boolean mEnabled;
    protected FpsMeter mFpsMeter;
    protected int mFrameHeight;
    protected int mFrameWidth;
    private CvCameraViewListener2 mListener;
    protected int mMaxHeight;
    protected int mMaxWidth;
    protected int mPreviewFormat;
    protected float mScale;
    private int mState;
    private boolean mSurfaceExist;
    private Object mSyncObject;
    
    public CameraBridgeViewBase(final Context context, final int mCameraIndex) {
        super(context);
        this.mState = 0;
        this.mSyncObject = new Object();
        this.mScale = 0.0f;
        this.mPreviewFormat = 1;
        this.mCameraIndex = -1;
        this.mFpsMeter = null;
        this.mCameraIndex = mCameraIndex;
        this.getHolder().addCallback((SurfaceHolder.Callback)this);
        this.mMaxWidth = -1;
        this.mMaxHeight = -1;
    }
    
    public CameraBridgeViewBase(final Context context, final AttributeSet set) {
        super(context, set);
        this.mState = 0;
        this.mSyncObject = new Object();
        this.mScale = 0.0f;
        this.mPreviewFormat = 1;
        this.mCameraIndex = -1;
        this.mFpsMeter = null;
        Log.d("CameraBridge", "Attr count: " + (Object)set.getAttributeCount());
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, R.styleable.CameraBridgeViewBase);
        if (obtainStyledAttributes.getBoolean(R.styleable.CameraBridgeViewBase_show_fps, false)) {
            this.enableFpsMeter();
        }
        this.mCameraIndex = obtainStyledAttributes.getInt(R.styleable.CameraBridgeViewBase_camera_id, -1);
        this.getHolder().addCallback((SurfaceHolder.Callback)this);
        this.mMaxWidth = -1;
        this.mMaxHeight = -1;
        obtainStyledAttributes.recycle();
    }
    
    private void checkCurrentState() {
        Log.d("CameraBridge", "call checkCurrentState");
        boolean mState;
        if (this.mEnabled && this.mSurfaceExist && this.getVisibility() == VISIBLE) {
            mState = true;
        }
        else {
            mState = false;
        }
        if ((mState ? 1 : 0) != this.mState) {
            this.processExitState(this.mState);
            this.processEnterState(this.mState = (mState ? 1 : 0));
        }
    }
    
    private void onEnterStartedState() {
        Log.d("CameraBridge", "call onEnterStartedState");
        if (!this.connectCamera(this.getWidth(), this.getHeight())) {
            final AlertDialog create = new AlertDialog.Builder(this.getContext()).create();
            create.setCancelable(false);
            create.setMessage((CharSequence)"It seems that you device does not support camera (or it is locked). Application will be closed.");
            create.setButton(-3, (CharSequence)"OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    dialogInterface.dismiss();
                    ((Activity)CameraBridgeViewBase.this.getContext()).finish();
                }
            });
            create.show();
        }
    }
    
    private void onEnterStoppedState() {
    }
    
    private void onExitStartedState() {
        this.disconnectCamera();
        if (this.mCacheBitmap != null) {
            this.mCacheBitmap.recycle();
        }
    }
    
    private void onExitStoppedState() {
    }
    
    private void processEnterState(final int n) {
        Log.d("CameraBridge", "call processEnterState: " + n);
        switch (n) {
            case 1: {
                this.onEnterStartedState();
                if (this.mListener != null) {
                    this.mListener.onCameraViewStarted(this.mFrameWidth, this.mFrameHeight);
                    return;
                }
                break;
            }
            case 0: {
                this.onEnterStoppedState();
                if (this.mListener != null) {
                    this.mListener.onCameraViewStopped();
                    return;
                }
                break;
            }
        }
    }
    
    private void processExitState(final int n) {
        Log.d("CameraBridge", "call processExitState: " + n);
        switch (n) {
            default: {}
            case 1: {
                this.onExitStartedState();
            }
            case 0: {
                this.onExitStoppedState();
            }
        }
    }
    
    protected void AllocateCache() {
        this.mCacheBitmap = Bitmap.createBitmap(this.mFrameWidth, this.mFrameHeight, Bitmap.Config.ARGB_8888);
    }
    
    public void SetCaptureFormat(final int mPreviewFormat) {
        this.mPreviewFormat = mPreviewFormat;
        if (this.mListener instanceof CvCameraViewListenerAdapter) {
            ((CvCameraViewListenerAdapter)this.mListener).setFrameFormat(this.mPreviewFormat);
        }
    }
    
    protected Size calculateCameraFrameSize(final List<?> list, final ListItemAccessor listItemAccessor, int mMaxWidth, int mMaxHeight) {
        int n = 0;
        int n2 = 0;
        if (this.mMaxWidth != -1 && this.mMaxWidth < mMaxWidth) {
            mMaxWidth = this.mMaxWidth;
        }
        if (this.mMaxHeight != -1 && this.mMaxHeight < mMaxHeight) {
            mMaxHeight = this.mMaxHeight;
        }
        for (final Object next : list) {
            final int width = listItemAccessor.getWidth(next);
            final int height = listItemAccessor.getHeight(next);
            if (width <= mMaxWidth && height <= mMaxHeight && width >= n && height >= n2) {
                n = width;
                n2 = height;
            }
        }
        return new Size(n, n2);
    }
    
    protected abstract boolean connectCamera(final int p0, final int p1);
    
    protected void deliverAndDrawFrame(CvCameraViewFrame cvCameraViewFrame) {
    Label_0036:
        while (true) {
            while (true) {
                Label_0018: {
                    if (this.mListener != null) {
                        cvCameraViewFrame = (CvCameraViewFrame)this.mListener.onCameraFrame(cvCameraViewFrame);
                        break Label_0018;
                    }
//                    Label_0301: {
//                        break Label_0301;
//                        while (true) {
//                            while (true) {
//                                Label_0422: {
//                                    try {
//                                        Utils.matToBitmap((Mat)cvCameraViewFrame, this.mCacheBitmap);
//                                        int n = 0;
//                                        if (n != 0 && this.mCacheBitmap != null) {
//                                            cvCameraViewFrame = (CvCameraViewFrame)this.getHolder().lockCanvas();
//                                            if (cvCameraViewFrame != null) {
//                                                ((Canvas)cvCameraViewFrame).drawColor(0, PorterDuff.Mode.CLEAR);
//                                                Log.d("CameraBridge", "mStretch value: " + this.mScale);
//                                                if (this.mScale == 0.0f) {
//                                                    break Label_0422;
//                                                }
//                                                ((Canvas)cvCameraViewFrame).drawBitmap(this.mCacheBitmap, new Rect(0, 0, this.mCacheBitmap.getWidth(),
//                                                        this.mCacheBitmap.getHeight()), new Rect((int)((((Canvas)cvCameraViewFrame).getWidth()
//                                                        - this.mScale * this.mCacheBitmap.getWidth()) / 2.0f),
//                                                        (int)((((Canvas)cvCameraViewFrame).getHeight() - this.mScale * this.mCacheBitmap.getHeight())
//                                                                / 2.0f), (int)((((Canvas)cvCameraViewFrame).getWidth() - this.mScale *
//                                                        this.mCacheBitmap.getWidth()) / 2.0f + this.mScale * this.mCacheBitmap.getWidth()),
//                                                        (int)((((Canvas)cvCameraViewFrame).getHeight() - this.mScale * this.mCacheBitmap.getHeight())
//                                                                / 2.0f + this.mScale * this.mCacheBitmap.getHeight())), (Paint)null);
//                                                if (this.mFpsMeter != null) {
//                                                    this.mFpsMeter.measure();
//                                                    this.mFpsMeter.draw((Canvas)cvCameraViewFrame, 20.0f, 30.0f);
//                                                }
//                                                this.getHolder().unlockCanvasAndPost((Canvas)cvCameraViewFrame);
//                                            }
//                                        }
//                                        return;
//                                        cvCameraViewFrame = (CvCameraViewFrame)cvCameraViewFrame.rgba();
//                                        break;
//                                    }
//                                    catch (Exception ex) {
//                                        Log.e("CameraBridge", "Mat type: " + cvCameraViewFrame);
//                                        Log.e("CameraBridge", "Bitmap type: " + this.mCacheBitmap.getWidth() + "*" + this.mCacheBitmap.getHeight());
//                                        Log.e("CameraBridge", "Utils.matToBitmap() throws an exception: " + ex.getMessage());
//                                        final int n = 0;
//                                        continue Label_0036;
//                                    }
//                                }
//                                ((Canvas)cvCameraViewFrame).drawBitmap(this.mCacheBitmap, new Rect(0, 0, this.mCacheBitmap.getWidth(), this.mCacheBitmap.getHeight()), new Rect((((Canvas)cvCameraViewFrame).getWidth() - this.mCacheBitmap.getWidth()) / 2, (((Canvas)cvCameraViewFrame).getHeight() - this.mCacheBitmap.getHeight()) / 2, (((Canvas)cvCameraViewFrame).getWidth() - this.mCacheBitmap.getWidth()) / 2 + this.mCacheBitmap.getWidth(), (((Canvas)cvCameraViewFrame).getHeight() - this.mCacheBitmap.getHeight()) / 2 + this.mCacheBitmap.getHeight()), (Paint)null);
//                                continue;
//                            }
//                        }
//                    }
                }
                final int n = 1;
                if (cvCameraViewFrame != null) {
                    continue;
                }
                break;
            }
            continue Label_0036;
        }
    }
    
    public void disableFpsMeter() {
        this.mFpsMeter = null;
    }
    
    public void disableView() {
        synchronized (this.mSyncObject) {
            this.mEnabled = false;
            this.checkCurrentState();
        }
    }
    
    protected abstract void disconnectCamera();
    
    public void enableFpsMeter() {
        if (this.mFpsMeter == null) {
            (this.mFpsMeter = new FpsMeter()).setResolution(this.mFrameWidth, this.mFrameHeight);
        }
    }
    
    public void enableView() {
        synchronized (this.mSyncObject) {
            this.mEnabled = true;
            this.checkCurrentState();
        }
    }
    
    public void setCameraIndex(final int mCameraIndex) {
        this.mCameraIndex = mCameraIndex;
    }
    
    public void setCvCameraViewListener(final CvCameraViewListener2 mListener) {
        this.mListener = mListener;
    }
    
    public void setCvCameraViewListener(final CvCameraViewListener cvCameraViewListener) {
        final CvCameraViewListenerAdapter mListener = new CvCameraViewListenerAdapter(cvCameraViewListener);
        mListener.setFrameFormat(this.mPreviewFormat);
        this.mListener = (CvCameraViewListener2)mListener;
    }
    
    public void setMaxFrameSize(final int mMaxWidth, final int mMaxHeight) {
        this.mMaxWidth = mMaxWidth;
        this.mMaxHeight = mMaxHeight;
    }
    
    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
        Log.d("CameraBridge", "call surfaceChanged event");
        synchronized (this.mSyncObject) {
            if (!this.mSurfaceExist) {
                this.mSurfaceExist = true;
                this.checkCurrentState();
            }
            else {
                this.mSurfaceExist = false;
                this.checkCurrentState();
                this.mSurfaceExist = true;
                this.checkCurrentState();
            }
        }
    }
    
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
    }
    
    public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
        synchronized (this.mSyncObject) {
            this.mSurfaceExist = false;
            this.checkCurrentState();
        }
    }
    
    public interface CvCameraViewFrame
    {
        Mat gray();
        
        Mat rgba();
    }
    
    public interface CvCameraViewListener
    {
        Mat onCameraFrame(final Mat p0);
        
        void onCameraViewStarted(final int p0, final int p1);
        
        void onCameraViewStopped();
    }
    
    public interface CvCameraViewListener2
    {
        Mat onCameraFrame(final CvCameraViewFrame p0);
        
        void onCameraViewStarted(final int p0, final int p1);
        
        void onCameraViewStopped();
    }
    
    protected class CvCameraViewListenerAdapter implements CvCameraViewListener2
    {
        private CvCameraViewListener mOldStyleListener;
        private int mPreviewFormat;
        
        public CvCameraViewListenerAdapter(final CvCameraViewListener mOldStyleListener) {
            this.mPreviewFormat = 1;
            this.mOldStyleListener = mOldStyleListener;
        }
        
        @Override
        public Mat onCameraFrame(final CvCameraViewFrame cvCameraViewFrame) {
            switch (this.mPreviewFormat) {
                default: {
                    Log.e("CameraBridge", "Invalid frame format! Only RGBA and Gray Scale are supported!");
                    return null;
                }
                case 1: {
                    return this.mOldStyleListener.onCameraFrame(cvCameraViewFrame.rgba());
                }
                case 2: {
                    return this.mOldStyleListener.onCameraFrame(cvCameraViewFrame.gray());
                }
            }
        }
        
        @Override
        public void onCameraViewStarted(final int n, final int n2) {
            this.mOldStyleListener.onCameraViewStarted(n, n2);
        }
        
        @Override
        public void onCameraViewStopped() {
            this.mOldStyleListener.onCameraViewStopped();
        }
        
        public void setFrameFormat(final int mPreviewFormat) {
            this.mPreviewFormat = mPreviewFormat;
        }
    }
    
    public interface ListItemAccessor
    {
        int getHeight(final Object p0);
        
        int getWidth(final Object p0);
    }
}

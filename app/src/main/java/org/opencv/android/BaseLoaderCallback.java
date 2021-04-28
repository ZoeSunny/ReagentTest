package org.opencv.android;

import android.util.*;
import android.content.*;
import android.app.*;

public abstract class BaseLoaderCallback implements LoaderCallbackInterface
{
    private static final String TAG = "OpenCVLoader/BaseLoaderCallback";
    protected Context mAppContext;
    
    public BaseLoaderCallback(final Context mAppContext) {
        this.mAppContext = mAppContext;
    }
    
    void finish() {
        ((Activity)this.mAppContext).finish();
    }
    
    @Override
    public void onManagerConnected(final int n) {
        switch (n) {
            default: {
               // Log.e("OpenCVLoader/BaseLoaderCallback", "OpenCV loading failed!");
                final AlertDialog create = new AlertDialog.Builder(this.mAppContext).create();
                create.setTitle((CharSequence)"OpenCV error");
                create.setMessage((CharSequence)"OpenCV was not initialised correctly. Application will be shut down");
                create.setCancelable(false);
                create.setButton(-1, (CharSequence)"OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        BaseLoaderCallback.this.finish();
                    }
                });
                create.show();
            }
            case 0: {}
            case 2: {
              //  Log.e("OpenCVLoader/BaseLoaderCallback", "Package installation failed!");
                final AlertDialog create2 = new AlertDialog.Builder(this.mAppContext).create();
                create2.setTitle((CharSequence)"OpenCV Manager");
                create2.setMessage((CharSequence)"Package installation failed!");
                create2.setCancelable(false);
                create2.setButton(-1, (CharSequence)"OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        BaseLoaderCallback.this.finish();
                    }
                });
                create2.show();
            }
            case 3: {
              //  Log.d("OpenCVLoader/BaseLoaderCallback", "OpenCV library instalation was canceled by user");
                this.finish();
            }
            case 4: {
                //Log.d("OpenCVLoader/BaseLoaderCallback", "OpenCV Manager Service is uncompatible with this app!");
                final AlertDialog create3 = new AlertDialog.Builder(this.mAppContext).create();
                create3.setTitle((CharSequence)"OpenCV Manager");
                create3.setMessage((CharSequence)"OpenCV Manager service is incompatible with this app. Try to update it via Google Play.");
                create3.setCancelable(false);
                create3.setButton(-1, (CharSequence)"OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        BaseLoaderCallback.this.finish();
                    }
                });
                create3.show();
            }
        }
    }
    
    @Override
    public void onPackageInstall(final int n, final InstallCallbackInterface installCallbackInterface) {
        switch (n) {
            default: {}
            case 0: {
                final AlertDialog create = new AlertDialog.Builder(this.mAppContext).create();
                create.setTitle((CharSequence)"Package not found");
                create.setMessage((CharSequence)(installCallbackInterface.getPackageName() + " package was not found! Try to install it?"));
                create.setCancelable(false);
                create.setButton(-1, (CharSequence)"Yes", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        installCallbackInterface.install();
                    }
                });
                create.setButton(-2, (CharSequence)"No", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        installCallbackInterface.cancel();
                    }
                });
                create.show();
            }
            case 1: {
                final AlertDialog create2 = new AlertDialog.Builder(this.mAppContext).create();
                create2.setTitle((CharSequence)"OpenCV is not ready");
                create2.setMessage((CharSequence)"Installation is in progress. Wait or exit?");
                create2.setCancelable(false);
                create2.setButton(-1, (CharSequence)"Wait", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        installCallbackInterface.wait_install();
                    }
                });
                create2.setButton(-2, (CharSequence)"Exit", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        installCallbackInterface.cancel();
                    }
                });
                create2.show();
            }
        }
    }
}

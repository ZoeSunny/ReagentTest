package org.opencv.android;

import org.opencv.engine.*;
import android.util.*;
import android.os.*;
import org.opencv.core.*;
import android.net.*;
import android.content.*;
import java.util.*;
import java.io.*;

class AsyncServiceHelper
{
    protected static final int MINIMUM_ENGINE_VERSION = 2;
    protected static final String OPEN_CV_SERVICE_URL = "market://details?id=org.opencv.engine";
    protected static final String TAG = "OpenCVManager/Helper";
    protected static boolean mLibraryInstallationProgress;
    protected static boolean mServiceInstallationProgress;
    protected Context mAppContext;
    protected OpenCVEngineInterface mEngineService;
    protected String mOpenCVersion;
    protected ServiceConnection mServiceConnection;
    protected LoaderCallbackInterface mUserAppCallback;
    
    static {
        AsyncServiceHelper.mServiceInstallationProgress = false;
        AsyncServiceHelper.mLibraryInstallationProgress = false;
    }
    
    protected AsyncServiceHelper(final String mOpenCVersion, final Context mAppContext, final LoaderCallbackInterface mUserAppCallback) {
        this.mServiceConnection = (ServiceConnection)new ServiceConnection() {
            public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
                int i = 0;
                Log.d("OpenCVManager/Helper", "Service connection created");
                AsyncServiceHelper.this.mEngineService = OpenCVEngineInterface.Stub.asInterface(binder);
                if (AsyncServiceHelper.this.mEngineService == null) {
                    Log.d("OpenCVManager/Helper", "OpenCV Manager Service connection fails. May be service was not installed?");
                    AsyncServiceHelper.InstallService(AsyncServiceHelper.this.mAppContext, AsyncServiceHelper.this.mUserAppCallback);
                    return;
                }
                AsyncServiceHelper.mServiceInstallationProgress = false;
                try {
                    if (AsyncServiceHelper.this.mEngineService.getEngineVersion() < 2) {
                        Log.d("OpenCVManager/Helper", "Init finished with status 4");
                        Log.d("OpenCVManager/Helper", "Unbind from service");
                        AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                        Log.d("OpenCVManager/Helper", "Calling using callback");
                        AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(4);
                        return;
                    }
                }
                catch (RemoteException ex) {
                    ex.printStackTrace();
                    Log.d("OpenCVManager/Helper", "Init finished with status 255");
                    Log.d("OpenCVManager/Helper", "Unbind from service");
                    AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                    Log.d("OpenCVManager/Helper", "Calling using callback");
                    AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(255);
                    return;
                }
                Log.d("OpenCVManager/Helper", "Trying to get library path");
                String libPathByVersion = null;
                try {
                    libPathByVersion = AsyncServiceHelper.this.mEngineService.getLibPathByVersion(AsyncServiceHelper.this.mOpenCVersion);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if (libPathByVersion != null && libPathByVersion.length() != 0) {
                    Log.d("OpenCVManager/Helper", "Trying to get library list");
                    AsyncServiceHelper.mLibraryInstallationProgress = false;
                     String libraryList = null;
                    try {
                        libraryList = AsyncServiceHelper.this.mEngineService.getLibraryList(AsyncServiceHelper.this.mOpenCVersion);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    Log.d("OpenCVManager/Helper", "Library list: \"" + libraryList + "\"");
                    Log.d("OpenCVManager/Helper", "First attempt to load libs");
                    int n;
                    if (AsyncServiceHelper.this.initOpenCVLibs(libPathByVersion, libraryList)) {
                        Log.d("OpenCVManager/Helper", "First attempt to load libs is OK");
                        for (String[] split = Core.getBuildInformation().split(System.getProperty("line.separator")); i < split.length; ++i) {
                            Log.i("OpenCVManager/Helper", split[i]);
                        }
                        n = 0;
                    }
                    else {
                        Log.d("OpenCVManager/Helper", "First attempt to load libs fails");
                        n = 255;
                    }
                    Log.d("OpenCVManager/Helper", "Init finished with status " + n);
                    Log.d("OpenCVManager/Helper", "Unbind from service");
                    AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                    Log.d("OpenCVManager/Helper", "Calling using callback");
                    AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(n);
                    return;
                }
                if (!AsyncServiceHelper.mLibraryInstallationProgress) {
                    AsyncServiceHelper.this.mUserAppCallback.onPackageInstall(0, new InstallCallbackInterface() {
                        @Override
                        public void cancel() {
                            Log.d("OpenCVManager/Helper", "OpenCV library installation was canceled");
                            Log.d("OpenCVManager/Helper", "Init finished with status 3");
                            Log.d("OpenCVManager/Helper", "Unbind from service");
                            AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                            Log.d("OpenCVManager/Helper", "Calling using callback");
                            AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(3);
                        }
                        
                        @Override
                        public String getPackageName() {
                            return "OpenCV library";
                        }
                        
                        @Override
                        public void install() {
                            Log.d("OpenCVManager/Helper", "Trying to install OpenCV lib via Google Play");
                            try {
                                if (AsyncServiceHelper.this.mEngineService.installVersion(AsyncServiceHelper.this.mOpenCVersion)) {
                                    AsyncServiceHelper.mLibraryInstallationProgress = true;
                                    Log.d("OpenCVManager/Helper", "Package installation statred");
                                    Log.d("OpenCVManager/Helper", "Unbind from service");
                                    AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                                    return;
                                }
                                Log.d("OpenCVManager/Helper", "OpenCV package was not installed!");
                                Log.d("OpenCVManager/Helper", "Init finished with status 2");
                                Log.d("OpenCVManager/Helper", "Unbind from service");
                                AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                                Log.d("OpenCVManager/Helper", "Calling using callback");
                                AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(2);
                            }
                            catch (RemoteException ex) {
                                ex.printStackTrace();
                                Log.d("OpenCVManager/Helper", "Init finished with status 255");
                                Log.d("OpenCVManager/Helper", "Unbind from service");
                                AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                                Log.d("OpenCVManager/Helper", "Calling using callback");
                                AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(255);
                            }
                        }
                        
                        @Override
                        public void wait_install() {
                            Log.e("OpenCVManager/Helper", "Instalation was not started! Nothing to wait!");
                        }
                    });
                    return;
                }
                AsyncServiceHelper.this.mUserAppCallback.onPackageInstall(1, new InstallCallbackInterface() {
                    @Override
                    public void cancel() {
                        Log.d("OpenCVManager/Helper", "OpenCV library installation was canceled");
                        AsyncServiceHelper.mLibraryInstallationProgress = false;
                        Log.d("OpenCVManager/Helper", "Init finished with status 3");
                        Log.d("OpenCVManager/Helper", "Unbind from service");
                        AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                        Log.d("OpenCVManager/Helper", "Calling using callback");
                        AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(3);
                    }
                    
                    @Override
                    public String getPackageName() {
                        return "OpenCV library";
                    }
                    
                    @Override
                    public void install() {
                        Log.e("OpenCVManager/Helper", "Nothing to install we just wait current installation");
                    }
                    
                    @Override
                    public void wait_install() {
                        Log.d("OpenCVManager/Helper", "Waiting for current installation");
                        try {
                            if (!AsyncServiceHelper.this.mEngineService.installVersion(AsyncServiceHelper.this.mOpenCVersion)) {
                                Log.d("OpenCVManager/Helper", "OpenCV package was not installed!");
                                Log.d("OpenCVManager/Helper", "Init finished with status 2");
                                Log.d("OpenCVManager/Helper", "Calling using callback");
                                AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(2);
                            }
                            else {
                                Log.d("OpenCVManager/Helper", "Wating for package installation");
                            }
                            Log.d("OpenCVManager/Helper", "Unbind from service");
                            AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                        }
                        catch (RemoteException ex) {
                            ex.printStackTrace();
                            Log.d("OpenCVManager/Helper", "Init finished with status 255");
                            Log.d("OpenCVManager/Helper", "Unbind from service");
                            AsyncServiceHelper.this.mAppContext.unbindService(AsyncServiceHelper.this.mServiceConnection);
                            Log.d("OpenCVManager/Helper", "Calling using callback");
                            AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(255);
                        }
                    }
                });
            }
            
            public void onServiceDisconnected(final ComponentName componentName) {
                AsyncServiceHelper.this.mEngineService = null;
            }
        };
        this.mOpenCVersion = mOpenCVersion;
        this.mUserAppCallback = mUserAppCallback;
        this.mAppContext = mAppContext;
    }
    
    protected static void InstallService(final Context context, final LoaderCallbackInterface loaderCallbackInterface) {
        if (!AsyncServiceHelper.mServiceInstallationProgress) {
            Log.d("OpenCVManager/Helper", "Request new service installation");
            loaderCallbackInterface.onPackageInstall(0, new InstallCallbackInterface() {
                private LoaderCallbackInterface mUserAppCallback = loaderCallbackInterface;
                
                @Override
                public void cancel() {
                    Log.d("OpenCVManager/Helper", "OpenCV library installation was canceled");
                    Log.d("OpenCVManager/Helper", "Init finished with status " + 3);
                    Log.d("OpenCVManager/Helper", "Calling using callback");
                    this.mUserAppCallback.onManagerConnected(3);
                }
                
                @Override
                public String getPackageName() {
                    return "OpenCV Manager";
                }
                
                @Override
                public void install() {
                    Log.d("OpenCVManager/Helper", "Trying to install OpenCV Manager via Google Play");
                    if (AsyncServiceHelper.InstallServiceQuiet(context)) {
                        AsyncServiceHelper.mServiceInstallationProgress = true;
                        Log.d("OpenCVManager/Helper", "Package installation started");
                        return;
                    }
                    Log.d("OpenCVManager/Helper", "OpenCV package was not installed!");
                    Log.d("OpenCVManager/Helper", "Init finished with status " + 2);
                    Log.d("OpenCVManager/Helper", "Unbind from service");
                    Log.d("OpenCVManager/Helper", "Calling using callback");
                    this.mUserAppCallback.onManagerConnected(2);
                }
                
                @Override
                public void wait_install() {
                    Log.e("OpenCVManager/Helper", "Instalation was not started! Nothing to wait!");
                }
            });
            return;
        }
        Log.d("OpenCVManager/Helper", "Waiting current installation process");
        loaderCallbackInterface.onPackageInstall(1, new InstallCallbackInterface() {
            private LoaderCallbackInterface mUserAppCallback = loaderCallbackInterface;
            
            @Override
            public void cancel() {
                Log.d("OpenCVManager/Helper", "Wating for OpenCV canceled by user");
                AsyncServiceHelper.mServiceInstallationProgress = false;
                Log.d("OpenCVManager/Helper", "Init finished with status " + 3);
                Log.d("OpenCVManager/Helper", "Calling using callback");
                this.mUserAppCallback.onManagerConnected(3);
            }
            
            @Override
            public String getPackageName() {
                return "OpenCV Manager";
            }
            
            @Override
            public void install() {
                Log.e("OpenCVManager/Helper", "Nothing to install we just wait current installation");
            }
            
            @Override
            public void wait_install() {
                AsyncServiceHelper.InstallServiceQuiet(context);
            }
        });
    }
    
    protected static boolean InstallServiceQuiet(final Context context) {
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=org.opencv.engine"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
    
    public static boolean initOpenCV(final String s, final Context context, final LoaderCallbackInterface loaderCallbackInterface) {
        final AsyncServiceHelper asyncServiceHelper = new AsyncServiceHelper(s, context, loaderCallbackInterface);
        final Intent intent = new Intent("org.opencv.engine.BIND");
        intent.setPackage("org.opencv.engine");
        if (context.bindService(intent, asyncServiceHelper.mServiceConnection, Context.BIND_AUTO_CREATE)) {
            return true;
        }
        context.unbindService(asyncServiceHelper.mServiceConnection);
        InstallService(context, loaderCallbackInterface);
        return false;
    }
    
    private boolean initOpenCVLibs(final String s, final String s2) {
        Log.d("OpenCVManager/Helper", "Trying to init OpenCV libs");
        if (s != null && s.length() != 0) {
            int n = 1;
            boolean b;
            if (s2 != null && s2.length() != 0) {
                Log.d("OpenCVManager/Helper", "Trying to load libs by dependency list");
                final StringTokenizer stringTokenizer = new StringTokenizer(s2, ";");
                while (true) {
                    b = (n != 0);
                    if (!stringTokenizer.hasMoreTokens()) {
                        break;
                    }
                    n &= (this.loadLibrary(s + File.separator + stringTokenizer.nextToken()) ? 1 : 0);
                }
            }
            else {
                b = (true & this.loadLibrary(s + File.separator + "libopencv_java3.so"));
            }
            return b;
        }
        Log.d("OpenCVManager/Helper", "Library path \"" + s + "\" is empty");
        return false;
    }
    
    private boolean loadLibrary(final String s) {
        Log.d("OpenCVManager/Helper", "Trying to load library " + s);
        try {
            System.load(s);
            Log.d("OpenCVManager/Helper", "OpenCV libs init was ok!");
            return true;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            Log.d("OpenCVManager/Helper", "Cannot load library \"" + s + "\"");
            unsatisfiedLinkError.printStackTrace();
            return true & false;
        }
    }
}

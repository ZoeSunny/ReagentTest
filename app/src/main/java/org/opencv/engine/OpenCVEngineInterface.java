package org.opencv.engine;

import android.os.*;

public interface OpenCVEngineInterface extends IInterface
{
    int getEngineVersion() throws RemoteException;
    
    String getLibPathByVersion(final String p0) throws RemoteException;
    
    String getLibraryList(final String p0) throws RemoteException;
    
    boolean installVersion(final String p0) throws RemoteException;
    
    public abstract static class Stub extends Binder implements OpenCVEngineInterface
    {
        private static final String DESCRIPTOR = "org.opencv.engine.OpenCVEngineInterface";
        static final int TRANSACTION_getEngineVersion = 1;
        static final int TRANSACTION_getLibPathByVersion = 2;
        static final int TRANSACTION_getLibraryList = 4;
        static final int TRANSACTION_installVersion = 3;
        
        public Stub() {
            this.attachInterface((IInterface)this, "org.opencv.engine.OpenCVEngineInterface");
        }
        
        public static OpenCVEngineInterface asInterface(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("org.opencv.engine.OpenCVEngineInterface");
            if (queryLocalInterface != null && queryLocalInterface instanceof OpenCVEngineInterface) {
                return (OpenCVEngineInterface)queryLocalInterface;
            }
            return new Proxy(binder);
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(int engineVersion, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
            switch (engineVersion) {
                default: {
                    return super.onTransact(engineVersion, parcel, parcel2, n);
                }
                case 1598968902: {
                    parcel2.writeString("org.opencv.engine.OpenCVEngineInterface");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                    engineVersion = this.getEngineVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(engineVersion);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                    final String libPathByVersion = this.getLibPathByVersion(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(libPathByVersion);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                    final boolean installVersion = this.installVersion(parcel.readString());
                    parcel2.writeNoException();
                    if (installVersion) {
                        engineVersion = 1;
                    }
                    else {
                        engineVersion = 0;
                    }
                    parcel2.writeInt(engineVersion);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                    final String libraryList = this.getLibraryList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(libraryList);
                    return true;
                }
            }
        }
        
        private static class Proxy implements OpenCVEngineInterface
        {
            private IBinder mRemote;
            
            Proxy(final IBinder mRemote) {
                this.mRemote = mRemote;
            }
            
            public IBinder asBinder() {
                return this.mRemote;
            }
            
            @Override
            public int getEngineVersion() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            public String getInterfaceDescriptor() {
                return "org.opencv.engine.OpenCVEngineInterface";
            }
            
            @Override
            public String getLibPathByVersion(String string) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(string);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    string = obtain2.readString();
                    return string;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public String getLibraryList(String string) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(string);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    string = obtain2.readString();
                    return string;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean installVersion(final String s) throws RemoteException {
                boolean b = false;
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(s);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

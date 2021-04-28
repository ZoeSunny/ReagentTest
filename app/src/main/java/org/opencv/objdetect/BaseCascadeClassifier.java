package org.opencv.objdetect;

import org.opencv.core.*;

public class BaseCascadeClassifier extends Algorithm
{
    protected BaseCascadeClassifier(final long n) {
        super(n);
    }
    
    private static native void delete(final long p0);
    
    @Override
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}

package org.opencv.core;

public class CvException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public CvException(final String s) {
        super(s);
    }
    
    @Override
    public String toString() {
        return "CvException [" + super.toString() + "]";
    }
}

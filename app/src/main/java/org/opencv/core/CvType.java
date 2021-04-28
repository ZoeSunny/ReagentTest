package org.opencv.core;

public final class CvType
{
    public static final int CV_16S = 3;
    public static final int CV_16SC1;
    public static final int CV_16SC2;
    public static final int CV_16SC3;
    public static final int CV_16SC4;
    public static final int CV_16U = 2;
    public static final int CV_16UC1;
    public static final int CV_16UC2;
    public static final int CV_16UC3;
    public static final int CV_16UC4;
    public static final int CV_32F = 5;
    public static final int CV_32FC1;
    public static final int CV_32FC2;
    public static final int CV_32FC3;
    public static final int CV_32FC4;
    public static final int CV_32S = 4;
    public static final int CV_32SC1;
    public static final int CV_32SC2;
    public static final int CV_32SC3;
    public static final int CV_32SC4;
    public static final int CV_64F = 6;
    public static final int CV_64FC1;
    public static final int CV_64FC2;
    public static final int CV_64FC3;
    public static final int CV_64FC4;
    public static final int CV_8S = 1;
    public static final int CV_8SC1;
    public static final int CV_8SC2;
    public static final int CV_8SC3;
    public static final int CV_8SC4;
    public static final int CV_8U = 0;
    public static final int CV_8UC1;
    public static final int CV_8UC2;
    public static final int CV_8UC3;
    public static final int CV_8UC4;
    private static final int CV_CN_MAX = 512;
    private static final int CV_CN_SHIFT = 3;
    private static final int CV_DEPTH_MAX = 8;
    public static final int CV_USRTYPE1 = 7;
    
    static {
        CV_8UC1 = CV_8UC(1);
        CV_8UC2 = CV_8UC(2);
        CV_8UC3 = CV_8UC(3);
        CV_8UC4 = CV_8UC(4);
        CV_8SC1 = CV_8SC(1);
        CV_8SC2 = CV_8SC(2);
        CV_8SC3 = CV_8SC(3);
        CV_8SC4 = CV_8SC(4);
        CV_16UC1 = CV_16UC(1);
        CV_16UC2 = CV_16UC(2);
        CV_16UC3 = CV_16UC(3);
        CV_16UC4 = CV_16UC(4);
        CV_16SC1 = CV_16SC(1);
        CV_16SC2 = CV_16SC(2);
        CV_16SC3 = CV_16SC(3);
        CV_16SC4 = CV_16SC(4);
        CV_32SC1 = CV_32SC(1);
        CV_32SC2 = CV_32SC(2);
        CV_32SC3 = CV_32SC(3);
        CV_32SC4 = CV_32SC(4);
        CV_32FC1 = CV_32FC(1);
        CV_32FC2 = CV_32FC(2);
        CV_32FC3 = CV_32FC(3);
        CV_32FC4 = CV_32FC(4);
        CV_64FC1 = CV_64FC(1);
        CV_64FC2 = CV_64FC(2);
        CV_64FC3 = CV_64FC(3);
        CV_64FC4 = CV_64FC(4);
    }
    
    public static final int CV_16SC(final int n) {
        return makeType(3, n);
    }
    
    public static final int CV_16UC(final int n) {
        return makeType(2, n);
    }
    
    public static final int CV_32FC(final int n) {
        return makeType(5, n);
    }
    
    public static final int CV_32SC(final int n) {
        return makeType(4, n);
    }
    
    public static final int CV_64FC(final int n) {
        return makeType(6, n);
    }
    
    public static final int CV_8SC(final int n) {
        return makeType(1, n);
    }
    
    public static final int CV_8UC(final int n) {
        return makeType(0, n);
    }
    
    public static final int ELEM_SIZE(final int n) {
        switch (depth(n)) {
            default: {
                throw new UnsupportedOperationException("Unsupported CvType value: " + n);
            }
            case 0:
            case 1: {
                return channels(n);
            }
            case 2:
            case 3: {
                return channels(n) * 2;
            }
            case 4:
            case 5: {
                return channels(n) * 4;
            }
            case 6: {
                return channels(n) * 8;
            }
        }
    }
    
    public static final int channels(final int n) {
        return (n >> 3) + 1;
    }
    
    public static final int depth(final int n) {
        return n & 0x7;
    }
    
    public static final boolean isInteger(final int n) {
        return depth(n) < 5;
    }
    
    public static final int makeType(final int n, final int n2) {
        if (n2 <= 0 || n2 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        }
        if (n < 0 || n >= 8) {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
        return (n & 0x7) + (n2 - 1 << 3);
    }
    
    public static final String typeToString(int channels) {
        String s = null;
        switch (depth(channels)) {
            default: {
                throw new UnsupportedOperationException("Unsupported CvType value: " + channels);
            }
            case 0: {
                s = "CV_8U";
                break;
            }
            case 1: {
                s = "CV_8S";
                break;
            }
            case 2: {
                s = "CV_16U";
                break;
            }
            case 3: {
                s = "CV_16S";
                break;
            }
            case 4: {
                s = "CV_32S";
                break;
            }
            case 5: {
                s = "CV_32F";
                break;
            }
            case 6: {
                s = "CV_64F";
                break;
            }
            case 7: {
                s = "CV_USRTYPE1";
                break;
            }
        }
        channels = channels(channels);
        if (channels <= 4) {
            return s + "C" + channels;
        }
        return s + "C(" + channels + ")";
    }
}

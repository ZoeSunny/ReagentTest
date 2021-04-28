package org.opencv.utils;

import java.util.*;
import org.opencv.core.*;

public class Converters
{
    public static void Mat_to_vector_DMatch(final Mat mat, final List<DMatch> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        final int rows = mat.rows();
        if (CvType.CV_64FC4 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_64FC4 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        final double[] array = new double[rows * 4];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(new DMatch((int)array[i * 4], (int)array[i * 4 + 1], (int)array[i * 4 + 2], (float)array[i * 4 + 3]));
        }
    }
    
    public static void Mat_to_vector_KeyPoint(final Mat mat, final List<KeyPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        final int rows = mat.rows();
        if (CvType.CV_64FC(7) != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_64FC(7) != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        final double[] array = new double[rows * 7];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(new KeyPoint((float)array[i * 7], (float)array[i * 7 + 1], (float)array[i * 7 + 2], (float)array[i * 7 + 3], (float)array[i * 7 + 4], (int)array[i * 7 + 5], (int)array[i * 7 + 6]));
        }
    }
    
    public static void Mat_to_vector_Mat(final Mat mat, final List<Mat> list) {
        if (list == null) {
            throw new IllegalArgumentException("mats == null");
        }
        final int rows = mat.rows();
        if (CvType.CV_32SC2 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32SC2 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        final int[] array = new int[rows * 2];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(new Mat((long)array[i * 2] << 32 | ((long)array[i * 2 + 1] & 0xFFFFFFFFL)));
        }
    }
    
    public static void Mat_to_vector_Point(final Mat mat, final List<Point> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        final int rows = mat.rows();
        final int type = mat.type();
        if (mat.cols() != 1) {
            throw new IllegalArgumentException("Input Mat should have one column\n" + mat);
        }
        list.clear();
        if (type == CvType.CV_32SC2) {
            final int[] array = new int[rows * 2];
            mat.get(0, 0, array);
            for (int i = 0; i < rows; ++i) {
                list.add(new Point(array[i * 2], array[i * 2 + 1]));
            }
        }
        else if (type == CvType.CV_32FC2) {
            final float[] array2 = new float[rows * 2];
            mat.get(0, 0, array2);
            for (int j = 0; j < rows; ++j) {
                list.add(new Point(array2[j * 2], array2[j * 2 + 1]));
            }
        }
        else {
            if (type != CvType.CV_64FC2) {
                throw new IllegalArgumentException("Input Mat should be of CV_32SC2, CV_32FC2 or CV_64FC2 type\n" + mat);
            }
            final double[] array3 = new double[rows * 2];
            mat.get(0, 0, array3);
            for (int k = 0; k < rows; ++k) {
                list.add(new Point(array3[k * 2], array3[k * 2 + 1]));
            }
        }
    }
    
    public static void Mat_to_vector_Point2d(final Mat mat, final List<Point> list) {
        Mat_to_vector_Point(mat, list);
    }
    
    public static void Mat_to_vector_Point2f(final Mat mat, final List<Point> list) {
        Mat_to_vector_Point(mat, list);
    }
    
    public static void Mat_to_vector_Point3(final Mat mat, final List<Point3> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        final int rows = mat.rows();
        final int type = mat.type();
        if (mat.cols() != 1) {
            throw new IllegalArgumentException("Input Mat should have one column\n" + mat);
        }
        list.clear();
        if (type == CvType.CV_32SC3) {
            final int[] array = new int[rows * 3];
            mat.get(0, 0, array);
            for (int i = 0; i < rows; ++i) {
                list.add(new Point3(array[i * 3], array[i * 3 + 1], array[i * 3 + 2]));
            }
        }
        else if (type == CvType.CV_32FC3) {
            final float[] array2 = new float[rows * 3];
            mat.get(0, 0, array2);
            for (int j = 0; j < rows; ++j) {
                list.add(new Point3(array2[j * 3], array2[j * 3 + 1], array2[j * 3 + 2]));
            }
        }
        else {
            if (type != CvType.CV_64FC3) {
                throw new IllegalArgumentException("Input Mat should be of CV_32SC3, CV_32FC3 or CV_64FC3 type\n" + mat);
            }
            final double[] array3 = new double[rows * 3];
            mat.get(0, 0, array3);
            for (int k = 0; k < rows; ++k) {
                list.add(new Point3(array3[k * 3], array3[k * 3 + 1], array3[k * 3 + 2]));
            }
        }
    }
    
    public static void Mat_to_vector_Point3d(final Mat mat, final List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }
    
    public static void Mat_to_vector_Point3f(final Mat mat, final List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }
    
    public static void Mat_to_vector_Point3i(final Mat mat, final List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }
    
    public static void Mat_to_vector_Rect(final Mat mat, final List<Rect> list) {
        if (list == null) {
            throw new IllegalArgumentException("rs == null");
        }
        final int rows = mat.rows();
        if (CvType.CV_32SC4 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32SC4 != m.type() ||  m.rows()!=1\n" + mat);
        }
        list.clear();
        final int[] array = new int[rows * 4];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(new Rect(array[i * 4], array[i * 4 + 1], array[i * 4 + 2], array[i * 4 + 3]));
        }
    }
    
    public static void Mat_to_vector_char(final Mat mat, final List<Byte> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        final int rows = mat.rows();
        if (CvType.CV_8SC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_8SC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        final byte[] array = new byte[rows];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(array[i]);
        }
    }
    
    public static void Mat_to_vector_double(final Mat mat, final List<Double> list) {
        if (list == null) {
            throw new IllegalArgumentException("ds == null");
        }
        final int rows = mat.rows();
        if (CvType.CV_64FC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_64FC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        final double[] array = new double[rows];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(array[i]);
        }
    }
    
    public static void Mat_to_vector_float(final Mat mat, final List<Float> list) {
        if (list == null) {
            throw new IllegalArgumentException("fs == null");
        }
        final int rows = mat.rows();
        if (CvType.CV_32FC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32FC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        final float[] array = new float[rows];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(array[i]);
        }
    }
    
    public static void Mat_to_vector_int(final Mat mat, final List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("is == null");
        }
        final int rows = mat.rows();
        if (CvType.CV_32SC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32SC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        final int[] array = new int[rows];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(array[i]);
        }
    }
    
    public static void Mat_to_vector_uchar(final Mat mat, final List<Byte> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        final int rows = mat.rows();
        if (CvType.CV_8UC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_8UC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        final byte[] array = new byte[rows];
        mat.get(0, 0, array);
        for (int i = 0; i < rows; ++i) {
            list.add(array[i]);
        }
    }
    
    public static void Mat_to_vector_vector_DMatch(final Mat mat, final List<MatOfDMatch> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        final ArrayList<Mat> list2 = new ArrayList<Mat>(mat.rows());
        Mat_to_vector_Mat(mat, list2);
        list.clear();
        for (final Mat mat2 : list2) {
            list.add(new MatOfDMatch(mat2));
            mat2.release();
        }
        list2.clear();
    }
    
    public static void Mat_to_vector_vector_KeyPoint(final Mat mat, final List<MatOfKeyPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        final ArrayList<Mat> list2 = new ArrayList<Mat>(mat.rows());
        Mat_to_vector_Mat(mat, list2);
        for (final Mat mat2 : list2) {
            list.add(new MatOfKeyPoint(mat2));
            mat2.release();
        }
        list2.clear();
    }
    
    public static void Mat_to_vector_vector_Point(final Mat mat, final List<MatOfPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        final ArrayList<Mat> list2 = new ArrayList<Mat>(mat.rows());
        Mat_to_vector_Mat(mat, list2);
        for (final Mat mat2 : list2) {
            list.add(new MatOfPoint(mat2));
            mat2.release();
        }
        list2.clear();
    }
    
    public static void Mat_to_vector_vector_Point2f(final Mat mat, final List<MatOfPoint2f> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        final ArrayList<Mat> list2 = new ArrayList<Mat>(mat.rows());
        Mat_to_vector_Mat(mat, list2);
        for (final Mat mat2 : list2) {
            list.add(new MatOfPoint2f(mat2));
            mat2.release();
        }
        list2.clear();
    }
    
    public static void Mat_to_vector_vector_Point3f(final Mat mat, final List<MatOfPoint3f> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        final ArrayList<Mat> list2 = new ArrayList<Mat>(mat.rows());
        Mat_to_vector_Mat(mat, list2);
        for (final Mat mat2 : list2) {
            list.add(new MatOfPoint3f(mat2));
            mat2.release();
        }
        list2.clear();
    }
    
    public static void Mat_to_vector_vector_char(final Mat mat, final List<List<Byte>> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        final ArrayList<Mat> list2 = new ArrayList<Mat>(mat.rows());
        Mat_to_vector_Mat(mat, list2);
        for (final Mat mat2 : list2) {
            final ArrayList<Byte> list3 = new ArrayList<Byte>();
            Mat_to_vector_char(mat2, list3);
            list.add(list3);
            mat2.release();
        }
        list2.clear();
    }
    
    public static Mat vector_DMatch_to_Mat(final List<DMatch> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_64FC4);
            final double[] array = new double[size * 4];
            for (int i = 0; i < size; ++i) {
                final DMatch dMatch = list.get(i);
                array[i * 4] = dMatch.queryIdx;
                array[i * 4 + 1] = dMatch.trainIdx;
                array[i * 4 + 2] = dMatch.imgIdx;
                array[i * 4 + 3] = dMatch.distance;
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_KeyPoint_to_Mat(final List<KeyPoint> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_64FC(7));
            final double[] array = new double[size * 7];
            for (int i = 0; i < size; ++i) {
                final KeyPoint keyPoint = list.get(i);
                array[i * 7] = keyPoint.pt.x;
                array[i * 7 + 1] = keyPoint.pt.y;
                array[i * 7 + 2] = keyPoint.size;
                array[i * 7 + 3] = keyPoint.angle;
                array[i * 7 + 4] = keyPoint.response;
                array[i * 7 + 5] = keyPoint.octave;
                array[i * 7 + 6] = keyPoint.class_id;
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_Mat_to_Mat(final List<Mat> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_32SC2);
            final int[] array = new int[size * 2];
            for (int i = 0; i < size; ++i) {
                final long nativeObj = list.get(i).nativeObj;
                array[i * 2] = (int)(nativeObj >> 32);
                array[i * 2 + 1] = (int)(-1L & nativeObj);
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_Point2d_to_Mat(final List<Point> list) {
        return vector_Point_to_Mat(list, 6);
    }
    
    public static Mat vector_Point2f_to_Mat(final List<Point> list) {
        return vector_Point_to_Mat(list, 5);
    }
    
    public static Mat vector_Point3_to_Mat(final List<Point3> list, int i) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size <= 0) {
            return new Mat();
        }
        switch (i) {
            default: {
                throw new IllegalArgumentException("'typeDepth' can be CV_32S, CV_32F or CV_64F");
            }
            case 4: {
                final Mat mat = new Mat(size, 1, CvType.CV_32SC3);
                final int[] array = new int[size * 3];
                Point3 point3;
                for (i = 0; i < size; ++i) {
                    point3 = list.get(i);
                    array[i * 3] = (int)point3.x;
                    array[i * 3 + 1] = (int)point3.y;
                    array[i * 3 + 2] = (int)point3.z;
                }
                mat.put(0, 0, array);
                return mat;
            }
            case 5: {
                final Mat mat2 = new Mat(size, 1, CvType.CV_32FC3);
                final float[] array2 = new float[size * 3];
                Point3 point4;
                for (i = 0; i < size; ++i) {
                    point4 = list.get(i);
                    array2[i * 3] = (float)point4.x;
                    array2[i * 3 + 1] = (float)point4.y;
                    array2[i * 3 + 2] = (float)point4.z;
                }
                mat2.put(0, 0, array2);
                return mat2;
            }
            case 6: {
                final Mat mat3 = new Mat(size, 1, CvType.CV_64FC3);
                final double[] array3 = new double[size * 3];
                Point3 point5;
                for (i = 0; i < size; ++i) {
                    point5 = list.get(i);
                    array3[i * 3] = point5.x;
                    array3[i * 3 + 1] = point5.y;
                    array3[i * 3 + 2] = point5.z;
                }
                mat3.put(0, 0, array3);
                return mat3;
            }
        }
    }
    
    public static Mat vector_Point3d_to_Mat(final List<Point3> list) {
        return vector_Point3_to_Mat(list, 6);
    }
    
    public static Mat vector_Point3f_to_Mat(final List<Point3> list) {
        return vector_Point3_to_Mat(list, 5);
    }
    
    public static Mat vector_Point3i_to_Mat(final List<Point3> list) {
        return vector_Point3_to_Mat(list, 4);
    }
    
    public static Mat vector_Point_to_Mat(final List<Point> list) {
        return vector_Point_to_Mat(list, 4);
    }
    
    public static Mat vector_Point_to_Mat(final List<Point> list, int i) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size <= 0) {
            return new Mat();
        }
        switch (i) {
            default: {
                throw new IllegalArgumentException("'typeDepth' can be CV_32S, CV_32F or CV_64F");
            }
            case 4: {
                final Mat mat = new Mat(size, 1, CvType.CV_32SC2);
                final int[] array = new int[size * 2];
                Point point;
                for (i = 0; i < size; ++i) {
                    point = list.get(i);
                    array[i * 2] = (int)point.x;
                    array[i * 2 + 1] = (int)point.y;
                }
                mat.put(0, 0, array);
                return mat;
            }
            case 5: {
                final Mat mat2 = new Mat(size, 1, CvType.CV_32FC2);
                final float[] array2 = new float[size * 2];
                Point point2;
                for (i = 0; i < size; ++i) {
                    point2 = list.get(i);
                    array2[i * 2] = (float)point2.x;
                    array2[i * 2 + 1] = (float)point2.y;
                }
                mat2.put(0, 0, array2);
                return mat2;
            }
            case 6: {
                final Mat mat3 = new Mat(size, 1, CvType.CV_64FC2);
                final double[] array3 = new double[size * 2];
                Point point3;
                for (i = 0; i < size; ++i) {
                    point3 = list.get(i);
                    array3[i * 2] = point3.x;
                    array3[i * 2 + 1] = point3.y;
                }
                mat3.put(0, 0, array3);
                return mat3;
            }
        }
    }
    
    public static Mat vector_Rect_to_Mat(final List<Rect> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_32SC4);
            final int[] array = new int[size * 4];
            for (int i = 0; i < size; ++i) {
                final Rect rect = list.get(i);
                array[i * 4] = rect.x;
                array[i * 4 + 1] = rect.y;
                array[i * 4 + 2] = rect.width;
                array[i * 4 + 3] = rect.height;
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_char_to_Mat(final List<Byte> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_8SC1);
            final byte[] array = new byte[size];
            for (int i = 0; i < size; ++i) {
                array[i] = list.get(i);
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_double_to_Mat(final List<Double> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_64FC1);
            final double[] array = new double[size];
            for (int i = 0; i < size; ++i) {
                array[i] = list.get(i);
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_float_to_Mat(final List<Float> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_32FC1);
            final float[] array = new float[size];
            for (int i = 0; i < size; ++i) {
                array[i] = list.get(i);
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_int_to_Mat(final List<Integer> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_32SC1);
            final int[] array = new int[size];
            for (int i = 0; i < size; ++i) {
                array[i] = list.get(i);
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_uchar_to_Mat(final List<Byte> list) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Mat mat = new Mat(size, 1, CvType.CV_8UC1);
            final byte[] array = new byte[size];
            for (int i = 0; i < size; ++i) {
                array[i] = list.get(i);
            }
            mat.put(0, 0, array);
            return mat;
        }
        return new Mat();
    }
    
    public static Mat vector_vector_DMatch_to_Mat(final List<MatOfDMatch> list, final List<Mat> list2) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Iterator<MatOfDMatch> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }
    
    public static Mat vector_vector_KeyPoint_to_Mat(final List<MatOfKeyPoint> list, final List<Mat> list2) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Iterator<MatOfKeyPoint> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }
    
    public static Mat vector_vector_Point2f_to_Mat(final List<MatOfPoint2f> list, final List<Mat> list2) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Iterator<MatOfPoint2f> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }
    
    public static Mat vector_vector_Point3f_to_Mat(final List<MatOfPoint3f> list, final List<Mat> list2) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Iterator<MatOfPoint3f> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }
    
    public static Mat vector_vector_Point_to_Mat(final List<MatOfPoint> list, final List<Mat> list2) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Iterator<MatOfPoint> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }
    
    public static Mat vector_vector_char_to_Mat(final List<MatOfByte> list, final List<Mat> list2) {
        int size;
        if (list != null) {
            size = list.size();
        }
        else {
            size = 0;
        }
        if (size > 0) {
            final Iterator<MatOfByte> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }
}

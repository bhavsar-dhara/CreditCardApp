package com.presto.dhara.creditcardapp.utils;

import android.text.TextUtils;

import androidx.databinding.InverseMethod;

public class Converters {

    /**
     * method to convert from String data type to int type
     *
     * @param text String type
     * @return int type
     */
    @InverseMethod("convertIntToString")
    public static int convertStringToInt(String text) {
        try {
            if (!TextUtils.isEmpty(text))
                return Integer.parseInt(text);
            else
                return 0;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * method to convert from Integer data type to String type
     *
     * @param value Integer type
     * @return String type
     */
    public static String convertIntToString(Integer value) {
        if (value != null)
            return String.valueOf(value);
        else
            return "";
    }

    /**
     * method to convert from String data type to long type
     *
     * @param text String type
     * @return long type
     */
    @InverseMethod("convertLongToString")
    public static long convertStringToLong(String text) {
        try {
            if (!TextUtils.isEmpty(text))
                return Long.parseLong(text);
            else
                return 0L;
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    /**
     * method to convert from Long data type to String type
     *
     * @param value Long type
     * @return String type
     */
    public static String convertLongToString(Long value) {
        if (value != null)
            return String.valueOf(value);
        else
            return "";
    }

    /**
     * method to unbox wrapper Integer to int type
     *
     * @param value Integer type
     * @return int type
     */
    @InverseMethod("intBox")
    public static int intUnbox(Integer value) {
        if (value != null)
            return value;
        else
            return 0;
    }

    /**
     * method to box int to Integer type
     *
     * @param value int type
     * @return Integer type
     */
    public static Integer intBox(int value) {
        return value > 0 ? value : null;
    }

    /**
     * method to unbox wrapper Long to long type
     *
     * @param value Long type
     * @return long type
     */
    @InverseMethod("longBox")
    public static long longUnbox(Long value) {
        if (value != null)
            return value;
        else
            return 0;
    }

    /**
     * method to box long to Long type
     *
     * @param value long type
     * @return Long type
     */
    public static Long longBox(long value) {
        return value > 0 ? value : null;
    }
}

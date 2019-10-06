package com.presto.dhara.creditcardapp.utils;

import android.text.TextUtils;

import androidx.databinding.InverseMethod;

public class Converters {

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

    public static String convertIntToString(Integer value) {
        if (value != null)
            return String.valueOf(value);
        else
            return "";
    }

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

    public static String convertLongToString(Long value) {
        if (value != null)
            return String.valueOf(value);
        else
            return "";
    }

    @InverseMethod("intBox")
    public static int intUnbox(Integer b) {
        if (b != null)
            return b;
        else
            return 0;
    }

    public static Integer intBox(int b) {
        return b > 0 ? b : null;
    }

    @InverseMethod("longBox")
    public static long longUnbox(Long b) {
        if (b != null)
            return b;
        else
            return 0;
    }

    public static Long longBox(long b) {
        return b > 0 ? b : null;
    }
}

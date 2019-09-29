package com.tsorrow.test.network.util;

import android.telephony.TelephonyManager;

import java.lang.reflect.Method;

public class Utils {

    public static String[] mClassNameArray = {"UNKNOWN", "2G", "3G", "4G"};

    public static String getNetworkTypeName(TelephonyManager tm, int mobile_type) {
        String type_name = "";
        try {
            Method method = tm.getClass().getMethod("getNetworkTypeName", Integer.TYPE);
            type_name = (String) method.invoke(tm, mobile_type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type_name;
    }

    public static int getClassType(TelephonyManager tm, int mobile_type) {
        int class_type = 0;
        try {
            Method method = tm.getClass().getMethod("getNetworkClass", Integer.TYPE);
            class_type = (Integer) method.invoke(tm, mobile_type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return class_type;
    }

    public static String getClassName(TelephonyManager tm, int mobile_type) {
        int class_type = getClassType(tm, mobile_type);
        return mClassNameArray[class_type];
    }
}

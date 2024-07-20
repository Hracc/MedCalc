package com.pguti.med_calc.calcs.common;

import com.pguti.med_calc.service.MedCalcService;

import java.util.Map;

public class MedCalcUtils {
    public static String getRequireNumberParamType() {
        return "number";
    }

    public static String getNotRequireNumberParamType() {
        return "number";
    }

    public static String getBooleanParamType() {
        return "checkbox";
    }

    public static Double createNumber(String paramName, Map<String, Object> params) {
        return ((Number) params.get(paramName)).doubleValue();
    }

    public static boolean createBoolean(String paramName, Map<String, Object> params) {
        return (boolean) params.get(paramName);
    }

    public static double roundToNumber(double value, int number) {
        if (number < 0) {
            number *= -1;
        }
        double format = Math.pow(10, number);
        return Math.round(value * format) / format;
    }
}

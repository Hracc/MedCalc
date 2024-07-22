package com.pguti.med_calc.calcs.common;

import java.util.List;
import java.util.Map;

public class MedCalcUtils {

    public static String getNumberParamType() {
        return "number";
    }

    public static String getBooleanParamType() {
        return "checkbox";
    }

    public static String getListParamType(){
        return "select";
    }
    public static String createString(String paramName, Map<String, Object> params){
        return (String) params.get(paramName);
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

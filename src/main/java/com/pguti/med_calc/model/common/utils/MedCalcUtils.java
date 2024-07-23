package com.pguti.med_calc.model.common.utils;

import java.util.Map;

//  Класс предназначен для упрощения создания классов калькуляторов.
public class MedCalcUtils {
    // Методы create() для создания нужных типов ввода данных MedCalc. Используются в методе MedCalc.calculte() .
    public static String createString(String paramName, Map<String, Object> params){
        return (String) params.get(paramName);
    }

    public static Double createNumber(String paramName, Map<String, Object> params) {
        return ((Number) params.get(paramName)).doubleValue();
    }

    public static boolean createBoolean(String paramName, Map<String, Object> params) {
        return (boolean) params.get(paramName);
    }

    //  Метод для округления результата. Используются в методе MedCalc.calculte() .
    public static double roundToNumber(double value, int number) {
        if (number < 0) {
            number *= -1;
        }
        double format = Math.pow(10, number);
        return Math.round(value * format) / format;
    }
    //  Методы getParamType() для возвращения типа данных для фронта. Используются в MedCalc.getInfoParams() .
    public static String getNumberParamType() {
        return "number";
    }

    public static String getBooleanParamType() {
        return "checkbox";
    }

    public static String getListParamType(){
        return "select";
    }
}

package com.pguti.med_calc.calcs;

import java.util.LinkedHashMap;
import java.util.Map;

public class MedCalcIVDripRate implements MedCalc {
    private Map<String, Object> results;

    @Override
    public String getId() {
        return "IVDripRate";
    }

    @Override
    public String getName() {
        return "Я забыл как калькулятор называется";
    }

    @Override
    public String getInfo() {
        return "Очень крутая инфа";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        double V = (double) params.get("V");
        boolean hm = (boolean) params.get("hm");
        double t = (double) params.get("t");
        if(!hm){
            t*=60;
        }
        double result= V*20/t;
        Map<String, Object> results = new LinkedHashMap<>();
        results.put("result1", result);
        results.put("result2", result/60);
        return results;
    }
}
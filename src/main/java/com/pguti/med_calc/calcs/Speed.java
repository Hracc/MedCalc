package com.pguti.med_calc.calcs;

import java.util.HashMap;
import java.util.Map;

public class Speed implements Calculator {
    private Map<String, Object> results;

    @Override
    public String getInfo() {
        return "Очень крутая инфа";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        double V = (double) params.get("V");
        double t = (double) params.get("t");

        Map<String, Object> results = new HashMap<>();
        results.put("result", V*20.0/t);
        return results;
    }
}
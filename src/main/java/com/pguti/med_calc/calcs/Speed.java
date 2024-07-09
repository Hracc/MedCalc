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
        double k = (double) params.get("k");
        double m = (double) params.get("m");

        Map<String, Object> results = new HashMap<>();
        results.put("result1", (5-k)*0.2*m);
        results.put("result2", k*m);
        return results;
    }
}
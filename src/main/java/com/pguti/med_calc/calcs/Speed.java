package com.pguti.med_calc.calcs;

import java.util.HashMap;
import java.util.Map;

public class Speed implements Calculator{
    private final Map<String, String> info=new HashMap<>();
    {
        info.put("info", "Очень крутая инфа");
    }
    private Map<String, Object> results;
    @Override
    public Map<String, String> getInfo() {
        return info;
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        float s = (float) params.get("s");
        float t = (float) params.get("t");
        results.put("result", s/t);
        return results;
    }
}

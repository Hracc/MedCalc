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
        // Извлекаем значения из параметров как Double
        Double s = ((Number) params.get("s")).doubleValue();
        Double t = ((Number) params.get("t")).doubleValue();

        // Вычисляем результат
        Double result = s / t;

        // Создаем карту для результата
        Map<String, Object> results = new HashMap<>();
        results.put("result", result);
        return results;
    }
}
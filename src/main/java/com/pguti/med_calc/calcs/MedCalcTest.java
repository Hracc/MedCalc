package com.pguti.med_calc.calcs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedCalcTest implements MedCalc{
    @Override
    public String getId() {
        return "bruh";
    }

    @Override
    public String getName() {
        return "тест";
    }

    @Override
    public String getInfo() {
        return "Просто для теста a*b";
    }

    @Override
    public List<MedCalcParamsList> getInfoParams() {
        return List.of(
                new MedCalcParamsList("a","Штука а", "number", true),
                new MedCalcParamsList("b","Штука b", "number", true)
        );
    }

    @Override
    public List<MedCalcResult> getInfoResult() {
        return List.of(
                new MedCalcResult("result", "Вот итог"));
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        double a = ((Number)  params.get("a")).doubleValue();
        double b = ((Number)  params.get("b")).doubleValue();
        Map<String, Object> res=new HashMap<>();
        res.put("result", a/b);
        return res;
    }
}

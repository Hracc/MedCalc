package com.pguti.med_calc.calcs;

import java.util.*;

public class MedCalcIVDripRate implements MedCalc {
    private Map<String, Object> results;

    @Override
    public String getId() {
        return "IVDripRate";
    }

    @Override
    public String getName() {
        return "Расчет скорости внутривенного капельного введения препарата";
    }

    @Override
    public String getInfo() {
        return "Расчет производится по следующей формуле: количество капель в минуту = V*20/t, где V - объем раствора в милилитрах, t - время в минутах, 20 - среднее количество капель в милилитре, v - скорость введения в каплях в минуту";
    }

    @Override
    public List<MedCalcParamsList> getInfoParams() {
        return List.of(
                new MedCalcParamsList("V", "Объем раствора (мл)", "number",true),
                new MedCalcParamsList("hm", "В часах / в минутах", "checkbox", false),
                new MedCalcParamsList("t", "Время", "number", true)
        );
    }

    @Override
    public List<MedCalcResult> getInfoResult() {
        return List.of(
                new MedCalcResult("resultMinute","Результат в часах"),
                new MedCalcResult("resultHour","Результат в минутах")
        );
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        double V = ((Number)  params.get("V")).doubleValue();
        boolean hm = (boolean) params.get("hm");
        double t = ((Number) params.get("t")).doubleValue();
        if(!hm){
            t*=60;
        }
        double result= V*20/t;
        Map<String, Object> results = new LinkedHashMap<>();
        results.put("resultMinute", result);
        results.put("resultHour", result/60);
        return results;
    }
}
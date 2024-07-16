package com.pguti.med_calc.calcs;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        return List.of();
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
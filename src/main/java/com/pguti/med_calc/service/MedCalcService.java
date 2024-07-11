package com.pguti.med_calc.service;

import com.pguti.med_calc.calcs.MedCalc;
import com.pguti.med_calc.calcs.MedCalcAntibiotics;
import com.pguti.med_calc.calcs.MedCalcIVDripRate;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class MedCalcService {
    //    Переменная для хранения списка калькуляторов
    private final Map<String, MedCalc> calcList = new HashMap<>();

    //    Заполнение списка калькуляторов
    {
        putCalcList(new MedCalcIVDripRate());
        putCalcList(new MedCalcAntibiotics());
    }

    private void putCalcList(MedCalc medCalc) {
        calcList.put(medCalc.getId(), medCalc);
    }

    public Map<String, MedCalc> getCalcList() {
        return calcList;
    }

    public MedCalc getCalcById(String id) {
        return calcList.get(id);
    }

    public Map<String, String> getCalcInfo(String calc) {
        Map<String, String> info = new HashMap<>();
        info.put("info", calcList.get(calc).getInfo());
        return info;
    }

    public Map<String, Object> getResult(String calc, Map<String, Object> params) {
        return calcList.get(calc).calculate(params);
    }


}
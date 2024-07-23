package com.pguti.med_calc.service;

import com.pguti.med_calc.calcs.MedCalcExample;
import com.pguti.med_calc.calcs.common.MedCalc;
import com.pguti.med_calc.calcs.MedCalcPercOfTheSubstance;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class MedCalcService {
    //    Переменная для хранения списка калькуляторов
    private final Map<String, MedCalc> calcList = new HashMap<>();

    //  *  Заполнение списка калькуляторов
    {
        putCalcList(new MedCalcExample());
        putCalcList(new MedCalcPercOfTheSubstance());
    }

    private void putCalcList(MedCalc medCalc) {
        calcList.put(medCalc.getId(), medCalc);
    }

    public Map<String, String> getCalcList() {
        return calcList.values().stream().collect(Collectors.toMap(MedCalc::getId, MedCalc::getName));
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
package com.pguti.med_calc.service;

import com.pguti.med_calc.calcs.MedCalc;
import com.pguti.med_calc.calcs.MedCalcIVDripRate;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class MedCalcService {
    private final Map<String, MedCalc> calcList=new HashMap<>();
    {
        calcList.put("speed", new MedCalcIVDripRate());
    }

    public Map<String, MedCalc> getCalcList() {
        return calcList;
    }
    public Map<String, String> getCalcInfo(String calc){
        Map<String, String> info=new HashMap<>();
        info.put("info", calcList.get(calc).getInfo());
        return info;
    }
    public Map<String, Object> getResult(String calc, Map<String, Object> params){
        return calcList.get(calc).calculate(params);
    }
}
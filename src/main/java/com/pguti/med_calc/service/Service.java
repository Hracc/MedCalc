package com.pguti.med_calc.service;

import com.pguti.med_calc.calcs.Calculator;
import com.pguti.med_calc.calcs.Speed;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {
    private final Map<String, Calculator> calcList=new HashMap<>();
    {
        calcList.put("speed", new Speed());
    }

    public Map<String, Calculator> getCalcList() {
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
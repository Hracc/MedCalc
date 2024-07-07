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
}

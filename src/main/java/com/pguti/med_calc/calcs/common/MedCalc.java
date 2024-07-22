package com.pguti.med_calc.calcs.common;

import com.pguti.med_calc.calcs.MedCalcNumbParams;

import java.util.List;
import java.util.Map;

public interface MedCalc {
    List<MedCalcNumbParams> getNumberParams();
    List<String> getListParam();
    Map<String, Double> getNotRequireNumbs();
    String getId();
    String getName();
    String getInfo();
    List<MedCalcParamsList> getInfoParams();
    List<MedCalcResult> getInfoResult();
    Map<String, Object> calculate(Map<String, Object> params);
}
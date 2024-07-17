package com.pguti.med_calc.calcs;

import java.util.List;
import java.util.Map;

public interface MedCalc {
    String getId();
    String getName();
    String getInfo();
    List<MedCalcParamsList> getInfoParams();
    List<MedCalcResult> getInfoResult();
    Map<String, Object> calculate(Map<String, Object> params);
}
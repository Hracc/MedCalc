package com.pguti.med_calc.calcs.common;

import java.util.List;
import java.util.Map;

public interface MedCalc {
    String getId();
    String getName();
    String getInfo();
    Map<String, Object> calculate(Map<String, Object> params);
    List<ParamsList> getInfoParams();
    List<Result> getInfoResult();
    Map<String, Double> getNotRequireNumbs();
    List<NumbParams> getNumberParams();
    List<String> getListParam();
}
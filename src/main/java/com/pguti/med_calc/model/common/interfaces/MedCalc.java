package com.pguti.med_calc.model.common.interfaces;

import com.pguti.med_calc.model.common.params.NumbParam;
import com.pguti.med_calc.model.common.params.ListParam;
import com.pguti.med_calc.model.common.params.ResultParam;

import java.util.List;
import java.util.Map;
// Обязательный интерфейс для создания калькулятора.
public interface MedCalc {
    //  Методы для бэкэнда
    String getId();
    String getName();
    String getInfo();
    Map<String, Object> calculate(Map<String, Object> params);
    //  Методы для фронтэнда
    List<ListParam> getInfoParams();
    List<ResultParam> getInfoResult();
    Map<String, Double> getNotRequireNumbs();
    List<NumbParam> getNumberParams();
    List<String> getListParam();
}
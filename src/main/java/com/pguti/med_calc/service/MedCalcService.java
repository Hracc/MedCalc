package com.pguti.med_calc.service;

import com.pguti.med_calc.model.MedCalcExample;
import com.pguti.med_calc.model.MedCalcMayoComaScale;
import com.pguti.med_calc.model.MedCalcPotassiumDeficiency;
import com.pguti.med_calc.model.common.interfaces.MedCalc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

// Данные Service нужен для получения всех  калькуляторов и взаимодействия с ними в Контроллерах
@org.springframework.stereotype.Service
public class MedCalcService {
    //    Переменная для хранения списка калькуляторов
    private final Map<String, MedCalc> calcList = new TreeMap<>();

    //  *  Заполнение списка калькуляторов
    {
        putCalcList(new MedCalcExample());
        putCalcList(new MedCalcPotassiumDeficiency());
        putCalcList(new MedCalcMayoComaScale());
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
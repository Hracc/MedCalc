package com.pguti.med_calc.model;

import com.pguti.med_calc.model.common.interfaces.MedCalc;
import com.pguti.med_calc.model.common.params.ListParam;
import com.pguti.med_calc.model.common.params.NumbParam;
import com.pguti.med_calc.model.common.params.ResultParam;
import com.pguti.med_calc.model.common.utils.MedCalcUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedCalcExample implements MedCalc {
    @Override
    public String getId() {
        return "example";
    }

    @Override
    public String getName() {
        return "Пример структуры калькулятора";
    }

    @Override
    public String getInfo() {
        return "В этом калькуляторе сделаны возможности для создания калькулятора. " +
                "Число 1 обязательна для формулы." +
                "Число 2 необязательно и в случае не написания в него числа будет равна стандартному значению." +
                "Умножить/Делить для создания выбора из двух вариантов ответа." +
                "Ничего не делать /Умножить на 0/ Умножить на 2 для создания нескольких вариантов ответа";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        Map<String, Object> res = new HashMap<>();

        double var1 = MedCalcUtils.createNumber("var1", params);
        double var2 = MedCalcUtils.createNumber("var2", params);
        double operation;
        boolean var3 = MedCalcUtils.createBoolean("var3", params);
        String var4 = MedCalcUtils.createString("var4", params);
        if (var3) {
            operation = var1 * var2;
            res.put("res1", operation);
        } else {
            operation = var1 / var2;
            res.put("res1", operation);
        }
        switch (var4) {
            case "Умножить на 2":
                res.put("res2", operation * 2);
                break;
            case "Разделить на 3":
                res.put("res2", operation / 3);
                break;
            default:
                res.put("res2", 0);
        }
        return res;
    }

    @Override
    public List<ListParam> getInfoParams() {
        return List.of(
                new ListParam("var1", "Число 1", MedCalcUtils.getNumberParamType()),
                new ListParam("var2", "Число 2", MedCalcUtils.getNumberParamType()),
                new ListParam("var3", "Умножить/Разделить", MedCalcUtils.getBooleanParamType()),
                new ListParam("var4", "Доп операции:", MedCalcUtils.getListParamType())
        );
    }

    @Override
    public List<ResultParam> getInfoResult() {
        return List.of(
                new ResultParam("res1", "Операция 1"),
                new ResultParam("res2", "Операция 2")
        );
    }

    @Override
    public Map<String, Double> getNotRequireNumbs() {
        return Map.of(
                "var2", 1.0
        );
    }

    @Override
    public List<NumbParam> getNumberParams() {
        return List.of(
                new NumbParam("var1",1,0,300),
                new NumbParam("var2",0.1,0,100)
        );
    }

    @Override
    public List<String> getListParam() {
        return List.of(
                "Ничего не делать",
                "Умножить на 2",
                "Разделить на 3"
        );
    }
}

package com.pguti.med_calc.model;

import com.pguti.med_calc.model.common.interfaces.MedCalc;
import com.pguti.med_calc.model.common.params.NumbParam;
import com.pguti.med_calc.model.common.params.ListParam;
import com.pguti.med_calc.model.common.params.ResultParam;
import com.pguti.med_calc.model.common.utils.MedCalcUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedCalcExample implements MedCalc {


    @Override
    public List<NumbParam> getNumberParams() {
        return List.of(
                new NumbParam("var1", 1, 0,200),
                new NumbParam("var2",0.1,0,100)
        );
    }

    @Override
    public List<String> getListParam() {
        return List.of(
                "Да","Нет","Что?"
        );
    }

    @Override
    public Map<String, Double> getNotRequireNumbs() {
        return Map.of(
                "var2",1.0
        );
    }

    @Override
    public String getId() {
        return "example";
    }

    @Override
    public String getName() {
        return "Пример калькулятора";
    }

    @Override
    public String getInfo() {
        return "Показывает все реализованные механики калькулятора";
    }

    @Override
    public List<ListParam> getInfoParams() {
        return List.of(
                new ListParam("var1", "Число 1", MedCalcUtils.getNumberParamType()),
                new ListParam("var2", "Число 2(не обязательно)", MedCalcUtils.getNumberParamType()),
                new ListParam("var3", "Да/Нет", MedCalcUtils.getBooleanParamType()),
                new ListParam("var4", "Состояния", MedCalcUtils.getListParamType())
        );
    }

    @Override
    public List<ResultParam> getInfoResult() {
        return List.of(
                new ResultParam("res","Итог")
        );
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        Double var1 = MedCalcUtils.createNumber("var1", params);
        Double var2 = MedCalcUtils.createNumber("var2", params);
        boolean var3 = MedCalcUtils.createBoolean("var3", params);
        String var4= MedCalcUtils.createString("var4",params);
        Map<String, Object> result = new HashMap<>();
        double numb = 1;
        if (var3) {
            numb *= 2;
        }
        switch (var4){
            case "Да":
                numb+=1;
                break;
            case "Нет":
                numb-=1;
                break;
            case "Что?":
                numb*=69;
                break;
        }

        result.put("res", MedCalcUtils.roundToNumber(var1 * var2 + numb,2));
        return result;
    }
}

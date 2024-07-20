package com.pguti.med_calc.calcs;

import com.pguti.med_calc.calcs.common.MedCalc;
import com.pguti.med_calc.calcs.common.MedCalcParamsList;
import com.pguti.med_calc.calcs.common.MedCalcResult;
import com.pguti.med_calc.calcs.common.MedCalcUtils;

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
        return "Пример калькулятора";
    }

    @Override
    public String getInfo() {
        return "Показывает все реализованные механики калькулятора";
    }

    @Override
    public List<MedCalcParamsList> getInfoParams() {
        return List.of(
                new MedCalcParamsList("var1", "Число 1", MedCalcUtils.getRequireNumberParamType()),
                new MedCalcParamsList("var2", "Число 2(не обязательно)", MedCalcUtils.getNotRequireNumberParamType()),
                new MedCalcParamsList("var3", "Да/Нет", MedCalcUtils.getBooleanParamType())
        );
    }

    @Override
    public List<MedCalcResult> getInfoResult() {
        return List.of(
                new MedCalcResult("res","Итог")
        );
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        Double var1 = MedCalcUtils.createNumber("var1", params);
        Double var2 = MedCalcUtils.createNumber("var2", params);
        boolean var3 = MedCalcUtils.createBoolean("var3", params);
        Map<String, Object> result = new HashMap<>();
        double numb = 5;
        if (var3) {
            numb *= 2;
        }
        result.put("res", MedCalcUtils.roundToNumber(var1 * var2 + numb,0));
        return result;
    }
}

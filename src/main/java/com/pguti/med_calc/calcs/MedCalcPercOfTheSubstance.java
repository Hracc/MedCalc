package com.pguti.med_calc.calcs;

import com.pguti.med_calc.calcs.common.*;

import java.util.List;
import java.util.Map;

public class MedCalcPercOfTheSubstance implements MedCalc {

    @Override
    public String getId() {
        return "PercOfTheSubstance";
    }

    @Override
    public String getName() {
        return "Расчет содержания вещества в растворе (пересчет процентов в миллиграммы)";
    }

    @Override
    public String getInfo() {
        return "Об этом калькуляторе *Этот калькулятор позволяет пересчитать процентное содержание вещества в заданном объеме раствора в миллиграммы. Формула Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе. Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм)";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        double p = MedCalcUtils.createNumber("p", params);
        double v = MedCalcUtils.createNumber("v", params);
        return Map.of(
                "res", (p * v) / 100
        );
    }

    @Override
    public List<ParamsList> getInfoParams() {
        return List.of(
                new ParamsList("p", "Процент", MedCalcUtils.getNumberParamType()),
                new ParamsList("v", "Объем", MedCalcUtils.getNumberParamType())
        );
    }

    @Override
    public List<Result> getInfoResult() {
        return List.of(
                new Result("res", "Хуйня ебанная")
        );
    }

    @Override
    public Map<String, Double> getNotRequireNumbs() {
        return Map.of();
    }

    @Override
    public List<NumbParams> getNumberParams() {
        return List.of(
                new NumbParams("p", 0.1, 0, 100),
                new NumbParams("v", 0.1, 0, 5000)
        );
    }

    @Override
    public List<String> getListParam() {
        return List.of();
    }
}

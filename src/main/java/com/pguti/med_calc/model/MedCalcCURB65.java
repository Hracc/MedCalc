package com.pguti.med_calc.model;

import com.pguti.med_calc.model.common.interfaces.MedCalc;
import com.pguti.med_calc.model.common.params.InfoParam;
import com.pguti.med_calc.model.common.params.InfoResult;
import com.pguti.med_calc.model.common.params.NumbParam;
import com.pguti.med_calc.model.common.utils.MedCalcUtils;

import java.util.List;
import java.util.Map;

// Оригинал - https://medicalc.pro/curb
public class MedCalcCURB65 implements MedCalc {

    @Override
    public String getId() {
        return "CURB-65";
    }

    @Override
    public String getName() {
        return "Шкала CURB-65";
    }

    @Override
    public String getInfo() {
        return "Калькулятор для оценка степени тяжести внегоспитальной" +
                " пневмонии и выбор места лечения пациента по шкале CURB(CRB)-65 \n" +
                "Сумма баллов, каждый критерий = 1";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        boolean type = MedCalcUtils.createBoolean("type", params);
        return Map.of();
    }

    @Override
    public List<InfoParam> getInfoParams() {
        return List.of(
                new InfoParam("type", "CURB-65/CRB-65", MedCalcUtils.getBooleanParamType()),
                new InfoParam("a", "Нарушение сознания", MedCalcUtils.getBooleanParamType()),
                new InfoParam("b", "Азот мочевины крови >7 ммоль/л", MedCalcUtils.getBooleanParamType()),
                new InfoParam("c", "Частота дыхания ≥30/мин", MedCalcUtils.getBooleanParamType()),
                new InfoParam("d", "Систолическое АД <90 мм Hg или диаcтолическое АД ≤60 мм Hg", MedCalcUtils.getBooleanParamType()),
                new InfoParam("e", "Возраст ≥65 лет", MedCalcUtils.getBooleanParamType())
        );
    }

    @Override
    public List<InfoResult> getInfoResult() {
        return List.of();
    }

    @Override
    public Map<String, Double> getNotRequireNumbs() {
        return Map.of();
    }

    @Override
    public List<NumbParam> getNumberParams() {
        return List.of();
    }

    @Override
    public List<String> getListParam() {
        return List.of();
    }
}

package com.pguti.med_calc.model;

import com.pguti.med_calc.model.common.interfaces.MedCalc;
import com.pguti.med_calc.model.common.params.InfoParam;
import com.pguti.med_calc.model.common.params.NumbParam;
import com.pguti.med_calc.model.common.params.InfoResult;
import com.pguti.med_calc.model.common.utils.MedCalcUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Оригинал - https://medicalc.pro/rashchetkalija
public class MedCalcPotassiumDeficiency implements MedCalc {

    @Override
    public String getId() {
        return "PotassiumDeficiency";
    }

    @Override
    public String getName() {
        return "Расчет дефицита калия";
    }

    @Override
    public String getInfo() {
        return " Калькулятор расчитывает дефицита калия в плазме крови и объема его возмещения. \n" +
                "Для ее вычисления нужно :\n" +
                "Дефицит калия (ммоль/л) = (5 - калий плазмы пациента в ммоль/л) * 0.2 * массу тела пациента \n" +
                "1 ммоль калия = 39.1 мг калия. \n" +
                "1 грамм калия хлорида (KCL) = 13.4 ммоль калия";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        Map<String, Object> res = new HashMap<>();

        double p = MedCalcUtils.createNumber("p", params);
        double w = MedCalcUtils.createNumber("w", params);
        double d = (5 - p) * 0.2 * w;
        res.put("res7.5%", MedCalcUtils.roundToNumber(d,2) + " ммоль (мл)");
        res.put("res4%", MedCalcUtils.roundToNumber(d/0.536,2) + " мл");
        res.put("resMax", MedCalcUtils.roundToNumber(3*w,0) + " ммоль");
        res.put("resKCl", MedCalcUtils.roundToNumber(d/13.4*1000,2) + " мг");
        return res;
    }

    @Override
    public List<InfoParam> getInfoParams() {
        return List.of(
                new InfoParam("p", "Калий сыворотки, ммоль/л", MedCalcUtils.getNumberParamType()),
                new InfoParam("w", "Вес пациента, кг", MedCalcUtils.getNumberParamType())
        );
    }

    @Override
    public List<InfoResult> getInfoResult() {
        return List.of(
                new InfoResult("res7.5%", "7.5%-й раствор"),
                new InfoResult("res4%", "4%-й раствор"),
                new InfoResult("resMax", "Максимальная дозировка в сутки"),
                new InfoResult("resKCl", "Масса калия хлорида (KCl)")
        );
    }

    @Override
    public Map<String, Double> getNotRequireNumbs() {
        return Map.of();
    }

    @Override
    public List<NumbParam> getNumberParams() {
        return List.of(
                new NumbParam("p", 0.1, 0, 100),
                new NumbParam("w", 1, 0, 500)
        );
    }

    @Override
    public List<String> getListParam() {
        return List.of();
    }
}

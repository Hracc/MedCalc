package com.pguti.med_calc.model;

import com.pguti.med_calc.model.common.interfaces.MedCalc;
import com.pguti.med_calc.model.common.params.InfoParam;
import com.pguti.med_calc.model.common.params.InfoResult;
import com.pguti.med_calc.model.common.params.NumbParam;
import com.pguti.med_calc.model.common.params.SelectParam;
import com.pguti.med_calc.model.common.utils.MedCalcUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Оригинал - https://medicalc.pro/mayo
public class MedCalcMayoComaScale implements MedCalc {

    @Override
    public String getId() {
        return "MayoComaScale";
    }

    @Override
    public String getName() {
        return "Шкала комы Мэйо";
    }

    @Override
    public String getInfo() {
        return "Оценка степени нарушения сознания по шкале Мэйо\n" +
                "\n" +
                "Интерпретация\n" +
                "Oценка по баллам:\n" +
                "\n" +
                "16 баллов - ясное сознание\n" +
                "15 баллов - сомноленция\n" +
                "14 баллов - оглушение\n" +
                "9-12 баллов - сопор\n" +
                "4-8 баллов - кома\n" +
                "3 балла - смерть мозга";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        Map<String, Object> res = new HashMap<>();
        List<SelectParam> selectParams = getListParam();

        String eyes = MedCalcUtils.createString("eyes", params);
        String motor_reactions = MedCalcUtils.createString("motor_reactions", params);
        String stem_reactions = MedCalcUtils.createString("stem_reactions", params);
        String breath = MedCalcUtils.createString("breath", params);

        String[] arr = {eyes, motor_reactions, stem_reactions, breath};
        String resStatus;

        int i = 0, j = 0, k = 0, resPoint = 0;
        while (i < selectParams.size()) {
            if (arr[j].equals(selectParams.get(i).getName())) {
                resPoint += k;
            }
            if (i % 5 == 0 && i != 0) {
                j++;
            }
            if (k == 4) {
                k = 0;
            } else {
                k++;
            }
            i++;
        }
        if (resPoint <= 3) {
            resStatus = "смерть мозга";
        } else if (resPoint <= 8) {
            resStatus = "кома";
        } else if (resPoint <= 12) {
            resStatus = "сопор";
        } else if (resPoint == 14) {
            resStatus = "оглушение";
        } else if (resPoint == 15) {
            resStatus = "сомноленция";
        } else {
            resStatus = "ясное сознание";
        }
        res.put("resPoint", resPoint);
        res.put("resStatus", resStatus);
        return res;
    }

    @Override
    public List<InfoParam> getInfoParams() {
        return List.of(
                new InfoParam("eyes", "Открывание глаз", MedCalcUtils.getListParamType()),
                new InfoParam("motor_reactions", "Двигательные реакции", MedCalcUtils.getListParamType()),
                new InfoParam("stem_reactions", "Стволовые реакции", MedCalcUtils.getListParamType()),
                new InfoParam("breath", "Дыхание", MedCalcUtils.getListParamType())
        );
    }

    @Override
    public List<InfoResult> getInfoResult() {
        return List.of(
                new InfoResult("resPoint", "Кол-во баллов"),
                new InfoResult("resStatus", "Статус")
        );
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
    public List<SelectParam> getListParam() {
        return List.of(
                new SelectParam("eyes", "Не открывает на боль"),
                new SelectParam("eyes", "Закрыты, открывает на бровь"),
                new SelectParam("eyes", "Закрыты, открывает на громкую команду"),
                new SelectParam("eyes", "Открыты, нет слежения"),
                new SelectParam("eyes", "Самостоятельное слежение, мигание по команде"),
                new SelectParam("motor_reactions", "Отсутствуют или генерализованный миоклонус"),
                new SelectParam("motor_reactions", "Разгибание в ответ на боль"),
                new SelectParam("motor_reactions", "Сгибание в ответ на боль"),
                new SelectParam("motor_reactions", "Тянется к месту болевого раздражения"),
                new SelectParam("motor_reactions", "'Отлично' - показывает большим пальцем"),
                new SelectParam("stem_reactions", "Зрачковый, роговичный и кашлевой рефлексы отсутствуют"),
                new SelectParam("stem_reactions", "Зрачковый И роговичный рефлексы отсутствуют"),
                new SelectParam("stem_reactions", "Зрачковый ИЛИ роговичный рефлексы отсутствуют"),
                new SelectParam("stem_reactions", "Один зрачок расширен, не реагирует на свет"),
                new SelectParam("stem_reactions", "Зрачковый и роговичный рефлексы сохранены"),
                new SelectParam("breath", "Подчинено респиратору или апноэ"),
                new SelectParam("breath", "Чаще частоты респиратора"),
                new SelectParam("breath", "Не интубирован, нерегулярное"),
                new SelectParam("breath", "Не интубирован, типа Чейн - Стокса"),
                new SelectParam("breath", "Не интубирован, нормальное")
        );
    }
}

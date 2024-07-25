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

// Оригинал - https://medicalc.pro/gidrobalans
public class MedCalcHydrobalance implements MedCalc {
    @Override
    public String getId() {
        return "Hydrobalance";
    }

    @Override
    public String getName() {
        return "Расчет гидробаланса";
    }

    @Override
    public String getInfo() {
        return "Этот калькулятор позволяет рассчитать гидробаланс за сутки как с операционными и другими потерями, так и без них.\n" +
                "Гидробаланс - это соотношение введенной и выделенной организмом жидкости за определенный промежуток времени (сутки, 12 часов, 6 часов, время операции).\n" +
                "Введенная жидкость - сумма объема внутривенной инфузии и энтерально (per os, в зонд) введенной жидкости\n" +
                "Выделенная организмом организмом жидкость может быть представлена физиологическими и патологическими потерями.\n" +
                "Физиологическая потребность (ФП) - потребность организма в жидкости в единицу времени (сутки). Зависит от возраста: до 65 лет - 30 мл/кг/сут., 65-75 лет - 25 мл/кг/сут., старше 75 лет - 20 мл/кг/сут.\n" +
                "Физиологические потери:\n" +
                "Нормальное дыхание\n" +
                "Перспирация через кожу\n" +
                "Нормальный стул\n" +
                "Физиологический диурез\n" +
                "В целом, физиологические потери составляют около 40% от физиологической потребности, а диурез в сутки примерно равен 60% от нее, или 20 мл/кг/сутки.\n" +
                "Патологические потери\n" +
                "Потери с лихорадкой: 3 мл/кг/сут. (10% ФП) на каждый градус выше 37,5 oC. Также теряются электролиты.\n" +
                "Потери с одышкой: 10 мл/кг/сут. на каждые 10 дыханий в минутут выше 25.\n" +
                "Потери при ИВЛ без согревания и увлажнения газовой смеси: 1000 мл/сут.\n" +
                "Потери при ИВЛ с согреванием и увлажнением газовой смеси: 0 мл/сут.\n" +
                "Интраоперационные потери\n" +
                "Перспирация из раны во время операции с минимальной травматизацией: 2 мл/кг/час.\n" +
                "Перспирация из раны во время операции со средней травматизацией: 4 мл/кг/час.\n" +
                "Перспирация из раны во время операции с тяжелой травматизацией: 6 мл/кг/час.\n" +
                "Рвота, отделяемое по зондам\n" +
                "Другие потери. Это могут быть наружные и внутренние кровотечения, диарея, полиурия и другое.\n" +
                "Формула\n" +
                "Гидробаланс = Внутривенная инфузия + Энтеральное введение - Диурез - Физиологические внепочечные потери - Патологические потери\n" +
                "Состав инфузии\n" +
                "Физиологические потребности в жидкости обеспечиваются солевыми растворами и глюкозой в равном соотношении (1:1).\n" +
                "Потери по дренажам, зонду, рвота - солевыми растворами и глюкозой (1:1).\n" +
                "Потери с дыханием и при ИВЛ без согревания и увлажнения смеси - только глюкозой.\n" +
                "Если объем инфузии превышает 2400 мл/сутки, не менее 1/3 ее объема должны составить коллоидные растворы.";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        Map<String, Object> res = new HashMap<>();
        double m = MedCalcUtils.createNumber("m", params);
        double a = MedCalcUtils.createNumber("a", params);
        double c = MedCalcUtils.createNumber("c", params);
        double v = MedCalcUtils.createNumber("v", params);
        double d = MedCalcUtils.createNumber("d", params);
        double i = MedCalcUtils.createNumber("i", params);
        double y = MedCalcUtils.createNumber("y", params);
        double rv = MedCalcUtils.createNumber("rv", params);
        double dr = MedCalcUtils.createNumber("dr", params);
        double oth = MedCalcUtils.createNumber("oth", params);
        boolean IVL = MedCalcUtils.createBoolean("IVL", params);
        String travm = MedCalcUtils.createString("travm", params);
        double t = MedCalcUtils.createNumber("t", params);

        double req;
        if (a < 65) {
            req = 30;
        } else if (a <= 75) {
            req = 25;
        } else {
            req = 20;
        }

        double FP = m * req;
        double resDiur = m * 20;
        double resFL = 0.4 * FP;

        double feverLoss = c > 37.5 ? 3 * m * (c - 37.5) : 0;
        double breathingLoss = v > 25 ? 10 * m * (v - 25) / 10 : 0;
        double ivlLoss = IVL ? 0 : 1000;

        double travmLoss = 0;
        switch (travm) {
            case "Минимальная травматизация (паховая грыжа, флебэктомия, лапароскопческие операции)":
                travmLoss = 2 * m * t;
                break;
            case "Средняя травматизация (холецистэктомия, ампутация)":
                travmLoss = 4 * m * t;
                break;
            case "Тяжелая травматизация (кишечная непроходимость, резекция желудка)":
                travmLoss = 6 * m * t;
                break;
        }

        double pathologicalLosses = feverLoss + breathingLoss + ivlLoss + rv + dr + oth + travmLoss;

        double resHy = i + y - d - resFL - pathologicalLosses;

        res.put("resFP", FP);
        res.put("resDiur", resDiur);
        res.put("resFL", resFL);
        res.put("resHy", resHy);

        return res;
    }

    @Override
    public List<InfoParam> getInfoParams() {
        return List.of(
                new InfoParam("m", "* Вес кг", MedCalcUtils.getNumberParamType()),
                new InfoParam("a", "* Возраст", MedCalcUtils.getNumberParamType()),
                new InfoParam("c", "* Температура C", MedCalcUtils.getNumberParamType()),
                new InfoParam("v", "* Частота дыхания, в мин", MedCalcUtils.getNumberParamType()),
                new InfoParam("d", "* Диурез, мл/сутки", MedCalcUtils.getNumberParamType()),
                new InfoParam("i", "Инфузия, мл/сутки", MedCalcUtils.getNumberParamType()),
                new InfoParam("y", "Энтерально, мл/сутки", MedCalcUtils.getNumberParamType()),
                new InfoParam("rv", "Рвота, мл/сутки", MedCalcUtils.getNumberParamType()),
                new InfoParam("dr", "Дренажи, мл/сутки", MedCalcUtils.getNumberParamType()),
                new InfoParam("oth", "Другие потери, мл/сутки", MedCalcUtils.getNumberParamType()),
                new InfoParam("IVL", "Физиологическое дыхание или физиологичная ИВЛ", MedCalcUtils.getBooleanParamType()),
                new InfoParam("travm", "Трамвы", MedCalcUtils.getListParamType()),
                new InfoParam("t", "Длительность операции, часов", MedCalcUtils.getNumberParamType())
        );
    }

    @Override
    public List<InfoResult> getInfoResult() {
        return List.of(
                new InfoResult("resHy", "Гидробаланс"),
                new InfoResult("resFP", "Физиологическая потребность"),
                new InfoResult("resDiur", "Должный диурез"),
                new InfoResult("resFL", "Физиологические потери")
        );
    }

    @Override
    public Map<String, Double> getNotRequireNumbs() {
        return Map.of(
                "d",0.0,
                "y",0.0,
                "i",0.0,
                "rv",0.0,
                "dr",0.0,
                "oth",0.0,
                "t",0.0
        );
    }

    @Override
    public List<NumbParam> getNumberParams() {
        return List.of();
    }

    @Override
    public List<SelectParam> getListParam() {
        return List.of(
                new SelectParam("travm", "Нет"),
                new SelectParam("travm", "Минимальная травматизация (паховая грыжа, флебэктомия, лапароскопческие операции)"),
                new SelectParam("travm", "Средняя травматизация (холецистэктомия, ампутация)"),
                new SelectParam("travm", "Тяжелая травматизация (кишечная непроходимость, резекция желудка)")
        );
    }
}

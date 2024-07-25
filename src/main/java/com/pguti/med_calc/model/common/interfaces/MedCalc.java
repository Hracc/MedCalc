package com.pguti.med_calc.model.common.interfaces;

import com.pguti.med_calc.model.common.params.NumbParam;
import com.pguti.med_calc.model.common.params.InfoParam;
import com.pguti.med_calc.model.common.params.InfoResult;
import com.pguti.med_calc.model.common.params.SelectParam;

import java.util.List;
import java.util.Map;

/* Обязательный интерфейс для создания калькулятора.
 Пример реализации Калькулятора находится в MedCalcExample
 Методы в которых ничего не нужно указывать вводите return Map.of() / List.of()*/

public interface MedCalc {

    // Значение для url
    String getId();

    //    Название калькулятор
    String getName();

    //    Описание
    String getInfo();

    //    Возвращает результат(ы). Требуется использовать MedCalcUtils.create() методы
    //    для создания значений, который должны быть отправлены через params
    Map<String, Object> calculate(Map<String, Object> params);

    //  Далнейшие методы настраивают страницу с калькулятором

    // Список для создания вводных элементов значений на сайте
    // В InfoParam.type используйте MedCalcUtils.getParamType() методы
    List<InfoParam> getInfoParams();

    //Вывод результатов на сайте
    List<InfoResult> getInfoResult();

    //Настройка необязательных значений и их начальное значение
    Map<String, Double> getNotRequireNumbs();

    //Настройка шага, минимального и макс числовых значений
    List<NumbParam> getNumberParams();

    //Варианты ответов для элементов с выбором нескольких ответов
    List<SelectParam> getListParam();
}
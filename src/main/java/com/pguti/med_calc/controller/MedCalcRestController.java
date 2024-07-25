package com.pguti.med_calc.controller;

import com.pguti.med_calc.model.common.params.InfoParam;
import com.pguti.med_calc.model.common.params.SelectParam;
import com.pguti.med_calc.service.MedCalcService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calculator")
@Tag(name = "Rest-Controller Для проекта", description = "/{calc}/info и /{calc}/result для задания, обрабатывавшие в фронт части через JQuery")
public class MedCalcRestController {
    private final MedCalcService medCalcService;

    @Autowired
    public MedCalcRestController(MedCalcService medCalcService) {
        this.medCalcService = medCalcService;
    }

    @Operation(summary = "Список калькуляторов", description = "Вывод айди калькулятора и его название")
    @GetMapping("/list")
    public Map<String, String> getCalcList() {
        return medCalcService.getCalcList();
    }

    @Operation(summary = "Параметры калькулятора", description = "Вывод параметров калькуляторов которые нужно в result в JSON формате")
    @GetMapping("/{calc}/params")
    public ResponseEntity<List<InfoParam>> getInfoParams(@PathVariable String calc) {
        List<InfoParam> calcInfo = medCalcService.getInfoParams(calc);
        return ResponseEntity.ok(calcInfo);
    }

    @Operation(summary = "Варианты ответа для значения", description = "Варианты ответов для значений с типом String")
    @GetMapping("/{calc}/Listparams")
    public ResponseEntity<List<SelectParam>> getSelectParams(@PathVariable String calc) {
        List<SelectParam> calcInfo = medCalcService.getSelectParams(calc);
        return ResponseEntity.ok(calcInfo);
    }

    @Operation(summary = "Информация о калькуляторе", description = "Описание о чем калькулятор")
    @GetMapping("/{calc}/info")
    public ResponseEntity<Map<String, String>> getInfo(@PathVariable String calc) {
        Map<String, String> calcInfo = medCalcService.getCalcInfo(calc);
        return ResponseEntity.ok(calcInfo);
    }

    @Operation(summary = "Расчет калькулятора", description = "Получение ответа от калькулятора")
    @PostMapping("/{calc}/result")
    public ResponseEntity<Map<String, Object>> getResult(@PathVariable String calc, @RequestBody Map<String, Object> params) {
        Map<String, Object> result = medCalcService.getResult(calc, params);
        return ResponseEntity.ok(result);
    }
}
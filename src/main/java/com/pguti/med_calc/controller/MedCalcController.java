package com.pguti.med_calc.controller;

import com.pguti.med_calc.model.common.interfaces.MedCalc;
import com.pguti.med_calc.service.MedCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MedCalcController {
    private final MedCalcService medCalcService;

    @Autowired
    public MedCalcController(MedCalcService medCalcService) {
        this.medCalcService = medCalcService;
    }

    //  Отображение списка калькуляторов
    @GetMapping("/")
    public String getCalcList(Model model){
        model.addAttribute("medCalcList", medCalcService.getCalcList());
        return "medCalcList";
    }

    //  Отображение конкретного калькулятора по ключу
    @GetMapping("/calculator/{calc}")
    public String getMedCalc(@PathVariable String calc, Model model) {
        MedCalc medCalc = medCalcService.getCalcById(calc);
        if (medCalc != null && medCalc.getId().equals(calc)) {
            model.addAttribute("medCalc", medCalc);
            model.addAttribute("data", calc);
        } else {
            model.addAttribute("alert", "нету такого");
        }
        return "medCalc";
    }
}

package com.pguti.med_calc.controller;

import com.pguti.med_calc.calcs.MedCalc;
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
    @GetMapping("/")
    public String getCalcList(Model model){
        model.addAttribute("medCalcList",medCalcService.getCalcList());
        return "medCalcList";
    }

    @GetMapping("/{calc}")
    public String getMedCalc(@PathVariable String calc, Model model){
        MedCalc medCalc= medCalcService.getCalcById(calc);
        if(medCalc != null && medCalc.getId().equals(calc)){
            model.addAttribute("calc",medCalc);
            model.addAttribute("data", calc);
            model.addAttribute("info", medCalc.getInfoParams());
        } else {
            model.addAttribute("alert", "нету такого");
        }
        return "medCalc";
    }
}

package com.pguti.med_calc.controller;

import com.pguti.med_calc.service.MedCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class MedCalcController {
    @Autowired
    private MedCalcService medCalcService;


    @GetMapping("/")
    public String showCalcList(Model model){
        model.addAttribute("calcList", medCalcService.getCalcList());
        return "medCalcList";
    }
}

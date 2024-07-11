package com.pguti.med_calc.controller;

import com.pguti.med_calc.service.MedCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Controller
public class MedCalcController {


    @GetMapping("/")
    public String showCalcList(Model model){
        model.addAttribute("calcList", "");
        return "medCalcList";
    }

    @GetMapping("/{id}")
    public String showCalc(@PathVariable String id, Model model){
        model.addAttribute("calcList", "");

        return "medCalc";
    }
}

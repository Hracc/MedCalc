package com.pguti.med_calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedCalcController {
    @GetMapping("/bruh")
    public String getCalcList(){
        return "calcList";
    }
}

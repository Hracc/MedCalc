package com.pguti.med_calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedCalcController {
<<<<<<< HEAD
    @GetMapping("/")
    public String getMain(){
        return "index";
=======
    @Autowired
    private MedCalcService medCalcService;


    @GetMapping("/")
    public String showCalcList(Model model){
        model.addAttribute("calcList", medCalcService.getCalcList());
        return "medCalcList";
    }

    @GetMapping("/{id}")
    public String showCalc(@PathVariable String id, Model model){
        model.addAttribute("calcList", medCalcService.getCalcById(id));

        return "medCalc";
>>>>>>> parent of 8341e20 (попытки что то сделать)
    }
}

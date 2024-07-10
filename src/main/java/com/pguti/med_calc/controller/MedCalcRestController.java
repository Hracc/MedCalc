package com.pguti.med_calc.controller;

import com.pguti.med_calc.service.MedCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class MedCalcRestController {

    @Autowired
    private MedCalcService medCalcService;
    @GetMapping("/calculator/{calc}/info")
    public Map<String, String> getInfo(@PathVariable String calc){
        return medCalcService.getCalcInfo(calc);
    }
    @PostMapping("/calculator/{calc}/result")
    public Map<String, Object> getResult(@PathVariable String calc, @RequestBody Map<String, Object> params){
        Map<String, Object> response = new HashMap<>();
        try{
            return medCalcService.getResult(calc, params);
        } catch (IllegalArgumentException e) {
            return Map.of("error", "Invalid calculator name or parameters: " + e.getMessage());
        } catch (Exception e) {
            return Map.of("error", "An unexpected error occurred: " + e.getMessage());
        }
    }
}

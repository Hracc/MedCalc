package com.pguti.med_calc.controller;

import com.pguti.med_calc.service.MedCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/calculator")
public class MedCalcRestController {
    private final MedCalcService medCalcService;
    @Autowired
<<<<<<< HEAD
    public MedCalcRestController(MedCalcService medCalcService) {
        this.medCalcService = medCalcService;
    }
    @GetMapping("/list")
    public Map<String, String> getCalcList() {
        return medCalcService.getCalcList();
    }

    @GetMapping("/{calc}/info")
    public ResponseEntity<Map<String, String>> getInfo(@PathVariable String calc) {
        Map<String, String> calcInfo = medCalcService.getCalcInfo(calc);
        return ResponseEntity.ok(calcInfo);
=======
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
>>>>>>> parent of 8341e20 (попытки что то сделать)
    }

    @PostMapping("/{calc}/result")
    public ResponseEntity<Map<String, Object>> getResult(@PathVariable String calc, @RequestBody Map<String, Object> params) {
        Map<String, Object> result = medCalcService.getResult(calc, params);
        return ResponseEntity.ok(result);
    }
}
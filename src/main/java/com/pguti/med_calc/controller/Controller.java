package com.pguti.med_calc.controller;

import com.pguti.med_calc.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private Service calcService;
    @GetMapping("/{calc}")
    public Map<String, String> getInfo(@PathVariable String calc){
        return calcService.getCalcList().get(calc).getInfo();
    }
}

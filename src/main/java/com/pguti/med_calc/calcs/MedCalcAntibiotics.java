package com.pguti.med_calc.calcs;

import java.util.Map;

public class MedCalcAntibiotics implements MedCalc{
    @Override
    public String getId() {
        return "Antibiotics";
    }

    @Override
    public String getName() {
        return "Антибиотики";
    }

    @Override
    public String getInfo() {
        return "решает что то";
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> params) {
        return Map.of();
    }
}

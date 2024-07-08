package com.pguti.med_calc.calcs;

import java.util.Map;

public interface Calculator {
    String getInfo();
    Map<String, Object> calculate(Map<String, Object> params);
}

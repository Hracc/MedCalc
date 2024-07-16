package com.pguti.med_calc.calcs;

public class MedCalcParamsList {
    private String paramKey;
    private String paramName;
    private String paramType;

    public MedCalcParamsList(String paramKey, String paramName, String paramType) {
        this.paramKey = paramKey;
        this.paramName = paramName;
        this.paramType = paramType;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }
}

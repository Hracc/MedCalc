package com.pguti.med_calc.calcs;

public class MedCalcParamsList {
    private String key;
    private String name;
    private String type;
    private boolean required;

    public MedCalcParamsList(String key, String name, String type, boolean required) {
        this.key = key;
        this.name = name;
        this.type = type;
        this.required = required;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
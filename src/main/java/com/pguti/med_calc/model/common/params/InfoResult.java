package com.pguti.med_calc.model.common.params;

public class InfoResult {
    private String key;
    private String descr;

    public InfoResult(String key, String descr) {
        this.key = key;
        this.descr = descr;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}

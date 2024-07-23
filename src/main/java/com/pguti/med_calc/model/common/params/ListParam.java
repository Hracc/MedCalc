package com.pguti.med_calc.model.common.params;

public class ListParam {
    private String key;
    private String descr;
    private String type;

    public ListParam(String key, String descr, String type) {
        this.key = key;
        this.descr = descr;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
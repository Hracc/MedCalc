package com.pguti.med_calc.model.common.params;

public class NumbParam {
    private String key;
    private double step;
    private int min;
    private int max;

    public NumbParam(String key, double step, int min, int max) {
        this.key = key;
        this.step = step;
        this.min = min;
        this.max = max;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}

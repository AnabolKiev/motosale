package com.anabol.motosearch.dto;

import java.util.Set;
import java.util.TreeSet;

public class BikeModelDto {

    public String manufacturerName;

    public String modelName;

    public Set<Integer> years = new TreeSet<>();

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Set<Integer> getYears() {
        return years;
    }

    public void setYears(Set<Integer> years) {
        this.years = years;
    }
}

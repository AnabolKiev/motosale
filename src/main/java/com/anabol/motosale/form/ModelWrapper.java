package com.anabol.motosale.form;

import java.util.Set;
import java.util.TreeSet;

public class ModelWrapper {

    private String name;

    private Set<Integer> years = new TreeSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getYears() {
        return years;
    }

    public void setYears(Set<Integer> years) {
        this.years = years;
    }
}

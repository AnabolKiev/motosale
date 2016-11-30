package com.anabol.motosale.model;

import javax.persistence.*;
@Entity
@Table(name = "model_hold_bikez")
public class ModelDownload {
    @Id
    @Column(name = "Url")
    private String url;
    @Column(name = "Manufacturer")
    private String manufacturer;
    @Column(name = "ModelName")
    private String modelName;
    @Column(name = "ModelYear")
    private String modelYear;
    @Column(name = "AttrCount")
    private int attrCount;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public int getAttrCount() {
        return attrCount;
    }

    public void setAttrCount(int attrCount) {
        this.attrCount = attrCount;
    }
}

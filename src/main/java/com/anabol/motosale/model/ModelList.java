package com.anabol.motosale.model;

import javax.persistence.*;

@Entity
@Table(name = "modelList")
public class ModelList {
    @Id
    @Column(name = "URL")
    private String url;
    @Column(name = "MANUFACTURER")
    private String manufacturer;

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
}


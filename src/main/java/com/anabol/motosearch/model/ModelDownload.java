package com.anabol.motosearch.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
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
    @Column(name = "AttrCount")
    private int attrCount;
}

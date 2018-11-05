package com.anabol.motosearch.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "modelAttribute_hold_bikez")
public class ModelAttributeDownload {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Long id;
    @Column(name = "Url", nullable = false)
    private String url;
    @Column(name = "AttrName")
    private String attrName;
    @Column(name = "AttrValue")
    private String attrValue;
}


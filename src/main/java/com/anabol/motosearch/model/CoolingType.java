package com.anabol.motosearch.model;

import javax.persistence.*;

@Entity
@Table(name = "CoolingType")
public class CoolingType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Long id;
    @Column(name = "NAME", unique = true, nullable = false, length = 15)
    private String name;
    @Column(name = "NAMEENG", unique = true, nullable = false, length = 15)
    private String nameEng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }
}

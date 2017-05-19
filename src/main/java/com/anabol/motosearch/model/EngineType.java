package com.anabol.motosearch.model;

import javax.persistence.*;

@Entity
@Table(name = "EngineType")
public class EngineType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Long id;
    @Column(name = "NAME", unique = true, nullable = false, length = 50)
    private String name;
    @Column(name = "SHORTNAME", nullable = false, length = 50)
    private String shortName;
    @Column(name = "NAMEENG", unique = true, nullable = false, length = 50)
    private String nameEng;
    @Column(name = "GROUPNAME", nullable = false, length = 50)
    private String groupName;
    @Column(name = "GROUPORDER")
    private Integer groupOrder;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(Integer groupOrder) {
        this.groupOrder = groupOrder;
    }
}

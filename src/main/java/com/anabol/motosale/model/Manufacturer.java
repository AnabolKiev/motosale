package com.anabol.motosale.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Long id;
    @Column(name = "NAME", nullable = false, length = 30)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
    private Set<Ad> ads = new HashSet<Ad>(0);

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

    public Set<Ad> getAds() {
        return this.ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }
}

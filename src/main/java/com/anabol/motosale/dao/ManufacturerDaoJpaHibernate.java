package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.ManufacturerRepository;
import com.anabol.motosale.model.Manufacturer;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class ManufacturerDaoJpaHibernate implements ManufacturerDao{

    @PersistenceContext(unitName = "MotoSaleJPA")
    private EntityManager em;

    public List<Manufacturer> getAllManufacturers() {
            List<Manufacturer> manufacturers = em.createQuery("FROM Manufacturer").getResultList();
        return manufacturers;
    }

    public Manufacturer findManufacturerById(Long id) {
            Manufacturer manufacturer = em.find(Manufacturer.class, id);
        return manufacturer;
    }

    public void insertManufacturer(Manufacturer manufacturer) {
        em.persist(manufacturer);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        Manufacturer existingManufacturer = findManufacturerById(manufacturer.getId());
        existingManufacturer.setName(manufacturer.getName());
    }

    public void deleteById(Long id) {
        em.remove(findManufacturerById(id));
    }









}

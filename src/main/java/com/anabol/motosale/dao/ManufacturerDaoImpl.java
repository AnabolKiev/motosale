package com.anabol.motosale.dao;

import com.anabol.motosale.model.Manufacturer;
import java.util.*;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao{

    @PersistenceUnit(unitName = "MotoSaleJPA")
    private EntityManagerFactory emf;

    public List<Manufacturer> getAllManufacturers() {
            EntityManager em = emf.createEntityManager();
            List<Manufacturer> manufacturers = em.createQuery("FROM Manufacturer").getResultList();
        return manufacturers;
    }

    public Manufacturer findManufacturerById(Long id) {
            EntityManager em = emf.createEntityManager();
            Manufacturer manufacturer = em.find(Manufacturer.class, id);
        return manufacturer;
    }

    public void insertManufacturer(Manufacturer manufacturer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(manufacturer);
        em.getTransaction().commit();
        em.close();
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        EntityManager em = emf.createEntityManager();
        Manufacturer existingManufacturer = em.getReference(Manufacturer.class, manufacturer.getId());
        existingManufacturer.setName(manufacturer.getName());
        em.getTransaction().begin();
        em.merge(existingManufacturer);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Manufacturer.class, id));
        em.getTransaction().commit();
        em.close();
    }









}

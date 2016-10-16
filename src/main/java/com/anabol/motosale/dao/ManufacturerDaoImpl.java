package com.anabol.motosale.dao;

import com.anabol.motosale.model.Manufacturer;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Manufacturer> getAllManufacturers() {
        Session session = sessionFactory.getCurrentSession();
        List<Manufacturer> manufacturers = session.createQuery("FROM Manufacturer ").list();
        return manufacturers;
    }

    public Manufacturer findManufacturerById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Manufacturer manufacturer = (Manufacturer)session.get(Manufacturer.class, id);
        return manufacturer;
    }

    public void insertManufacturer(Manufacturer manufacturer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(manufacturer);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        Session session = sessionFactory.getCurrentSession();
        Manufacturer existingManufacturer = findManufacturerById(manufacturer.getId());
        existingManufacturer.setName(manufacturer.getName());
        session.save(existingManufacturer);
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(findManufacturerById(id));
    }









}

package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.ManufacturerRepository;
import com.anabol.motosale.model.Manufacturer;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao{

    @Autowired
    ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        Iterator<Manufacturer> i = manufacturerRepository.findAll().iterator();
        while (i.hasNext()) {
            manufacturers.add(i.next());
        }
        return manufacturers;
    }

    public Manufacturer findManufacturerById(Long id) {
            Manufacturer manufacturer = manufacturerRepository.findOne(id);
        return manufacturer;
    }

    public void insertManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void deleteById(Long id) {
        manufacturerRepository.delete(id);
    }

}
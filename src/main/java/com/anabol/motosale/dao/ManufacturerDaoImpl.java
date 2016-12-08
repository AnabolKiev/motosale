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

    public List<Manufacturer> getAll() {
        List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        Iterator<Manufacturer> i = manufacturerRepository.findAll().iterator();
        while (i.hasNext()) {
            manufacturers.add(i.next());
        }
        return manufacturers;
    }

    public Manufacturer findById(Long id) {
            Manufacturer manufacturer = manufacturerRepository.findOne(id);
        return manufacturer;
    }

    public void insert(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void update(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void deleteById(Long id) {
        manufacturerRepository.delete(id);
    }

    public void setActiveAll(boolean active) {
        manufacturerRepository.setActiveAll(active);
    }

    public void setActiveByIds(boolean active, Long[] ids) {
        manufacturerRepository.setActiveByIDs(active, ids);
    }
}
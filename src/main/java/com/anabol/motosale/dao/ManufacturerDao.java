package com.anabol.motosale.dao;

import com.anabol.motosale.model.Manufacturer;
import java.util.*;

public interface ManufacturerDao {
    public List<Manufacturer> getAllManufacturers();
    public Manufacturer findManufacturerById(Long id);
    public void insertManufacturer(Manufacturer manufacturer);
    public void updateManufacturer(Manufacturer manufacturer);
    public void deleteById(Long id);
}

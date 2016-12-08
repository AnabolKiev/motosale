package com.anabol.motosale.dao;

import com.anabol.motosale.model.Manufacturer;
import java.util.*;

public interface ManufacturerDao {
    public List<Manufacturer> getAll();
    public Manufacturer findById(Long id);
    public void insert(Manufacturer manufacturer);
    public void update(Manufacturer manufacturer);
    public void deleteById(Long id);
    public void setActiveAll(boolean active);
    public void setActiveByIds(boolean active, Long[] ids);
}

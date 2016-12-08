package com.anabol.motosale.dao;

import com.anabol.motosale.model.CoolingType;
import java.util.*;

public interface CoolingTypeDao {
    public List<CoolingType> getAll();
    public CoolingType findById(Long id);
    public void insert(CoolingType coolinType);
    public void update(CoolingType coolingType);
    public void deleteById(Long id);
}

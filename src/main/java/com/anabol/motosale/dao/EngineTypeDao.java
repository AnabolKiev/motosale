package com.anabol.motosale.dao;

import com.anabol.motosale.model.EngineType;
import java.util.*;

public interface EngineTypeDao {
    public List<EngineType> getAll();
    public EngineType findById(Long id);
    public void insert(EngineType engineType);
    public void update(EngineType engineType);
    public void deleteById(Long id);
}
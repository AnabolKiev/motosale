package com.anabol.motosale.dao;

import com.anabol.motosale.model.StarterType;
import java.util.*;

public interface StarterTypeDao {
    public List<StarterType> getAll();
    public StarterType findById(Long id);
    public void insert(StarterType starterType);
    public void update(StarterType starterType);
    public void deleteById(Long id);
}

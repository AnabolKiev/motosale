package com.anabol.motosale.dao;

import com.anabol.motosale.model.FinalDriveType;
import java.util.*;

public interface FinalDriveTypeDao {
    public List<FinalDriveType> getAll();
    public FinalDriveType findById(Long id);
    public void insert(FinalDriveType finalDriveType);
    public void update(FinalDriveType finalDriveType);
    public void deleteById(Long id);
}

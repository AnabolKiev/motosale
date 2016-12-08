package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.FinalDriveTypeRepository;
import com.anabol.motosale.model.FinalDriveType;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FinalDriveTypeDaoImpl implements FinalDriveTypeDao{

    @Autowired
    FinalDriveTypeRepository finalDriveTypeRepository;

    public List<FinalDriveType> getAll() {
        List<FinalDriveType> finalDriveTypes = new ArrayList<FinalDriveType>();
        Iterator<FinalDriveType> i = finalDriveTypeRepository.findAll().iterator();
        while (i.hasNext()) {
            finalDriveTypes.add(i.next());
        }
        return finalDriveTypes;
    }

    public FinalDriveType findById(Long id) {
        FinalDriveType finalDriveType = finalDriveTypeRepository.findOne(id);
        return finalDriveType;
    }

    public void insert(FinalDriveType finalDriveType) {
        finalDriveTypeRepository.save(finalDriveType);
    }

    public void update(FinalDriveType finalDriveType) {
        finalDriveTypeRepository.save(finalDriveType);
    }

    public void deleteById(Long id) {
        finalDriveTypeRepository.delete(id);
    }

}
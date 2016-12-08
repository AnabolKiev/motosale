package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.CoolingTypeRepository;
import com.anabol.motosale.model.CoolingType;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoolingTypeDaoImpl implements CoolingTypeDao{

    @Autowired
    CoolingTypeRepository coolingTypeRepository;

    public List<CoolingType> getAll() {
        List<CoolingType> coolingTypes = new ArrayList<CoolingType>();
        Iterator<CoolingType> i = coolingTypeRepository.findAll().iterator();
        while (i.hasNext()) {
            coolingTypes.add(i.next());
        }
        return coolingTypes;
    }

    public CoolingType findById(Long id) {
        CoolingType coolingType = coolingTypeRepository.findOne(id);
        return coolingType;
    }

    public void insert(CoolingType coolingType) {
        coolingTypeRepository.save(coolingType);
    }

    public void update(CoolingType coolingType) {
        coolingTypeRepository.save(coolingType);
    }

    public void deleteById(Long id) {
        coolingTypeRepository.delete(id);
    }

}
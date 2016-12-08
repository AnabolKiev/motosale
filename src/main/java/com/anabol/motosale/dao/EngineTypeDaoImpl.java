package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.EngineTypeRepository;
import com.anabol.motosale.model.EngineType;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EngineTypeDaoImpl implements EngineTypeDao{

    @Autowired
    EngineTypeRepository engineTypeRepository;

    public List<EngineType> getAll() {
        List<EngineType> engineTypes = new ArrayList<EngineType>();
        Iterator<EngineType> i = engineTypeRepository.findAll().iterator();
        while (i.hasNext()) {
            engineTypes.add(i.next());
        }
        return engineTypes;
    }

    public EngineType findById(Long id) {
        EngineType engineType = engineTypeRepository.findOne(id);
        return engineType;
    }

    public void insert(EngineType engineType) {
        engineTypeRepository.save(engineType);
    }

    public void update(EngineType engineType) {
        engineTypeRepository.save(engineType);
    }

    public void deleteById(Long id) {
        engineTypeRepository.delete(id);
    }

}
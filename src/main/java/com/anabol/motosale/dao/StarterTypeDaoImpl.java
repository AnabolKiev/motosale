package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.StarterTypeRepository;
import com.anabol.motosale.model.StarterType;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StarterTypeDaoImpl implements StarterTypeDao{

    @Autowired
    StarterTypeRepository starterTypeRepository;

    public List<StarterType> getAll() {
        List<StarterType> starterTypes = new ArrayList<StarterType>();
        Iterator<StarterType> i = starterTypeRepository.findAll().iterator();
        while (i.hasNext()) {
            starterTypes.add(i.next());
        }
        return starterTypes;
    }

    public StarterType findById(Long id) {
        StarterType starterType = starterTypeRepository.findOne(id);
        return starterType;
    }

    public void insert(StarterType starterType) {
        starterTypeRepository.save(starterType);
    }

    public void update(StarterType starterType) {
        starterTypeRepository.save(starterType);
    }

    public void deleteById(Long id) {
        starterTypeRepository.delete(id);
    }

}
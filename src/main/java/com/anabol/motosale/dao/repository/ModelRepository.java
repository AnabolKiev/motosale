package com.anabol.motosale.dao.repository;

import com.anabol.motosale.model.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Long>{
    List<Model> findByManufacturer_Id(Long id);
    List<Model> findByManufacturer_Name(String name);
}

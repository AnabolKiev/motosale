package com.anabol.motosearch.dao.repository;

import com.anabol.motosearch.model.EngineType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface EngineTypeRepository extends CrudRepository<EngineType, Long>{

    List<EngineType> findAllByOrderByGroupOrderAscEngineOrderAsc();

}


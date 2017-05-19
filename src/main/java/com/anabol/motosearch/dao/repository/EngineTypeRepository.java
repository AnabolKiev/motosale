package com.anabol.motosearch.dao.repository;

import com.anabol.motosearch.model.EngineType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EngineTypeRepository extends CrudRepository<EngineType, Long>{

    @Query(value = "SELECT DISTINCT et.GROUPNAME from EngineType et order by et.GROUPORDER asc", nativeQuery = true)
    String[] findDistinctGroupNameOrderByGroupNameAsc();

}


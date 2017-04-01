package com.anabol.motosearch.dao.repository;

import com.anabol.motosearch.model.BikeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ModelRepository extends CrudRepository<BikeModel, Long>, JpaSpecificationExecutor<BikeModel> {
    List<BikeModel> findByManufacturer_Id(Long id);
    List<BikeModel> findByManufacturer_IdAndManufacturer_ActiveTrue(Long id);
    BikeModel findByManufacturer_IdAndNameAndYearAndManufacturer_ActiveTrue(Long manufacturerId, String modelName, Integer year);
    Page<BikeModel> findByCategory_IdAndManufacturer_ActiveTrue(Long id, Pageable pageable);
}

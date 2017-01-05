package com.anabol.motosale.dao.repository;

import com.anabol.motosale.model.BikeModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<BikeModel, Long>{
    List<BikeModel> findByManufacturer_Id(Long id);
    List<BikeModel> findByManufacturer_IdAndManufacturer_ActiveTrue(Long id);
    BikeModel findByManufacturer_IdAndNameAndYearAndManufacturer_ActiveTrue(Long manufacturerId, String modelName, Integer year);
}

package com.anabol.motosearch.service;

import com.anabol.motosearch.model.BikeModel;
import org.springframework.data.domain.Page;

import java.util.*;

public interface BikeModelService {
    void delete(Long modelId);
    BikeModel findOne(Long modelId);
    void save(BikeModel bikeModel);
    List<BikeModel> findByManufacturer(Long id);
    List<Object[]> findAggregatedByManufacturer(Long id);
    BikeModel findByKey(Long manufacturerId, String modelName, Integer year);
    Page<BikeModel> findByFilters(List<Long> manufacturers,
                                  List<Long> categories,
                                  List<Long> engineTypes,
                                  List<Long> finalDriveTypes,
                                  Integer yearFrom,
                                  Integer yearTo,
                                  Integer displacementFrom,
                                  Integer displacementTo,
                                  String searchText,
                                  Integer sizePerPage,
                                  Integer pageNumber);
    List<Object[]> findAggregatedByFilters(List<Long> manufacturers,
                                            List<Long> categories,
                                            List<Long> engineTypes,
                                            List<Long> finalDriveTypes,
                                            Integer yearFrom,
                                            Integer yearTo,
                                            Integer displacementFrom,
                                            Integer displacementTo,
                                            String searchText);
}

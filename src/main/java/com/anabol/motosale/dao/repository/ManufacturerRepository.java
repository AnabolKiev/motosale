package com.anabol.motosale.dao.repository;

import com.anabol.motosale.model.Manufacturer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    @Modifying
    @Query("UPDATE Manufacturer m SET m.active = :active")
    int setActiveAll(@Param("active") boolean active);

    @Modifying
    @Query("UPDATE Manufacturer m SET m.active = :active WHERE m.id in :manufacturerIDs")
    int setActiveByIDs(@Param("active") boolean active, @Param("manufacturerIDs") Long[] manufacturerIDs);

    List<Manufacturer> findByActiveTrue();
    Manufacturer findByNameAndActiveTrue(String name);

}
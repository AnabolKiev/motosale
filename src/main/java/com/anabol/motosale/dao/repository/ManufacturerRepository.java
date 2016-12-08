package com.anabol.motosale.dao.repository;

import com.anabol.motosale.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Manufacturer m SET m.active = :active")
    int setActiveAll(@Param("active") boolean active);

    @Modifying
    @Transactional
    @Query("UPDATE Manufacturer m SET m.active = :active WHERE m.id in :manufacturerIDs")
    int setActiveByIDs(@Param("active") boolean active, @Param("manufacturerIDs") Long[] manufacturerIDs);
}
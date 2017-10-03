package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.CarrierToVersion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Repository for CarrierToVersion
 */
@CrossOrigin
public interface CarrierToVersionRepository extends Repository<CarrierToVersion, Integer> {
    CarrierToVersion getCarrierToVersionById(Integer id);

    @Query("SELECT ss from CarrierToVersion ss WHERE ss.carrierCode = :carrierCode")
    List<CarrierToVersion> getCarrierToVersionByName(@Param("carrierCode") String storeServer);
}

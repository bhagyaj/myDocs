package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.EventCompliance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Event Compliance Repository
 */

public interface EventCompliancesRepository extends Repository<EventCompliance, Integer> {

    @Query("SELECT ec FROM EventCompliance ec WHERE ec.loBSubscription.sStoreBrand.carrierToVersion.cSettings.id=:version")
    List<EventCompliance> getEventComplianceByVersion(@Param("version") Integer version);


}

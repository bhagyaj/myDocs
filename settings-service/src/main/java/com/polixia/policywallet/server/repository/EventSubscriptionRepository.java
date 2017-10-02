package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.EventSubscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository class for FieldDef
 */
public interface EventSubscriptionRepository extends Repository<EventSubscription, Integer> {

    @Query("SELECT es FROM EventSubscription es WHERE es.sLoBSubscription.sStoreBrand.sStoreServer.cSettings.id > :version")
    List<Object> getCEventSubscriptionByVersionId(@Param("version") Integer id);
}

package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.EventTypeDef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository class for FieldDef
 */
public interface EventTypeDefRepository extends Repository<EventTypeDef, Integer> {

    @Query("SELECT ed FROM EventTypeDef ed WHERE ed.questionaireType.carrierToVersion.cSettings.id > :version")
    List<Object> getCEventTypeDefByVersionId(@Param("version") Integer id);

    EventTypeDef save(EventTypeDef eventTypeDef);

    List<EventTypeDef> findAll();

    EventTypeDef getEventTypeDefinitionById(Integer id);

}

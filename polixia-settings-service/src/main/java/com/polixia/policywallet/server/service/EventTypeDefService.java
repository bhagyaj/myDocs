package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.EventTypeDef;

import java.util.List;

/**
 * Repository class for FieldDef
 */
public interface EventTypeDefService {

    List<Object> getCEventTypeDefByVersionId(Integer id);

    EventTypeDef upsertEventTypeDefinition(EventTypeDef eventTypeDef);

    List<EventTypeDef> getEventTypeDefinitions();

    EventTypeDef getEventTypeDefinitionById(Integer id);

}

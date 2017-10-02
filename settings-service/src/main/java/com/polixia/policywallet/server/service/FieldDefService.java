package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.FieldDef;

import java.util.List;

/**
 * FieldDef Service
 */
public interface FieldDefService {

    FieldDef getCFieldDefById(Integer id);

    List<Object> getCFieldDefByVersionId(Integer version);

    List<FieldDef> getFieldDefinitions(Integer storeserver);

    FieldDef upsertFieldDefinition(FieldDef fieldDef);
}

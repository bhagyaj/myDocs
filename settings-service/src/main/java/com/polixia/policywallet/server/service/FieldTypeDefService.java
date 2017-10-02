package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.FieldTypeDef;

import java.util.List;

/**
 * FieldDef Service
 */
public interface FieldTypeDefService {

    List<Object> getCFieldTypeDefByVersionId(Integer version);
    FieldTypeDef upsertFieldTypeDef(FieldTypeDef fieldTypeDef);
    List<FieldTypeDef> getall();
    FieldTypeDef get(Integer id);
    List<FieldTypeDef> getFieldTypesByVersion(Integer version);
}

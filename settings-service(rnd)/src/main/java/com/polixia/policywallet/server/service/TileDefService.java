package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.EventTypeDef;
import com.polixia.policywallet.server.model.TileDef;

import java.util.List;

/**
 * Repository class for FieldDef
 */
public interface TileDefService {

    List<Object> getCTileDefByVersionId(Integer version);

    TileDef upsertTileDefinition(TileDef payload);

    List<TileDef> getTileDefinitions();

    TileDef getTileDefinitionById(Integer id);
}

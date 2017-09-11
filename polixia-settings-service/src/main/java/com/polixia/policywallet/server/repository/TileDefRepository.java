package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.EventTypeDef;
import com.polixia.policywallet.server.model.TileDef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository class for FieldDef
 */
public interface TileDefRepository extends Repository<TileDef, Integer> {

    @Query("SELECT td FROM TileDef td WHERE td.setting.id > :version")
    List<Object> getCTileDefVersionId(@Param("version") Integer version);

    TileDef save(TileDef payload);

    List<TileDef> findAll();

    TileDef getTileDefinitionById(Integer id);
}

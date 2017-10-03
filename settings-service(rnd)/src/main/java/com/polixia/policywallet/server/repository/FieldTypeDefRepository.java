package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.FieldTypeDef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository class for FieldDef
 */
public interface FieldTypeDefRepository extends Repository<FieldTypeDef, Integer> {

    @Query("SELECT td FROM FieldTypeDef td WHERE td.cSettings.id > :version")
    List<Object> getCFieldTypeDefByVersionId(@Param("version") Integer version);

    FieldTypeDef save(FieldTypeDef fieldTypeDef);

    List<FieldTypeDef> findAll();

    FieldTypeDef getFieldTypeDefById(Integer id);

    @Query("SELECT td FROM FieldTypeDef td WHERE td.cSettings.id = :version")
    List<FieldTypeDef> findByVersion(@Param("version") Integer version);
}

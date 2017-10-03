package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.FieldDef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Field Definition Repository
 */
public interface FieldDefRepository extends Repository<FieldDef, Integer> {

    FieldDef getCFieldDefById(Integer id);

    @Query("SELECT fd FROM FieldDef fd WHERE fd.carrierToVersion.cSettings.id > :version")
    List<Object> getCFieldDefByVersionId(@Param("version") Integer version);

    @Query("SELECT fd FROM FieldDef fd WHERE fd.carrierToVersion.id=:carrierToVersion")
    List<FieldDef> findByStoreServer(@Param("carrierToVersion") Integer carrierToVersion);

    FieldDef save(FieldDef fieldDef);
}

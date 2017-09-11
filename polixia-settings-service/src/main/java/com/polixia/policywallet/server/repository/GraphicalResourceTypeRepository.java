package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.GraphicalResourcesType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by brupasinghe on 8/28/2017.
 */
public interface GraphicalResourceTypeRepository extends Repository<GraphicalResourcesType, Integer> {

    @Query("SELECT t FROM GraphicalResourcesType t WHERE t.cSettings.id > :versionId")
    List<Object> getCGraphicalResourceTypeById(@Param("versionId") Integer versionId);
}

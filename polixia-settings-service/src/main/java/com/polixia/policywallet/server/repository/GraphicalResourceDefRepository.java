package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.GraphicalResourceDef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by brupasinghe on 8/28/2017.
 */
public interface GraphicalResourceDefRepository extends Repository<GraphicalResourceDef, Integer> {

    @Query("SELECT g FROM GraphicalResourceDef g WHERE g.cGraphicalResourcesType.cSettings.id > :version")
    List<Object> getCGraphicalResourceDefId(@Param("version") Integer version);
}

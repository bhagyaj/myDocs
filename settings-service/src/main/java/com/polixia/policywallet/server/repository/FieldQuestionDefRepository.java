package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.FieldQuestionDef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Jeyanthasingam on 9/12/2017.
 */
public interface FieldQuestionDefRepository extends Repository<FieldQuestionDef,Integer> {
    @Query("SELECT fqd FROM FieldQuestionDef fqd WHERE fqd.cFieldDef.carrierToVersion.cSettings.id>:version")
    List<Object> getFieldDefByVersion(@Param("version") Integer version);
}

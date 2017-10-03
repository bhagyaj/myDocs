package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.Compliance;
import com.polixia.policywallet.server.model.ComplianceRule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository class for ComplianceRule
 */
public interface ComplianceRuleRepository extends Repository<ComplianceRule, Integer> {
    ComplianceRule getComplianceRuleById(Integer Id);

    @Query("SELECT cr FROM ComplianceRule cr where cr.sStoreServer.cSettings.id=:version")
    List<ComplianceRule> getComplianceRulesByVersion(@Param("version") Integer version);


    @Query("SELECT cr FROM ComplianceRule cr WHERE cr.sStoreServer.id=:storeserver")
    List<ComplianceRule> findBystoreserver(@Param("storeserver") Integer storeserver);

    List<ComplianceRule> getComplianceRulesBytimestampGreaterThan(long timestamp);
}

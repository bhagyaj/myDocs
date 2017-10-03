package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.ComplianceRuleDef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Compliance Rule Definition repository
 */

public interface ComplianceRuleDefRepository extends Repository<ComplianceRuleDef, Integer> {
    @Query("SELECT crd FROM ComplianceRuleDef crd where crd.complianceRule.carrierToVersion.cSettings.id=:version")
    List<ComplianceRuleDef> getComplianceRuleDefByVersion(@Param("version") Integer version);

}

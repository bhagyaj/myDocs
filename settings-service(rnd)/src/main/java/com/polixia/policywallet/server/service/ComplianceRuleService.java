package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.Compliance;
import com.polixia.policywallet.server.model.ComplianceRule;

import java.util.List;

/**
 * Compliance Rule repository
 */
public interface ComplianceRuleService{
    ComplianceRule getComplianceRuleById(Integer Id);
    List<ComplianceRule> getComplianceRulesBytimestampGreaterThan(long timestamp);

    List<ComplianceRule> getAllCompliances(Integer storeserver);
}

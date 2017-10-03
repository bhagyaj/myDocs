package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.ComplianceRuleDef;

import java.util.List;

public interface ComplianceRuleDefService {
    List<ComplianceRuleDef> getComplianceRuleDefByVersion(Integer version);
}

package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.model.Compliance;
import com.polixia.policywallet.server.model.ComplianceRule;
import com.polixia.policywallet.server.repository.ComplianceRuleRepository;
import com.polixia.policywallet.server.service.ComplianceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ComplianceRule Service
 */

@Service
public class ComplianceRuleServiceImpl implements ComplianceRuleService {
    @Autowired
    ComplianceRuleRepository complianceRuleRepository;

    @Override
    public ComplianceRule getComplianceRuleById(Integer Id) {
        return complianceRuleRepository.getComplianceRuleById(Id);
    }

    @Override
    public List<ComplianceRule> getComplianceRulesByVersion(Integer version) {
        return complianceRuleRepository.getComplianceRulesByVersion(version);
    }

    @Override
    public List<ComplianceRule> getAllCompliances(Integer storeserver) {
        return complianceRuleRepository.findBystoreserver(storeserver);
    }
}
